package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsytem extends SubsystemBase {
    SparkMax motor;
    public IntakeSubsytem(){
        motor=new SparkMax(5, SparkLowLevel.MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        super.periodic();
        motor.set(Constants.joystick.getLeftTriggerAxis());
    }
}

