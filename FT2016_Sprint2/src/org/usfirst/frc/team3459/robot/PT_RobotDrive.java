package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class PT_RobotDrive extends RobotDrive {
	boolean m_backwards = false;
	
	public void setLeftRightMotorOutputs(double leftOutput, double rightOutput){
		if(m_backwards == false){
			super.setLeftRightMotorOutputs(leftOutput, rightOutput);
		}
		else{
			// switches motors and direction
			super.setLeftRightMotorOutputs(-rightOutput, -leftOutput);
		}
	}
	
	public void setBackwards(boolean backwards){
		m_backwards = backwards;
	}
	

	public PT_RobotDrive(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}

	public PT_RobotDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
		// TODO Auto-generated constructor stub
	}

	public PT_RobotDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public PT_RobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

}
