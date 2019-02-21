package org.usfirst.frc.team6317.robot.commands;

// import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DeployMantis extends Command {

    public DeployMantis() {}

    @Override
    protected void initialize() {
        // Robot.mantisArms.power();
    }

    protected void execute(){
        // Robot.mantisArms.power(1.0);
    }

    @Override
    protected boolean isFinished() {
        return true;
        // return Robot.mantisArms.getSwitch();
    }

    @Override
    protected void end() {
        // Robot.mantisArms.power(0);
    }

}