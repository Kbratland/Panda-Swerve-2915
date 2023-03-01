package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Armticulation;

public class ArmMove extends CommandBase {
    Armticulation armticulation;
    XboxController m_controller;

    public ArmMove(Armticulation armticulation, XboxController m_controller) {
        addRequirements(armticulation);
        this.armticulation = armticulation;
        this.m_controller = m_controller;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        if (m_controller.getRawAxis(1) > 0.5) {
            armticulation.lift();
            System.out.println("lowering");
        } else if (m_controller.getRawAxis(1) < -0.5) {
            armticulation.lower();
            System.out.println("lifting");
        } else {
            armticulation.brokenArm();
        }
    }

    public boolean end() {
        return false;
    }
}
