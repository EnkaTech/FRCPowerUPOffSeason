/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

        // Main Sensors
        public static ADIS16448_IMU gyro = new ADIS16448_IMU();
        public static Encoder elevatorEncoder = new Encoder(0, 1, false, EncodingType.k4X);

        // Drive Train Controllers
        private static int dt_FrontLeft = 0;
        private static int dt_FrontRight = 1;
        private static int dt_RearLeft = 2;
        private static int dt_RearRight = 3;

        private static SpeedControllerGroup driveTrainL = new SpeedControllerGroup(new Victor(dt_FrontLeft),
                        new Victor(dt_RearLeft));
        private static SpeedControllerGroup driveTrainR = new SpeedControllerGroup(new Victor(dt_FrontRight),
                        new Victor(dt_RearRight));

        public static DifferentialDrive driveTrain = new DifferentialDrive(driveTrainL, driveTrainR);
        // Pneumatic Valves

        private static int lv = 2;
        private static int rv_a = 0;
        private static int rv_b = 1;

        public static DoubleSolenoid rightValve =  new DoubleSolenoid(rv_a, rv_b);
        public static Solenoid leftValve = new Solenoid(lv);
}