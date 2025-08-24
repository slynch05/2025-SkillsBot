package frc.robot.nerdyfiles.utilities;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

public class CTREUtils {

  /**
   * Creates a default limit configuration. This is base the current limit
   * configuration we use on our motors to prevent overheating the motors
   * in catastrophic scenerios.
   */
  public static CurrentLimitsConfigs setDefaultCurrentLimit() {
    //TODO: Valdiate with documentation
    CurrentLimitsConfigs defaultCurrentLimit = new CurrentLimitsConfigs();
    defaultCurrentLimit.SupplyCurrentLimit = 40.0;
    defaultCurrentLimit.SupplyCurrentLowerLimit = 50.0;
    defaultCurrentLimit.SupplyCurrentLowerTime = 1.0;
    defaultCurrentLimit.SupplyCurrentLimitEnable = true;

    defaultCurrentLimit.StatorCurrentLimit = 50.0;
    defaultCurrentLimit.StatorCurrentLimitEnable = true;
    return defaultCurrentLimit;
  }

  public static CurrentLimitsConfigs setEndEffectorCurrentLimit() {
    //TODO: Valdiate with documentation
    CurrentLimitsConfigs defaultCurrentLimit = new CurrentLimitsConfigs();
    defaultCurrentLimit.SupplyCurrentLimit = 50.0;
    defaultCurrentLimit.SupplyCurrentLowerLimit = 60.0;
    defaultCurrentLimit.SupplyCurrentLowerTime = 1.0;
    defaultCurrentLimit.SupplyCurrentLimitEnable = false;

    defaultCurrentLimit.StatorCurrentLimit = 50.0;
    defaultCurrentLimit.StatorCurrentLimitEnable = false;
    return defaultCurrentLimit;
  }

  public static CurrentLimitsConfigs setElevatorCurrentLimit() {
    CurrentLimitsConfigs defaultCurrentLimit = new CurrentLimitsConfigs();
    defaultCurrentLimit.SupplyCurrentLimit = 40.0;//45
    defaultCurrentLimit.SupplyCurrentLowerLimit = 50.0;
    defaultCurrentLimit.SupplyCurrentLowerTime = 1.0;
    defaultCurrentLimit.SupplyCurrentLimitEnable = true;

    defaultCurrentLimit.StatorCurrentLimit = 50.0;
    defaultCurrentLimit.StatorCurrentLimitEnable = true;
    return defaultCurrentLimit;
  }

  public static CurrentLimitsConfigs setLowCurrentLimit() {
    CurrentLimitsConfigs lowCurrentLimit = new CurrentLimitsConfigs();
    lowCurrentLimit.SupplyCurrentLimit = 30.0;
    lowCurrentLimit.SupplyCurrentLowerLimit = 30.0;
    lowCurrentLimit.SupplyCurrentLowerTime = 1.0;
    lowCurrentLimit.SupplyCurrentLimitEnable = true;

    lowCurrentLimit.StatorCurrentLimit = 30.0;
    lowCurrentLimit.StatorCurrentLimitEnable = true;
    return lowCurrentLimit;
  }

  public static CurrentLimitsConfigs setIntakeActuatorCurrentLimit() {
    CurrentLimitsConfigs currentLimit = new CurrentLimitsConfigs();
    currentLimit.SupplyCurrentLimit = 10.0;
    currentLimit.SupplyCurrentLowerLimit = 10.0;
    currentLimit.SupplyCurrentLowerTime = 1.0;
    currentLimit.SupplyCurrentLimitEnable = true;

    currentLimit.StatorCurrentLimit = 10.0;
    currentLimit.StatorCurrentLimitEnable = true;
    return currentLimit;
  }

}
