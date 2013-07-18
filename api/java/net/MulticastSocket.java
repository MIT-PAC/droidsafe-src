package java.net;

// Droidsafe Imports
import java.io.IOException;
import java.util.Enumeration;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MulticastSocket extends DatagramSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.797 -0400", hash_original_field = "96B66E9938C3C3EFB77DFCB3A31F2836", hash_generated_field = "FA21EF96F67F8787C26D586D454C48A6")

    private InetAddress setAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.798 -0400", hash_original_method = "E00E381299DD101E8388BF5692519367", hash_generated_method = "6344D883D7E184B34B1618995D02B96E")
    public  MulticastSocket() throws IOException {
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.798 -0400", hash_original_method = "AEBFC898C5450F1ABC3134E881783937", hash_generated_method = "87EBB8BCDE1BCC01B777E56621321E79")
    public  MulticastSocket(int port) throws IOException {
        super(port);
        addTaint(port);
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.798 -0400", hash_original_method = "04DD868DCBB43DC9F285487EAD012BAF", hash_generated_method = "F001036BB26D87CCF7837A6D2AD22D2E")
    public  MulticastSocket(SocketAddress localAddress) throws IOException {
        super(localAddress);
        addTaint(localAddress.getTaint());
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.799 -0400", hash_original_method = "467AD7DD9552F52C52E1B541B5F40FE0", hash_generated_method = "5E048C8BD989ABFA031EECA1C3D761C6")
    public InetAddress getInterface() throws SocketException {
        checkOpen();
        if(setAddress != null)        
        {
InetAddress var78312240CDBFCCC3F04771B2D94D19B8_1730949176 =             setAddress;
            var78312240CDBFCCC3F04771B2D94D19B8_1730949176.addTaint(taint);
            return var78312240CDBFCCC3F04771B2D94D19B8_1730949176;
        } //End block
        InetAddress ipvXaddress = (InetAddress) impl.getOption(SocketOptions.IP_MULTICAST_IF);
        if(ipvXaddress.isAnyLocalAddress())        
        {
            NetworkInterface theInterface = getNetworkInterface();
            if(theInterface != null)            
            {
                Enumeration<InetAddress> addresses = theInterface.getInetAddresses();
                if(addresses != null)                
                {
                    while
(addresses.hasMoreElements())                    
                    {
                        InetAddress nextAddress = addresses.nextElement();
                        if(nextAddress instanceof Inet6Address)                        
                        {
InetAddress var19A3FB9C42B757A160F40F7C37CFD501_105624707 =                             nextAddress;
                            var19A3FB9C42B757A160F40F7C37CFD501_105624707.addTaint(taint);
                            return var19A3FB9C42B757A160F40F7C37CFD501_105624707;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
InetAddress var44E9082E21DD4D2A51E79570976A7A8A_24402108 =         ipvXaddress;
        var44E9082E21DD4D2A51E79570976A7A8A_24402108.addTaint(taint);
        return var44E9082E21DD4D2A51E79570976A7A8A_24402108;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.800 -0400", hash_original_method = "9619F0CC924DAE776456EC0CB550E95C", hash_generated_method = "20C0ABC3CFBF17823D8C630585E78E1B")
    public NetworkInterface getNetworkInterface() throws SocketException {
        checkOpen();
        int index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        if(index != 0)        
        {
NetworkInterface var43F84E7944CA9D14BF0E29EB3235E5CC_233865140 =             NetworkInterface.getByIndex(index);
            var43F84E7944CA9D14BF0E29EB3235E5CC_233865140.addTaint(taint);
            return var43F84E7944CA9D14BF0E29EB3235E5CC_233865140;
        } //End block
NetworkInterface var92F39B46B4CB3D019A4178969874DAFE_2106636668 =         NetworkInterface.forUnboundMulticastSocket();
        var92F39B46B4CB3D019A4178969874DAFE_2106636668.addTaint(taint);
        return var92F39B46B4CB3D019A4178969874DAFE_2106636668;
        // ---------- Original Method ----------
        //checkOpen();
        //int index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        //if (index != 0) {
            //return NetworkInterface.getByIndex(index);
        //}
        //return NetworkInterface.forUnboundMulticastSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.801 -0400", hash_original_method = "115D2F8953DD08E8766DFC64CC7C212D", hash_generated_method = "7DD13CF6B14B02BC5714ABA5B5FDFFB5")
    public int getTimeToLive() throws IOException {
        checkOpen();
        int var5E24BF1313E653ABC196207ACB8FF45F_1144238694 = (impl.getTimeToLive());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901014634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901014634;
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTimeToLive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.802 -0400", hash_original_method = "2ED04886DDF130567B09FF7DB10BF58C", hash_generated_method = "EC722B94B96325C2B31CAE10F3342CAE")
    @Deprecated
    public byte getTTL() throws IOException {
        checkOpen();
        byte var8070E1377BA2A3A48480E94D750140F6_673866640 = (impl.getTTL());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_298456023 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_298456023;
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTTL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.802 -0400", hash_original_method = "2A9249956792D7D287EC6DE49DBB9AA1", hash_generated_method = "0944674FEBBF4CDC68CE620A2A4A81B9")
    public void joinGroup(InetAddress groupAddr) throws IOException {
        addTaint(groupAddr.getTaint());
        checkJoinOrLeave(groupAddr);
        impl.join(groupAddr);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.join(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.803 -0400", hash_original_method = "E3A8AF53901269F90797322614E1EFAB", hash_generated_method = "C79171D11BB95AA0FCE81E251919FD98")
    public void joinGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        addTaint(netInterface.getTaint());
        addTaint(groupAddress.getTaint());
        checkJoinOrLeave(groupAddress, netInterface);
        impl.joinGroup(groupAddress, netInterface);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.joinGroup(groupAddress, netInterface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.803 -0400", hash_original_method = "84DF9FB54D017E3534FF7B79FFC861AD", hash_generated_method = "6B091CBD1BEFB882101D219D562D101F")
    public void leaveGroup(InetAddress groupAddr) throws IOException {
        addTaint(groupAddr.getTaint());
        checkJoinOrLeave(groupAddr);
        impl.leave(groupAddr);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.leave(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.804 -0400", hash_original_method = "5C672C91FEA72835E9232D6CA28DF6E9", hash_generated_method = "53A7058DDD379F1238D32C1AC4E5F955")
    public void leaveGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        addTaint(netInterface.getTaint());
        addTaint(groupAddress.getTaint());
        checkJoinOrLeave(groupAddress, netInterface);
        impl.leaveGroup(groupAddress, netInterface);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.leaveGroup(groupAddress, netInterface);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.805 -0400", hash_original_method = "5D3737731721260F57AF95D7810519A1", hash_generated_method = "CBB8A4F420303A555A6BA7D7FE2813FE")
    private void checkJoinOrLeave(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        addTaint(netInterface.getTaint());
        addTaint(groupAddress.getTaint());
        checkOpen();
        if(groupAddress == null)        
        {
            IllegalArgumentException varDC3E3FF3F6BD9A190E8FB79DD1215D2D_542835549 = new IllegalArgumentException("groupAddress == null");
            varDC3E3FF3F6BD9A190E8FB79DD1215D2D_542835549.addTaint(taint);
            throw varDC3E3FF3F6BD9A190E8FB79DD1215D2D_542835549;
        } //End block
        if(netInterface != null && !netInterface.getInetAddresses().hasMoreElements())        
        {
            SocketException varA8BBC7DCE697829FBEEFA51A5B4E1C75_542602771 = new SocketException("No address associated with interface: " + netInterface);
            varA8BBC7DCE697829FBEEFA51A5B4E1C75_542602771.addTaint(taint);
            throw varA8BBC7DCE697829FBEEFA51A5B4E1C75_542602771;
        } //End block
        if(!(groupAddress instanceof InetSocketAddress))        
        {
            IllegalArgumentException var6D461ECCF3C3B184189A72A4B2D9802B_1881252095 = new IllegalArgumentException("Group address not an InetSocketAddress: " +
                    groupAddress.getClass());
            var6D461ECCF3C3B184189A72A4B2D9802B_1881252095.addTaint(taint);
            throw var6D461ECCF3C3B184189A72A4B2D9802B_1881252095;
        } //End block
        InetAddress groupAddr = ((InetSocketAddress) groupAddress).getAddress();
        if(groupAddr == null)        
        {
            SocketException var1833259C2AD0A59C8B12EC641B29806E_738215265 = new SocketException("Group address has no address: " + groupAddress);
            var1833259C2AD0A59C8B12EC641B29806E_738215265.addTaint(taint);
            throw var1833259C2AD0A59C8B12EC641B29806E_738215265;
        } //End block
        if(!groupAddr.isMulticastAddress())        
        {
            IOException var5140AC881883AC4428CD75EDC6B7198F_1812627219 = new IOException("Not a multicast group: " + groupAddr);
            var5140AC881883AC4428CD75EDC6B7198F_1812627219.addTaint(taint);
            throw var5140AC881883AC4428CD75EDC6B7198F_1812627219;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.806 -0400", hash_original_method = "6596B4EA78B0ED28321084C8CA9DCC77", hash_generated_method = "A40939F5E15D55DEC9C721738978367F")
    private void checkJoinOrLeave(InetAddress groupAddr) throws IOException {
        addTaint(groupAddr.getTaint());
        checkOpen();
        if(!groupAddr.isMulticastAddress())        
        {
            IOException var5140AC881883AC4428CD75EDC6B7198F_1943015491 = new IOException("Not a multicast group: " + groupAddr);
            var5140AC881883AC4428CD75EDC6B7198F_1943015491.addTaint(taint);
            throw var5140AC881883AC4428CD75EDC6B7198F_1943015491;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //if (!groupAddr.isMulticastAddress()) {
            //throw new IOException("Not a multicast group: " + groupAddr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.807 -0400", hash_original_method = "B2C00FA361C879157E99EDF94577EB31", hash_generated_method = "898B80A0BD1A14FEBDF10D8C37D725C2")
    @Deprecated
    public void send(DatagramPacket packet, byte ttl) throws IOException {
        addTaint(ttl);
        addTaint(packet.getTaint());
        checkOpen();
        InetAddress packAddr = packet.getAddress();
        int currTTL = getTimeToLive();
        if(packAddr.isMulticastAddress() && (byte) currTTL != ttl)        
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
        else
        {
            impl.send(packet);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.809 -0400", hash_original_method = "89C8198F5D22E8812FC96CB1AE49CBE2", hash_generated_method = "A0246EC2041EEBBBE0DD27C4801FDB87")
    public void setInterface(InetAddress address) throws SocketException {
        checkOpen();
        if(address == null)        
        {
            NullPointerException var8D4EF061238524D9B0591C939EC42798_440702550 = new NullPointerException("address == null");
            var8D4EF061238524D9B0591C939EC42798_440702550.addTaint(taint);
            throw var8D4EF061238524D9B0591C939EC42798_440702550;
        } //End block
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
        if(networkInterface == null)        
        {
            SocketException var4623A7A72254EA22A1EADFEBDAFE092F_2057335111 = new SocketException("Address not associated with an interface: " + address);
            var4623A7A72254EA22A1EADFEBDAFE092F_2057335111.addTaint(taint);
            throw var4623A7A72254EA22A1EADFEBDAFE092F_2057335111;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.810 -0400", hash_original_method = "103D9F8CED47CA1D8B78CD3F071983B8", hash_generated_method = "B86E5945E2F298FBAD0E0A76D48795E2")
    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        addTaint(networkInterface.getTaint());
        checkOpen();
        if(networkInterface == null)        
        {
            SocketException varF4BD2D007C3B75AA022B00A7D94E34E2_40467659 = new SocketException("networkInterface == null");
            varF4BD2D007C3B75AA022B00A7D94E34E2_40467659.addTaint(taint);
            throw varF4BD2D007C3B75AA022B00A7D94E34E2_40467659;
        } //End block
        impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        this.setAddress = null;
        // ---------- Original Method ----------
        //checkOpen();
        //if (networkInterface == null) {
            //throw new SocketException("networkInterface == null");
        //}
        //impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        //this.setAddress = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.811 -0400", hash_original_method = "87E1DCD7CA258C3733B679C47E824196", hash_generated_method = "6C27278E51B987BF9BB7512A7C033CFE")
    public void setTimeToLive(int ttl) throws IOException {
        addTaint(ttl);
        checkOpen();
        if(ttl < 0 || ttl > 255)        
        {
            IllegalArgumentException varA3BFC4F4A2BC4F4B51A0E909CC51F700_951401325 = new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
            varA3BFC4F4A2BC4F4B51A0E909CC51F700_951401325.addTaint(taint);
            throw varA3BFC4F4A2BC4F4B51A0E909CC51F700_951401325;
        } //End block
        impl.setTimeToLive(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //if (ttl < 0 || ttl > 255) {
            //throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        //}
        //impl.setTimeToLive(ttl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.812 -0400", hash_original_method = "5513CDD24FF579269A679F40508B01F6", hash_generated_method = "E8221AE49B47B8A996466933E1CBF6B0")
    @Deprecated
    public void setTTL(byte ttl) throws IOException {
        addTaint(ttl);
        checkOpen();
        impl.setTTL(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setTTL(ttl);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.813 -0400", hash_original_method = "EBCEB6AAB2ED917FE096C1D1630BA905", hash_generated_method = "FC3BB31DCA0918B6BE7F82F5D18150FD")
    @Override
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        addTaint(addr.getTaint());
        addTaint(aPort);
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
            e.addTaint(taint);
            throw e;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.814 -0400", hash_original_method = "DC4B33B8ADF09E78AF384B12E0911A9B", hash_generated_method = "4BC6A13C4609C6658C10C0844BFEB84A")
    public boolean getLoopbackMode() throws SocketException {
        checkOpen();
        boolean var4207F20481139554418AE371EDD1EBCE_677520042 = (!((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358319687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358319687;
        // ---------- Original Method ----------
        //checkOpen();
        //return !((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.814 -0400", hash_original_method = "3AC1197302083655B98FC683162962C9", hash_generated_method = "67F609CD3A59A6BCB90429A5AFB0DBDC")
    public void setLoopbackMode(boolean disable) throws SocketException {
        addTaint(disable);
        checkOpen();
        impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
    }

    
}

