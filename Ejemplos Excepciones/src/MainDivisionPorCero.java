/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francisco
 */
public class MainDivisionPorCero {
    public static void main(String[]args){
        
        double suma=0, n;
        int cont=0;
        
        do{
            System.out.println("Introduce un numero: ");
            n = EntradaConsola.leeReal();
            suma+=n;
            cont++;
        }while(n!=0);
        try{
            System.out.println("La media de las sumas es: " + 
                    Mate.divide(suma,cont-1));}catch(DivisionPorCero evt){
                    System.err.println("Dividir por CER0?!?!?!");
                    }
        }
    }
