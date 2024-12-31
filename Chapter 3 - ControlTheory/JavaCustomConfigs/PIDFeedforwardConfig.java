// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.poroslib.constantConfigObjects;

import com.ctre.phoenix6.configs.SlotConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

/**
 * PIDFeedforwardConfig
 * PID is used in a closed feedback loop where feedforward is necessary
 * 
 * Feedforward
 * @param kG Add fixed voltage to offset gravity in one direction
 * @param kS Add fixed voltage to offset static friction in the direction of rotation
 * @param kV Add voltage proportional to the desired profile velocity
 * @param kA Add voltage proportional to the desired profile acceleration
 * @param pidConfig PIDConfig object
 * 
 * <p>
 * </p>
 * kP: Add voltage proportional to the closed-loop error
 * <p>
 * </p>
 * kI: Add voltage proportional to the accumulated closed-loop error
 * <p>
 * </p>
 * kD: Add voltage proportional to the rate-of-change of the closed-loop error
 * <p>
 * </p>
 * 
 * @implNote
 * Output Voltage = kG + kS * sign(v) + kV * v + kA * a + kP * err + kI * accumulated-err-sec + kD * err/sec
 */
public record PIDFeedforwardConfig(double kG, double kS, double kV, double kA, PIDConfig pidConfig) {
    public void configProfileSlot(int profileSlotID, TalonFX motor) {
        var slotConfigs = new SlotConfigs();
        slotConfigs.SlotNumber = profileSlotID;

        // Feedforward
        slotConfigs.kG = kG;
        slotConfigs.kS = kS;
        slotConfigs.kV = kV;
        slotConfigs.kA = kA;

        // Feedback
        slotConfigs.kP = pidConfig.kP();
        slotConfigs.kI = pidConfig.kI();
        slotConfigs.kD = pidConfig.kD();
        motor.getConfigurator().apply(slotConfigs);
    }

    public void updateConfig(int profileSlotID, TalonFX motor, double kG, double kS, double kV, double kA, PIDConfig pidConfig) {
        var slotConfigs = new SlotConfigs();
        slotConfigs.SlotNumber = profileSlotID;

        // Feedforward
        slotConfigs.kG = kG;
        slotConfigs.kS = kS;
        slotConfigs.kV = kV;
        slotConfigs.kA = kA;

        // Feedback
        slotConfigs.kP = pidConfig.kP();
        slotConfigs.kI = pidConfig.kI();
        slotConfigs.kD = pidConfig.kD();
        motor.getConfigurator().apply(slotConfigs);
    }
}