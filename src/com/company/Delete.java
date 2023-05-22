package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import static com.company.project.*;

public class Delete extends JFrame implements ActionListener {
    JLabel shop, label,label3,label4,label5;
    JTextField text1,text2,text3;
    JPanel panel2;
    JButton back, delete;
    Delete(){
        setSize(700,500);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(SHOP_NAME);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());

        ImageIcon backgroundimage = new ImageIcon("pexels-danielle-de-angelis-2849743.jpg");
        Image img = backgroundimage.getImage();
        Image temp_img = img.getScaledInstance(800, 650, Image.SCALE_SMOOTH);
        backgroundimage = new ImageIcon(temp_img);
        JLabel background = new JLabel("", backgroundimage, JLabel.CENTER);

        shop= new JLabel("");
        shop.setBounds(0,7,700,50);
        shop.setForeground(Color.WHITE);
//        label1.setText("SHOP NAME")
        shop.setHorizontalAlignment(JLabel.CENTER);

        shop.setFont(new Font("Serif",Font.BOLD,50));
        background.add(shop);
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

        panel2= new JPanel();
        panel2.setBounds(0,0,1000,70);
        panel2.setBackground(new Color(222, 215, 215, 72));
        background.add(panel2);
        background.add(shop);

        label3 = new JLabel("Name: ");
        label3.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label3.setBounds(95, 150, 100, 35);
        label3.setForeground(Color.BLACK);
        background.add(label3);

        text1 = new JTextField();
        text1.setFont(new Font("arial", Font.PLAIN, 16));
        text1.setBounds(200, 150, 300, 35);
        text1.setForeground(Color.BLACK);
        background.add(text1);


        label4 = new JLabel("Mob No: ");
        label4.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label4.setBounds(95, 200, 150, 35);
        label4.setForeground(Color.BLACK);
        background.add(label4);

        text2 = new JTextField();
        text2.setFont(new Font("arial", Font.PLAIN, 16));
        text2.setBounds(200, 200, 300, 35);
        text2.setForeground(Color.BLACK);
        background.add(text2);

        label5 = new JLabel("GST No:");
        label5.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        label5.setBounds(95, 250, 150, 35);
        label5.setForeground(Color.BLACK);
        background.add(label5);

        text3 = new JTextField();
        text3.setFont(new Font("arial", Font.PLAIN, 16));
        text3.setBounds(200, 250, 300, 35);
        text3.setForeground(Color.BLACK);
        background.add(text3);

        delete = new JButton("Delete");
        delete.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        delete.setBounds(350, 400, 150, 40);
        delete.setFocusable(false);
        delete.setBorder(BorderFactory.createEtchedBorder());
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        background.add(delete);

        back = new JButton("Back");
        back.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        back.setBounds(170, 400, 150, 40);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        background.add(back);

        background.setBounds(0,0,700,500);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Delete();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            delete();
        }else if(e.getSource()==back){
            new Home();
            setVisible(false);
        }
    }
    void delete(){

        if(text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Fill up all details","Error",JOptionPane.ERROR_MESSAGE);
        }else {
            Conn conn=new Conn();
            String name=text1.getText();
            String mob=text2.getText();
            String gst=text3.getText();

            String query="Select * from signup where Name='"+name+"' and Mobile_No='"+mob+"' and GST_No='"+gst+"' ";
            try {
                ResultSet rs= conn.sta.executeQuery(query);
                if (rs.next()){
                    String UserName=JOptionPane.showInputDialog(this,"Enter Your UserName","UserName",JOptionPane.QUESTION_MESSAGE);
                    String password=JOptionPane.showInputDialog(this,"Enter Your Password","Password",JOptionPane.QUESTION_MESSAGE);
                    if(UserName.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this,"UserName & Password doesn't Empty","ERROR",JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(UserName.equals(username2) && password.equals(password2)) {
                            String query2 = "select * from signup where UserName='" + UserName + "' and password='" + password + "'";
                            ResultSet rs1 = conn.sta.executeQuery(query2);
                            if (rs1.next()) {
                                int option = JOptionPane.showConfirmDialog(this, "Your all data will be deleted... Are you confirm about this..?", "Alert", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_NO_OPTION) {
                                    String query4 = "drop table item_"+username2+";";
                                    int insertQuery1 = conn.sta.executeUpdate(query4);
                                    System.out.println(insertQuery1 + "row/s updated");

                                    String query5 = "drop table "+username2+";";
                                    int insertQuery2 = conn.sta.executeUpdate(query5);
                                    System.out.println(insertQuery2 + "row/s updated");

                                    String query6 = "delete from signup where username='"+username2+"' and password='"+password2+"';";
                                    int insertQuery3 = conn.sta.executeUpdate(query6);
                                    System.out.println(insertQuery3 + "row/s updated");

                                    JOptionPane.showMessageDialog(this, "All data has been erased......!!");
                                    JOptionPane.showMessageDialog(this, "Your account has been deleted successfully !");
                                    new project();
                                    setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(this, "Process is terminated...", "", JOptionPane.PLAIN_MESSAGE);

                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Sorry wrong username & password..","Error",JOptionPane.ERROR_MESSAGE);

                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(this,"Sorry User Not Found", "Error",JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(this,"Sorry User Not Found", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
