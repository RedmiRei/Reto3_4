package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "message")
public class Message implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idMessage;
        private String messageText;

        public Integer getIdMessage() {
                return idMessage;
        }

        public void setIdMessage(Integer idMessage) {
                this.idMessage = idMessage;
        }

        public String getMessageText() {
                return messageText;
        }

        public void setMessageText(String messageText) {
                this.messageText = messageText;
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

        @ManyToOne
        @JoinColumn(name="id")
        @JsonIgnoreProperties({"messages", "client", "reservations"})
        private Cabin cabin;

        @ManyToOne
        @JoinColumn(name="idClient")
        @JsonIgnoreProperties({"messages", "reservations", "client"})
        private Client client;

}


