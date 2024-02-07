/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelwebsite1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomers extends JFrame implements ActionListener{
    JLabel labelusername,labelname ;
    JComboBox comboid;
    JTextField lfnumber, lfcountry, lfadress,lfphone, lfemail;
    JRadioButton rmale,rfemale;
    JButton add,back;
    AddCustomers(String username){
        setBounds(300,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblusername);
        
        labelusername = new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
         JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        lblid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblid);
        
        comboid = new JComboBox(new String[]{"passport","Aadhar card","Pan card","Ration card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        labelname = new JLabel("");
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
      lblgender .setBounds(30,210,150,25);
    lblgender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblgender );
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add");
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
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
         Image i2 = i1.getImage().getScaledInstance(350, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        
     try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM account WHERE username ='"+username+"'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
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
        String id = (String) comboid.getSelectedItem();
        String number = lfnumber.getText();
        String name = labelname.getText();
        String gender = null;
        if (rmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String country = lfcountry.getText();
        String adress = lfadress.getText();
        String phone = lfphone.getText();
        String email = lfemail.getText();

        try {
            Conn c = new Conn();
            // Corrected SQL query by adding the 'VALUES' keyword
            String query = "INSERT INTO customer VALUES ('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + adress + "','" + phone + "','" + email + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer added successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        setVisible(false);
    }
}

    public static void main(String[] args){
        new AddCustomers("parthasarathi");
    }
    
}
