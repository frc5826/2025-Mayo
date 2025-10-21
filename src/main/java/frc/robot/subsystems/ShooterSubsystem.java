package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class ShooterSubsystem extends SubsystemBase {
    private SparkMax leftShooterMotor;
    private SparkMax rightShooterMotor;

    public ShooterSubsystem() {
        leftShooterMotor = new SparkMax(leftShooterID, SparkLowLevel.MotorType.kBrushless);
        rightShooterMotor = new SparkMax(rightShooterID, SparkLowLevel.MotorType.kBrushless);
    }


    @Override
    public void periodic() {
        double trigger = joystick.getRightTriggerAxis();
        leftShooterMotor.set(trigger*shooterSpeed);
        rightShooterMotor.set(-trigger*shooterSpeed);
    }
}

