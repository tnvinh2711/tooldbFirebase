package com.zinzin.tooluploaddb.model.AutoChess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Creep {
    private int id;
    @SerializedName("round")
    @Expose
    private Integer round;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("creeps")
    @Expose
    private List<String> creeps = null;

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCreeps() {
        return creeps;
    }

    public void setCreeps(List<String> creeps) {
        this.creeps = creeps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
