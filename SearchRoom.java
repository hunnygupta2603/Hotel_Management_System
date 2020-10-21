
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    SearchRoom(){
        
        JLabel l1 = new JLabel("Search For Room");
        l1.setBounds(350,10,300,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(20,70,100,20);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(150,70,130,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(600,70,180,20);
        c2.setBackground(Color.WHITE);
        add(c2);
        
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
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50,110,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(240,110,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Status");
        l5.setBounds(420,110,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Price");
        l6.setBounds(600,110,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Bed type");
        l7.setBounds(760,110,100,20);
        add(l7);
       
        getContentPane().setBackground(Color.WHITE);
                
        setLayout(null);
        setBounds(250,150,900,520);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String str = "select * from room where bed_type ='"+c1.getSelectedItem()+"'";
                String str2 = "select * from room where available = 'Available' AND bed_type ='"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs;
                
                if(c2.isSelected()){
                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else {
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new SearchRoom().setVisible(true);
    }
}
