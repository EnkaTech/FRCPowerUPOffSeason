/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class AutonomousCommand extends CommandGroup {
  // addSequential(new Command());
  // addParallel(new Command());
  public AutonomousCommand(int x) {
    boolean alliedScaleIsRight = DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'R';
    switch (x) {
    case 1:
      if (alliedScaleIsRight) {
        addParallel(new SetElevatorHeight(160));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(4.4, false));
        addSequential(new GyroTurn(90));
        addSequential(new TimedIntake(0.75, -0.75));
      } else {

      }
      break;

    case 2:
      if (alliedScaleIsRight) {

      } else {

      }

      break;

    case 3:
      if (alliedScaleIsRight) {

      } else {

      }

      break;
    }
  }
}
