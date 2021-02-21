package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * The type Game.
 */
@Entity(name = "Game")
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "game_id")
    private int gameId;

    @ManyToOne
    private User user;

    @Column(name = "user_score")
    private int userScore;

    @Column(name = "cpu_score")
    private int cpuScore;

    @Column(name = "time_played")
    private LocalDate timePlayed;

    /**
     * Instantiates a new Game.
     */
    public Game() {}

    /**
     * Instantiates a new Game.
     */
    public Game(User user, int userScore, int cpuScore, LocalDate timePlayed) {
        this.user = user;
        this.userScore = userScore;
        this.cpuScore = cpuScore;
        this.timePlayed = timePlayed;
    }

    /**
     * Gets time played.
     *
     * @return the time played
     */
    public LocalDate getTimePlayed() {
        return timePlayed;
    }


    /**
     * Gets game id.
     *
     * @return the game id
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Sets game id.
     *
     * @param gameId the game id
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets user score.
     *
     * @return the user score
     */
    public int getUserScore() {
        return userScore;
    }

    /**
     * Sets user score.
     *
     * @param userScore the user score
     */
    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    /**
     * Gets cpu score.
     *
     * @return the cpu score
     */
    public int getCpuScore() {
        return cpuScore;
    }

    /**
     * Sets cpu score.
     *
     * @param cpuScore the cpu score
     */
    public void setCpuScore(int cpuScore) {
        this.cpuScore = cpuScore;
    }

    /**
     * Sets time played.
     *
     * @param timePlayed the time played
     */
    public void setTimePlayed(LocalDate timePlayed) {
        this.timePlayed = timePlayed;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", user=" + user +
                ", userScore=" + userScore +
                ", cpuScore=" + cpuScore +
                ", timePlayed=" + timePlayed +
                '}';
    }
}
