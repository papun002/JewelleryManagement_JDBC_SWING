package com.company;

import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

                  // access  all the properties of project cls

public class shopz extends JFrame implements ActionListener {
    JButton back, button1, button2, button3,update, button5, button6, button7, button8;
    JTextField text1, text2, text3, text4, text5, text6, text7;
    JFrame frame;
    JLabel Address, SName, OName, MobileNo, EMail, GstNo, Hallmark;
    Conn con = new Conn();
    String Add, Hall, Name, ShopName, Mobile, Email;
    JPanel panel2;
    String username2 = project.username2;
    String SHOP_NAME = project.SHOP_NAME;

    shopz() {
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(SHOP_NAME);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

        ImageIcon background_image = new ImageIcon("wallpaperflare.com_wallpaper.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setLayout(null);
        background.setBounds(0,0,800,600);
        add(background);

        panel2=new JPanel();
        panel2.setBounds(50,100,680,420);
        panel2.setBackground(new Color(10, 167, 167, 144));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel2.setLayout(null);
        background.add(panel2);

        Font fv = new Font("Lithos Pro Regular", Font.PLAIN, 50);

        JLabel head = new JLabel("---SHOP DETAILS---");
        head.setBounds(0, 10, 800, 80);
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setForeground(new Color(0, 0, 0));
        head.setFont(fv);
        background.add(head);


        Font f = new Font("Calibri (Body)", Font.BOLD, 17);
        Font fz = new Font("serif",Font.ITALIC,17);

        SName = new JLabel(" SHOP NAME ");
        SName.setBounds(30, 30, 150, 20);
        SName.setForeground(Color.WHITE);
        SName.setFont(f);
        panel2.add(SName);

        text1 = new JTextField();
        text1.setBounds(210, 30, 400, 25);
        text1.setFont(fz);
        text1.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89),1));
        text1.setBackground(null);
//        text1.setForeground(Color.WHITE);
        text1.setEditable(false);
        String s1 = "select signup.shop_Name from signup where signup.UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s1);
            if(rs.next()){
                String r1 = rs.getString(1);
                text1.setText(r1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text1);

        OName = new JLabel("OWNER NAME ");
        OName.setBounds(30, 75, 150, 20);
        OName.setFont(f);
        OName.setForeground(Color.WHITE);
        panel2.add(OName);

        text2 = new JTextField();
        text2.setBounds(210, 75, 400, 25);
        text2.setFont(fz);
        text2.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89),1));
        text2.setBackground(null);
        text2.setEditable(false);
            String s2 = "select signup.name from signup where signup.UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s2);
            if(rs.next()){
                String r2 = rs.getString(1);
                text2.setText(r2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        panel2.add(text2);

        MobileNo = new JLabel("MOBILE NO");
        MobileNo.setBounds(30, 120, 150, 20);
        MobileNo.setFont(f);
        MobileNo.setForeground(Color.WHITE);
        panel2.add(MobileNo);

        text3 = new JTextField();
        text3.setBounds(210, 120, 400, 25);
        text3.setFont(fz);
        text3.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89), 1));
        text3.setBackground(null);
        text3.setEditable(false);
        String s3 = "select signup.Mobile_No from signup where signup.UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s3);
            if(rs.next()){
                String r3 = rs.getString(1);
                text3.setText(r3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text3);

        EMail = new JLabel("EMAIL ID");
        EMail.setBounds(30, 165, 150, 20);
        EMail.setFont(f);
        EMail.setForeground(Color.WHITE);
        panel2.add(EMail);

        text4 = new JTextField();
        text4.setBounds(210, 165, 400, 25);
        text4.setFont(fz);
        text4.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89), 1));
        text4.setBackground(null);
        text4.setEditable(false);
        String s4 = "select signup.Email from signup where signup.UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s4);
            if(rs.next()){
                String r4 = rs.getString(1);
                text4.setText(r4);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text4);


        Address = new JLabel("ADDRESS");
        Address.setBounds(30, 210, 150, 20);
        Address.setFont(f);
        Address.setForeground(Color.WHITE);
        panel2.add(Address);

        text5 = new JTextField();
        text5.setBounds(210, 210, 400, 25);
        text5.setBackground(null);
        text5.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89), 1));
        text5.setFont(fz);
        text5.setEditable(false);
        String s5 = "select signup.address from signup where UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s5);
            if(rs.next()){
                String r5 = rs.getString(1);
                text5.setText(r5);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text5);


        ImageIcon ImageIcon = new ImageIcon(new ImageIcon("edit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        button1 = new JButton(ImageIcon);
        button1.setBounds(615, 214, 20, 20);
        button1.setToolTipText("Edit");
        button1.setBorder(null);
        panel2.add(button1);
        button1.addActionListener(this);

        button5 = new JButton(ImageIcon);
        button5.setBounds(615, 30, 20, 20);
        button5.setToolTipText("Edit");
        button5.setBorder(null);
        panel2.add(button5);
        button5.addActionListener(this);

        button6 = new JButton(ImageIcon);
        button6.setBounds(615, 165, 20, 20);
        button6.setToolTipText("Edit");
        button6.setBorder(null);
        panel2.add(button6);
        button6.addActionListener(this);

        button7 = new JButton(ImageIcon);
        button7.setBounds(615, 120, 20, 20);
        button7.setToolTipText("Edit");
        button7.setBorder(null);
        panel2.add(button7);
        button7.addActionListener(this);

        button8 = new JButton(ImageIcon);
        button8.setBounds(615, 75, 20, 20);
        button8.setToolTipText("Edit");
        button8.setBorder(null);
        panel2.add(button8);
        button8.addActionListener(this);

        GstNo = new JLabel("GST NO");
        GstNo.setBounds(30, 255, 150, 20);
        GstNo.setFont(f);
        GstNo.setForeground(Color.WHITE);
        panel2.add(GstNo);

        text6 = new JTextField();
        text6.setBounds(210, 255, 400, 25);
        text6.setFont(fz);
        text6.setBackground(null);
        text6.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89), 1));
        text6.setEditable(false);
        String s6 = "select signup.GST_No from signup where signup.UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s6);
            if(rs.next()){
                String r6 = rs.getString(1);
                text6.setText(r6);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text6);

        Hallmark = new JLabel("HALLAMRK CERTIFICATE NO");
        Hallmark.setBounds(30, 300, 260, 20);
        Hallmark.setFont(f);
        Hallmark.setForeground(Color.WHITE);
        panel2.add(Hallmark);

        text7 = new JTextField();
        text7.setBounds(290, 300, 320, 25);
        text7.setFont(fz);
        text7.setBackground(null);
        text7.setBorder(BorderFactory.createLineBorder(new Color(255, 251, 251, 89),1));
        text7.setEditable(false);
        String s7 = "select signup.Hallmark_Certification_No from signup where UserName='"+username2+"';";
        try {
            ResultSet rs = con.sta.executeQuery(s7);
            if(rs.next()){
                String r7 = rs.getString(1);
                text7.setText(r7);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        panel2.add(text7);

        button3 = new JButton(ImageIcon);
        button3.setBounds(615, 304, 20, 20);
        button3.setToolTipText("Edit");
        button3.setBorder(null);
        panel2.add(button3);
        button3.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(290, 370, 100, 30);
        back.addActionListener(this);
        back.setBorderPainted(false);
        back.setBackground(new Color(229, 200, 13));
        back.setFocusable(false);
        panel2.add(back);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Home();
            setVisible(false);
        } else if (e.getSource() == button1) {
            address();
        } else if (e.getSource() == button3) {
            hall();
        } else if (e.getSource()== button8){
            name();
        } else if (e.getSource() == button5){
            shopName();
        } else if(e.getSource() == button7){
            mobile();
        } else if(e.getSource() == button6){
            email();
        }
    }

    void shopName(){
        ShopName = JOptionPane.showInputDialog(frame, "Enter Shop Name");
        if (ShopName.length()>0) {
            String query = "update signup set Shop_Name = '"+ ShopName +"' where signup.UserName='"+username2+"';";
            try {
                int insertQuery = con.sta.executeUpdate(query);
                System.out.println(insertQuery + "row/s updated");
                JOptionPane.showMessageDialog(frame, "Successfully Added", "", JOptionPane.PLAIN_MESSAGE);
                new shopz();
                setVisible(false);
            } catch (Exception a) {
                a.printStackTrace();
                System.out.println("Sorry, data not inserted..");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "sorry Shop Name cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void name(){
        Name = JOptionPane.showInputDialog(frame, "Enter Name");
        if (Name.length()>0) {
            String query = "update signup set name = '"+ Name +"' where signup.UserName='"+username2+"';";
            try {
                int insertQuery = con.sta.executeUpdate(query);
                System.out.println(insertQuery + "row/s updated");
                JOptionPane.showMessageDialog(frame, "Successfully Added", "", JOptionPane.PLAIN_MESSAGE);
                new shopz();
                setVisible(false);
            } catch (Exception a) {
                a.printStackTrace();
                System.out.println("Sorry, data not inserted..");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "sorry Name cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void mobile(){
        Mobile = JOptionPane.showInputDialog(frame, "Enter Mobile No.");
        if (Mobile.length()>0) {
            String query = "update signup set Mobile_No = '"+ Mobile +"' where signup.UserName='"+username2+"';";
            try {
                int insertQuery = con.sta.executeUpdate(query);
                System.out.println(insertQuery + "row/s updated");
                JOptionPane.showMessageDialog(frame, "Successfully Added", "", JOptionPane.PLAIN_MESSAGE);
                new shopz();
                setVisible(false);
            } catch (Exception a) {
                a.printStackTrace();
                System.out.println("Sorry, data not inserted..");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "sorry Mobile No cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void email(){
        Email = JOptionPane.showInputDialog(frame, "Enter Email.");
        if (Email.length()>0) {
            String query = "update signup set Email = '"+ Email +"' where signup.UserName='"+username2+"';";
            try {
                int insertQuery = con.sta.executeUpdate(query);
                System.out.println(insertQuery + "row/s updated");
                JOptionPane.showMessageDialog(frame, "Successfully Added", "", JOptionPane.PLAIN_MESSAGE);
                new shopz();
                setVisible(false);
            } catch (Exception a) {
                a.printStackTrace();
                System.out.println("Sorry, data not inserted..");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "sorry Email cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void address() {
        Add = JOptionPane.showInputDialog(frame, "Enter Address");
        if (Add.length()>0) {
            String query = "update signup set address = '"+Add+"' where signup.UserName='"+username2+"';";
            try {
                int insertQuery = con.sta.executeUpdate(query);
                System.out.println(insertQuery + "row/s updated");
                JOptionPane.showMessageDialog(frame, "Successfully Added", "", JOptionPane.PLAIN_MESSAGE);
                new shopz();
                setVisible(false);
            } catch (Exception a) {
                a.printStackTrace();
                System.out.println("Sorry, data not inserted..");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "sorry Address cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        void hall() {
            Hall = JOptionPane.showInputDialog(frame, "Enter Certificate No.");
                if (Hall.length()>0) {
                    String query1 = "update signup set Hallmark_Certification_No = '"+Hall+"' where signup.UserName='"+username2+"';";
                    try {
                        int insertQuery = con.sta.executeUpdate(query1);
                        System.out.println(insertQuery + "row/s updated");
                        JOptionPane.showMessageDialog(frame, "Successfully Added", "Done", JOptionPane.PLAIN_MESSAGE);
                        new shopz();
                        setVisible(false);
                    } catch (Exception a) {
                        a.printStackTrace();
                        System.out.println("Sorry, data not inserted..");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "sorry Certificate No. cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }

    public static void main (String[]args) {
        new shopz();
    }
}





