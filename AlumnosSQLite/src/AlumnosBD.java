/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author medina
 */
import java.sql.*;

public class AlumnosBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public AlumnosBD() {
        conectar();
    }
    public void conectar() {        
        String url = "alumnos.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null) {
                System.out.println("Conectado");               
            }           
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexion con la BD Alumnos");
        }       
    }
    public ResultSet ejecutarQuery(String sentenciaSQL) {
        ResultSet resultado;
        Statement sentencia;
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
            return null;
        }
        return resultado;
    }
    public ResultSet obtenerEvaluaciones(){
        String sentenciaSQL="SELECT DISTINCT evaluacion FROM notas";
        return ejecutarQuery(sentenciaSQL);
    }
    public ResultSet obtenerCursos(){
        String sentenciaSQL="SELECT * FROM cursos";
        return ejecutarQuery(sentenciaSQL);         
    }
    public ResultSet obtenerTabla(String nomTabla){
        String sentenciaSQL="SELECT * FROM "+nomTabla;
        return ejecutarQuery(sentenciaSQL);
    }
    public int idClaveTabla(String tabla, String clave, String valor){
        String sentenciaSQL="SELECT * FROM "+tabla+" WHERE "+clave+"='"+valor+"'";
        ResultSet resultado=ejecutarQuery(sentenciaSQL);
        if(resultado!=null){
            try{
                if(resultado.next())
                    return (resultado.getInt("id"+clave));
            } catch(SQLException sql){
                System.out.println("Error en tabla " + tabla);
            }
        }
        return -1;
    }
    public ResultSet obtenerRegistro(String clave, int valor, String nomTabla){
        String sentenciaSQL="SELECT * FROM "+nomTabla+" WHERE "+clave+"="+valor+"";
        return ejecutarQuery(sentenciaSQL);
    }
    public ResultSet obtenerRegistro(String clave, String valor, String nomTabla){
        String sentenciaSQL="SELECT * FROM "+nomTabla+" WHERE "+clave+"='"+valor+"'";
        return ejecutarQuery(sentenciaSQL);
    }  
    public float obtenerNota(int idAlumno, int idAsignatura, String evaluacion){
        String sentenciaSQL="SELECT nota FROM Notas WHERE idAlumno="+idAlumno+" AND idAsignatura="+idAsignatura+" AND evaluacion='"+evaluacion+"'";
        ResultSet res=ejecutarQuery(sentenciaSQL);
        float nota=-1;
        if(res!=null) {
            try{
                if(res.next())
                    nota=res.getFloat("nota");                        
                }catch(SQLException e){}
        }
        return nota;        
    }
    public ResultSet obtenerNota(String evaluacion, int idAlumno, int idAsignatura){
        String sentenciaSQL="SELECT nota FROM Notas WHERE idAlumno="+idAlumno+" AND idAsignatura="+idAsignatura+" AND evaluacion='"+evaluacion+"'";
        return ejecutarQuery(sentenciaSQL);
    }
    public int numFilasTabla(String nomTabla){
        int cont=0;
        ResultSet resultado=obtenerTabla(nomTabla);
        if(resultado!=null) {
            try{
                while(resultado.next())
                    cont++;
            }catch(SQLException e){}            
        }
        return cont;
    }
    public ResultSet obtenerAsignaturas(String clave, int valor){
        String sentenciaSQL="SELECT * FROM Asignaturas WHERE "+clave+"="+valor;
        return ejecutarQuery(sentenciaSQL);
    }    
    public ResultSet obtenerAsignaturasEvaluables(String clave, int valor, String evaluacion){
        String sentenciaSQL="SELECT * FROM Asignaturas WHERE "+clave+"="+valor+" AND Asignaturas.idAsignatura IN (SELECT idAsignatura FROM notas WHERE evaluacion='"+evaluacion+"')";
        return ejecutarQuery(sentenciaSQL);
    }
    public int obtenerNumeroAsignaturasEvaluables(String clave, int valor, String evaluacion){
        ResultSet resultado=obtenerAsignaturasEvaluables(clave, valor, evaluacion);
        int cont=0;
        if(resultado!=null) {
            try{          
                while(resultado.next())
                    cont++;
            } catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
        return cont;
    }
    public int obtenerNumeroAsignaturas(String clave, int valor){
        ResultSet resultado=obtenerAsignaturas(clave, valor);
        int cont=0;
        if(resultado!=null) {
            try{
                while(resultado.next())
                    cont++;
            } catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
        return cont;
    }      
    public int obtenerNumeroAlumnos(String clave, int valor){
        ResultSet resultado=obtenerAlumnos(clave, valor);
        int cont=0;        
        if(resultado!=null) {
            try{
                while(resultado.next())
                    cont++;
            } catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
        }
        return cont;
    }      
    public ResultSet obtenerNotas(int idAlumno, String evaluacion){
        String sentenciaSQL="SELECT * FROM Notas WHERE idAlumno="+idAlumno+" AND evaluacion='"+evaluacion+"'";
        return ejecutarQuery(sentenciaSQL);
    }
    public ResultSet obtenerNotasAsignatura(int idAsignatura, String evaluacion){
        String sentenciaSQL="SELECT * FROM Notas WHERE idAsignatura="+idAsignatura;
        return ejecutarQuery(sentenciaSQL);
    }    
    public int [] obtenerAsignaturas(int idCurso){
        int idAsignaturas[];
        ResultSet rAsignaturas=obtenerAsignaturas("idCurso", idCurso);
        int fila=0;
        int n=obtenerNumeroAsignaturas("idCurso", idCurso);
        idAsignaturas=new int[n];
        try{
            while(rAsignaturas.next())
                idAsignaturas[fila++]=rAsignaturas.getInt("idAsignatura");
        }catch(SQLException e){}
        return idAsignaturas;
    }
    public String [] obtenerNombreAsignaturas(int idCurso){
        String asignaturas[];
        ResultSet rAsignaturas=obtenerAsignaturas("idCurso", idCurso);
        if(rAsignaturas==null)
            return null;
        int fila=0;
        int n=obtenerNumeroAsignaturas("idCurso", idCurso);
        asignaturas=new String[n];
        try{
            while(rAsignaturas.next())
                asignaturas[fila++]=rAsignaturas.getString("asignatura");
        }catch(SQLException e){}
        return asignaturas;
    }
    public ResultSet obtenerAlumnos(String clave, int valor){
        String sentenciaSQL="SELECT * FROM Alumnos WHERE "+clave+"="+valor;
        return ejecutarQuery(sentenciaSQL);
    }
    public int [] obtenerAlumnos(int idCurso){
        ResultSet rAlumnos=obtenerAlumnos("idCurso", idCurso);
        int idAlumnos [];
        int fila=0;
        int n=obtenerNumeroAlumnos("idCurso", idCurso);
        idAlumnos=new int[n];
        try{
            while(rAlumnos.next()){
                idAlumnos[fila++]=rAlumnos.getInt("idAlumno");
            }
        }catch(SQLException e){}
        return idAlumnos;
    }
    public int [] idCursos(){
        ResultSet rCursos=obtenerTabla("cursos");
        int idCursos [];
        int fila=0;
        int n=numFilasTabla("cursos");
        idCursos=new int[n];
        try{
            while(rCursos.next()){
                idCursos[fila++]=rCursos.getInt("idCurso");
            }
        }catch(SQLException e){}
        return idCursos;
    }
    public String [] obtenerEvaluaciones(int idCurso){
        String sentenciaSQL="SELECT DISTINCT evaluacion  FROM Notas, Asignaturas WHERE Notas.idAsignatura=Asignaturas.idAsignatura AND Asignaturas.idCurso="+idCurso;
        ResultSet rEvaluaciones=ejecutarQuery(sentenciaSQL);
        String evaluaciones[]=null;
        int cont=0;
        if(rEvaluaciones!=null){
            try{
                while(rEvaluaciones.next()){
                    cont++;
                }
            } catch(SQLException sql){
                System.out.println(sql.getMessage());
            }
            evaluaciones=new String[cont];
            cont=0;
            sentenciaSQL="SELECT DISTINCT evaluacion  FROM notas, Asignaturas WHERE Notas.idAsignatura=Asignaturas.idAsignatura AND Asignaturas.idCurso="+idCurso;
            rEvaluaciones=ejecutarQuery(sentenciaSQL);
            try{
                while(rEvaluaciones.next()){
                    evaluaciones[cont++]=rEvaluaciones.getString("evaluacion");
                }
            } catch(SQLException sql){
                System.out.println(sql.getMessage());
            }           
        }
        return evaluaciones;
    }
    public int [] obtenerNotas(int idAlumno, int idCurso, String evaluacion){
        ResultSet rNotas=obtenerNotas(idAlumno, evaluacion);        
        int idAsignaturas[]=obtenerAsignaturas(idCurso);
        int notas[]=new int[idAsignaturas.length];
        for(int i=0; i<notas.length; i++)
            notas[i]=-1;
        int i=0;
        try{
            while(rNotas.next()){
                notas[i++]=rNotas.getInt("nota");
            }
        } catch(SQLException e){System.out.println("error");}
        return notas;        
    }
    public int obtenerNota(int idAlumno, int idCurso, int idAsignatura, String evaluacion){
        ResultSet rNotas=obtenerNotas(idAlumno, evaluacion);
        boolean existenNotas=false;
        int idAsignaturas[]=obtenerAsignaturas(idCurso);
        int nota=0;
        int i=0;
        try{
            while(rNotas.next()){
                if(rNotas.getInt("idAsignatura")==idAsignatura){
                    nota=rNotas.getInt("nota");
                    existenNotas=true;
                }
            }
        } catch(SQLException e){System.out.println("error");}
        if(existenNotas)
            return nota;
        return -1;
    }
    public void ejecutarUpdate(String sentenciaSQL){
        Statement sentencia;
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }    
    public void grabarNota(int idAlumno, int idAsignatura, String evaluacion, float nota) {
        String sentenciaSQL="INSERT INTO Notas(idAlumno, idAsignatura, evaluacion, nota) VALUES("+idAlumno+","+idAsignatura+", '"+evaluacion+"',"+nota+")";
        ejecutarUpdate(sentenciaSQL);
    }
    public void modificarNota(int idAlumno, int idAsignatura, String evaluacion, float nota) {
        String sentenciaSQL="UPDATE Notas SET nota="+nota+" WHERE idAlumno="+idAlumno+" AND idAsignatura="+idAsignatura+" AND evaluacion='"+evaluacion+"'";
        ejecutarUpdate(sentenciaSQL);
    }   
}
