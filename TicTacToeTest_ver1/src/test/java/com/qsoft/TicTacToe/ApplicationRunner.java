package com.qsoft.TicTacToe;

import com.qsoft.TicTacToe.ui.MainGUI;

/**
 * User: quynhtq
 * Date: 8/7/13
 * Time: 8:25 AM
 */
public class ApplicationRunner
{
    private TicTacToeUIDriver ticTacToeUIDriver;
    private TicTacToeMain ticTacToeMain;

    public void startGame()
    {
        clickStartButton();
        hasLabelWithNameGameStarted();
    }

    public void stopGame()
    {
        clickStopButton();
        hasLabelInUIWithNameGameStopped();
        showsThatGameEndedWithNoWinner();
    }

    private void clickStartButton()
    {
        ticTacToeUIDriver.button("btnStart").click();
    }

    public void clickStopButton()
    {
        ticTacToeUIDriver.button("btnStop").click();
    }

    public void hasLabelWithNameGameStarted()
    {
        ticTacToeUIDriver.hasTitle(MainGUI.MAIN_WINDOW_NAME);
        ticTacToeUIDriver.showsTicTacToeLabelGameStatus(MainGUI.STATUS_GAME_STARTED);
    }

    public void hasLabelInUIWithNameGameStopped()
    {
        ticTacToeUIDriver.showsTicTacToeLabelGameStatus(MainGUI.STATUS_GAME_STOPPED);
    }

    public void startTheTopLevelUI()
    {
        ticTacToeMain = new TicTacToeMain();
        ticTacToeUIDriver = new TicTacToeUIDriver(1000);
    }

    public void hasOAtThePosition(String position)
    {
        ticTacToeUIDriver.hasOAtThePosition(position);
    }

    public void hasXAtThePosition(String position)
    {
        ticTacToeUIDriver.hasXAtThePosition(position);
    }


    public void clickToPosition(String position)
    {
        ticTacToeUIDriver.button(position).click();
    }


    public void endGameAndReleaseMemory()
    {
        ticTacToeUIDriver.dispose();
    }

    public void showsThatGameEndedWithNoWinner()
    {
        ticTacToeUIDriver.showsGameResultOfMatch(MainGUI.NO_WINNER);
    }

    public void hasLabelInUIWithNameOneWin(String winner)
    {
        ticTacToeUIDriver.hasLabelWithNameOneWinner(winner);
    }

    public void showsAllButtonWithEmptyText()
    {
        for(int i=1;i<=3;i++)
            for(int j=1;j<=3;j++)
            {
                String name = i+"-"+j;
                ticTacToeUIDriver.hasButtonWithNameAndText(name," ");
            }
    }

    public void showHistory()
    {
        ticTacToeUIDriver.button("btShowHistory").click();
    }

    public void hasHistoryTableInUI()
    {
       ticTacToeUIDriver.hasHistoryTable(1,"X","1-1,1-2,2-2,3-1,3-3,");
    }


}

