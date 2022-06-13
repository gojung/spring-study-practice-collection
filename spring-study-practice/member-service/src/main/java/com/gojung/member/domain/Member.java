package com.gojung.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "member_id")
  private Long id;

  @Column(name = "name")
  private String username;

  private Integer age;

  @Builder
  public Member(String username, Integer age) {
    this.username = username;
    this.age = age;
  }

  public void updateUsername(String username) {
    this.username = username;
  }
}
