package com.kemal.demo.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reservation_id")
	private long reservationId;
	
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="guest_id")
	private long guestId;
	
	@Column(name="res_date")
	private Date reservationDate;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public Date getResDate() {
		return reservationDate;
	}

	public void setResDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
}
