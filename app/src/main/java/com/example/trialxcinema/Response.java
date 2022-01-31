package com.example.trialxcinema;

import java.util.List;

public class Response {
    int page;
    List<ResponseModel> results;

    public int getPage() {
        return page;
    }

    public List<ResponseModel> getResults() {
        return results;
    }
}
