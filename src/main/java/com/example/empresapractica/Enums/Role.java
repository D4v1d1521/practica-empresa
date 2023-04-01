package com.example.empresapractica.Enums;

public enum Role {
    ADMIN("administrador"),
    OPERATOR("operario"),

    EMPLOYED("empleado"),
    LEADER("lider");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
