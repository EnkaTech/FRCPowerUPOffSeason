/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.PistonMotion;

/**
 * Add your docs here.
 */
public class Gripper extends Subsystem {
  public DoubleSolenoid s1 = RobotMap.rightValve;
  // Put methods for controlling this subsystem
  // here. Call these from Commands

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PistonMotion(true));
  }

  public void trigger(boolean fwd) {
    if(fwd){
      s1.set(Value.kForward);
      Timer.delay(0.04);
      s1.set(Value.kOff);
    }
    else{
      s1.set(Value.kReverse);
      Timer.delay(0.04);
      s1.set(Value.kOff);
    }
  }
}
