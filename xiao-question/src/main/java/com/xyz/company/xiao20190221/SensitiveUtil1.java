package com.xyz.company.xiao20190221;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SensitiveUtil1 {

    String str = "王侯将相，宁有种乎";

    private static final List<String> sensitiveWords = new ArrayList<>(1000);

    static {
        try {
            URL url = SensitiveUtil1.class.getClassLoader().getResource("gistfile1.txt");
            if(url != null) {
                File file = new File(url.getFile());
                BufferedReader reader = null;
                String lineContent;
                reader = new BufferedReader(new FileReader(file));
                while ((lineContent = reader.readLine()) != null) {
                    sensitiveWords.add(lineContent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean judgeSensitiveWord() {
        for (String sensitiveWord : sensitiveWords) {
            if(str.contains(sensitiveWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

    }

}
