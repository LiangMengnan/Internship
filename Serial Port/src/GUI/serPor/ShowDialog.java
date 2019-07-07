package GUI.serPor;

import javax.swing.*;
import java.awt.*;

public class ShowDialog {

    private JDialog proDia = new JDialog();
    private JLabel proLab = new JLabel();

    public ShowDialog(String name){
        initDia();
        showSerPotName(name);
        proDia.setVisible(true);
    }

    public ShowDialog(String command, Boolean flag,String problem){
        initDia();
        if (command.equals("Open")){
            if (flag)
                open();
            if (!flag)
                open(problem);
        }

        if (command.equals("Close")){
            if (flag)
                close();
            if (!flag)
                close(problem);
        }
        proDia.setVisible(true);
    }

    /**
     * 初始化对话框
     */
    private void initDia(){
        proDia.setSize(380,160);
        proDia.setTitle("提示");
        proDia.setLocationRelativeTo(null);
    }

    /**
     * 打开关闭成功或失败时弹出此对话框
     */
    private void open(){
        proLab.setText("打开串口成功");
        diaUI();
    }

    private void open(String problem){
        proLab.setText(problem);
        diaUI();
    }

    private void close(){
        proLab.setText(SerMainFrame.serCom1.getSelectedItem() + "关闭成功");
        diaUI();
    }

    private void close(String problem){
        proLab.setText(problem);
        diaUI();
    }

    /**
     * 显示准备就绪的串口
     * @param name 串口名字
     */
    private void showSerPotName(String name){
        if (name != null){
            proLab.setText("串口" + name + "准备就绪");
        }else{
            proLab.setText("没有检测到可用串口");
        }
        diaUI();
    }


    /**
     * 提示的标题设置
     */
    private void diaUI(){
        proLab.setFont(new Font("隶书",Font.BOLD,35));
        proLab.setHorizontalAlignment(SwingConstants.CENTER);
        proLab.setBounds(25,10,120,30);
        proDia.getContentPane().add(proLab);
    }
}
