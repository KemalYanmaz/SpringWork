package com.kemal.demo.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kemal.demo.business.domain.RoomReservation;
import com.kemal.demo.business.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationWebServiceController {

	private final ReservationService reservationService;
	
	@Autowired
	public RoomReservationWebServiceController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public ResponseEntity<List<RoomReservation>> getReservations(@RequestParam(name="date",required=false) String dateString){
		Date date = DateUtils.createDateFromDateString(dateString);
		return ResponseEntity.status(HttpStatus.OK).body(this.reservationService.getRoomReservationsForDate(date));
	}
}
