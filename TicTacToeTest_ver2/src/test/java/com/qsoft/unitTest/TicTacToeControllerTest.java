package com.qsoft.unitTest;

import com.qsoft.tictactoe.ui.controller.TicTacToeController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.scheduling.quartz.SimpleTriggerBean;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */

public class TicTacToeControllerTest
{
    private TicTacToeController ticTacToeController = new TicTacToeController();
    private String steps[];

    @Before
    public void setUp()
    {
        steps = new String[9];
    }

    @Test
    public void testCalculateResultWithTheWinnerIsX()
    {
        steps[0] = "X";
        steps[1] = "O";
        steps[4] = "X";
        steps[2] = "O";
        steps[8] = "X";
        assertEquals(ticTacToeController.calculateResult(steps), "X");
    }

    @Test
    public void testCalculateResultAndTheWinnerIsO()
    {
        steps[0] = "X";
        steps[1] = "O";
        steps[3] = "X";
        steps[4] = "O";
        steps[5] = "X";
        steps[7] = "O";
        assertEquals(ticTacToeController.calculateResult(steps), "O");
    }

    @Test
    public void testCalculateResultAndNotOneWin()
    {
        steps[0] = "X";
        steps[1] = "O";
        steps[3] = "X";
        steps[4] = "O";
        assertEquals(ticTacToeController.calculateResult(steps), "");
    }
}
