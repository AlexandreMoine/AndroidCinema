package com.epul.androidcinema.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id", "title", "description", "coverPath", "duration", "releaseDate", "director", "categories"
})
public class Movie implements java.io.Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("coverPath")
    private String coverPath;
    @JsonProperty("duration")
    private int duration;
    @JsonProperty("releaseDate")
    private Date releaseDate;
    @JsonProperty("director")
    private Director director;
    @JsonProperty("categories")
    private Set<Category> categories;

    public Movie(long id, String title, String description, String coverPath, int duration, Date releaseDate, Director director, Set<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverPath = coverPath;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.director = director;
        this.categories = categories;
    }

    public Movie(String title, String description, String coverPath, int duration, Date releaseDate, Director director, Set<Category> categories) {
        this.title = title;
        this.description = description;
        this.coverPath = coverPath;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.director = director;
        this.categories = categories;
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("coverPath")
    public String getCoverPath() {
        return coverPath;
    }
    @JsonProperty("coverPath")
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty("releaseDate")
    public Date getReleaseDate() {
        return releaseDate;
    }
    @JsonProperty("releaseDate")
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("director")
    public Director getDirector() {
        return director;
    }
    @JsonProperty("director")
    public void setDirector(Director director) {
        this.director = director;
    }

    @JsonProperty("categories")
    public Set<Category> getCategories() {
        return categories;
    }
    @JsonProperty("categories")
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", director=" + director +
                ", categories=" + categories +
                '}';
    }
}
