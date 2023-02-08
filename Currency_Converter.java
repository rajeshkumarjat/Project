package Project.JAVA;

import java.awt.Color;
import java.io.*;
import java.awt.event.*;
import java.lang.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Currency {
    void converter(){
   JFrame frame = new JFrame("Currency Converter");
   frame.setLayout(null);
   frame.setSize(400, 450);
   frame.getContentPane().setBackground(Color.LIGHT_GRAY);
   frame.setVisible(true);
   JTextField jtf = new JTextField();
   jtf.setBounds(250, 30, 100, 30);
   frame.add(jtf);
        JTextField jtf1 = new JTextField();
        jtf1.setBounds(250, 105, 100, 30);
        frame.add(jtf1);
     JButton bt = new JButton("Converter"); 
     bt.setBounds(150, 250, 100, 40);
     bt.setBackground(Color.MAGENTA);
     frame.add(bt);
     String[] currenc={"INR","USD","EURO","RUBLE"};  
   JComboBox jcomb = new JComboBox(currenc);
   JComboBox jcomb1 = new JComboBox(currenc);
   jcomb.setBackground(Color.white);
   jcomb.setForeground(Color.DARK_GRAY);
   jcomb1.setBackground(Color.white);
   jcomb1.setForeground(Color.DARK_GRAY);
   jcomb.setBounds(20, 30, 150, 40);
   frame.add(jcomb);
   jcomb1.setBounds(20, 100, 150, 40);
   frame.add(jcomb1);
  
     ActionListener click = new ActionListener(){
      public void actionPerformed(ActionEvent e)  {
     if(jcomb.getSelectedIndex()==0){
        if(jcomb1.getSelectedIndex()==0){
            jtf1.setText(jtf.getText());
        }
        else if(jcomb1.getSelectedIndex()==1){
            Double input = Double.parseDouble(jtf.getText());
            input*=.012;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==2){
            Double input = Double.parseDouble(jtf.getText());
            input*=.010;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==3){
            Double input = Double.parseDouble(jtf.getText());
            input*=.85;
            jtf1.setText(Double.toString(input));
        }
     }
     else if(jcomb.getSelectedIndex()==1){
        if(jcomb1.getSelectedIndex()==0){
            Double input = Double.parseDouble(jtf.getText());
            input*=80;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==1){
            jtf1.setText(jtf.getText());
        }
        else if(jcomb1.getSelectedIndex()==2){
            Double input = Double.parseDouble(jtf.getText());
            input*=.90;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==3){
            Double input = Double.parseDouble(jtf.getText());
            input*=70;
            jtf1.setText(Double.toString(input));
        }
     }
     else if(jcomb.getSelectedIndex()==2){
        if(jcomb1.getSelectedIndex()==0){
            Double input = Double.parseDouble(jtf.getText());
            input*=82;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==1){
            Double input = Double.parseDouble(jtf.getText());
            input*=1.08;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==2){
            jtf1.setText(jtf.getText());
        }
        else if(jcomb1.getSelectedIndex()==3){
            Double input = Double.parseDouble(jtf.getText());
            input*=76.36;
            jtf1.setText(Double.toString(input));
        }
     }
     else if(jcomb.getSelectedIndex()==3){
        if(jcomb1.getSelectedIndex()==0){
            Double input = Double.parseDouble(jtf.getText());
            input*=1.15;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==1){
            Double input = Double.parseDouble(jtf.getText());
            input*=.014;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==2){
            Double input = Double.parseDouble(jtf.getText());
            input*=.013;
            jtf1.setText(Double.toString(input));
        }
        else if(jcomb1.getSelectedIndex()==3){
            jtf1.setText(jtf.getText());  
        }
     }
      }
     }; bt.addActionListener(click);
    }
}
public class Currency_Converter {
    public static void main(String[] args) {
        Currency obj = new Currency();
        obj.converter();
    }
    
}
