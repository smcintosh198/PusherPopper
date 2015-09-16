package PusherPopper;
//package cs380assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * MyPanelTop creates the graphical user interface of the program.
 * 
 * @author Dr. Roger Webster and Matt Maze
 */
public class MyPanelTop extends JPanel implements ActionListener {

	Button StopButton;
	Button StartButton;
	Button StopPushButton;
	Button StartPushButton;
	Button StopPopButton;
	Button StartPopButton;
	Button statisticsButton;
	Button threadStatButton;
	boolean output = false;
	MyStack stack;
	TextArea textarea = new TextArea();
	TextArea stackTextArea = new TextArea("Current stack:\n - ");
	JPanel mypanel = new JPanel();
	ArrayList<MyThread> threadList = null;

	public MyPanelTop() {

		this.setLayout(new BorderLayout());

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));

		textarea.setFont(new Font("Helvetica", Font.PLAIN, 12));
		textarea.setEditable(false);
		textarea.setSize(100, 100);

		stackTextArea.setFont(new Font("Helvetica", Font.PLAIN, 12));
		stackTextArea.setEditable(false);
		stackTextArea.setSize(100, 100);

		textPanel.add(textarea);
		textPanel.add(stackTextArea);
		// create control buttons
		//this.setLayout(null); // set layout to null
		// ///////////////////////

		StopButton = new Button("Stop All");
		StartButton = new Button("Start All");
		StopPushButton = new Button("Stop Push");
		StartPushButton = new Button("Start Push");
		StopPopButton = new Button("Stop Pop");
		StartPopButton = new Button("Start Pop");
	
		
		statisticsButton = new Button("View Statistics");
		threadStatButton = new Button("View Thread Stats");

		mypanel.add(StartPushButton);
		mypanel.add(StopPushButton);
		
		mypanel.add(StartPopButton);
		mypanel.add(StopPopButton);
	
		
		mypanel.add(StartButton);
		mypanel.add(StopButton);
		mypanel.add(statisticsButton);
		mypanel.add(threadStatButton);
		textarea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		this.add(textPanel, BorderLayout.CENTER);

		this.add(mypanel, BorderLayout.SOUTH);
		StopPushButton.addActionListener(this);
		StartPushButton.addActionListener(this);
		StopPopButton.addActionListener(this);
		StartPopButton.addActionListener(this);
	
		
		StopButton.addActionListener(this);
		StartButton.addActionListener(this);
		statisticsButton.addActionListener(this);
		threadStatButton.addActionListener(this);
		textarea.append("   H        H       IIIIIIIII      !!!!\n"
				+ "   H        H           I          !!!!\n"
				+ "   H        H           I          !!!!\n"
				+ "   H        H           I          !!!!\n"
				+ "   H        H           I          !!!!\n"
				+ "   HHHHHHHHHH           I          !!!!\n"
				+ "   H        H           I          !!!!\n"
				+ "   H        H           I          \n"
				+ "   H        H           I           !!\n"
				+ "   H        H           I          !!!!\n"
				+ "   H        H       IIIIIIIII       !!\n\n\n"
				+ "\t\tHello to CS380 Operating Systems\n");
	}

	public void paint(Graphics g) {
		// g.drawString("Hello!", 10, 10);
		// add labels for textfields
		// //////////////////////////
	}

	public void setThreads(ArrayList<MyThread> threadList) {
		this.threadList = threadList;
	}

	public void setStack(MyStack stack) {
		this.stack = stack;
	}
	
	public void printToStack(int x) {
		
	}

	// /////////////////////////////////
	// Implementation of ActionListener
	// /////////////////////////////////
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == StartPushButton) {
			this.threadList.get(0).revive();
			this.threadList.get(1).revive();
		}

		if (ae.getSource() == StopPushButton) {
			this.threadList.get(0).kill();
			this.threadList.get(1).kill();
		}
		
		if (ae.getSource() == StartPopButton) {
			this.threadList.get(2).revive();
			this.threadList.get(3).revive();
		}
		
		if (ae.getSource() == StopPopButton) {
			this.threadList.get(2).kill();
			this.threadList.get(3).kill();
		}
		
		if (ae.getSource() == StartButton) {
			this.threadList.get(0).start();
			this.threadList.get(1).start();
			this.threadList.get(2).start();
			this.threadList.get(3).start();
			
		}
		
		if (ae.getSource() == StopButton) {
			this.threadList.get(0).kill();
			textarea.append("Stop All!!!\n");
			this.threadList.get(1).kill();
			textarea.append("Stop All!!!\n");
			this.threadList.get(2).kill();
			textarea.append("Stop All!!!\n");
			this.threadList.get(3).kill();
			textarea.append("Stop All!!!\n");
		}
		
		if (ae.getSource() == statisticsButton) {
			
		}

		if (ae.getSource() == threadStatButton) {
			
		}

	} // end actionPerformed, implementation of ActionListener
}