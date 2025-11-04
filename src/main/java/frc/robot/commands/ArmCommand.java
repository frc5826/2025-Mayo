package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;


public class ArmCommand extends Command {
    double angle;
    ArmSubsystem arm;
    public ArmCommand(double angle, ArmSubsystem arm){
        this.arm = arm;
        this.angle = angle;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        super.initialize();
    arm.setGoal(angle);
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}

