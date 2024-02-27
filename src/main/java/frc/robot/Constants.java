package frc.robot;

public class Constants {
    //controller constants
        public static final int joystickPort = 1;
        public static final int gamepadPort = 0;
        
    //shooter constants
    public static final class ShooterConstants {
    //spark max ID
        public static final int kshooterpivotMotordID = 11;
        public static final int kshooterindexerMotordID = 12;
        public static final int kshooterMotordID = 13;
    //maximum current
        public static final int kpivotCurrentLimit = 50; 
        public static final int kindexerCurrentLimit = 20; 
        public static final int kshooterCurrentLimit = 50; 
    //motor speed
        public static final int kshooterShootSpeed = 1; 
        public static final int kindexerIntakeSpeed = -0.5; //reversed because motor placed on the inside
        public static final int kpivotUpSpeed = -0.5; //reversed because motor placed on the inside
        public static final int kpivotDownSpeed = 0.5;
    }

    //intake constants
    public static final class IntakeConstants {
    //spark max ID
        public static final int kintakeMotorID = 9;
        public static final int kintakepivotMotorID = 10;
    }
}
