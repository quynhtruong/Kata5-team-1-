package com.qsoft.unitTest;

import com.qsoft.tictactoe.dao.TicTacToeDao;
import com.qsoft.tictactoe.entity.GameEntity;
import com.qsoft.tictactoe.service.TicTacToeService;
import com.qsoft.tictactoe.service.impl.TicTacToeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeServiceTest
{
    @Mock
    private TicTacToeDao mockTicTacToeDao=mock(TicTacToeDao.class);

    private TicTacToeService ticTacToeService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
      ticTacToeService=new TicTacToeServiceImpl();
      ticTacToeService.setTicTacToeDao(mockTicTacToeDao );
    }

    @Test
    public void testSaveGame(){
        ticTacToeService.save(new GameEntity());
        ArgumentCaptor<GameEntity> argumentCaptor= ArgumentCaptor.forClass(GameEntity.class);
        verify(mockTicTacToeDao).save(argumentCaptor.capture());
    }
    @Test
    public void testGetAllGameFinished(){
         ticTacToeService.getAllGameFinished();
        ArgumentCaptor<GameEntity> argumentCaptor=ArgumentCaptor.forClass(GameEntity.class);
        verify(mockTicTacToeDao).getAllGameFinished();
    }
}
