package com.sliit.mtit.microservice.shippingservice.Model;

public class Shipping {

    private int shippingId;
    private int orderId;
    private String transportType;
    private int transportId;
    private String address;

    public Shipping() {
        super();
    }

    public Shipping(int shippingId, int orderId, String transportType, int transportId, String address) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.transportType = transportType;
        this.transportId = transportId;
        this.address = address;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
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
        return "Shipping{" +
                "shippingId=" + shippingId +
                ", orderId=" + orderId +
                ", transportType='" + transportType + '\'' +
                ", transportId=" + transportId +
                ", address='" + address + '\'' +
                '}';
    }
}