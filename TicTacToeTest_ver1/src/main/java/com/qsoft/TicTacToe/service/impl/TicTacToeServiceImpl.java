package com.qsoft.TicTacToe.service.impl;

import com.qsoft.TicTacToe.persistance.dao.TicTacToeDao;
import com.qsoft.TicTacToe.persistance.entity.GameEntity;
import com.qsoft.TicTacToe.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 9:24 AM
 */
@Component
@Transactional
public class TicTacToeServiceImpl implements TicTacToeService
{
    @Autowired
    private TicTacToeDao ticTacToeDao;
    @Override
    public void save(GameEntity gameEntity)
    {
        ticTacToeDao.save(gameEntity);
    }

    @Override
    public void setTicTacToeDao(TicTacToeDao ticTacToeDao)
    {
           this.ticTacToeDao=ticTacToeDao;
    }

    @Override
    public List<GameEntity> getAllGameFinished()
    {
        return ticTacToeDao.getAllGameEntity();
    }
}
