package com.scorpiospace.utils;

import com.scorpiospace.utils.CheckPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName GetHtml
 * @Description TODO
 * @Author zq
 * @Date 2019/7/31 11:21
 * @Version 1.0
 **/
public class GetHtml {
    public static void main(String[] args) {
        try {
            //创建一个URL实例
            URL url = new URL("https://tieba.baidu.com/f?kw=%E4%B9%B0%E5%8D%96%E6%89%8B%E6%9C%BA%E5%8F%B7");
            try {
                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is,"utf-8");

                //为字符输入流添加缓冲
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据

                while (data!=null){//循环读取数据
                    CheckPhone.checkNum(data);//输出数据
                    data = br.readLine();
                }
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
