package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorSubsystem extends Subsystem {
	// public DigitalInput liftBottom = new DigitalInput(RobotMap.Sensors.LIFT_BOTTOM_LIMIT);
	public DigitalInput centerFollower = new DigitalInput(RobotMap.Sensors.CENTER_FOLLOWER);
	public DigitalInput leftFollower = new DigitalInput(RobotMap.Sensors.LEFT_FOLLOWER);
	public DigitalInput rightFollower = new DigitalInput(RobotMap.Sensors.RIGHT_FOLLOWER);

	public Encoder liftEncoder = new Encoder(0, 1);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public int currentLiftPos = 0;

	public SensorSubsystem() {
		gyro.calibrate();
	}

	public void resetGyro() {
		try {
			gyro.reset();
		} catch (NullPointerException e) {
			
		}
	}

	public void calibrateGyro() {
		gyro.calibrate();
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	@Override
	protected void initDefaultCommand() {}

	public boolean getCenterFollower() {
		return centerFollower.get();
	}
}
