
package travelwebsite1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
     ViewPackage(String username) {
        setBounds(300,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,300,30);
        add(text);
        
         JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
          JLabel lblid  = new JLabel("Package");
       lblid .setBounds(30,90,150,25);
        add(lblid );
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        JLabel lblnumber  = new JLabel("Total Person");
       lblnumber .setBounds(30,130,150,25);
        add(lblnumber );
        
        JLabel labelpersons = new JLabel();
       labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
         JLabel lblname  = new JLabel("ID");
       lblname .setBounds(30,170,150,25);
        add(lblname);
        
        JLabel labelid = new JLabel();
        labelid .setBounds(220,170,150,25);
        add(labelid );
        
         JLabel lblpackage  = new JLabel("Number");
    lblpackage .setBounds(30,210,150,25);
        add(lblpackage);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber );
        
         JLabel lblgender  = new JLabel("Phone");
       lblgender .setBounds(30,250,150,25);
        add(lblgender);
        
        JLabel labelphone = new JLabel();
        labelphone .setBounds(220,250,150,25);
        add(labelphone );
        
         JLabel lblcountry  = new JLabel("Price");
       lblcountry .setBounds(30,290,150,25);
        add(lblcountry);
        
        JLabel labeltotal = new JLabel();
        labeltotal.setBounds(220,290,150,25);
        add(labeltotal);
        
      
        
        
        
         back = new JButton("back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookeddetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        
        
        try{
            Conn conn  = new Conn();
            String query  = "select * from bookpackage where username = '"+username+"'";
           ResultSet rs =  conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelpackage.setText(rs.getString("package"));
               labeltotal.setText(rs.getString("total"));
               labelpersons.setText(rs.getString("persons"));
               labelphone.setText(rs.getString("phone"));
               labelnumber.setText(rs.getString("Number"));
               
               
           }
         
            
        }catch(Exception e){
            
        }
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        // Create an instance of ViewCustomer with a title
        new ViewPackage("parthasarathi");
    }
}
