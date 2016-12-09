package com.hkm.example;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by makhotin on 8/12/2016.
 */
public class JavaModel {
    private String title;
    private String content;
    private List<String> tags;
    private JavaSingleMethodInterface singleListener;
    private JavaMultiMethodInterface multiListener;

    public JavaModel(@Nullable String title, @Nullable String content, @Nullable List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(@Nullable String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(@Nullable List<String> tags) {
        this.tags = tags;
    }

    public JavaSingleMethodInterface getSingleListener() {
        return singleListener;
    }

    public void setSingleListener(JavaSingleMethodInterface singleListener) {
        this.singleListener = singleListener;
    }

    public JavaMultiMethodInterface getMultiListener() {
        return multiListener;
    }

    public void setMultiListener(JavaMultiMethodInterface multiListener) {
        this.multiListener = multiListener;
    }

    public interface JavaSingleMethodInterface {
        void doSomething(String text);
    }

    public interface JavaMultiMethodInterface extends JavaSingleMethodInterface {
        String returnSomething();
    }
}
