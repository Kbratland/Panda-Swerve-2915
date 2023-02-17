package frc.robot.commands;

import frc.robot.subsystems.PneumaticSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Compress extends CommandBase {
 public CrabClaw(PneumaticSystem m_Compressor) {
        addRequirements(m_Compressor);
        this.m_piston = m_Compressor;

@Override
    public void initialize() {

    }

    public void execute() {
        m_Compressor.suck();
    }

    public boolean isFinished() {
        return false;
    }
    }
}