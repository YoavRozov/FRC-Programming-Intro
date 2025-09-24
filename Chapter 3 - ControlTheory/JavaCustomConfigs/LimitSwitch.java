// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.teamlib.sensors.limitswitches;

import edu.wpi.first.wpilibj.DigitalInput;

/** Add your docs here. */
public class LimitSwitch {
    private DigitalInput limitSwitch;
    private boolean isNormallyClosed;

    public LimitSwitch (int channel, boolean isNormallyClosed)
	{
        this.limitSwitch = new DigitalInput(channel);
		this.isNormallyClosed = isNormallyClosed;
    }
    
    public boolean get(){
        return this.limitSwitch.get() == this.isNormallyClosed;
    }

    public DigitalInput getLimitSwitch(){
        return this.limitSwitch;
    }

    public void setLimitSwitch(int channel){
        this.limitSwitch = new DigitalInput(channel);
    }

    public boolean getIsNormallyClosed(){
        return this.isNormallyClosed;
    }
    
    public void setIsNormallyClosed(boolean isNormallyClosed){
        this.isNormallyClosed = isNormallyClosed;
    }
}