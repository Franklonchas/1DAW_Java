/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Asignaturas {

    int idAsignatura, idCurso;
    String asignatura;

    public Asignaturas(int idAsignatura, int idCurso, String asignatura) {
        this.idAsignatura = idAsignatura;
        this.idCurso = idCurso;
        this.asignatura = asignatura;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}
