package com.qsoft.TicTacToe.persistance.dao;

import com.qsoft.TicTacToe.persistance.entity.*;

import java.util.List;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 9:32 AM
 */
public interface TicTacToeDao
{
    public void save(GameEntity gameEntity);

    public List<GameEntity> getAllGameEntity();
}
