/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6317.robot;

import org.usfirst.frc.team6317.robot.commands.RunHour;
import org.usfirst.frc.team6317.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team6317.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team6317.robot.subsystems.MantisSubsystem;
import org.usfirst.frc.team6317.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team6317.robot.subsystems.SolenoidSubsystem;

 //import edu.wpi.cscore.UsbCamera;
 //import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveSubsystem driveSystem = new DriveSubsystem();
	public static final LiftSubsystem liftSystem = new LiftSubsystem();
	public static final SensorSubsystem sensorSystem = new SensorSubsystem();
	public static final SolenoidSubsystem solenoid = new SolenoidSubsystem();
	public static final MantisSubsystem mantisArms = new MantisSubsystem();
	public static OI m_oi;

//	public static int activeCamera = 1;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	// UsbCamera frontCamera;
	// UsbCamera backCamera;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addOption("Running for Hour", new RunHour());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);

		// Initializes the Cameras
	//	 frontCamera = new UsbCamera("Front Camera",0);
	//	 frontCamera.setResolution(400,280);
	//	 frontCamera.setFPS(20);

		// backCamera = new UsbCamera("Back Camera", 1);
		// backCamera.setResolution(400,280);
		// backCamera.setFPS(20);

	//	 CameraServer.getInstance().startAutomaticCapture(frontCamera);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("seriously, this is not a joke. doge is in my nightmares.", 1);
		SmartDashboard.putNumber("Lift Value", sensorSystem.liftEncoder.getDistance());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	@Override
	public void robotPeriodic() { 
		SmartDashboard.putBoolean("Is Lifting", driveSystem.lifting);
		// SmartDashboard.putNumber("MID ENCODER", mantisArms.getMidEnc());
		// SmartDashboard.putNumber("BACK ENCODER", mantisArms.getBackEnc());
		// SmartDashboard.putNumber("OTHER MID ENCODER", mantisArms.getOtherMidEnc());
		SmartDashboard.putBoolean("Line Follower", sensorSystem.getCenterFollower());
	//	 SmartDashboard.putString("Camera Value", CameraServer.getInstance().toString());

	//	 if (activeCamera == 0 && CameraServer.getInstance().toString() != "Front Camera") {
	//	 	CameraServer.getInstance().removeCamera("Front Camera");
		 	//CameraServer.getInstance().startAutomaticCapture(backCamera);
	//	 } else if (activeCamera == 1 && CameraServer.getInstance().toString() != "Back Camera") {
	//	 	CameraServer.getInstance().removeCamera("Back Camera");
	//	 	CameraServer.getInstance().startAutomaticCapture(frontCamera);
		 }

	}
//}
