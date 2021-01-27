package com.choistec.blelist;

class Beacon {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getName() {
        return name;
    }

    public String getRawData() { return rawData; }

    public float getTemp() { return temp; }

    private String address;
    private int rssi;

    public void setName(String name) {
        this.name = name;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    private String now;
    private String name;
    private String rawData;
    private float temp;
    private int battery;

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public Beacon(String address, int rssi, String now, String name, String rawData, float temp, int battery) {
        this.address = address;
        this.rssi = rssi;
        this.now = now;
        this.name = name;
        this.rawData = rawData;
        this.temp = temp;
        this.battery = battery;
    }

}
