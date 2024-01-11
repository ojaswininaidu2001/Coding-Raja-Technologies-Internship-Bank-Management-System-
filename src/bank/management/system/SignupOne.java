package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;



public class SignupOne extends JFrame implements ActionListener{
    
    JButton b;
    JLabel formno, personalDetails, name,fname,dob,gender,email,martial,address,city,pincode,state;
    JTextField nameTextField,fnameTextField ,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser dateChooser;
    
    JRadioButton male,female,unmarried ,married,other ;
    
    Random ran= new Random();
    long random = Math.abs(ran.nextLong() % 9000L) + 1000L;
    
    
    
    SignupOne(){
        
       // String first = "" + Math.abs(first4);
        
        formno= new JLabel("Application Form NO.  " + random);
        formno.setFont(new Font("Georgia", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        formno.setForeground(Color.pink);
        add(formno);
        
        personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Georgia", Font.BOLD, 22));
        personalDetails.setBounds(290,80,600,30);
        personalDetails.setForeground(Color.pink);
        add(personalDetails);
        
        name= new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        name.setForeground(Color.white);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        fname.setForeground(Color.white);
        add(fname); 
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
       
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        dob.setForeground(Color.white);
        add(dob);
        
        dateChooser = new JDateChooser();
	dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(300,240,200,30);
	add(dateChooser);
       
       
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        gender.setForeground(Color.white);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(300,290,60,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(450,290,90,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
      
        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        email.setForeground(Color.white);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
      
        martial = new JLabel("Marital Status:");
        martial.setFont(new Font("Raleway", Font.BOLD, 20));
        martial.setBounds(100,390,200,30);
        martial.setForeground(Color.white);
        add(martial);
        
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 14));
        married.setBackground(Color.WHITE);
        married.setBounds(300,390,100,30);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 14));
        other.setBackground(Color.WHITE);
        other.setBounds(635,390,100,30);
        add(other);
        
        ButtonGroup martitalgroup = new ButtonGroup();
        martitalgroup.add(married);
        martitalgroup.add(unmarried);
        martitalgroup.add(other);
        
        
        address= new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        address.setForeground(Color.white);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        city.setForeground(Color.white);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        state.setForeground(Color.white);
        add(state);
        
        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        pincode.setForeground(Color.white);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        b = new JButton("Next");
        b.setBounds(900,590,200,30);
        b.setBackground(Color.pink);
        b.addActionListener(this);
        add(b);
        
       
     
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setLayout(null);
         
       
        getContentPane().setBackground(Color.BLACK);
        setSize(1920,1080);
        setVisible(true);

    }
    
    
    
    
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = ""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }
        if(female.isSelected()){ 
            gender = "Female";
        }
        String email = emailTextField.getText();
        
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String state = stateTextField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Fill Required Details");
            }
            else{
                Conn c=new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                
            
            }
            
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
            
        }
        catch ( Exception e){
            System.out.println(e);
        }
        
        
        
        



    }
    
     public static void main(String args[]){
        new SignupOne();
    }
}