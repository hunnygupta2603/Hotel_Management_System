
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class CheckOut extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    
    CheckOut(){
        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(80,10,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(35,70,100,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("Number"));
            }
        }catch (Exception e){}
        c1.setBounds(180,70,130,20);
        add(c1);
        
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(35,110,100,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(180,110,130,20);
        add(t1); 
        
        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(35,160,100,20);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,160,100,20);
        b2.addActionListener(this);
        add(b2); 
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(320,70,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(350,210, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(370,5,350,210);
        add(l4);
        
        
        setLayout(null);
        setBounds(300,200,720,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String id  = c1.getSelectedItem();
            String room  = t1.getText();
            String str = "delete from customer where number ='"+id+"'";
            String str2 = "update room set available= 'Available' where room_number ='"+room+"'";
            conn c = new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){}
            
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            conn c = new conn();
            String id = c1.getSelectedItem();
            try{
                ResultSet rs = c.s.executeQuery(("select * from customer where number ='"+id+"'"));
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
            }catch(Exception e){}
        }
            
    }
    public static void main(String[] args){
        new CheckOut().setVisible(true);
    }
}
