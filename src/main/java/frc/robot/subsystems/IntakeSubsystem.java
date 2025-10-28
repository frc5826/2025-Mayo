package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    SparkMax motor;
    DutyCycleEncoder encoder;
    ArmController controller;
    PID pid;
    double offset=-.336;

    public IntakeSubsystem(){
        encoder=new DutyCycleEncoder(new DigitalInput(0));
        encoder.setInverted(true);
        motor=new SparkMax(2, SparkLowLevel.MotorType.kBrushless);
        pid = new PID(0,0,0,1,-1,0,this::getAngle);
        controller = new ArmController(0,0,0,0,-1,1,pid,this::getAngle);
    }

    @Override
    public void periodic() {
        super.periodic();
        SmartDashboard.putNumber("intake/encoder",encoder.get());
        SmartDashboard.putNumber("intake/angle",getAngle());
    }

    public double getAngle(){
        double angle = (encoder.get()+offset)*20.0/48.0*360;
        return angle;
    }
}
