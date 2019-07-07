package GUI.serPor;

import eventListener.ButEveListener;
import gnu.io.SerialPort;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SerMainFrame extends JFrame {

    public static void main(String[] args){
        new SerMainFrame();
    }
    public  static SerialPort serialPort;
    public static JButton findSerPot = new JButton("查找串口");
    public static JButton serBut1 = new JButton("打开串口");
    public static JButton serBut2 = new JButton("清除内容");
    public static JButton serBut3 = new JButton("保存数据");
    public static JButton serBut4 = new JButton("关闭串口");
    private static String[] COM = {"COM1","COM2","COM3","COM4","COM5","COM6","COM7","COM8"} ;
    public static JComboBox serCom1 = new JComboBox<>(COM);
    private static String[] bauRat = {"7200","9600","14400","19200","28800","115200"};
    public static JComboBox serCom2 = new JComboBox<>(bauRat);
    public static JTextArea serialData = new JTextArea();

    private SerMainFrame(){
        //窗口初始化
        initialization();
        //控件显示
        UI();
        //监听器设置
        ButEveListener.addButListener(this);
        //设置可见
        setVisible(true);
    }

    /**
     * 窗口初始化
     */
    private void initialization(){
        setTitle("串口监视器");
        setLayout(null);
        setSize(750,530);
        //设置显示在屏幕中央
        setLocationRelativeTo(null);
        //设置不可最大化
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void UI(){
        displayInformation();
        infPan();
        setUp();
    }

    /**
     * 显示串口的通信数据
     */
    private void displayInformation(){
        JScrollPane scrollPane = new JScrollPane(serialData);
        scrollPane.setBounds(13, 10, 718, 300);
        //设置显示区域无法选中
        serialData.setFocusable(false);
        getContentPane().add(scrollPane);
    }

    /**
     * 显示串口信息
     */
    private void infPan(){
        JPanel serInf = new JPanel();
        JLabel serLab1 = new JLabel("选择串口:");
        JLabel serLab2 = new JLabel("选择波特率:");
        TitledBorder titledBorder = new TitledBorder("串口设置");

        //设置标题格式
        titledBorder.setTitleFont(new Font("隶书",Font.BOLD,25));

        //设置面板格式
        serInf.setLayout(null);
        serInf.setBorder(titledBorder);
        serInf.setBounds(13, 320, 270, 150);

        //设置Label1格式
        serLab1.setBounds(15,40,150,30);
        serLab1.setForeground(Color.black);
        serLab1.setFont(new Font("隶书",Font.BOLD,23));
        serInf.add(serLab1);

        //设置Label2格式
        serLab2.setBounds(15,80,150,30);
        serLab2.setForeground(Color.black);
        serLab2.setFont(new Font("隶书",Font.BOLD,23));
        serInf.add(serLab2);

        //设置JComboBox1格式
        serCom1.setBounds(152,45,90,25);
        serCom1.setForeground(Color.black);
        serCom1.setSelectedIndex(0);
        serCom1.setFocusable(false);
        serCom1.setFont(new Font("隶书",Font.BOLD,23));
        serInf.add(serCom1);
        
        //设置JComboBox2格式
        serCom2.setBounds(152,85,110,25);
        serCom2.setForeground(Color.black);
        serCom2.setSelectedIndex(0);
        serCom2.setFocusable(false);
        serCom2.setFont(new Font("隶书",Font.BOLD,23));
        serInf.add(serCom2);
        
        //设置JButton findSerPot格式
        findSerPot.setBounds(152,115,87,27);
        //设置居中显示
        findSerPot.setMargin(new Insets(0,0,0,0));
        findSerPot.setFocusable(false);
        findSerPot.setForeground(Color.black);
        findSerPot.setFont(new Font("隶书",Font.BOLD,19));
        serInf.add(findSerPot);
        getContentPane().add(serInf);
    }

    /**
     *串口其它操作
     */
    private void setUp(){
        JPanel serSetUp = new JPanel();
        TitledBorder titledBorder = new TitledBorder("其他操作");
        //设置标题格式
        titledBorder.setTitleFont(new Font("隶书",Font.BOLD,25));
        //设置面板格式
        serSetUp.setLayout(null);
        serSetUp.setBorder(titledBorder);
        serSetUp.setBounds(315, 320, 415, 150);

        //设置Button1
        serBut1.setBounds(33,50,160,27);
        //设置居中显示
        serBut1.setMargin(new Insets(0,0,0,0));
        serBut1.setFocusable(false);
        serBut1.setForeground(Color.black);
        serBut1.setFont(new Font("隶书",Font.BOLD,23));
        serSetUp.add(serBut1);

        //设置Button2
        serBut2.setBounds(222,50,160,27);
        //设置居中显示
        serBut2.setMargin(new Insets(0,0,0,0));
        serBut2.setFocusable(false);
        serBut2.setForeground(Color.black);
        serBut2.setFont(new Font("隶书",Font.BOLD,23));
        serSetUp.add(serBut2);
        
        //设置Button3
        serBut3.setBounds(33,90,160,27);
        //设置居中显示
        serBut3.setMargin(new Insets(0,0,0,0));
        serBut3.setFocusable(false);
        serBut3.setForeground(Color.black);
        serBut3.setFont(new Font("隶书",Font.BOLD,23));
        serSetUp.add(serBut3);

        //设置Button4
        serBut4.setBounds(222,90,160,27);
        //设置居中显示
        serBut4.setMargin(new Insets(0,0,0,0));
        serBut4.setFocusable(false);
        serBut4.setForeground(Color.black);
        serBut4.setFont(new Font("隶书",Font.BOLD,23));
        serSetUp.add(serBut4);
        getContentPane().add(serSetUp);
    }
}
