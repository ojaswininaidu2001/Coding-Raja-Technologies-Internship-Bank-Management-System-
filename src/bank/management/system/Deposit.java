
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1,b2;
    JLabel l1,title,name_label,cardno_label;
    String pin;
    Deposit(String pin){
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
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,330,400,35);
        add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(190,360,320,25);
        add(t1);
        
        b1 = new JButton("Deposit");
        b1.setBounds(390,450,150,35);
        b1.setBackground(Color.PINK);
        add(b1);
       
        
        
        
   
         b2 = new JButton("BACK");
        b2.setBounds(560,450,150,35);
        b2.setBackground(Color.PINK);
        add(b2);
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
           
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposit Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
