package mx.uv.alumnosdb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alumno {
  @Id
  @GeneratedValue ( strategy = GenerationType.AUTO )
  private Integer id;
  private String nombre;

  public String getNombre() {
    return nombre;
  }

  public void setNombre( String nombre ) {
    this.nombre = nombre;
  }

  public Integer getId() {
    return id;
  }

  public void setId( Integer id ) {
    this.id = id;
  }
}
