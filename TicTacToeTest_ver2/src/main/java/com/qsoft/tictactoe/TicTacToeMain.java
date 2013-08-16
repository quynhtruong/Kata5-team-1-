package com.qsoft.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 8:57 AM
 * To change this template use File | Settings | File Templates.
 */

public class TicTacToeMain
{
    private MainGUI mainGUI;
    public TicTacToeMain()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        mainGUI = applicationContext.getBean(MainGUI.class);
    }

    public void showMainUI()
    {
        mainGUI.showUI();
    }

    public static void main(String[] args)
    {
        new TicTacToeMain();
    }

}
