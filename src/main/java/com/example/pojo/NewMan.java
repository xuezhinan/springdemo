package com.example.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "people",type = "newman")
public class NewMan {
    @Id
    private long id;
    private String word;
    private String name;
    private String title;
    private String age;
    private String time;


    public void setId(long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public NewMan() {
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAge() {
        return age;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString(){

        return "NewMan{"+
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", time=" + time +
                '}';
    }
}
