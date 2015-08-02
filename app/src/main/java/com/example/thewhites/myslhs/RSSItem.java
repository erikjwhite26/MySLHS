package com.example.thewhites.myslhs;

import java.io.Serializable;

/**
 * Created by Erik on 2/11/2015.
 */
public class RSSItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String _title = null;
    private String _link = null;
    private String _author = null;
    private String _pubDate = null;

    void setTitle(String title) {
        _title = title;
    }

    void setLink(String link) { _link = link; }

    void setAuthor(String author) {
        _author = author;
    }

    void setPubDate(String pubdate) {
        _pubDate = pubdate;
    }

    public String getTitle() { return _title; }

    public String getLink() { return _link; }

    public String getAuthor() {
        return _author;
    }

    public String getPubDate() {
        return _pubDate;
    }

}
