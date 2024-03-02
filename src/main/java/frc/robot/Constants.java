package frc.robot;

public class Constants {
    //controller constants
        public static final int joystickPort = 1;
        public static final int gamepadPort = 0;
        
    //shooter constants
    public static final class ShooterConstants {
    //spark max ID
        public static final int kshooterpivotMotordID = 13;
        public static final int kshooterindexerMotordID = 12;
        public static final int kshooterMotordID = 11;
    //maximum current
        public static final int kpivotCurrentLimit = 50; 
        public static final int kindexerCurrentLimit = 20; 
        public static final int kshooterCurrentLimit = 50; 
    //motor speed
        public static final int kshooterShootSpeed = 1; 
        public static final double kindexerIntakeSpeed = -1; //reversed because motor placed on the inside
        public static final double kpivotUpSpeed = -0.25; //reversed because motor placed on the inside
        public static final double kpivotDownSpeed = 0.25;
    }

    //intake constants
    public static final class IntakeConstants {
    //spark max ID
        public static final int kintakeMotorID = 9;
        public static final int kintakepivotMotorID = 10;
    }

    //climber constants
    public static final class ClimberConstants {
    //spark max ID
        public static final int kleftclimberMotorID = 14;
        public static final int krightclimberMotorID = 15;
    //motor speed
        public static final double kclimberSpeed = 0.5;
    //maximum current
        public static final int kclimberCurrentLimit = 50;
    }
}
