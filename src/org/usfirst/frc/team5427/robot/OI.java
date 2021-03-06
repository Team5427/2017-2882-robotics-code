package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.auto.AutoDrive;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	/**
	 * Primary joystick
	 */
	public Joystick joy = new Joystick(Config.JOYSTICK_PORT);
	/**
	 * Alternate joystick. Currently unused
	 */
	public Joystick altJoy = new Joystick(Config.ALT_JOYSTICK_PORT);

	/**
	 * Sendable chooser for autonomous selection
	 */
	private SendableChooser<Integer> autoChooser = new SendableChooser<>();

	
	/**
	 * Constructor for the OI class, defines the button-press events.
	 */
	public OI() {
		// TODO tie the right buttons to the right commands
		
		autoChooser.addDefault("              ",	AutoDrive.AUTO_NONE);
		autoChooser.addObject("BlueAutoDriveLeft  ", AutoDrive.BLUE_AUTO_LEFT);
		autoChooser.addObject("BlueAutoDriveMiddle", AutoDrive.BLUE_AUTO_MIDDLE);
		autoChooser.addObject("BlueAutoDriveRight ", AutoDrive.BLUE_AUTO_RIGHT);
		autoChooser.addObject("RedAutoDriveLeft ", AutoDrive.RED_AUTO_LEFT);
		autoChooser.addObject("RedAutoDriveMiddle ", AutoDrive.RED_AUTO_MIDDLE);
		autoChooser.addObject("RedAutoDriveRight ", AutoDrive.RED_AUTO_RIGHT);
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
	}

	/**
	 * returns the joystick object
	 * @return the joystick
	 */
	public Joystick getJoy() {
		return joy;
	} 

	/**
	 * returns the right joystick if using 2 NOTE: not used for real, but used
	 * elsewhere in code
	 * @return the other joystick
	 */
	public Joystick getAltJoy() {
		return altJoy;

	}
	
	public SendableChooser<Integer> getAutoChooser() {
		return autoChooser;
	}
}
