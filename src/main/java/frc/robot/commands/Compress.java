package frc.robot.commands;

import frc.robot.subsystems.PneumaticSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Compress extends CommandBase {
    private PneumaticSystem m_compressor;

    public Compress(PneumaticSystem m_compressor) {
        addRequirements(m_compressor);
        this.m_compressor = m_compressor;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        m_compressor.suck();
    }

    public boolean isFinished() {
        return false;
    }
}