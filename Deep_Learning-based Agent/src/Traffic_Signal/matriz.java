/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traffic_Signal;

import digitos.*;

/**
 *
 * @author celes
 */
public class matriz {
      double balance=-1;
    double capaI[][]={ {0,0,1,0,0 ,0,0,1,1,0, 1,1,1,1,1, 1,0,1,1,0, 1,0,1,0,0},///RIGHT
                       {0,0,1,0,0 ,0,0,0,1,0, 1,1,1,1,1, 1,0,0,1,0, 1,0,1,0,0},//RIGHT
                       {0,0,1,1,0 ,0,0,0,1,1, 1,1,1,1,1, 1,0,0,1,1, 1,0,1,1,0},//RIGHT
                       {0,0,1,0,0 ,0,1,1,0,0, 1,1,1,1,1, 0,1,1,0,1, 0,0,1,0,1},//LEFT
                       {0,0,1,0,0 ,0,1,0,0,0, 1,1,1,1,1, 0,1,0,0,1, 0,0,1,0,1},//LEFT
                       {0,1,1,0,0 ,1,1,0,0,0, 1,1,1,1,1, 1,1,0,0,1, 0,1,1,0,1}//LEFT
                             
                        };

    public double[][] getCapaI() {
        return capaI;
    }

    public double[][] getApender() {
        return ap