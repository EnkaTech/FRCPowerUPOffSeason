/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.JointMotion;

/**
 * Add your docs here.
 */
public class GripperJoint extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private SpeedController gripperJoint = RobotMap.jointMotor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JointMotion());
  }
  public void moveJoint(double x) {
    gripperJoint.set(x);
  }

  public void moveJoint(Joystick joy) {
    moveJoint(joy.getRawAxis(2)-joy.getRawAxis(3));
  }
}
