
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
            redNeuronal.entradasH(m.getCapaI()[iteracion]);
            redNeuronal.activacionH();
            redNeuronal.entradasO();
            redNeuronal.activacionO();
            
            redNeuronal.errorCapaO(m.getApender( ), iteracion);
            for (int j = 0; j <nodoso; j++) {
                 System.out.print(""+Math.round(redNeuronal.forward(j))+"  ");
                
            }
            
            //identificar
            String TURN = "";
            
            
            for (int j = nodoso-1; j >= 0; j--) {
                TURN+=""+(int)redNeuronal.forward(j);
                
            }
            if(TURN.equals("00")){
                TURN =" LEFT";
                
            }else if(TURN.equals("11")){
                 TURN =" RIGHT";
            }else{
                 TURN =" INDEFINIDO";
            }
            
            System.out.println(" TURN "+ TURN );
            noigual=false;
            
            //si los nodos o aprendieron bien 
            for(int j =0; j< nodoso; j++){
             if(redNeuronal.forward(j)==m.getApender()[j][iteracion]){
             }else{
                 noigual=true;
             }
            }
            
            if(noigual){
                i=-1;
                redNeuronal.pesos_ho();
                redNeuronal.errorCapaH();
                redNeuronal.pesosIH();
                
            }
            i++;
            numeroactualItera++;
           // System.out.println("**********************  "+i+" ***************** "+numeroactualItera+" ***************");
            
        }
      //  redNeuronal.verPesos_IH();
      //  redNeuronal.verPesos_HO();
    }
}