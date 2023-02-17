package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSystem extends SubsystemBase {

    Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);
    Solenoid out = new Solenoid(PneumaticsModuleType.REVPH, 1);
    Solenoid in = new Solenoid(PneumaticsModuleType.REVPH, 0);

    public void suck() {
        phCompressor.enableDigital();
    }

    public void decompress() {
        phCompressor.disable();
    }

    public void reverse() {
        out.set(true);
    }

    public void thrust() {
        in.set(true);
    }

    // boolean enabled = pcmCompressor.enabled();
    // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
}