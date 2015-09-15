package PusherPopper;
//package cs380.DrWebster.Assignment1;

import java.awt.Container;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
           JFrame myWindow = new JFrame();
           
            myWindow.setTitle("CS380 Assignment 1");
            myWindow.setSize(1000, 600);
            myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyPanelTop mytop = new MyPanelTop();
            MyStack stack = new MyStack(mytop.textarea);
                   
            MyThread t1 = new MyThread("Thread 1 (Pusher)", stack, 750, true);
            MyThread t2 = new MyThread("Thread 2 (Pusher)", stack, 800, true);
            MyThread t3 = new MyThread("Thread 3 (Popper)", stack, 750, false);
            MyThread t4 = new MyThread("Thread 4 (Popper)", stack, 800, false);
           
            Container pane = myWindow.getContentPane();
            pane.add("Center", mytop);
            myWindow.setVisible(true);

    }

}