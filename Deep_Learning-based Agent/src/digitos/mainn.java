
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitos;

import ann.calculos;
import digitos.matriz;

/**
 *
 * @author celes
 */
public class mainn {
     static matriz m=new matriz();
    static int nodoso;
    static int nodosh;
    static int entCapaO , entraCapaH;
    
    static  calculos redNeuronal=new calculos(nodoso,nodosh,entCapaO,entraCapaH);
    
    public mainn (int nodoso, int nodosh, int entCapaO, int entraCapaH){
    this.nodoso=nodoso;
    this.nodosh=nodosh;
    this.entCapaO =entCapaO;
    this.entraCapaH=entraCapaH ;
    }
   
    public void main() {
        redNeuronal.crearRed();
        redNeuronal.inicioPesos();
        
        int numeroIter=70000; //n
        int i=0;
        int iteracion;//epoca
        double error;
        int numeroactualItera=0;//k
        boolean noigual=false;
        while(i<m.getCapaI().length && numeroactualItera < numeroIter ){
             iteracion=i;
            if(i==0){
                 System.out.println("---------------------------------------------------Iteracion "+ numeroactualItera+" ------------------------");
            }
             
            for (int j = 0; j < 7; j++) {
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
            
            redNeuronal.errorCapaO(m.getApender(), iteracion);
            for (int j = 0; j <nodoso; j++) {
                 System.out.print(""+Math.round(redNeuronal.forward(j))+"  ");
                
            }
            
            //conversion decimal a binario
            double decimal=0;
            
            int t=0;
            for (int j = nodoso-1; j >= 0; j--) {
                decimal+=redNeuronal.forward(j)*Math.pow(2,t);
                t++;
            }
            System.out.println(" decimal "+ decimal);
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