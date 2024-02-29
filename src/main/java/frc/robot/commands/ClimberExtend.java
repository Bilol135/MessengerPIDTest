package main.java.frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;
import frc.robot.Constants.ClimberConstants;

public class ClimberExtend extends WaitUntilCommand{
    Climber climber;

    public ClimberExtend(Climber m_climber, BooleanSupplier btnState) {
        super(btnState);
        // indicate that this command requires the climber system
        addRequirements(climber);
        // save the climber system internally
        climber = m_climber;
      }

      @Override
      public void initialize() {
        // Set climber to speed
        //climber.extend(ClimberConstants.kclimberExSpeed);
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        climber.extend();
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        // Always return false so the command never ends on it's own. In this project we use the
        // scheduler to end the command when the button is released.
        return false;
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        // Stop the climber when the command ends.
        climber.stop();
      }
}
