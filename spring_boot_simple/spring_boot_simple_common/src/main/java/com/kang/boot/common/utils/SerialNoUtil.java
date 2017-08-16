package com.kang.boot.common.utils;

import com.kang.boot.common.enums.AppName;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class SerialNoUtil {
    private static Object lock = new Object();
    private static String localHostAddress = "";
    private static String ipCode = "";
    private static int index = 0;

    public SerialNoUtil() {
    }

    public static String generateSerialNo(AppName appName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append(appName.getNumber());
        stringBuffer.append(getIpCode());
        stringBuffer.append(getTimeCode());
        String indexV = "000";
        Object var3 = lock;
        synchronized(lock) {
            ++index;
            if(index > 999) {
                index = 0;
            }

            indexV = "" + index;
        }

        if(indexV.length() < 2) {
            indexV = "00" + indexV;
        }

        if(indexV.length() < 3) {
            indexV = "0" + indexV;
        }

        stringBuffer.append(indexV);
        return stringBuffer.toString();
    }

    private static String getIpCode() {
        String ip = getLocalHostAddress();
        if(ipCode != null && !ipCode.equals("")) {
            return ipCode;
        } else {
            String[] ipArray = ip.split("\\.");

            for(int j = 0; j < 4; ++j) {
                for(int i = ipArray[j].length(); i < 3; ++i) {
                    ipCode = ipCode + "0";
                }

                ipCode = ipCode + ipArray[j];
            }

            return ipCode;
        }
    }

    private static String getTimeCode() {
        return (new SimpleDateFormat("yyMMddHHmmssSSS")).format(new Date());
    }

    public static String getLocalHostAddress() {
        if(!localHostAddress.equals("")) {
            return localHostAddress;
        } else {
            String ip = "";
            String ipBak = "";
            InetAddress inetAddress = null;

            try {
                inetAddress = InetAddress.getLocalHost();
                ip = inetAddress.getHostAddress();
            } catch (UnknownHostException var10) {
                ;
            } catch (NullPointerException var11) {
                ;
            }

            if(ip.equals("127.0.0.1") && ip.indexOf(58) < 0) {
                Enumeration netInterfaces = null;

                try {
                    netInterfaces = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException var9) {
                    ;
                }

                InetAddress iAddress = null;

                NetworkInterface ni;
                try {
                    for(boolean e = netInterfaces.hasMoreElements(); e; iAddress = null) {
                        ni = (NetworkInterface)netInterfaces.nextElement();
                        iAddress = (InetAddress)ni.getInetAddresses().nextElement();
                        if(!iAddress.isSiteLocalAddress() && !iAddress.isLoopbackAddress() && iAddress.getHostAddress().indexOf(":") == -1) {
                            ip = iAddress.getHostAddress();
                            break;
                        }

                        ip = iAddress.getHostAddress();
                        if(!ip.equals("127.0.0.1") && ip.split("\\.").length == 4 && ip.indexOf(58) < 0) {
                            ipBak = ip;
                        }

                        ip = "";
                    }
                } catch (NullPointerException var13) {
                    ;
                } catch (Exception var14) {
                    ;
                }

                if(!ip.equals("127.0.0.1") && ip.split("\\.").length == 4 && ip.indexOf(58) < 0) {
                    localHostAddress = ip;
                    return ip;
                } else {
                    try {
                        label151: {
                            Enumeration e1 = NetworkInterface.getNetworkInterfaces();

                            do {
                                if(!e1.hasMoreElements()) {
                                    break label151;
                                }

                                ni = (NetworkInterface)e1.nextElement();
                            } while(!ni.getName().equals("eth0") && !ni.getName().equals("eth1") && !ni.getName().equals("bond0"));

                            Enumeration e2 = ni.getInetAddresses();

                            while(e2.hasMoreElements()) {
                                InetAddress ia = (InetAddress)e2.nextElement();
                                if(!(ia instanceof Inet6Address)) {
                                    ip = ia.getHostAddress();
                                    if(!ia.isSiteLocalAddress() && !ip.equals("127.0.0.1") && ip.split("\\.").length == 4 && ip.indexOf(58) < 0) {
                                        localHostAddress = ip;
                                        return ip;
                                    }

                                    if(ni.getName().equals("eth1") && !ia.isSiteLocalAddress() && !ip.equals("127.0.0.1") && ip.split("\\.").length == 4 && ip.indexOf(58) < 0) {
                                        ipBak = ip;
                                        ip = "";
                                    }
                                }
                            }
                        }
                    } catch (SocketException var12) {
                        ;
                    }

                    if(!ip.equals("127.0.0.1") && ip.split("\\.").length == 4 && ip.indexOf(58) < 0) {
                        localHostAddress = ip;
                        return ip;
                    } else if(!ipBak.equals("127.0.0.1") && ipBak.split("\\.").length == 4 && ipBak.indexOf(58) < 0) {
                        localHostAddress = ipBak;
                        return ipBak;
                    } else {
                        localHostAddress = ip;
                        return ip;
                    }
                }
            } else {
                localHostAddress = ip;
                return ip;
            }
        }
    }
}

