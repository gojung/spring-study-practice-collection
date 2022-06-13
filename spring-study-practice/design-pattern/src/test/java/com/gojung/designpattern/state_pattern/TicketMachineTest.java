package com.gojung.designpattern.state_pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketMachineTest {

  @Test
  void insertCoinTest(){
    TicketMachine ticketMachine1 = new TicketMachine();
    ticketMachine1.insertCoin();
  }
}