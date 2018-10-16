/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.SetElevatorHeight;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  public SpeedControllerGroup motors = new SpeedControllerGroup(RobotMap.elevator_1, RobotMap.elevator_2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new SetElevatorHeight(Robot.IO.joy2));
  }

  public void stabilize(Encoder e, double targetDistance) {
    double distance = -e.getDistance();
    double difference = targetDistance - distance;
    double throttle = RobotMap.map(difference, 180, -180, -0.8, 0.8);
    if (throttle > -0.01 && throttle < 0.01) {
      throttle = -0.1;
    } else if (throttle < 0 && throttle > -0.4) {
      throttle = -0.4;
    } else if (throttle < 0 && throttle < -0.7) {
      throttle = -0.7;
    } else if (throttle > 0 && throttle < 0.3) {
      throttle = 0.3;
    } else if (throttle > 0 && throttle > 0.4) {
      throttle = 0.4;
    }
    motors.set(throttle);
  }
}
