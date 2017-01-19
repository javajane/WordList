package com.MiscellaneousProjects;

/**
 * Created by pinaki on 12/15/2016.
 */
public class WordList implements Comparable<WordList>{

    private String name;
    private int times;

    public WordList(String name) {
        this.name = name;
        this.times=1;
    }

    public String getName() {
        return name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes () {
        this.times++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordList wordList = (WordList) o;

        return name != null ? name.equals(wordList.name) : wordList.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    @Override
    public int compareTo(WordList thisword) {
        return this.getTimes() > thisword.getTimes() ? -1 : 1;
        //return 0;
    }
}
