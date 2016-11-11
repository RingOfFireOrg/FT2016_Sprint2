package org.usfirst.frc.team3459.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
// No longer has to be backwards because now we are doing it in the "right" way 
    public static int leftMotor = 0;
    public static int rightMotor = 1;
//TODO: This should be renamed instead of sample to explain what it is doing    
    public static int sampleServo = 9;
 // for drive station ports
    public static int driverStationDriveStickLeft = 0;
    public static int driverStationDriveStickRight = 1;
    public static int driverStationCommandStick = 2;
    public static int s1 = 0;
    public static int s2 = 1;
    public static int trigger = 1;
}
