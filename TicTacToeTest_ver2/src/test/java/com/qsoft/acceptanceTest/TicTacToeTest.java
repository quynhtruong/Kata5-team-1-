package com.qsoft.acceptanceTest;

import org.junit.After;
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

    private void playAllMatch() {
        applicationRunner.move("0");
        applicationRunner.move("1");
        applicationRunner.move("2");
        applicationRunner.move("5");
        applicationRunner.move("3");
        applicationRunner.move("6");
        applicationRunner.move("4");
        applicationRunner.move("8");
        applicationRunner.move("7");
    }
    private void playSomethingAndWinnerIsX() {
        applicationRunner.move("0");
        applicationRunner.move("1");
        applicationRunner.move("4");
        applicationRunner.move("7");
        applicationRunner.move("8");
    }
    private void playSomethingAndTheWinnerIsO() {
        applicationRunner.move("1");
        applicationRunner.move("2");
        applicationRunner.move("3");
        applicationRunner.move("4");
        applicationRunner.move("5");
        applicationRunner.move("6");
    }
    @Test
    public void testTheOriginalUI()
    {
        applicationRunner.hasLabelWithNameAndText("gameStatus", "");
        applicationRunner.hasLabelWithNameAndText("gameResult", "");
        applicationRunner.hasButtonWithNameAndText("btStart", "Start");
        applicationRunner.hasButtonWithNameAndText("btStop", "Stop");
        applicationRunner.hasButtonWithNameAndText("btHistory","History");
        applicationRunner.hasBoardWithNineButton();
    }

    @Test
    public void testStartStopGame()
    {
        applicationRunner.startGame();
        applicationRunner.hasLabelWithNameAndText("gameStatus", "Game started");
        applicationRunner.stopGame();
        applicationRunner.hasLabelWithNameAndText("gameStatus", "Game stopped");
        applicationRunner.hasLabelWithNameAndText("gameResult", "No one wins");
    }

    @Test
    public void testDoSomeThingThenStop()
    {
        applicationRunner.startGame();
        applicationRunner.move("1");
        applicationRunner.move("3");
        applicationRunner.move("6");
        applicationRunner.move("2");
        applicationRunner.stopGame();
        applicationRunner.hasButtonWithNameAndText("1", "X");
        applicationRunner.hasButtonWithNameAndText("3", "O");
        applicationRunner.hasButtonWithNameAndText("6", "X");
        applicationRunner.hasButtonWithNameAndText("2", "O");
        applicationRunner.hasLabelWithNameAndText("gameResult", "No one wins");

    }
    @Test
    public void testPlayAllMatchAndNoOneWin(){
        applicationRunner.startGame();
        playAllMatch();
        applicationRunner.hasLabelWithNameAndText("gameResult","No one wins");
    }

    @Test
    public void testPlaySomethingAndTheWinnerIsX(){
        applicationRunner.startGame();
        playSomethingAndWinnerIsX();
        applicationRunner.hasLabelWithNameAndText("gameResult","The winner is X");
    }

    @Test
    public void testPlaySomethingAndTheWinnerIsO(){
        applicationRunner.startGame();
        playSomethingAndTheWinnerIsO();
        applicationRunner.hasLabelWithNameAndText("gameResult","The winner is O");
    }

    @Test
    public void testShowHistory(){
        applicationRunner.startGame();
        playSomethingAndWinnerIsX();
        applicationRunner.showHistory();
        applicationRunner.hasHistoryTableInUI();
    }


    @After
    public void releaseMemory()
    {
        applicationRunner.releaseMemory();
    }
}
