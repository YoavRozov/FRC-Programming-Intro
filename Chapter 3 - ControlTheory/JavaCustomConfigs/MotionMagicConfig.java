package frc.teamlib.constantConfigObjects;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

/**
 * MotionMagicConfig
 * MotionMagic is used to produce a motion profile to be used with a closed feedback loop
 * 
 * @param pidConfig PIDFeedforwardConfig object
 * @param acceleration This is the target acceleration Motion Magic® based control modes are allowed to use. Units: rot per sec²
 * @param cruiseVelocity Max velocity Motion Magic® based control modes are allowed to use. Units: rot per sec
 * @param jerk This is the target jerk (acceleration derivative) Motion Magic® based control modes are allowed to use. Units: rot per sec³
 */
public record MotionMagicConfig(PIDFeedforwardConfig pidConfig, double acceleration, double cruiseVelocity, double jerk) {
    public void configProfileSlot(int profileSlotID, TalonFX motor) {
        pidConfig.configProfileSlot(profileSlotID, motor);
        
        var motionMagicConfigs = new MotionMagicConfigs();
        motionMagicConfigs.MotionMagicCruiseVelocity = cruiseVelocity;
        motionMagicConfigs.MotionMagicAcceleration = acceleration;
        motionMagicConfigs.MotionMagicJerk = jerk;

        motor.getConfigurator().apply(motionMagicConfigs);
    }
}