package com.cuatro.cursoboot.model;

public class Course {

  private int id;
  private String name;
  private String description;
  private Integer price;
  private Integer hours;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getHours() {
    return hours;
  }

  public void setHours(Integer hours) {
    this.hours = hours;
  }

  public Course() {
  }

  public Course(int id, String name, String description, Integer price, Integer hours) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.hours = hours;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", hours=" + hours +
            '}';
  }
}
