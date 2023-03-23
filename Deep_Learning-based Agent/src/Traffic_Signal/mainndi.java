
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traffic_Signal;

import static Traffic_Signal.trafic_signal.m;
import static Traffic_Signal.trafic_signal.nodoso;
import static Traffic_Signal.trafic_signal.redNeuronal;
import digitos.*;
import ann.calculos;
import Traffic_Signal.matriz;

/**
 *
 * @author celes
 */
public class mainndi {
     static matriz m=new matriz();
    static int nodoso;
    static int nodosh;
    static int entCapaO , entraCapaH;
    
    static  calculos redNeuronal=new calculos(nodoso,nodosh,entCapaO,entraCapaH);
    
    public mainndi (int nodoso, int nodosh, int entCapaO, int entraCapaH){
    this.nodoso=nodoso;
    this.nodosh=nodosh;
    this.entCapaO =entCapaO;
    this.entraCapaH=entraCapaH ;
    }
   
    public void main() {
      redNeuronal.crearRed();
        redNeuronal.inicioPesos();
        
        int numeroIter=60000; //n
        int i=0;
        int iteracion;//epoca
        double error;
        int numeroactualItera=0;//k
        boolean noigual=false;
        while(i<m.getCapaI().length && numeroactualItera < numeroIter ){
             iteracion=i;
            if(i==0){
                 System.out.println("---------------epoca"+iteracion+"------------------------------------Iteracion "+ numeroactualItera+" ------------------------");
            }
             
            for (int j = 0; j < 25; j++) {
                 System.out.print(""+Math.round(m.getCapaI()[iteracion][j])+" ");
                
            }
            System.out.print(" Aprender ");
            for (int j = 0; j <nodoso; j++) {
                 System.out.print(""+Math.round(m.getApender()[j][iteracion])+" ");
                
            }
            
            System.out.print(" Salida ");