package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class ShooterSubsystem extends SubsystemBase {
    private SparkMax leftShooterMotor;
    private SparkMax rightShooterMotor;
    private boolean isShooting;

    public ShooterSubsystem() {
        leftShooterMotor = new SparkMax(leftShooterID, SparkLowLevel.MotorType.kBrushless);
        rightShooterMotor = new SparkMax(rightShooterID, SparkLowLevel.MotorType.kBrushless);
        isShooting = false;
    }

    public void shoot() {
        isShooting = true;
    }

    public void stop() {
        isShooting = false;
    }

    @Override
    public void periodic() {
        if (isShooting) {
            leftShooterMotor.set(shooterSpeed);
            rightShooterMotor.set(-shooterSpeed);
        } else {
            leftShooterMotor.set(0);
            rightShooterMotor.set(0);
        }
    }
}

