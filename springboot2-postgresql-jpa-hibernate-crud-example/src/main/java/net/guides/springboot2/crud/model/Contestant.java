package net.guides.springboot2.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "contestant")
public class Contestant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int challengecount;
    private int votecount;

    Contestant() {

    }

    Contestant(String name, int challengecount) {
        this.challengecount = challengecount;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }
    public void setChallengecount(int challengecount) {
        this.challengecount = challengecount;
    }

    public int getChallengecount() {
        return challengecount;
    }

    public int getVotecount() {
        return votecount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
