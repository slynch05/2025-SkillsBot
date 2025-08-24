package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.nerdyfiles.utilities.Utilities;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static final).  Do not put anything functional in this class.
 *
 * <p>It is advised to static finalally import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static double STARTING_ANGLE = 25;

  

  private static Constants instance;

  public static final class DashboardLogging {
    public static final boolean ARM = false;
    public static final boolean AUTO = false;
    public static final boolean CLIMB = false;
    public static final boolean DELIVERY = false;
    public static final boolean DRIVETRAIN = false;
    public static final boolean ELEVATOR = false;
    public static final boolean ENDEFFECTOR = false;
    public static final boolean HEADING = false;
    public static final boolean INTAKE = false;
    public static final boolean INTAKEACTUATOR = false;
    public static final boolean PDH = false;
    public static final boolean SHOOTER = true;
    public static final boolean SHOOTERPOT = false;
    public static final boolean SWERVE = false;
    public static final boolean VISION = false;

    public static final boolean TEMP = false;
  }

  // Driver dashboard
  // 28x13
  public static enum DriverDashboardPositions {
    AUTON_CHOOSER(9, 6, 6, 3),
    STARTING_POS_CHOOSER(9, 0, 6, 3),
    STARTING_ANGLE_CHOOSER(9, 3, 6, 3),
    AUTODRIVE_COMMAND(9, 9, 6, 3),
    GYRO_DEGREES(12, 9, 3, 3),
    ALLIANCE(9, 9, 6, 3),
    SHOULDERLAMPREY(15,0,3,3),
    ELBOWLAMPREY(18,0,3,3),
    INTAKESPINNERLAMPREY(21,0,3,3),
    INTAKESENSOR(15, 6, 3, 3),
    PASTARMPOSITION(15,3,6,3);
    
    
    public final int x, y, width, height;
    
    private DriverDashboardPositions(int x, int y, int w, int h) {
      this.x = x;
      this.y = y;
      this.width = w;
      this.height = h;
    }
  }
  public static final ShuffleboardTab DRIVER_DASHBOARD = Shuffleboard.getTab("DRIVER DASHBOARD");
  
  // Systems check
  public static enum SystemsCheckPositions {
    // Temperatures (3x4 widgets)
    MODULE0(9, 4),
    MODULE1(12,4),
    MODULE2(15, 4),
    MODULE3(18, 4),
    INTAKE_TEMP(0, 0),
    DELIVERY_TEMP(3, 0),
    L_SHOOTER_TEMP(0, 4),
    R_SHOOTER_TEMP(3, 4),
    L_CLIMBER_TEMP(0, 8),
    R_CLIMBER_TEMP(3, 8),
    // Delivery Sensors (3x3 widgets)
    TOP_SENSOR(7, 0),
    INTAKE_SENSOR(5, 0),
    SHOOTER_POSITION(5, 3),
    // Other sensors (also 3x3 widgets)
    BOTTOM_SENSOR(7, 3),
    POSE_ROTATION(5, 4),
    LIMELIGHT(13, 3),
    ROLL_DEGREES(19, 0);

    public final int x, y;

    private SystemsCheckPositions(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static final boolean DO_SYSTEMS_CHECK = true;
  public static final ShuffleboardTab SYSTEMS_CHECK_TAB = Shuffleboard.getTab("SYSTEMS CHECK");

  public static Constants getInstance() {
    if (instance == null) {
      instance = new Constants();
    }
    return instance;
  }

  public Constants() {
    RobotType.Type robotType = RobotType.getRobotType();
    // SmartDashboard.putString("Startup/Mac-Address", RobotType.getMACAddress());
    SmartDashboard.putString("Startup/Robot Type", robotType.description);
    switch (robotType) {
      case SKILLSBOT:
        
        break;
      case PRACTICE:
        
        break;
      case COMPETITION:
      default:
        

       
        break;
    }
  }

  public static final int LEDSTRIP_PWM_ID = 0;

  public static final class FieldElements {

    public static final Translation2d CENTER_OF_RED_REEF = new Translation2d(Utilities.inchesToMeters(514.13), Utilities.inchesToMeters(158.50));
    public static final Translation2d CENTER_OF_BLUE_REEF = new Translation2d(Utilities.inchesToMeters(176.745), Utilities.inchesToMeters(158.50));

    // Red Coral Station
    public static final Pose2d TAG_ONE_LOCATION = new Pose2d(Utilities.inchesToMeters(657.37), Utilities.inchesToMeters(25.80), Rotation2d.fromDegrees(126)); 
    public static final Pose2d TAG_TWO_LOCATION = new Pose2d(Utilities.inchesToMeters(657.37), Utilities.inchesToMeters(291.20), Rotation2d.fromDegrees(234)); 

    //Blue Coral Station
    public static final Pose2d TAG_TWELVE_LOCATION = new Pose2d(Utilities.inchesToMeters(33.51), Utilities.inchesToMeters(25.80), Rotation2d.fromDegrees(54)); 
    public static final Pose2d TAG_THIRTEEN_LOCATION = new Pose2d(Utilities.inchesToMeters(33.51 ), Utilities.inchesToMeters(291.20), Rotation2d.fromDegrees(306));

    // Red Reef
    public static final Pose2d TAG_SIX_LOCATION = new Pose2d(Utilities.inchesToMeters(530.49), Utilities.inchesToMeters(130.17), Rotation2d.fromDegrees(-60));
    public static final Pose2d TAG_SEVEN_LOCATION = new Pose2d(Utilities.inchesToMeters(546.87), Utilities.inchesToMeters(158.50), Rotation2d.fromDegrees(0));
    public static final Pose2d TAG_EIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(530.49), Utilities.inchesToMeters(186.83), Rotation2d.fromDegrees(60));
    public static final Pose2d TAG_NINE_LOCATION = new Pose2d(Utilities.inchesToMeters(497.77), Utilities.inchesToMeters(186.83), Rotation2d.fromDegrees(120));
    public static final Pose2d TAG_TEN_LOCATION = new Pose2d(Utilities.inchesToMeters(481.39), Utilities.inchesToMeters(158.50), Rotation2d.fromDegrees(180));
    public static final Pose2d TAG_ELEVEN_LOCATION = new Pose2d(Utilities.inchesToMeters(497.77 ), Utilities.inchesToMeters(130.17), Rotation2d.fromDegrees(-120));
    
    // Blue Reef
    public static final Pose2d TAG_SEVENTEEN_LOCATION = new Pose2d(Utilities.inchesToMeters(160.39), Utilities.inchesToMeters(130.17), Rotation2d.fromDegrees(-120));
    public static final Pose2d TAG_EIGHTEEN_LOCATION = new Pose2d(Utilities.inchesToMeters(144.00), Utilities.inchesToMeters(158.50), Rotation2d.fromDegrees(180));
    public static final Pose2d TAG_NINETEEN_LOCATION = new Pose2d(Utilities.inchesToMeters(160.39), Utilities.inchesToMeters(186.83), Rotation2d.fromDegrees(120));
    public static final Pose2d TAG_TWENTY_LOCATION = new Pose2d(Utilities.inchesToMeters(193.10), Utilities.inchesToMeters(186.83), Rotation2d.fromDegrees(60));
    public static final Pose2d TAG_TWENTY_ONE_LOCATION = new Pose2d(Utilities.inchesToMeters(209.49), Utilities.inchesToMeters(158.50), Rotation2d.fromDegrees(0));
    public static final Pose2d TAG_TWENTY_TWO_LOCATION = new Pose2d(Utilities.inchesToMeters(193.10), Utilities.inchesToMeters(130.17), Rotation2d.fromDegrees(-60));
    

    //Blue Branches
    public static final Pose2d BRANCH_17_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(155.797), Utilities.inchesToMeters(135.154), Rotation2d.fromDegrees(60));
    public static final Pose2d BRANCH_17_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(166.979), Utilities.inchesToMeters(128.896), Rotation2d.fromDegrees(60));
    public static final Pose2d BRANCH_18_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(146.007), Utilities.inchesToMeters(165.220), Rotation2d.fromDegrees(0));
    public static final Pose2d BRANCH_18_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(146.007), Utilities.inchesToMeters(152.282), Rotation2d.fromDegrees(0));
    public static final Pose2d BRANCH_19_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(167.001113), Utilities.inchesToMeters(188.566407), Rotation2d.fromDegrees(-60));
    public static final Pose2d BRANCH_19_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(155.774256), Utilities.inchesToMeters(182.137), Rotation2d.fromDegrees(-60));
    public static final Pose2d BRANCH_20_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(197.694309), Utilities.inchesToMeters(182.097582), Rotation2d.fromDegrees(-120));
    public static final Pose2d BRANCH_20_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(186.512452), Utilities.inchesToMeters(188.605392), Rotation2d.fromDegrees(-120));
    public static final Pose2d BRANCH_21_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(207.438741), Utilities.inchesToMeters(152.282083), Rotation2d.fromDegrees(180));
    public static final Pose2d BRANCH_21_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(207.438741), Utilities.inchesToMeters(165.219760), Rotation2d.fromDegrees(180));
    public static final Pose2d BRANCH_22_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(186.490), Utilities.inchesToMeters(129.608), Rotation2d.fromDegrees(120));
    public static final Pose2d BRANCH_22_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(197.717), Utilities.inchesToMeters(135.365274), Rotation2d.fromDegrees(120));

    //Red Branches
    public static final Pose2d BRANCH_11_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(493.182), Utilities.inchesToMeters(135.154), Rotation2d.fromDegrees(60));
    public static final Pose2d BRANCH_11_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(504.364), Utilities.inchesToMeters(128.896), Rotation2d.fromDegrees(60));
    public static final Pose2d BRANCH_10_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(483.437), Utilities.inchesToMeters(165.220), Rotation2d.fromDegrees(0));
    public static final Pose2d BRANCH_10_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(483.392), Utilities.inchesToMeters(152.282), Rotation2d.fromDegrees(0));
    public static final Pose2d BRANCH_9_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(504.386), Utilities.inchesToMeters(188.566407), Rotation2d.fromDegrees(-60));
    public static final Pose2d BRANCH_9_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(493.159), Utilities.inchesToMeters(182.137), Rotation2d.fromDegrees(-60));
    public static final Pose2d BRANCH_8_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(535.079), Utilities.inchesToMeters(182.097582), Rotation2d.fromDegrees(-120));
    public static final Pose2d BRANCH_8_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(523.897), Utilities.inchesToMeters(188.605392), Rotation2d.fromDegrees(-120));
    public static final Pose2d BRANCH_7_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(544.824), Utilities.inchesToMeters(152.282083), Rotation2d.fromDegrees(180));
    public static final Pose2d BRANCH_7_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(544.869), Utilities.inchesToMeters(165.219760), Rotation2d.fromDegrees(180));
    public static final Pose2d BRANCH_6_LEFT_LOCATION = new Pose2d(Utilities.inchesToMeters(524.669), Utilities.inchesToMeters(129.608), Rotation2d.fromDegrees(120));
    public static final Pose2d BRANCH_6_RIGHT_LOCATION = new Pose2d(Utilities.inchesToMeters(535.101702), Utilities.inchesToMeters(135.365274), Rotation2d.fromDegrees(120));

    /**Gives the branch angles 
     * IDs 7, 8, 9, 10, 11, 6
     * Left then right
    */
    public static final double[] BRANCH_ANGLES = {
      -11.02, 11.02,//ID 7 and 21 
      48.98, 71.02, // ID 8 and 20
      108.98, 131.02, // ID 9 and 19
      168.98, -168.98, // ID 10 and 18
      -131.02, -108.98, // ID 11 and 17
      -71.02, -48.98 // ID 6 and 22
    };



    public static final double SCORING_OFFSET_FROM_REEF = Utilities.inchesToMeters(20); // 13 (robot) + 3 (bumper) + 4 (coral)
    public static final double SCORING_OFFSET_FROM_STATION = Utilities.inchesToMeters(22); // 13 + 3 + 4

    public static final double SCORING_LEVEL_1_OFFSET_FROM_REEF_RIGHT = Utilities.inchesToMeters(22); // 13 + 3 + 4
    public static final double SCORING_LEVEL_1_OFFSET_FROM_REEF_LEFT = Utilities.inchesToMeters(20); // 13 + 3 + 4
    public static final double SCORING_LEVEL_1_RIGHT_DEGREE_OFFSET = -18;
    public static final double SCORING_LEVEL_1_LEFT_DEGREE_OFFSET = 8;
    public static final double LEFT_LEVEL_1_OFFSET = Utilities.inchesToMeters(-12);
    public static final double RIGHT_LEVEL_1_OFFSET = Utilities.inchesToMeters(13);

    public static final double LEFT_BRANCH_OFFSET = Utilities.inchesToMeters(-2);
    public static final double RIGHT_BRANCH_OFFSET = Utilities.inchesToMeters(11);
    public static final double CENTER_BRANCH_OFFSET = Utilities.inchesToMeters(4);

    public static final double LEFT_INTAKE_OFFSET = Utilities.inchesToMeters(-22.5); //-16 + 5.5
    public static final double RIGHT_INTAKE_OFFSET = Utilities.inchesToMeters(19.5); //13 + 5.5
    public static final double CENTER_INTAKE_OFFSET = Utilities.inchesToMeters(0); //-16 + 5.5

    public static final double BLUE_INTAKE_LEFT_PRIORITY = Utilities.inchesToMeters(177);
    public static final double BLUE_INTAKE_RIGHT_PRIORITY = Utilities.inchesToMeters(140);

    public static final double BLUE_AUTO_DRIVE_LINE_X = Utilities.inchesToMeters(176.745);
    public static final double RED_AUTO_DRIVE_LINE_X = Utilities.inchesToMeters(514.13);
    public static final double REEF_AVOIDANCE_STATION_LINE_UPPER = Utilities.inchesToMeters(220.5);
    public static final double REEF_AVOIDANCE_STATION_LINE_LOWER = Utilities.inchesToMeters(96.5); 

    public static final double UPPER_INTAKE_APPROACH_Y = Utilities.inchesToMeters(317); 
    public static final double LOWER_INTAKE_APPROACH_Y = Utilities.inchesToMeters(0); 


    public static final double TAG_TO_CENTER_OF_REEF = Utilities.inchesToMeters(32.745);
  }

  public static final class Global {
    public static double motorShutDownTempCelcius = 70;     
    public static double logDelay = 20;
  }

  public static final class Auto {
  }


  // Robot-specific configuration for our swerve drive algorithm
  public static final class Swerve {

    public static double MaxSpeed = 4.7244; // 4.7244 meters per second desired top speed
    // TODO: Increase MaxAngularRate
    public static double MaxAngularRate = 2.5 * Math.PI; // 3/4 of a rotation per second max angular velocity @ 1.5 //3 
    public static double driveAdjustment = 1;
    public static double driveDeadband = 0.1;
    public static double angularDeadband = 0.1;
    public static double driveScale = 5;

    public static final double REEF_OFFSET_LEFT = 13;
    public static final double REEF_OFFSET_RIGHT = -13;
    public static final double STRAFE_OFFSET = Utilities.inchesToMeters(2);
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.6223;//TODO

    public static final double REEF_AVOIDANCE_MACKINAC_ISLAND_PERCENT = 0.75; // Fudge for side to side reef avoidance
    public static final double DISTANCE_AWAY_MOOSETRACKS_PERCENT = 0.3; // Fudge for intake
    public static final double DISTANCE_AWAY_ROCKYROAD_PERCENT = 0.35; // Fudge for scoring
    public static final double DISTANCE_AWAY_MINTCHOCHOLATECHIP_PERCENT = 0.6; // Fudge for scoring Back Angle 0.5


    /**
     * 
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = 0.6223;

    public static final SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(
        // Front left
        new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
        // Front right
        new Translation2d(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0),
        // Back left
        new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0),
        // Back right
        new Translation2d(-DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -DRIVETRAIN_WHEELBASE_METERS / 2.0)
    );
  }

  public static final class Vision {
    public static final double IMAGE_PROCESSING_LATENCY_MS = 11;
    public static final double VISION_TARGET_OFFSET_FROM_HUB_CENTER_METERS = Units.feetToMeters(2);
    public static final int RED_PIPELINE_INDEX = 0;
    public static final int BLUE_PIPELINE_INDEX = 1;
    public static final double VISION_CAMERA_FIELD_ORIENTATION_SWITCHER = 7.5;
  }

  public static final String UPPER_CANIVORE_ID = "Upper";

  public static class Arm {
    public static final double MOTOR_REVOLUTIONS_PER_DEGREE = (0.347); // 81/360 Practice: 75/360
    public static final Integer ARM_MOTOR_ID = 40;
    public static final double DISTANCE_OF_ARM_IN_INCHES = 18;
    public static final double DISTANCE_TO_TCP = 9; // Was 6
    public static final double ARM_MAX_POWER = 1; //TODO: MAKE FAST
    public static final double ARM_FEEDFORWARD_MULTIPLIER = 0.02; //Practice: 0.03

    public static final double ARM_LEVEL_1 = 95; // -80
    public static final double ARM_LEVEL_2 = 130; // -39, 138
    public static final double ARM_LEVEL_3 = 130; // -39, 138
    public static final double ARM_LEVEL_4 = 142; // -32.5, 144
    public static final double ARM_INTAKE = 212; // 210
    public static final double ARM_AUTO_INTAKE = 214; // 212
    public static final double ARM_TRAVEL_GAME_PIECE = 170; // -10
    public static final double ARM_TRAVEL_NO_GAME_PIECE = 190; // 10
    public static final double ARM_CLIMB = 234; //228

    public static final double ARM_LEVEL_2_AUTO = 138; // -39, 138
    public static final double ARM_LEVEL_3_AUTO = 138; // -39, 138

    public static final double ARM_ALGAE_2 = 135; // 140
    public static final double ARM_ALGAE_3 = 135; // 140
    public static final double ARM_LEVEL_2_SKYFALL = 100; // -80
    public static final double ARM_LEVEL_1_DOGBONE = 130; // 120

    public static final double ARM_ABSOLUTE_MAX = 70;

  }

  public static class Climber {
    public static final Integer CLIMBER_MOTOR_ID = 41; 
    public static final double CLIMBER_MAX_JOYSTICK_SPEED = 0.6;
    public static final double CLIMBER_MAX_PID_SPEED = 0.6;
  }

  public static class Elevator {
    public static final int FRONT_ELEVATOR_MOTOR_ID = 27;
    public static final int BACK_ELEVATOR_MOTOR_ID = 28;
    public static final double STRINGPOT_TICKS_PER_INCH = 47.083;
    public static final double MOTOR_REVOLUTIONS_PER_INCH = 40;
    public static final int STRINGPOT_ZERO = 50;
    public static final double MOTOR_REVOLUTION_TO_STRINGPOT_CONVERSION = 57.788;
    public static final double ELEVATOR_LEVEL_1 = 900; //Practice: 500
    public static final double ELEVATOR_LEVEL_2 = 700; //Practice: 840 //750
    public static final double ELEVATOR_LEVEL_3 = 1350; //Practice: 1550 //1500
    public static final double ELEVATOR_LEVEL_4 = 2550; //was 2600
    public static final double ELEVATOR_INTAKE = 180; //Practice: 280
    public static final double ELEVATOR_TRAVEL = 200; //Practice: 300
    public static final double ELEVATOR_CLIMB = 200; 

    public static final double ELEVATOR_LEVEL_2_AUTO = 750; 
    public static final double ELEVATOR_LEVEL_3_AUTO = 1500; 

    public static final double ELEVATOR_ALGAE_2_APPROACH = 110; //Practice: 330
    public static final double ELEVATOR_ALGAE_2_BANISH = 360; //Practice: 620
    public static final double ELEVATOR_ALGAE_3_APPROACH = 1000; //Practice: 1000
    public static final double ELEVATOR_ALGAE_3_BANISH = 1250; //Practice: 1300
    public static final double ELEVATOR_LEVEL_1_DOGBONE = 200; //Practice: 500

    public static final double ELEVATOR_LEVEL_2_SKYFALL = 1600; //Practice: 1700

    public static final double ELEVATOR_90_DEGREE_LEVEL_2 = 1400; //Practice: 1500
    public static final double ELEVATOR_90_DEGREE_LEVEL_3 = 2150; //Practice: 2250

    public static final double ELEVATOR_SECOND_STAGE_HEIGHT = 1350; //Practice: 1400
    public static final double ELEVATOR_FEEDFORWARD_LOW = 0.02;
    public static final double ELEVATOR_FEEDFORWARD_HIGH = 0.03;

    public static final double ELEVATOR_MAX_SPEED = 1;
    public static final double ELEVATOR_BANISH_ALGAE_SPEED = -0.2;
    public static final double ELEVATOR_BANISH_ALGAE_HEIGHT = 500; //Practice: 600
    public static final double ELEVATOR_BANISH_ALGAE_ARM_CLEAR = 1900; //Practice: 2000

    public static final double ELEVATOR_ABOVE_ARM_LIMIT = 1250; //Practice: 1350
  }
  
  public static class EndEffector {
    public static final Integer ENDEFFECTOR_TOP_MOTOR_ID = 37;
    public static final Integer ENDEFFECTOR_BOTTOM_MOTOR_ID = 36;

    public static final double ENDEFFECTOR_SLOW_OUT_OUTTAKE_SPEED = 0.1;
    public static final double ENDEFFECTOR_FAST_OUTTAKE_SPEED = 0.3;
    public static final double ENDEFFECTOR_FAST_INTAKE_SPEED = 0.3;
    public static final double ENDEFFECTOR_INTAKE_SLOW_SPEED = 0.15;
    public static final double ENDEFFECTOR_REVERSE_SPEED = -0.2;
    public static final double ENDEFFECTOR_BANISH_ALGAE_SPEED = 1;


    public static final double ENDEFFECTOR_OFFSET_FROM_CENTER_Y = Utilities.inchesToMeters(5.5);
    public static final double ENDEFFECTOR_OFFSET_FROM_CENTER_X = Utilities.inchesToMeters(6);

    public static final double OUTTAKE_SPEED_ALTERATION_ZONE = 700;
  }

  public static class Intake {
    public static final Integer INTAKE_MOTOR_ID = 21; 
  }

  public static class IntakeActuator {
    public static final Integer INTAKE_ACTUATOR_MOTOR_ID = 23;
  }

  public static class MotorTesting {
    public static final Integer MOTOR_TESTING_MOTOR_ONE_ID = 58;
    public static final Integer MOTOR_TESTING_MOTOR_TWO_ID = 59;
  }
}