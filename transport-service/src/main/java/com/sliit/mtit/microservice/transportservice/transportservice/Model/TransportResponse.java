package com.sliit.mtit.microservice.transportservice.transportservice.Model;

public class TransportResponse {

    private String id;
    private String message;

    public TransportResponse() {
        super();
    }

    public TransportResponse(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TransportResponse{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
