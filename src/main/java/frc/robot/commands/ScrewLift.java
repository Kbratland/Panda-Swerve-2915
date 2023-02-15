package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ScrewDrive;

public class ScrewLift extends CommandBase {
    public ScrewDrive screwDrive;

    public ScrewLift(ScrewDrive screwDrive) {
        addRequirements(screwDrive);
        this.screwDrive = screwDrive;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        screwDrive.lift();
        System.out.println("LiftCommand");
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        screwDrive.stopScrew();
    }

}
