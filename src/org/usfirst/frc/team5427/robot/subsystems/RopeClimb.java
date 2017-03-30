package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The RopeClimb subsystem is used to control the motors used in the PullRope
 * command, which is used to control the motors used to climb the rope.
 * 
 * @author Blake Romero
 *
 */
public class RopeClimb extends Subsystem {

	/**
	 * SpeedControllers which are responsible for the wheels that pull the rope
	 * into the robot.
	 */
	public SpeedController motorPWM_Flywheel_1;
	public SpeedController motorPWM_Flywheel_2;

	/**
	 * RopeClimb constructor -- Initializes the motor for the RopeClimb subsystem.
	 * 
	 * @param motorFlyWheel - The motor used to control the RopeClimb.
	 */
	public RopeClimb(SpeedController motorPWM_Flywheel_1,SpeedController motorPWM_Flywheel_2) {
		this.motorPWM_Flywheel_1 = motorPWM_Flywheel_1;
		this.motorPWM_Flywheel_2=motorPWM_Flywheel_2;
		Log.init("FINISHED MAKING A NEW RopeClimb");
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Sets the motor's speed to zero.
	 */
	public void stop() {
		setPullSpeed(0);
	}
	
	public void throttleUp()
	{
		if(Robot.oi.getJoy().getThrottle()>0)
			stop();
		else if(Robot.oi.getJoy().getThrottle()>=1)
			setPullSpeed(1);
		else
			setPullSpeed(Robot.oi.getJoy().getThrottle());
	}

	/**
	 * Sets the speed of the RopeClimb to the desired speed.
	 * 
	 * @param speed - The desired speed of the RopeClimb.
	 */
	public void setPullSpeed(double speed) {
		// Prevent speed from going to fast
		if (speed > 1)
			speed = 1;
		else if (speed < -1)
			speed = -1;

		motorPWM_Flywheel_1.set(speed);
		motorPWM_Flywheel_2.set(speed);
	}
}