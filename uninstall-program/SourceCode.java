package AllTasks;

/* 
 * A simple script to uninstall a program from my Windows system
 * */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class UnistallProgram {

	public static void main(String[] args) {

		try {
			Robot robot = new Robot();

			/*
			 * Opening the control panel the exec method executes the specified string
			 * command in a separate process cmd /c - used to run the following command and
			 * exit start opens a new command line control opens the control panel
			 */
			Runtime.getRuntime().exec("cmd /c start control");

			robot.delay(2000);

			// Pressing Alt + Space + X to maximize the control panel
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_SPACE);

			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);

			// Pressing Ctrl + F to search for the Uninstalling option
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_F);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_F);

			// Typing in the "uninstall" search parameter, going down in the list and
			// pressing Enter
			int inputUninstall[] = { KeyEvent.VK_U, KeyEvent.VK_N, KeyEvent.VK_I, KeyEvent.VK_N, KeyEvent.VK_S,
					KeyEvent.VK_T, KeyEvent.VK_A, KeyEvent.VK_L, KeyEvent.VK_L };

			for (int input : inputUninstall) {
				robot.keyPress(input);
				robot.keyRelease(input);
			}

			robot.delay(2000);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			System.out.println("An unexpected error occured with the Robot handler.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An unexpected error occured in the runtime.");
			e.printStackTrace();
		}

	}

}
