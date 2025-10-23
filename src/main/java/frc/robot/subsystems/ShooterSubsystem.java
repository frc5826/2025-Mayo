package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class ShooterSubsystem extends SubsystemBase {
    private SparkMax leftShooterMotor;
    private SparkMax rightShooterMotor;
    private SparkMax leftLoaderMotor;
    private SparkMax rightLoaderMotor;

    public ShooterSubsystem() {
        leftShooterMotor = new SparkMax(leftShooterID, SparkLowLevel.MotorType.kBrushless);
        rightShooterMotor = new SparkMax(rightShooterID, SparkLowLevel.MotorType.kBrushless);
        leftLoaderMotor = new SparkMax(leftLoaderID, SparkLowLevel.MotorType.kBrushless);
        rightLoaderMotor = new SparkMax(rightLoaderID, SparkLowLevel.MotorType.kBrushless);
    }



    @Override
    public void periodic() {
        double trigger = joystick.getRightTriggerAxis();
         leftShooterMotor.set(trigger*shooterSpeed);
         rightShooterMotor.set(-trigger*shooterSpeed);
        boolean loader = joystick.getXButton();
        if (loader) {
            rightLoaderMotor.set(-loaderSpeed);
            leftLoaderMotor.set(loaderSpeed);
        }else {
            rightLoaderMotor.set(0);
            leftLoaderMotor.set(0);
        }

    }
}

