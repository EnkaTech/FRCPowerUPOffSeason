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
import frc.robot.commands.PistonMotion;
import frc.robot.commands.SetElevatorHeight;

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
  public Button A_2 = new JoystickButton(joy2, 1);
  public Button B_2 = new JoystickButton(joy2, 2);
  public Button X_2 = new JoystickButton(joy2, 3);
  public Button Y_2 = new JoystickButton(joy2, 4);
  public Button L1_2 = new JoystickButton(joy2, 5);
  public Button R1_2 = new JoystickButton(joy2, 6);
  public Button back_2 = new JoystickButton(joy1, 7);
  public Button L3_2 = new JoystickButton(joy2, 9);

  // Button Assigments
  public IO() {
    A_1.whenPressed(new PistonMotion(true));
    B_1.whenPressed(new PistonMotion(false));
    X_1.whenPressed(new SetElevatorHeight());
    Y_1.whenPressed(new SetElevatorHeight());
    L1_1.whileHeld(new GripperIntake(1));
    R1_1.whileHeld(new GripperIntake(-1));
  }
}
