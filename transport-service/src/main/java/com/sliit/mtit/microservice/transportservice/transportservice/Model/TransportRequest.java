package com.sliit.mtit.microservice.transportservice.transportservice.Model;

public class TransportRequest {

    private String transportType; // transport type (local or out)
    private String transportMode; // transport mode (bus, van, ship and etc.)
    private double charges; // rate for the transport

    public TransportRequest() {
        super();
    }

    public TransportRequest(String transportType, String transportMode, double charges) {
        this.transportType = transportType;
        this.transportMode = transportMode;
        this.charges = charges;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "TransportRequest{" +
                "transportType='" + transportType + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", charges=" + charges +
                '}';
    }
}
