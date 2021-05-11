package com.atm.atmproject.successfulresponse;

import com.fasterxml.jackson.annotation.JsonInclude;

<<<<<<< HEAD:src/main/java/com/atm/atmproject/models/SuccessfulResponseObject.java
import java.util.Optional;
=======
>>>>>>> 0d93ce16b94fa4f8d1b50594e63b3aaabf3843b1:src/main/java/com/atm/atmproject/successfulresponse/SuccessfulResponseObject.java
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessfulResponseObject {
    private int code;
    private String message;
    private Object data;

    public SuccessfulResponseObject(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
