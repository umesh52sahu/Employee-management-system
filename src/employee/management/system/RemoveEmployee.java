
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempid;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid=new JLabel("Employee Id");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);
        
        cempid=new Choice();
        cempid.setBounds(200,50,150,30);
        add(cempid);
       
        try{
            conn c=new conn();
            String query="select * from employee ";
            ResultSet rs=c.s.executeQuery(query);
               
            while(rs.next()){
                cempid.add(rs.getString("Emp_empId"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel jname=new JLabel("Name");
        jname.setBounds(50,110,150,30);
        add(jname);
        
        JLabel jtname=new JLabel();
        jtname.setBounds(200,110,150,30);
        add(jtname);
        
        JLabel jemail=new JLabel("Email");
        jemail.setBounds(50,170,150,30);
        add(jemail);
        
        JLabel jtemail=new JLabel();
        jtemail.setBounds(200,170,150,30);
        add(jtemail);
        
        JLabel jphone=new JLabel("Phone");
        jphone.setBounds(50,230,150,30);
        add(jphone);
        
        JLabel jtphone=new JLabel();
        jtphone.setBounds(200,230,150,30);
        add(jtphone);
        
        try{
            conn n=new conn();
            String query="select * from employee where Emp_empId = '"+cempid.getSelectedItem()+"'";
            ResultSet rs=n.s.executeQuery(query);
            while(rs.next()){
                jtname.setText(rs.getString("Emp_Name"));
                jtemail.setText(rs.getString("Emp_email"));
                jtphone.setText(rs.getString("Emp_phone"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void  itemStateChanged(ItemEvent ie){
                try{
                        conn n=new conn();
                        String query="select * from employee where Emp_empId = '"+cempid.getSelectedItem()+"'";
                        ResultSet rs=n.s.executeQuery(query);
                        while(rs.next()){
                            jtname.setText(rs.getString("Emp_Name"));
                            jtemail.setText(rs.getString("Emp_email"));
                            jtphone.setText(rs.getString("Emp_phone"));
                            }
                } catch(Exception e){
                    e.printStackTrace();
                }
                }
        });
        
        
        delete=new JButton("Delete ");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        delete.setBounds(80,300,100,30);
        add(delete);
        
        back=new JButton("Back ");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(230,300,100,30);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 650, 400);
        add(image);
        
        setSize(1000,550);
        setLocation(200,250);
        setBounds(200,250,1000,405);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==delete){
           try{
               conn n=new conn();
               String query="delete from employee where Emp_empId = '"+cempid.getSelectedItem()+"'";
               n.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
               setVisible(false);
               new Home();
           }catch(Exception e){
               e.printStackTrace();
           }
       } else{
           setVisible(false);
           new Home();
       }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
