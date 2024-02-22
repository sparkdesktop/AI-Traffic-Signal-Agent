/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann;

/**
 *
 * @author celes
 */
public class activacion {
    double activa; 
    double []entradas; 
    double []pesos;  
    double errorNodo;//error de cada nodo
    static sigmoide sigmode;
    
    //inicializamos
    public activacion(int nentradas){
        pesos= new double[nentradas];
        entradas= new double[nentradas];
        sigmode= new sigmoide();
        errorNodo=0;
        
    }
    
    public void activar(){
        double suma=0;
        for(int i=0;i<entradas.length;i++){
            suma+=entradas[i]*pesos[i];
        }
        activa=sigmode.funcion(suma);
    }

    
    public void verEntradas(){
        System.out.println("-------------ENTRADAS-------------");
        for(int i=0;i<entradas.length;i++){
            System.out.println(entradas[i]);
        }
    }
    
    public void verPesos(){
        System.out.println("-------------PESOS----------------");
        for(int i=0;i<pesos.length;i++){
            System.out.println(pesos[i]);
        }
    }
     
    public double getActivacion(){
        return activa;
    } 
    
    public void verActivacion(){
         System.out.println("-------------ACTIVACION----------");
         System.out.println(activa);
        
    }
    
     public double getErrorNodo() {
        return errorNo