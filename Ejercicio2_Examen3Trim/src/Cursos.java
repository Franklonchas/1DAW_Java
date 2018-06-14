/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Cursos {

    int idCurso;
    String curso;

    public Cursos(int idCurso, String curso) {
        this.idCurso = idCurso;
        this.curso = curso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getCurso() {
        return curso;
    }

}
