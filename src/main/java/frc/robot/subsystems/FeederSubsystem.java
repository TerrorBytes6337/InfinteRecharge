package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder.BooleanConsumer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.PID.ElevatorPID;
import frc.robot.OI;
import frc.robot.RobotMap;

public class FeederSubsystem extends Subsystem
{
    
    private static final Hand FEEDER_IN = Hand.kLeft;
    private static final Hand FEEDER_OUT = Hand.kRight;
    public FeederSubsystem()
    {
        super();
        //FEEDER_IN = new Spark(OI.CARGO_FEEDER_IN);
        //FEEDER_OUT = new Spark(OI.CARGO_FEEDER_OUT);
    }
    

    protected double getFeederIn()
    {
        return OI.XBOX_CONTROLLER.getX(FEEDER_IN);
    }

    protected double getFeederOut()
    {
        return OI.XBOX_CONTROLLER.getY(FEEDER_OUT);
    }

    @Override
    protected void initDefaultCommand() {

    }

    
} 