/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class RobotMap {
  //Main Sensors
  public static ADIS16448_IMU gyro = new ADIS16448_IMU();

  //Drive Train Controllers
  private static int driveTrainFL = 0;
  private static int driveTrainFR = 1;
  private static int driveTrainRL = 2;
  private static int driveTrainRR = 3;

  private static SpeedControllerGroup driveTrainL = new SpeedControllerGroup(new Victor(driveTrainFL),new Victor(driveTrainRL));
  private static SpeedControllerGroup driveTrainR = new SpeedControllerGroup(new Victor(driveTrainFR),new Victor(driveTrainRR));
  
  public static DifferentialDrive driveTrain = new DifferentialDrive(driveTrainL, driveTrainR);
}
