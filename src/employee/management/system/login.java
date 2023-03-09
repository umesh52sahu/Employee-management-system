    package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JTextField jfpassword,jfusername;
    login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username=new JLabel("Username");
        username.setBounds(35,40,200,20);
        add(username);
        
        jfusername=new JTextField();
        jfusername.setBounds(135,40,150,25);
        add(jfusername);
        
        JLabel password=new JLabel("Password");
        password.setBounds(35,80,200,20);
        add(password);
        
        jfpassword=new JTextField();
        jfpassword.setBounds(135,80,150,25);
        add(jfpassword);
        
        JButton Login=new JButton("Login");
        Login.setBounds(135,120,150,25);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(290,15,200,200);
        add(image);
        
        
        setSize(500,250);
        setLocation(530,270);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=jfusername.getText();
            String password=jfpassword.getText();
            
            conn c=new conn();
            String query="select * from login where username = '"+username+"' and password='"+password+"'";   
            ResultSet rs=c.s.executeQuery(query);
            
            if(rs.next()){
                
                new Home();
                setVisible(false);
            } else{
                JOptionPane.showMessageDialog(null,"Invalid Username and password");
                setVisible(false);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
       new login();
    }
}