package save;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

/**
 * 文件保存、文件打开、txt文档写入
 */
public class Save {

    public static String fileSave(Component parent,String name) {
        JFileChooser fileChooser = new JFileChooser();
        //文件默认名称
        fileChooser.setSelectedFile(new File(name));
        //文件过滤器
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("txt(*.txt)", "txt"));
        String path;
        int result = fileChooser.showSaveDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
            if (!(path.length() - 4 == path.lastIndexOf(".txt"))){
                path = path + ".txt";
            }
            return path;
        }
        else
            return null;
    }

    /**
     * 在.txt中保存字符串
     * @param data 要保存的字符串
     * @param filePath 保存文件的路径
     */
    public static void saveStr(String data, String filePath)
    {
        File file = new File(filePath);
        try {
            FileOutputStream out = new FileOutputStream(file,false);
            out.write(data.getBytes());
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
