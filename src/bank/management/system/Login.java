package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear;
    JTextField cardTextField ;
    JPasswordField pinTextField;
    
    
    Login(){
        setTitle(" Login Page");
        
        
        setLayout(null);
        
        JLabel text = new JLabel("Welcome to YN BANK");
        text.setFont(new Font("Georgia",Font.BOLD,38));
        text.setBounds(400, 40, 400, 40);
        text.setForeground(Color.pink);
        add(text);
        
        JLabel cardno = new JLabel("Card No :  ");
        cardno.setFont(new Font("Osward",Font.BOLD,20));
        cardno.setBounds(150, 180, 400, 40);
        cardno.setForeground(Color.white);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(350, 180, 400, 40);
        cardTextField.setFont(new Font("Osward",Font.BOLD,20));
        add(cardTextField);
        
        
        JLabel pin = new JLabel("PIN :  ");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(150,250 , 400, 40);
        pin.setForeground(Color.white);
        add(pin);
        
         pinTextField = new JPasswordField();
         pinTextField.setBounds(350, 250, 400, 40);
         pinTextField.setFont(new Font("Osward",Font.BOLD,20));
         add(pinTextField);
         
         login = new JButton("SIGN IN");
         login.setBounds(300, 350, 100, 40);
         login.setBackground(Color.pink);
         login.addActionListener(this);
         add(login);
         
         clear = new JButton("CLEAR");
         clear.setBounds(500, 350, 100, 40);
         clear.setBackground(Color.pink);
         clear.addActionListener(this);
         add(clear);
         
         signup = new JButton("SIGN UP");
         signup.setBounds(700, 350, 100, 40);
         signup.setBackground(Color.pink);
         signup.addActionListener(this);
         add(signup);
         
         
        getContentPane().setBackground(Color.BLACK);
        setSize(1920,1080);
        setVisible(true);
        setVisible(true);
         
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        if(ae.getSource()== login){
            Conn c = new Conn();
                String cardno  = cardTextField.getText();
                String pin  = pinTextField.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
                
                
                try{
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next()){
                        setVisible(false);  
                        new Transactions(pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
        }
                    
  
            
        
        if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        
        
    }
    
   public static void main(String args[]){
       new Login();
       
   }
}
