package frc.robot.nerdyfiles.leds;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Setup for addressable LED strip
 * 
 * @author Madison J
 */

public class LED extends SubsystemBase {
	/**
	 * 0-60 are left LEDs
	 * 61-130 are right LEDs
	 */

	private static AddressableLED led;
	private static AddressableLEDBuffer ledBuffer;
	// private static int LED_LENGTH = 273;
	// private static int LED_RIGHT_LENGTH = 70;
	// private static int LED_SHOOTER_START = 71;
	// private static int LED_SHOOTER_END = 202;
	// private static int LED_LEFT_START = 203;
	
	private static int LED_LENGTH = 186;//186
	private static int LED_RIGHT_LENGTH = 70;
	private static int LED_SHOOTER_START = 71;
	private static int LED_SHOOTER_MIDDLE = 94;
	private static int LED_SHOOTER_END = 117;
	private static int LED_LEFT_START = 150;
	private static int LED_LEFT_END = 186;

	/**
	 * Controls the LEDs on the Robot 
	 * 
	 * @param pwm The PWM port that the blinkin is plugged into
	 */
	public LED() {
		led = new AddressableLED(Constants.LEDSTRIP_PWM_ID);
		ledBuffer = new AddressableLEDBuffer(LED_LENGTH);
		led.setLength(ledBuffer.getLength());
	}

	/**
	 * Sets the color of the LEDs
	 * 
	 * @param color A Color object reflecting the color you want to use on the LEDs.  i.e.  kRed, kBlue, kSeashell
	 */
  	public void setColor(Color color) {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setAutoColor(Color color, double time) {
		for (int i = 0; i < 186; i++) {
			if (i < (12 * time)) {
				ledBuffer.setLED(i, color);
			} else {
				ledBuffer.setLED(i, Color.kBlack);
			}
		}

		// for (int i = ((int)(12 * time)); i < 186; i++) {
		// 	ledBuffer.setLED(i, Color.kBlack);
		// }
			led.setData(ledBuffer);
			led.start();
	}

	public void setShooterLeft(Color color) {
		for (int i = LED_SHOOTER_START; i <  LED_SHOOTER_MIDDLE; i++) {
			ledBuffer.setLED(i, color);
		}
		led.setData(ledBuffer);
		led.start();
	}

	public void setShooterRight(Color color) {
		for (int i = (LED_SHOOTER_START + 1); i <  LED_SHOOTER_END; i++) {
			ledBuffer.setLED(i, color);
		}
		led.setData(ledBuffer);
		led.start();
	}

	public void setUprightColors(Color color) {
		for (int i = 0; i < LED_RIGHT_LENGTH; i++) {
			ledBuffer.setLED(i, color);
		}
		for (int i = LED_LEFT_START; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setIntakeColor(Color color) {
		for (int i = 65; i < LED_RIGHT_LENGTH; i++) {
			ledBuffer.setLED(i, color);
		}
		for (int i = 117; i < 122; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setShooterColors(Color color) {
		for (int i = LED_SHOOTER_START; i < LED_SHOOTER_END; i++) {
			ledBuffer.setLED(i, color);
		}

			led.setData(ledBuffer);
			led.start();
	}

	public void setLowerUprightColors(Color color) {
		for (int i = 0; i < 36; i++) {
			ledBuffer.setLED(i, color);
		}

		for (int i = LED_LEFT_START; i < LED_LEFT_END; i++) {
			ledBuffer.setLED(i, color);
		}

		for (int i = LED_SHOOTER_START; i < (LED_SHOOTER_START + 11); i++) {
			ledBuffer.setLED(i, color);
		}

		for (int i = (LED_SHOOTER_END - 11); i < LED_SHOOTER_END; i++) {
			ledBuffer.setLED(i, color);
		}

			led.setData(ledBuffer);
			led.start();
	}


	public void setFrontColor(Color color) {
		for (int i = 0; i < LED_LENGTH; i++) {
			if (i > 60 && i < 78) {
				ledBuffer.setLED(i, color);
			}
		}
		led.setData(ledBuffer);
		led.start();
	}

	public void setLeftColor(Color color) {
		for (int i = 0; i < LED_LENGTH; i++) {
			if (i < 61) {
				ledBuffer.setLED(i, color);
			}
		}
		led.setData(ledBuffer);
		led.start();
	}

	public void setRightColor(Color color) {
		for (int i = 0; i < LED_LENGTH; i++) {
			if (i > 60) {
				ledBuffer.setLED(i, color);
			}
		}
		led.setData(ledBuffer);
		led.start();
	}

	public void setColorRGB(int r, int g, int b) {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setRGB(i, r, g, b);
		}
		led.setData(ledBuffer);
		led.start();
	}

  public void setColorLeft(Color color) {
		for (int i = 0; i < 8; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

    public void setColorLeft5() {
        ledBuffer.setLED(0, Color.kRed);
        ledBuffer.setLED(1, Color.kOrange);
        ledBuffer.setLED(2, Color.kBlue);
        ledBuffer.setRGB(3, 87, 26, 125);
        ledBuffer.setLED(4, Color.kGray);


            led.setData(ledBuffer);
            led.start();
	}

  public void setColorRight(Color color) {
		for (int i = 9; i < 16; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

  public void setColorEdge(Color color) {
		for (int i = 0; i < 2; i++) {
			ledBuffer.setLED(i, color);
		}
    for (int i = 14; i < 16; i++) {
			ledBuffer.setLED(i, color);
		}
			led.setData(ledBuffer);
			led.start();
	}

  public void setColorMiddle() {
		for (int i = 0; i < LED_LENGTH; i++) {
			if (i > 27 && i < 48) {
				ledBuffer.setRGB(i, 25, 25, 25);
			} else {
				ledBuffer.setRGB(i, 0, 0, 0);
			}
		}
			led.setData(ledBuffer);
			led.start();
	}

	public static void setRed() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, Color.kRed);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setGreen() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, Color.kGreen);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public static void setBlue() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, Color.kBlue);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setYellow() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, Color.kYellow);
		}
			led.setData(ledBuffer);
			led.start();
	}

	public void setSeashell() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setLED(i, Color.kSeashell);
		}
			led.setData(ledBuffer);
			led.start();
	}

  
	public static void setLeftOff() {
		for (int i = 0; i < 8; i++) {
			ledBuffer.setRGB(i, 0, 0, 0);
		}
			led.setData(ledBuffer);
			led.start();
  }

  
	public static void setRightOff() {
		for (int i = 9; i < 16; i++) {
			ledBuffer.setRGB(i, 0, 0, 0);
		}
			led.setData(ledBuffer);
			led.start();
  }

	public static void setOff() {
		for (int i = 0; i < LED_LENGTH; i++) {
			ledBuffer.setRGB(i, 0, 0, 0);
		}
			led.setData(ledBuffer);
			led.start();
  }
} 