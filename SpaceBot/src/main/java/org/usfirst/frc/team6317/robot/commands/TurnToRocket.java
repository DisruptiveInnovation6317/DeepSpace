package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToRocket extends Command {

    final double TURN_SPEED = 0.5;

    double angles[] = {28.75, 151.25, (360-151.25), (360-28.75)};
    double endPosition;

    public TurnToRocket() {
        requires(Robot.driveSystem);
    }

    @Override
    protected void initialize() {
        double heading = (Robot.sensorSystem.getAngle() + (360*50));

        double angle = heading % 360;
        int quadrant = (int)(angle / 90);
        endPosition = angles[quadrant];
    }

    @Override
    protected void execute() {
        double heading = (Robot.sensorSystem.getAngle() + (360*50));

        if ((heading%360) < endPosition - 2) 
            Robot.driveSystem.turnRight(TURN_SPEED);
        else if ((heading%360) > endPosition + 2)
            Robot.driveSystem.turnLeft(TURN_SPEED);
        else
            Robot.driveSystem.drive(0);
    }

    @Override
    protected boolean isFinished() {
        double heading = (Robot.sensorSystem.getAngle() + (360*50));

        return (((heading%360) > endPosition - 2) &&
         ((heading%360) < endPosition + 2)) || Robot.shouldCancel;
    }
    
    @Override
    protected void end() {
        Robot.driveSystem.drive(0);
        Robot.shouldCancel = false;
    }

}