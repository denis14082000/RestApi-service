package com.kazantsev.testEx.model;

import java.util.Objects;

public class Info {
    private String key;
    private String content;
    private Integer ttl;
    private long createTime;

    public Info() {

    }

    public Info(String key, String content) {
        this.key = key;
        this.content = content;
    }

    public Info(String key, String content, Integer ttl) {
        this.key = key;
        this.content = content;
        this.ttl = ttl;
    }

    public Info(String key, String content, Integer ttl, long createTime) {
        this.key = key;
        this.content = content;
        this.ttl = ttl;
        this.createTime = createTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return createTime == info.createTime && key.equals(info.key) && content.equals(info.content) && Objects.equals(ttl, info.ttl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, content, ttl, createTime);
    }
}
