package serPor;


import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

public class GetSerPorMes {

    /**
     * 查找可用的串口
     * @return 返回可用串口的名称
     */
    public static String getSerPotName(){
        String portName = null;
        @SuppressWarnings("unchecked")
        Enumeration<CommPortIdentifier> serPotList = CommPortIdentifier.getPortIdentifiers();
        while (serPotList.hasMoreElements()){
            CommPortIdentifier portIdentifier = serPotList.nextElement();
            if (portIdentifier.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                portName = portIdentifier.getName();
            }
        }
        return portName;
    }
}
