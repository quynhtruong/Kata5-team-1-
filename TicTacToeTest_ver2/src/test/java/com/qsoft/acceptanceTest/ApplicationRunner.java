package com.qsoft.acceptanceTest;

import com.qsoft.tictactoe.TicTacToeMain;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationRunner
{
    private TicTacToeMain ticTacToeMain = new TicTacToeMain();
    private TicTacToeDriver ticTacToeDriver = new TicTacToeDriver(1000);
    public void showMainUI()
    {
            ticTacToeMain.showMainUI();
    }

    public void hasLabelWithName(String gameStatus)
    {
        ticTacToeDriver.hasLabelWithName(gameStatus);
    }

    public void hasButtonWithName(String name, String text)
    {
        ticTacToeDriver.hasButtonWithName(name, text);
    }

    public void hasBoardWithNineButton()
    {
        ticTacToeDriver.hasBoardWithNineButton();
    }
}
