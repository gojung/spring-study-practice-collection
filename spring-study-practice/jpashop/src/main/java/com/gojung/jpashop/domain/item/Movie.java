package com.gojung.jpashop.domain.item;

import com.gojung.jpashop.domain.Item;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item {
  private String director;
  private String actor;
}