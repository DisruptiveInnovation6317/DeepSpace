package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunHour extends CommandGroup {

	public RunHour() {
		addSequential(new RunFor(1));
	}

}
