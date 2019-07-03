package com.thejoker.searchrepository.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Repo {

    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    private ArrayList<Item> items;
    @SerializedName("total_count")
    private Long totalCount;

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

}
