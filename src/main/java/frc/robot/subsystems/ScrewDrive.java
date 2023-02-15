package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ScrewDrive extends SubsystemBase {
    CANSparkMax m_ScrewMotor = new CANSparkMax(10, MotorType.kBrushless);

    public void lift() {
        m_ScrewMotor.set(.75);
        System.out.println("lifting");
    }

    public void lower() {
        m_ScrewMotor.set(-0.75);
        System.out.println("Lowering");
    }

    public void stopScrew() {
        m_ScrewMotor.set(0);
        System.out.println("stoping");
    }
}