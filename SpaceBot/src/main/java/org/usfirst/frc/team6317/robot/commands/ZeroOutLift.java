package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ZeroOutLift extends Command {

    boolean setZero = false;

    public ZeroOutLift() {
        requires(Robot.liftSystem);
    }

    @Override
    protected void execute() {
        if (!setZero) {
            setZero = Robot.sensorSystem.liftBottom.get();
            if (!setZero) {
                Robot.liftSystem.controlLift(1.0);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}