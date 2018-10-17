/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GripperIntake;
import frc.robot.commands.JointMotion;
import frc.robot.commands.PistonMotion;

public class IO {

  // Joystick declarations
  public Joystick joy1 = new Joystick(0);
  public Joystick joy2 = new Joystick(1);

  // Button Config for Joystick 1
  public Button A_1 = new JoystickButton(joy1, 1);
  public Button B_1 = new JoystickButton(joy1, 2);
  public Button X_1 = new JoystickButton(joy1, 3);
  public Button Y_1 = new JoystickButton(joy1, 4);
  public Button L1_1 = new JoystickButton(joy1, 5);
  public Button R1_1 = new JoystickButton(joy1, 6);
  public Button back_1 = new JoystickButton(joy1, 7);
  public Button L3_1 = new JoystickButton(joy1, 9);

  // Button Config for Joystick 2
  public Button b_9 = new JoystickButton(joy2, 9);
  public Button b_10 = new JoystickButton(joy2, 10);
  public Button b_11 = new JoystickButton(joy2, 11);
  public Button b_12 = new JoystickButton(joy2, 12);

  // Button Assigments
  public IO() {
    A_1.whenPressed(new PistonMotion(false));
    B_1.whenPressed(new PistonMotion(true));
    b_9.whileHeld(new JointMotion(-1));
    b_10.whileHeld(new JointMotion(1));
    b_11.toggleWhenPressed(new GripperIntake(0.75));
    b_12.toggleWhenPressed(new GripperIntake(-0.75));
  }
}
