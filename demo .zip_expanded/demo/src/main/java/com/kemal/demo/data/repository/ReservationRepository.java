package com.kemal.demo.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemal.demo.data.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	List<Reservation> findReservationByReservationDate(Date date);
}
