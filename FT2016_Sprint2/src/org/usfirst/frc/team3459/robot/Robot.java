
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3459.robot.RobotMap;
import org.usfirst.frc.team3459.robot.PT_RobotDrive;
import org.usfirst.frc.team3459.robot.PT_SampleServoMechanism;

/**
 * Don't change the name of this or it won't work. (The manifest looks for "Robot")
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
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain = new PT_RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        // If we are using the robot where the front is the back
        driveTrain.setBackwards(true);
        mechanism = new PT_SampleServoMechanism(RobotMap.sampleServo);
        
        // Setup driver station controls
        leftDriveStick = new Joystick(RobotMap.driverStationDriveStickLeft);
        rightDriveStick = new Joystick(RobotMap.driverStationDriveStickRight);
        commandStick = new Joystick(RobotMap.driverStationCommandStick);
    }
    
    /**
     * This function is used to display credits
     */
    public void credits(){
    	//TODO: Change this to be YOUR team name
    	DriverStation.reportWarning("Put Yout Team Name Here", false);
    	DriverStation.reportWarning("--------------------------", false);    	
    }
    
    /**
     * This function is called once when we go into the teleop mode
     */
    public void teleopInit(){
    	credits();
    }
    
    /**
     * This function is called periodically during operator control (approx 20ms)
     */
    public void teleopPeriodic() {
    	double leftDriveSpeed = leftDriveStick.getY();
    	double rightDriveSpeed = rightDriveStick.getY();
    	
    	// Set Drivetrain motors
    	if(leftDriveStick.getTrigger() || rightDriveStick.getTrigger()){
    	   	// If either trigger is pressed, drive normal speed
    		driveTrain.tankDrive(leftDriveSpeed, rightDriveSpeed);
    	}
    	else{
    		// Otherwise, slow things down for easier turning
    		driveTrain.tankDrive(leftDriveSpeed / 2, rightDriveSpeed / 2);
    	}

    	if(commandStick.getTrigger()){
    		mechanism.open();
    	}
    	else{
    		mechanism.close();
    	}
    }

    /**
     * This function is called once when we go into the Autonomous mode
     */
    public void autonomousInit(){
    	credits();    	
    }

    /**
     * This function is called periodically during autonomous control (approx 20ms)
     */
    public void autonomousPeriodic() {
    	//TODO: Put Autonomous code here.   Must finish within 20 ms
    }

    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run(); // This makes sure the values of items are correct on the driver station during test mode.   
    }    
}
