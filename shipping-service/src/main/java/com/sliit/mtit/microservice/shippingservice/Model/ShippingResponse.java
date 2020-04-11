package com.sliit.mtit.microservice.shippingservice.Model;

public class ShippingResponse {

    private String id;
    private String message;

    public ShippingResponse() {
        super();
    }

    public ShippingResponse(String id, String message) {
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
        return "ShippingResponse{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
