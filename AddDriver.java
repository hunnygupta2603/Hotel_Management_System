
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1,c2;
    AddDriver(){
        
    JLabel title = new JLabel("Add Drivers");
    title.setFont(new Font("Tahoma",Font.BOLD,16));
    title.setBounds(140,20,100,20);
    add(title);
    
    JLabel name = new JLabel("Name");
    name.setBounds(60,60,150,30);
    name.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(name);
    
    t1 = new JTextField();
    t1.setBounds(200,60,150,30);
    add(t1);
    
    JLabel age = new JLabel("Age");
    age.setBounds(60,100,150,30);
    age.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(age);
    
    t2 = new JTextField();
    t2.setBounds(200,100,150,30);
    add(t2);
    
    JLabel gender = new JLabel("Gender");
    gender.setBounds(60,140,150,30);
    gender.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(gender);
    
    c1 = new JComboBox(new String[] {"Male","Female"});
    c1.setBounds(200,140,150,30);
    c1.setBackground(Color.WHITE);
    add(c1);

    JLabel car = new JLabel("Car Company");
    car.setBounds(60,180,150,30);
    car.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(car);
    
    t3 = new JTextField();
    t3.setBounds(200,180,150,30);
    add(t3);

    JLabel model = new JLabel("Car Model");
    model.setBounds(60,220,150,30);
    model.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(model);
    
    t4 = new JTextField();
    t4.setBounds(200,220,150,30);
    add(t4);

    JLabel available = new JLabel("Available");
    available.setBounds(60,260,150,30);
    available.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(available);
    
    c2 = new JComboBox(new String[] {"Available","Busy"});
    c2.setBounds(200,260,150,30);
    c2.setBackground(Color.WHITE);
    add(c2);

    JLabel location = new JLabel("Location");
    location.setBounds(60,300,150,30);
    location.setFont(new Font("Tahoma",Font.PLAIN,13));
    add(location);
    
    t5 = new JTextField();
    t5.setBounds(200,300,150,30);
    add(t5);
    
    b1 = new JButton("Add Driver");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(60,360,130,30);
    b1.addActionListener(this);
    add(b1);

    b2 = new JButton("Cancel");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(200,360,130,30);
    b2.addActionListener(this);
    add(b2);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(300,40,700,340);
    add(l1);
    
    getContentPane().setBackground(Color.WHITE);
    
    setLayout(null);
    setBounds(200,180,950,450);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String loaction = t5.getText();
            
            conn c = new conn();
            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+loaction+"')";
            
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Successfully Added");
                this.setVisible(false);
            }catch(Exception e){
                
            }
            
            
        }else if(ae.getSource()== b2){
            setVisible(false);
        }
            
    }
    
    
    public static void main(String args[]){
        new AddDriver().setVisible(true);
    }
}
