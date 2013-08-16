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

    public void hasLabelWithNameAndText(String gameStatus,String text)
    {
        ticTacToeDriver.hasLabelWithNameAndText(gameStatus, text);
    }

    public void hasButtonWithNameAndText(String name, String text)
    {
        ticTacToeDriver.hasButtonWithName(name, text);
    }

    public void hasBoardWithNineButton()
    {
        ticTacToeDriver.hasBoardWithNineButton();
    }

    public void startGame()
    {
        ticTacToeDriver.button("btStart").click();

    }

    public void stopGame()
    {
        ticTacToeDriver.button("btStop").click();
    }

    public void releaseMemory()
    {
        ticTacToeDriver.dispose();
    }
}
