// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.PrepareLaunch;
import frc.robot.commands.LaunchNote;

public class RobotContainer {
    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    
    CommandXboxController controller = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        controller.leftBumper().whileTrue(intake.intakeNote());
        controller.rightBumper().whileTrue(intake.releaseNote());
        controller.leftTrigger().whileTrue(intake.goToGround());
        controller.rightTrigger().whileTrue(intake.goToHandOff());

        controller.y().whileTrue(
             new PrepareLaunch(shooter)
                .withTimeout(1)
                .andThen(new LaunchNote(shooter))
                .handleInterrupt(() -> shooter.stop())
        );

        controller.a().whileTrue(shooter.indexerIn());
        controller.b().whileTrue(shooter.indexerOut());
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
