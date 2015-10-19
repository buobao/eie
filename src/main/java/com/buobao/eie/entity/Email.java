package com.buobao.eie.entity;

import java.io.Serializable;

/**
 * Created by dqf on 2015/10/19.
 */
public class Email implements Serializable {
    private static final long serialVersioUID = -658250125732806493L;

    private String receiver;
    private String title;
    private String content;

    public Email(String receiver, String title, String content){
        this.receiver = receiver;
        this.title = title;
        this.content = content;
    }

    public String getReceiver(){
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Email [receiver=").append(receiver).append(",title=").append(title)
                .append(",content=").append(content).append("]");
        return builder.toString();
    }
}
