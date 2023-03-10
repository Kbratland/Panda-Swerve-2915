
package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*
From McLain: 
See here:  https://docs.wpilib.org/en/stable/docs/software/hardware-apis/pneumatics/pneumatics.html
That diocumentat
You probably want your setup work (see comments below) in your constructor. Then you probably want two functions:
  1. Push (or grab or whatever is meaningful)
  2. Pull (or release or whatever is meaningful)
  [or you could use one function and toggle it. See the linked documentation on that one 'cause there's setup work for that, too]
  
*/
public class PneumaticSystem extends SubsystemBase {
    /*
     * From McLain: you have two compressors created here: why?
     */
    // Compressor phCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    Compressor phCompressor = new Compressor(13, PneumaticsModuleType.REVPH);

    // phCompressor.enableDigital();
    // phCompressor.disable();
    /*
     * From McLain
     * The above lines should go in a constructor function to get the compressor
     * started
     */

    boolean enabled = phCompressor.isEnabled();
    double current = phCompressor.getCurrent();

    // DoubleSolenoid exampleDoublePCM = new
    DoubleSolenoid exampleDoublePH = new DoubleSolenoid(13, PneumaticsModuleType.REVPH, 0, 1);
    // DoubleSolenoid musclePiston = new DoubleSolenoid(13,
    // PneumaticsModuleType.REVPH, 2, 3);

    // exampleDoublePH.set(k)

    public void suck() {
        phCompressor.enableDigital();
    }

    public void decompress() {
        phCompressor.disable();
    }

    // public void muscleReverse() {
    // musclePiston.set(kReverse);
    // }

    public void reverse() {
        exampleDoublePH.set(kReverse);
    }

    // public void muscleThrust() {
    // musclePiston.set(kForward);
    // }

    public void thrust() {
        exampleDoublePH.set(kForward);
    }

    // public void muscleOff() {
    // musclePiston.set(kOff);
    // }

    public void off() {
        exampleDoublePH.set(kOff);
    }
}
