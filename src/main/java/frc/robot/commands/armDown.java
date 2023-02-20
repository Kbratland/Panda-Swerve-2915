package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Armticulation;

public class armDown extends CommandBase {
    public Armticulation armticulation;

    public armDown(Armticulation armticulation) {
        addRequirements(armticulation);
        this.armticulation = armticulation;
    }

    @Override
    public void initialize() {

    }

    public void execute() {
        armticulation.lower();
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        armticulation.brokenArm();
    }

}
