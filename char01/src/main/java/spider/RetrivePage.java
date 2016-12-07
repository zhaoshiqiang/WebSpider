package spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过jdk自带的URL访问
 */
public class RetrivePage {
    public static String downloadPage(String path) {
        try {
            // 根据传入的路径构造URL
            URL pageURL = new URL(path);

            // 创建网络流
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    pageURL.openStream(), "UTF-8"));

            String line;
            // 读取网页内容
            StringBuilder pageBuffer = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                pageBuffer.append(line);
            }
            // 返回网页内容
            return pageBuffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) {
        // 抓取baidu首页,输出
        System.out.println(RetrivePage.downloadPage("http://www.baidu.com"));
    }
}

