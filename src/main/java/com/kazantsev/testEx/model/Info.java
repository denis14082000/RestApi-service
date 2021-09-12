package com.kazantsev.testEx.model;

public class Info {
    private final String key;
    private final String content;

    public Info(String key, String content) {
        this.key = key;
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Info{" +
                "key='" + key + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
