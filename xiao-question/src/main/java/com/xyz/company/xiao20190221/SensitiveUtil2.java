package com.xyz.company.xiao20190221;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SensitiveUtil2 {

    private static Node root = new Node();

    static {
        try {
            URL url = SensitiveUtil2.class.getClassLoader().getResource("gistfile1.txt");
            if (url != null) {
                File file = new File(url.getFile());
                BufferedReader reader = null;
                String lineContent;
                reader = new BufferedReader(new FileReader(file));
                while ((lineContent = reader.readLine()) != null) {
                    // 取出每一行中的数据
                    Node tempNode = root;
                    for (int i = 0; i < lineContent.length(); i++) {
                        // 根据字符来建立树状结构
                        char key = lineContent.charAt(i);
                        // 得到子节点
                        Node node = tempNode.getSubNode(key);
                        if (node == null) {
                            node = new Node();
                        }
                        // 如果已经是敏感词结尾，设置标记
                        if (i == lineContent.length() - 1) {
                            node.setKeywordEnd(true);
                        }
                        tempNode.addSubNode(key, node);
                        tempNode = node;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SensitiveUtil2 sensitiveUtil2 = new SensitiveUtil2();
        sensitiveUtil2.printSensitiveWord("王侯将相，宁有种乎，北京怎么了？北京事件是什么？");
    }

    /**
     * description: 根据 text 循环取出字符, 根据字符所对应的节点一直往下查, 直到查到敏感词结尾.
     * 如果能查到敏感词结尾, 打印敏感词. 如果没有下一个节点, 清空敏感池.
     *
     * @param text
     * @return boolean
     * @author: xyz
     * @create: 2019-02-22
     */
    private void printSensitiveWord(String text) {

        int position = 0;
        Node tempNode = root;
        StringBuilder sb = new StringBuilder();
        while (position < text.length()) {
            char key = text.charAt(position);
            tempNode = tempNode.getSubNode(key);
            if (tempNode == null) {
                // 临时节点变为根节点重新判断
                tempNode = root;
                // 清空缓冲池
                sb.setLength(0);
            } else if (tempNode.isKeywordEnd()) { // 如果已经是敏感词结尾了
                tempNode = root;
                sb.append(key);
                // 打印缓冲池的敏感词
                System.out.println(sb.toString());
            } else {
                sb.append(key);
            }
            position++;
        }
    }

    private static class Node {

        /**
         * 当前节点是否是叶子节点, 默认不是叶子节点.
         */
        private boolean end = false;

        /**
         * 存放子节点列表
         */
        Map<Character, Node> subNodeMap = new HashMap<>();

        void addSubNode(Character key, Node node) {
            subNodeMap.put(key, node);
        }

        Node getSubNode(Character key) {
            return subNodeMap.get(key);
        }

        void setKeywordEnd(boolean end) {
            this.end = end;
        }

        boolean isKeywordEnd() {
            return end;
        }
    }
}
