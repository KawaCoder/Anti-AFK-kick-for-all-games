import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. 
 * Creator: DR34M-M4K3R#7751*/



//                                                If you are searching for comments, jusst scroll down and look at this column    |   |
public class Main {                                       //                                                                      |   |
                                                          //                                                                      |   |
    static Thread startthread = new Thread(){             //                                                                      |   |
        public void run () {                              //                                                                      |   |
            while (!camion){ //                                                                                                   |   |
                try {
                    Robot robot = new Robot();

                    robot.keyPress(KeyEvent.VK_Z);
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    robot.keyRelease(KeyEvent.VK_Z);


                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    robot.keyPress(KeyEvent.VK_S);
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    robot.keyRelease(KeyEvent.VK_S);

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /*static Thread stopthread = new Thread(){         This thread is stupid because i don't need it to stop the other one        |***|
        public void run (){                             |
            camion = true;                              |
        }                                             <--
    };*/

    public static boolean camion = false;

    public static void main(String[] args){


        JFrame frame = new JFrame("Anti AFK-kick ");
        JLabel text = new JLabel("github.com/DR34M-M4K3R");
        JButton startbutton = new JButton("Start");
        JButton stopbutton = new JButton("Stop");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.add(text, BorderLayout.CENTER);
        frame.add(startbutton, BorderLayout.WEST);

        frame.add(stopbutton, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);



        startbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                text.setText("Anti-afk activé.");
                startthread.start();
            }
        });


        stopbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                text.setText("Anti AFK désactivé!!");
                //stopthread.start();  <--------------I know this is stupid to start an other thread to stop an other :/          |***|
                startthread.stop();
            }
        });


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //stopthread.start();  <--------------I know this is stupid to start an other thread to stop an other :/          |***|
                startthread.stop();
            }
        });

    }
}
