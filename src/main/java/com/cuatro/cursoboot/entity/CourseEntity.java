package com.cuatro.cursoboot.entity;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "public", catalog = "ejemplo")
public class CourseEntity {
  private int id;
  private String name;
  private String description;
  private Integer price;
  private Integer hours;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO, generator="course_id_gen")
  @SequenceGenerator(name="course_id_gen", sequenceName="course_id_seq")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Basic
  @Column(name = "hours")
  public Integer getHours() {
    return hours;
  }

  public void setHours(Integer hours) {
    this.hours = hours;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CourseEntity that = (CourseEntity) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(description, that.description) &&
            Objects.equals(price, that.price) &&
            Objects.equals(hours, that.hours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price, hours);
  }
}
