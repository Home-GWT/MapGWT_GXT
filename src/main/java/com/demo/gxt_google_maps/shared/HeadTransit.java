package com.demo.gxt_google_maps.shared;


public class HeadTransit {
    private String time;
    private String vehicleType;
    private String nameVehicleType;

    public HeadTransit(String time, String vehicleType){
        this.time = time;
        this.vehicleType = vehicleType;
        nameVehicleType = vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1); //vehicleType.toUpperCase();
    }

    public String getTime() {
        return time;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public String getNameVehicleType() {
        return nameVehicleType;
    }
}
