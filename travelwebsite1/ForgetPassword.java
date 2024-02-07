package travelwebsite1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField lfusername, lfname, lfquestion, lfanswer, lfpassword;
    JButton search, retrieve, back;
    
    ForgetPassword() {
        setBounds(300, 200, 900, 360); // Increased width of the JFrame
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 600, 260); // Adjusted the panel width
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650, 40, 200, 200); // Adjusted image position
        add(image);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(lblusername);
        
        lfusername = new JTextField();
        lfusername.setBounds(220, 20, 150, 25);
        lfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(lblname);
        
        lfname = new JTextField();
        lfname.setBounds(220, 60, 150, 25);
        lfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfname);
        
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40, 100, 150, 25);
        lblquestion.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(lblquestion);
        
        lfquestion = new JTextField();
        lfquestion.setBounds(220, 100, 150, 25);
        lfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfquestion);
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 140, 100, 25);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(lblanswer);
        
        lfanswer = new JTextField();
        lfanswer.setBounds(220, 140, 150, 25);
        lfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfanswer);
        
        retrieve = new JButton("retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 180, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p1.add(lblpassword);
        
        lfpassword = new JTextField();
        lfpassword.setBounds(220, 180, 150, 25);
        lfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            try{
                String query = "select * from account where username = '"+lfusername.getText()+"'";
                Conn c = new Conn();
                
               ResultSet rs =  c.s.executeQuery(query);
               while(rs.next()){
                 lfname.setText(rs.getString("name"));
                 lfquestion.setText(rs.getString("security"));
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() ==  retrieve){
            try {
    String query = "select * from account where answer = '"+lfanswer.getText()+"' AND username = '"+lfusername.getText()+"'";
    Conn c = new Conn();
    
    ResultSet rs = c.s.executeQuery(query);
    while(rs.next()) {
        lfpassword.setText(rs.getString("password"));
    }
    } catch(Exception e) {
         System.out.println("i am not getting");
     }
        }else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
