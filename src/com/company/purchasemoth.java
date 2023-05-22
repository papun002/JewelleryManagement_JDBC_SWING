package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static com.company.project.SHOP_NAME;
import static com.company.project.username2;

public class purchasemoth  extends JFrame implements ActionListener  {
        JLabel label4,month33;
        JComboBox com, com1, com2,com3,com4,com5;
        JButton Submit, Back,Submit1, Back1,Submit2, Back2;
        JPanel panel,panel2;
        Conn con = new Conn();
        purchasemoth() {
            setLayout(null);
            setSize(400, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            setTitle(SHOP_NAME);
            ImageIcon imageIcon = new ImageIcon("Logo.png");
            setIconImage(imageIcon.getImage());

            label4 = new JLabel("Date:");
            label4.setFont(new Font("ariel", Font.BOLD, 18));
            label4.setForeground(Color.BLACK);
            label4.setBounds(15, 30, 50, 20);
//            add(label4);

            String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            com = new JComboBox(date);
            com.setBounds(65, 30, 50, 25);
            com.setBackground(Color.white);
            com.setForeground(Color.BLACK);
//            add(com);

            String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            com1 = new JComboBox(month);
            com1.setBounds(118, 30, 100, 25);
            com1.setBackground(Color.white);
            com1.setForeground(Color.BLACK);
//            add(com1);

            String[] year = {"2022","2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051"};
            com2 = new JComboBox(year);
            com2.setBounds(222, 30, 118, 25);
            com2.setBackground(Color.white);
            com2.setForeground(Color.BLACK);
//            add(com2);

            Submit = new JButton("Confirm");
            Submit.setBounds(100, 75, 100, 25);
            Submit.setBackground(Color.CYAN);
            Submit.addActionListener(this);
//            panel.add(Submit);

            Back = new JButton("Back");
            Back.setBounds(200, 75, 100, 25);
            Back.setBackground(Color.CYAN);
            Back.addActionListener(this);
//            panel.add(Back);

            panel=new JPanel();
            panel.setBounds(0,0,400,200);
            panel.setLayout(null);
            panel.add(label4);
            panel.add(com);
            panel.add(com1);
            panel.add(com2);
            panel.add(Submit);
            panel.add(Back);
//            add(panel);
            panel2=new JPanel();
            panel2.setBounds(0,0,400,200);
            panel2.setLayout(null);

            month33 = new JLabel("Option ");
            month33.setFont(new Font("ariel", Font.BOLD, 18));
            month33.setForeground(Color.BLACK);
            month33.setBounds(15, 30, 50, 20);
            panel2.add(month33);

            String[] month2 = {"Last Month","Last Three Month","Last Six Month","One Year"};
            com3 = new JComboBox(month2);
            com3.setBounds(80, 30, 80, 25);
            com3.setBackground(Color.white);
            com3.setForeground(Color.BLACK);
            panel2.add(com3);

//            String[] month3 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//            com4 = new JComboBox(month3);
//            com4.setBounds(200, 30, 80, 25);
//            com4.setBackground(Color.white);
//            com4.setForeground(Color.BLACK);
//            panel2.add(com4);
//
//            String[] year1 = {"2022","2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051"};
//            com5 = new JComboBox(year);
//            com5.setBounds(300, 30, 80, 25);
//            com5.setBackground(Color.white);
//            com5.setForeground(Color.BLACK);
//            panel2.add(com5);

            Submit1 = new JButton("Confirm");
            Submit1.setBounds(100, 75, 100, 25);
            Submit1.setBackground(Color.CYAN);
            Submit1.addActionListener(this);
            panel2.add(Submit1);

            Back1 = new JButton("Back");
            Back1.setBounds(200, 75, 100, 25);
            Back1.setBackground(Color.CYAN);
            Back1.addActionListener(this);
            panel2.add(Back1);

            JTabbedPane tabbedPane=new JTabbedPane();
            tabbedPane.setBounds(0,0,400,150);
            tabbedPane.add("DAY", panel);
            tabbedPane.add("YEAR", panel2);
            add(tabbedPane);
            setVisible(true);
        }

    public static void main(String[] args) {
        new purchasemoth();
    }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Submit) {
                date();
            } else if (e.getSource() == Back) {
                setVisible(false);
                new Home();

            }

        }

        public void date() {
            JTable table;
            DefaultTableModel listTableModel;
            Object[][] rowData = {};
            Object[] columnNames = { "Date", "Bill No.", "Customer Name", "Mobile No.", "P.Name", "Gold Weight", "Description", "Per Gram Price", "Grand Total"};

            listTableModel = new DefaultTableModel(rowData, columnNames);

            JFrame frame1 = new JFrame();
            String year1 = (String) com2.getSelectedItem();
            String month1 = (String) com1.getSelectedItem();
            String day1 = (String) com.getSelectedItem();
            String date = year1 + "-" + month1 + "-" + day1;

            frame1.setLayout(new BorderLayout());
            frame1.setSize(1000, 600);
            frame1.setDefaultCloseOperation(HIDE_ON_CLOSE);
            frame1.setLocationRelativeTo(null);
            frame1.setResizable(false);

            String query = "select item_"+username2+".date, item_"+username2+".cust_bill, "+username2+".cust_name,"+username2+".mob_no,  item_"+username2+".gold_Name, item_"+username2+".weight, item_"+username2+".gold_describe, item_"+username2+".per_gram, item_"+username2+".grand_total from "+username2+" inner join item_"+username2+" where item_"+username2+".date='"+date+"' and "+username2+".date='"+date+"' order by "+username2+".cust_Bill ASC ; ";
            try {
                ResultSet rs = con.sta.executeQuery(query);
                while (rs.next()) {
                    listTableModel.addRow(new Object[]{rs.getString(1), String.valueOf(rs.getLong(2)), rs.getString(3), String.valueOf(rs.getLong(4)), rs.getString(5), String.valueOf(rs.getDouble(6)), rs.getString(7), String.valueOf(rs.getDouble(8)), String.valueOf(rs.getDouble(9))});
                }
                table = new JTable(listTableModel);
                table.setLayout(new BorderLayout());
                table.setBounds(10, 10, 1000, 550);
//            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.setCellEditor(null);
                table.setForeground(Color.black);
                JTableHeader tableHeader = table.getTableHeader();
                tableHeader.setBackground(Color.yellow);
                tableHeader.setForeground(Color.BLACK);

                frame1.add(new JScrollPane(table));

            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Table not find");
            }
            frame1.setVisible(true);
        }
        void month(){

            JTable table;
            DefaultTableModel listTableModel;
            Object[][] rowData = {};
            Object[] columnNames = { "Date", "Bill No.", "Customer Name", "Mobile No.", "P.Name", "Gold Weight", "Description", "Per Gram Price", "Grand Total"};

            listTableModel = new DefaultTableModel(rowData, columnNames);

            JFrame frame1 = new JFrame();
            String month1 = (String) com3.getSelectedItem();
            String month2 = (String) com4.getSelectedItem();
            String year = (String) com5.getSelectedItem();
            String date = month1 + "-" + month2 + "-" +year;

            frame1.setLayout(new BorderLayout());
            frame1.setSize(1000, 600);
            frame1.setDefaultCloseOperation(HIDE_ON_CLOSE);
            frame1.setLocationRelativeTo(null);
            frame1.setResizable(false);

            String query = "select item_"+username2+".date, item_"+username2+".cust_bill, "+username2+".cust_name,"+username2+".mob_no,  item_"+username2+".gold_Name, item_"+username2+".weight, item_"+username2+".gold_describe, item_"+username2+".per_gram, item_"+username2+".grand_total from "+username2+" inner join item_"+username2+" where item_"+username2+".date='"+date+"' and "+username2+".date='"+date+"' order by "+username2+".cust_Bill ASC ; ";
            try {
                ResultSet rs = con.sta.executeQuery(query);
                while (rs.next()) {
                    listTableModel.addRow(new Object[]{rs.getString(1), String.valueOf(rs.getLong(2)), rs.getString(3), String.valueOf(rs.getLong(4)), rs.getString(5), String.valueOf(rs.getDouble(6)), rs.getString(7), String.valueOf(rs.getDouble(8)), String.valueOf(rs.getDouble(9))});
                }
                table = new JTable(listTableModel);
                table.setLayout(new BorderLayout());
                table.setBounds(10, 10, 1000, 550);
//            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.setCellEditor(null);
                table.setForeground(Color.black);
                JTableHeader tableHeader = table.getTableHeader();
                tableHeader.setBackground(Color.yellow);
                tableHeader.setForeground(Color.BLACK);

                frame1.add(new JScrollPane(table));

            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Table not find");
            }
            frame1.setVisible(true);
        }

        }







