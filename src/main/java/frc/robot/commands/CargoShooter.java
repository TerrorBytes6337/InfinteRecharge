package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CargoShooter extends InstantCommand 
{
    private double speed;

    public CargoShooter(double speed){
        super();
        this.speed = speed;
    }

    public void execute(){
        //Robot.cHandler.CargoShooter().set(speed);
    }
}