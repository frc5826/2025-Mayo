package frc.robot.commands;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;

public class TeleopDrive extends Command {
    SwerveSubsystem swerve;
    public TeleopDrive(SwerveSubsystem swerve){
        this.swerve=swerve;
        addRequirements(swerve);
    }


    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        super.execute();
        double xSpeed= -Constants.joystick.getRightY();
        double ySpeed= -Constants.joystick.getRightX();
        double turnSpeed= -Constants.joystick.getLeftX();
        double mult = Units.feetToMeters(16.6*0.5);
        if(Math.abs(xSpeed)<0.15){
         xSpeed=0;
        }
        if(Math.abs(ySpeed)<0.15){
            ySpeed=0;
        }
            if (Math.abs(turnSpeed)<0.15){
                turnSpeed=0;
            }
        swerve.drive(xSpeed*mult,ySpeed*mult,turnSpeed*6);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}
