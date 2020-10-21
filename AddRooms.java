
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    
    AddRooms(){
        
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        l1.setBounds(140,20,100,20);
        add(l1);
        
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.PLAIN,13));
        room.setBounds(60,70,150,30);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,13));
        available.setBounds(60,120,150,30);
        add(available);
        
        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(200,120,150,30);
        c1.setBackground(Color.white);
        add(c1);
        
        
        JLabel status = new JLabel("Cleaning Status");
        available.setFont(new Font("Tahoma",Font.PLAIN,13));
        status.setBounds(60,170,150,30);
        add(status);
        
        c2 = new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,170,150,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,13));
        price.setBounds(60,220,150,30);
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(200,220,150,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.PLAIN,13));
        type.setBounds(60,270,150,30);
        add(type);
        
        c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,270,150,30);
        c3.setBackground(Color.white);
        add(c3);
        
        b1 = new JButton("Add Rooms");
        b1.setBounds(60,330,130,30);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(210,330,130,30);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        JLabel l5  = new JLabel(i1);
        l5.setBounds(370,30,400,340);
        add(l5);
  
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(250,200,800,430);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1){
            
            String room  = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();
            
            conn c = new conn();
            try{
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            }
            
            
            
            
            
        }else if(ae.getSource() == b2){
        
            this.setVisible(false);
        }
    }
    
    
    
    
    public static void main(String[] args){
         new AddRooms().setVisible(true);
    }
       
}
