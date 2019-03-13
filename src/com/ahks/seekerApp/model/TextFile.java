package com.ahks.seekerApp.model;

public class TextFile {
    private String name;
    private String path;
    private int results;

    public TextFile(String name, String path) {
        this.name = name;
        this.path = path;
        this.results = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
