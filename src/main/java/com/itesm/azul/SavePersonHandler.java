package com.itesm.azul;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

public class SavePersonHandler
        implements RequestHandler<PersonRequest, PersonResponse> {

    private static final DynamoDbEnhancedClient DDB_ENHANCED_CLIENT =
            DynamoDbEnhancedClient.create();
    private static final DynamoDbTable<NuevaPersona> PERSONA_TABLE =
            DDB_ENHANCED_CLIENT.table("NuevaPersona", TableSchema.fromBean(NuevaPersona.class));


    public PersonResponse handleRequest(
            PersonRequest personRequest, Context context) {

        NuevaPersona p = new NuevaPersona();
        p.setPersonaID(personRequest.getPersonaID());
        p.setTimestamp(personRequest.getTimestamp());
        p.setEdad(personRequest.getEdad());
        p.setNombre(personRequest.getNombre());
        PERSONA_TABLE.putItem(p);


        PersonResponse personResponse = new PersonResponse();
        personResponse.setMessage("Saved Successfully!!!");
        return personResponse;
    }



}
