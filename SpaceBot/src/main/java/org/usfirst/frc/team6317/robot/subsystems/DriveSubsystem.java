package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	
	SpeedController fl = new Victor(RobotMap.Drive.FRONT_LEFT);
	SpeedController bl = new Victor(RobotMap.Drive.BACK_LEFT);
	SpeedController fr = new Victor(RobotMap.Drive.FRONT_RIGHT);
	SpeedController br = new Victor(RobotMap.Drive.BACK_RIGHT);

	SpeedController mantisDrive = new Victor(RobotMap.EndEffectors.MANTIS_DRIVE);

	public boolean lifting = false;
	
	public double speedMultiplier = 1;

	public DriveSubsystem() {
		fl.setInverted(true);
		bl.setInverted(true);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}
	
	public void drive(double speed) {
		drive(speed,speed);
	}
	
	public void drive(double leftSpeed, double rightSpeed) {
		drive(leftSpeed,rightSpeed,leftSpeed,rightSpeed);
	}
	
	public void drive(double flSpeed, double frSpeed, double blSpeed, double brSpeed) {
		fl.set(flSpeed);
		fr.set(frSpeed);
		bl.set(blSpeed);
		br.set(brSpeed);

	}

	public void powerDrive(double speed) {
        mantisDrive.set(speed);
	}
	
	public void strafeRight() {
		mecanumDrive(0, 1, 0, 1);
	}

	public void strafeLeft() {
		mecanumDrive(0, -1, 0, 1);
	}
	
	public void mecanumDrive(double y, double x, double z, double throttle) {
		this.speedMultiplier = throttle;
			
		speedMultiplier += 1;
		speedMultiplier = Math.abs((speedMultiplier / 2) - 1);
		z *= 0.75;

		fl.set(clip(-z + y - x) * speedMultiplier);
		bl.set(clip(-z + y + x)* speedMultiplier);
		br.set(clip(z + y - x)* speedMultiplier);
		fr.set(clip(z + y + x)* speedMultiplier);
	}
	
	private double clip (double speed) {
		return (speed > 1 ? 1 : speed < -1 ? -1 : speed);
	}

}
