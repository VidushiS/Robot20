package Team4450.Robot20;

import Team4450.Lib.Util;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends SubSystem
{
	private Robot			robot;
	private boolean			shooterRunning;
	
	// This variable used to make this class is a singleton.
	
	private static Shooter 	INSTANCE = null;
	
	private Shooter (Robot robot)
	{
		Util.consoleLog();
		
		this.robot = robot;
		
		Util.consoleLog("Shooter created!");
	}
		
	/**
	* Get reference to the single instance of this class shared by any caller of
	* this method.
	* @return Reference to single shared instance of this class.
	*/	
	public static Shooter getInstance(Robot robot)
	{
		if (INSTANCE == null) INSTANCE = new Shooter(robot);
		
		return INSTANCE;		
	}

	@Override
	void enable()
	{
		Util.consoleLog();

		stop();
	}

	@Override
	void disable()
	{
		Util.consoleLog();

		stop();
	}

	@Override
	void dispose()
	{
		Util.consoleLog();
		
		disable();
		
		INSTANCE = null;
	}

	@Override
	protected void updateDS()
	{
		Util.consoleLog();

		SmartDashboard.putBoolean("Shooter", shooterRunning);
	}

	public void stop()
	{
		Util.consoleLog();
		
		Devices.shooterTalon.stopMotor();
		
		shooterRunning = false;
		
		updateDS();
	}
	
	public void start(double power)
	{
		Util.consoleLog();
		
		Devices.shooterTalon.set(power);
		
		shooterRunning = true;
		
		updateDS();
	}
	
	public boolean isRunning()
	{
		return shooterRunning;
	}
}
