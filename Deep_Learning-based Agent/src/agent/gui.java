/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author celes
 */
public class gui extends JFrame {
    private agent myAgent;
    private JTextField xValueField;
    private JTextField xValueField2;
    private JTextField traf;
    gui(agent a){
        super(a.getLocalName());
        
        myAgent =a;
        
        JPanel p = new JPanel();
        

        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Digitos");
        addButton.addActionListener(new ActionListener() {
            public void 