package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.crudrepository.ReservationsCrudRepository;
import com.usa.ciclo3.reto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

        @Autowired
        private ReservationsCrudRepository reservationsCrudRepository;

        public List<Reservation> getAll(){

            return (List<Reservation>) reservationsCrudRepository.findAll();
        }
        public Optional<Reservation> getReservation(int idReservation){

            return reservationsCrudRepository.findById(idReservation);
        }
        public Reservation save(Reservation reservation){

            return reservationsCrudRepository.save(reservation);
        }
        public void delete(Reservation reservation){

            reservationsCrudRepository.delete(reservation);
        }


}
