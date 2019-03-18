package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftTill extends Command {

    // private int liftPosition;
    private boolean isHigher;
    private int liftPosition;
    private double endPosition;
    private static double encoders[] = {130850,// difference between 0 and 1
        79150,// difference between 1 and 2
        0}; 

	public LiftTill(int position) {
        this.requires(Robot.liftSystem);
        this.liftPosition = position;

        if (Robot.sensorSystem.currentLiftPos > this.liftPosition) {
            isHigher = true;
            // reset encoders
            if (position == 0 && Robot.sensorSystem.currentLiftPos == 2) {
                endPosition = (encoders[1] + encoders[0]);
            } else {
                endPosition = Robot.sensorSystem.liftEncoder.getDistance() + encoders[position];
            }
            // if (position == 0 && Robot.sensorSystem.currentLiftPos == 2) {
            //     endPosition = -(encoders[1] + encoders[0]);
            // } else if (position != 0) {
            //     endPosition = Robot.sensorSystem.liftEncoder.getDistance() - encoders[position-1];
            // }
        } else {
            isHigher = false;

            if (position == 2 && Robot.sensorSystem.currentLiftPos == 0) {
                endPosition = -(encoders[1] + encoders[0]);
            } else if (position != 0) {
                endPosition = Robot.sensorSystem.liftEncoder.getDistance() - encoders[position-1];
            }
            // for (int i = Robot.sensorSystem.currentLiftPos; i < position; i++) {
            //     endPosition += encoders[i];
            // }
        }
        
        // Robot.sensorSystem.currentLiftPos = position;

        // isHigher = (Robot.sensorSystem.liftEncoder.getDistance() > encoders[position]);
	}
	
	@Override
	protected void execute() {
        if (isHigher)
            Robot.liftSystem.controlLift(1);
        else
            Robot.liftSystem.controlLift(-1);
	}

	@Override
	protected boolean isFinished() {
        if (isHigher)
            return (Robot.sensorSystem.liftEncoder.getDistance() > endPosition);
        else
		    return (Robot.sensorSystem.liftEncoder.getDistance() < endPosition);
    }
    
    @Override
    protected void end() {
        Robot.liftSystem.controlLift(0);
        Robot.sensorSystem.currentLiftPos = liftPosition;
    }
}
