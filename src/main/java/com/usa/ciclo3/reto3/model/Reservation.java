package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idReservation;
        private Date startDate;
        private Date devolutionDate;
        private String status="created";

        public Integer getIdReservation() {
                return idReservation;
        }

        public void setIdReservation(Integer idReservation) {
                this.idReservation = idReservation;
        }

        public Date getStartDate() {
                return startDate;
        }

        public void setStartDate(Date startDate) {
                this.startDate = startDate;
        }

        public Date getDevolutionDate() {
                return devolutionDate;
        }

        public void setDevolutionDate(Date devolutionDate) {
                this.devolutionDate = devolutionDate;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public Cabin getCabin() {
                return cabin;
        }

        public void setCabin(Cabin cabin) {
                this.cabin = cabin;
        }

        public Client getClient() {
                return client;
        }

        public void setClient(Client client) {
                this.client = client;
        }

        public String getScore() {
                return score;
        }

        public void setScore(String score) {
                this.score = score;
        }

        @ManyToOne
        @JoinColumn(name = "id")
        @JsonIgnoreProperties("reservations")
        private Cabin cabin;

        @ManyToOne
        @JoinColumn(name = "idClient")
        @JsonIgnoreProperties({"reservations","messages"})
        private Client client;

        private String score;



}

