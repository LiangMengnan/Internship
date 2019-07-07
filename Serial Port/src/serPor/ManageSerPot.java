package serPor;

import GUI.serPor.SerMainFrame;
import GUI.serPor.ShowDialog;
import eventListener.ButEveListener;
import eventListener.ComEveListener;
import gnu.io.*;

public class ManageSerPot {

    /**
     * 打开串口
     * @param serPotName 串口名
     * @param bauRat 波特率
     * @return 返回串口对象
     */
    public static SerialPort openSerPot(String serPotName,String bauRat){
        try {
            //识别串口
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(serPotName);
            //打开串口并设置打开超时时间
            CommPort commPort = portIdentifier.open(serPotName, 2000);
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                try {
                    //设置波特率、数据位、停止位、检验位
                    serialPort.setSerialPortParams(Integer.parseInt(bauRat), SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    ManageSerPot.addListener(serialPort,new ComEveListener());
                }catch (Exception e){
                    e.printStackTrace();
                }
                new ShowDialog("Open",true,null);
                return serialPort;
            }
        }catch (NoSuchPortException e){
            new ShowDialog("Open",false, ButEveListener.serPot() + "没有连接");
        }catch (PortInUseException e){
            new ShowDialog("Open",false,"串口被占用");
        }
        return null;
    }

    /**
     * 关闭串口
     */
    public static void closeSerPot(){
        if (SerMainFrame.serialPort != null){
            try {
                SerMainFrame.serialPort.close();
                SerMainFrame.serialPort = null;
                new ShowDialog("Close",true,null);
            }catch (Exception e){
                new ShowDialog("Close",false,null);
            }
        }else{
            new ShowDialog("Close",false,ButEveListener.serPot() + "没有打开");
        }
    }

    private static void addListener(SerialPort port, SerialPortEventListener listener){
        try {
            // 给串口添加监听器
            port.addEventListener(listener);
            // 设置当有数据到达时唤醒监听接收线程
            port.notifyOnDataAvailable(true);
            // 设置当通信中断时唤醒中断线程
            port.notifyOnBreakInterrupt(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
