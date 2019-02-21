package org.usfirst.frc.team6317.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidSubsystem extends Subsystem{

    DoubleSolenoid grabber = new DoubleSolenoid(0,1);

    @Override
    protected void initDefaultCommand() { }

    public void shiftUp() {
        grabber.set(DoubleSolenoid.Value.kForward);
        // shiftUp(grabber);
    }

    public void shiftUp(DoubleSolenoid solenoid) {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void shiftDown() {
        grabber.set(DoubleSolenoid.Value.kReverse);
        // shiftDown(grabber);
    }

    public void shiftDown(DoubleSolenoid solenoid) {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

}