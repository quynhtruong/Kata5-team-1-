package com.qsoft.TicTacToe;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.TicTacToe.ui.MainGUI;

import javax.swing.*;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;
import static java.lang.String.valueOf;
import static org.hamcrest.Matchers.equalTo;


/**
 * User: quynhtq
 * Date: 8/7/13
 * Time: 8:27 AM
 */
public class TicTacToeUIDriver extends JFrameDriver
{
    public TicTacToeUIDriver(int timeoutMillis)
    {
        super(new GesturePerformer(), JFrameDriver.topLevelFrame(named(MainGUI.MAIN_WINDOW_NAME),
                showingOnScreen()), new AWTEventQueueProber(timeoutMillis, 500));
    }

    public void showsTicTacToeLabelGameStatus(String statusText)
    {
        new JLabelDriver(this, named(MainGUI.labelName)).hasText(equalTo(statusText));
    }

    public void hasOAtThePosition(String position)
    {
        new JButtonDriver(this,JButton.class,named(position)).hasText(equalTo("O"));
    }

    public void hasXAtThePosition(String position)
    {
        new JButtonDriver(this,JButton.class,named(position)).hasText(equalTo("X"));
    }

    public JButtonDriver button(String name)
    {
        return new JButtonDriver(this, JButton.class, named(name));
    }

    public void showsGameResultOfMatch(String status)
    {
        new JLabelDriver(this, named(MainGUI.lbResult)).hasText(equalTo(status));
    }

    public void hasLabelWithNameOneWinner(String winner)
    {
        new JLabelDriver(this, named(MainGUI.lbResult)).hasText(equalTo(winner));
    }

    public void hasButtonWithNameAndText(String name, String text)
    {
        new JButtonDriver(this,JButton.class,named(name)).hasText(equalTo(text));
    }

    public void hasHistoryTable(int id,String winner,String process)
    {
        JTableDriver table = new JTableDriver(this);
        table.hasRow(matching(withLabelText(valueOf(id)), withLabelText(winner),
                withLabelText(process)));
    }
}
