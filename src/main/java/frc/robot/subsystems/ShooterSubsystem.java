package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
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

        SparkMaxConfig leftConfig = new SparkMaxConfig();
        leftConfig.inverted(false);
        leftConfig.idleMode(SparkBaseConfig.IdleMode.kCoast);
        leftConfig.closedLoopRampRate(0.5);
        leftConfig.openLoopRampRate(0.5);
        leftShooterMotor.configure(leftConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        SparkMaxConfig rightConfig = new SparkMaxConfig();
        rightConfig.follow(leftShooterMotor, true);
        rightConfig.idleMode(SparkBaseConfig.IdleMode.kCoast);
        rightConfig.closedLoopRampRate(0.5);
        rightConfig.openLoopRampRate(0.5);
        rightShooterMotor.configure(rightConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    }



    @Override
    public void periodic() {
        double trigger = joystick.getRightTriggerAxis();
        leftShooterMotor.set(trigger*shooterSpeed);
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

