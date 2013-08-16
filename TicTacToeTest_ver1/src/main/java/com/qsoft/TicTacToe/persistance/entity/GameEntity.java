package com.qsoft.TicTacToe.persistance.entity;

import javax.persistence.*;

/**
 * User: quynhtq
 * Date: 8/14/13
 * Time: 8:49 AM
 */
@Entity
@Table(name = "game")
@SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq", initialValue = 1, allocationSize = 1)
public class GameEntity
{
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "game_id_seq")
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "winner")
    private String winner;

    @Column(name = "process")
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

    //getter and setter

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
