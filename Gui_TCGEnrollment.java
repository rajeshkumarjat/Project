package Project.JAVA;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.*;
import java.io.*;

class Enrollment1{
    void details1(){
        JFrame frame = new JFrame("TCG ...");
        frame.setLayout(null);
        frame.setSize(400, 500);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);

        JLabel lb5 = new JLabel("Tcg Enrollment");
        lb5.setFont(new Font("Arial",Font.BOLD,20));
        lb5.setBounds(110, 10, 200, 30);
        frame.add(lb5);

        JLabel lb = new JLabel("Name:");
        lb.setBounds(15, 60, 70, 30);
        frame.add(lb);
        JTextField tf = new JTextField();
        tf.setBounds(90, 60, 200, 40);
        frame.add(tf);

        JLabel lb1 = new JLabel("Rank:");
        lb1.setBounds(15, 120, 70, 30);
        frame.add(lb1);
        JTextField tf1 = new JTextField();
        tf1.setBounds(90, 120, 200, 40);
        frame.add(tf1);

        JLabel lb2 = new JLabel("Domain:");
        lb2.setBounds(15, 180, 70, 30);
        frame.add(lb2);
        JTextField tf2 = new JTextField();
        tf2.setBounds(90, 180, 200, 40);
        frame.add(tf2);

        JLabel lb3 = new JLabel("Mob No:");
        lb3.setBounds(15, 240, 70, 30);
        frame.add(lb3);
        JTextField tf3 = new JTextField();
        tf3.setBounds(90, 240, 200, 40);
        frame.add(tf3);

        JLabel lb4 = new JLabel("Email ID:");
        lb4.setBounds(15, 300, 70, 30);
        frame.add(lb4);
        JTextField tf4 = new JTextField();
        tf4.setBounds(90, 300, 200, 40);
        frame.add(tf4);

        JButton bt = new JButton("Submit");
        bt.setBackground(Color.PINK);
        bt.setBounds(140, 360, 100, 40);
        frame.add(bt);
         
        File obj = new File("Enrollment.Json");  // file name
        ActionListener click=new ActionListener(){
            public void actionPerformed(ActionEvent e){
        
            try {
                if(obj.exists()){
                    JSONParser par = new JSONParser();
                    JSONArray arr=(JSONArray)par.parse(new FileReader("Enrollment.Json"));
                    JSONObject obj1= new JSONObject();
                    obj1.put("Name", tf.getText());
                    obj1.put("Rank", tf1.getText());
                    obj1.put("Domain", tf2.getText());
                    obj1.put("Mob No", tf3.getText());
                    obj1.put("Email Id", tf4.getText());
                    arr.add(obj1);
                System.out.println(arr);
            FileWriter fw= new FileWriter("Enrollment.Json");
            fw.write(arr.toString());
            fw.close();
                        }
                        else{
                            System.out.println("Create new Json file");
                            JSONObject obj1= new JSONObject();
                            obj1.put("Name", tf.getText());
                            obj1.put("Rank", tf1.getText());
                            obj1.put("Domain", tf2.getText());
                            obj1.put("Mob No", tf3.getText());
                            obj1.put("Email Id", tf4.getText());

                    JSONArray array = new JSONArray();
                    array.add(obj1);
                System.out.println(array);
            FileWriter fw= new FileWriter("Enrollment.Json");
            fw.write(array.toString());
            fw.close();
                        }
                    }catch(Exception f){
                        System.out.println(f);
                    }
                tf.setText("");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");


                   
                }}; bt.addActionListener(click);
            }}
                public class Gui_TCGEnrollment {
                public static void main(String[] args) {
                Enrollment1 obj = new Enrollment1();
                obj.details1();    
    }
}
