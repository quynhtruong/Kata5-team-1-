package com.qsoft.tictactoe.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 8/20/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="game")
@SequenceGenerator(name = "game_id_seq",sequenceName = "game_id_seq",allocationSize = 1,initialValue = 1)
public class GameEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "game_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name="winner")
    private String winner;

    @Column(name="process")
    private String process;


    //constructor

    public GameEntity()
    {
    }

    public GameEntity(String winner, String process)
    {
        this.winner = winner;
        this.process = process;
    }

    //getter & setter

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getWinner()
    {
        return winner;
    }

    public void setWinner(String winner)
    {
        this.winner = winner;
    }

    public String getProcess()
    {
        return process;
    }

    public void setProcess(String process)
    {
        this.process = process;
    }
}
