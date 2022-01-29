package com.epul.androidcinema.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "duration",
        "release_date",
        "budget",
        "revenue_amount",
        //"category",
        "director"
})
public class Movie implements java.io.Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("duration")
    private int duration;
    @JsonProperty("release_date")
    private Date release_date;
    @JsonProperty("budget")
    private int budget;
    @JsonProperty("revenue_amount")
    private int revenue_amount;
    //@JsonProperty("category")
    //private Category category;
    @JsonProperty("director")
    private Director director;

    public Movie(long id, String title, int duration, Date release_date, int budget, int revenue_amount, Director director) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.release_date = release_date;
        this.budget = budget;
        this.revenue_amount = revenue_amount;
        //this.category = category;
        this.director = director;
    }

    public Movie(String title, int duration, Date release_date, int budget, int revenue_amount, Director director) {
        this.title = title;
        this.duration = duration;
        this.release_date = release_date;
        this.budget = budget;
        this.revenue_amount = revenue_amount;
        //this.category = category;
        this.director = director;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty("release_date")
    public Date getRelease_date() {
        return release_date;
    }

    @JsonProperty("release_date")
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    @JsonProperty("budget")
    public int getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @JsonProperty("revenue_amount")
    public int getRevenue_amount() {
        return revenue_amount;
    }

    @JsonProperty("revenue_amount")
    public void setRevenue_amount(int revenue_amount) {
        this.revenue_amount = revenue_amount;
    }
/*
    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }
*/
    @JsonProperty("director")
    public Director getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(Director director) {
        this.director = director;
    }
}
