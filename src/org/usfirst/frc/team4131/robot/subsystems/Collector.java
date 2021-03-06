package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Run on Robot in a Box
 * We will call {@link #collect()} in teleop, and expect the motor to spin at full speed.
 * Tests passed
 * ====================================
 * 
 * @author Patrick
 * @since 1/28/2017
 * 
 */
public class Collector extends Subsystem{
	private static final double STALL_CURRENT = 20;
	private CANTalon motor;
	
	public Collector(){
		motor = new CANTalon(RobotMap.COLLECTOR_MOTOR);
	}
	
	@Override
	protected void initDefaultCommand(){}
	
	public void collect(){
		motor.set(1);
	}
	
	public void stop(){
		motor.set(0);
	}

	public void eject(){
		motor.set(-1);
	}
	public boolean isStalling(){
		return motor.getOutputCurrent() >= STALL_CURRENT;
	}
}
