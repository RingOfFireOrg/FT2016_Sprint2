
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Don't change the name of this or it won't work. (The manifest looks for
 * "Robot")
 */
public class Robot extends IterativeRobot {

	/*
	 * Member variables go here
	 */
	PT_RobotDrive driveTrain;
	PT_SampleServoMechanism mechanism;
	Joystick leftDriveStick;
	Joystick rightDriveStick;
	Joystick commandStick;
	PT_Timer autonomousTimer;
//	Solenoid solenoidOne;
//	Solenoid solenoidTwo;
	
	DoubleSolenoid solenoid;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		driveTrain = new PT_RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
		// If we are using the robot where the front is the back
		driveTrain.setBackwards(true);
		mechanism = new PT_SampleServoMechanism(RobotMap.sampleServo);

		autonomousTimer = new PT_Timer();
		solenoid = new DoubleSolenoid(RobotMap.s1,RobotMap.s2);
//		solenoidOne = new Solenoid(RobotMap.s1);
//		solenoidTwo = new Solenoid(RobotMap.s2);
		// Setup driver station controls
		leftDriveStick = new Joystick(RobotMap.driverStationDriveStickLeft);
		rightDriveStick = new Joystick(RobotMap.driverStationDriveStickRight);
		commandStick = new Joystick(RobotMap.driverStationCommandStick);
	}

	/**
	 * This function is used to display credits
	 */
	public void credits() {
		// TODO: Change this to be YOUR team name
		DriverStation.reportWarning("Put Yout Team Name Here", false);
		DriverStation.reportWarning("--------------------------", false);
	}

	/**
	 * This function is called once when we go into the teleop mode
	 */
	public void teleopInit() {
		credits();
	}

	/**
	 * This function is called periodically during operator control (approx
	 * 20ms)
	 */
	public void teleopPeriodic() {
		// Read joysticks - The -1 is because we have the robot facing backwards
		double leftDriveSpeed = leftDriveStick.getY() * -1;
		double rightDriveSpeed = rightDriveStick.getY() * -1;
		// Set Drivetrain motors
		driveTrain.tankDrive(leftDriveSpeed, rightDriveSpeed);
		// Read triggers for BIGPIPPIN
		boolean leftTrigger = leftDriveStick.getRawButton(RobotMap.trigger);
		boolean rightTrigger = rightDriveStick.getRawButton(RobotMap.trigger);
		if (leftTrigger) {
			solenoid.set(DoubleSolenoid.Value.kForward);
		} else if (rightTrigger) {
			solenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
//
//	public void setLeft() {
//		solenoidOne.set(true);
//		solenoidTwo.set(false);
//	}
//
//	public void setRight() {
//		solenoidOne.set(false);
//		solenoidTwo.set(true);
//	}

	/**
	 * This function is called once when we go into the Autonomous mode
	 */
	public void autonomousInit() {
		credits();
		autonomousTimer.reset();
	}

	// this is the time since beginning of autonomous period
	/**
	 * This function is called periodically during autonomous control (approx
	 * 20ms)
	 */
	public void autonomousPeriodic() {
		double timeSecs = autonomousTimer.getSecs();

		// for the first second
		if (timeSecs < 2.0) {
			driveTrain.tankDrive(0.5, 0.5); // half speed - straight ahead
		} else {
			driveTrain.tankDrive(0, 0); // stopped
		}
		if (timeSecs > 5.0) {
//			solenoidOne.set(false);
//			solenoidTwo.set(true);
			solenoid.set(DoubleSolenoid.Value.kForward);
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run(); // This makes sure the values of items are correct on
							// the driver station during test mode.
	}
}
