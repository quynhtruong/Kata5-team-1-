package com.qsoft.tictactoe.service.impl;

import com.qsoft.tictactoe.dao.TicTacToeDao;
import com.qsoft.tictactoe.entity.GameEntity;
import com.qsoft.tictactoe.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TicTacToeServiceImpl implements TicTacToeService
{

    @Override
    public void save(GameEntity gameEntity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<GameEntity> getAllGameFinished()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTicTacToeDao(TicTacToeDao mockTicTacToeDao)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
