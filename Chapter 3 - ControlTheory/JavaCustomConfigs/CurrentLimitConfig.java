package frc.poroslib.constantConfigObjects;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

/**
 * Current limits config 
 * @param currentLimit
 *      The amount of supply current allowed. Use currentThreshold and timeThreshold to allow brief periods of high-current before limiting occurs.
 *      Units: A
 *  @param currentThreshold
 *      Delay supply current limiting until current exceeds this threshold for longer than timeThreshold. 
 *      This allows current draws above currentLimit for a fixed period of time. This has no effect if currentLimit is greater than this value.
 *      Units: A
 *  @param timeThreshold
 *      Allows unlimited current for a period of time before current limiting occurs.
 *      Current threshold is the maximum of currentThreshold and currentLimit.
 *      Units: sec
 */
public record CurrentLimitConfig(double currentLimit, double currentThreshold, double timeThreshold) {
    public void enableLimit(TalonFX motor) {
        CurrentLimitsConfigs currentLimits = new CurrentLimitsConfigs();
        currentLimits.SupplyCurrentLimit = currentLimit;
        currentLimits.SupplyCurrentThreshold = currentThreshold;
        currentLimits.SupplyTimeThreshold = timeThreshold;
        currentLimits.SupplyCurrentLimitEnable = true;

        motor.getConfigurator().apply(currentLimits);
    }

    public void disableLimit(TalonFX motor) {
        CurrentLimitsConfigs currentLimits = new CurrentLimitsConfigs();
        currentLimits.SupplyCurrentLimit = currentLimit;
        currentLimits.SupplyCurrentThreshold = currentThreshold;
        currentLimits.SupplyTimeThreshold = timeThreshold;
        currentLimits.SupplyCurrentLimitEnable = false;

        motor.getConfigurator().apply(currentLimits);
    }
}
