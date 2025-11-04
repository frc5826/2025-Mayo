// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.SwerveSubsystem;


public class RobotContainer
{
    private final SwerveSubsystem swerve=new SwerveSubsystem();
    private final ShooterSubsystem shooter = new ShooterSubsystem();
    private final ArmSubsystem arm=new ArmSubsystem();
    private final IntakeSubsytem intake = new IntakeSubsytem();
    public RobotContainer()
    {
        configureBindings();
        swerve.setDefaultCommand(new TeleopDrive(swerve));
    }
    
    
    private void configureBindings() {
        new Trigger(()->Constants.joystick.getYButton()).onTrue(new InstantCommand(swerve::zeroGyro));
    }
    
    
    public Command getAutonomousCommand()
    {
        return Commands.print("No autonomous command configured");
    }
}
