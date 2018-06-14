/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Notas {

    int idAlumno, idAsignatura, nota;
    String evaluacion;

    public Notas(int idAlumno, int idAsignatura, int nota, String evaluacion) {
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.nota = nota;
        this.evaluacion = evaluacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public int getNota() {
        return nota;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

}
