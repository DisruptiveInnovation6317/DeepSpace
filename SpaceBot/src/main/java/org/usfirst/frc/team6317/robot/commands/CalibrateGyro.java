package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CalibrateGyro extends Command {

    public CalibrateGyro() {
        this.requires(Robot.sensorSystem);
        Robot.sensorSystem.calibrateGyro();
        Robot.sensorSystem.gyro.reset();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}