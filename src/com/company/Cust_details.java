package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import static com.company.project.*;

public class Cust_details extends JFrame implements ActionListener {
    JButton back,submit,back2,back3,back4,back5, more, clear;
    JTextField  text,text1,text2,text3;
    JLabel label1,label2,label3;
    JFrame frame1,frame2;
    JTextArea area;
    JPanel panel, panel2, panel3;
    Conn con = new Conn();
    JLabel background;
    Cust_details(){
    setSize(1000, 600);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
        setTitle(SHOP_NAME);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

    ImageIcon background_image = new ImageIcon("wallpaperflare.com_wallpaper.png");
    Image img = background_image.getImage();
    Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
    background_image = new ImageIcon(temp_img);
    background = new JLabel("", background_image, JLabel.CENTER);
    background.setLayout(null);
    background.setBounds(0,0,1000,600);
    add(background);

    panel2=new JPanel();
        panel2.setBounds(10,10,965,80);
        panel2.setBackground(new Color(65, 75, 77, 69));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel2.setLayout(null);
        background.add(panel2);

    panel3=new JPanel();
        panel3.setBounds(10,470,965,85);
        panel3.setBackground(new Color(65, 75, 77, 69));
        panel3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel3.setLayout(null);
        background.add(panel3);

    label1 = new JLabel("Customer Name:");
        label1.setFont(new Font("ariel", Font.PLAIN, 15));
        label1.setBounds(20, 30, 150, 30);
        label1.setForeground(Color.WHITE);
        panel2.add(label1);
    text = new JTextField();
        text.setBounds(150, 30, 200, 27);
        text.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        panel2.add(text);

    label2 = new JLabel("Bill No :");
        label2.setFont(new Font("ariel", Font.PLAIN, 15));
        label2.setBounds(380, 30, 150, 30);
        label2.setForeground(Color.WHITE);
        panel2.add(label2);
    text1 = new JTextField();
        text1.setBounds(450, 30, 180, 27);
        panel2.add(text1);

    label3 = new JLabel("Mobile No :");
        label3.setFont(new Font("ariel", Font.PLAIN, 15));
        label3.setBounds(660, 30, 150, 30);
        label3.setForeground(Color.WHITE);
        panel2.add(label3);
    text2 = new JTextField();
        text2.setBounds(760, 30, 180, 27);
        panel2.add(text2);

    area=new JTextArea();
        area.setBounds(130,110,700,350);
        area.setBackground(new Color(202, 224, 232));
        area.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD,12));
        area.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
        area.setEditable(false);
    JScrollPane scrollBar=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    panel = new JPanel();
        panel.setBounds(130,110,700,350);
//        panel.setBackground(new Color(0,0,0,0));
        panel.setLayout(new BorderLayout());
        panel.add(scrollBar);
        background.add(panel);


        back = new JButton("Back");
        back.setBounds(220, 30, 100, 30);
        back.setBorderPainted(false);
        back.setBackground(new Color(229, 200, 13));
        back.addActionListener(this);
        panel3.add(back);

        clear = new JButton("Clear All");
        clear.setBounds(440, 30, 150, 30);
        clear.setBorderPainted(false);
        clear.setBackground(new Color(229, 200, 13));
        clear.addActionListener(this);
        panel3.add(clear);

        submit = new JButton("Submit");
        submit.setBounds(680, 30, 100, 30);
        submit.setBorderPainted(false);
        submit.setBackground(new Color(229, 200, 13));
        submit.addActionListener(this);
        panel3.add(submit);


        setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            new Home();
            setVisible(false);
        } else if(e.getSource()==submit){
            submit();
        }else if(e.getSource()==more){
//            upload();
        }else if(e.getSource()==back2){
            new Cust_details();
            frame1.setVisible(false);
        }else if(e.getSource()==back4){
//            frame2.setVisible(false);
            frame1.setVisible(true);
        } else if(e.getSource()==clear){
            text.setText("");
            area.setText("");
            text1.setText("");
            text2.setText("");
        }
    }

    void submit(){
        if(text.getText().isEmpty() || text1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Sorry Please Full up all details...","Error",JOptionPane.ERROR_MESSAGE);
        }else {
            String name = text.getText();
             String billNo = text1.getText();
             String mobNo = text2.getText();

          back2 = new JButton("Clear");
          back2.setBounds(850, 280, 100, 30);
          back2.setBorderPainted(false);
          back2.setBackground(new Color(181,190,178));
          back2.addActionListener(e -> area.setText(""));


          background.add(back2);

        String query ="select "+username2+".date, "+username2+".cust_name, "+username2+".mob_no, "+username2+".address, "+username2+".cust_bill, item_"+username2+".gold_product, item_"+username2+".gold_Name, item_"+username2+".gold_Karate, item_"+username2+".weight, item_"+username2+".gold_describe, item_"+username2+".per_gram, item_"+username2+".making_charge, item_"+username2+".discount, item_"+username2+".total, item_"+username2+".gst, item_"+username2+".grand_total from item_"+username2+" inner join "+username2+" where "+username2+".cust_bill="+billNo+" and item_"+username2+".cust_bill="+billNo+" and "+username2+".cust_name='"+name+"' and "+username2+".mob_no="+mobNo+";";
        try {
            ResultSet rs = con.sta.executeQuery(query);
                while (rs.next()) {
                    String result =  "\nDate: " + rs.getString(1) + " \nCustomer Name: " + rs.getString(2) + " \nMobile No.: " + rs.getLong(3) + " \nAddress: " + rs.getString(4) + " \nBill No.: " + rs.getLong(5) + " \nGold Product:  " + rs.getString(6) + " \nGold Name: " + rs.getString(7) + " \nGold Karat: " + rs.getDouble(8) + " \nGold Weight: " + rs.getDouble(9) + " \nGold Describe: " + rs.getString(10) + " \nPer Gram Price: " + rs.getDouble(11) + " \nMaking Charge: " + rs.getDouble(12) + " \nDiscount: " + rs.getDouble(13) + " \nTotal: " + rs.getDouble(14) + " \nGST: " + rs.getDouble(15) + " \nGrand Total: " + rs.getDouble(16);
                    String result2 = result + " \n------------------------------------------------------------\n ";
                    area.append(result2);
                }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Sorry Wrong Input","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }


    public static void main(String[] args) {
        new Cust_details();
    }
}


