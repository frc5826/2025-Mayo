package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArmCommand;

public class ArmSubsystem extends SubsystemBase {
    SparkMax motor;
    DutyCycleEncoder encoder;
    ArmController controller;
    PID pid;
    double offset=-.8;

    public ArmSubsystem(){
        encoder=new DutyCycleEncoder(new DigitalInput(0));
        encoder.setInverted(true);
        motor=new SparkMax(2, SparkLowLevel.MotorType.kBrushless);
        pid = new PID(0,0,0,1,-1,0,this::getAngle);
        controller = new ArmController(0.008,0,450,600,-1,1,pid,this::getAngle);

        SmartDashboard.putData("intake/set 0 degrees",new ArmCommand(0,this));
        SmartDashboard.putData("intake/set 50 degrees",new ArmCommand(50,this));
    }

    @Override
    public void periodic() {
        super.periodic();
        SmartDashboard.putNumber("intake/encoder",encoder.get());
        SmartDashboard.putNumber("intake/angle",getAngle());
        SmartDashboard.putData("intake/PID",pid);
        SmartDashboard.putData("intake/Controller",controller);
        motor.set(controller.calculate(.02));
       // motor.set(Constants.joystick.getLeftY()*0.4);
    }

    public double getAngle(){
        double angle = (encoder.get()+offset)*-20.0/48.0*360.0;
        return angle;
    }

    public void setGoal(double angle) {

        if (angle >= 100) {
            angle = 100;
        } else if (angle <= 0) {
            angle = 0;
        }
        controller.setGoal(getAngle(), angle, 0);
    }
}
