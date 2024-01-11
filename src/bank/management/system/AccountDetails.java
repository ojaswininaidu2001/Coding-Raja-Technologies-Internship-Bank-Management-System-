
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class AccountDetails extends JFrame implements ActionListener{
 
    JLabel title,name_label,cardno_label,l2,l3,l4,l5;
    JButton b2;
    String pin;
    AccountDetails(String pin){
        this.pin = pin;
        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        
        
        title = new JLabel("YN BANK");
        title.setFont(new Font("Georgia", Font.BOLD, 42));
        title.setBounds(380,40,700,100);
        title.setForeground(Color.PINK);
        title.setBounds(500, 40, 500, 30);
        add(title);
        
        name_label = new JLabel("  " );
        name_label.setFont(new Font("Georgia", Font.BOLD,23));
        name_label.setBounds(30, 140, 500, 30);
        name_label.setForeground(Color.white);
        add(name_label);
        
        cardno_label = new JLabel(" ");
        cardno_label.setBounds(700, 140, 500, 30);
        cardno_label.setFont(new Font("Georgia", Font.BOLD,23));
        cardno_label.setForeground(Color.white);
        add(cardno_label);
        
        
        int f_no=0;
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                cardno_label.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
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
         
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,200,1000,30);
        l2.setForeground(Color.WHITE);
        add(l2);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from signupthree where formno = '"+f_no+"'");
            while(rs.next()){
                l2.setText("Account Type :  " + rs.getString("atype"));
            }
        }catch(Exception e){}
        
        
        l3 = new JLabel("Facilities :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,250,1000,30);
        l3.setForeground(Color.WHITE);
        add(l3);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from signupthree where formno = '"+f_no+"'");
            while(rs.next()){
                l3.setText("Facilities Selected :  " + rs.getString("facility"));
            }
        }catch(Exception e){}
         
        l4 = new JLabel("Facilities :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100,300,1000,30);
        l4.setForeground(Color.WHITE);
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from signuptwo where formno = '"+f_no+"'");
            while(rs.next()){
                l4.setText("Any Other existing account :  " + rs.getString("existingaccount"));
            }
        }catch(Exception e){}
        
        l5 = new JLabel("Balance :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100,350,1000,30);
        l5.setForeground(Color.WHITE);
        add(l5);
        
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l5.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        b2 = new JButton("BACK");
        b2.setBounds(560,550,150,35);
        b2.setBackground(Color.PINK);
        add(b2);
        b2.addActionListener(this);
        
        setLayout(null);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
        
    }
    
    public static void main(String[] args){
        new  AccountDetails("").setVisible(true);
    }
    
}




