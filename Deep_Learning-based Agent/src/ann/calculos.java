
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
public class calculos {
    int nodosCapaO; //k
    int entCapaO;
    int nodosCapaH;//j
    int entCapaH;
    double n = 0.5; //valor de aprendisaje
    double [] entradas;
    activacion [] neuronO, neuronH;
    static double balance=-1;
    
    public calculos(int nodosCapaO, int nodosCapaH, int entCapaO, int entraCapaH ){
        this.nodosCapaO= nodosCapaO;
        this.nodosCapaH= nodosCapaH;
        this.entCapaO=entCapaO;
        this.entCapaH=entraCapaH;
    }
    
    public void crearRed(){
        
        //capa O
        neuronO =new activacion[nodosCapaO];
        for(int o=0;o<nodosCapaO;o++){
           neuronO[o]=new activacion(entCapaO);
        }
        //capa H
        neuronH =new  activacion[nodosCapaH];
        for(int h=0;h<nodosCapaH;h++){
           neuronH[h]=new activacion(entCapaH);           
        }
    }
    public void inicioPesos(){
        //capa o
        for(int o=0;o<nodosCapaO;o++){
            for(int i=0;i<entCapaO ;i++){
               neuronO[o].pesos[i]=Math.random();
            }
           // neuronO[o].verPesos();
        }