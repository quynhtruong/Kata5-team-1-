package com.qsoft.tictactoe;

import com.qsoft.tictactoe.ui.controller.TicTacToeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:57 AM
 * To change this template use File | Settings | File Templates.
 */

public class TicTacToeMain
{
    public TicTacToeMain()
    {
    }

    public void showMainUI()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-contextTest.xml");
        TicTacToeController ticTacToeController = applicationContext.getBean(TicTacToeController.class);
        ticTacToeController.initActionAndShowUI();
    }

    public static void main(String[] args)
    {
        new TicTacToeMain();
    }

}
