package edu.mum.cs544;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "edu.mum.cs544.Students")
@Table(name = "students")
public class Students {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;
}