package com.qsoft.acceptanceTest;

import com.objogate.wl.Prober;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.ComponentSelector;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(int timeOut)
    {
        super(new GesturePerformer(), JFrameDriver.topLevelFrame(named("TicTacToeGame"),
                showingOnScreen()), new AWTEventQueueProber(timeOut, 500));
    }

    public void hasLabelWithName(String name)
    {
        new JLabelDriver(this, named(name)).hasText(equalTo(""));
    }

    public void hasButtonWithName(String name, String text)
    {
        new JButtonDriver(this,JButton.class,named(name)).hasText(equalTo(text));
    }

    public void hasBoardWithNineButton()
    {
        for (int i = 0; i < 9; i++){
            new JButtonDriver(this, JButton.class, named(new Integer(i).toString())).hasText(equalTo(" "));
        }
    }
}
