package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class project extends JFrame implements ActionListener {
    JButton log_button;
    JButton signup;
    JPanel heading, login;
    JLabel name;
    JTextField username;
    JPasswordField password;
    public static String username2, password2;
    public static String GST_Inner_Table ;
    public static String SHOP_NAME ;


    project() {

        //FONT
        Font f = new Font("Serif", Font.BOLD, 30);
        //HEADER
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 1000, 100);
        heading.setLayout(null);

        name = new JLabel();
        name.setText("JEWELLERY MANAGEMENT SYSTEM");
        name.setForeground(Color.WHITE);
        name.setBounds(0,20,1000,50);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Bradley Hand ITC",Font.BOLD,45));
        heading.add(name);


        //LOGIN PANEL
        login = new JPanel();
        login.setLayout(null);
        login.setSize(400, 350);
        login.setBackground(new Color(0, 0, 0, 60));
        login.setBounds(280, 175, 400, 350);

        username = new JTextField();
        username.setBackground(new Color(200, 180, 140));
        username.setForeground(Color.WHITE);
        username.setBorder(null);
        username.setOpaque(true);
        username.setBounds(50, 50, 300, 40);
        username.setText("Enter Your Username");
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(username.getText().equals("Enter Your Username")){
                    username.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(username.getText().equals("")){
                    username.setText("Enter Your Username");
                }

            }
        });
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(200, 180, 140));
        password.setForeground(Color.WHITE);
        password.setOpaque(true);
        password.setBorder(null);
        password.setBounds(50, 150, 300, 40);
        password.setText("Enter Your Password");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(password.getText().equals("Enter Your Password")){
                    password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(password.getText().equals("")){
                    password.setText("Enter Your Password");
                }


            }
        });
        login.add(password);

        signup = new JButton("Sign Up");
        signup.setBounds(50, 250, 100, 50);
        signup.setBackground(new Color(160, 182, 45));
        signup.addActionListener(this);
        login.add(signup);

        log_button = new JButton("Login");
        log_button.setBounds(250, 250, 100, 50);
        log_button.setBackground(new Color(160, 182, 45));
        log_button.addActionListener(this);
        login.add(log_button);


        //FRAME
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());
        setTitle("JEWELLERY MANAGEMENT SYSTEM");

        //BACKGROUND
        ImageIcon background_image = new ImageIcon("bulbul-ahmed-IsWq1oWhVNU-unsplash.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1000, 600);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log_button) {
            login();
        }
        if(e.getSource()==signup)
        {
            SignUp();
            setVisible(false);
        }
    }

    void SignUp(){
        new signup();
//        username2 = username.getText();
//        password2 = password.getText();
//
//        Conn conn = new Conn();
//        String query = "select * from signup where UserName='"+username2+"' and password='"+password2+"';";
//        try {
//            ResultSet rs = conn.sta.executeQuery(query);
//            if(rs.next()){
//                JOptionPane.showMessageDialog(this, "Account already exist....", "Error",JOptionPane.ERROR_MESSAGE);
//                int a = JOptionPane.showConfirmDialog(this, "Do You want to login...? ","",JOptionPane.QUESTION_MESSAGE);
//                if(a == JOptionPane.YES_OPTION){
//                    new Home();
//                    setVisible(false);
//                }
//            }else {
//                new signup();
//            }
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Account doesn't exist", "Error",JOptionPane.ERROR_MESSAGE);
//        }
    }

    void login(){
        username2 = username.getText();
        password2 = password.getText();

        Conn conn = new Conn();
        String query = "select * from signup where UserName='"+username2+"' and password='"+password2+"';";
        try {
            ResultSet rs = conn.sta.executeQuery(query);
            if(rs.next()){
//                String a = "select GST_No from signup where UserName='"+username2+"' and password='"+password2+"';";
//                ResultSet rs2 = conn.sta.executeQuery(a);
//                if(rs2.next()){
//                    String result = rs2.getString(1);
//                    GST_Inner_Table = result;
//                }

                String b = "select Shop_Name from signup where UserName='"+username2+"' and password='"+password2+"';";
                ResultSet rs3 = conn.sta.executeQuery(b);
                if(rs3.next()){
                    String result2 = rs3.getString(1);
                    SHOP_NAME = result2;
                }

                new Home();
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Account doesn't exist", "Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(this, "Some Error Occurred...", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}














