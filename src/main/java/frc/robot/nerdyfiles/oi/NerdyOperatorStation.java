package frc.robot.nerdyfiles.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;

/**
 * Code for operator station.
 *
 * Copied from 2020 code
 * @see https://github.com/Team2337/2020-Perpetual-Supercharger/blob/master/src/main/java/frc/robot/nerdyfiles/controller/NerdyOperatorStation.java
 */
public class NerdyOperatorStation extends Joystick {

  private Double lastPressed, branchLevel = 1.0;

  public NerdyOperatorStation(int port) {
    super(port);
  }

  /*
    * --- DRIVER STATION CONTROLS ---
    *
    * These button/switch names and ports will need to be updated each year if the
    * driver's station is redesigned.
    *
    */
  public JoystickButton  whiteButton  = new JoystickButton(this, 1);
  public JoystickButton  blackButton  = new JoystickButton(this, 2);

  public JoystickButton  redSwitch  = new JoystickButton(this, 16);
  public JoystickButton  yellowSwitch = new JoystickButton(this, 7);
  public JoystickButton  blueSwitch   = new JoystickButton(this, 5);
  public JoystickButton  blackSwitch  = new JoystickButton(this, 3);
  
  public JoystickButton  branchAlignment  = new JoystickButton(this, 9);
  public JoystickButton  intakePriority  = new JoystickButton(this, 10);
  public JoystickButton  intakeAlignment  = new JoystickButton(this, 11);

  public JoystickButton  reefTwelve  = new JoystickButton(this, 21);
  public JoystickButton  reefTwo  = new JoystickButton(this, 4);
  public JoystickButton  reefFour  = new JoystickButton(this, 12);
  public JoystickButton  reefSix  = new JoystickButton(this, 14);
  public JoystickButton  reefEight  = new JoystickButton(this, 6);
  public JoystickButton  reefTen  = new JoystickButton(this, 20);

  public JoystickButton armDialOne    = new JoystickButton(this, 13);
  public JoystickButton armDialTwo    = new JoystickButton(this, 8);
  public JoystickButton armDialThree  = new JoystickButton(this, 22);
  public JoystickButton armDialFour   = new JoystickButton(this, 15);
  public JoystickButton armDialFive   = new JoystickButton(this, 18);
  public JoystickButton armDialSix    = new JoystickButton(this, 17);
  public JoystickButton armDialSeven  = new JoystickButton(this, 19);
  public JoystickButton armDialEight  = new JoystickButton(this, 23);
  public JoystickButton armDialNine   = new JoystickButton(this, 24);
  public JoystickButton armDialTen    = new JoystickButton(this, 25);
  public JoystickButton armDialEleven = new JoystickButton(this, 26);

  public boolean isYellowSwitchOn() {
    return this.yellowSwitch.getAsBoolean();
  }

  public boolean isBlackSwitchOn() {
    return this.blackSwitch.getAsBoolean();
  }

  public boolean isBlueSwitchOn() {
    return this.blueSwitch.getAsBoolean();
  }

  public Double[] getReefPositionAndAlignment() {
    if (reefTwelve.getAsBoolean()) {
      lastPressed = 1.0;
    } else if (reefTen.getAsBoolean()) {
      lastPressed = 2.0;
    } else if (reefEight.getAsBoolean()) {
      lastPressed = 3.0;
    } else if (reefSix.getAsBoolean()) {
      lastPressed = 4.0;
    } else if (reefFour.getAsBoolean()) {
      lastPressed = 5.0;
    } else if (reefTwo.getAsBoolean()) {
      lastPressed = 6.0;
    }

    if        (armDialOne.getAsBoolean()){
      branchLevel = 1.0;
    } else if (armDialTwo.getAsBoolean()){
      branchLevel = 2.0;
    } else if (armDialThree.getAsBoolean()){
      branchLevel = 3.0;
    } else if (armDialFour.getAsBoolean()){
      branchLevel = 4.0;
    } else if (armDialFive.getAsBoolean()){
      branchLevel = 5.0;
    } else {
      branchLevel = 6.0;
    }
    
    if (branchAlignment.getAsBoolean()) {
      Double[] scoringArray = new Double[3];
      scoringArray[0] = lastPressed;
      scoringArray[1] = 2.0;
      scoringArray[2] = branchLevel;
      return scoringArray;
    } else {
      Double[] scoringArray = new Double[3];
      scoringArray[0] = lastPressed;
      scoringArray[1] = 1.0;
      scoringArray[2] = branchLevel;
      return scoringArray;
    }
  }
}
