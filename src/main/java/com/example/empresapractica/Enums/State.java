package com.example.empresapractica.Enums;

public enum State {

    ACTIVE(1),
    INACTIVE(2),
    DELETED(3);

    private final int state;

    State(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public static State fromInt(int value) {
        for (State state : State.values()) {
            if (state.state == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid Status value: " + value);
    }
}
