package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.company.project.SHOP_NAME;

public class Check_Stock extends JFrame implements ActionListener {
    JButton back;
    JPanel panel1;
    Check_Stock()
   {
        setSize(1000, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
       setLocationRelativeTo(null);
       setTitle(SHOP_NAME);
       ImageIcon imageIcon = new ImageIcon("Logo.png");
       setIconImage(imageIcon.getImage());

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension(1000, 600));


       back = new JButton("Back");
       back.setBounds(450, 500, 100, 30);
       back.addActionListener(this);
       panel1.add(back);

       add(panel1);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
            new Home();

        }
    }
}
