


package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel l1,name_label;
    String pin;
    MiniStatement(String pin){
        this.pin = pin;
        
        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        
        
        l1 = new JLabel();
        l1.setForeground(Color.white);
        l1.setBounds(300, 200, 1000, 400);
        l1.setFont(new Font("Raleway", Font.BOLD, 16));
        add(l1);
        
        JLabel l2 = new JLabel("YN BANK");
        l2.setBounds(500, 40, 500, 30);
        l2.setFont(new Font("Georgia", Font.BOLD, 42));
        l2.setForeground(Color.PINK);
        add(l2);
        
        name_label = new JLabel("  " );
        name_label.setFont(new Font("Georgia", Font.BOLD,23));
        name_label.setBounds(30, 140, 500, 30);
        name_label.setForeground(Color.white);
        add(name_label);
        
       
        
        JLabel l3 = new JLabel();
        l3.setBounds(700, 140, 500, 30);
        l3.setFont(new Font("Georgia", Font.BOLD,23));
        l3.setForeground(Color.white);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(200, 620, 600, 30);
        l4.setFont(new Font("Raleway", Font.BOLD, 25));
        l4.setForeground(Color.white);
        add(l4);
        
        int f_no=0;
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
                f_no += Integer.parseInt(rs.getString("formno"));
            }
        }catch(Exception e){}
        
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from signup where formno = '"+f_no+"'");
            while(rs.next()){
                name_label.setText("Name : " + rs.getString("name"));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Back");
        b1.setBackground(Color.pink);
        add(b1);
        
        b1.addActionListener(this);
        b1.setBounds(800, 600, 100, 30);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}



