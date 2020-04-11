package com.sliit.mtit.microservice.shippingservice.Model;

public class ShippingRequest {

    private int orderId; // Order id from order service
    private String transportType; // Transport type can take either yes or no
    private int transportId; // Transport id from transport services
    private String address;

    public ShippingRequest() {
        super();
    }

    public ShippingRequest(int orderId, String transportType, int transportId, String address) {
        this.orderId = orderId;
        this.transportType = transportType;
        this.transportId = transportId;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ShippingRequest{" +
                "orderId=" + orderId +
                ", transportType='" + transportType + '\'' +
                ", transportId=" + transportId +
                ", address='" + address + '\'' +
                '}';
    }
}
