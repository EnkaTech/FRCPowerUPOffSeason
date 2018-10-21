/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
  // addSequential(new Command());
  // addParallel(new Command());
  public AutonomousCommand(int x) {
    boolean alliedScaleIsRight = DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'R';
    boolean alliedSwitchIsRight = DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R';
    addSequential(new PistonMotion(true));
    switch (x) {
    // Sol Taraf
    case 1:
      if (alliedScaleIsRight) {
        addParallel(new SetElevatorHeight(160));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(4, false,0));
        addSequential(new GyroTurn(-90));
        addSequential(new GyroDrive(4, false,90));
        addSequential(new GyroTurn(0));
        addSequential(new TimedIntake(0.75, -0.75));
      } else {
        addParallel(new SetElevatorHeight(160));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(6, false,0));
        addSequential(new GyroTurn(45));
        addSequential(new TimedIntake(0.75, -0.75));
        if (!alliedSwitchIsRight) {
          addParallel(new SetElevatorHeight(0));
          addParallel(new TimedJoint(1, -0.8));
          addSequential(new GyroTurn(135));
          addParallel(new TimedIntake(1, 0.75));
          addSequential(new GyroDrive(1, false,-135));
          addParallel(new SetElevatorHeight(50));
          addParallel(new TimedJoint(1, 1));
          addSequential(new GyroDrive(0.5, true,-135));
          addSequential(new GyroTurn(180));
          addSequential(new TimedIntake(0.75, -0.75));
        }
      }
      break;
    // Orta taraf
    case 2:
      if (alliedSwitchIsRight) {
        addParallel(new SetElevatorHeight(50));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(0.75, false,0));
        addSequential(new GyroTurn(45));
        addSequential(new GyroDrive(1.1, false,-45));
        addSequential(new GyroTurn(0));
        addSequential(new GyroDrive(0.75, false,0));
        addSequential(new TimedIntake(0.75, -0.75));
      } else {
        addParallel(new SetElevatorHeight(50));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(0.75, false,0));
        addSequential(new GyroTurn(-45));
        addSequential(new GyroDrive(1.2, false,45));
        addSequential(new GyroTurn(0));
        addSequential(new GyroDrive(0.75, false,0));
        addSequential(new TimedIntake(0.75, -0.75));
      }

      break;
    // Sağ Taraf
    case 3:
      if (alliedScaleIsRight) {
        addParallel(new SetElevatorHeight(160));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(4.5, false,0));
        addSequential(new GyroTurn(-45));
        addSequential(new TimedIntake(0.75, -0.75));
        if (alliedSwitchIsRight) {
          addParallel(new SetElevatorHeight(0));
          addParallel(new TimedJoint(1, -0.8));
          addSequential(new GyroTurn(-135));
          addParallel(new TimedIntake(1, 0.75));
          addSequential(new GyroDrive(1, false,135));
          addParallel(new SetElevatorHeight(50));
          addParallel(new TimedJoint(1, 1));
          addSequential(new GyroDrive(0.5, true,135));
          addSequential(new GyroTurn(-180));
          addSequential(new TimedIntake(0.75, -0.75));
        }
      } else {
        addParallel(new SetElevatorHeight(160));
        addParallel(new TimedJoint(1, -0.8));
        addSequential(new GyroDrive(4, false,0));
        addSequential(new GyroTurn(-90));
        addSequential(new GyroDrive(4, false,90));
        addSequential(new GyroTurn(0));
        addSequential(new TimedIntake(0.75, -0.75));
      }
      break;
    }
  }
}
