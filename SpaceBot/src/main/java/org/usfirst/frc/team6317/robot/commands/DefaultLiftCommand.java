package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultLiftCommand extends Command {


	public DefaultLiftCommand() {
		this.requires(Robot.liftSystem);
		// this.requires(Robot.mantisArms);
	}
	
	@Override
	protected void execute() {
		Robot.liftSystem.controlLift(OI.controlStick.getY());
		Robot.liftSystem.controlTilt(OI.controlStick.getX());

		// Robot.mantisArms.powerMid(OI.controlStickTwo.getY());
		// Robot.mantisArms.powerBack(OI.controlStick.getY());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
