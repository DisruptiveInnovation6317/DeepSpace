package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultSensorCommand extends Command {


	public DefaultSensorCommand() {
		this.requires(Robot.driveSystem);
	}
	
	@Override
	protected void execute() {
		Robot.driveSystem.mecanumDrive(OI.driveStick.getY(), OI.driveStick.getX(), OI.driveStick.getZ(), OI.driveStick.getThrottle());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}