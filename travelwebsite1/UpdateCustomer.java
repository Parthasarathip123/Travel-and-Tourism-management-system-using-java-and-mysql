
package travelwebsite1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname ;
    JComboBox comboid;
    JTextField lfnumber, lfcountry, lfadress,lfphone, lfemail,lfid,lfgender;
    JRadioButton rmale,rfemale;
    JButton add,back;
    UpdateCustomer(String username){
        setBounds(300,150,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50,15,200,25);
        text.setFont(new Font("Tahoma",Font.BOLD,16));
        add(text);
        
        
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblusername);
        
        labelusername = new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
JLabel lblid = new JLabel("ID");
lblid.setBounds(30, 90, 150, 25);
lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
add(lblid);

lfid = new JTextField();
lfid.setBounds(220, 90, 150, 25); // Adjusted the x-coordinate to prevent overlap
add(lfid);

            JLabel lblnumber = new JLabel("Number");
     lblnumber.setBounds(30,130,150,25);
        lblnumber.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblnumber);
        
        lfnumber = new JTextField();
        lfnumber.setBounds(220,130,150,25);
        add(lfnumber);
        
        JLabel lblname = new JLabel("Name");
       lblname .setBounds(30,170,150,25);
    lblname .setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblname );
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
      lblgender .setBounds(30,210,150,25);
    lblgender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblgender );
        
          lfgender = new JTextField();
        lfgender.setBounds(220,210,150,25);
        add(lfgender);
        
         JLabel lblcountry = new JLabel("Country");
     lblcountry.setBounds(30,250,150,25);
        lblcountry.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblcountry);
        
        lfcountry = new JTextField();
        lfcountry.setBounds(220,250,150,25);
        add(lfcountry);
        
        
         JLabel lbladress = new JLabel("Adress");
     lbladress.setBounds(30,290,150,25);
      lbladress.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lbladress);
        
        lfadress = new JTextField();
        lfadress.setBounds(220,290,150,25);
        add( lfadress);
        
            JLabel lblphone = new JLabel("Phone");
    lblphone.setBounds(30,330,150,25);
        lblphone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblphone);
        
        lfphone = new JTextField();
        lfphone.setBounds(220,330,150,25);
        add(lfphone);
        
        
         JLabel lblemail = new JLabel("Email");
    lblemail.setBounds(30,370,150,25);
      lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblemail);
        
        lfemail = new JTextField();
        lfemail.setBounds(220,370,150,25);
        add( lfemail);
        
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
         Image i2 = i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,400,300);
        add(image);
        
     try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username ='"+username+"'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                lfid.setText(rs.getString("id"));
                lfnumber.setText(rs.getString("number"));
                lfgender.setText(rs.getString("gender"));
                lfcountry.setText(rs.getString("country"));
                lfadress.setText(rs.getString("adress"));
                lfphone.setText(rs.getString("phone"));
                lfemail.setText(rs.getString("email"));
                
            }
        } catch (Exception e) {
            // Handle SQL exceptions properly
            e.printStackTrace(); // Temporary handling to identify the issue
        }

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        String username = labelusername.getText();
        String id = lfid.getText();
        String number = lfnumber.getText();
        String name = labelname.getText();
        String gender = lfgender.getText();
        String country = lfcountry.getText();
        String adress = lfadress.getText();
        String phone = lfphone.getText();
        String email = lfemail.getText();

        try {
            Conn c = new Conn();
            // Corrected SQL query by adding the 'VALUES' keyword
            String query = "update  customer set username = '" + username + "',id = '" + id + "',number = '" + number + "',name = '" + name + "',gender = '" + gender + "',country = '" + country + "',adress = '" + adress + "',phone = '" + phone + "',email = '" + email + "'";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer updated successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        setVisible(false);
    }
}

    public static void main(String[] args){
        new UpdateCustomer("parthasarathi");
    }
    
}
