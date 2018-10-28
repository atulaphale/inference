package com.cvs.inference.representation;

import io.swagger.annotations.ApiModelProperty;

public class Survey {

    @ApiModelProperty(notes = "The question in the survey")
    private String question;

    @ApiModelProperty(notes = "The question applicability in the survey")
    private String applicable;

    @ApiModelProperty(notes = "The response associated with the question in the survey")
    private String response;

    @ApiModelProperty(notes = "The comments associated with the question in the survey")
    private String comments;

    public Survey(String question, String applicable, String response, String comments) {
        this.question = question;
        this.applicable = applicable;
        this.response = response;
        this.comments = comments;
    }

    public String getQuestion() {
        return question;
    }

    public String getApplicable() {
        return applicable;
    }

    public String getResponse() {
        return response;
    }

    public String getComments() {
        return comments;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setApplicable(String applicable) {
        this.applicable = applicable;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
