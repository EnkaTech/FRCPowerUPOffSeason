/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import javax.security.auth.x500.X500Principal;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Compress;

/**
 * Add your docs here.
 */
public class CompressorSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public void compress(boolean x){
      RobotMap.compressor.setClosedLoopControl(x);
    }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Compress(false));
    }
  
}
