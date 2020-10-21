
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    PickUp(){
        
        JLabel l1 = new JLabel("Pick Up Service");
        l1.setBounds(350,10,300,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("Type Of Car");
        l2.setBounds(20,70,100,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c  = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
        }catch (Exception e){}
        c1.setBounds(150,70,130,20);
        add(c1);
        
        
        t1 = new JTable();
        t1.setBounds(0,130,900,310);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,440,100,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(430,440,100,25);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(45,110,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(170,110,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(300,110,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Company");
        l6.setBounds(420,110,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setBounds(550,110,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Availability");
        l8.setBounds(670,110,100,20);
        add(l8);
        
        JLabel l9 = new JLabel("Loaction");
        l9.setBounds(790,110,100,20);
        add(l9);
       
        getContentPane().setBackground(Color.WHITE);
                
        setLayout(null);
        setBounds(250,150,900,520);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String str = "select * from driver where brand ='"+c1.getSelectedItem()+"'";
                
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new PickUp().setVisible(true);
    }
}
