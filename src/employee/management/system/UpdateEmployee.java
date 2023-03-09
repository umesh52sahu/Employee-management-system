package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    JTextField jtFname,jtsalary,jtaddress,jtemail, jtdesignation,jtphone,jteducation;
    JButton update,back;
    JLabel randomid;
    String empId;
    
    UpdateEmployee(String empId){
        
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel AddDetail=new JLabel("Add Employee Detail");
        AddDetail.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        AddDetail.setBounds(300,30,250,30);
        add(AddDetail);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Serif",Font.PLAIN,17));
        name.setBounds(40,130,100,30);
        add(name);
        
        JLabel jtname=new JLabel();
        jtname.setBounds(170,130,150,30);
        add(jtname);
        
        JLabel Fname=new JLabel("Father's Name");
        Fname.setFont(new Font("Serif",Font.PLAIN,17));
        Fname.setBounds(390,130,200,30);
        add(Fname);
        
        jtFname=new JTextField();
        jtFname.setBounds(560,130,150,30);
        add(jtFname);
        
        JLabel Dataofbirth=new JLabel("Date of Birth");
        Dataofbirth.setFont(new Font("Serif",Font.PLAIN,17));
        Dataofbirth.setBounds(40,180,100,30);
        add(Dataofbirth);
        
        JLabel DOB =new JLabel();
        DOB.setBounds(170,180,150,30);
        add(DOB);
        
        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Serif",Font.PLAIN,17));
        salary.setBounds(390,180,200,30);
        add(salary);
        
        jtsalary=new JTextField();
        jtsalary.setBounds(560,180,150,30);
        add(jtsalary);
        
        JLabel address=new JLabel("Address");
        address.setFont(new Font("Serif",Font.PLAIN,17));
        address.setBounds(40,230,100,30);
        add(address);
        
        jtaddress=new JTextField();
        jtaddress.setBounds(170,230,150,30);
        add(jtaddress);
        
        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Serif",Font.PLAIN,17));
        phone.setBounds(390,230,200,30);
        add(phone);
        
        jtphone=new JTextField();
        jtphone.setBounds(560,230,150,30);
        add(jtphone);
        
        JLabel email=new JLabel("Email");
        email.setFont(new Font("Serif",Font.PLAIN,17));
        email.setBounds(40,280,200,30);
        add(email);
        
        jtemail=new JTextField();
        jtemail.setBounds(170,280,150,30);
        add(jtemail);
        
        JLabel highedu=new JLabel("Highest Education");
        highedu.setFont(new Font("Serif",Font.PLAIN,17));
        highedu.setBounds(390,280,200,30);
        add(highedu);
        
        
        jteducation=new JTextField();
        jteducation.setBackground(Color.WHITE);
        jteducation.setBounds(560,280,150,30);
        add(jteducation);
        
        JLabel designation=new JLabel("Designation");
        designation.setFont(new Font("Serif",Font.PLAIN,17));
        designation.setBounds(40,330,200,30);
        add(designation);
        
        jtdesignation=new JTextField();
        jtdesignation.setBounds(170,330,150,30);
        add(jtdesignation);
        
        JLabel aadhar=new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Serif",Font.PLAIN,17));
        aadhar.setBounds(390,330,200,30);
        add(aadhar);
        
        JLabel jtaadhar=new JLabel();
        jtaadhar.setBounds(560,330,150,30);
        add(jtaadhar);
        
        JLabel employeeid=new JLabel("Employee Id");
        employeeid.setFont(new Font("Serif",Font.PLAIN,17));
        employeeid.setBounds(40,380,200,30);
        add(employeeid);
        
        randomid=new JLabel();
        randomid.setFont(new Font("Serif",Font.PLAIN,17));
        randomid.setBounds(170,380,200,30);
        add(randomid);
        
        try{
            conn c=new conn();
            String query="select * from employee where Emp_empId = '"+empId+"' ";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                jtname.setText(rs.getString("Emp_Name"));
                jtFname.setText(rs.getString("Emp_FName"));
                DOB.setText(rs.getString("Emp_dob"));
                jtsalary.setText(rs.getString("Emp_salary"));
                jtaddress.setText(rs.getString("Emp_address"));
                jtphone.setText(rs.getString("Emp_phone"));
                jtemail.setText(rs.getString("Emp_email"));
                jteducation.setText(rs.getString("Emp_education"));
                jtdesignation.setText(rs.getString("Emp_designation"));
                jtaadhar.setText(rs.getString("Emp_aadhar"));
                randomid.setText(empId);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        update=new JButton("Update Details");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(250,550,150,40);
        add(update);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(450,550,150,40);
        add(back);
        
        setSize(850,700);
        setBounds(200,150,850,700);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            
            String Father_Name=jtFname.getText();
            String Employee_salary=jtsalary.getText();
            String Employee_address=jtaddress.getText();
            String Employee_email=jtemail.getText();
            String Employee_phone=jtphone.getText();
            String Employee_designation=jtdesignation.getText();
            String Employee_education=jteducation.getText();
            
            try{
                conn num=new conn();
                String query="update employee set Emp_FName = '"+Father_Name+"', Emp_salary = '"+Employee_salary+"', Emp_address = '"+Employee_address+"', Emp_phone = '"+Employee_phone+"', Emp_email = '"+Employee_email+"', Emp_education = '"+Employee_education+"', Emp_designation = '"+Employee_designation+"' where Emp_empId ='"+empId+"'";
                num.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Detail Updated Successfully");
                setVisible(false);
                new Home();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
