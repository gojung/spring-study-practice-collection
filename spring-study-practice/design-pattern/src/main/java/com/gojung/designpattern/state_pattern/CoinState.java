package com.gojung.designpattern.state_pattern;

public class CoinState extends State {

  CoinState(TicketMachine ticketMachine) {
    super(ticketMachine);
  }

  @Override
  public void insertCoin() {
    System.out.println("There is enought coin there");
  }

  @Override
  public void printTicket() {
    System.out.println("printing...");
    ticketMachine.setState(ticketMachine.getNoCoinState());
  }
}
