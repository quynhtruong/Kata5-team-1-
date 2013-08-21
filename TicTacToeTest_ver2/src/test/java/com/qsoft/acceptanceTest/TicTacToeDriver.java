package com.qsoft.acceptanceTest;

import com.objogate.wl.Prober;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.ComponentSelector;
import com.objogate.wl.swing.driver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;
import static java.lang.String.valueOf;
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

    public void hasLabelWithNameAndText(String name,String text)
    {
        new JLabelDriver(this, named(name)).hasText(equalTo(text));
    }

    public void hasButtonWithName(String name, String text)
    {
        new JButtonDriver(this,JButton.class,named(name)).hasText(equalTo(text));
    }

    public JButtonDriver button(String name)
    {
        return new JButtonDriver(this, JButton.class, named(name));
    }
    public void hasBoardWithNineButton()
    {
        for (int i = 0; i < 9; i++){
            new JButtonDriver(this, JButton.class, named(new Integer(i).toString())).hasText(equalTo(" "));
        }
    }

    public void hasHistoryTable(int id, String winner, String process) {
        JTableDriver table=new JTableDriver(this);
        table.hasRow(matching(withLabelText(valueOf(id)), withLabelText(winner),
                withLabelText(process)));
    }
}
