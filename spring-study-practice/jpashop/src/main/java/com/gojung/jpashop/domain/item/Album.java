package com.gojung.jpashop.domain.item;

import com.gojung.jpashop.domain.Item;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item {
  private String artist;
  private String etc;
}