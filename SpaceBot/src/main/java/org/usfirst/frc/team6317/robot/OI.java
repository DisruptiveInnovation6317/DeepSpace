/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6317.robot;

import org.usfirst.frc.team6317.robot.commands.ShiftDrive;
import org.usfirst.frc.team6317.robot.commands.SolenoidShift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick driveStick = new Joystick(0);
	public static Joystick controlStickTwo = new Joystick(1);
	public static Joystick controlStick = new Joystick(2);
	Button driveShift = new JoystickButton(driveStick, 1);
	Button shiftUp = new JoystickButton(controlStick,1);
	Button shiftDown = new JoystickButton(controlStick, 2);


	public OI() {
		//baby seal mechanism
		shiftDown.whenPressed(new SolenoidShift(0));
		shiftUp.whenPressed(new SolenoidShift(1));

		// Deploys Mantis Arms
		// deloreanMeetGround.whenPressed(new HalfMantis());
		// delorean.whenPressed(new DeployMantis());

		// Toggles Mantis Drives
		driveShift.whenPressed(new ShiftDrive());
		// testing.whenPressed(new RunFor(0.0005));
	}
}
