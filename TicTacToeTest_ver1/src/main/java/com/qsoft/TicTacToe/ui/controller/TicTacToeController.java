package com.qsoft.TicTacToe.ui.controller;

import com.qsoft.TicTacToe.persistance.entity.GameEntity;
import com.qsoft.TicTacToe.service.TicTacToeService;
import com.qsoft.TicTacToe.ui.MainGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 9:00 AM
 */
@Component
public class TicTacToeController implements ActionListener
{
    @Autowired
    private MainGUI mainWindow;
    private Integer numberOfStep = 0;
    private Integer winner = 0;
    private String finalResult;

    @Autowired
    public TicTacToeService ticTacToeService;

    public void addListener()
    {
        mainWindow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton btCommand = (JButton) e.getSource();
        if (btCommand.equals(mainWindow.getStartButton()))
        {
            resetUIAndResult();
            mainWindow.setLbGameStatus(mainWindow.STATUS_GAME_STARTED);
        }
        else if (btCommand.equals(mainWindow.getStopButton()))
        {
            doFinish();
        }
        else if (btCommand.equals(mainWindow.getBtShowHistory()))
        {
            List<GameEntity> listGameFinished = ticTacToeService.getAllGameFinished();
            mainWindow.createHistoryTable(listGameFinished);
        }
        else
        {
            for (JButton jButton : mainWindow.getListButton())
            {
                if (jButton.getName().equals(btCommand.getName()))
                {
                    if (!("X".equals(jButton.getText())) && !("O".equals(jButton.getText())))
                    {
                        if ((numberOfStep % 2) == 0)
                        {
                            jButton.setText("X");
                        }
                        else
                        {
                            jButton.setText("O");
                        }
                        numberOfStep++;
                        finalResult += jButton.getName() + ",";
                        calculateResult();
                    }
                }
            }
        }
    }

    public void resetUIAndResult()
    {
        for (JButton jButton : mainWindow.getListButton())
        {
            jButton.setText(" ");
        }
        mainWindow.getLbGameResult().setText("");
        numberOfStep = 0;
        winner = 0;
        finalResult = new String("");
    }

    public void doFinish()
    {
        showResult();
        if (winner == 1 || winner == -1)
        {
            saveResult();
        }
    }

    public void saveResult()
    {
        GameEntity gameEntity = new GameEntity();
        if (winner == 1)
        {
            gameEntity.setWinner("X");
        }
        else if (winner == -1)
        {
            gameEntity.setWinner("O");
        }
        else
        {
            gameEntity.setWinner("");
        }
        gameEntity.setProcess(finalResult);
        ticTacToeService.save(gameEntity);
    }

    public void showResult()
    {
        mainWindow.setLbGameStatus(mainWindow.STATUS_GAME_STOPPED);
        if (winner == 1)
        {
            mainWindow.getLbGameResult().setText(mainWindow.THE_WINNER_IS + "X");
        }
        else if (winner == -1)
        {
            mainWindow.getLbGameResult().setText(mainWindow.THE_WINNER_IS + "O");
        }
        else
        {
            mainWindow.getLbGameResult().setText(mainWindow.NO_WINNER);
        }
    }

    public void checkEquals(String text1, String text2, String text3)
    {
        if (text1.equals(text2) && text1.equals(text3))
        {
            if (text1.equals("X"))
            {
                winner = 1;
            }
            else if (text1.equals("O"))
            {
                winner = -1;
            }
        }
    }

    public void calculateResult()
    {

        List<JButton> jButtonList = mainWindow.getListButton();
        String text0 = jButtonList.get(0).getText();
        String text1 = jButtonList.get(1).getText();
        String text2 = jButtonList.get(2).getText();
        String text3 = jButtonList.get(3).getText();
        String text4 = jButtonList.get(4).getText();
        String text5 = jButtonList.get(5).getText();
        String text6 = jButtonList.get(6).getText();
        String text7 = jButtonList.get(7).getText();
        String text8 = jButtonList.get(8).getText();
        if (winner == 0)
        {
            checkEquals(text0, text1, text2);
        }
        if (winner == 0)
        {
            checkEquals(text3, text4, text5);
        }
        if (winner == 0)
        {
            checkEquals(text6, text7, text8);
        }
        if (winner == 0)
        {
            checkEquals(text0, text3, text6);
        }
        if (winner == 0)
        {
            checkEquals(text1, text4, text7);
        }
        if (winner == 0)
        {
            checkEquals(text2, text5, text8);
        }
        if (winner == 0)
        {
            checkEquals(text0, text4, text8);
        }
        if (winner == 0)
        {
            checkEquals(text2, text4, text6);
        }
        if (winner != 0)
        {
            doFinish();
        }
        if (numberOfStep == 9)
        {
            doFinish();
        }
    }

    public void setTicTacToeService(TicTacToeService ticTacToeService)
    {
        this.ticTacToeService = ticTacToeService;
    }

    public TicTacToeService getTicTacToeService()
    {
        return ticTacToeService;
    }

    public void showMainView()
    {
        mainWindow.showMainView();
    }
}
