package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;
import libcore.io.IoUtils;

public class MulticastSocket extends DatagramSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.609 -0400", hash_original_field = "96B66E9938C3C3EFB77DFCB3A31F2836", hash_generated_field = "FA21EF96F67F8787C26D586D454C48A6")

    private InetAddress setAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.609 -0400", hash_original_method = "E00E381299DD101E8388BF5692519367", hash_generated_method = "6344D883D7E184B34B1618995D02B96E")
    public  MulticastSocket() throws IOException {
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.610 -0400", hash_original_method = "AEBFC898C5450F1ABC3134E881783937", hash_generated_method = "790ADC8A1A12A292BB6A363D4846CF2C")
    public  MulticastSocket(int port) throws IOException {
        super(port);
        setReuseAddress(true);
        addTaint(port);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.610 -0400", hash_original_method = "04DD868DCBB43DC9F285487EAD012BAF", hash_generated_method = "726603EEB895A29BA63497A62A6BB64D")
    public  MulticastSocket(SocketAddress localAddress) throws IOException {
        super(localAddress);
        setReuseAddress(true);
        addTaint(localAddress.getTaint());
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.611 -0400", hash_original_method = "467AD7DD9552F52C52E1B541B5F40FE0", hash_generated_method = "85E328B665182F605CD52F04068DCCE7")
    public InetAddress getInterface() throws SocketException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1858027294 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1930224209 = null; //Variable for return #2
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1654521909 = null; //Variable for return #3
        checkOpen();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1858027294 = setAddress;
        } //End block
        InetAddress ipvXaddress;
        ipvXaddress = (InetAddress) impl.getOption(SocketOptions.IP_MULTICAST_IF);
        {
            boolean var110FBA367A6CAF2439B7CCD5FE128683_441902495 = (ipvXaddress.isAnyLocalAddress());
            {
                NetworkInterface theInterface;
                theInterface = getNetworkInterface();
                {
                    Enumeration<InetAddress> addresses;
                    addresses = theInterface.getInetAddresses();
                    {
                        {
                            boolean varDFF60DB25A496BFFEE32B4F3AB44E179_1094394582 = (addresses.hasMoreElements());
                            {
                                InetAddress nextAddress;
                                nextAddress = addresses.nextElement();
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1930224209 = nextAddress;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1654521909 = ipvXaddress;
        InetAddress varA7E53CE21691AB073D9660D615818899_1347496768; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1347496768 = varB4EAC82CA7396A68D541C85D26508E83_1858027294;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1347496768 = varB4EAC82CA7396A68D541C85D26508E83_1930224209;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1347496768 = varB4EAC82CA7396A68D541C85D26508E83_1654521909;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1347496768.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1347496768;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.613 -0400", hash_original_method = "9619F0CC924DAE776456EC0CB550E95C", hash_generated_method = "795DB5BF4DDCD57A70331942EF6EEA8E")
    public NetworkInterface getNetworkInterface() throws SocketException {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1269163232 = null; //Variable for return #1
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_880979231 = null; //Variable for return #2
        checkOpen();
        int index;
        index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1269163232 = NetworkInterface.getByIndex(index);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_880979231 = NetworkInterface.forUnboundMulticastSocket();
        NetworkInterface varA7E53CE21691AB073D9660D615818899_1300741485; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1300741485 = varB4EAC82CA7396A68D541C85D26508E83_1269163232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1300741485 = varB4EAC82CA7396A68D541C85D26508E83_880979231;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1300741485.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1300741485;
        // ---------- Original Method ----------
        //checkOpen();
        //int index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        //if (index != 0) {
            //return NetworkInterface.getByIndex(index);
        //}
        //return NetworkInterface.forUnboundMulticastSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.613 -0400", hash_original_method = "115D2F8953DD08E8766DFC64CC7C212D", hash_generated_method = "60722BBDE09846CBA1DA62B41F32A312")
    public int getTimeToLive() throws IOException {
        checkOpen();
        int var6981648A3805519BB38588D233DBE717_1887890840 = (impl.getTimeToLive());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187539352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187539352;
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTimeToLive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.613 -0400", hash_original_method = "2ED04886DDF130567B09FF7DB10BF58C", hash_generated_method = "BB3A16CA060B224D8329DCAD86CA8881")
    @Deprecated
    public byte getTTL() throws IOException {
        checkOpen();
        byte var21FABDC4F3977645D00C46337AF407A5_1314968984 = (impl.getTTL());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_2139329461 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2139329461;
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTTL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.621 -0400", hash_original_method = "2A9249956792D7D287EC6DE49DBB9AA1", hash_generated_method = "E30FD8C692F94D6F3CA5E0FCC5656348")
    public void joinGroup(InetAddress groupAddr) throws IOException {
        checkJoinOrLeave(groupAddr);
        impl.join(groupAddr);
        addTaint(groupAddr.getTaint());
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.join(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.622 -0400", hash_original_method = "E3A8AF53901269F90797322614E1EFAB", hash_generated_method = "F095DD26B2EF4DCB4E3859A3D3D17DEF")
    public void joinGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkJoinOrLeave(groupAddress, netInterface);
        impl.joinGroup(groupAddress, netInterface);
        addTaint(groupAddress.getTaint());
        addTaint(netInterface.getTaint());
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.joinGroup(groupAddress, netInterface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.622 -0400", hash_original_method = "84DF9FB54D017E3534FF7B79FFC861AD", hash_generated_method = "E7328591C62F697B2CFD79C1E04A83A5")
    public void leaveGroup(InetAddress groupAddr) throws IOException {
        checkJoinOrLeave(groupAddr);
        impl.leave(groupAddr);
        addTaint(groupAddr.getTaint());
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.leave(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.632 -0400", hash_original_method = "5C672C91FEA72835E9232D6CA28DF6E9", hash_generated_method = "BA1432106E2BF9A3FEA669F27E42552B")
    public void leaveGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkJoinOrLeave(groupAddress, netInterface);
        impl.leaveGroup(groupAddress, netInterface);
        addTaint(groupAddress.getTaint());
        addTaint(netInterface.getTaint());
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.leaveGroup(groupAddress, netInterface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.632 -0400", hash_original_method = "5D3737731721260F57AF95D7810519A1", hash_generated_method = "10F4285626B51544431DAAF9996554E4")
    private void checkJoinOrLeave(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("groupAddress == null");
        } //End block
        {
            boolean var51868208D871CAD688D045D5994E5703_1080757121 = (netInterface != null && !netInterface.getInetAddresses().hasMoreElements());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("No address associated with interface: " + netInterface);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Group address not an InetSocketAddress: " +
                    groupAddress.getClass());
        } //End block
        InetAddress groupAddr;
        groupAddr = ((InetSocketAddress) groupAddress).getAddress();
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Group address has no address: " + groupAddress);
        } //End block
        {
            boolean varEDC6F8254C9C0286DEE9E460F974EF8F_184786561 = (!groupAddr.isMulticastAddress());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Not a multicast group: " + groupAddr);
            } //End block
        } //End collapsed parenthetic
        addTaint(groupAddress.getTaint());
        addTaint(netInterface.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.633 -0400", hash_original_method = "6596B4EA78B0ED28321084C8CA9DCC77", hash_generated_method = "944652AD998D8E005B03E1E4B61EEE5A")
    private void checkJoinOrLeave(InetAddress groupAddr) throws IOException {
        checkOpen();
        {
            boolean varEDC6F8254C9C0286DEE9E460F974EF8F_662989326 = (!groupAddr.isMulticastAddress());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Not a multicast group: " + groupAddr);
            } //End block
        } //End collapsed parenthetic
        addTaint(groupAddr.getTaint());
        // ---------- Original Method ----------
        //checkOpen();
        //if (!groupAddr.isMulticastAddress()) {
            //throw new IOException("Not a multicast group: " + groupAddr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.634 -0400", hash_original_method = "B2C00FA361C879157E99EDF94577EB31", hash_generated_method = "D50D43DC390696BE84BBC7BCDEF20C66")
    @Deprecated
    public void send(DatagramPacket packet, byte ttl) throws IOException {
        checkOpen();
        InetAddress packAddr;
        packAddr = packet.getAddress();
        int currTTL;
        currTTL = getTimeToLive();
        {
            boolean var34C3FA09B2E514266A2C38DF6E52C4B1_1811394490 = (packAddr.isMulticastAddress() && (byte) currTTL != ttl);
            {
                try 
                {
                    setTimeToLive(ttl & 0xff);
                    impl.send(packet);
                } //End block
                finally 
                {
                    setTimeToLive(currTTL);
                } //End block
            } //End block
            {
                impl.send(packet);
            } //End block
        } //End collapsed parenthetic
        addTaint(packet.getTaint());
        addTaint(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //InetAddress packAddr = packet.getAddress();
        //int currTTL = getTimeToLive();
        //if (packAddr.isMulticastAddress() && (byte) currTTL != ttl) {
            //try {
                //setTimeToLive(ttl & 0xff);
                //impl.send(packet);
            //} finally {
                //setTimeToLive(currTTL);
            //}
        //} else {
            //impl.send(packet);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.634 -0400", hash_original_method = "89C8198F5D22E8812FC96CB1AE49CBE2", hash_generated_method = "12EE7ACBF35469E0648F08707C51E715")
    public void setInterface(InetAddress address) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("address == null");
        } //End block
        NetworkInterface networkInterface;
        networkInterface = NetworkInterface.getByInetAddress(address);
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("Address not associated with an interface: " + address);
        } //End block
        impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        this.setAddress = address;
        // ---------- Original Method ----------
        //checkOpen();
        //if (address == null) {
            //throw new NullPointerException("address == null");
        //}
        //NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
        //if (networkInterface == null) {
            //throw new SocketException("Address not associated with an interface: " + address);
        //}
        //impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        //this.setAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.648 -0400", hash_original_method = "103D9F8CED47CA1D8B78CD3F071983B8", hash_generated_method = "ECCF94C38AD0B5200CBDF14CE62D39E3")
    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("networkInterface == null");
        } //End block
        impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        this.setAddress = null;
        addTaint(networkInterface.getTaint());
        // ---------- Original Method ----------
        //checkOpen();
        //if (networkInterface == null) {
            //throw new SocketException("networkInterface == null");
        //}
        //impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        //this.setAddress = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.648 -0400", hash_original_method = "87E1DCD7CA258C3733B679C47E824196", hash_generated_method = "B47293E90BE280492A8E2A24A29E1028")
    public void setTimeToLive(int ttl) throws IOException {
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        } //End block
        impl.setTimeToLive(ttl);
        addTaint(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //if (ttl < 0 || ttl > 255) {
            //throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        //}
        //impl.setTimeToLive(ttl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.649 -0400", hash_original_method = "5513CDD24FF579269A679F40508B01F6", hash_generated_method = "720D5EA826331A6CD37628E84D69E0F0")
    @Deprecated
    public void setTTL(byte ttl) throws IOException {
        checkOpen();
        impl.setTTL(ttl);
        addTaint(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setTTL(ttl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.650 -0400", hash_original_method = "EBCEB6AAB2ED917FE096C1D1630BA905", hash_generated_method = "BEDF31EA5381933A07A4F54017CC3162")
    @Override
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
        impl.create();
        try 
        {
            impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
            impl.bind(aPort, addr);
            isBound = true;
        } //End block
        catch (SocketException e)
        {
            close();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        addTaint(aPort);
        addTaint(addr.getTaint());
        // ---------- Original Method ----------
        //impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
        //impl.create();
        //try {
            //impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
            //impl.bind(aPort, addr);
            //isBound = true;
        //} catch (SocketException e) {
            //close();
            //throw e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.664 -0400", hash_original_method = "DC4B33B8ADF09E78AF384B12E0911A9B", hash_generated_method = "33B7CAD41932DB8232268427D7DCF415")
    public boolean getLoopbackMode() throws SocketException {
        checkOpen();
        boolean var9F17B8B0C8660863198CB1597BEE44E9_2133967036 = (!((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13089111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_13089111;
        // ---------- Original Method ----------
        //checkOpen();
        //return !((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.664 -0400", hash_original_method = "3AC1197302083655B98FC683162962C9", hash_generated_method = "D2AB57B17885F2DCBD096F6B12E191E0")
    public void setLoopbackMode(boolean disable) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
        addTaint(disable);
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
    }

    
}

