package com.itesm.azul;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.ArrayList;
import java.util.List;

public class ReadPersonHandler
        implements RequestHandler<PersonRequest, PersonList> {

    private static final DynamoDbEnhancedClient DDB_ENHANCED_CLIENT =
            DynamoDbEnhancedClient.create();
    private static final DynamoDbTable<NuevaPersona> PERSONA_TABLE =
            DDB_ENHANCED_CLIENT.table("NuevaPersona", TableSchema.fromBean(NuevaPersona.class));


    public PersonList handleRequest(
            PersonRequest personRequest, Context context) {
        Iterable<NuevaPersona> iterableNuevaPersona;
        List<NuevaPersona> regreso = new ArrayList<NuevaPersona>();

        iterableNuevaPersona = PERSONA_TABLE.scan().items();

        for (NuevaPersona p:iterableNuevaPersona)
        {
            regreso.add(p);
        }

        PersonList personResponse = new PersonList();
        personResponse.setLista(regreso);
        return personResponse;
    }



}
