/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gripper;

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
  public static Encoder sampleEncoder;
  public static final double kDistancePerRevolution = 18.84; // guestimate from your code
  public static final double kPulsesPerRevolution = 1024; // for an AS5145B Magnetic Encoder
  public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;
  public static DoubleSolenoid s;
  public static SendableChooser<Integer> selim;
  public static Compressor x;
  public static Gripper grip;

  /**
   * i This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    grip = new Gripper(0, 1, 2);
    x = new Compressor();
    IO = new IO();
    driveTrain = new DriveTrain();
    autoChooser = new SendableChooser<Integer>();
    selim = new SendableChooser<Integer>();
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    table = instance.getTable("datatable");
    autoChooser.addObject("Right Side Auto", 1);
    autoChooser.addDefault("Middle Auto", 2);
    autoChooser.addObject("Left Side Auto", 3);
    selim.addDefault("Kapali", 1);
    selim.addObject("On",2 );
    selim.addObject("Arka", 3);
    SmartDashboard.putData("Piston", selim);
    SmartDashboard.putData("Auto mode", autoChooser);
    sampleEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    s = new DoubleSolenoid(0, 1);
    sampleEncoder.setDistancePerPulse(kDistancePerPulse);
    sampleEncoder.reset();
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
    table.getEntry("gyro").setDouble(RobotMap.gyro.getAngle());
    SmartDashboard.putNumber("enc", sampleEncoder.getDistance());
    switch (selim.getSelected()) {

    case 2:
      s.set(DoubleSolenoid.Value.kForward);
      break;
    case 3:
      s.set(DoubleSolenoid.Value.kReverse);
      break;
    default:
      s.set(DoubleSolenoid.Value.kOff);
      break;
    }
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
    x.setClosedLoopControl(true);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
