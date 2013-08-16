package com.qsoft.TicTacToe.persistance.dao.impl;

import com.qsoft.TicTacToe.persistance.dao.*;
import com.qsoft.TicTacToe.persistance.entity.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 9:59 AM
 */
@Transactional
public class TicTacToeDaoImpl implements TicTacToeDao
{
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void save(GameEntity gameEntity)
    {
        if (gameEntity.getId() == null)
            entityManager.persist(gameEntity);
        else
            entityManager.merge(gameEntity);
    }

    @Override
    public List<GameEntity> getAllGameEntity()
    {
        Query query = entityManager.createQuery("select o from GameEntity o",GameEntity.class);
        List<GameEntity> result = query.getResultList();
        return result;
    }
}
