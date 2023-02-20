package frc.robot.commands;

import frc.robot.subsystems.PneumaticSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClawOff extends CommandBase {
    public PneumaticSystem m_piston;

    public ClawOff(PneumaticSystem m_piston) {
        addRequirements(m_piston);
        this.m_piston = m_piston;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        m_piston.off();
    }

    public boolean isFinished() {
        return false;
    }
}