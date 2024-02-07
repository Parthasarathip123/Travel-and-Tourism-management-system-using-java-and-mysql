/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package travelwebsite1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton viewPersonelDetails, addPersonelDetails, updatePersonelDetails,
            checkpackages, bookpackage, viewpackage,CheckHotels,destinations;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ggg.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addPersonelDetails = new JButton("Add Personel Details");
        addPersonelDetails.setBounds(0, 0, 300, 80);
        addPersonelDetails.setBackground(new Color(0, 0, 102));
        addPersonelDetails.setForeground(Color.WHITE);
        addPersonelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonelDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonelDetails.addActionListener(this);
        p2.add(addPersonelDetails);

        updatePersonelDetails = new JButton("Update Personel Details");
        updatePersonelDetails.setBounds(0, 80, 300, 80);
        updatePersonelDetails.setBackground(new Color(0, 0, 102));
        updatePersonelDetails.setForeground(Color.WHITE);
        updatePersonelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonelDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonelDetails.addActionListener(this);
        p2.add(updatePersonelDetails);

        viewPersonelDetails = new JButton("View details");
        viewPersonelDetails.setBounds(0, 160, 300, 80);
        viewPersonelDetails.setBackground(new Color(0, 0, 102));
        viewPersonelDetails.setForeground(Color.WHITE);
        viewPersonelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonelDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonelDetails.addActionListener(this);
        p2.add(viewPersonelDetails);

        checkpackages = new JButton("Check packages");
        checkpackages.setBounds(0, 240, 300, 80);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 100));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book package");
        bookpackage.setBounds(0, 320, 300, 80);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 120));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View package");
        viewpackage.setBounds(0, 400, 300, 80);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 120));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        CheckHotels = new JButton("Check Hotels");
        CheckHotels.setBounds(0, 480, 300, 80);
        CheckHotels.setBackground(new Color(0, 0, 102));
        CheckHotels.setForeground(Color.WHITE);
        CheckHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        CheckHotels.setMargin(new Insets(0, 0, 0, 130));
        CheckHotels.addActionListener(this);
        p2.add(CheckHotels);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 560, 300, 80);
        destinations.setBackground(new Color(0, 0, 102));
      destinations.setForeground(Color.WHITE);
       destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
      destinations.setMargin(new Insets(0, 0, 0, 140));
        destinations.addActionListener(this);
        p2.add(destinations);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dest4.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("TRAVEL AND TOURISM SYSTEM");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonelDetails) {
            // Handle Add Personel Details action
            new AddCustomers(username);
        } else if (ae.getSource() == viewPersonelDetails) {
            // Handle View Personel Details action
              new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonelDetails) {
            // Handle Update Personel Details action
             new UpdateCustomer(username);
        } else if (ae.getSource() == checkpackages) {
            // Handle Check Packages action
            new CheckPackage();
        } else if (ae.getSource() == bookpackage) {
            // Handle Book Package action
             new BookPackage(username);
        } else if (ae.getSource() == viewpackage) {
            // Handle View Package action
            new ViewPackage(username);
        } else if (ae.getSource() == CheckHotels) {
            // Handle Check Hotels action
            new CheckHotels();
        }else if (ae.getSource() == destinations) {
            // Handle Check Hotels action
            new destinations();
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}

//public void actionPerformed(ActionEvent ae) {
//    if (ae.getSource() == addPersonelDetails) {
//        new AddCustomers(username);
//    } else if (ae.getSource() == viewPersonelDetails) {
//        new ViewCustomer(username);
//    } else if (ae.getSource() == updatePersonelDetails) {
//        new UpdateCustomer(username);
//    } else if (ae.getSource() == checkpackages) {
//        new CheckPackage();
//    } else if (ae.getSource() == bookpackage) {
//        new BookPackage(username);
//    } else if (ae.getSource() == viewpackage) {
//        new ViewPackage(username);
//    } else if (ae.getSource() == Checkhotels) {
//        new CheckHotels();
//    }

