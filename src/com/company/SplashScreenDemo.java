package com.company;

import javax.swing.*;
import java.awt.*;

    public class SplashScreenDemo {
        JFrame frame;
        ImageIcon background_image = new ImageIcon("jewelry-ring-with-nacre-on-blue-beads.jpg");
        JLabel text = new JLabel("JEWELLERY MANAGEMENT SYSTEM");
        JLabel background;
        JProgressBar progressBar = new JProgressBar();
        JLabel message = new JLabel();//Crating a JLabel for displaying the message

        SplashScreenDemo() {

//            ImageIcon background_image = new ImageIcon("wallpaperflare.com_wallpaper.png");
//            Image img = background_image.getImage();
//            Image temp_img = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
//            background_image = new ImageIcon(temp_img);
//            background = new JLabel("", background_image, JLabel.CENTER);
//            background.setLayout(null);
//            background.setBounds(0,0,1000,600);
//            frame.add(background);

            createGUI();
            addImage();
            addText();
            addProgressBar();
            addMessage();
            runningPBar();
        }

        public void createGUI() {
            frame = new JFrame();
            frame.setLayout(null);
            frame.setUndecorated(true);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }

        public void addImage() {
            Image img = background_image.getImage();
//            image.setSize(600,400);
            Image temp_img = img.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
            background_image = new ImageIcon(temp_img);
            background = new JLabel("", background_image, JLabel.CENTER);
            background.setLayout(new BorderLayout());
            background.setBounds(0, 0, 600, 400);
            frame.add(background);
        }

        public void addText() {
            text.setFont(new Font("Colonna MT", Font.PLAIN, 32));
            text.setBounds(0, 25, 600, 40);
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setForeground(Color.WHITE);
            background.add(text);
        }

        public void addMessage() {
            message.setBounds(50, 100, 200, 40);//Setting the size and location of the label
            message.setLayout(null);
            message.setForeground(Color.WHITE);//Setting foreground Color
            message.setFont(new Font("arial", Font.ITALIC, 10));//Setting font properties
            background.add(message);//adding label to the frame
        }

        public void addProgressBar() {
            progressBar.setBounds(-1, 390, 500, 10);
            progressBar.setBorderPainted(false);
//            progressBar.setBorder(null);
//            progressBar.setStringPainted(true);
            progressBar.setBackground(Color.BLACK);
            progressBar.setForeground(Color.WHITE);
            progressBar.setValue(0);
            background.add(progressBar);
        }

        public void runningPBar() {
            int i = 0;//Creating an integer variable and intializing it to 0


            try {

                for (i = 0; i <= 100; i++) {
                    progressBar.setValue(i);
                    Thread.sleep(70);//Pausing execution for 50 milliseconds
                    message.setText("Connecting Resources...   " + Integer.toString(i) + "%");
//                    progressBar.setValue(i);//Setting value of Progress Bar
//                    message.setText("Please Wait.." + Integer.toString(i) + "%");//Setting text of the message JLabel
                    if (i == 5) {
                        message.setText("Turning on Modules....   " + Integer.toString(i) + "%");
                        Thread.sleep(1200);
                    }
                    if (i == 10) {
                        message.setText("Loading Modules....   " + Integer.toString(i) + "%");
                        Thread.sleep(1000);
                    }
                    if (i == 20) {
                        message.setText("Connecting Resources...   " + Integer.toString(i) + "%");
                        Thread.sleep(1100);
                    }
                    if (i == 40) {
                        message.setText("Please Wait...   " + Integer.toString(i) + "%");
//                        Thread.sleep(1200);
                    }
                    if (i == 50) {
                        message.setText("Server Connecting...   " + Integer.toString(i) + "%");
//                        Thread.sleep(1200);
                    }
                    if (i == 60) {
                        message.setText("Please wait...   " + Integer.toString(i) + "%");
//                        Thread.sleep(1200);
                    }
                    if (i == 70) {
                        message.setText("Fetching Database...   " + Integer.toString(i) + "%");
//                        Thread.sleep(1200);
                    }
                    if (i == 80) {
                        message.setText("Server Connecting...   " + Integer.toString(i) + "%");
//                        Thread.sleep(1200);
                    }
                    if (i == 90) {
                        message.setText("Loading...   " + Integer.toString(i) + "%");
                        Thread.sleep(1000);
                    }
                    if (i == 100) {
                        message.setText("Completed...  " + Integer.toString(i) + "%");
                        new project();
                        frame.dispose();

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


            public static void main (String[]args){
                new SplashScreenDemo();

            }
        }




