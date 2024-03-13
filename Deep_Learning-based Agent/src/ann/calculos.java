
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
        
        //capa h
         for(int j=0;j<nodosCapaH;j++){
            for(int i=0;i<entCapaH;i++){
               neuronH[j].pesos[i]=Math.random();
            }
           // neuronO[j].verPesos();
        }
    }
    
    public void entradasH(double capaI[]){
        //inicaliza entradas nodosh
        for(int j=0;j<nodosCapaH;j++){
            for(int i=0;i<capaI.length;i++){
               neuronH[j].entradas[i]=capaI[i];
            }
         //   neuronH[j].verEntradas();
        }
    }
    
    public void activacionO(){
        for(int j=0;j<nodosCapaO;j++){
            neuronO[j].activar();
        }
    }
    public void activacionH(){
        for(int j=0;j<nodosCapaH;j++){
            neuronH[j].activar();
        }
        
    } 
    
     public void entradasO(){
        //inicaliza entradas nodosh
        int i;
        for(int j=0;j<nodosCapaO;j++){
            for( i=0;i<nodosCapaH;i++){
               neuronO[j].entradas[i]=neuronH[i].getActivacion();
            }
            neuronO[j].entradas[i]=balance; //-1 umbral balance
        
         //   neuronO[j].verEntradas();
        }
    }
     
    public void errorCapaO(double aprender [][],int epoca){
        double error=0;
        for( int i=0;i<nodosCapaO;i++){
              error=(aprender[i][epoca]-neuronO[i].getActivacion())*neuronO[i].getActivacion()*(1-neuronO[i].getActivacion());
              neuronO[i].setErrorNodo(error);
        }
        
    }
    
    public void pesos_ho(){
        for(int i=0;i<nodosCapaO;i++){
            for(int p=0;p<entCapaO;p++){
            neuronO[i].pesos[p]+=(n*neuronO[i].getErrorNodo()*neuronO[i].entradas[p]);//revisar
        }
        }
    }
    
    public void errorCapaH(){
        double error, suma;
        
        for(int i=0;i<nodosCapaH;i++){
            suma=0;
            for(int p=0;p<nodosCapaO;p++){
              suma+=(neuronO[p].getErrorNodo()*neuronO[p].pesos[i]);
             }
            
           error=(neuronH[i].getActivacion()*(1-neuronH[i].getActivacion())*suma);
           neuronH[i].setErrorNodo(error);
        }  
    }
    
    public void pesosIH(){
        for(int i=0;i<nodosCapaH;i++){
            for(int p=0;p<entCapaH;p++){
              neuronH[i].pesos[p]+=n*neuronH[i].getErrorNodo()*neuronH[i].entradas[p];
            }
           // neuronH[i].verPesos();
        }
    }
    
    public double forward(int neutron) { 
		if(neuronO[neutron].getActivacion()>= 0.5) 
			return  1; 
		else 
			return  0;
		
	} 
    
    public void verPesos_IH(){
        System.out.println("-------------actualiza pesos_IH----------------------");
        for(int j=0;j <nodosCapaH;j++){
            neuronH[j].verPesos();
        }
    }
    
    public void verPesos_HO(){
        System.out.println("-------------actualiza pesos_HO----------------------");
        for(int j=0;j <nodosCapaO;j++){
            neuronO[j].verPesos();
        }
    }
    
}