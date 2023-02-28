// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.PS4Controller.Button;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ClawOff;
import frc.robot.commands.Compress;
import frc.robot.commands.CrabClaw;
import frc.robot.commands.CrabClawClose;
import frc.robot.commands.ScrewLift;
import frc.robot.commands.ScrewLower;
// import frc.robot.commands.armDeploy;
import frc.robot.commands.armDown;
import frc.robot.commands.armUp;
// import frc.robot.commands.muscleIn;
// import frc.robot.commands.muscleOut;
import frc.robot.subsystems.Armticulation;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticSystem;
import frc.robot.subsystems.ScrewDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;

import java.util.List;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
        // The robot's subsystems+

        private final DriveSubsystem m_robotDrive = new DriveSubsystem();
        private final PneumaticSystem pneumaticSystem = new PneumaticSystem();
        private final ScrewDrive m_screwDrive = new ScrewDrive();
        private final Armticulation m_armSystem = new Armticulation();
        public final ScrewLift m_Lift = new ScrewLift(m_screwDrive);
        public final armDown aDown = new armDown(m_armSystem);
        public final armUp aUp = new armUp(m_armSystem);
        public final ScrewLower m_Lower = new ScrewLower(m_screwDrive);
        public final CrabClaw m_CrabClaw = new CrabClaw(pneumaticSystem);
        public final CrabClawClose m_ClawClose = new CrabClawClose(pneumaticSystem);
        public final Compress m_Compress = new Compress(pneumaticSystem);
        public final ClawOff m_ClawOff = new ClawOff(pneumaticSystem);
        // public final armDeploy aDeploy = new armDeploy(m_armSystem);
        // public final muscleIn m_MuscleIn = new muscleIn(pneumaticSystem);
        // public final muscleOut m_MuscleOut = new muscleOut(pneumaticSystem);
        //
        // The driver's controller
        Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);
        XboxController m_arnController = new XboxController(1);
        // Trigger button5 = new JoystickButton(m_driverController, 5);
        // Trigger button6 = new JoystickButton(m_driverController, 6);

        /**
         * The container for the robot. Contains subsystems, OI devices, and commands.
         */
        public RobotContainer() {

                // Configure the button bindings
                configureButtonBindings();

                // Configure default commands
                m_robotDrive.setDefaultCommand(
                                new RunCommand(
                                                () -> m_robotDrive.drive(
                                                                MathUtil.applyDeadband(
                                                                                -m_driverController.getRawAxis(1),
                                                                                0.05),
                                                                MathUtil.applyDeadband(
                                                                                -m_driverController.getRawAxis(0),
                                                                                0.05),
                                                                MathUtil.applyDeadband(
                                                                                -m_driverController.getRawAxis(2),
                                                                                0.05),
                                                                true),
                                                m_robotDrive));
        }

        /**
         * Use this method to define your button->command mappings. Buttons can be
         * created by
         * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
         * subclasses ({@link
         * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
         * passing it to a
         * {@link JoystickButton}.
         */
        private void configureButtonBindings() {
                // new JoystickButton(m_driverController, Button.kR1.value)
                // .whileTrue(new RunCommand(
                // () -> m_robotDrive.setX(),
                // m_robotDrive));
                // button5.whileTrue(new ScrewLift(m_screwDrive));
                // button6.whileTrue(new ScrewLower(m_screwDrive));
                new JoystickButton(m_driverController, 5).whileTrue(m_Lift);
                new JoystickButton(m_driverController, 6).whileTrue(m_Lower);
                new JoystickButton(m_driverController, 3).whileTrue(m_CrabClaw);
                new JoystickButton(m_driverController, 4).whileTrue(m_ClawClose);
                new JoystickButton(m_driverController, 1).whileTrue(aDown);
                new JoystickButton(m_driverController, 2).whileTrue(aUp);
                new JoystickButton(m_driverController, 7).whileTrue(m_Compress);
                // new JoystickButton(m_driverController, 8).whileTrue(aDeploy);
        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                // Create config for trajectory
                TrajectoryConfig config = new TrajectoryConfig(
                                AutoConstants.kMaxSpeedMetersPerSecond,
                                AutoConstants.kMaxAccelerationMetersPerSecondSquared)
                                // Add kinematics to ensure max speed is actually obeyed
                                .setKinematics(DriveConstants.kDriveKinematics);

                // An example trajectory to follow. All units in meters.
                Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
                                // Start at the origin facing the +X direction
                                new Pose2d(0, 0, new Rotation2d(0)),
                                // Waypoint syntax - newTranslation2d(x,y,(optional)Rotation);
                                List.of(new Translation2d(1, 0), new Translation2d(1, 1), new Translation2d(0, 1)),
                                // End 3 meters straight ahead of where we started, facing forward
                                new Pose2d(0, 0, new Rotation2d(1)),
                                config);
                // hi
                var thetaController = new ProfiledPIDController(
                                AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
                thetaController.enableContinuousInput(-Math.PI, Math.PI);

                SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
                                exampleTrajectory,
                                m_robotDrive::getPose, // Functional interface to feed supplier
                                DriveConstants.kDriveKinematics,

                                // Position controllers
                                new PIDController(AutoConstants.kPXController, 0, 0),
                                new PIDController(AutoConstants.kPYController, 0, 0),
                                thetaController,
                                m_robotDrive::setModuleStates,
                                m_robotDrive);

                // Reset odometry to the starting pose of the trajectory.
                m_robotDrive.resetOdometry(exampleTrajectory.getInitialPose());

                // Run path following command, then stop at the end.
                return swerveControllerCommand.andThen(() -> m_robotDrive.drive(0, 0, 0, false));
        }
}
