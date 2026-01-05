package org.sciborgs1155.robot;

import edu.wpi.first.wpilibj.RobotBase;

/** Do not touch this! */
public final class Main {
  private Main() {}

  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
