/**********************************************************************
 *  README.txt template                                                   
 *  CS112 PS7 (Guitar Hero)
 **********************************************************************/

Name: Phaelan Darius Vaillancourt

Yale NetID:pdv3

Partner's Name (if any): Fumitaka Osumi

Partner's NetID: fo39

Which partner is submitting the program files?  Fumitaka

Operating System (e.g., Mac OS X or Windows): Mac OS X

Text editor (e.g., Eclipse): Eclipse

Hours to complete assignment (optional): 8 hours

/**********************************************************************
 *  Explain why it makes sense to have a separate RingBuffer class.
 **********************************************************************/
It is important RingBuffer is a separate class because it is the building blocks for creating a sequence of numbers which translates into a buffer.  With the exception of how noise is generated (random numbers btw +/- 1/2 vs. some other technique) the behavior of the buffer should remain the same for each instrument, frequency, key stroke, etc. That is to say, Ringbuffer creates the array which is then manipulated by guitar string, guitar hero, etc.  Having the ring buffer as a separate class creates maximum flexibility if one wants to use a different instruments properties which would ultimately iterate through the buffer differently. 
/**********************************************************************
 *  List whatever help (if any) that you received, and the names of
 *  any students with whom you collaborated.                          
 **********************************************************************/


I received help from TAs from office hours.
/**********************************************************************
*  If you collaborated, explain how you split the work.
***********************************************************************/

My partner and I collaborated several ways.  We first each attempted the problem set on our own.  We then met to review bugs and share parts that were working for each of our programs.  If either one of us was stuck on a particular part of the code we would explain our approach to one another.  We would then part again, work on the code separately and then reconvene to compare once again.  We finally met one last time to ensure both of us had the program working but wound up tweaking one final version which was used to submit.   This was the file that was ultimately submitted.


/**********************************************************************
 *  If you and/or your partner did extra credit (IIa or IIb),  
 *  please note here who did it (only you, only your partner, both).
 **********************************************************************/




/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/


NO major issues other than sometimes we would name variables differently.  By partner also pointed out that i did not need a for loop in Ring Buffer (capacity) constructor because the array was actually created in guitar string.






/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

This assignment was confusing. Not only does one have to have really good working member tor member where all the code is, the instructors could have been a little clear on the function of each java file.

