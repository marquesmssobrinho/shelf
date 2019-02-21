package br.com.shelf.errors;

public class ErrorObject {

    private String message;

    private Object parameter;

    private String field;

    public ErrorObject(String message, Object parameter, String field) {
        this.message = message;
        this.parameter = parameter;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public Object getParameter() {
        return parameter;
    }

    public String getField() {
        return field;
    }
}
