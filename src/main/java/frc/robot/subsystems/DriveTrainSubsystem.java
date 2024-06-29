// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drivetrain extends SubsystemBase {

  WPI_VictorSPX leftFrontMotor = null;
  WPI_VictorSPX leftBackMotor = null;
  WPI_VictorSPX rightFrontMotor = null;
  WPI_VictorSPX rightBackMotor = null;

  DifferentialDrive differentialDrive = null;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFrontMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_MOTOR);
    leftBackMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_BACK_MOTOR);
    rightFrontMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_MOTOR);
    rightBackMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_MOTOR);

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {

    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
