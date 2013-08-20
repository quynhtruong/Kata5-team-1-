package com.qsoft.tictactoe.service;

import com.qsoft.tictactoe.dao.TicTacToeDao;
import com.qsoft.tictactoe.entity.GameEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TicTacToeService
{
    public void save(GameEntity gameEntity);

    public List<GameEntity> getAllGameFinished();

    public void setTicTacToeDao(TicTacToeDao mockTicTacToeDao);
}
