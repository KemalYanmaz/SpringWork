package com.kemal.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kemal.demo.business.service.GuestService;
import com.kemal.demo.data.entity.Guest;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

	private final GuestService guestService;

	@Autowired	
	public GuestWebController(GuestService guestService) {
		this.guestService = guestService;
	}
	
	@GetMapping
	public String getGuests(Model model) {
		List<Guest> guests = guestService.getAllGuests();
		model.addAttribute("guests",guests);
		return "guests";
	}
}
