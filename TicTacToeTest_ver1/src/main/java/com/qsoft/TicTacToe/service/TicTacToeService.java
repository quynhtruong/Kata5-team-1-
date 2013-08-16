package com.qsoft.TicTacToe.service;

import com.qsoft.TicTacToe.persistance.dao.*;
import com.qsoft.TicTacToe.persistance.entity.*;

import java.util.List;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 8:47 AM
 */
public interface TicTacToeService
{
    public void save(GameEntity gameEntity);

    public void setTicTacToeDao(TicTacToeDao mockTicTacToeDao);

    public List<GameEntity> getAllGameFinished();

}
