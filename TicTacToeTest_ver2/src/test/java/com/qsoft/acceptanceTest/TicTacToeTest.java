package com.qsoft.acceptanceTest;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeTest
{
    private ApplicationRunner applicationRunner = new ApplicationRunner();

    @Before
    public void setUp()
    {
        applicationRunner.showMainUI();
    }

    @Test
    public void testTheOriginalUI()
    {
        applicationRunner.hasLabelWithName("gameStatus");
        applicationRunner.hasLabelWithName("gameResult");
        applicationRunner.hasButtonWithName("btStart","Start");
        applicationRunner.hasButtonWithName("btStop","Stop");
        applicationRunner.hasBoardWithNineButton();
    }

}
