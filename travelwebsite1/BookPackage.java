
package travelwebsite1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.border.LineBorder;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField lfpersons;
    String username;
    JLabel labelusername,labelnumber,labelphone,labelid,labeltotal;
    JButton checkprice,bookpackage,back;
    BookPackage(String username){
        this.username = username;
        setBounds(150,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,100,20);
        add(labelusername);
        
        
          JLabel lblpackage  = new JLabel("Select Package");
          lblpackage .setFont(new Font("Tahoma",Font.PLAIN,16));
         lblpackage .setBounds(40,110,200,20);
          add(lblpackage );
        
         
          cpackage = new Choice();
          cpackage.add("GOLD PACKAGE");
          cpackage.add("SILVER PACKAGE");
          cpackage.add("BRONZE PACKAGE");
          cpackage.setBounds(250,110,200,20);
          add(cpackage);
          
        JLabel lblpersons  = new JLabel("Total Persons");
      lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblpersons .setBounds(40,150,150,25);
        add(lblpersons );
        
          lfpersons= new JTextField("1");
          lfpersons.setBounds(250,150,200,25);
          add(lfpersons);
        
         JLabel lblid  = new JLabel("ID");
         lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblid .setBounds(40,190,150,25);
        add(lblid);
        
         labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
         JLabel lblnumber  = new JLabel("Number");
          lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblnumber .setBounds(40,230,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone  = new JLabel("Phone");
        lblphone .setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,270,150,25);
        add(lblphone );
        
         labelphone = new JLabel();
         labelphone.setBounds(250,270,200,25);
        add( labelphone);
        
         JLabel lbltotal  = new JLabel("Total Price");
         lbltotal .setFont(new Font("Tahoma",Font.PLAIN,16));
      lbltotal  .setBounds(40,310,150,25);
        add(lbltotal );
        
        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,150,25);
        add(labeltotal);
        
          try{
            Conn conn  = new Conn();
            String query  = "select * from customer where username = '"+username+"'";
           ResultSet rs =  conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));            
           }    
        }catch(Exception e){
            e.printStackTrace();
        }
        checkprice = new JButton("Check Price");
         checkprice.setBounds(60, 380,120 ,25);
         checkprice.setBackground(Color.BLACK);
         checkprice.setForeground(Color.WHITE);
         checkprice.setBorder(new LineBorder(new Color(133, 193, 233)));
         checkprice.addActionListener(this);
        add( checkprice);
        
         bookpackage = new JButton("Book Package");
          bookpackage.setBounds(200, 380,120 ,25);
          bookpackage.setBackground(Color.BLACK);
          bookpackage.setForeground(Color.WHITE);
          bookpackage.setBorder(new LineBorder(new Color(133, 193, 233)));
          bookpackage.addActionListener(this);
        add(  bookpackage);
        
        back = new JButton("Back");
        back .setBounds(340, 380,120 ,25);
        back .setBackground(Color.BLACK);
        back .setForeground(Color.WHITE);
        back .setBorder(new LineBorder(new Color(133, 193, 233)));
        back.addActionListener(this);
        add(back );
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);
        
        
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == checkprice) {
        String pack = cpackage.getSelectedItem();
        int cost = 0;
        if (pack.equals("GOLD PACKAGE")) {
            cost += 12000;
        } else if (pack.equals("SILVER PACKAGE")) {
            cost += 24000;
        } else {
            cost += 32000;
        }

        int persons = Integer.parseInt(lfpersons.getText());
        cost *= persons;
        labeltotal.setText("Rs" + cost);
    } else if (ae.getSource() == bookpackage) {
         try{
             Conn c = new Conn();
             c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+lfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");
             
             JOptionPane.showMessageDialog(null,"Package booked succesfully" );
             setVisible(false);
         }catch(Exception e){
             e.printStackTrace();
         }
    } else {
        setVisible(false);
    }
}
    
    public static void main(String[] args){
        new BookPackage("parthasarathi");
    }
    
}
