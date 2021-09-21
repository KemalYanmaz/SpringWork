package com.example.Demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.Demo1.model.Alien;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> 
{	
	List<Alien> findByAname(String aname);
	List<Alien> findByAidGreaterThan(int aid);
}
