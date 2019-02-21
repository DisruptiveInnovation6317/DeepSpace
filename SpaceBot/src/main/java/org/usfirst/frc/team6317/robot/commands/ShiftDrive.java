package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftDrive extends Command {

    @Override
    protected void initialize() {
        Robot.driveSystem.lifting = !Robot.driveSystem.lifting;
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}