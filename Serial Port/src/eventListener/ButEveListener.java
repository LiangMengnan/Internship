package eventListener;

import GUI.serPor.SerMainFrame;
import GUI.serPor.ShowDialog;
import save.Save;
import serPor.*;

import java.awt.*;
import java.io.IOException;

public class ButEveListener {

    public static void addButListener(Component parent){

        //添加查找按钮监听事件
        SerMainFrame.findSerPot.addActionListener(
            event-> new ShowDialog(GetSerPorMes.getSerPotName())
        );

        //打开串口按钮监听事件
        SerMainFrame.serBut1.addActionListener( event-> {
            SerMainFrame.serialPort = ManageSerPot.openSerPot(serPot(),bauRat());
            if (SerMainFrame.serialPort != null){
                SerMainFrame.serCom1.setEnabled(false);
            }
        });

        //扫雷小游戏按钮监听事件
        SerMainFrame.serBut2.addActionListener(event -> {
            SerMainFrame.serialData.setText("");
            SerMainFrame.serialData.paintImmediately(SerMainFrame.serialData.getBounds());
        });

        //保存按钮监听事件
        SerMainFrame.serBut3.addActionListener(event->{
            String filePath = Save.fileSave(parent,"data0.txt");
            if (filePath!=null){
                String str = SerMainFrame.serialData.getText();
                Save.saveStr(str,filePath);
            }
        });

        //关闭串口按钮监听事件
        SerMainFrame.serBut4.addActionListener(event-> {
            try {
                if (ComEveListener.in != null){
                    ComEveListener.in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            SerMainFrame.serCom1.setEnabled(true);
            ManageSerPot.closeSerPot();
        });
    }

    public static String serPot(){
        return (String) SerMainFrame.serCom1.getSelectedItem();
    }

    private static String bauRat(){
        return (String)SerMainFrame.serCom2.getSelectedItem();
    }
}
