package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.project.*;

public class signup extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JTextField text1, text2, text3, text4, text5;
    JButton back, sign2;
    JFrame frame;
    Conn con = new Conn();
    String GST_Table;
    signup() {
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("JEWELLERY MANAGEMENT SYSTEM");
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

        ImageIcon backgroundimage = new ImageIcon("maxresdefault.jpg");
        Image img = backgroundimage.getImage();
        Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        backgroundimage = new ImageIcon(temp_img);
        JLabel background = new JLabel("", backgroundimage, JLabel.CENTER);
        /*
        Container c= getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

         */

        label1 = new JLabel("JEWELLERY MANAGEMENT SYSTEM");
        label1.setFont(new Font("Bauhaus 93", Font.BOLD, 42));
        label1.setForeground(Color.BLACK);
        label1.setBounds(160, 15, 800, 50);
        background.add(label1);

        label2 = new JLabel("For signing up fill up the following details.");
        label2.setFont(new Font("ariel", Font.ITALIC, 25));
        label2.setBounds(250, 50, 1000, 50);
        label2.setForeground(Color.WHITE);
        background.add((label2));

        label3 = new JLabel("Name: ");
        label3.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label3.setBounds(190, 150, 100, 35);
        label3.setForeground(Color.WHITE);
        background.add(label3);

        text1 = new JTextField();
        text1.setFont(new Font("arial", Font.PLAIN, 16));
        text1.setBounds(350, 150, 300, 35);
        text1.setForeground(Color.BLACK);
        background.add(text1);


        label4 = new JLabel("Mob No: ");
        label4.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label4.setBounds(190, 200, 150, 35);
        label4.setForeground(Color.WHITE);
        background.add(label4);

        text2 = new JTextField();
        text2.setFont(new Font("arial", Font.PLAIN, 16));
        text2.setBounds(350, 200, 300, 35);
        text2.setForeground(Color.BLACK);
        background.add(text2);

        label5 = new JLabel("Email: ");
        label5.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label5.setBounds(190, 250, 150, 35);
        label5.setForeground(Color.WHITE);
        background.add(label5);

        text3 = new JTextField();
        text3.setFont(new Font("arial", Font.PLAIN, 16));
        text3.setBounds(350, 250, 300, 35);
        text3.setForeground(Color.BLACK);
        background.add(text3);

        label6 = new JLabel("Shop Name: ");
        label6.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label6.setBounds(190, 300, 150, 35);
        label6.setForeground(Color.WHITE);
        background.add(label6);

        text4 = new JTextField();
        text4.setFont(new Font("arial", Font.PLAIN, 16));
        text4.setBounds(350, 300, 300, 35);
        text4.setForeground(Color.BLACK);
        background.add(text4);


        label7 = new JLabel("GST No:  ");
        label7.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label7.setBounds(190, 350, 150, 35);
        label7.setForeground(Color.WHITE);
        background.add(label7);

        text5 = new JTextField();
        text5.setFont(new Font("arial", Font.PLAIN, 16));
        text5.setBounds(350, 350, 300, 35);
        text5.setForeground(Color.BLACK);
        background.add(text5);


        sign2 = new JButton("Sign Up");
        sign2.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        sign2.setBounds(200, 500, 150, 40);
        sign2.setFocusable(false);
        sign2.setBorder(BorderFactory.createEtchedBorder());
        sign2.setForeground(Color.BLACK);
        sign2.addActionListener(this);
        background.add(sign2);

        back = new JButton("Back");
        back.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        back.setBounds(500, 500, 150, 40);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        background.add(back);

        background.setBounds(0, 0, 1000, 600);
        add(background);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new project();
            setVisible(false);
        } else if (e.getSource() == sign2) {
            signup();
        }
    }

    void signup() {

        if (text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty() || text4.getText().isEmpty() || text5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill up all details", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String label3 = text1.getText();
            String label4 = text2.getText();
            Long mob1=Long.parseLong(label4);
            String label5 = text3.getText();
            String label6 = text4.getText();
            GST_Table = text5.getText();

            String myquery = "select * from information_schema.tables where table_schema='jm' and table_name='signup';";
            try {
                ResultSet rs= con.sta.executeQuery(myquery);
                System.out.println(rs+"row/s updated");
                if(rs.next()) {
                    String username2 = JOptionPane.showInputDialog(frame, "Enter UserName:");
                    String password2 = JOptionPane.showInputDialog(frame, "Set Password:");
                    if (username2 == null  || password2 == null ) {
                        JOptionPane.showMessageDialog(frame, "sorry username and password cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (username2.equals(password2)) {
                            JOptionPane.showMessageDialog(frame, "Username can't be same as password , set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (password2.equals(label4)) {
                            JOptionPane.showMessageDialog(frame, "Password can't be same as mobile number, set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String query1 = "select * from signup where username='" + username2 + "';";
                            ResultSet rs5 = con.sta.executeQuery(query1);
                            if (rs5.next()) {
                                JOptionPane.showMessageDialog(frame, "Username Already exist", "Error", JOptionPane.ERROR_MESSAGE);
                            } else{

                                //passing blank value to address
                                String address = " ", hall = " ";
                            String query = "insert into signup values('" + label3 + "', " + mob1 + ",'" + label5 + "','" + label6 + "', '" + GST_Table + "','" + username2 + "','" + password2 + "','" + address + "','" + hall + "')";
                            try {
                                int insertQuery = con.sta.executeUpdate(query);
                                System.out.println(insertQuery + "row/s updated");
                                JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "", JOptionPane.PLAIN_MESSAGE);
                                new project();
                                setVisible(false);

                                //Creating Shop Table
//                                String query4 = "select * from information_schema.tables where table_schema='jm' and table_name='shop';";
//                                try {
//                                    ResultSet rs2 = con.sta.executeQuery(query4);
//                                    if (rs2.next()) {
////                                        String address=" " , hall=" ";
//                                        String query2 = "insert into shop values('"+address+"','"+hall+"','"+username2+"');";
//                                        try {
//                                            int insertQuery2 = con.sta.executeUpdate(query2);
//                                            System.out.println(insertQuery2 + "row/s updated");
//                                        }catch (Exception e){
//                                            e.printStackTrace();
//                                        }
//                                    }else{
//                                        String query6 = "create table shop (Address varchar(200), Hallmark_Certification_No varchar(100) primary key,UserName varchar(100), foreign key(UserName) references signup(UserName));";
//                                        int insertQuery4 = con.sta.executeUpdate(query6);
//                                        System.out.println(insertQuery4+"row/s updated");
//
////                                        String address=" " , hall=" ";
//                                        String query2 = "insert into shop values('"+address+"','"+hall+"','"+username2+"');";
//                                        try {
//                                            int insertQuery2 = con.sta.executeUpdate(query2);
//                                            System.out.println(insertQuery2 + "row/s updated");
//                                        }catch (Exception e){
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                }catch(Exception e){
//                                    e.printStackTrace();
//                                }

                                //GST table creation
//                                String query3 = " create table "+GST_Table+"(date varchar(100) not null,cust_name varchar(100) not null, cust_Bill decimal(10,0) primary key,mob_no decimal(10,0) not null,address varchar(1000) not null ,UserName varchar(100) not null, foreign key (UserName) references signup(UserName) );";
//                                try {
//                                    int insertQuery3 = con.sta.executeUpdate(query3);
//                                    System.out.println(insertQuery3 + "row/s updated");
//                                }catch(Exception e){
//                                    e.printStackTrace();
//                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(this, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                                System.out.println("Sorry, data not inserted..");
                                JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        }

                    }
                }else{
                    String query5 = "create table signup(Name varchar(100) not null, Mobile_No decimal(10,0) not null, Email varchar(50) not null, Shop_Name varchar(200) not null, GST_No varchar(100)not null, UserName varchar(100) primary key, password varchar(20) not null, address varchar(50) not null, Hallmark_Certification_No varchar(100) not null);";
                    try {
                        int insertQuery1 = con.sta.executeUpdate(query5);
                        System.out.println(insertQuery1+"row/s updated");
                        String username2 = JOptionPane.showInputDialog(frame, "Enter UserName:");
                        String password2 = JOptionPane.showInputDialog(frame, "Set Password:");

                        if (username2 == null || password2 == null) {
                            JOptionPane.showMessageDialog(frame, "sorry username & password cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (username2.equals(password2)) {
                                JOptionPane.showMessageDialog(frame, "Username can't be same as password , set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                            } else if (password2.equals(label4)) {
                                JOptionPane.showMessageDialog(frame, "Password can't be same as mobile number, set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                String query1 = "select * from signup where username='" + username2 + "';";
                                ResultSet rs5 = con.sta.executeQuery(query1);
                                if (rs5.next()) {
                                    JOptionPane.showMessageDialog(frame, "Username Already exist", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    //passing blank value to address
                                    String address = " ", hall = " ";
                                    String query = "insert into signup values('" + label3 + "', " + mob1 + ",'" + label5 + "','" + label6 + "', '" + GST_Table + "','" + username2 + "','" + password2 + "','" + address + "','" + hall + "')";
                                    try {
                                        int insertQuery = con.sta.executeUpdate(query);
                                        System.out.println(insertQuery + "row/s updated");
                                        JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "", JOptionPane.PLAIN_MESSAGE);
                                        new project();
                                        setVisible(false);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        JOptionPane.showMessageDialog(this, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                                        System.out.println("Sorry, data not inserted..");
                                        JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

//                                String query = "insert into signup values('" + label3 + "', " + mob1 + ",'" + label5 + "','" + label6 + "', '" + GST_Table + "','" + username2 + "','" + password2 + "')";
//                                try {
//                                    int insertQuery = con.sta.executeUpdate(query);
//                                    System.out.println(insertQuery + "row/s updated");
//                                    JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "", JOptionPane.PLAIN_MESSAGE);
//                                    new project();
//                                    setVisible(false);
//
//                                    //Creating Shop Table
//                                    String query4 = "select * from information_schema.tables where table_schema='jm'and table_name='shop';";
//                                    try {
//                                        ResultSet rs2 = con.sta.executeQuery(query4);
//                                        if (rs2.next()) {
//                                            String address=" " , hall=" ";
//                                            String query2 = "insert into shop values('"+address+"','"+hall+"','"+username2+"');";
//                                            try {
//                                                int insertQuery2 = con.sta.executeUpdate(query2);
//                                                System.out.println(insertQuery2 + "row/s updated");
//                                            }catch (Exception e){
//                                                e.printStackTrace();
//                                            }
//                                        }else{
//                                            String query6 = "create table shop (Address varchar(200), Hallmark_Certification_No varchar(100) primary key,UserName varchar(100), foreign key(UserName) references signup(UserName));";
//                                            int insertQuery4 = con.sta.executeUpdate(query6);
//                                            System.out.println(insertQuery4+"row/s updated");
//
//                                            String address=" " , hall=" ";
//                                            String query2 = "insert into shop values('"+address+"','"+hall+"','"+username2+"');";
//                                            try {
//                                                int insertQuery2 = con.sta.executeUpdate(query2);
//                                                System.out.println(insertQuery2 + "row/s updated");
//                                            }catch (Exception e){
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    }catch(Exception e){
//                                        e.printStackTrace();
//                                    }
//
//                                    String query3 = " create table "+GST_Table+"(date varchar(100) not null,cust_name varchar(100) not null, cust_Bill decimal(10,0) primary key,mob_no decimal(10,0) not null,address varchar(1000) not null ,UserName varchar(100) not null, foreign key (UserName) references signup(UserName) );";
//                                    try {
//                                        int insertQuery3 = con.sta.executeUpdate(query3);
//                                        System.out.println(insertQuery3 + "row/s updated");
//                                    }catch(Exception e){
//                                        e.printStackTrace();
//                                    }
//
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    JOptionPane.showMessageDialog(this,"Wrong Input","Error",JOptionPane.ERROR_MESSAGE);
//                                    System.out.println("Sorry, data not inserted..");
//                                    JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);
//                                }

                                }

                            }

                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            } catch (SQLException throwables) {
                       throwables.printStackTrace();
                JOptionPane.showMessageDialog(this,"Data not inserted due to some error, Please try again....","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Table not Created");
            }



        }

    }
}

















