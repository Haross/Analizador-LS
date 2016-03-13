/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Gramatica {

    ArrayList<String> tokens;

    Gramatica(ArrayList tokens) {
        this.tokens = tokens;
    }

    public String P() {
        try {
            if (tokens.get(0).equals("INCLUDE")) {
                tokens.remove(0);
            } else {
              //  System.out.println("Se esperaba un INCLUDE");
                //return "Se esperaba un INCLUDE";
            }
        } catch (Exception e) {
           // System.out.println("Se esperaba un INCLUDE");
             //return "Se esperaba un INCLUDE";
        }
        //------------------------Métodos----------------------------
        try{
            if (tokens.get(0).equals("tipo")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un tipo");
                return "Se esperaba un tipo";
            }
        } catch (Exception e) {
             System.out.println("Se esperaba un tipo");
             return "Se esperaba un tipo";
        }
        try{
            if (tokens.get(0).equals("MAIN")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un MAIN");
                return "Se esperaba un MAIN";
            }
        } catch (Exception e) {
             System.out.println("Se esperaba un MAIN");
             return "Se esperaba un MAIN";
        }
        try{
            if (tokens.get(0).equals("PI")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un PI");
                return "Se esperaba un PI";
            }
         } catch (Exception e) {
             System.out.println("Se esperaba un PI");
             return "Se esperaba un PI";
        } 
        try{
            if (tokens.get(0).equals("PD")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un PD");
                return "Se esperaba un PD";
            }
        } catch (Exception e) {
             System.out.println("Se esperaba un PD");
             return "Se esperaba un PD";
        } 
        try{
            if (tokens.get(0).equals("LI")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba una LI");
                return "Se esperaba una LI";
            }
         } catch (Exception e) {
             System.out.println("Se esperaba una LI");
             return "Se esperaba una LI";
        } 
          //IDENTIFICADOR
        
        try {
            if (tokens.get(0).equals("tipo")) {
                tokens.remove(0);
                try{
                    if (tokens.get(0).equals("ID")) {
                        tokens.remove(0);
                        try{
                            if (tokens.get(0).equals("puntoYComa")) {
                                tokens.remove(0);
                            } else {
                                System.out.println("Se esperaba un ;");
                                return "Se esperaba un ;" ;
                            }
                        }catch(Exception e){
                            System.out.println("Se esperaba un ;");
                            return "Se esperaba un ;" ;
                        }
                    } else {
                        System.out.println("Se esperaba una ID");
                        return "Se esperaba una ID" ;
                    }
                }catch(Exception e){
                    System.out.println("Se esperaba una ID");
                    return "Se esperaba una ID" ;
                }
            } else {
                System.out.println("Se esperaba un tipo");
                return "Se esperaba un tipo" ;
            }
        } catch (Exception e) {
            System.out.println("Se esperaba un tipo");
            return "Se esperaba un tipo";
        } 
        //----------------------------------------------//
        try{
            if (tokens.get(0).equals("LD")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba una LD");
            }
         } catch (Exception e) {
             System.out.println("Se esperaba una LD");
             return "Se esperaba una LD";
        } 
        return "Sintaxis correcta";

        
    }
    
    public void M(){
        try{
         if (tokens.get(0).equals("tipo")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un tipo");
            }
          if (tokens.get(0).equals("ID")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba una ID");
            }
          
           if (tokens.get(0).equals("puntoYcoma")) {
                tokens.remove(0);
            } else {
                System.out.println("Se esperaba un ;");
            }
            } catch (Exception e) {
            
        }
    }

    /* public void P(){
     importar();
     tipo();
     main();
     parentesis();
        
     }
     public void M(){
        
     }
     public void declaracion(){
     tipo();
     identificador();
     R();
     }
     public void R(){
     coma();
     identificador();
     }
     public void coma(){
     try{
     if(tokens.get(0).equals("coma")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba parentesis Izq");
     System.exit(0);
     }
     }catch(Exception e){
     System.out.println("Se esperaba parentesis Izq");
     System.exit(0);
     }
     }
     public void identificador(){
     try{
     if(tokens.get(0).equals("ID")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba identoficador");
     System.exit(0);
     }
     }catch(Exception e){
     System.out.println("Se esperaba identificador");
     System.exit(0);
     }
     }
     public void parentesis(){
     parentesisIzq();
     parentesisDer();
     }
     public void parentesisIzq(){
     try{
     if(tokens.get(0).equals("PI")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba parentesis Izq");
     System.exit(0);
     }
     }catch(Exception e){
     System.out.println("Se esperaba parentesis Izq");
     System.exit(0);
     }
     }
     public void parentesisDer(){
     try{
     if(tokens.get(0).equals("PD")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba parentesis Der");
     System.exit(0);
     }
                    
     }catch(Exception e){
     System.out.println("Se esperaba parentesis Der");
     System.exit(0);
     }
        
     }
     public void tipo(){
     if(tokens.get(0).equals("tipo")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba tipo");
     System.exit(0);
     }
     }
     public void main(){
     if(tokens.get(0).equals("MAIN")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba main");
     System.exit(0);
     }
     }
    
     public void importar(){
     try{
     if(tokens.get(0).equals("INCLUDE")){
     tokens.remove(0);
     importar();
     }
           
     }catch(Exception e){
            
     }    
     }
    
     /*public void inicio(){
     importar();
     main();
     }
     public void main(){
     tipo();
     main2();
     }
     public void main2(){
     palabraMain();
     parentesis();
     }
     public void parentesis(){
     parentesisIzq();
     parentesisDer();
     }
     public void parentesisIzq(){
     if(tokens.get(0).equals("PI")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba parentesis Izq");
     System.exit(0);
     }
     }
     public void parentesisDer(){
     try{
     if(tokens.get(0).equals("PD"))
     tokens.remove(0);
     }catch(Exception e){
     System.out.println("Se esperaba parentesis Der");
     System.exit(0);
     }
        
     }
     public void palabraMain(){
     if(tokens.get(0).equals("MAIN")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba main");
     System.exit(0);
     }
     }
     public void tipo(){
     if(tokens.get(0).equals("tipo")){
     tokens.remove(0);
     }else{
     System.out.println("Se esperaba tipo");
     System.exit(0);
     }
     }*/
}
