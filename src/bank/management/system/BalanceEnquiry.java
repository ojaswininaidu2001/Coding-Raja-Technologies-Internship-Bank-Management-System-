package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3,title,name_label,cardno_label;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        
        setLayout(null);

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
        

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setFont(new Font("Raleway", Font.BOLD,30));
        l1.setBounds(190, 350, 1000, 35);
        add(l1);

        b1 = new JButton("BACK");
        b1.setBounds(390, 433, 150, 35);
        b1.setBackground(Color.PINK);
        b1.setForeground(Color.black);
        add(b1);
     
       
        int balance = 0;
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                    
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
