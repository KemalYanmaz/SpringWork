package com.kemal.demo.business.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemal.demo.business.domain.RoomReservation;
import com.kemal.demo.data.entity.Guest;
import com.kemal.demo.data.entity.Reservation;
import com.kemal.demo.data.entity.Room;
import com.kemal.demo.data.repository.GuestRepository;
import com.kemal.demo.data.repository.ReservationRepository;
import com.kemal.demo.data.repository.RoomRepository;

@Service
public class ReservationService {
	
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(RoomRepository roomRepository,GuestRepository guestRepository,ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(Date date){
		List<Room> rooms = roomRepository.findAll();
		Map<Long,RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room->{
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservation.setDate(date);
			roomReservationMap.put(room.getRoomId(),roomReservation);
		});
		List<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation->{
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		
		List<RoomReservation> roomReservations = new ArrayList<>();
		for(Long id:roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		
		roomReservations.sort(new Comparator<RoomReservation>() {
			@Override
			public int compare(RoomReservation o1, RoomReservation o2) {
				if(o1.getRoomName().equals(o2.getRoomName())) {
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				}
				return o1.getRoomName().compareTo(o2.getRoomName());
			}
		});
		return roomReservations;
	}
}
