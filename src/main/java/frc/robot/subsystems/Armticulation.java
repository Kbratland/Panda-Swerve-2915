package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Armticulation extends SubsystemBase {
    CANSparkMax m_Armticulation = new CANSparkMax(12, MotorType.kBrushless);
    CANSparkMax m_Armticulation2 = new CANSparkMax(11, MotorType.kBrushed);

    public void lift() {
        // m_Armticulation.set(0.2);
        m_Armticulation2.set(-1);
    }

    public void deploy() {
        m_Armticulation.set(0.25);
    }

    public void stopDeploy() {
        m_Armticulation.set(0);
    }

    public void lower() {
        // m_Armticulation.set(-0.2);
        m_Armticulation2.set(1);
    }

    public void brokenArm() {
        // m_Armticulation.set(0);
        m_Armticulation2.set(0);
    }
}
