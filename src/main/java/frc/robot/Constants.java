// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
//Victor Motors
public static final int DRIVETRAIN_LEFT_FRONT_MOTOR = 0;
public static final boolean DRIVETRAIN_LEFT_FRONT_MOTOR_INVERTED = true;
public static final int DRIVETRAIN_LEFT_BACK_MOTOR = 15;
public static final boolean DRIVETRAIN_LEFT_BACK_MOTOR_INVERTED = true;
public static final int DRIVETRAIN_RIGHT_BACK_MOTOR = 3;
public static final boolean DRIVETRAIN_RIGHT_BACK_MOTOR_INVERTED = false;
public static final int DRIVETRAIN_RIGHT_FRONT_MOTOR = 14;
public static final boolean DRIVETRAIN_RIGHT_FRONT_MOTOR_INVERTED = false;

//Joysticks
public static final int DRIVER_CONTROLLER = 0;
public static final int DRIVER_CONTROLLER_MOVE_AXIS = 2;
public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 3;

// Sub class for the operator constants to keep things organized
    public class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }
}
