package com.weusouza.resources.Exeptions;

public class FieldMessage {
    private String fieldName;
    private String name;

    public FieldMessage() {
    }

    public FieldMessage(String fieldName, String name) {
        this.fieldName = fieldName;
        this.name = name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
