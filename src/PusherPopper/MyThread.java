package PusherPopper;

import java.awt.TextArea;

/**
 * Thread can be a pusher or popper of a stack object. It needs a stack
 * object to
 * 
 * @author Matt Maze
 */
public class MyThread extends Thread {

	private MyStack stack;
	private int delay;
	private boolean isAlive = true;
	private boolean isPopper;
	int number;
	int counter;

	public MyThread(String name, MyStack stack, int delay, boolean is_popper) {
		super(name);
		this.stack = stack;
		this.delay = delay;
		this.isPopper = is_popper;
		counter = 0;
		this.start();
	}

	public void run() {
		while (true) {

			try {
				this.sleep((long) (delay * Math.random()));
			} catch (Exception e) {
				System.out.println("Exception thrown: " + e.toString());
			}
// This is to prevent popping/pushing when the output is stopped.
			if (isAlive) {
				if (isPopper) {
					number = stack.pop();
				} else {
					number = (int) (Math.random() * 100);
					stack.push(number);
				}
			}

		}
	}

	public boolean isPopper() {
		return isPopper;
	}

	public void revive() {
		isAlive = true;
	}

	public void kill() {
		isAlive = false;
	}
}