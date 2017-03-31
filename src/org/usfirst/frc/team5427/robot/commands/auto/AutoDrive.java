package org.usfirst.frc.team5427.robot.commands.auto;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * this class constantly inputs the Joystick axis into the driveTrain file,
 * causing the robot to move.
 */
public class AutoDrive extends Command {

	public static final int AUTO_NONE 		  = -1;
	public static final int BLUE_AUTO_LEFT 	  =  0; 
	public static final int BLUE_AUTO_MIDDLE  =  1;
	public static final int BLUE_AUTO_RIGHT	  =  2;
	public static final int RED_AUTO_LEFT	  =  3;
	public static final int RED_AUTO_MIDDLE   =  4;
	public static final int RED_AUTO_RIGHT    =  5;
	
	private int position;
	private long startTime;
	
	private double mag =-.3;
	private double curve =.3;
	
	public AutoDrive(int position) {
		requires(Robot.driveTrain);
		
		switch(position)
		{
		
		case BLUE_AUTO_LEFT:
			Log.info("Chose Blue Auto_Left selection");
			break;
		case BLUE_AUTO_MIDDLE:
			Log.info("Chose Blue Auto_Middle selection");
			break;
		case BLUE_AUTO_RIGHT:
			Log.info("Chose Blue Auto_Right selection");
			break;
		case RED_AUTO_LEFT:
			Log.info("Chose RED Auto_Left selection");
			break;
		case RED_AUTO_MIDDLE:
			Log.info("Chose RED Auto_Middle selection");
			break;
		case RED_AUTO_RIGHT:
			Log.info("Chose RED Auto_Right selection");
			break;
		default:
			Log.info("Did not chose an Autonomous modee");
		}
		
		this.position = position;
		setTimeout(15);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized Drive");
		startTime = System.nanoTime();

		SmartDashboard.putNumber("Time: ", time);
		SmartDashboard.putNumber("Mag: ", mag);
		SmartDashboard.putNumber("Curve: ", curve);
	}

	//TODO check this code for autonomous
	// Called repeatedly when this Command is scheduled to run

	private double forwardStartTime = -1;
	private double time = 3.5;
	
	/**
	 * TODO comment
	 */
	@SuppressWarnings("all")
	protected void execute() {

		Log.info("Time:"+getTime());
		Log.info("Pos:"+position);
	
	
		if(position == BLUE_AUTO_LEFT)
		{
			Log.info("BL");
			double timetoTurn = 7.8;
			if(getTime()<4.6)	{ 
				Robot.driveTrain.driveWPI(-0.3,.3);
			}
			else if(getTime()<4.6+3)	{ 
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			} else if (getTime() < timetoTurn) {
				Robot.driveTrain.driveWPI(0.3, 0);
			} else if (getTime() < (timetoTurn + .2)) {
				System.out.print("waiting to turn");
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			} else if (getTime() < (timetoTurn + .2 + 3.3)) {
				System.out.print("turning");
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT * -1);
				}
			else {
				end();
			}

		}
		else if(position == BLUE_AUTO_MIDDLE)
		{
			//testing
		//blue mid
//			Log.init("Starting Blue Autonomous Middle");
			if(getTime()<Config.AUTO_MIDDLE_START_DRIVE_TIME)
			{				
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else if(getTime()<Config.AUTO_MIDDLE_GEAR_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_BACK_OFF_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_BACKWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_BACKWARD_RIGHT);
			}
			else if(getTime()< Config.AUTO_MIDDLE_AFTER_BACK_DELAY)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_TURN_TO_GOAL_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT * -1);

			}
			else if (getTime() < Config.AUTO_MIDDLE_TURN_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_DRIVE_GOAL_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else {
				end();
			}

		}
		else if(position == BLUE_AUTO_RIGHT)
		{
			
			//blue right
			
			if(getTime()<5.6)	{ 
				Robot.driveTrain.driveWPI(-0.3,-.32);
			}
			else {
				end();
			}

		}
		else if(position == RED_AUTO_RIGHT)
		{
			//red right
			double timetoTurnRed = 8.8;
			if(getTime() < 5.6)	{ 
				Robot.driveTrain.driveWPI(-0.3,-.32);
			}
			else if(getTime() < 5.6+3)	{ 
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}	
			else if(getTime() < timetoTurnRed)	{ 
				Robot.driveTrain.driveWPI(0.3,0);		}
			else if(getTime() < (timetoTurnRed + .2) )	{ 
				System.out.print("waiting to turn");
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime() < (timetoTurnRed + .2 + 2.8))	{ 
				System.out.print("turning");
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT * -1);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT);
			}
			else {
				end();
			}
		}
		else if(position == RED_AUTO_MIDDLE)
		{
			Log.init("Starting Red Autonomous Middle");
			if(getTime()<Config.AUTO_MIDDLE_START_DRIVE_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else if(getTime()<Config.AUTO_MIDDLE_GEAR_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_BACK_OFF_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_BACKWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_BACKWARD_RIGHT);
			}
			else if(getTime()< Config.AUTO_MIDDLE_AFTER_BACK_DELAY)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_TURN_TO_GOAL_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT*-1);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT );
			}
			else if (getTime() < Config.AUTO_MIDDLE_TURN_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_DRIVE_GOAL_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else {
				end();
			}

		}
		else if(position == RED_AUTO_LEFT)
		{
			//redLeft
		if(getTime()<4.6)	{ 
			Robot.driveTrain.driveWPI(-0.3, .3);
		} 
		else
			{
			end();
		}
		}

	}
	
	/**
	 * 
	 * @return returns the number of milliseconds since autonomous started
	 */
	protected double getTime() {
		return (double) ((System.nanoTime() - startTime) / 1000000000f);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut() || getTime() > 15f;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}