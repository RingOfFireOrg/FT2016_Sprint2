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
 // for drive station ports
    public static int driverStationDriveStickLeft = 0;
    public static int driverStationDriveStickRight = 1;
}
