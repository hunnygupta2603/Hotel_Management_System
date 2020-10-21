
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5; 
    
    
    UpdateCheck(){
        JLabel l1 = new JLabel("Check-in Details");
        l1.setBounds(80,10,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(35,70,100,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        c1.setBounds(200,70,130,20);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(35,110,100,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,110,130,20);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,150,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,150,130,20);
        add(t2);
        
        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(35,190,100,20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,190,130,20);
        add(t3);
        
        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(35,230,100,20);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200,230,130,20);
        add(t4);
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(35,270,100,20);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200,270,130,20);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(105,310,100,20);
        b1.addActionListener(this);
        b1.setVisible(true);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,350,100,20);
        b2.addActionListener(this);
        b2.setVisible(true);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(170,350,100,20);
        b3.addActionListener(this);
        b3.setVisible(true);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel l8 = new JLabel(i3);
        l8.setBounds(230,10,700,390);
        add(l8);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setLayout(null);
        setBounds(250,200,800,430);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
           try{
               String room = null;
               String deposit = null;
               int amountPaid;
               String price = null;
               conn c = new conn();
               String id = c1.getSelectedItem();
               String str = "select * from customer where number ='"+id+"'";
               ResultSet rs = c.s.executeQuery(str);
               while(rs.next()){
                   t1.setText(rs.getString("room"));
                   t2.setText(rs.getString("name"));
                   t3.setText(rs.getString("status"));
                   t4.setText(rs.getString("deposit"));
                   room = rs.getString("room");
                   deposit = rs.getString("deposit");
               }
               
               ResultSet rs2 = c.s.executeQuery("select * from room where room_number ='"+room+"'");
               while(rs2.next()){
                   price = rs2.getString("price");
                   amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                   t5.setText(Integer.toString(amountPaid));
                   
               }
               
           } catch (Exception e){}
        }else if(ae.getSource()==b2){
            try{
                //pending
            }catch(Exception e){}
            
            
        }else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
