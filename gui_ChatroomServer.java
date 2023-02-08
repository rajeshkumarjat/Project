import java.awt.Color;
import java.awt.Font;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.lang.*;

public class gui_ChatroomServer {
    static ServerSocket ss;
    static Socket s;
    static Scanner sc1= new Scanner(System.in);
    static JTextField jtf;
    static JButton bt;
    static JTextArea jtr;
    static PrintWriter pw;

    static String str="", str1="";
    public static void main (String[] args){
JFrame frame = new JFrame("Chatroom");
frame.setLayout(null);
frame.setSize(500, 350);
frame.getContentPane().setBackground(Color.LIGHT_GRAY);
frame.setVisible(true);
JLabel lb = new JLabel("Server...");
lb.setFont(new Font("Arial",Font.BOLD,20));
lb.setBounds(10, 20, 100, 40);
frame.add(lb);
jtf = new JTextField();
jtf.setBounds(10, 200, 350, 50);
frame.add(jtf);
JButton bt = new JButton("SEND");
bt.setBounds(370, 200, 100, 50);
bt.setBackground(Color.GREEN);
frame.add(bt);
jtr = new JTextArea();
jtr.setBounds(10, 100, 350, 50);
frame.add(jtr);
    try {
        ss= new ServerSocket(100);
        s = ss.accept();
        jtr.setText("Connection establish");
        sc1= new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream(),true);
        ActionListener click = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                write();
                
        }};bt.addActionListener(click);
        reader();
    } catch (Exception e) {
        System.out.println(e);
    }
    }
    static void reader(){
        Thread tr = new Thread(()->{
            while(true){
                try {
                    str=sc1.nextLine();
                    jtr.setText(str);
                    if(str.equals("thanks")){break;}
                } catch (Exception e1) {
                    System.out.println(e1);
            }
        }
    });tr.start();}

    static void write(){
        Thread tw = new Thread(()->{
            
                try {
                    if(!(jtf.getText().equals(""))){
                    str1=jtf.getText();
                    pw.println(str1);
                    jtf.setText("");
                    }
                } catch (Exception e) {
                    System.out.println(e);
        }
    });tw.start();
}
}
