
package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team5427.robot.OurClasses.*;

//import org.usfirst.frc.team5427.robot.commands.ExampleCommand;
import org.usfirst.frc.team5427.robot.util.Log;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.commands.PullRope;
import org.usfirst.frc.team5427.robot.commands.auto.AutoDrive;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.*;
import org.usfirst.frc.team5427.robot.subsystems.*;

// New imports
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	// motor for intake

	public static SpeedController motorPWM_Intake;
	
	//motor for agitator
	public static SpeedController motorPWM_Agitator;
	
	//motor for flap
	public static SpeedController motorPWM_Flap;

	// PWM Motors for Drive Train
	/**
	 * Motor utilized in the DriveTrain. It is located in the front left of the
	 * robot from a top-down point of view, and setting the speed of this motor
	 * to a positive value will cause the robot to move __________
	 */
	public static SpeedController motorPWM_FrontLeft;
	
	

	// TODO fill in the blank in this comment after testing the robot.
	/**
	 * Motor utilized in the DriveTrain. It is located in the rear left of the
	 * robot from a top-down point of view, and setting the speed of this motor
	 * to a positive value will cause the robot to move __________
	 */
	public static SpeedController motorPWM_RearLeft;

	// TODO fill in the blank in this comment after testing the robot.
	/**
	 * Motor utilized in the DriveTrain. It is located in the front right of the
	 * robot from a top-down point of view, and setting the speed of this motor
	 * to a positive value will cause the robot to move __________
	 */
	public static SpeedController motorPWM_FrontRight;

	// TODO fill in the blank in this comment after testing the robot.
	/**
	 * Motor utilized in the DriveTrain. It is located in the rear right of the
	 * robot from a top-down point of view, and setting the speed of this motor
	 * to a positive value will cause the robot to move __________
	 */
	public static SpeedController motorPWM_RearRight;

	/**
	 * SpeedControllers for TODO
	 */
	public static SpeedController motorPWM_Flywheel;
	public static SpeedController motorPWM_Flywheel2;

	 /** Rope Climb subsystem launcher for the robot to climb the rope
	 */
	public static RopeClimb ropeClimb;
	/**
	 * Drive train subsystem to drive the robot
	 */
	public static DriveTrain driveTrain;

	/**
	 * Drive command to drive the robot
	 */
	public static Drive drive;

	/**
	 * Pull command to pull the robot
	 */
	public static PullRope pull;
	
	
	Command autonomousCommand;
		/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		/** Initialize Steel Talon Motors */
		Log.init("Initializing SteelTalon Motors");
		motorPWM_FrontLeft = new SteelSpark(Config.FRONT_LEFT_MOTOR, Config.OFFSET_FRONT_LEFT_MOTOR_BACKWARD, Config.OFFSET_FRONT_LEFT_MOTOR_FORWARD, Config.BIAS_FRONT_LEFT_MOTOR_BACKWARD, Config.BIAS_FRONT_LEFT_MOTOR_FORWARD);
		motorPWM_RearLeft = new SteelSpark(Config.REAR_LEFT_MOTOR, Config.OFFSET_REAR_LEFT_MOTOR_BACKWARD, Config.OFFSET_REAR_LEFT_MOTOR_FORWARD, Config.BIAS_REAR_LEFT_MOTOR_BACKWARD, Config.BIAS_REAR_LEFT_MOTOR_FORWARD);
		motorPWM_FrontRight = new SteelSpark(Config.FRONT_RIGHT_MOTOR, Config.OFFSET_FRONT_RIGHT_MOTOR_BACKWARD,Config.OFFSET_FRONT_RIGHT_MOTOR_FORWARD, Config.BIAS_FRONT_RIGHT_MOTOR_BACKWARD,Config.BIAS_FRONT_RIGHT_MOTOR_FORWARD);
		motorPWM_RearRight = new SteelSpark(Config.REAR_RIGHT_MOTOR, Config.OFFSET_REAR_RIGHT_MOTOR_BACKWARD, Config.OFFSET_REAR_RIGHT_MOTOR_FORWARD, Config.BIAS_REAR_RIGHT_MOTOR_BACKWARD, Config.BIAS_REAR_RIGHT_MOTOR_FORWARD);
		Log.init("Initializing Flywheels...Shooter");
		motorPWM_Flywheel = new SteelSpark(Config.ROPE_CLIMB_MOTOR_2);	
		motorPWM_Flywheel2 = new SteelSpark(Config.ROPE_CLIMB_MOTOR);
		Log.init("Initialized all SteelSpark Motors!");
		
		/**Initialize Drive Train*/
		Log.init("Initializing Drive Train");
		driveTrain = new DriveTrain(motorPWM_FrontLeft, motorPWM_RearLeft, motorPWM_FrontRight, motorPWM_RearRight);
		Log.init("driveTrain initialized!");

		/* Initialize Subsystems */
		Log.init("Initializing Subsystems");

		Log.init("Initializing RopeClimb subsystem");
		ropeClimb = new RopeClimb(motorPWM_Flywheel,motorPWM_Flywheel2);
		Log.init("RopeClimb subsystem initialized!");


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
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Log.info("Starting autonomous");
		
		autonomousCommand = new AutoDrive(oi.getAutoChooser().getSelected());
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
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
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		driveTrain = new DriveTrain(motorPWM_FrontLeft, motorPWM_RearLeft, motorPWM_FrontRight, motorPWM_RearRight);
		drive = new Drive(driveTrain, oi.getJoy(), Config.JOYSTICK_MODE);
		drive.start();
		
		ropeClimb = new RopeClimb(motorPWM_Flywheel,motorPWM_Flywheel2);
		pull= new PullRope();
		pull.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}


}