package com.example.bean.validation.entity;

/*
 * In the given context, it should be assumed that the User is provided as a third-party dependency.
 * Thus, its code cannot be modified, i.e., validation annotations cannot be set.
 */
public class User {

  private Long id;
  private String name;

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("User{id=%d, name=%s}", id, name);
  }
}
