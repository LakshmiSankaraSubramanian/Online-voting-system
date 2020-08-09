package net.guides.springboot2.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    private String name;
    @Column(name="vote")
    private int vote;
    @Column(name="emailid")
    private String emailid;

    public User() {

    }

    public User(String name, String emailid) {
        this.name = name;
        this.emailid = emailid;
    }

    public long getUserid() {
        return userid;
    }
    @Column(name = "userId",nullable = false)
    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name="name",nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "emailid",nullable = false)
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setVote(int vote){
        this.vote=vote;
    }
    public int getVote(){
        return vote;
    }

    @Override
    public String toString() {
        return "User [id=" + userid + ", name=" + name + ", emailId=" + emailid + ", vote=" + vote
                + "]";
    }


}
