/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;
import digitos.mainn;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ReceiverBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author celes
 */
public class agent  extends Agent {
    gui gui;
   // mainndi mm=new mainndi(2,13,14,26);
     
    mainn m=new mainn(4,5,6,8);
    public void setup(){
        System.out.println("Hola Mundo");
        gui gui = new gui(this);
	gui.showGui(); 
        
    }
    protected void takeDown() {
        gui.dispose();
    }
    public void Digitos( ){
        addBehaviour(new OneShotBehaviour() {
            public