/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6317.robot;

import org.usfirst.frc.team6317.robot.commands.CalibrateGyro;
import org.usfirst.frc.team6317.robot.commands.CancelCommands;
import org.usfirst.frc.team6317.robot.commands.LiftPositions;
import org.usfirst.frc.team6317.robot.commands.LiftTill;
import org.usfirst.frc.team6317.robot.commands.ShiftDrive;
import org.usfirst.frc.team6317.robot.commands.SolenoidShift;
import org.usfirst.frc.team6317.robot.commands.StrafeToLine;
import org.usfirst.frc.team6317.robot.commands.TurnToRocket;

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

	// Shifts Drive Modes
	Button driveShift = new JoystickButton(driveStick, 1);

	// Shifts the solenoid cylinder up and down
	Button shiftUp = new JoystickButton(controlStick,1);
	Button shiftDown = new JoystickButton(controlStick, 2);

	// Strafes to the lines
	Button toLineLeft = new JoystickButton(driveStick, 5);
	Button toLineRight = new JoystickButton(driveStick, 6);

	Button turning = new JoystickButton(driveStick, 3);
	Button cancelStrafe = new JoystickButton(driveStick, 4);

	// Lifts to specific heights
	// 7 9 11
	Button toZero = new JoystickButton(controlStick, 3);
	Button toOne = new JoystickButton(controlStick, 4);
	Button toTwo = new JoystickButton(controlStick, 5);
	Button cancel = new JoystickButton(controlStick, 6);


	public OI() {
		//baby seal mechanism
		shiftDown.whenPressed(new SolenoidShift(0));
		shiftUp.whenPressed(new SolenoidShift(1));

		toLineLeft.whenPressed(new StrafeToLine('l'));
		toLineRight.whenPressed(new StrafeToLine('r'));

		// Deploys Mantis Arms
		// deloreanMeetGround.whenPressed(new HalfMantis());
		// delorean.whenPressed(new DeployMantis());

		// Toggles Mantis Drives
		driveShift.whenPressed(new ShiftDrive());
		// testing.whenPressed(new RunFor(0.0005));

		turning.whenPressed(new TurnToRocket());
		cancelStrafe.whenPressed(new CancelCommands());

		toZero.whenPressed(new LiftPositions(0));
		toOne.whenPressed(new LiftPositions(1));
		toTwo.whenPressed(new LiftPositions(2));
		cancel.whenPressed(new CancelCommands());
		
	}
}
