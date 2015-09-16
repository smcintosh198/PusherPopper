package PusherPopper;

import java.awt.TextArea;
import java.util.ArrayList;


public class MyStack {
	
	//private static final int CAPACITY = 10;
	private int index;
	private static ArrayList<Integer> stack;
	private int size;
	private int waitCount;
	private int pushTotal;
	private int popTotal;
	private TextArea textArea;
	private TextArea stackText;
	
	public MyStack () {
		index = 0;
		pushTotal = 0;
		popTotal = 0;
		size = 0;
		stack = new ArrayList<Integer>();
		
	}
	
	public MyStack (TextArea ta, TextArea st) {
		index = 0;
		pushTotal = 0;
		popTotal = 0;
		stack = new ArrayList<Integer>();
		textArea = ta;
		stackText = st;
	}
	
	public synchronized void push (int x) {
		textArea.append(Thread.currentThread().getName() + " pushed " + x + "\n");
		if (waitCount > 0) {
			stack.add(x);
			
			notify();
		} else {
			stack.add(x);
		}
		++index;
		++pushTotal;
		print();
		System.out.println(index);
	}
	
	public synchronized int pop() {
		while (isEmpty()) {
			try {
				++waitCount;
				wait();
			} catch (Exception e) {

			}
		}
		int poppedElement = stack.get(index - 1);
		--index;
		textArea.append(Thread.currentThread().getName() + " popped " + poppedElement + "\n");
		System.out.println(index);
		stack.remove(index);
		++popTotal;
		print();
		return poppedElement;
	}
	
	private synchronized void print() {
		stackText.setText("Current Stack: ");
		stackText.append("\n ______________");
		
		for (int i = stack.size() - 1; i >= 0; --i) {
			stackText.append("\n | \t" + stack.get(i) + "\t |");
		}
		
		stackText.append("\n ______________");
		
	}
	
	private boolean isEmpty() {
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}
	
//	private int[] remove(int[] s, int ind) {
//		int[] newStack = new int[s.length - 1];
//		for (int i = 0; i <= s.length; ++i) {
//			newStack[i] = s[i + 1];
//		}
//		return newStack;
//	}

//	public boolean isFull() {
//		return false;
//	}
	
}
