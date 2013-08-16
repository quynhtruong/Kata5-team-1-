package com.qsoft.UnitTest;

import com.qsoft.TicTacToe.persistance.entity.*;
import com.qsoft.TicTacToe.service.TicTacToeService;
import com.qsoft.TicTacToe.ui.controller.TicTacToeController;
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
 * Time: 9:09 AM
 */
public class TicTacToeControllerTest
{
    @Mock
    public TicTacToeService mockTicTacToeService = mock(TicTacToeService.class);
    public TicTacToeController ticTacToeController = new TicTacToeController();

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        ticTacToeController.setTicTacToeService(mockTicTacToeService);
    }

    @Test
    public void testSaveGame()
    {
        ticTacToeController.saveResult();
        ArgumentCaptor<GameEntity> argumentCaptor = ArgumentCaptor.forClass(GameEntity.class);
        verify(mockTicTacToeService).save(argumentCaptor.capture());
    }

}
