package com.example.bean.validation.constraint;

import org.hibernate.validator.cfg.ConstraintDef;

public class UserIdDef extends ConstraintDef<UserIdDef, UserId> {

  public UserIdDef() {
    super(UserId.class);
  }
}
