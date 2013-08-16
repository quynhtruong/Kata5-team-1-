package com.qsoft.acceptanceTest;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationRunner
{
    private TicTacToeDriver ticTacToeDriver = new TicTacToeDriver(1000);
    public void showMainUI()
    {
            //To change body of created methods use File | Settings | File Templates.
    }

    public void hasLabelWithName(String gameStatus)
    {
        ticTacToeDriver.hasLabelWithName(gameStatus);
    }

    public void hasButtonWithName(String name)
    {
        ticTacToeDriver.hasButtonWithName(name);
    }

    public void hasBoardWithNineButton()
    {
        ticTacToeDriver.hasBoardWithNineButton();
    }
}
