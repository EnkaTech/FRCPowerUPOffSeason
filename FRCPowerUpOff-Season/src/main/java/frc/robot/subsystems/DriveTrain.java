/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private double Kp= 0.02;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DifferentialDrive driveTrain = RobotMap.driveTrain;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JoystickDrive());
  }

  public void drive(double spdL, double spdR){
    driveTrain.tankDrive(spdL, spdR);
  }

  public void drive(Joystick joy, double mult){
    drive(joy.getRawAxis(5)*mult,joy.getRawAxis(1)*mult);
  }

  public void gyroDrive(ADIS16448_IMU gyro,char x){
    double angle = gyro.getAngle();
    if(x=='F'){
      drive((0.5-angle*Kp),(0.5+angle*Kp));
    }
    else{
      drive(-(angle*Kp+0.5),-(0.5-angle*Kp));
    }
    Timer.delay(0.0004);
  }
  
  public void gyroTurn(ADIS16448_IMU gyro,double x){
    double angle = gyro.getAngle();
    double power=(x-angle)*Kp*8;
    if (power>=0.7)
		{
			power=0.7;
		}
		else if(power>0) {
			power= 0.5;
		}
		else if(power <= -0.7) {
			power= -0.7;
		}
		else {
			power= -0.5;
		}
		Timer.delay(0.0004);
		drive(power,-power);
  }
}
