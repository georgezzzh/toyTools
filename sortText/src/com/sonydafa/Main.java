package com.sonydafa;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * in 2020-07-16
 * this program's functions is sorting text according alphabetical
 * given a file path, output the same fileName but suffix is '.sort'
 * notice: this program only process markdown anchor, e.g. [google](www.google.com)
 */

public class Main {
    public static void sortText(String path){
        // write your code here
        try{
            FileReader reader = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(reader);
            String str;
            ArrayList<Link> list = new ArrayList<>();
            while((str=br.readLine())!=null){
                int begin = str.indexOf('[');
                int end = str.indexOf(']');
                if(begin==-1 || end==-1)
                    continue;
                String title = str.substring(begin+1,end);
                String content = end+1<str.length() ? str.substring(end+1): "";
                list.add(new Link(title,content));
            }
            list.sort(new Comparator<Link>() {
                @Override
                public int compare(Link o1, Link o2) {
                    return o1.head.compareTo(o2.head);
                }
            });
            FileWriter writer = new FileWriter(new File(path+".sort"));
            for(Link lk:list){
                writer.write("["+lk.head+"]("+lk.content+")\n\n");
            }
            //close
            reader.close();
            writer.close();
        }catch (IOException ie){
            System.out.println(ie.toString());
        }
    }
    public static void main(String[] args) {
        sortText("/home/george/test.txt");
    }
}
