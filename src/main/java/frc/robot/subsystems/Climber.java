package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;


public class Climber extends SubsystemBase{
    //create the climber motor objects
    private final CANSparkMax leftClimber = new CANSparkMax(ClimberConstants.kleftclimberMotorID, MotorType.kBrushless);
    private final CANSparkMax rightClimber = new CANSparkMax(ClimberConstants.krightclimberMotorID, MotorType.kBrushless);

    public void extend() {
        leftClimber.set(-ClimberConstants.kclimberSpeed);
        rightClimber.set(-ClimberConstants.kclimberSpeed);
    }

    public void retract() {
        leftClimber.set(ClimberConstants.kclimberSpeed);
        rightClimber.set(ClimberConstants.kclimberSpeed);
    }

    public void stop() {
        leftClimber.set(0);
        rightClimber.set(0);
    }

    public void periodic() {
        // This method will be called once per scheduler run
    }
}   
