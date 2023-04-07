package mx.uv.alumnosdb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.alumnos.EditarRequest;
import https.t4is_uv_mx.alumnos.EliminarRequest;
import https.t4is_uv_mx.alumnos.MostrarRequest;
import https.t4is_uv_mx.alumnos.RegistrarRequest;
import https.t4is_uv_mx.alumnos.RegistrarResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class EndPoint {
  @Autowired
  private IAlumnos iAlumnos;

  @PayloadRoot( localPart = "RegistrarRequest", namespace = "https://t4is.uv.mx/alumnos" )
  @ResponsePayload
  public RegistrarResponse Registrar( @RequestPayload RegistrarRequest peticion ) {
    RegistrarResponse respuesta = new RegistrarResponse();
    respuesta.setRespuesta("Se registró el alumno " + peticion.getNombre());

    Alumno alumno = new Alumno();
    alumno.setNombre(peticion.getNombre());
    iAlumnos.save(alumno);

    return respuesta;
  }

  @PayloadRoot( localPart = "MostrarRequest", namespace = "https://t4is.uv.mx/alumnos" )
  @ResponsePayload
  public RegistrarResponse Mostrar( @RequestPayload MostrarRequest peticion ) {
    RegistrarResponse respuesta = new RegistrarResponse();

    Alumno alumno = new Alumno();
    alumno.setId( peticion.getValor() );
    Optional< Alumno > response = iAlumnos.findById( alumno.getId() );

    Alumno a = response.get();
    respuesta.setRespuesta( a.getNombre() );

    return respuesta;
  }

  @PayloadRoot( localPart = "EliminarRequest", namespace = "https://t4is.uv.mx/alumnos" )
  @ResponsePayload
  public RegistrarResponse Eliminar( @RequestPayload EliminarRequest peticion ) {
    RegistrarResponse respuesta = new RegistrarResponse();

    Alumno alumno = new Alumno();
    alumno.setId( peticion.getId() );
    
    iAlumnos.deleteById( alumno.getId() );
    
    respuesta.setRespuesta("Eliminado...");
    return respuesta;
  }

  @PayloadRoot( localPart = "EditarRequest", namespace = "https://t4is.uv.mx/alumnos" )
  @ResponsePayload
  public RegistrarResponse Editar( @RequestPayload EditarRequest peticion ) {
    RegistrarResponse respuesta = new RegistrarResponse();

       Alumno alumno = new Alumno();
        alumno.setId(peticion.getId());
        alumno.setNombre(peticion.getNombre());

        if ( iAlumnos.existsById(alumno.getId()) == true ) {
            iAlumnos.save(alumno);

            respuesta.setRespuesta( "Alumno actializado :D" );
        }else {
            respuesta.setRespuesta( "No existe el alumno..." );
        }

        return respuesta;
  }
}
