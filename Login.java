
package electricity.billing.system2;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel, signup;
    JTextField t1,t2;
    Choice c1 ;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        
         t1 = new JTextField();
        t1.setBounds(400, 20, 150, 20);
        add(t1);
        
        JLabel l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        
         t2 = new JTextField();
        t2.setBounds(400, 60, 150, 20);
        add(t2);
        
        JLabel l3 = new JLabel("Logiin in as");
        l3.setBounds(300, 100, 100, 20);
        add(l3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
         login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(330,160,100,20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(450,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("SignUp", new ImageIcon(i6));
        signup.setBounds(380,200,100,20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400,100,150,20);
        add(c1);
        
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = t1.getText();
            String password = t2.getText();
            String user = c1.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    t1.setText("");
                    t2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);  
        } else if(ae.getSource()== signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
