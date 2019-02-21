package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftTill extends Command {

    // private int liftPosition;
    private boolean isHigher;
    private double endPosition;
    private static double encoders[] = {100,// difference between 0 and 1
        200}; // difference between 1 and 2

	public LiftTill(int position) {
        this.requires(Robot.liftSystem);
        // liftPosition = position;

        if (Robot.sensorSystem.currentLiftPos > position) {
            isHigher = true;
            // reset encoders
            Robot.sensorSystem.liftEncoder.reset();
            for (int i = Robot.sensorSystem.currentLiftPos; i > position; i--) {
                endPosition += encoders[i];
            }
        } else {
            isHigher = false;
            Robot.sensorSystem.liftEncoder.reset();
            for (int i = Robot.sensorSystem.currentLiftPos; i < position; i++) {
                endPosition += encoders[i];
            }
        }

        
        Robot.sensorSystem.currentLiftPos = position;

        // isHigher = (Robot.sensorSystem.liftEncoder.getDistance() > encoders[position]);
	}
	
	@Override
	protected void execute() {
        if (isHigher)
            Robot.liftSystem.controlLift(-1);
        else
            Robot.liftSystem.controlLift(1);
	}

	@Override
	protected boolean isFinished() {
		return (Robot.sensorSystem.liftEncoder.getDistance() > endPosition);
    }
    
    @Override
    protected void end() {
        Robot.liftSystem.controlLift(0);
    }
}
