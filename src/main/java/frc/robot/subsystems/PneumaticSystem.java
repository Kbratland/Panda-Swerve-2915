package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSystem extends SubsystemBase {
    Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);
    Solenoid OpenSolenoid = new Solenoid(PneumaticsModuleType.REVPH, 0);
    Solenoid CloseSolenoid = new Solenoid(PneumaticsModuleType.REVPH, 1);

    public void Compress() {
        pcmCompressor.enable();
    }

    public void Decompress() {
        pcmCompressor.disable();
    }

    public void CloseClaw() {
        CloseSolenoid.set(true);
        /*if statment for if it's open
    Opensolonoid.set(false);*/
    }

    public void OpenClaw() {
        OpenSolenoid.set(true);
    /*if statment for if it's closed
    Opensolonoid.set(false);*/
    }

    // boolean enabled = pcmCompressor.enabled();
    // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
    double current = pcmCompressor.getCurrent();
}