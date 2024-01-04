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
        sigmode= ne