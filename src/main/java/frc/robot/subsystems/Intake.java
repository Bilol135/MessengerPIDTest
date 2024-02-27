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
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    private final CANSparkMax intake;
    private final CANSparkMax pivot;
    private final RelativeEncoder pivotEncoder;
    private final SparkPIDController pivotController;
    private double kP, kI, kD, kFF, kMaxOutput, kMinOutput;
    private double setpoint = 0;

    public Intake() {
        intake = new CANSparkMax(kintakeMotorID, MotorType.kBrushless);
        pivot = new CANSparkMax(kintakepivotMotorID, MotorType.kBrushless);

        intake.restoreFactoryDefaults();
        pivot.restoreFactoryDefaults();

        intake.setIdleMode(IdleMode.kBrake);
        pivot.setIdleMode(IdleMode.kBrake);


        kP = 0.1;
        kI = 0.0;
        kD = 1.0;
        kFF = 0.0;
        kMaxOutput = 1;
        kMinOutput = -1;

        pivotEncoder = pivot.getEncoder();
        pivotController = pivot.getPIDController();

        pivotController.setP(kP);
        pivotController.setI(kI);
        pivotController.setD(kD);
        pivotController.setFF(kFF);
        pivotController.setOutputRange(kMinOutput, kMaxOutput);

        SmartDashboard.putNumber("P:", kP);
        SmartDashboard.putNumber("I:", kI);
        SmartDashboard.putNumber("D:", kD);
        SmartDashboard.putNumber("FF:", kFF);
        SmartDashboard.putNumber("Max Output:", kMaxOutput);
        SmartDashboard.putNumber("Min Output:", kMinOutput);
        SmartDashboard.putNumber("Setpoint:", setpoint);

        intake.burnFlash();
        pivot.burnFlash();
    }

    @Override
    public void periodic() {
        double p = SmartDashboard.getNumber("P:", 0);
        double i = SmartDashboard.getNumber("I:", 0);
        double d = SmartDashboard.getNumber("D:", 0);
        double ff = SmartDashboard.getNumber("FF:", 0);
        double max = SmartDashboard.getNumber("Max Output:", 0);
        double min = SmartDashboard.getNumber("Min Output:", 0);
        double s = SmartDashboard.getNumber("Setpoint:", 0);

        if (p != kP) {pivotController.setP(p); kP = p;}
        if (p != kI) {pivotController.setI(i); kI = i;}
        if (p != kD) {pivotController.setD(d); kD = d;}
        if (p != kFF) {pivotController.setFF(ff); kFF = ff;}
        if (max != kMaxOutput || min != kMinOutput) {
            pivotController.setOutputRange(min, max);
            kMinOutput = min;
            kMaxOutput = max;
        }

        setPivotPosition(s);
        SmartDashboard.putNumber("Setpoint:", s);
        SmartDashboard.putNumber("Angle:", pivotEncoder.getPosition());
    }

    public Command intakeNote() {
        return startEnd(
            () -> intake.set(0.5),
            () -> intake.set(0)
        );
    }

    public Command releaseNote() {
        return startEnd(
            () -> intake.set(-0.5),
            () -> intake.set(0)
        );
    }

    public Command goToGround() {
        return startEnd(
            () -> pivot.set(1),
            () -> pivot.set(0)
        );
    }

    public Command goToHandOff() {
        return startEnd(
            () -> pivot.set(-1),
            () -> pivot.set(0)
        );
    }

    public void setPivotPosition(double setpoint) {
        pivotController.setReference(setpoint, ControlType.kPosition);
    }

    public double getP() {
        return pivotController.getP();
    }

    public double getI() {
        return pivotController.getI();
    }

    public double getD() {
        return pivotController.getD();
    }

    public double getFF() {
        return pivotController.getFF();
    }

    public void setP(double p) {
        pivotController.setP(p);
    }

    public void setI(double i) {
        pivotController.setI(i);
    }

    public void setD(double d) {
        pivotController.setD(d);
    }
}
