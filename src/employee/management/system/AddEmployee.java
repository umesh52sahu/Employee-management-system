
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField jtname,jtFname,jtsalary,jtaddress,jtemail, jtdesignation,jtphone,jtaadhar;
    JButton hadd,back;
    JComboBox jteducation;
    JDateChooser DOB;
    JLabel randomid;
    
    Random ran=new Random();
    int num=ran.nextInt(999999);
    AddEmployee(){
        
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
        
        jtname=new JTextField();
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
        
        DOB =new JDateChooser();
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
        
        String deg[]={"BBA","BCA","BA","B.com","B.Tech","B.Sc","MBA","MCA","MA","M.com","M.Tech","OTHER"};
        jteducation=new JComboBox(deg);
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
        
        jtaadhar=new JTextField();
        jtaadhar.setBounds(560,330,150,30);
        add(jtaadhar);
        
        JLabel employeeid=new JLabel("Employee Id");
        employeeid.setFont(new Font("Serif",Font.PLAIN,17));
        employeeid.setBounds(40,380,200,30);
        add(employeeid);
        
        randomid=new JLabel(""+num);
        randomid.setFont(new Font("Serif",Font.PLAIN,17));
        randomid.setBounds(170,380,200,30);
        add(randomid);
        
        hadd=new JButton("Add Details");
        hadd.setBackground(Color.BLACK);
        hadd.setForeground(Color.WHITE);
        hadd.addActionListener(this);
        hadd.setBounds(250,550,150,40);
        add(hadd);
        
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
        if(ae.getSource()==hadd){
            
            String Name_Employee=jtname.getText();
            String Father_Name=jtFname.getText();
            String Employee_dob = ((JTextField) DOB.getDateEditor().getUiComponent()).getText();
            String Employee_salary=jtsalary.getText();
            String Employee_address=jtaddress.getText();
            String Employee_email=jtemail.getText();
            String Employee_phone=jtphone.getText();
            String Employee_designation=jtdesignation.getText();
            String Employee_aadhar=jtaadhar.getText();
            String Employee_education=(String)jteducation.getSelectedItem();
            String Employee_empId= randomid.getText();
            
            try{
                conn num=new conn();
                String query="insert into employee values('"+Name_Employee+"', '"+Father_Name+"', '"+Employee_dob+"', '"+Employee_salary+"', '"+Employee_address+"', '"+Employee_phone+"', '"+Employee_email+"', '"+Employee_education+"', '"+Employee_designation+"', '"+Employee_aadhar+"', '"+Employee_empId+"')";
                num.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Detail added Successfully");
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
        new AddEmployee();
    }
}
