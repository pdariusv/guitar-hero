//************************************************************************
// File: GuitarString.java         Assignment 7
// 
// Author: <your name>             Email: <your email>
//
// Class: RingBuffer
// Dependencies: RingBuffer 
//
// Description  :  GuitarString template
//  
//  This is a template file for GuitarString.java. It lists the 
// constructors and methods you need, along with descriptions of what 
// they're supposed to do.
//  
//  Note: it won't compile until you fill in the constructors and methods
//        (or at least commment out the ones whose return type is non-void).
//
//************************************************************************

import java.util.Random;

public class GuitarString {

	private RingBuffer          buffer; // ring buffer
	private static final double DECAY = 0.996;
	private int time = 0;

	//fo39

	// create a guitar string of the given frequency
	public GuitarString(double frequency) {

		buffer = new RingBuffer((int)(44100/frequency));
		while (!buffer.isFull())
			buffer.enqueue(0);

	}

	// create a guitar string with size & initial values given by the array
	public GuitarString(double[] init) {

		buffer = new RingBuffer(init.length);

		for(int i=0; i < init.length; i++) {

			buffer.enqueue(init[i]);
		}

	}

	// pluck the guitar string by replacing the buffer with white noise.  use a combination of the RingBuffer methods size(), dequeue(), and enqueue() to replace the buffer with values between -0.5 and 0.5. 
	public void pluck() {


		while (!buffer.isEmpty()) {

			buffer.dequeue();
		}

		while (!buffer.isFull()) {

			buffer.enqueue(Math.random()*1/2 - Math.random()*1/2);

		}
	}

	// advance the simulation one time step. use a combination of enqueue(), dequeue(), and peek().
	public void tic() {
		time += 1;
		double first = buffer.dequeue();
		double second = buffer.peek();

		buffer.enqueue((first + second)*(0.5)*DECAY);

		
	}




	// return the current sample
	public double sample() {

		return buffer.peek();


	}

	// return number of times tic was called
	public int time() {
		return time;

	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
		GuitarString testString = new GuitarString(samples);
		for (int i = 0; i < N; i++) {
			int t = testString.time();
			double sample = testString.sample();
			System.out.printf("%6d %8.4f\n", t, sample);
			testString.tic();
		}
	}

}
