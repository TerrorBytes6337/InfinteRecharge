package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Feeder extends InstantCommand
{
    private double speed;
    public Feeder(double speed)
    {
        super();
        this.speed = speed;
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    public void execute()
    {
        //Robot.cHandler.Feeder().set(speed);
    }
}