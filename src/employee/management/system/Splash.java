package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBackground(Color.RED);
        heading.setFont(new Font("Serif",Font.PLAIN,50));
        heading.setBounds(140,5,1000,80);
        heading.setForeground(Color.RED);
        add(heading);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(40, 90, 855, 600);
        add(image);
        
        JButton click=new JButton("Click here to Continue");
        click.setBounds(310,600,300,50);
        click.addActionListener(this);
        add(click);
        
        
        setSize(950,750);
        setLocation(200,50);
        setVisible(true);
        
        while(true){
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            } catch(Exception e){
                
            }
            
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            } catch(Exception e){
                
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();
    }
    public static void main(String args[]){
        new Splash();
    }
}
