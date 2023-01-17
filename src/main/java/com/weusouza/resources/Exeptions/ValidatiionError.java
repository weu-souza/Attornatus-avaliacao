package com.weusouza.resources.Exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidatiionError extends StandardError{
    private List<FieldMessage> erros = new ArrayList<>();
    public ValidatiionError(long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public ValidatiionError() {

    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String fieldName,String message) {
        this.erros.add(new FieldMessage(fieldName,message));
    }
}
