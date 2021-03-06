/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDriveWithJoysticks;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private static Talon rightDrive1 = new Talon(RobotMap.rightDrive1);
  private static Talon rightDrive2 = new Talon(RobotMap.rihgtDrive2);
  private static Talon leftDrive1 = new Talon(RobotMap.leftDrive1);
  private static Talon leftDrive2 = new Talon(RobotMap.leftDrive2);

  private static SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(rightDrive1, rightDrive2);
  private static SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(leftDrive1, leftDrive2);

  private static DifferentialDrive drivetrain = new DifferentialDrive(leftDriveGroup, rightDriveGroup);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveWithJoysticks());
  }

  public void drive(XboxController controller) {
    drivetrain.tankDrive(controller.getRawAxis(1), controller.getRawAxis(3));
  }

  public void stopDrive() {
    drivetrain.stopMotor();
  }
}
