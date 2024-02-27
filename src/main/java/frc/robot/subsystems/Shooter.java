package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final CANSparkMax pivot, indexer, shooter;

    public Shooter() {
        pivot = new CANSparkMax(kshooterpivotMotordID, MotorType.kBrushless);
        indexer = new CANSparkMax(kshooterindexerMotordID, MotorType.kBrushless);
        shooter = new CANSparkMax(kshooterMotordID, MotorType.kBrushless);

        pivot.restoreFactoryDefaults();
        indexer.restoreFactoryDefaults();
        shooter.restoreFactoryDefaults();

        pivot.setSmartCurrentLimit(kpivotCurrentLimit);
        indexer.setSmartCurrentLimit(kindexerCurrentLimit);
        shooter.setSmartCurrentLimit(kshooterCurrentLimit);

        pivot.setIdleMode(IdleMode.kBrake);
        indexer.setIdleMode(IdleMode.kBrake);
        shooter.setIdleMode(IdleMode.kCoast);

        pivot.burnFlash();
        indexer.burnFlash();
        shooter.burnFlash();
    }


    public void setShooter(double speed) {
        shooter.set(speed);
    }

    public void setIndexer(double speed) {
        indexer.set(speed);
    }

    public Command indexerIn() {
        return startEnd(
            () -> indexer.set(-0.5),
            () -> indexer.set(0)
        );
    }

    public Command indexerOut() {
        return startEnd(
            () -> indexer.set(0.5),
            () -> indexer.set(0)
        );
    }

    public Command turnDown() {
        return startEnd(
            () -> pivot.set(0.5),
            () -> pivot.set(0)
        );
    }

    public Command turnUp() {
        return startEnd(
            () -> pivot.set(-0.5),
            () -> pivot.set(0)
        );
    }

    public void stop(){
        shooter.set(0);
        indexer.set(0);
    }
}
