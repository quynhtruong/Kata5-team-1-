package com.qsoft.tictactoe.dao;

import com.qsoft.tictactoe.entity.GameEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TicTacToeDao
{
    public void save(GameEntity gameEntity);
    public List<GameEntity> getAllGameFinished();
}
