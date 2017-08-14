package com.testingdocs.examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotExample {
	
	static Robot robot;
    
    public static void main(String[] args) throws IOException {
        
        try {
        	robot = new Robot();
            Process process = Runtime.getRuntime().exec("notepad.exe");
            robot.delay(10000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_D);
            typeCombinationKeys(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
            
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    private static void typeCombinationKeys(int key1, int key2)
    {
        try
        {
            robot.keyPress(key1);
            robot.keyPress(key2);
            robot.keyRelease(key2);
            robot.keyRelease(key1);
        }
        catch(Exception e)
        {
            System.out.println("Exception : Invalid keys");
        }
}
}