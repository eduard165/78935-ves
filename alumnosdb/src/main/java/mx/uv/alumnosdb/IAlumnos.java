package mx.uv.alumnosdb;

import org.springframework.data.repository.CrudRepository;

public interface IAlumnos extends CrudRepository<Alumno, Integer>{
  
}
