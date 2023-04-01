package com.example.empresapractica.Enums.Deserializable;


import com.example.empresapractica.Enums.State;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.IOException;

public class Deserialize extends JsonDeserializer<State> {
    @Override
    public State deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        int intValue = p.getValueAsInt();
        return State.fromInt(intValue);
    }
}