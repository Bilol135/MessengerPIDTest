// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Climber;
import frc.robot.commands.PrepareLaunch;
import frc.robot.commands.LaunchNote;
import frc.robot.commands.ClimberExtend;
import frc.robot.commands.ClimberRetract;

public class RobotContainer {
    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    private final Climber climber = new Climber();
    
    CommandXboxController controller = new CommandXboxController(Constants.gamepadPort);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        controller.leftBumper().whileTrue(intake.intakeNote());
        controller.rightBumper().whileTrue(intake.releaseNote());
        controller.y().whileTrue(intake.goToGround());
        controller.a().whileTrue(intake.goToHandOff());

        controller.b().whileTrue(
             new PrepareLaunch(shooter)
                .withTimeout(0.5)
                .andThen(new LaunchNote(shooter))
                .handleInterrupt(() -> shooter.stop())
        );

        // controller.a().whileTrue(shooter.indexerIn());
        // controller.b().whileTrue(shooter.indexerOut());

        
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
