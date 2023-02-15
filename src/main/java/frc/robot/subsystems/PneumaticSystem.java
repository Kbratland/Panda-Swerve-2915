package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSystem extends SubsystemBase {
    CANSparkMax m_ScrewMotor = new CANSparkMax(10, MotorType.kBrushless);

    Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);

    public void suck() {
        pcmCompressor.enableDigital();
    }

    public void decompress() {
        pcmCompressor.disable();
    }

    // boolean enabled = pcmCompressor.enabled();
    // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
    double current = pcmCompressor.getCurrent();
}