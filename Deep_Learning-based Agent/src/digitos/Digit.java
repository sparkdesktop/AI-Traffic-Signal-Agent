
package digitos;

import ann.calculos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author celes
 */
public class Digit {
    static matriz m=new matriz();
    static int nodoso=4;
    static int nodosh=5;
    static int entCapaO =6, entraCapaH=8 ;
    
    static  calculos redNeuronal=new calculos(nodoso,nodosh,entCapaO,entraCapaH);
    
    public static void main(String[] args) {
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
        redNeuronal.verPesos_IH();
        redNeuronal.verPesos_HO();
                
    }
}