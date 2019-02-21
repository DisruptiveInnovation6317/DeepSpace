package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultLiftCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
	
	public SpeedController lift = new Victor(RobotMap.EndEffectors.LIFT);
	public SpeedController liftTilt = new Victor(RobotMap.EndEffectors.LIFT_TILT);
	
	public double speedMultiplier = 1;

	public LiftSubsystem() {
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultLiftCommand());
	}
	
	public void controlLift(double speed) {
        lift.set(speed);
	}
	
	public void controlTilt(double speed) {
		liftTilt.set(speed);
	}
}
