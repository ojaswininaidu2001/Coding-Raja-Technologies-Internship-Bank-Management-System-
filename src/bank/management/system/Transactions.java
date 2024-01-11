package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1,l2,title,name_label,cardno_label;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions(String pin){
        this.pin = pin;
        
        setTitle("Home Page");
        
        setLayout(null);

        title = new JLabel("Welcome to YN BANK");
        title.setFont(new Font("Georgia", Font.BOLD, 42));
        title.setBounds(380,40,700,100);
        title.setForeground(Color.PINK);
        title.setBounds(500, 40, 500, 30);
        add(title);
        
        name_label = new JLabel("  " );
        name_label.setFont(new Font("Georgia", Font.BOLD,23));
        name_label.setBounds(30, 200, 500, 30);
        name_label.setForeground(Color.white);
        add(name_label);
        
        cardno_label = new JLabel(" ");
        cardno_label.setBounds(700, 200, 500, 30);
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
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("WITHDRAWL");
        b3 = new JButton("ACCOUNT DETAILS");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        
        
        b1.setBounds(200,300,150,40);
        add(b1);
        
        b2.setBounds(500,300,150,40);
        add(b2);
        
        b3.setBounds(200,400,150,40);
        add(b3);
        
        b4.setBounds(500,400,150,40);
        add(b4);
        
        b5.setBounds(200,500,150,40);
        add(b5);
        
        b6.setBounds(500,500,150,40);
        add(b6);
        
        b7.setBounds(500,600,150,40);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new AccountDetails(pin).setVisible(true);}
        else if(ae.getSource()==b4){ 
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==b5){ 
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}