package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Servo;

/**
 * We make simple classes for each piece of hardware so that if the way we need to interact
 * with it changes, then we don't have to change it everywhere in the program but only in one
 * place.  The "fancy" word for this is encapsulation.
 */
public class PT_Silverback_Tubes extends Servo {
    public enum state { CLOSED, FIRST_OPEN, BOTH_OPEN }; 
    state m_state = state.CLOSED;
    PT_Timer m_timer;

	public PT_Silverback_Tubes(int channel) {
		super(channel);
		m_timer = new PT_Timer();
		// Nothing else to do here
	}
	public void setState(state newState){
		if(newState != m_state){
			switch(newState){
			case CLOSED:
				close();
				break;
			case FIRST_OPEN:
				dumpFirstTube();
				break;
			case BOTH_OPEN:
				dumpBothTubes();
				break;
			}
		}
	}
	public state getState(){
		return m_state;
	}
	
	public void dumpBothTubes(){
		set(0.0);
		m_state = state.BOTH_OPEN;
	}
	public void dumpFirstTube(){
		set(0.40);
		m_state = state.FIRST_OPEN;
	}
	public void close(){
		set(0.95);
		m_state = state.CLOSED;
	}
	
	public void timedRelease(){
		switch(m_state){
			case CLOSED:
				m_timer.reset();
				dumpFirstTube();
				break;
			case FIRST_OPEN:
				if(m_timer.getSecs() > 1.5){   // If the first one has been open for more than a second
					dumpBothTubes();
				}
				break;
			case BOTH_OPEN:  // do nothing
				break;
		}
	}
}
