package PusherPopper;

import java.awt.TextArea;


public class MyStack {
	
	//private static final int CAPACITY = 10;
	private int index;
	private int[] stack;
	
	
	private int pushTotal;
	private int popTotal;
	public TextArea ta;
	
	public MyStack () {
		index = 0;
		pushTotal = 0;
		popTotal = 0;
		
	}
	
	public MyStack (TextArea textArea) {
		index = 0;
		pushTotal = 0;
		popTotal = 0;
		ta = textArea;
	}
	
	public synchronized void push (int x) {
		ta.append(Thread.currentThread().getName() + " pushed " + x + "\n");
		if (isEmpty()) {
			stack[index] = x;
			notify();
		} else {
			stack[index] = x;
		}
		++index;
		++pushTotal;
	}
	
	public synchronized int pop() {
		if (isEmpty()) {
			try {
				wait();
			} catch (Exception e) {
				
			}
		} else {
			ta.append(Thread.currentThread().getName() + " popped " + stack[index] + "\n");
			//stack = remove(stack, index);
			--index;
			++popTotal;
			//return stack[index];
			return stack[index];
		}
		return stack[index];
	}
	
	private boolean isEmpty() {
		if (stack.length == 0) {
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
