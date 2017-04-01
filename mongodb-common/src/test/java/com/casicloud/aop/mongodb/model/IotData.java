package com.casicloud.aop.mongodb.model;

import java.io.Serializable;

public class IotData implements Serializable {
	private static final long serialVersionUID = 2754114883696539802L;
	private String iotid;
	private String equipment;
	private String name;
	private String type;
	private String key;
	private String value;
	private String collecttime;
	private String host;
	private String rack;
	private String other;
	public String getIotid() {
		return iotid;
	}
	public void setIotid(String iotid) {
		this.iotid = iotid;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
}
