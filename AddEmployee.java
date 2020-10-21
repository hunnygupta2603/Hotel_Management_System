
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee(){
        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,80,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60,130,120,30);
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(200,130 ,70,30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(270,130,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel job = new JLabel("JOB");
        job.setBounds(60,180,120,30);
        add(job);
        
        String str[] = {"Front desk Clerks","Porters","Housekeeping","kitchen staff","Room services","Waiter/Waiteress","Manager","Accountant"};        
        c1 = new JComboBox(str);
        c1.setBounds(200,180,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,330,120,30);
        add(aadhar);
        
        t5 = new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);
        
        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,380,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);
        
        b1 = new JButton("SUMBIT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,430,150,30);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1  = new JLabel(i3);
        l1.setBounds(380,50,450,450);
        add(l1);
        
        JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setBounds(460,20,400,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(230,150,850,510);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         String name = t1.getText();
         String age = t2.getText();
         String salary = t3.getText();
         String phone = t4.getText();
         String aadhar = t5.getText();
         String email =t6.getText();
         
         String gender = null;
         
         if(r1.isSelected()){
             gender = "Male";
         }else if(r2.isSelected()){
             gender = "Female";
         }
         
         String job = (String) c1.getSelectedItem();
         
         conn c = new conn();
         String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
         
         try{
             c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"New Employee Added");
             this.setVisible(false);
             
         }catch(Exception e){
             System.out.println(e);
         
         }
    }
    
    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
    
}
