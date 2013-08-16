package com.qsoft.TicTacToe;

import com.qsoft.TicTacToe.ui.controller.TicTacToeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * User: quynhtq
 * Date: 8/7/13
 * Time: 8:50 AM
 */
public class TicTacToeMain
{
    public TicTacToeMain()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        TicTacToeController ticTacToeController = (TicTacToeController) applicationContext.getBean("ticTacToeController");
        ticTacToeController.showMainView();
        ticTacToeController.addListener();
    }

    public static void main(String[] args)
    {
        new TicTacToeMain();
    }
}
