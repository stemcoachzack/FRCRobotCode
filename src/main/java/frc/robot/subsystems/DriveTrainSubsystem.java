// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  
  WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(Constants.DriveTrainConstants.leftFrontCANID);
  WPI_VictorSPX leftBackMotor = new WPI_VictorSPX(Constants.DriveTrainConstants.leftBackCANID);
  WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(Constants.DriveTrainConstants.rightFrontCANID);
  WPI_VictorSPX rightBackMotor = new WPI_VictorSPX(Constants.DriveTrainConstants.rightBackCANID);

  public DifferentialDrive diffDrive;

  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightFrontMotor.setInverted(true);
    leftFrontMotor.setInverted(false);

    diffDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
