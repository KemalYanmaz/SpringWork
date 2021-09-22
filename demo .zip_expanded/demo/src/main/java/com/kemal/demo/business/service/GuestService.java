package com.kemal.demo.business.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemal.demo.data.entity.Guest;
import com.kemal.demo.data.repository.GuestRepository;

@Service
public class GuestService {
	
	private final GuestRepository guestRepository;
	
	@Autowired
	public GuestService(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	public List<Guest>getAllGuests() {
		List<Guest> guests = new ArrayList<>();
		guests = guestRepository.findAll();
		
		guests.sort(new Comparator<Guest>() {
			@Override
			public int compare(Guest g1,Guest g2) {
				return g1.getFirstName().compareTo(g2.getFirstName());
			}
			
		});
		return 	guests;
	}
}
