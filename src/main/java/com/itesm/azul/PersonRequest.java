package com.itesm.azul;

public class PersonRequest {
    private String personaID;
    private String nombre;
    private String edad;
    private String timestamp;

    public String getPersonaID(){
        return personaID;
    }
    public void setPersonaID(String personaID) {
        this.personaID = personaID;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
