package com.gojung.designpattern.state_pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketMachine {

  private State state;

  final State coinState;
  final State noCoinState;

  public TicketMachine(){
    this.noCoinState = new NoCoinState(this);
    this.coinState = new CoinState(this);
    this.state = noCoinState;
  }

  public void insertCoin(){
    state.insertCoin();
  }

}
