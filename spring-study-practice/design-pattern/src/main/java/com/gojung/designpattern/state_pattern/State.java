package com.gojung.designpattern.state_pattern;

public abstract class State {

  TicketMachine ticketMachine;

  State(TicketMachine ticketMachine){
    this.ticketMachine = ticketMachine;
  }

  void insertCoin() {

  }

  void printTicket(){

  }
}
