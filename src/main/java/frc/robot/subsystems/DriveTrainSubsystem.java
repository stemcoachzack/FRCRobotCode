// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.math.Filter;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrainSubsystem extends SubsystemBase {

  // Moved the object creation up here because it will have the same effect that the constructor would but cleaner -MADMAN-Modding
  WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_MOTOR);
  WPI_VictorSPX leftBackMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_BACK_MOTOR);
  WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_MOTOR);
  WPI_VictorSPX rightBackMotor = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_MOTOR);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);;

  /** Constructor for the DriveTrain class */
  public DriveTrainSubsystem() {
    // Motor Inverting, check Constants for the values
    leftFrontMotor.setInverted(Constants.DRIVETRAIN_LEFT_BACK_MOTOR_INVERTED);
    leftBackMotor.setInverted(Constants.DRIVETRAIN_LEFT_BACK_MOTOR_INVERTED);
    rightFrontMotor.setInverted(Constants.DRIVETRAIN_RIGHT_FRONT_MOTOR_INVERTED);
    rightBackMotor.setInverted(Constants.DRIVETRAIN_RIGHT_BACK_MOTOR_INVERTED);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {

    // differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);

    // These might be inverted (switch the plus and minus symbol) but this should accomplish turning -MADMAN-Modding
    double leftSpeed = Filter.cutoffFilter(moveSpeed + rotateSpeed);
    double rightSpeed = Filter.cutoffFilter(moveSpeed - rotateSpeed);

    leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
    rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);

    // Not 100% sure that these have to be down here, but I've always been taught to do it this way, might not need to happen -MADMAN-Modding
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Joystick X", RobotContainer.m_driverController.getRightX());
    SmartDashboard.putNumber("Left Joystick Y", RobotContainer.m_driverController.getLeftY());
  }
}
