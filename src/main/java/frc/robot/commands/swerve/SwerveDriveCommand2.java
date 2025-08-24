package frc.robot.commands.swerve;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.utility.PhoenixPIDController;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.nerdyfiles.utilities.Utilities;
import frc.robot.subsystems.Drivetrain;

public class SwerveDriveCommand2 extends Command{

    private PIDController poseTranslationXController = new PIDController(0.8, 0, 0.05);//.5 0.016
    private PIDController poseTranslationYController = new PIDController(0.8, 0, 0.05);//.5 0.016
    
    /* Setting up bindings for necessary control of the swerve drive platform */
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private SwerveRequest.RobotCentric robotCentric = new SwerveRequest.RobotCentric()
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage);
    
    private SwerveRequest.FieldCentricFacingAngle driveFacingAngle = new SwerveRequest.FieldCentricFacingAngle()
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage)
        .withRotationalDeadband(0.05);

    private Drivetrain drivetrain;
    private CommandXboxController driverJoystick;
    private SwerveRequest swerveRequest;
    
    private PhoenixPIDController turnPID = new PhoenixPIDController(7, 0, 0);
    private double forward, rotation, strafe = 0;


    public SwerveDriveCommand2(Drivetrain drivetrain, CommandXboxController driverJoystick) {
        this.drivetrain = drivetrain;
        this.driverJoystick = driverJoystick;
        addRequirements(drivetrain);
    }
    
    @Override
    public void initialize() {
        turnPID.enableContinuousInput(-Math.PI, Math.PI);
        driveFacingAngle.HeadingController = turnPID;
        poseTranslationXController.setTolerance(0.01, 1);
        poseTranslationYController.setTolerance(0.01, 1);

    }
    
    @Override
    public void execute() {
        
        //Read Inputs From Joysticks
        forward = Utilities.deadband(-driverJoystick.getLeftY(), Constants.Swerve.driveDeadband) * (Constants.Swerve.MaxSpeed/Constants.Swerve.driveAdjustment);
        strafe = Utilities.deadband(-driverJoystick.getLeftX(), Constants.Swerve.driveDeadband) * (Constants.Swerve.MaxSpeed/Constants.Swerve.driveAdjustment);
        rotation = Utilities.deadband(-driverJoystick.getRightX(), Constants.Swerve.driveDeadband) * Constants.Swerve.MaxAngularRate;
        if(drivetrain.driveAtAngle) {
            swerveRequest = driveFacingAngle
                .withTargetDirection(drivetrain.rotationAngle)
                .withVelocityX(forward)
                .withVelocityY(strafe);
        }  else if(drivetrain.robotCentric) {
            
            swerveRequest = robotCentric
                .withVelocityX(forward)
                .withVelocityY(strafe)
                .withRotationalRate(rotation);

        } else if ((Math.abs(forward) > 0 || Math.abs(strafe) > 0 || Math.abs(rotation) > 0) || drivetrain.getChassisSpeeds() > 0.25){//0.25
            swerveRequest = drive
                .withVelocityX(forward)
                .withVelocityY(strafe)
                .withRotationalRate(rotation);
        } else {
            swerveRequest = brake;
        }

        drivetrain.setControl(swerveRequest);

    }

    

    @Override
    public void end(boolean interupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
