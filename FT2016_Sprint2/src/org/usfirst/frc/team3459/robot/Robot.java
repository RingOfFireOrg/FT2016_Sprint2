
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3459.robot.RobotMap;
import org.usfirst.frc.team3459.robot.PT_RobotDrive;

/**
 * Don't change the name of this or it won't work. (The manifest looks for "Robot")
 */
public class Robot extends IterativeRobot {
	
	/*
	 * Member variables go here 
	 */
	PT_RobotDrive driveTrain;
	Joystick leftDriveStick;
	Joystick rightDriveStick;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain = new PT_RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        // If we are using the robot where the front is the back
        driveTrain.setBackwards(true);
        leftDriveStick = new Joystick(RobotMap.driverStationDriveStickLeft);
        rightDriveStick = new Joystick(RobotMap.driverStationDriveStickRight);
    }
    
    /**
     * This function is called once when we go into the teleop mode
     */
    public void teleopInit(){
    	System.out.println("Team Name");  	
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run(); // This makes sure the values of items are correct on the driver station during test mode.   
    }    
}
