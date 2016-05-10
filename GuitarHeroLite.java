import java.util.Scanner;

//************************************************************************
// File: GuitarHeroLite.java         Assignment 7
// 
// Author: <your name>  Email: <your email>
//
// Class: GuitarHeroLite
// Dependencies: RingBuffer GuitarString StdAudio StdDraw 
//
// Description  :  GuitarHero template
//  
//  Plays two guitar strings (concert A and concert C) when the user
//  types the lowercase letters 'a' and 'c', respectively in the 
//  standard drawing window.
//************************************************************************

public class GuitarHeroLite {

	public static void main(String[] args) {
		int DRAW_SAMPLE_RATE = 20; // draw at a rate of 20/sec
		int AUDIO_PER_DRAW = StdAudio.SAMPLE_RATE / DRAW_SAMPLE_RATE;

		int PLAY_TIME = 10; // target 60 seconds display window
		int XWIDTH = DRAW_SAMPLE_RATE * PLAY_TIME;
		char key = 0;

		// Create two guitar strings, for concert A and C
		double CONCERT_A = 440.0;
		double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
		GuitarString stringA = new GuitarString(CONCERT_A); // how do these related back to program?
		GuitarString stringC = new GuitarString(CONCERT_C);

		// Set up parameters for visualization
		StdDraw.setCanvasSize(768, 256);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setXscale(0, XWIDTH);
		StdDraw.setYscale(-1, 1);

		// fence post
		double xprev = 0, yprev = 0;

		// the main input loop
		
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		GuitarString[] key_index = new GuitarString[keyboard.length()];

		for (int i = 0; i < 37; i++) {

			key_index[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12));

		}

		while (true) {

			// check if the user has typed a key, and, if so, process it

			if (StdDraw.hasNextKeyTyped()) {

				// the user types this character
				key = StdDraw.nextKeyTyped();

				int i = keyboard.indexOf(key);
				if (i != -1)
					key_index[i].pluck();
			}
			/*
			 * else { System.out.print("Key typed is invalid"); }
			 */

			double new_sample = 0;

			for (int i = 0; i < 37; i++) {

				// double new_sample = stringA.sample() + stringC.sample();

				new_sample += key_index[i].sample();

				key_index[i].tic();

			}

			// send the result to standard audio
			StdAudio.play(new_sample);

			// advance the simulation of each guitar string by one step

			stringA.tic();
			stringC.tic();

			// Decide if we need to draw.
			// Audio sample rate is StdAudio.SAMPLE_RATE per second
			// Draw sample rate is DRAW_SAMPLE_RATE
			// Hence, we draw every StdAudio.SAMPLE_RATE / DRAW_SAMPLE_RATE
			if (stringA.time() % AUDIO_PER_DRAW == 0) {
				StdDraw.line(xprev, yprev, xprev + 1, new_sample);
				xprev++;
				yprev = new_sample;
				if (xprev>XWIDTH) {
					xprev = 0;
					StdDraw.clear();
				}
				// check if wrapped around
			} // end of if

		} // end of while

	} // end of main

}// end of class
