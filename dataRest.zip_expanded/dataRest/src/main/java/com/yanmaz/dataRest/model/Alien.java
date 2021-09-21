package com.yanmaz.dataRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien {

	@Id
	@GeneratedValue
	private int aid;
	private String aname;
	private String atech;

	public Alien() {
		super();
	}

	public Alien(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtech() {
		return atech;
	}

	public void setAtech(String atech) {
		this.atech = atech;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", atech=" + atech + "]";
	}

}
