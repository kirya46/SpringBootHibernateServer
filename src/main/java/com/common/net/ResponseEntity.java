package com.common.net;

import java.util.ArrayList;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */
public class ResponseEntity {
    private String body;int status;

    public ResponseEntity(String body, int status) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
