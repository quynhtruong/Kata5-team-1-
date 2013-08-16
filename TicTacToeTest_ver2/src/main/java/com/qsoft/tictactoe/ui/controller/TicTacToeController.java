package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.ui.MainGUI;
import com.qsoft.tictactoe.ui.controller.ActionEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Object source = actionEvent.getSource();
        if (source.equals(mainGUI.getBtStart()))
        {
            mainGUI.getLbGameStatus().setText("Game started");
        }
        else
            if (source.equals(mainGUI.getBtStop()))
            {
                mainGUI.getLbGameStatus().setText("Game stopped");
                mainGUI.getLbGameResult().setText("No one wins");
            }
    }

    @Override
    public void initActionAndShowUI()
    {
        mainGUI.showUI();
        mainGUI.addListener(this);
    }
}
