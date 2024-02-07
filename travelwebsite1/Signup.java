package travelwebsite1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField lfusername,lfname,lfpassword,lfanswer;
    Choice security;
    Signup() {
        setBounds(250, 200, 800, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233)); // Add a semicolon at the end of this line
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(50,20,125,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lblusername);
        
         lfusername = new JTextField();
        lfusername.setBounds(190,20,180,25);
        lfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,60,125,25);
        lblname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lblname);
        
        lfname = new JTextField();
        lfname.setBounds(190,60,180,25);
        lfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfname);
        
         JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50,140,125,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lblpassword);
        
         lfpassword = new JTextField();
        lfpassword.setBounds(190,100,180,25);
        lfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfpassword);
        
         JLabel lblsecurity = new JLabel("Security key");
        lblsecurity.setBounds(50,100,125,25);
        lblsecurity.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("Fav charcter from the boys");
        security.add("fav marvel avenger");
        security.add("your lucky number");
          security.add("your childhood superhero");
          security.setBounds(190,140,180,25);
          p1.add(security);
          
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(50,180,125,25);
        lblanswer.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        p1.add(lblanswer);
        
        lfanswer = new JTextField();
        lfanswer.setBounds(190,180,180,25);
        lfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(lfanswer);  
        
        
        create = new JButton("Create");
        create.setBounds(230, 200,130 , 30);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(230, 200,130 , 30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,50,250,250);
        add(image);

        // Add p1 to the content pane or perform operations on p1 here

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String username = lfusername.getText();
            String name = lfname.getText();
            String password = lfpassword.getText();
            String question = security.getSelectedItem();
            String answer = lfanswer.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account created succesfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}