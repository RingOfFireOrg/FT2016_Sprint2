package org.usfirst.frc.team3459.robot;

/*
 * This is a class to encapsulate a system timer
 */
public class PT_Timer {
  // member variables
  long m_startTime;
	
  /*
   * Constructor sets start time
   */
  public PT_Timer(){
	  reset();
  }
  
  /*
   * Reset the start time to be now
   */
  public void reset(){
	  m_startTime = System.currentTimeMillis();
  }
  
  /*
   * Get the number of milliseconds since start time
   */
  public long getMillis(){
	  return (System.currentTimeMillis() - m_startTime);
  }
  
  /*
   * Get the number of seconds since start time
   */
  public double getSecs(){
	  return (((double)getMillis()) / 1000);
  }
    
}
