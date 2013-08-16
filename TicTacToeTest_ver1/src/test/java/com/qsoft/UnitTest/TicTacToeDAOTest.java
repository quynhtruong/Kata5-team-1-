package com.qsoft.UnitTest;

import com.qsoft.TicTacToe.persistance.dao.TicTacToeDao;
import com.qsoft.TicTacToe.persistance.entity.GameEntity;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/15/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config-Test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TicTacToeDAOTest
{
    @Autowired
    public TicTacToeDao ticTacToeDao;
    @Autowired
    private DataSource dataSourceTest;

    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(System.class.getResource("/dataSet.xml"));
        databaseTester = new DataSourceDatabaseTester(dataSourceTest);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        databaseTester.onTearDown();
    }

    @Test
    public void testGetAllGameEntity()
    {
        List<GameEntity> gameEntityList = ticTacToeDao.getAllGameEntity();
        assertEquals(2L, gameEntityList.size());
        assertEquals("X", gameEntityList.get(0).getWinner());
        assertEquals("1-2,", gameEntityList.get(0).getProcess());
    }

    @Test
    public void testSaveGameEntity()
    {
        GameEntity gameEntity = new GameEntity("x", "3-4,");
        ticTacToeDao.save(gameEntity);
        List<GameEntity> gameEntityList = ticTacToeDao.getAllGameEntity();
        assertTrue(gameEntityList.contains(gameEntity));
    }
}
