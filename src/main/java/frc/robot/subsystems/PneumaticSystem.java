
package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSystem extends SubsystemBase {
    Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);

    // pcmCompressor.enableDigital();
    // pcmCompressor.disable();

    boolean enabled = pcmCompressor.enabled();
    boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
    double current = pcmCompressor.getCurrent();

    // DoubleSolenoid exampleDoublePCM = new
    // DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
    DoubleSolenoid exampleDoublePH = new DoubleSolenoid(9, PneumaticsModuleType.REVPH, 4, 5);

    // exampleDoublePH.set(k)

    public void suck() {
        phCompressor.enableDigital();
    }

    public void decompress() {
        phCompressor.disable();
    }

    public void reverse() {
        // out.set(true);
    }

    public void thrust() {
        // in.set(true);
    }
}
