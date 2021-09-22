package com.kemal.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemal.demo.data.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long>{

}
