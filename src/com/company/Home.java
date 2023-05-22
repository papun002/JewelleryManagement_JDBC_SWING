package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Locale;

public class Home extends JFrame implements ActionListener{
    JButton back,customer,checkStock,addStock, cusdetails,ShopDetails, delete, setting;
    JLabel panel1, name, shop;
    JPanel panel2,panel5;
    String username2 = project.username2;
    String SHOP_NAME= project.SHOP_NAME;

    Home() {
        setSize(1000, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
//        setTitle();
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

        //BACKGROUND
        ImageIcon background_image = new ImageIcon("wallpaperflare.com_wallpaper.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setLayout(null);
        background.setBounds(0,0,1000,600);
        add(background);

        panel2=new JPanel();
        panel2.setBounds(120,120,750,400);
        panel2.setBackground(new Color(65, 75, 77, 69));
        panel2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel2.setLayout(null);
        background.add(panel2);

        customer=new JButton("Add Customer");
        customer.setBounds(150,70,200,40);
        customer.addActionListener( this);
        customer.setBackground(new Color(232, 225, 225));
        customer.setBorderPainted(false);
        customer.setFocusable(false);
        customer.setForeground(Color.BLACK);
        panel2.add(customer);

        cusdetails=new JButton("Customer Details");
        cusdetails.setBounds(390,70,200,40);
        cusdetails.addActionListener( this);
        cusdetails.setBackground(new Color(232, 225, 225));
        cusdetails.setBorderPainted(false);
        cusdetails.setFocusable(false);
        cusdetails.setForeground(Color.BLACK);
        panel2.add(cusdetails);

        checkStock =new JButton("Purchase Details");
        checkStock.setBounds(150,140,200,40);
        checkStock.addActionListener(this);
        checkStock.setBackground(new Color(232, 225, 225));
        checkStock.setBorderPainted(false);
        checkStock.setFocusable(false);
        checkStock.setForeground(Color.BLACK);
        panel2.add(checkStock);

        addStock =new JButton("Add Stock");
        addStock.setBounds(390,140,200,40);
        addStock.addActionListener(this);
        addStock.setBackground(new Color(232, 225, 225));
        addStock.setBorderPainted(false);
        addStock.setFocusable(false);
        addStock.setForeground(Color.BLACK);
        panel2.add(addStock);

        ShopDetails=new JButton("Shop Details");
        ShopDetails.setBounds(150,210,200,40);
        ShopDetails.addActionListener( this);
        ShopDetails.setBackground(new Color(232, 225, 225));
        ShopDetails.setBorderPainted(false);
        ShopDetails.setFocusable(false);
        ShopDetails.setForeground(Color.BLACK);
        panel2.add(ShopDetails);

        delete = new JButton("Delete Account");
        delete.setBounds(390,210,200,40);
        delete.setBackground(new Color(232, 225, 225));
        delete.setBorderPainted(false);
        delete.addActionListener( this);
        delete.setFocusable(false);
        delete.setForeground(Color.BLACK);
        panel2.add(delete);

        back =new JButton("Logout");
        back.setBounds(260,310,200,40);
        back.addActionListener(this);
        back.setBackground(new Color(229, 200, 13));
        back.setBorderPainted(false);
        back.setFocusable(false);
        panel2.add(back);

        panel5=new JPanel();
        panel5.setBounds(0,0,1000,80);
        panel5.setBackground(new Color(0,0,0,0));
//        panel5.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 109), 1));
        panel5.setLayout(null);
        background.add(panel5);

        shop= new JLabel("");
        shop.setBounds(0,20,1000,50);
        shop.setForeground(Color.WHITE);
        shop.setHorizontalAlignment(JLabel.CENTER);

        shop.setFont(new Font("Trajan Pro 3",Font.BOLD,40));
        panel5.add(shop);
        Conn con = new Conn();
        String query="Select signup.shop_Name from signup where signup.UserName='"+username2+"'";
        try{
            ResultSet rs= con.sta.executeQuery(query);
            if(rs.next()){
                String r1=rs.getString(1);
                shop.setText(r1.toUpperCase(Locale.ROOT));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }

        ImageIcon ImageIcon = new ImageIcon(new ImageIcon("settings.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        setting= new JButton(ImageIcon);
        setting.setBounds(10, 365, 30, 30);
        setting.setToolTipText("Privacy Setting");
        setting.setFocusable(false);
        setting.setOpaque(true);
        setting.setBorderPainted(false);
        setting.setBackground(null);
        setting.setBorder(null);
        panel2.add(setting);
        setting.addActionListener(e -> JOptionPane.showMessageDialog(this,"Server Busy!!","ERROR",JOptionPane.PLAIN_MESSAGE));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==customer)
        {
            new Customer();
            setVisible(false);
        }
        else
            if(e.getSource()==checkStock)
        {
//            new PurchaseDetails();
            new purchasemoth();
            setVisible(false);
        }else if(e.getSource()==addStock) {
            JOptionPane.showMessageDialog(this,"This Server is Busy Now", "Error",JOptionPane.ERROR_MESSAGE);

        }else if(e.getSource()==cusdetails) {
            new Cust_details();
            setVisible(false);
        }else if (e.getSource()==back) {
                int a=JOptionPane.showConfirmDialog(this,"You will returned to the login screen","Confirm Logout",JOptionPane.YES_NO_OPTION);
                if(a==JOptionPane.YES_OPTION){
                    new project();
                    setVisible(false);
                }
            }else if(e.getSource()==ShopDetails) {
                new shopz();
                setVisible(false);
            } else if(e.getSource()==delete){
                int b = JOptionPane.showConfirmDialog(this, "Do you want to delete your account?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                if(b==JOptionPane.YES_OPTION){
                    new Delete();
                    setVisible(false);
                }
            }
    }
}
