
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3,title,name_label,cardno_label;
    String pin;
    PinChange(String pin){
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
      
         
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(280,300,800,35);
        add(l1);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(180,390,150,35);
        add(l2);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(180,440,200,35);
        add(l3);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(350,390,180,25);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(350,440,180,25);
        add(t2);
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        b1.setBounds(390,560,150,35);
        b1.setBackground(Color.pink);
        add(b1);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b2.setBounds(600,560,150,35);
        b2.setBackground(Color.pink);
        add(b2);
        
       
        setSize(2000,1080);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}

