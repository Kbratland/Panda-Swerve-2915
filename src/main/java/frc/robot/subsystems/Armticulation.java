package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Armticulation extends SubsystemBase {
    CANSparkMax m_Armticulation = new CANSparkMax(12, null);

    public void lift() {
        m_Armticulation.set(1);
    }

    public void lower() {
        m_Armticulation.set(1);
    }

    public void brokenArm() {
        m_Armticulation.set(0);
    }
}
