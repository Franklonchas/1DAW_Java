

import java.sql.*;
public class Alumnos {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public Alumnos(){
        String url=".\\alumnos.s3db";
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:"+ url);
        }catch(SQLException e){
            System.err.println("No se ha podido realizar la conexion a la base de datos. "+ e);
        }     
    }
    public ResultSet obtenerCurso(String tabla){
        String sentenciaSQL="SELECT * FROM "+ tabla+ " ORDER BY idcurso";
        try{
            sentencia= conexion.createStatement();
            resultado= sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    
    
    public ResultSet obtenerEvaluacion(String tabla){
        String sentenciaSQL="SELECT DISTINCT evaluacion FROM "+ tabla;
        try{
            sentencia= conexion.createStatement();
            resultado= sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
   
    public ResultSet obtenerAsignatura(String cur){
        String sentenciaSQL="SELECT * FROM Asignaturas join cursos on asignaturas.idCurso = cursos.idCurso where cursos.curso ='"+cur+"'";
        try{
            sentencia= conexion.createStatement();
            resultado= sentencia.executeQuery(sentenciaSQL);
            
        }catch(SQLException e){
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
   
   
    public ResultSet obtenerAlumnos(String cur){
        String sentenciaSQL="SELECT * FROM alumnos join cursos on alumnos.idCurso = cursos.idCurso where cursos.curso ='"+cur+"'";
        try{
            sentencia= conexion.createStatement();
            resultado= sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;}
    
    private ResultSet ejecutarSentencia(String sentenciaSQL){
        try{
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
            return resultado;
        }catch(SQLException e){
            
            return null;
        }    
    }
     public String obtenerNotaAlumno(String idAlumno, String idAsignatura, String evaluacion){
        String sentenciaSQL = "SELECT nota FROM notas WHERE idAlumno="+idAlumno+" AND idAsignatura="+idAsignatura+" AND evaluacion='"+evaluacion+"';";
        resultado = ejecutarSentencia(sentenciaSQL);
        if(resultado != null){
            try{
                while(resultado.next()){
                    return resultado.getString("nota");
                }
            }catch(SQLException e){System.err.println();}
        }
        System.err.println("Fallo al obtener nota");
        return null;
     }
public String obtenerIDAlumno(String nombre){
        String sentenciaSQL = "SELECT idAlumno FROM alumnos Where nombre='"+nombre+"'";
        resultado = ejecutarSentencia(sentenciaSQL);
        if(resultado != null){
            try{
                while(resultado.next()){
                    return resultado.getString("idAlumno");
                }
            }catch(SQLException e){System.err.println();}
        }
        System.err.println("Fallo al obtener nota");
        return null;
     }


public String obtenerIDAsignatura(String asig){
        String sentenciaSQL = "SELECT idAsignatura FROM asignaturas where asignatura='"+asig+"'";
        resultado = ejecutarSentencia(sentenciaSQL);
        if(resultado != null){
            try{
                while(resultado.next()){
                    return resultado.getString("idAsignatura");
                }
            }catch(SQLException e){System.err.println();}
        }
        System.err.println("Fallo al obtener nota");
        return null;
     }

public void Actualizanotas(float nota, String alu,String asig, String eva){
    String sentenciaSQL = "update notas set nota='"+nota+"' where notas.idAlumno='"+alu+"' and notas.idAsignatura='"+asig+"' and notas.evaluacion='"+eva+"'";
    resultado = ejecutarSentencia(sentenciaSQL);
    

}



}

