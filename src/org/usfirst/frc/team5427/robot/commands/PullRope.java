package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;
import org.usfirst.frc.team5427.robot.Robot;

/**
 * The PullRope class is used to start and stop the motor(s) used to pull the
 * rope into the robot.
 * 
 * @author Blake Romero
 *
 */
public class PullRope extends Command {

	public PullRope() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.ropeClimb);

	}

	/**
	 * sets the speed of the pulling mechanism to the speed defined in the
	 * configuration file.
	 */
	protected void initialize() {
		Log.init("Initialized Pull");
		Robot.ropeClimb.throttleUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.ropeClimb.throttleUp();
	}

	//returns true if the button in config is released
	protected boolean isFinished() {
	
			return false;
	}

	//stops pulling on the rope
	protected void end() {
		Robot.ropeClimb.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
