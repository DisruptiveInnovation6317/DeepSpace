package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// when lift goes up, encoders go down

public class LiftPositions extends Command {
    private final int BOTTOM_MIDDLE_DIFF = 163671;
    private final int TOP_MIDDLE_DIFF = 140559;
    private final int BOTTOM_TOP_DIFF = BOTTOM_MIDDLE_DIFF + TOP_MIDDLE_DIFF;

    private boolean atLevel = false;

    private double encDiff;
    private double finalPosition;

    private int pos;

    public static int diff = 0;

    public LiftPositions(int position) {

        this.requires(Robot.liftSystem);
        this.pos = position;
    }

    @Override
    protected void initialize() {
        diff = this.pos - Robot.sensorSystem.currentLiftPos;
        if (diff == 0) {
            atLevel = true;
            return;
        }

        if (Math.abs(diff) == 2) { // No matter what difference will always be the same because its top to bottom
            if (diff > 0)
                encDiff = -BOTTOM_TOP_DIFF;
            else
                encDiff = BOTTOM_TOP_DIFF;
        } else if (diff > 0) {
            if (this.pos == 1) // If we are going from 0 to 1
                encDiff = -BOTTOM_MIDDLE_DIFF;
            else // If we are going from 1 to 2
                encDiff = -TOP_MIDDLE_DIFF;
        } else {
            if (this.pos == 1) // If we are going from 2 to 1
                encDiff = TOP_MIDDLE_DIFF;
            else // If we are going from 1 to 0
                encDiff = BOTTOM_MIDDLE_DIFF;
        }

        finalPosition = Robot.sensorSystem.liftEncoder.getDistance() + encDiff;

        if (encDiff > 0) { // If encDiff is greater than zero than the lift needs to go downward
            Robot.liftSystem.lift.set(1.0);
        } else { // If encDiff is less than zero than the lift needs to go upwards
            Robot.liftSystem.lift.set(-1.0);
        }
    }

    @Override
    protected boolean isFinished() {
        double liftEncoder = Robot.sensorSystem.liftEncoder.getDistance();
        if (encDiff > 0) // If encDiff is greater than 0 than that means finalPosition will be greater than the starting position
            return atLevel || liftEncoder > finalPosition;
        else // If encDiff is less than 0 than that means final Position will be less than the starting position
            return atLevel || liftEncoder < finalPosition;
    }

    @Override
    protected void end() {
        Robot.liftSystem.lift.set(0);
        Robot.sensorSystem.currentLiftPos = this.pos;
    }
}