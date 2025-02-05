package com.salesianostriana.dam.conectapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GoblalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmpresaNotFoundException.class)
    public ProblemDetail handleEmpresaNotFound(EmpresaNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Empresa no encontrada");
        return result;
    }

    @ExceptionHandler(FamiliaProfesionalNotFoundException.class)
    public ProblemDetail handleFamiliaProfesionalNotFound(FamiliaProfesionalNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Familia profesional no encontrada");
        return result;
    }

    @ExceptionHandler(TrabajadorNotFoundException.class)
    public ProblemDetail handleTrabajadorNotFound(TrabajadorNotFoundException ex) {
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Trabajador no encontrado");
        return result;
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ProblemDetail handleUsuarioNotFound(UsuarioNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Usuario no encontrado");
        return result;
    }

    @ExceptionHandler(ProfesorNotFoundException.class)
    public ProblemDetail handleProfesorNotFound(ProfesorNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Profesor no encontrado");
        return result;
    }

    @ExceptionHandler(CursoNotFoundException.class)
    public ProblemDetail handleCursoNotFound(CursoNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Curso no encontrado");
        return result;
    }

}
