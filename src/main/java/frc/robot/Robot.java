/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.GripperJoint;
import frc.robot.subsystems.GripperWheels;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static IO IO;
  public static NetworkTable table;
  public static SendableChooser<Integer> autoChooser;
  public static DriveTrain driveTrain;
  public static Compressor compressor;
  public static Gripper gripper;
  public static CameraServer cameraServer;
  public static Elevator elevator;
  public static GripperWheels wheels;
  public static GripperJoint joint;

  /**
   * i This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    joint = new GripperJoint();
    gripper = new Gripper();
    compressor = new Compressor();
    elevator = new Elevator();
    wheels = new GripperWheels();
    IO = new IO();
    driveTrain = new DriveTrain();
    autoChooser = new SendableChooser<Integer>();
    autoChooser.addObject("Left Side Auto", 1);
    autoChooser.addDefault("Middle Auto", 2);
    autoChooser.addObject("Right Side Auto", 3);
    SmartDashboard.putData("Auto mode", autoChooser);
    cameraServer = CameraServer.getInstance();
    cameraServer.startAutomaticCapture();
    compressor.setClosedLoopControl(false);
    RobotMap.elevatorEncoder.setDistancePerPulse(RobotMap.elevatorDPP);
  }

  /*
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p> This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if (compressor.getPressureSwitchValue()) {
      compressor.setClosedLoopControl(false);
    } else if (IO.back_1.get()) {
      compressor.setClosedLoopControl(!compressor.getClosedLoopControl());
      Timer.delay(0.2);
    }
    SmartDashboard.putNumber("Elevator Height", -RobotMap.elevatorEncoder.getDistance() + 20);
    SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngleX());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    RobotMap.gyro.reset();
    new AutonomousCommand(autoChooser.getSelected()).start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
