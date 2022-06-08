package com.gojung.springjpa.section2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Member {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String username;

  private Integer age;
}
