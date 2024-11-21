package com.binaryfox.wikibooks.mediaTypes;

public abstract class MediaAbstract {
    public String title;
    public MediaAbstract(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }
}
