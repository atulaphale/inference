package com.cvs.inference.representation;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="inference_table")
public class Inference {

    @Id
    @ApiModelProperty(notes = "The inference application ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(notes = "The user associated with the inference")
    @Column(name="user", length=100, nullable=false)
    private String user;

    @ApiModelProperty(notes = "The time when the inference was generated")
    @Column(name="time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp createdTime;

    @ApiModelProperty(notes = "The questions associated with the inference")
    @Column(name="list_questions", columnDefinition = "json", nullable=false)
    //@Convert(converter = SurveyDocumentConverter.class)
    private String listQuestions;

    @ApiModelProperty(notes = "The onprem score generated in the inference")
    @Column(name="onprem_score")
    private int onPremScore;

    @ApiModelProperty(notes = "The cloud score generated in the inference")
    @Column(name="cloud_score")
    private int cloudScore;

    public Inference() {};

    public Inference(String user, String listQuestions, int onPremScore, int cloudScore) {
        this.user = user;
        //this.createdTime = createdTime;
        this.listQuestions = listQuestions;
        this.onPremScore = onPremScore;
        this.cloudScore = cloudScore;
    }

    public Long getId() {

        return id;
    }

    public String getUser() {
        return user;
    }

    public Timestamp getTime() {
        return createdTime;
    }

    public String getListQuestions() {
        return listQuestions;
    }

    public int getOnPremScore() {
        return onPremScore;
    }

    public int getCloudScore() {
        return cloudScore;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setListQuestions(String listQuestions) {
        this.listQuestions = listQuestions;
    }

    public void setOnPremScore(int onPremScore) {
        this.onPremScore = onPremScore;
    }

    public void setCloudScore(int cloudScore) {
        this.cloudScore = cloudScore;
    }
}
