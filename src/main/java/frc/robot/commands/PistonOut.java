package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticSystem;

public class PistonOut extends CommandBase {
    public PneumaticSystem pneumaticSystem;

    public PistonOut(PneumaticSystem pneumaticSystem) {
        addRequirements(pneumaticSystem);
        this.pneumaticSystem = pneumaticSystem;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        pneumaticSystem.decompress();
    }

    public boolean isFinished() {
        return false;
    }
}
