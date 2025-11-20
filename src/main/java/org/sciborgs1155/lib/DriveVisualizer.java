package org.sciborgs1155.lib;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveVisualizer {
    private double leftVoltageVolts;
    private double rightVoltageVolts;

    private final Field2d simulatedField;

    private final DifferentialDrivetrainSim simulation = new DifferentialDrivetrainSim(
            DCMotor.getNEO(2), 7.29, 7.5,
            60.0, Units.inchesToMeters(3), 0.7112,
            VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005));

    public DriveVisualizer() {
        leftVoltageVolts = 0;
        rightVoltageVolts = 0;

        simulatedField = new Field2d();
    }

    public void setLeftInput(double inputVoltage) {
        leftVoltageVolts = inputVoltage;
    }

    public void setRightInput(double inputVoltage) {
        rightVoltageVolts = inputVoltage;
    }

    public void update(double dtSeconds) {
        simulation.setInputs(leftVoltageVolts, rightVoltageVolts);
        simulation.update(dtSeconds);

        simulatedField.setRobotPose(simulation.getPose());
        SmartDashboard.putData(simulatedField);
    }

}
