package frc.robot.commands;
import frc.robot.subsystems.pneumaticSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticSystem;

public class CrabClaw {

    public PistonOut(PneumaticSystem pneumaticSystem) {
        addRequirements(pneumaticSystem);
        this.pneumaticSystem = pneumaticSystem;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        pneumaticSystem.CloseClaw.set(true);
    }

    public boolean isFinished() {
        pneumaticSystem.CloseClaw.set(false);
        pneumaticSystem.OpenClaw.set(true);
        return false;
    }
}