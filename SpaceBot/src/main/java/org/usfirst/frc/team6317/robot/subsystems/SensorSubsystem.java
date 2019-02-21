package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;

// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorSubsystem extends Subsystem {
	// public DigitalInput liftBottom = new DigitalInput(RobotMap.Sensors.LIFT_BOTTOM_LIMIT);
	public DigitalInput centerFollower = new DigitalInput(RobotMap.Sensors.LINE_FOLLOWER);
	public DigitalInput leftFollower = new DigitalInput(2);
	public DigitalInput rightFollower = new DigitalInput(3);

	public Encoder liftEncoder = new Encoder(0, 1);
	// ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public int currentLiftPos = 0;

	public SensorSubsystem() {
		// gyro.calibrate();
	}

	// public double getAngle() {
	// 	return gyro.getAngle();
	// }

	@Override
	protected void initDefaultCommand() {}

	public boolean getCenterFollower() {
		return centerFollower.get();
	}
}
