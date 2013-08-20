package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.ui.MainGUI;
import com.qsoft.tictactoe.ui.controller.ActionEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
    private int numOfStep = 0;

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
           showResult();

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
                        if (numOfStep == 5){
                            mainGUI.getLbGameResult().setText("The winner is X");
                        }
                        else
                        if(numOfStep==9){
                            showResult();
                        }

                    }

                }
            }
        }

    }

    private void showResult()
    {
        if(calculateResult().equals("")){
            mainGUI.getLbGameResult().setText("No one wins");
        }
    }

    public String calculateResult()
    {
        return "";
    }

    @Override
    public void initActionAndShowUI()
    {
        mainGUI.showUI();
        mainGUI.addListener(this);
    }
}
