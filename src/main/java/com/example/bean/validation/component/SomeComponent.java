package com.example.bean.validation.component;

import com.example.bean.validation.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class SomeComponent {

  public void handleUser(@Valid User user) {
    System.out.println("Got validated user " + user);
  }
}
