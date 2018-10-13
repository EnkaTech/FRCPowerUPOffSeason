/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Add your docs here.
 */
public class Gripper extends Subsystem {
  private Solenoid s2 = RobotMap.leftValve;
  private SpeedController wheel_l = RobotMap.wheel_l;
  private SpeedController wheel_r = RobotMap.wheel_r;

  // Put methods for controlling this subsystem
  // here. Call these from Commands

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void intake(double x) {
    wheel_l.set(x);
    wheel_r.set(-x);
  }

  public void tighten() {
    s2.set(true);
  }

  public void loosen() {
    s2.set(false);
  }
}
