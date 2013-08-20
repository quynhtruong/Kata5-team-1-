package com.qsoft.tictactoe.dao.impl;

import com.qsoft.tictactoe.dao.TicTacToeDao;
import com.qsoft.tictactoe.entity.GameEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class TicTacToeDaoImpl implements TicTacToeDao
{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(GameEntity gameEntity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<GameEntity> getAllGameFinished()
    {
        Query query=entityManager.createQuery("select g from GameEntity g");
        return query.getResultList();
    }
}
