/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Gripper extends Subsystem {
  public static DoubleSolenoid s1;
  public static Solenoid s2;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Gripper(int s1porta, int s1portb, int s2port) {
    s1 = new DoubleSolenoid(s1porta, s1portb);
    s2 = new Solenoid(s2port);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void tighten() {
    s1.set(Value.kForward);
    s2.set(true);
  }

  public void loosen() {
    s1.set(Value.kReverse);
    s2.set(false);
  }

  public void off() {
    s1.set(Value.kOff);
  }

}