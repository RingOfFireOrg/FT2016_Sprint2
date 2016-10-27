package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Servo;

/**
 * We make simple classes for each piece of hardware so that if the way we need to interact
 * with it changes, then we don't have to change it everywhere in the program but only in one
 * place.  The "fancy" word for this is encapsulation.
 */
public class PT_SampleServoMechanism extends Servo {

	public PT_SampleServoMechanism(int channel) {
		super(channel);
		// Nothing else to do here
	}
	public void open(){
		set(1.0);
	}
	public void close(){
		set(0.0);
	}
}
