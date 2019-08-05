package com.scorpiospace.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName checkPhone
 * @Description TODO
 * @Author zq
 * @Date 2019/7/31 11:23
 * @Version 1.0
 **/
public class CheckPhone {
    public static String checkNum(String num){
        if(num == null || num.length() == 0){return "";}
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[3456789]\\d{9})|(?:861[358]\\d{9}))(?!\\d)");
        Matcher matcher = pattern.matcher(num);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }
    public static void check(){
        try {
            URL url=new URL("https://tieba.baidu.com/f?kw=%E4%B9%B0%E5%8D%96%E6%89%8B%E6%9C%BA%E5%8F%B7");
            BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer=new BufferedWriter(new FileWriter("index.html"));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(CheckPhone.checkNum(line));
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
