package com.qsoft.UnitTest;

import com.qsoft.TicTacToe.persistance.dao.*;
import com.qsoft.TicTacToe.persistance.entity.*;
import com.qsoft.TicTacToe.service.TicTacToeService;
import com.qsoft.TicTacToe.service.impl.TicTacToeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 9:33 AM
 */
public class TicTacToeServiceTest
{
    @Mock
    public TicTacToeDao mockTicTacToeDao = mock(TicTacToeDao.class);

    public TicTacToeService ticTacToeService = new TicTacToeServiceImpl();

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        ticTacToeService.setTicTacToeDao(mockTicTacToeDao);
    }

    @Test
    public void testSaveDao()
    {
        ticTacToeService.save(new GameEntity());
        ArgumentCaptor<GameEntity> argumentCaptor = ArgumentCaptor.forClass(GameEntity.class);
        verify(mockTicTacToeDao).save(argumentCaptor.capture());
    }
}
