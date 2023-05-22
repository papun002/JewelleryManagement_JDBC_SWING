 package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


 public class Customer extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, level7, booking, cus, product, name, weight, productType, description, karats, jewellprice, gram, making, discount, gst, totalprice, pricegst, serialNo;
    JTextField text, text1, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17;
    JButton back, save, update,button1,button2,button3, clear;
    JTable table;
    JPanel panel1, panel2;
    JFrame frame;
    JComboBox com,com1,com2;
    String [][] data;
    String column[];
    Conn con = new Conn();

    String username2 =  project.username2;
    String SHOP_NAME = project.SHOP_NAME;

    Customer() {

        //FRAME
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(SHOP_NAME);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

        ImageIcon background_image = new ImageIcon("wallpaperflare.com_wallpaper.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setLayout(null);
        background.setBounds(0,0,1000,600);
        add(background);

        JLabel la=new JLabel();
        la.setText("PRODUCT ORDER FORM");
        la.setHorizontalAlignment(JLabel.CENTER);
        la.setBounds(0,25,1000,30);
        la.setForeground(Color.WHITE);
        la.setFont(new Font("Bradley Hand ITC",Font.BOLD,50));
        background.add(la);



        panel2=new JPanel();
        panel2.setBounds(10,80,965,466);
        panel2.setBackground(new Color(10, 167, 167, 144));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel2.setLayout(null);
        background.add(panel2);

        Font f = new Font("serif",Font.PLAIN,17);

        cus = new JLabel("--CUSTOMER--");
        cus.setFont(new Font("Bahnschrift Light", Font.PLAIN, 15));
        cus.setForeground(Color.WHITE);
        cus.setBounds(100, 40, 150, 30);
        panel2.add(cus);

        label1 = new JLabel("Customer Name:");
        label1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(20, 80, 150, 30);
        panel2.add(label1);
        text = new JTextField();
        text.setBounds(150, 80, 250, 27);
        text.setFont(f);
        panel2.add(text);

        label2 = new JLabel("Address:");
        label2.setFont(new Font("Berlin Sans FB", Font.PLAIN ,16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(20, 120, 100, 30);
        panel2.add(label2);
        text1 = new JTextField();
        text1.setBounds(150, 120, 250, 27);
        text1.setFont(f);
        panel2.add(text1);

        label3 = new JLabel("Mob No.:");
        label3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        label3.setBounds(20, 160, 100, 30);
        label3.setForeground(Color.WHITE);
        panel2.add(label3);
        text3 = new JTextField();
        text3.setBounds(150, 160, 250, 27);
        text3.setFont(f);
        panel2.add(text3);

        booking = new JLabel("--DETAILS--");
        booking.setFont(new Font("Bahnschrift Light", Font.PLAIN, 15));
        booking.setForeground(Color.WHITE);
        booking.setBounds(100, 200, 100, 30);
        panel2.add(booking);

        label4 = new JLabel("Date:");
        label4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        label4.setForeground(Color.WHITE);
        label4.setBounds(20, 240, 130, 30);
        panel2.add(label4);

        String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        com = new JComboBox(date);
        com.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        com.setBounds(150, 240, 50, 25);
        com.setBackground(Color.white);
        com.setForeground(Color.BLACK);
        panel2.add(com);

        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        com1 = new JComboBox(month);
        com1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
        com1.setBounds(205, 240, 100, 25);
        com1.setBackground(Color.white);
        com1.setForeground(Color.BLACK);
        panel2.add(com1);

        String[] year = {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051"};
        com2 = new JComboBox(year);
        com2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
        com2.setBounds(310, 240, 91, 25);
        com2.setBackground(Color.white);
        com2.setForeground(Color.BLACK);
        panel2.add(com2);

        label5 = new JLabel("Bill No:");
        label5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        label5.setBounds(20, 280, 150, 30);
        label5.setForeground(Color.WHITE);
        panel2.add(label5);
        text5 = new JTextField();
        text5.setBounds(150, 280, 100, 27);
        text5.setFont(f);
        text5.setForeground(Color.BLACK);
//        String query10=" select '"+username2+"'.cust_bill from '"+username2+"' where username='"+username2+"';";
//        try {
//            ResultSet resultSet=con.sta.executeQuery(query10);
//            if (resultSet.next()){
//                String rs=resultSet.getString(1);
//                text5.setText(rs);
//
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        panel2.add(text5);


        product = new JLabel("--PRODUCT--");
        product.setFont(new Font("Bahnschrift Light", Font.PLAIN, 15));
        product.setForeground(Color.WHITE);
        product.setBounds(600, 40, 150, 30);
        panel2.add(product);

        productType = new JLabel("Product Type:");
        productType.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        productType.setForeground(Color.WHITE);
        productType.setBounds(500,80 , 150, 30);
        panel2.add(productType);
        text6 = new JTextField();
        text6.setFont(f);
        text6.setBounds(630, 80, 100, 27);
        panel2.add(text6);

        name = new JLabel("Product Name:");
        name.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        name.setBounds(500, 120, 150, 30);
        name.setForeground(Color.WHITE);
        panel2.add(name);

        text7 = new JTextField();
        text7.setBounds(630, 120, 100, 27);
        text7.setFont(f);
        panel2.add(text7);

        karats = new JLabel("Karats:");
        karats.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        karats.setBounds(750, 80, 150, 30);
        karats.setForeground(Color.WHITE);
        panel2.add(karats);
        text8 = new JTextField();
        text8.setFont(f);
        text8.setText("916");
        text8.setEditable(false);
        text8.setBounds(810, 80, 110, 26);
        panel2.add(text8);

        weight = new JLabel("Weight(gm) :");
        weight.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        weight.setBounds(750, 120, 155, 30);
        weight.setForeground(Color.WHITE);
        panel2.add(weight);

        text9 = new JTextField();
        text9.setFont(f);
        text9.setBounds(850, 120, 70, 26);
        panel2.add(text9);

        description = new JLabel("Description:");
        description.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        description.setBounds(500, 160, 180, 30);
        description.setForeground(Color.WHITE);
        panel2.add(description);
        text10 = new JTextField();
        text10.setBounds(630, 160, 290, 27);
        text10.setFont(f);
        panel2.add(text10);

        jewellprice = new JLabel("--JEWELLERY DETAILS--");
        jewellprice.setFont(new Font("Bahnschrift Light", Font.PLAIN, 15));
        jewellprice.setBounds(600, 200, 250, 30);
        jewellprice.setForeground(Color.WHITE);
        panel2.add(jewellprice);

        gram = new JLabel("Per Gram Price :");
        gram.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        gram.setBounds(500, 240, 120, 30);
        gram.setForeground(Color.WHITE);
        panel2.add(gram);
        text11 = new JTextField();
        text11.setFont(f);
        text11.setBounds(630, 240, 100, 27);
        panel2.add(text11);

        making = new JLabel("Making :");
        making.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        making.setBounds(500, 280, 120, 30);
        making.setForeground(Color.WHITE);
        panel2.add(making);
        text12 = new JTextField();
        text12.setBounds(630, 280, 100, 27);
        text12.setFont(f);
        panel2.add(text12);



        discount = new JLabel("Discount:");
        discount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        discount.setForeground(Color.WHITE);
        discount.setBounds(750, 240, 100, 30);
        panel2.add(discount);
        text13 = new JTextField();
        text13.setFont(f);
        text13.setBounds(825, 240, 95, 27);
        panel2.add(text13);

        gst = new JLabel("GST 3% :");
        gst.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        gst.setBounds(750, 280, 100, 30);
        gst.setForeground(Color.WHITE);
        panel2.add(gst);
        text14 = new JTextField();
        text14.setFont(f);
        text14.setBounds(825, 280, 95, 27);
        panel2.add(text14);


        totalprice = new JLabel("Total :");
        totalprice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        totalprice.setBounds(500, 320, 180, 30);
        totalprice.setForeground(Color.WHITE);
        panel2.add(totalprice);
        text15 = new JFormattedTextField();
        text15.setBounds(630, 320, 290, 27);
        text15.setFont(f);
        panel2.add(text15);

        pricegst = new JLabel("Gr.Total(Applying GST):");
        pricegst.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        pricegst.setBounds(500, 360, 350, 30);
        pricegst.setForeground(Color.WHITE);
        panel2.add(pricegst);
        text16 = new JTextField();
        text16.setBounds(680, 360, 241, 27);
        text16.setFont(f);
        panel2.add(text16);

        ImageIcon ImageIcon = new ImageIcon(new ImageIcon("calculator (2).png").getImage().getScaledInstance(26, 20, Image.SCALE_DEFAULT));
        button1 = new JButton(ImageIcon);
        button1.setBounds(925, 286, 19, 20);
        button1.setToolTipText("calculate");
        button1.setFocusable(false);
        button1.setOpaque(false);
        button1.setBorderPainted(false);
        panel2.add(button1);
        button1.addActionListener(this);

        button2 = new JButton(ImageIcon);
        button2.setBounds(925, 326, 20, 20);
        button2.setToolTipText("calculate");
        button2.setFocusable(false);
        panel2.add(button2);
        button2.addActionListener(this);

        button3 = new JButton(ImageIcon);
        button3.setBounds(925, 366, 20, 20);
        button3.setToolTipText("calculate");
        button3.setFocusable(false);
        panel2.add(button3);
        button3.addActionListener(this);


        save = new JButton("Save");
        save.setBounds(600, 420, 100, 30);
        save.addActionListener(this);
//        save.setBorderPainted(false);
        save.setFocusable(false);
        save.setBackground(new Color(229, 200, 13));
        panel2.add(save);

        back = new JButton("Back");
        back.setBounds(200, 420, 100, 30);
        back.addActionListener(this);
//        back.setBorderPainted(false);
        back.setFocusable(false);
        back.setBackground(new Color(229, 200, 13));
        panel2.add(back);

        clear = new JButton("Clear");
        clear.setBounds(400, 420, 100, 30);
        clear.addActionListener(this);
        clear.setBorderPainted(false);
        clear.setFocusable(false);
        clear.setBackground(new Color(229, 200, 13));
        panel2.add(clear);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Home();
            setVisible(false);

        } else if (e.getSource() == save) {
            files();
        } else if (e.getSource()==button2){
            String goldWt = text9.getText();
            double goldWeight= Double.parseDouble(goldWt);
            String goldGm = text11.getText();
            double goldGram= Double.parseDouble(goldGm);
            String goldMak = text12.getText();
            double goldMaking= Double.parseDouble(goldMak);
            double total = (goldGram+goldMaking)*goldWeight;
            text15.setText(String.valueOf(total));
        }else if(e.getSource()==button1){
            String goldTotal = text15.getText();
            double goldtotal1= Double.parseDouble(goldTotal);
            double Gst=0.03f*goldtotal1;
            text14.setColumns(10);
            text14.setText(String.valueOf(Gst));

        }else if(e.getSource()==button3){
            String gold_Dis = text13.getText();
            double goldDiscount;
            if(gold_Dis.isEmpty()){
                goldDiscount = 0;
            }else{
                goldDiscount= Double.parseDouble(gold_Dis);
            }
            String goldGst = text14.getText();
            double goldGst1= Double.parseDouble(goldGst);
            String goldTotal = text15.getText();
            double goldtotal1= Double.parseDouble(goldTotal);
           double GrandTotal1=(goldtotal1+goldGst1)-goldDiscount;
           text16.setText(String.valueOf(GrandTotal1));
        }else if(e.getSource()==clear){
            text.setText("");
            text1.setText("");
            text3.setText("");
            text5.setText("");
            text6.setText("");
            text7.setText("");
            text8.setText("");
            text9.setText("");
            text10.setText("");
            text11.setText("");
            text12.setText("");
            text13.setText("");
            text14.setText("");
            text15.setText("");
            text16.setText("");

        }

    }

    void files() {
        if (text.getText().isEmpty() || text1.getText().isEmpty() || text3.getText().isEmpty() || text5.getText().isEmpty() || text6.getText().isEmpty() || text7.getText().isEmpty() || text8.getText().isEmpty() || text9.getText().isEmpty()  || text11.getText().isEmpty() || text12.getText().isEmpty() || text14.getText().isEmpty() || text15.getText().isEmpty() || text16.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill up all details", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nameCust = text.getText();
            String addCust = text1.getText();
            String custMob = text3.getText();
            String custDate = (String) com2.getSelectedItem() + "-" + com1.getSelectedItem() + "-" + com.getSelectedItem();
            String custBill = text5.getText();
            String goldProduct = text6.getText();
            String goldName = text7.getText();
            String goldK = text8.getText();
            String goldWt = text9.getText();
            String goldDis = text10.getText();
            String goldGm = text11.getText();
            String goldMak = text12.getText();
            String gold_Dis = text13.getText();
            double goldDiscount;
            if (gold_Dis.isEmpty()) {
                goldDiscount = 0;
            } else {
                goldDiscount = Double.parseDouble(gold_Dis);
            }
            String goldGst = text14.getText();
            String goldTotal = text15.getText();
            String goldGrtotal = text16.getText();


            String query5 = "select * from information_schema.tables where table_schema='jm' and table_name='" + username2 + "';";
            try {
                ResultSet rs2 = con.sta.executeQuery(query5);
                if (rs2.next()) {
                    String query4 = "select * from "+username2+" where cust_bill="+custBill+" and cust_name='"+nameCust+"' and mob_no="+custMob+" and username='"+username2+"';";
                    ResultSet rs3 = con.sta.executeQuery(query4);
                    if (rs3.next()) {

                        //Check whether item table is present or not---------------------
                        String query6 = "select * from information_schema.tables where table_schema='jm' and table_name='item_" + username2 + "';";
                        ResultSet rs4 = con.sta.executeQuery(query6);
                        if (rs4.next()) {
                            String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                            int insertQuery = con.sta.executeUpdate(query1);
                            System.out.println(insertQuery + " row/s updated");
                            JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                            text7.setText("");
                            text9.setText("");
                            text10.setText("");
                            text12.setText("");
                            text13.setText("");
                            text14.setText("");
                            text15.setText("");
                            text16.setText("");
                        } else {
                            String insertQuery2 = "create table item_" + username2 + " (date varchar(100) not null, cust_Bill decimal(10,0) not null,gold_Product varchar(50) not null,gold_Name varchar(50) not null,gold_karate decimal(10,2) not null, weight decimal(10,2) not null,gold_describe varchar(1000) ,per_gram decimal(10,2) not null ,making_charge decimal(10,2) not null,discount decimal(10,2) not null,total decimal(10,2) not null , gst decimal(10,2) not null,grand_total decimal(20,2) not null,foreign key (cust_Bill) references " + username2 + "(cust_Bill) );";
                            try {
                                int query3 = con.sta.executeUpdate(insertQuery2);
                                System.out.println(query3 + "row/s updated");

                                String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                                try {
                                    int insertQuery = con.sta.executeUpdate(query1);
                                    System.out.println(insertQuery + " row/s updated");
                                    JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                    text7.setText("");
                                    text9.setText("");
                                    text10.setText("");
                                    text12.setText("");
                                    text13.setText("");
                                    text14.setText("");
                                    text15.setText("");
                                    text16.setText("");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Sorry, data not inserted..");
                                    JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Sorry, data not inserted..");
                                JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        //GST table creation
                        String query = "insert into " + username2 + " values('" + custDate + "','" + nameCust + "'," + custBill + "," + custMob + ",'" + addCust + "','" + username2 + "');";
                        try {
                            int insertQuery = con.sta.executeUpdate(query);
                            System.out.println(insertQuery + " row/s updated");

                            //Check whether item table is present or not---------------------
                            String query6 = "select * from information_schema.tables where table_schema='jm' and table_name='item_" + username2 + "';";
                            ResultSet rs4 = con.sta.executeQuery(query6);
                            if (rs4.next()) {
                                String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                                int insertQuery1 = con.sta.executeUpdate(query1);
                                System.out.println(insertQuery1 + " row/s updated");
                                JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                text7.setText("");
                                text9.setText("");
                                text10.setText("");
                                text12.setText("");
                                text13.setText("");
                                text14.setText("");
                                text15.setText("");
                                text16.setText("");
                            } else {
                                String insertQuery2 = "create table item_" + username2 + " (date varchar(100) not null, cust_Bill decimal(10,0) not null,gold_Product varchar(50) not null,gold_Name varchar(50) not null,gold_karate decimal(10,2) not null, weight decimal(10,2) not null,gold_describe varchar(1000) ,per_gram decimal(10,2) not null ,making_charge decimal(10,2) not null,discount decimal(10,2) not null,total decimal(10,2) not null , gst decimal(10,2) not null,grand_total decimal(20,2) not null,foreign key (cust_Bill) references " + username2 + "(cust_Bill) );";
                                try {
                                    int query3 = con.sta.executeUpdate(insertQuery2);
                                    System.out.println(query3 + "row/s updated");

                                    String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                                    try {
                                        int insertQuery3 = con.sta.executeUpdate(query1);
                                        System.out.println(insertQuery3 + " row/s updated");
                                        JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                        text7.setText("");
                                        text9.setText("");
                                        text10.setText("");
                                        text12.setText("");
                                        text13.setText("");
                                        text14.setText("");
                                        text15.setText("");
                                        text16.setText("");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.out.println("Sorry, data not inserted..");
                                        JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Sorry, data not inserted..");
                                    JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Sorry, data not inserted..");
                            JOptionPane.showMessageDialog(this, "This bill no is expires, create new one", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    //GST table creation-----------------------
                    String query3 = " create table " + username2 + "(date varchar(100) not null, cust_name varchar(100) not null, cust_Bill decimal(10,0) primary key, mob_no decimal(10,0) not null, address varchar(1000) not null, UserName varchar(100) not null, foreign key (UserName) references signup(UserName) );";
                    try {
                        int insertQuery3 = con.sta.executeUpdate(query3);
                        System.out.println(insertQuery3 + "row/s updated");

                        String query = "insert into " + username2 + " values('" + custDate + "','" + nameCust + "'," + custBill + "," + custMob + ",'" + addCust + "','" + username2 + "');";
                        try {
                            int insertQuery = con.sta.executeUpdate(query);
                            System.out.println(insertQuery + " row/s updated");

                            //Check whether item table is present or not---------------------
                            String query6 = "select * from information_schema.tables where table_schema='jm' and table_name='item_" + username2 + "';";
                            ResultSet rs4 = con.sta.executeQuery(query6);
                            if (rs4.next()) {
                                String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                                int insertQuery1 = con.sta.executeUpdate(query1);
                                System.out.println(insertQuery1 + " row/s updated");
                                JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                text7.setText("");
                                text9.setText("");
                                text10.setText("");
                                text12.setText("");
                                text13.setText("");
                                text14.setText("");
                                text15.setText("");
                                text16.setText("");
                            } else {
                                String insertQuery2 = "create table item_" + username2 + " (date varchar(100) not null, cust_Bill decimal(10,0) not null,gold_Product varchar(50) not null,gold_Name varchar(50) not null,gold_karate decimal(10,2) not null, weight decimal(10,2) not null,gold_describe varchar(1000) ,per_gram decimal(10,2) not null ,making_charge decimal(10,2) not null,discount decimal(10,2) not null,total decimal(10,2) not null , gst decimal(10,2) not null,grand_total decimal(20,2) not null,foreign key (cust_Bill) references " + username2 + "(cust_Bill) );";
                                try {
                                    int query7 = con.sta.executeUpdate(insertQuery2);
                                    System.out.println(query7 + "row/s updated");

                                    String query1 = "insert into item_" + username2 + " values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
                                    try {
                                        int insertQuery6 = con.sta.executeUpdate(query1);
                                        System.out.println(insertQuery6 + " row/s updated");
                                        JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                        text7.setText("");
                                        text9.setText("");
                                        text10.setText("");
                                        text12.setText("");
                                        text13.setText("");
                                        text14.setText("");
                                        text15.setText("");
                                        text16.setText("");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.out.println("Sorry, data not inserted..");
                                        JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Sorry, data not inserted..");
                                    JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Sorry, data not inserted..");
                            JOptionPane.showMessageDialog(this, "Data Already Inserted, Press Update", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


//                ResultSet rs = con.sta.executeQuery(query4);
//                if(rs.next()){
//                    String query1 = "insert into item_"+username2+" values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
//                    try {
//                        int insertQuery = con.sta.executeUpdate(query1);
//                        System.out.println(insertQuery + " row/s updated");
//                        JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
//                        text7.setText("");
//                        text9.setText("");
//                        text10.setText("");
//                        text12.setText("");
//                        text13.setText("");
//                        text14.setText("");
//                        text15.setText("");
//                        text16.setText("");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.out.println("Sorry, data not inserted..");
//                        JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } else {
//                    String query = "insert into "+username2+" values('" + custDate + "','" + nameCust + "'," + custBill + "," + custMob + ",'" + addCust + "','" + username2 + "');";
//                    try {
//                        int insertQuery = con.sta.executeUpdate(query);
//                        System.out.println(insertQuery + " row/s updated");
////                        JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.out.println("Sorry, data not inserted..");
//                        JOptionPane.showMessageDialog(this, "Data Already Inserted, Press Update", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                    String insertQuery2 = "create table item_"+username2+" (date varchar(100) not null, cust_Bill decimal(10,0) not null,gold_Product varchar(50) not null,gold_Name varchar(50) not null,gold_karate decimal(10,2) not null, weight decimal(10,2) not null,gold_describe varchar(1000) ,per_gram decimal(10,2) not null ,making_charge decimal(10,2) not null,discount decimal(10,2) not null,total decimal(10,2) not null , gst decimal(10,2) not null,grand_total decimal(20,2) not null,foreign key (cust_Bill) references "+username2+"(cust_Bill) );";
//                    try{
//                        int query3 = con.sta.executeUpdate(insertQuery2);
//                        System.out.println(query3+"row/s updated");
//
//                        String query1 = "insert into item_"+username2+" values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + goldDiscount + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
//                        try {
//                            int insertQuery = con.sta.executeUpdate(query1);
//                            System.out.println(insertQuery + " row/s updated");
//                            JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
//                            text7.setText("");
//                            text9.setText("");
//                            text10.setText("");
//                            text12.setText("");
//                            text13.setText("");
//                            text14.setText("");
//                            text15.setText("");
//                            text16.setText("");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            System.out.println("Sorry, data not inserted..");
//                            JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
//                        }
//
//                    } catch(Exception e){
//                        e.printStackTrace();
//                    }
//
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//
//

//        }
//    }

//    void update() {
//        if(text.getText().isEmpty() ||text1.getText().isEmpty() ||text3.getText().isEmpty() ||text5.getText().isEmpty() ||text6.getText().isEmpty() ||text7.getText().isEmpty() ||text8.getText().isEmpty() ||text9.getText().isEmpty() ||text10.getText().isEmpty() ||text11.getText().isEmpty() ||text12.getText().isEmpty() ||text13.getText().isEmpty() ||text14.getText().isEmpty() ||text15.getText().isEmpty() ||text16.getText().isEmpty() ){
//            JOptionPane.showMessageDialog(this,"Fill up all details","Error",JOptionPane.ERROR_MESSAGE);
//        }else {
//            String custDate = (String) com2.getSelectedItem() + "-" + com1.getSelectedItem() + "-" + com.getSelectedItem();
//            String custBill = text5.getText();
//            String goldProduct = text6.getText();
//            String goldName = text7.getText();
//            String goldK = text8.getText();
//            String goldWt = text9.getText();
//            String goldDis = text10.getText();
//            String goldGm = text11.getText();
//            String goldMak = text12.getText();
//            String gold_Dis = text13.getText();
//            String goldGst = text14.getText();
//            String goldTotal = text15.getText();
//            String goldGrtotal = text16.getText();
//
//            String insertQuery2 = "create table upload_"+username2+" (date varchar(100) not null, cust_Bill decimal(10,0) not null,gold_Product varchar(50) not null,gold_Name varchar(50) not null,gold_karate decimal(10,2) not null, weight decimal(10,2) not null,gold_describe varchar(1000) ,per_gram decimal(10,2) not null ,making_charge decimal(10,2) not null,discount decimal(10,2) not null,total decimal(10,2) not null , gst decimal(10,2) not null,grand_total decimal(20,2) not null,foreign key (cust_Bill) references "+username2+"(cust_Bill) );";
//            try{
//                int query3 = con.sta.executeUpdate(insertQuery2);
//                System.out.println(query3+"row/s updated");
//            } catch(Exception e){
//                e.printStackTrace();
//            }
//
//            String query = "insert into upload_"+username2+" values('" + custDate + "'," + custBill + ",'" + goldProduct + "','" + goldName + "'," + goldK + "," + goldWt + ",'" + goldDis + "'," + goldGm + "," + goldMak + "," + gold_Dis + "," + goldTotal + "," + goldGst + "," + goldGrtotal + ");";
//            try {
//                int insertQuery = con.sta.executeUpdate(query);
//                System.out.println(insertQuery + " row/s updated");
//                JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
//                text7.setText("");
//                text9.setText("");
//                text10.setText("");
//                text12.setText("");
//                text13.setText("");
//                text14.setText("");
//                text15.setText("");
//                text16.setText("");
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Sorry, data not inserted..");
//                JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }


    public static void main(String[] args) {
         new Customer();
    }
}
