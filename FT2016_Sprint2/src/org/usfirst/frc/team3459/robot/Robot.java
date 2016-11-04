
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3459.robot.RobotMap;
import org.usfirst.frc.team3459.robot.PT_RobotDrive;
import org.usfirst.frc.team3459.robot.PT_Silverback_Tubes;
import org.usfirst.frc.team3459.robot.PT_Timer;

/**
 * Don't change the name of this or it won't work. (The manifest looks for "Robot")
 */
public class Robot extends IterativeRobot {
	
	/*
	 * Member variables go here 
	 */
	PT_RobotDrive driveTrain;
	PT_Silverback_Tubes mechanism;
	Joystick leftDriveStick;
	Joystick rightDriveStick;
	Joystick commandStick;
	PT_Timer autonomousTimer;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain = new PT_RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        // If we are using the robot where the front is the back
        driveTrain.setBackwards(true);
        mechanism = new PT_Silverback_Tubes(RobotMap.sampleServo);
        
        autonomousTimer = new PT_Timer();
        
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
    		mechanism.timedRelease(); 
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
    	autonomousTimer.reset();
    }

    // this is the time since beginning of autonomous period
    /**
     * This function is called periodically during autonomous control (approx 20ms)
     */
    public void autonomousPeriodic() {
    	double timeSecs = autonomousTimer.getSecs();
    	
    	// for the first second
    	if(timeSecs < 1.0){
    		driveTrain.tankDrive(0.5, 0.5);  // half speed - straight ahead
    	}
    	else{
    		driveTrain.tankDrive(0, 0);   // stopped
    	}
    	
    }

    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run(); // This makes sure the values of items are correct on the driver station during test mode.   
    }    
}
