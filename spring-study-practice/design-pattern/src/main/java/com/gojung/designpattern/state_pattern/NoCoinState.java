package com.gojung.designpattern.state_pattern;

public class NoCoinState extends State {

  NoCoinState(TicketMachine ticketMachine) {
    super(ticketMachine);
  }

  @Override
  public void insertCoin() {
    System.out.println("Able to print ticket");
    this.ticketMachine.setState(ticketMachine.getCoinState());
  }

  @Override
  public void printTicket() {
    System.out.println("PPLEASE INSERT COIN");
  }
}
