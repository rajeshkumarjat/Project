package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.Random;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Gui_QuizGame {
    static ButtonGroup bg;
    static JRadioButton rbt1,rbt2,rbt3,rbt4;
    static JLabel lable,right;
    static JSONArray opti;
    static int j=0,total=0,nat=0;
    void quiz(){
    JFrame frame = new JFrame("Game");
    frame.setSize(700, 600);
    frame.setLayout(null);
    frame.setVisible(true);

    JLabel lb = new JLabel("~ ~Quiz Game~ ~");
    lb.setForeground(Color.BLUE);
    lb.setFont(new Font("verdana",Font.BOLD,20));
    lb.setBounds(230, 20, 250, 40);
    frame.add(lb);
    
    JButton bt = new JButton("Start Quiz");
    bt.setBackground(Color.green);
    bt.setBounds(20, 400, 150, 50);
    frame.add(bt);

    ActionListener start = new   ActionListener(){
      public void actionPerformed(ActionEvent e) {
      bt.setVisible(false);
      lable = new JLabel();
      lable.setFont(new Font("Arial",Font.BOLD,15));
       lable.setBounds(0, 100, 600, 30);
    frame.add(lable);
    rbt1 = new JRadioButton();
    rbt1.setBounds(20, 200, 200, 20);
    frame.add(rbt1);
     rbt2= new JRadioButton();
    rbt2.setBounds(20, 240, 200, 20);
    frame.add(rbt2);
    rbt3 = new JRadioButton();
    rbt3.setBounds(20, 280, 200, 20);
    frame.add(rbt3);
     rbt4 = new JRadioButton();
    rbt4.setBounds(20, 320, 200, 20);
    frame.add(rbt4);
    bg = new ButtonGroup();
    bg.add(rbt1);
    bg.add(rbt2);
    bg.add(rbt3);
    bg.add(rbt4);
    
    select();  
    JButton bt1 = new JButton("Show Answer");
    bt1.setBackground(Color.PINK);
    bt1.setBounds(20, 500, 150, 50);
    frame.add(bt1);
    JButton bt2 = new JButton("NEXT");
    bt2.setBackground(Color.green);
    bt2.setBounds(580, 500, 100, 50);
    frame.add(bt2);
    right = new JLabel();
    right.setFont(new Font("Arial",Font.BOLD,15));
    right.setForeground(Color.BLUE);
    right.setBounds(20,450,400,20);
    frame.add(right);
    ActionListener next = new   ActionListener(){
        public void actionPerformed(ActionEvent e){
            right.setText("");
            select();

        }
    };
    bt2.addActionListener(next);
    ActionListener answer = new   ActionListener(){
        public void actionPerformed(ActionEvent e){
          right.setText("Right Answer:   "+opti.get(4).toString());
          
        }
    };
    bt1.addActionListener(answer);
  }}; bt.addActionListener(start);
      }
      static void select(){
        try {
          if(j!=10){
        bg.clearSelection();
        JSONParser par = new JSONParser();
         JSONArray arr =(JSONArray)par.parse(new FileReader("GUI/Quiz.json"));
         //Random rand = new Random();
         //int indx=rand.nextInt(10);
         
      
         
           //String Quest =Question.get(j).toString();
           JSONObject obj = (JSONObject)arr.get(j);
         String Question =(obj.get("Q").toString());
           
           lable.setText(" Que"+(j+1)+": "+Question);
           
         j++;
         
        // String Question=obj.get("Q").toString();
         //lable.setText(" Que:   "+Question);
        // String optionn=obj.get("option");
         opti =(JSONArray)par.parse(obj.get("option").toString());
         int i=0;
         while(i<4){
         String optio=opti.get(i).toString();
         if(i==0){
          rbt1.setText(optio);
         }else if(i==1){
            rbt2.setText(optio);
         }else if(i==2){
            rbt3.setText(optio);
         }else{
            rbt4.setText(optio);
         }
         i++;
         }
         
        }
        else{
          right.setText("your Right Queston is "+total+" And Not Attempt"+(10-total-nat));
          j=0;
          total=0;
          nat=0;
        }
        ActionListener radio1 = new   ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(rbt1.getText().equals(opti.get(4).toString())){
              total++;
              right.setText("Right answer");
            }else{
              nat++;
              right.setText("Wrong Answer!!   Right Answer: "+opti.get(4).toString());
            }
          }
        };rbt1.addActionListener(radio1); 
        ActionListener radio2 = new   ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(rbt2.getText().equals(opti.get(4).toString())){
              total++;
              right.setText("Right answer");
            }else{
              nat++;
              right.setText("Wrong Answer!!   Right Answer: "+opti.get(4).toString());
            }
          }
        };rbt2.addActionListener(radio2);  
      
        ActionListener radio3 = new   ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(rbt3.getText().equals(opti.get(4).toString())){
              total++;
              right.setText("Right answer");
            }else{
              nat++;
              right.setText("Wrong Answer!!   Right Answer: "+opti.get(4).toString());
            }
          }
        };rbt3.addActionListener(radio3);  
      
        ActionListener radio4 = new   ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(rbt4.getText().equals(opti.get(4).toString())){
              total++;
              right.setText("Right answer");
            }else{
              nat++;
              right.setText("Wrong Answer!!   Right Answer: "+opti.get(4).toString());
            }
          }
        };rbt4.addActionListener(radio4);  
      
      }catch(Exception h){
        System.out.println(h);
    }
  }
    public static void main(String[] args) {
      Gui_QuizGame obj = new Gui_QuizGame();
      obj.quiz();  
    }
}
