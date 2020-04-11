package com.sliit.mtit.microservice.transportservice.transportservice.Model;

public class Transport {

    private int trasportId; // unique id
    private String transportType; // transport type (local or out)
    private String transportMode; // transport mode (bus, van, ship and etc.)
    private double charges; // rate for the transport

    public Transport() {
        super();
    }

    public Transport(int trasportId, String transportType, String transportMode, double charges) {
        this.trasportId = trasportId;
        this.transportType = transportType;
        this.transportMode = transportMode;
        this.charges = charges;
    }

    public int getTrasportId() {
        return trasportId;
    }

    public void setTrasportId(int trasportId) {
        this.trasportId = trasportId;
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
        return "Transport{" +
                "trasportId=" + trasportId +
                ", transportType='" + transportType + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", charges=" + charges +
                '}';
    }
}
