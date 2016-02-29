package com.demo.gxt_google_maps.shared;

import java.io.Serializable;

public class Transit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
    private String firstName;
    private String lastName;
    private String time;
    private String timePosition;
    private String timeServer;
    private Integer speed;
    private Integer height;
    private String model;
    private String number;
    private Integer distance;
    private String position;
    private Integer degree;
    private String vehicleType;
    private Boolean wifi;
    private HeadTransit object;

    public Transit(){}
    public Transit(Integer id, String name, String phone, String email, String firstName, String lastName, String time, String timePosition, String timeServer, Integer speed, Integer height, String model, String number, Integer distance, String position, Integer degree, String vehicleType, Boolean wifi) {
        super();

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.timePosition = timePosition;
        this.timeServer = timeServer;
        this.speed = speed;
        this.height = height;
        this.model = model;
        this.number = number;
        this.distance = distance;
        this.position = position;
        this.degree = degree;
        this.vehicleType = vehicleType;
        this.wifi = wifi;
        object = new HeadTransit(time, vehicleType);
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimePosition() {
        return timePosition;
    }

    public void setTimePosition(String timePosition) {
        this.timePosition = timePosition;
    }

    public String getTimeServer() {
        return timeServer;
    }

    public void setTimeServer(String timeServer) {
        this.timeServer = timeServer;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean isWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public HeadTransit getObject() {
        return object;
    }

    public void setObject(HeadTransit object) {
        this.object = object;
    }
}
