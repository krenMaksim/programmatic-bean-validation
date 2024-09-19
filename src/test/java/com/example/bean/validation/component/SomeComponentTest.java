package com.example.bean.validation.component;

import com.example.bean.validation.entity.User;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class SomeComponentTest {

  @Autowired
  private SomeComponent someComponent;

  @Test
  void provideInvalidUser() {
    User user = new User();
    user.setId(-100L);
    user.setName(null);

    assertThatThrownBy(() -> someComponent.handleUser(user))
        .isInstanceOf(ConstraintViolationException.class)
        .hasMessageContaining("handleUser.arg0.id: -100 must be a positive long")
        .hasMessageContaining("handleUser.arg0.name: must not be null");
  }

  @Test
  void provideValidUser() {
    User user = new User();
    user.setId(1L);
    user.setName("Bob");

    assertDoesNotThrow(() -> someComponent.handleUser(user));
  }
}