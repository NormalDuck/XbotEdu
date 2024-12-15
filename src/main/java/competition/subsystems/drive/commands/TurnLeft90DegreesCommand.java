package competition.subsystems.drive.commands;

import javax.inject.Inject;

import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;
import xbot.common.math.XYPair;

public class TurnLeft90DegreesCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;
    double startDegree;

    @Inject
    public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    @Override
    public void initialize() {
        this.startDegree = pose.getCurrentHeading().getDegrees();
    }

    @Override
    public void execute() {
        if (startDegree - 80 > pose.getCurrentHeading().getDegrees() ) {
            drive.tankDrive(0.5, 0);
        } else {
            drive.tankDrive(-0.5, 0);
        }
        if (startDegree - 90 > pose.getCurrentHeading().getDegrees()) {
            System.out.println("done!");
        }
    }
}
