package Project.JAVA;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.util.*;

class Notespdf{
  void pdf(){
  JFrame frame = new JFrame();
  frame.setSize(1000, 1000);
  frame.setLayout(null);
  frame.getContentPane().setBackground(Color.LIGHT_GRAY);
  frame.setVisible(true);
  JLabel lb = new JLabel("** NOTES **");
  lb.setFont(new Font("Arial",Font.BOLD,20));
  lb.setBounds(400,20, 150, 30);
  frame.add(lb);
  JLabel lb1 = new JLabel("File Name:");
  lb1.setBounds(30, 70, 100, 20);
  frame.add(lb1);
  JTextField jtf= new JTextField();
  jtf.setBounds(120, 62, 250, 50);
  frame.add(jtf);
  JLabel lb2 = new JLabel("Topic Name:");
  lb2.setBounds(30, 130, 100, 20);
  frame.add(lb2);
  JTextField jtf1= new JTextField();
  jtf1.setBounds(120, 122, 250, 50);
  frame.add(jtf1);
  JLabel lb3 = new JLabel("Details:");
  lb3.setBounds(30, 200, 100,20 );
  frame.add(lb3);
  JTextArea area = new JTextArea();
  area.setBounds(30, 240, 930, 400);
  frame.add(area);
  JButton bt = new JButton("SUBMIT");
  bt.setBounds(30, 670, 100, 40);
  bt.setBackground(Color.GREEN);
  frame.add(bt);
  JLabel lb4 = new JLabel();
  lb4.setBounds(200, 670, 200, 30);
  frame.add(lb4);
  ActionListener submit = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      try {
        if(!(jtf.getText().isEmpty())){
          File file = new File(jtf.getText()+".text");
          FileWriter writer = new FileWriter(file,true);
          writer.write(jtf.getText()+":\t"+jtf1.getText()+":\n"+area.getText()+"\n");
          writer.close();
          lb4.setForeground(Color.BLUE);
          lb4.setText("Your Notes Saved");  
        }
        else{
          lb4.setForeground(Color.RED);
          lb4.setText("Please Enter File Name");
        }
      } catch (Exception f) {
        System.out.println(f);
      }
    }
  };  bt.addActionListener(submit);
  }
}
public class Gui_Notes {
    public static void main(String[] args) {
      Notespdf obj = new Notespdf();
      obj.pdf();  
    }
}
