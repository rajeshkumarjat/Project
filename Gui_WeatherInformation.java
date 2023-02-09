package URL;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.net.*;
import java.util.Scanner;
import java.awt.event.*;

public class Gui_WeatherInformation {
    void weather(){
     JFrame frame = new JFrame("Weather Information");
     frame.setSize(500, 500);
     frame.getContentPane().setBackground(Color.LIGHT_GRAY);
     frame.setLayout(null);
     frame.setVisible(true);
     JLabel lb = new JLabel("**Get Weather Report**");
     lb.setFont(new Font("Arial",Font.BOLD,20));
     lb.setBounds(120, 10, 250, 50);
     frame.add(lb);
     JLabel lb1 = new JLabel("Enter City Name:");
     lb1.setBounds(30, 70, 150, 30);
     frame.add(lb1);
     JTextField jtf = new JTextField();
     jtf.setBounds(140, 65, 200, 40);
     frame.add(jtf);
     JButton bt = new JButton("SUBMIT");
     bt.setBounds(360, 65, 100, 40);
     bt.setBackground(Color.green);
     frame.add(bt);

     JLabel lb2 = new JLabel();
     lb2.setBounds(30, 130, 300, 30);
     lb2.setForeground(Color.MAGENTA);
     frame.add(lb2);
     JLabel lb3 = new JLabel();
     lb3.setBounds(30, 180, 300, 30);
     lb3.setForeground(Color.MAGENTA);
     frame.add(lb3);
     JLabel lb4 = new JLabel();
     lb4.setBounds(30, 230, 300, 30);
     lb4.setForeground(Color.BLUE);
     frame.add(lb4);
     JLabel lb5 = new JLabel();
     lb5.setBounds(30, 280, 300, 30);
     lb5.setForeground(Color.red);
     frame.add(lb5);
     JLabel lb6 = new JLabel();
     lb6.setBounds(30, 330, 300, 30);
     lb6.setForeground(Color.BLUE);
     frame.add(lb6);
     
     ActionListener submit = new ActionListener(){
        public void actionPerformed(ActionEvent e){
     if(!(jtf.getText().isEmpty())){
     try {
        URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+jtf.getText()+"&limit=1&appid=ba59726589fcb0f59b16355371f6f660");
        Scanner sc = new Scanner(url.openStream());
        String str="";
        while(sc.hasNextLine()){
            str+=sc.nextLine();
        }
        JSONParser par = new JSONParser();
        JSONArray arr = (JSONArray)par.parse(str);
        JSONObject obj = (JSONObject)arr.get(0);
        
        double lon=(double)obj.get("lon");
        double lat=(double)obj.get("lat");
        lb2.setText("Lattitude:  "+lat);
        lb3.setText("Longitude:  "+lon);

        URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=ba59726589fcb0f59b16355371f6f660");
        Scanner sc1 = new Scanner(url1.openStream());
        String str1="";
        while(sc1.hasNextLine()){
            str1+=sc1.nextLine();
        }
        JSONParser par1 = new JSONParser();
        JSONObject obj1= (JSONObject)par1.parse(str1);
        lb4.setText("visibility:  "+obj1.get("visibility"));

        JSONArray arr2=(JSONArray)par1.parse(obj1.get("weather").toString());
        JSONObject obj2 = (JSONObject)arr2.get(0);
        lb6.setText("Description:  "+obj2.get("description"));

        JSONObject obj3 =(JSONObject)par.parse(obj1.get("main").toString());
        lb5.setText("Temperature:  "+String.valueOf((Double)obj3.get("temp")-273)+" C");

    }catch (Exception f) {
        System.out.println(f);
    }
}
      else{
        lb5.setText("Please Enter City Name");
      }
    }};  bt.addActionListener(submit);
    }
    public static void main(String[] args) {
        Gui_WeatherInformation obj = new Gui_WeatherInformation();
        obj.weather();
    }
}
