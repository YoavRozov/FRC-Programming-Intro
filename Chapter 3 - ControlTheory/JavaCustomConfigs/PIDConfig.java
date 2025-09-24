package frc.teamlib.constantConfigObjects;

import com.ctre.phoenix6.configs.SlotConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

/**
 * PIDConfig
 * PID is used in a closed feedback loop
 * 
 * @param Kp Add voltage proportional to the closed-loop error
 * @param Ki Add voltage proportional to the accumulated closed-loop error
 * @param Kd Add voltage proportional to the rate-of-change of the closed-loop error
 * @implNote
 * Output Voltage = kP * err + kI * accumulated-err-sec + kD * err/sec
 */
public record PIDConfig(double kP, double kI, double kD) {
    public void configProfileSlot(int profileSlotID, TalonFX motor) {
        var slotConfigs = new SlotConfigs();
        slotConfigs.SlotNumber = profileSlotID;
        slotConfigs.kP = kP;
        slotConfigs.kI = kI;
        slotConfigs.kD = kD;

        motor.getConfigurator().apply(slotConfigs);
    }
}
