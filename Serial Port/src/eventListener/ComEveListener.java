package eventListener;

import GUI.serPor.SerMainFrame;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;

public class ComEveListener implements SerialPortEventListener {

    static InputStream in;

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
       try {
           if (SerMainFrame.serialPort != null){
               in = SerMainFrame.serialPort.getInputStream();
           }

       }catch (Exception e){
           e.printStackTrace();
       }

        byte[] serPotData;
        try {
            // 获取数据长度
            int length = in.available();
            while (length > 0) {
                serPotData = new byte[in.available()];
                int bytLen = in.read(serPotData);
                String s = new String(serPotData,0,bytLen);
                //在显示区域显示数据
                SerMainFrame.serialData.append(s);
                //显示区域刷新
                SerMainFrame.serialData.paintImmediately(SerMainFrame.serialData.getBounds());
                length = in.available();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
