package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Gui_PasswordGenrator {
    void password(){
        File file = new File("Password.txt");  // file name
        JFrame frame = new JFrame("RSMSSB.gov.in.");
        frame.setSize(500,600 );
        frame.getContentPane().setBackground(Color.getHSBColor(60,20,93));
        frame.setLayout(null);
        frame.setVisible(true);
    
        JButton bt = new JButton("login in");
        bt.setBounds(50, 300, 150, 50);
        frame.add(bt);
        bt.setBackground(Color.LIGHT_GRAY);
        JButton bt1 = new JButton("Registration");
        bt1.setBounds(220, 300, 150, 50);
        frame.add(bt1);
        bt1.setBackground(Color.LIGHT_GRAY);

         ActionListener login = new ActionListener(){
         public void actionPerformed(ActionEvent e){ 
        JFrame fram = new JFrame("RSMSSB.gov.in.");
        fram.setSize(500,600 );
        fram.setLayout(null);
        fram.getContentPane().setBackground(Color.getHSBColor(60,20,93));
        fram.setVisible(true);
    
        JButton bt2 = new JButton("login in");
        bt2.setBounds(180, 250, 100, 50);
        fram.add(bt2);
        bt2.setBackground(Color.LIGHT_GRAY);

        
        JLabel lb = new JLabel("Email id:");
        lb.setBounds(20, 20, 100, 50);
        fram.add(lb);
        JTextField tf1 = new JTextField();
        tf1.setBounds(120, 20, 300, 50);
        fram.add(tf1);

        JLabel lb1 = new JLabel("password:");
        lb1.setBounds(20, 100, 100, 50);
        fram.add(lb1);
        JPasswordField tf2 = new JPasswordField();
        tf2.setBounds(120, 100, 300, 50);
        fram.add(tf2);

        JLabel lb2 = new JLabel();
        lb2.setBounds(20, 180, 300, 20); 
        fram.add(lb2);
          
        //******
        ActionListener login = new ActionListener(){
          public void actionPerformed(ActionEvent e){ 
            int count = 0,flag=0;
        try{
          
          Scanner read = new Scanner(file);
          while(read.hasNextLine()){
              String data=read.nextLine();
              int start=data.indexOf(' ');
              int end=data.length()-1;
              String aa =(tf1.getText()+" "+tf2.getText());
              if(data.contains(aa)&&aa.length()==(end-start)){
                  count=1;
                }else if(data.contains(aa)&&aa.length()!=(end-start)){
                   flag=1;
                   break;
                }
          }
          if(count==1){
            lb2.setText("you login successfully");
           }else if(flag==1){
            lb2.setText("you Entred wrong details");
           }
           else{
           lb2.setText("you are not registered !! Please Registration");
           }
          read.close();}
       catch(Exception e1){
           System.out.println(e1);
       }
        }
      };bt2.addActionListener(login);
    }}; 

        ActionListener registration = new ActionListener(){
        public void actionPerformed(ActionEvent e){  
        JFrame frame2 = new JFrame("RSMSSB.gov.in.");
        frame2.setSize(600,600 );
        frame2.setLayout(null);
        frame2.getContentPane().setBackground(Color.getHSBColor(60,20,93));
        frame2.setVisible(true);

       JButton bt3 = new JButton("Registration");
       bt3.setBounds(200, 300, 150, 50);
       frame2.add(bt3);
       bt3.setBackground(Color.LIGHT_GRAY);

      JLabel lb = new JLabel("Name:");
      lb.setBounds(20, 20, 100, 50);
      frame2.add(lb);
      JTextField tf = new JTextField();
      tf.setBounds(130, 20, 300, 50);
      frame2.add(tf);

      JLabel lb1 = new JLabel("Email Id:");
      lb1.setBounds(20, 100, 100, 50);
      frame2.add(lb1);
      JTextField tf1 = new JTextField();
      tf1.setBounds(130, 100, 300, 50);
      frame2.add(tf1);

      JLabel lb3 = new JLabel();
      lb3.setBounds(20, 250, 300, 20); 
      frame2.add(lb3);

      JLabel lb4 = new JLabel();
      lb4.setBounds(20, 210, 300, 20); 
      frame2.add(lb4);

      ActionListener fil = new ActionListener() {     
        public void actionPerformed(ActionEvent e){
          lb3.setForeground(Color.MAGENTA); 
      if(tf1.getText().contains("@gmail.com")){
        Random rand = new Random();
      int pass = rand.nextInt(11111,99999);
      lb3.setText("Your Password: "+pass);
        try {FileWriter writer = new FileWriter(file,true);
        
        writer.write(tf.getText()+" "+tf1.getText()+" "+pass+"\n");
        writer.close();
        lb4.setText("Registration Successfully");
    } catch (Exception f) {
        // TODO: handle exception
    }
      }
      else{
        lb4.setText("Wrong email id !! please try again");
      }
}};
bt3.addActionListener(fil);
      }
    };
      bt1.addActionListener(registration);
      bt.addActionListener(login);
        }
    public static void main(String[] args) {
        Gui_PasswordGenrator obj = new Gui_PasswordGenrator();
        obj.password();
    }
}
