package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui_CompleteCalculator {
 public static void main(String[] args) {
    JFrame frame = new JFrame("calculator");
    frame.setLayout(null);
    frame.setSize(400,450);
    
    JPanel jp1 = new JPanel();
    jp1.setBounds(0,0,380,50);
    jp1.setBackground(Color.CYAN);
    frame.add(jp1);

    JTextArea ta = new JTextArea();
    jp1.add(ta);
    
    JPanel jp = new JPanel();
    jp.setLayout(new GridLayout(4,4,2,2));
    jp.setBounds(0,55,380,350);
    frame.add(jp);

    JButton b1=new JButton("1");  
    JButton b2=new JButton("2");    
    JButton b3=new JButton("3");    
    JButton b4=new JButton("*");    
    JButton b5=new JButton("4");  
    JButton b6=new JButton("5");    
    JButton b7=new JButton("6");    
    JButton b8=new JButton("-");    
    JButton b9=new JButton("7"); 
    JButton b10=new JButton("8"); 
    JButton b11=new JButton("9");
    JButton b12=new JButton("+");
    JButton b13=new JButton("0");  
    JButton b14=new JButton("C");
    JButton b15=new JButton("/"); 
    JButton b16=new JButton("=");  
    jp.add(b1);
    jp.add(b2);
    jp.add(b3);
    jp.add(b4);
    jp.add(b5);
    jp.add(b6);
    jp.add(b7);
    jp.add(b8);
    jp.add(b9);
    jp.add(b10); 
    jp.add(b11); 
    jp.add(b12); 
    jp.add(b13); 
    jp.add(b14);
    jp.add(b15);
    jp.add(b16);  

    frame.setVisible(true);
 }
}
