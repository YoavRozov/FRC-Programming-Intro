package frc.teamlib.constantConfigObjects;

import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

public record SoftLimitsConfig(double maxPosition, double minPosition) {
    public void enableLimit(TalonFX motor) {
        SoftwareLimitSwitchConfigs softLimits = new SoftwareLimitSwitchConfigs();
        softLimits.ForwardSoftLimitThreshold = maxPosition;
        softLimits.ForwardSoftLimitEnable = true;
        softLimits.ReverseSoftLimitThreshold = minPosition;
        softLimits.ReverseSoftLimitEnable = true;

        motor.getConfigurator().apply(softLimits);
    }

    public void disableLimit(TalonFX motor) {
        SoftwareLimitSwitchConfigs softLimits = new SoftwareLimitSwitchConfigs();
        softLimits.ForwardSoftLimitThreshold = maxPosition;
        softLimits.ForwardSoftLimitEnable = false;
        softLimits.ReverseSoftLimitThreshold = minPosition;
        softLimits.ReverseSoftLimitEnable = false;

        motor.getConfigurator().apply(softLimits);
    }
}
