package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants.ShooterConstants;

public class LaunchNote extends Command{
    Shooter shooter;

    public LaunchNote(Shooter m_shooter) {
        // save the launcher system internally
        shooter = m_shooter;
    
        // indicate that this command requires the launcher system
        addRequirements(shooter);
      }

      @Override
      public void initialize() {
        // Set indexer to speed
        shooter.setIndexer(ShooterConstants.kindexerIntakeSpeed);
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        // There is nothing we need this command to do on each iteration. You could remove this method
        // and the default blank method
        // of the base class will run.
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
        // Stop the wheels when the command ends.
        shooter.stop();
      }
}
