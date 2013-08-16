package com.qsoft.TicTacToe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: quynhtq
 * Date: 8/7/13
 * Time: 8:05 AM
 */
public class TicTacToeTest
{
    private ApplicationRunner applicationRunner = new ApplicationRunner();

    @Before
    public void startTheTopLevelUI()
    {
        applicationRunner.startTheTopLevelUI();
    }

    private void doSomethingAndNoOneWin()
    {
        applicationRunner.clickToPosition("1-2");
        applicationRunner.hasXAtThePosition("1-2");
        applicationRunner.clickToPosition("2-2");
        applicationRunner.hasOAtThePosition("2-2");
        applicationRunner.clickToPosition("1-3");
        applicationRunner.hasXAtThePosition("1-3");
        applicationRunner.clickToPosition("2-3");
        applicationRunner.hasOAtThePosition("2-3");
    }
    private void playAllMatch()
    {
        applicationRunner.clickToPosition("1-2");
        applicationRunner.hasXAtThePosition("1-2");
        applicationRunner.clickToPosition("1-1");
        applicationRunner.hasOAtThePosition("1-1");
        applicationRunner.clickToPosition("2-1");
        applicationRunner.hasXAtThePosition("2-1");
        applicationRunner.clickToPosition("1-3");
        applicationRunner.hasOAtThePosition("1-3");
        applicationRunner.clickToPosition("2-3");
        applicationRunner.hasXAtThePosition("2-3");
        applicationRunner.clickToPosition("2-2");
        applicationRunner.hasOAtThePosition("2-2");
        applicationRunner.clickToPosition("3-1");
        applicationRunner.hasXAtThePosition("3-1");
        applicationRunner.clickToPosition("3-2");
        applicationRunner.hasOAtThePosition("3-2");
        applicationRunner.clickToPosition("3-3");
        applicationRunner.hasXAtThePosition("3-3");
    }
    private void playSomeThingAndTheWinnerIsX()
    {
        applicationRunner.clickToPosition("1-1");
        applicationRunner.clickToPosition("1-2");
        applicationRunner.clickToPosition("2-2");
        applicationRunner.clickToPosition("3-1");
        applicationRunner.clickToPosition("3-3");
    }

    private void playSomeThingAndTheWinnerIsO()
    {
        applicationRunner.clickToPosition("1-1");
        applicationRunner.clickToPosition("1-2");
        applicationRunner.clickToPosition("1-3");
        applicationRunner.clickToPosition("2-2");
        applicationRunner.clickToPosition("2-3");
        applicationRunner.clickToPosition("3-2");
    }
    @Test
    public void testJustStartAndStopGame()
    {
        applicationRunner.startGame();
        applicationRunner.stopGame();
        applicationRunner.showsThatGameEndedWithNoWinner();
    }
    @Test
    public void testStartDoSomeThingAndStop()
    {
        applicationRunner.startGame();
        doSomethingAndNoOneWin();
        applicationRunner.stopGame();
        applicationRunner.showsThatGameEndedWithNoWinner();
    }
    @Test
    public void testPlayAllMatch()
    {
        applicationRunner.startGame();
        playAllMatch();

        applicationRunner.showsThatGameEndedWithNoWinner();
    }
    @Test
    public void testDoSomeThingAndTheWinnerIsX()
    {
        applicationRunner.startGame();
        playSomeThingAndTheWinnerIsX();
        applicationRunner.hasLabelInUIWithNameGameStopped();
        applicationRunner.hasLabelInUIWithNameOneWin("The winner is X");
    }
    @Test
    public void testDoSomeThingAndTheWinnerIsO()
    {
        applicationRunner.startGame();
        playSomeThingAndTheWinnerIsO();
        applicationRunner.hasLabelInUIWithNameGameStopped();
        applicationRunner.hasLabelInUIWithNameOneWin("The winner is O");
    }
    @Test
    public void testResetUIAfterClickingStartButton()
    {
        applicationRunner.startGame();
        doSomethingAndNoOneWin();
        applicationRunner.stopGame();
        applicationRunner.startGame();
        applicationRunner.showsAllButtonWithEmptyText();
        applicationRunner.hasLabelInUIWithNameOneWin("");
    }
    @Test
    public void testShowHistory()
    {
        applicationRunner.startGame();
        playSomeThingAndTheWinnerIsX();
        applicationRunner.showHistory();
        applicationRunner.hasHistoryTableInUI();
    }
    @After
    public void endGame()
    {
        applicationRunner.endGameAndReleaseMemory();
    }

}


