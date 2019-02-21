package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class RunFor extends Command {

	private double hours;
	private double seconds;
	Timer timing = new Timer();
	private double startTime;
	
	public RunFor() {
		this.hours = 1;
	}
	
	public RunFor(double hours) {
		this.hours = hours;
	}

	@Override
	protected void initialize() {
		this.seconds = hours * 3600;
		this.startTime = Timer.getFPGATimestamp();
	}

	@Override
	protected void execute() {
		Robot.liftSystem.controlLift(1.0);
	}
	
	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() - startTime > seconds;
	}

	@Override
	protected void end() {
		Robot.driveSystem.drive(0);
	}
	
}
