package com.sonydafa;

import java.util.Comparator;

public class Link {
    String head;
    String content;
    public Link(String h,String c){
        this.head = h;
        this.content = c;
    }
    @Override
    public String toString() {
        return "Link{" +
                "head='" + head + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
