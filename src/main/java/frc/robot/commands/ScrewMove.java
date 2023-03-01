package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ScrewDrive;

public class ScrewMove extends CommandBase {
    ScrewDrive screwDrive;
    XboxController m_XboxController;

    public ScrewMove(ScrewDrive screwDrive, XboxController m_XboxController) {
        addRequirements(screwDrive);
        this.screwDrive = screwDrive;
        this.m_XboxController = m_XboxController;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        if (m_XboxController.getRawAxis(5) > 0.5) {
            screwDrive.lower();
            System.out.println("ScrewLift");
        } else if (m_XboxController.getRawAxis(5) < -0.5) {
            screwDrive.lift();
            System.out.println("ScrewLower");
        } else {
            screwDrive.stopScrew();
        }
    }

    public boolean end() {
        return false;
    }
}
