package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ScrewDrive;

public class ScrewLower extends CommandBase {
    public ScrewDrive screwDrive;

    public ScrewLower(ScrewDrive screwDrive) {
        addRequirements(screwDrive);
        this.screwDrive = screwDrive;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        screwDrive.lower();
        System.out.println("LowCommand");
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        screwDrive.stopScrew();
    }

}
