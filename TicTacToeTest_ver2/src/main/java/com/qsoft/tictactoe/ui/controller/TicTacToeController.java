package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.entity.GameEntity;
import com.qsoft.tictactoe.service.TicTacToeService;
import com.qsoft.tictactoe.ui.MainGUI;
import com.qsoft.tictactoe.ui.controller.ActionEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/16/13
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TicTacToeController implements ActionEventListener
{
    @Autowired
    private MainGUI mainGUI;

    @Autowired
    private TicTacToeService ticTacToeService;

    private int numOfStep = 0;
    private String steps[] = new String[9];
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Object source = actionEvent.getSource();
        if (source.equals(mainGUI.getBtStart()))
        {
            mainGUI.getLbGameStatus().setText("Game started");
        }
        else if (source.equals(mainGUI.getBtStop()))
        {

            mainGUI.getLbGameStatus().setText("Game stopped");
            showResult(calculateResult(steps));
        }
        else if(source.equals(mainGUI.getBtHistory())) {
            List<GameEntity> gameEntityList=ticTacToeService.getAllGameFinished();
            mainGUI.createHistoryTable(gameEntityList);
        }
        else
        {
            for (JButton button : mainGUI.getButtonList())
            {
                if (source.equals(button))
                {
                    if (button.getText().equals(" "))
                    {
                        numOfStep++;
                        if (numOfStep % 2 == 0)
                        {
                            button.setText("O");
                        }
                        else
                        {
                            button.setText("X");
                        }
                        steps[Integer.parseInt(button.getName())] = button.getText();
                        String tempResult = calculateResult(steps);
                        if (numOfStep == 9)
                        {
                            showResult(tempResult);
                        }
                        else if (tempResult != "")
                        {
                            showResult(tempResult);
                        }
                    }

                }
            }
        }

    }

    private void showResult(String result)
    {
        if (result.equals(""))
        {
            mainGUI.getLbGameResult().setText("No one wins");
        }
        else
        {
            mainGUI.getLbGameResult().setText("The winner is " + result);

            //save win game to Database

            ticTacToeService.save(new GameEntity("X","0,1,4,7,8,"));


        }
    }

    public String calculateResult(String steps[])
    {
        for (int i = 0; i < 9; i++)
        {
            if (steps[i] != null)
            {
                //case 1
                if (i == 4 && steps[i].equals(steps[i + 4]) && (steps[i]).equals(steps[i - 4]))
                {
                    if (!steps[i].equals(" "))
                    {
                        return steps[i];
                    }
                }
                //case 2
                if (i > 2 && i < 6 && steps[i].equals(steps[i + 3]) && (steps[i]).equals(steps[i - 3]))
                {
                    if (!steps[i].equals(" "))
                    {
                        return steps[i];
                    }
                }
                //case 3
                if (i == 4 && steps[i].equals(steps[i + 2]) && steps[i].equals(steps[i - 2]))
                {
                    if (!steps[i].equals(" "))
                    {
                        return steps[i];
                    }
                }
                //case 4
                if ((i % 3 == 1) && (steps[i].equals(steps[i + 1])) && (steps[i].equals(steps[i - 1])))
                {
                    if (!steps[i].equals(" "))
                    {
                        return steps[i];
                    }
                }
            }
        }
        return "";
    }

    @Override
    public void initActionAndShowUI()
    {
        mainGUI.showUI();
        mainGUI.addListener(this);
    }
}
