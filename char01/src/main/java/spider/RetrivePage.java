package spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ͨ��jdk�Դ���URL����
 */
public class RetrivePage {
    public static String downloadPage(String path) {
        try {
            // ���ݴ����·������URL
            URL pageURL = new URL(path);

            // ����������
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    pageURL.openStream(), "UTF-8"));

            String line;
            // ��ȡ��ҳ����
            StringBuilder pageBuffer = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                pageBuffer.append(line);
            }
            // ������ҳ����
            return pageBuffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ���Դ���
     */
    public static void main(String[] args) {
        // ץȡbaidu��ҳ,���
        System.out.println(RetrivePage.downloadPage("http://www.baidu.com"));
    }
}

