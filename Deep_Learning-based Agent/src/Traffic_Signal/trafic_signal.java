
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traffic_Signal;

import ann.calculos;

/**
 *
 * @author celes
 */
public class trafic_signal {
      static Traffic_Signal.matriz m=new Traffic_Signal.matriz();
    static int nodoso=2;
    static int nodosh=13;
    static int entCapaO =14, entraCapaH=26 ;
    
    static  calculos redNeuronal=new calculos(nodoso,nodosh,entCapaO,entraCapaH);
    
    public static void main(String[] args) {
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