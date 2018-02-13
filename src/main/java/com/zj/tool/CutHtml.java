package com.zj.tool;

import java.io.*;
import java.util.Date;

public class CutHtml {

    public static String top = "<%@ page contentType=\"text/html;charset=UTF-8\" %>\n<%@ include file=\"/WEB-INF/views/include/taglib.jsp\"%>" +
            "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><title>QQ Message</title>" +
            "<style type=\"text/css\">body{font-size:12px; line-height:22px; margin:2px;}td{font-size:12px; line-height:22px;}" +
            "</style></head><body><table width=100% cellspacing=0>\n";
    public static String end = "</table></body></html>";

    public static String dateStr = "日期:";

    public static String folderName = "F:\\html\\html3\\";

    public static String tempName = "F:\\html\\html3\\temp.jsp";

    public static void main(String[] args) {
        try {
            cut("f:\\1047583436-3.html", folderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cut(String fileName,String folder) throws IOException {
        File file = new File(fileName); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(file)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        int i = 0;
        int j = 0;

         /* 写入Txt文件 */
        File writeFile = new File(tempName); // 相对路径，如果没有则要建立一个新的output。txt文件
        writeFile.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writeFile));


        String writeFileName = "";

        out.write(top);
        while (line != null) {
            i++;
            j++;
            System.out.println(j+"   "+i+line);
            out.write(line + "\n"); // \r\n即为换行
            if (line!=null&&line.contains(dateStr)&&writeFileName.length()==0){
                int x = line.indexOf(dateStr);
                writeFileName = folder + "1047583436-"+line.substring(x+4,x+14)+".jsp";
            }
            if (i==1000){
                out.write(end);
                out.flush(); // 把缓存区内容压入文件
                out.close(); // 最后记得关闭文件

                if (writeFileName.length()==0){
                    writeFileName = folder + "1047583436-" + new Date().getTime()+".jsp";
                }
                writeFile.renameTo(new File(writeFileName));

                writeFile = new File(tempName);
                writeFile.createNewFile(); // 创建新文件
                out = new BufferedWriter(new FileWriter(writeFile));
                out.write(top);
                writeFileName = "";
                i=0;
            }

            line = br.readLine(); // 一次读入一行数据
        }

        out.write(end);
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件

        if (line!=null&&line.contains(dateStr)&&writeFileName.length()==0){
            int x = line.indexOf(dateStr);
            writeFileName = folder + "1047583436-"+line.substring(x+4,x+14)+".jsp";
        }

        if (writeFileName.length()==0){
            writeFileName = folder + "1047583436-" + new Date().getTime()+".jsp";
        }
        writeFile.renameTo(new File(writeFileName));

    }

}
