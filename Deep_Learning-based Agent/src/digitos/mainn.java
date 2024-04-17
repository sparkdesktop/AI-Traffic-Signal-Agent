
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
   