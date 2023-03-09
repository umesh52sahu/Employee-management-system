package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
        
    JButton add,view,remove,update;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(610,20,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(610,70,170,30);
        add.addActionListener(this);
        add.setFont(new Font("serif",Font.ITALIC,16));
        image.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(845,70,170,30);
        view.addActionListener(this);
        view.setFont(new Font("serif",Font.ITALIC,16));
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(610,110,170,30);
        update.addActionListener(this);
        update.setFont(new Font("serif",Font.ITALIC,16));
        image.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(845,110,170,30);
        remove.addActionListener(this);
        remove.setFont(new Font("serif",Font.ITALIC,16));
        image.add(remove);
        
        setSize(1120,650);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
        } else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        } else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        } else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String[] args){
        new Home();
    }
}
