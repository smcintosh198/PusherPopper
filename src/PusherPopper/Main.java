package PusherPopper;
//package cs380.DrWebster.Assignment1;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
           JFrame myWindow = new JFrame();
           
            myWindow.setTitle("CS380 Assignment 1");
            myWindow.setSize(1000, 600);
            myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyPanelTop mytop = new MyPanelTop();
            MyStack stack = new MyStack(mytop.textarea, mytop.stackTextArea);
            mytop.setStack(stack);       
            
            MyThread t1 = new MyThread("Thread 1 (Pusher)", stack, 800, false);
            MyThread t2 = new MyThread("Thread 2 (Pusher)", stack, 800, false);
            MyThread t3 = new MyThread("Thread 3 (Popper)", stack, 900, true);
            MyThread t4 = new MyThread("Thread 4 (Popper)", stack, 900, true);
            
            ArrayList<MyThread> tList = new ArrayList<MyThread>();
            tList.add(t1);
            tList.add(t2);
            tList.add(t3);
            tList.add(t4);
            mytop.setThreads(tList);
            
            Container pane = myWindow.getContentPane();
            pane.add("Center", mytop);
            myWindow.setVisible(true);
            
    }

}