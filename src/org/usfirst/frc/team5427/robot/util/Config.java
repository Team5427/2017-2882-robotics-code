package org.usfirst.frc.team5427.robot.util;

//TODO FIXED CODE fEB 20 2017
/**
 * This file will store ALL of the variables, offsets, measurements, etc. that
 * our robot will use during the year. All variables are to be static, and
 * nothing in this file should ever have to be initiated.
 * 
 * @author Andrew Kennedy, Bo Corman
 *
 */
public class Config {

	/**
	 * <p>
	 * The name of the program that will be used in the console, or anywhere
	 * else applicable.
	 * </p>
	 */
	public static final String PROGRAM_NAME = "Team5427RoboCode";
	/**
	 * <p>
	 * If true, then every call to <code>Log.debug()</code> will be printed in
	 * the console.
	 * </p>
	 * <p>
	 * If false, then all calls to this method will be ignored, saving the
	 * console from any spam created from debugging.
	 * </p>
	 */
	public static final boolean DEBUG_MODE = true;
	/**
	 * <p>
	 * This controls all print statements sent through <code>Log.java</code>,
	 * besides <code>Log.error</code> and <code>Log.fatal</code>.
	 * </p>
	 * <p>
	 * If true, then all printing not excluded by this method will be displayed
	 * in the console. If false, it will not.
	 * </p>
	 */
	public static final boolean LOGGING = true; // only logs errors and fatals
												// with this false
	// Speeds for the different things that the robot needs to do
	// Controlled by grip
												// later

	/*----------PWM PORTS-----------*/
	// TODO reassign motor values	
	public static final int FRONT_RIGHT_MOTOR 	= 0;
	public static final int REAR_RIGHT_MOTOR	= 1;
	public static final int FRONT_LEFT_MOTOR	= 2;
	public static final int REAR_LEFT_MOTOR 	= 3;
	public static final int ROPE_CLIMB_MOTOR    = 4;
	public static final int ROPE_CLIMB_MOTOR_2	= 5;	
	
	/*----------MULTIPLIERS AND DEADSETS----------*/
	public static final double DRIVE_TRAIN_MULTIPLIER = 1;
	public static final double DEADSET_DIF=.01;
	
	// Motor Bias
	public static final double BIAS_FRONT_LEFT_MOTOR_FORWARD  = 1;//.87;
	public static final double BIAS_FRONT_LEFT_MOTOR_BACKWARD = 1;//.94192;

	public static final double BIAS_REAR_LEFT_MOTOR_FORWARD    = 1;//.87;
	public static final double BIAS_REAR_LEFT_MOTOR_BACKWARD   = 1;//.94192;

	public static final double BIAS_FRONT_RIGHT_MOTOR_FORWARD  = 1;//1
	public static final double BIAS_FRONT_RIGHT_MOTOR_BACKWARD = 1;//1

	public static final double BIAS_REAR_RIGHT_MOTOR_FORWARD   = 1;//1
	public static final double BIAS_REAR_RIGHT_MOTOR_BACKWARD  = 1;//1

	public static final double BIAS_SHOOTER_MOTOR_FORWARD  	   = 1;//1
	public static final double BIAS_SHOOTER_MOTOR_BACKWARD     = 1;//1

	public static final double BIAS_INTAKE_MOTOR_FORWARD       = 1;//1
	public static final double BIAS_INTAKE_MOTOR_BACKWARD      = 1;//1

	// Motor Offset
	public static final double OFFSET_FRONT_LEFT_MOTOR_FORWARD  = 0;//0
	public static final double OFFSET_FRONT_LEFT_MOTOR_BACKWARD = 0;//0

	public static final double OFFSET_REAR_LEFT_MOTOR_FORWARD    = 0;//0
	public static final double OFFSET_REAR_LEFT_MOTOR_BACKWARD   = 0;//0

	public static final double OFFSET_FRONT_RIGHT_MOTOR_FORWARD  = 0;//0
	public static final double OFFSET_FRONT_RIGHT_MOTOR_BACKWARD = 0;//0

	public static final double OFFSET_REAR_RIGHT_MOTOR_FORWARD   = 0;//0
	public static final double OFFSET_REAR_RIGHT_MOTOR_BACKWARD  = 0;//0

	public static final double OFFSET_SHOOTER_MOTOR_FORWARD  = 0;//0
	public static final double OFFSET_SHOOTER_MOTOR_BACKWARD = 0;//0

	public static final double OFFSET_INTAKE_MOTOR_FORWARD  = 0;//0
	public static final double OFFSET_INTAKE_MOTOR_BACKWARD = 0;//0

	// motor speeds

	public static final double PULL_SPEED = -1; 
 
	/* ----------Controller Ports---------- */
	// Joystick
	public static final int JOYSTICK_PORT = 0;
	public static final int ALT_JOYSTICK_PORT = 0;
	public static final int ONE_JOYSTICK = 0; // static var for above
	public static final int TWO_JOYSTICKS = 1; // static var for above
	public static final int JOYSTICK_MODE = ONE_JOYSTICK; // Set this to either
															// ONE_JOYSTICK or
	/*------------speed for auto-------*/
	public static final double AUTO_FULL_SPEED_FORWARD_LEFT  = -.25;
	public static final double AUTO_FULL_SPEED_FORWARD_RIGHT = -.30;
	@Deprecated
	public static final double AUTO_FULL_SPEED_BACKWARD = .3;
	
	public static final double AUTO_FULL_SPEED_BACKWARD_LEFT  = .26;
	public static final double AUTO_FULL_SPEED_BACKWARD_RIGHT = .30;
	
	public static final double AUTO_FULL_TURN_SPEED_RIGHT = .3;
	public static final double AUTO_FULL_TURN_SPEED_LEFT = .3;	

	
	/*------------timings for auto-------*/
	//General Constants
	public static final double AUTO_GEAR_WAIT_TIME = 3;
	public static final double AUTO_BACK_OFF_TIME = 0;
	public static final double AUTO_SHOOT_TIME = 0;
	public static final double LEFT_TIMEOUT = 60;
	public static final double MIDDLE_TIMEOUT = 60;
	public static final double RIGHT_TIMEOUT = 60;
	public static final double FLAP_OPEN_TIMEOUT = 1;
	public static final double FLAP_CLOSE_TIMEOUT= 1;
	public static final double AUTO_DELAY = .6;
	public static final double MOMENTUM_OFFSET_TURNING_RIGHT=11;
	public static final double MOMENTUM_OFFSET=6;
	//Left Side
	public static final double AUTO_LEFT_START_DRIVE_TIME = 2.5; // 2.55;
	public static final double AUTO_LEFT_BEFORE_TURN_DELAY= AUTO_LEFT_START_DRIVE_TIME +AUTO_DELAY;
	public static double AUTO_LEFT_TURN_TO_GEAR_TIME = AUTO_LEFT_BEFORE_TURN_DELAY+ .44;//.751;//.76;too much//.75 too little//.7;Too little//1;Too long//.5;Too short//0.332 Tooo short;
	public static final double A_LT_TURN_GEAR_DEG= 69-MOMENTUM_OFFSET_TURNING_RIGHT;		// Actual good angle is 60
	public static final double AUTO_LEFT_AFTER_TURN_DELAY= AUTO_LEFT_TURN_TO_GEAR_TIME +AUTO_DELAY;
	public static final double AUTO_LEFT_DRIVE_TO_GEAR_TIME =AUTO_LEFT_AFTER_TURN_DELAY + 1.6;//1.65;//1.6;Too little//1.3;Too little
	public static final double AUTO_LEFT_GEAR_WAIT_TIME = AUTO_LEFT_DRIVE_TO_GEAR_TIME+AUTO_GEAR_WAIT_TIME;
	public static final double AUTO_LEFT_BACK_OFF_TIME = AUTO_LEFT_GEAR_WAIT_TIME+0;//+AUTO_BACK_OFF_TIME;
	public static final double AUTO_LEFT_TURN_TO_GOAL_TIME =AUTO_LEFT_BACK_OFF_TIME+ 0;
	public static final double AUTO_LEFT_SHOOT_TIME =AUTO_LEFT_TURN_TO_GOAL_TIME+ 0;//+AUTO_SHOOT_TIME;
	//Middle
	public static final double AUTO_MIDDLE_START_DRIVE_TIME = 2.4;
	public static final double AUTO_MIDDLE_GEAR_WAIT_TIME = AUTO_MIDDLE_START_DRIVE_TIME + AUTO_GEAR_WAIT_TIME;
	public static final double AUTO_MIDDLE_BACK_OFF_TIME = AUTO_MIDDLE_GEAR_WAIT_TIME + 1;//+AUTO_BACK_OFF_TIME;
	public static final double AUTO_MIDDLE_AFTER_BACK_DELAY = AUTO_MIDDLE_BACK_OFF_TIME + AUTO_DELAY;
	public static final double MIDDLE_TURN_ANGLE= 98.5-MOMENTUM_OFFSET;
	public static double AUTO_MIDDLE_TURN_TO_GOAL_TIME = AUTO_MIDDLE_AFTER_BACK_DELAY + 1.8;
	public static final double AUTO_MIDDLE_TURN_WAIT_TIME = AUTO_MIDDLE_TURN_TO_GOAL_TIME + AUTO_DELAY;
	public static final double AUTO_MIDDLE_DRIVE_GOAL_TIME = AUTO_MIDDLE_TURN_WAIT_TIME + 1; // .51 too much
	public static final double AUTO_MIDDLE_SHOOT_TIME = AUTO_MIDDLE_TURN_WAIT_TIME + 10;//+AUTO_SHOOT_TIME;
	//Right Side
	public static final double AUTO_RIGHT_START_DRIVE_TIME = 2.195;
	public static final double AUTO_RIGHT_BEFORE_TURN_DELAY = AUTO_RIGHT_START_DRIVE_TIME+AUTO_DELAY;
	public static double AUTO_RIGHT_TURN_TO_GEAR_TIME = AUTO_RIGHT_BEFORE_TURN_DELAY + 0.44;
	public static final double A_RT_TURN_GEAR_DEG= 61-MOMENTUM_OFFSET;
	public static final double AUTO_RIGHT_AFTER_TURN_DELAY = AUTO_RIGHT_TURN_TO_GEAR_TIME+AUTO_DELAY;
	public static final double AUTO_RIGHT_DRIVE_TO_GEAR_TIME =AUTO_RIGHT_AFTER_TURN_DELAY+ 1.85;
	public static final double AUTO_RIGHT_GEAR_WAIT_TIME = AUTO_RIGHT_DRIVE_TO_GEAR_TIME+AUTO_GEAR_WAIT_TIME;
	public static final double AUTO_RIGHT_BACK_OFF_TIME = AUTO_RIGHT_GEAR_WAIT_TIME+0;//+AUTO_BACK_OFF_TIME;
	public static final double AUTO_RIGHT_TURN_TO_GOAL_TIME =AUTO_RIGHT_BACK_OFF_TIME+ 0;
	public static final double AUTO_RIGHT_SHOOT_TIME =AUTO_RIGHT_TURN_TO_GOAL_TIME+ 0;//+AUTO_SHOOT_TIME;

	public static final int PULL_BUTTON = 8;
}
