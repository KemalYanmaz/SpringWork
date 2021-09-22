package com.yanmaz.demoRestJersey.resource;

import com.yanmaz.demoRestJersey.model.Alien;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("api/")
public class AlienResource 
{
	@GET
	public Alien getAlien() {
		System.out.println("getAlien called...");
		Alien a1 = new Alien();
		a1.setName("Kemal");
		a1.setPoints(60);
		
		return a1;
	}
	
	
}
