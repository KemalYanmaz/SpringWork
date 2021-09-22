package com.kemal.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemal.demo.data.entity.Guest;
import com.kemal.demo.data.entity.Reservation;
import com.kemal.demo.data.entity.Room;
import com.kemal.demo.data.repository.GuestRepository;
import com.kemal.demo.data.repository.ReservationRepository;
import com.kemal.demo.data.repository.RoomRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
