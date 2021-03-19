package com.test.rh.squaremobileproject.model;

public enum Employee_type {
    FULL_TIME("Full Time"),
    PART_TIME("Part Time"),
    CONTRACTOR("Contractor");

    private final String value;

    Employee_type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
