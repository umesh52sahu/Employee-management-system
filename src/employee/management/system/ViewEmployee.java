
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    JButton search,update,Print,back;
    Choice cemployeeid;
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        cemployeeid=new Choice();        
        cemployeeid.setBounds(270,10,150,20);
        add(cemployeeid);
        
        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                cemployeeid.add(rs.getString("Emp_empId"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,910,660);
        add(jsp);
        
        JLabel search_Empid=new JLabel("Search by Employee Id");
        search_Empid.setBounds(10, 10, 250, 35);
        search_Empid.setFont(new Font("Serif",Font.PLAIN,25));
        add(search_Empid);
        
        
                
        search=new JButton("Search"); 
        search.setBounds(20,60,100,20);
        search.addActionListener(this);
        add(search);
        
        Print=new JButton("Print"); 
        Print.setBounds(130,60,100,20);
        Print.addActionListener(this);
        add(Print);
        
        update=new JButton("update"); 
        update.setBounds(240,60,100,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back"); 
        back.setBounds(350,60,100,20);
        back.addActionListener(this);
        add(back);
        
        setSize(923,650);
        setLocation(200,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where Emp_empid = '"+cemployeeid.getSelectedItem()+"'";
            
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs)); 
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource()==Print){
            try{
                table.print();                
            } catch(Exception e){
                e.printStackTrace();
            } 
        } else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
        } else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new ViewEmployee();
    }
}
