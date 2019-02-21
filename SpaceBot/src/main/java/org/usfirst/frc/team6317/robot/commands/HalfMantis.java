package org.usfirst.frc.team6317.robot.commands;

// import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HalfMantis extends Command {

    /**
     * CHANGE THIS VALUE WITH THE ENCODER VALUE WHEN THE MOTORS HIT THE GROUND
     * THIS VALUE CAN BE FOUND IN SHUFFLE BOARD
     * IF STARTS WITH VALUE TAKE THE DIFFERENCE
     * TRY TO UNDERESIMATE THIS BY LIKE 1 LESS THAN THE VALUE!!!!
     */
    static int EncWhenGround = 0;

    public HalfMantis() {}

    @Override
    protected void initialize() {
        // Robot.mantisArms.resetEnc();
        // Robot.mantisArms.power(0.5);
    }

    protected void execute(){
        // if (EncWhenGround > 0) {
        //     if (Robot.mantisArms.getMidEnc() >= EncWhenGround)
        //         Robot.mantisArms.powerMid(0);
        //     else if (Robot.mantisArms.getBackEnc() >= EncWhenGround)
        //         Robot.mantisArms.powerBack(0);
        // } else {
        //     if (Robot.mantisArms.getMidEnc() <= EncWhenGround)
        //         Robot.mantisArms.powerMid(0);
        //     else if (Robot.mantisArms.getBackEnc() <= EncWhenGround)
        //         Robot.mantisArms.powerBack(0);
        // }
    }

    @Override
    protected boolean isFinished() {
        return true;
        // if (EncWhenGround > 0)
        //     return Robot.mantisArms.getMidEnc() >= EncWhenGround && Robot.mantisArms.getBackEnc() >= EncWhenGround;
        // else
        //     return Robot.mantisArms.getMidEnc() <= EncWhenGround && Robot.mantisArms.getBackEnc() <= EncWhenGround;
    }

    @Override
    protected void end() {
        // Robot.mantisArms.power(0);
    }

}