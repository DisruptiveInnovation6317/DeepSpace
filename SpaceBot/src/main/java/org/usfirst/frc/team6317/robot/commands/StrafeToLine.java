package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StrafeToLine extends Command {
    // White returns false for line sensor

    @Override
    protected void initialize() {
        Robot.driveSystem.strafeRight();
    }

    @Override
    protected void execute() {
        if (!Robot.sensorSystem.leftFollower.get())
            Robot.driveSystem.strafeLeft();
        else if (!Robot.sensorSystem.rightFollower.get())
            Robot.driveSystem.strafeRight();
    }

    @Override
    protected boolean isFinished() {
        return !Robot.sensorSystem.getCenterFollower();
    }

    @Override
    protected void end() {
        Robot.driveSystem.drive(0);
    }

}