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
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {
        
        public static double map(double x, double in_min, double in_max, double out_min, double out_max) {
                return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
        }

        // Main Sensors
        public static ADIS16448_IMU gyro = new ADIS16448_IMU();
        public static Encoder elevatorEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        // 1 tur = 6.5cm
        private static double elevatorPPR = 2048;
        public static double elevatorDPP = (1 / elevatorPPR) * 6.5;

        // Drive Train Controllers
        private static int dt_FrontLeft = 4;
        private static int dt_FrontRight = 8;
        private static int dt_RearLeft = 5;
        private static int dt_RearRight = 9;

        // Redline motors

        private static int gripw_l = 1;
        private static int gripw_r = 2;

        public static SpeedController wheel_l = new Spark(gripw_l);
        public static SpeedController wheel_r = new Spark(gripw_r);

        // Joint motor

        private static int joint = 3;
        public static SpeedController jointMotor = new Victor(joint);

        // Pneumatic valves
        private static int rv_a = 0;
        private static int rv_b = 1;

        // Elevator motors
        private static int elevator_cim_1 = 7;
        private static int elevator_cim_2 = 6;

        public static SpeedController elevator_1 = new Victor(elevator_cim_1);
        public static SpeedController elevator_2 = new Victor(elevator_cim_2);

        public static DoubleSolenoid rightValve = new DoubleSolenoid(rv_a, rv_b);

        private static SpeedControllerGroup driveTrainL = new SpeedControllerGroup(new Victor(dt_FrontLeft),
                        new Victor(dt_RearLeft));
        private static SpeedControllerGroup driveTrainR = new SpeedControllerGroup(new Victor(dt_FrontRight),
                        new Victor(dt_RearRight));

        public static DifferentialDrive driveTrain = new DifferentialDrive(driveTrainL, driveTrainR);
}
