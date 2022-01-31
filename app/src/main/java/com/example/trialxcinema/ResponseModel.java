package com.example.trialxcinema;

public class ResponseModel {
    String title, backdrop_path, vote_average, release_date, overview;

    public ResponseModel() {
    }

    public ResponseModel(String title, String backdrop_path, String vote_average, String release_date, String overview) {
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.release_date = release_date;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
