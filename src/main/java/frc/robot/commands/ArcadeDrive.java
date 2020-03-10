package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.AcceleratableMotor;
import frc.robot.Robot;

public class ArcadeDrive extends InstantCommand
{
    private static final double DEFAULT_INCREMENT = 0.30;
    private boolean stopCalled = false;
    private boolean accelerate;
    private double lastXSpeed = 0;
    private double increment;
    private double lastTime;
    private double timeMultiplier = 1;
    
    public ArcadeDrive()
    {
        super();
        this.accelerate = false;
        lastTime = timeSinceInitialized();
    }

    public ArcadeDrive(boolean accelerate)
    {
        super();
        this.accelerate = accelerate;
        if(accelerate)
        {
            this.increment = DEFAULT_INCREMENT;
        }
        lastTime = timeSinceInitialized();
    }

    public ArcadeDrive(double accelerateIncrement, double timeMultiplier)
    {
        super();
        this.increment = accelerateIncrement;
        this.accelerate = false;
        this.timeMultiplier = timeMultiplier;
        lastTime = timeSinceInitialized();
    }

    protected void execute()
    {        
        double xSpeed = -Robot.m_DrivingSubsystem.getForwardXbox();
        double zRotation = Robot.m_DrivingSubsystem.getRightXbox();
        if(accelerate)
        {
            double thisTime = timeSinceInitialized();
            double newSpeed = AcceleratableMotor.speedLerp(lastXSpeed, xSpeed, (thisTime - lastTime)*timeMultiplier, increment);
            if(newSpeed > 1) newSpeed = 1;
            else if(newSpeed < -1) newSpeed = -1;
            if(Math.abs(newSpeed) > 0.7d)
            System.out.println("{ "+(thisTime - lastTime)+", "+Math.round(newSpeed*1000d) / 1000d+" }");
            lastTime = thisTime;
            Robot.m_DrivingSubsystem.driver.arcadeDrive(newSpeed, zRotation);
            lastXSpeed = newSpeed;
        }
        else
        {
            Robot.m_DrivingSubsystem.driver.arcadeDrive(xSpeed, zRotation);
        }
    }
    public boolean isFinished()
    {
        
        return 
        //this.isCanceled() || this.isCompleted() 
        // || this.isTimedOut() 
        //||
         stopCalled;
    }
    public void stopExecuting()
    {
        stopCalled = true;
    }

    /*
    @Override
    public void execute()
    {
        double xSpeed = -Robot.m_DrivingSubsystem.getForwardXbox();
        double zRotation = Robot.m_DrivingSubsystem.getRightXbox();
        
        Robot.m_DrivingSubsystem.driver.arcadeDrive(xSpeed, zRotation);
        
    }
    */
}


