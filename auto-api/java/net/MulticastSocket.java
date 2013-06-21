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
    private InetAddress setAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.944 -0400", hash_original_method = "E00E381299DD101E8388BF5692519367", hash_generated_method = "6344D883D7E184B34B1618995D02B96E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MulticastSocket() throws IOException {
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.944 -0400", hash_original_method = "AEBFC898C5450F1ABC3134E881783937", hash_generated_method = "6F8C7FF9689AD16343763A4896F4FB81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MulticastSocket(int port) throws IOException {
        super(port);
        dsTaint.addTaint(port);
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.945 -0400", hash_original_method = "04DD868DCBB43DC9F285487EAD012BAF", hash_generated_method = "1FE81E8B2CEA8B7DE645975D8FC5C941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MulticastSocket(SocketAddress localAddress) throws IOException {
        super(localAddress);
        dsTaint.addTaint(localAddress.dsTaint);
        setReuseAddress(true);
        // ---------- Original Method ----------
        //setReuseAddress(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.945 -0400", hash_original_method = "467AD7DD9552F52C52E1B541B5F40FE0", hash_generated_method = "8F8D4C133668798382BDBEA3504CD82A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInterface() throws SocketException {
        checkOpen();
        InetAddress ipvXaddress;
        ipvXaddress = (InetAddress) impl.getOption(SocketOptions.IP_MULTICAST_IF);
        {
            boolean var110FBA367A6CAF2439B7CCD5FE128683_156205747 = (ipvXaddress.isAnyLocalAddress());
            {
                NetworkInterface theInterface;
                theInterface = getNetworkInterface();
                {
                    Enumeration<InetAddress> addresses;
                    addresses = theInterface.getInetAddresses();
                    {
                        {
                            boolean varDFF60DB25A496BFFEE32B4F3AB44E179_1541911033 = (addresses.hasMoreElements());
                            {
                                InetAddress nextAddress;
                                nextAddress = addresses.nextElement();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.945 -0400", hash_original_method = "9619F0CC924DAE776456EC0CB550E95C", hash_generated_method = "222410746A44B710299F89BD003039B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInterface getNetworkInterface() throws SocketException {
        checkOpen();
        int index;
        index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        {
            NetworkInterface var993CD675654B0F281CB793E4232D9C23_703933909 = (NetworkInterface.getByIndex(index));
        } //End block
        NetworkInterface varF3E86AD9E6A4EC992BDC1886A092F787_1350632153 = (NetworkInterface.forUnboundMulticastSocket());
        return (NetworkInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpen();
        //int index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        //if (index != 0) {
            //return NetworkInterface.getByIndex(index);
        //}
        //return NetworkInterface.forUnboundMulticastSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.945 -0400", hash_original_method = "115D2F8953DD08E8766DFC64CC7C212D", hash_generated_method = "E246AAF8698D28B2102C03D211FB93FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeToLive() throws IOException {
        checkOpen();
        int var6981648A3805519BB38588D233DBE717_453121783 = (impl.getTimeToLive());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTimeToLive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.946 -0400", hash_original_method = "2ED04886DDF130567B09FF7DB10BF58C", hash_generated_method = "DC599E3A98206CFC0F5C9E41FE6EC82A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public byte getTTL() throws IOException {
        checkOpen();
        byte var21FABDC4F3977645D00C46337AF407A5_756410544 = (impl.getTTL());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkOpen();
        //return impl.getTTL();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.946 -0400", hash_original_method = "2A9249956792D7D287EC6DE49DBB9AA1", hash_generated_method = "B00CFEEA863352F7A5C17192CC897639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void joinGroup(InetAddress groupAddr) throws IOException {
        dsTaint.addTaint(groupAddr.dsTaint);
        checkJoinOrLeave(groupAddr);
        impl.join(groupAddr);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.join(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.946 -0400", hash_original_method = "E3A8AF53901269F90797322614E1EFAB", hash_generated_method = "71E0EBC95344DF3A50B776F094C69509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void joinGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        dsTaint.addTaint(netInterface.dsTaint);
        dsTaint.addTaint(groupAddress.dsTaint);
        checkJoinOrLeave(groupAddress, netInterface);
        impl.joinGroup(groupAddress, netInterface);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.joinGroup(groupAddress, netInterface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.946 -0400", hash_original_method = "84DF9FB54D017E3534FF7B79FFC861AD", hash_generated_method = "599C73B354F70A55D3CF2625F36828C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void leaveGroup(InetAddress groupAddr) throws IOException {
        dsTaint.addTaint(groupAddr.dsTaint);
        checkJoinOrLeave(groupAddr);
        impl.leave(groupAddr);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddr);
        //impl.leave(groupAddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.946 -0400", hash_original_method = "5C672C91FEA72835E9232D6CA28DF6E9", hash_generated_method = "EF8A2E7FBBFE4E398EEFDAAB675F083D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void leaveGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        dsTaint.addTaint(netInterface.dsTaint);
        dsTaint.addTaint(groupAddress.dsTaint);
        checkJoinOrLeave(groupAddress, netInterface);
        impl.leaveGroup(groupAddress, netInterface);
        // ---------- Original Method ----------
        //checkJoinOrLeave(groupAddress, netInterface);
        //impl.leaveGroup(groupAddress, netInterface);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.947 -0400", hash_original_method = "5D3737731721260F57AF95D7810519A1", hash_generated_method = "85EED1C80B7F878A76204FF62A79B835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkJoinOrLeave(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        dsTaint.addTaint(netInterface.dsTaint);
        dsTaint.addTaint(groupAddress.dsTaint);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("groupAddress == null");
        } //End block
        {
            boolean var51868208D871CAD688D045D5994E5703_1711888401 = (netInterface != null && !netInterface.getInetAddresses().hasMoreElements());
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
            boolean varEDC6F8254C9C0286DEE9E460F974EF8F_2034894344 = (!groupAddr.isMulticastAddress());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Not a multicast group: " + groupAddr);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.947 -0400", hash_original_method = "6596B4EA78B0ED28321084C8CA9DCC77", hash_generated_method = "9DACE5BE64BEB0B835AD3FB2FC20FEDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkJoinOrLeave(InetAddress groupAddr) throws IOException {
        dsTaint.addTaint(groupAddr.dsTaint);
        checkOpen();
        {
            boolean varEDC6F8254C9C0286DEE9E460F974EF8F_187970212 = (!groupAddr.isMulticastAddress());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Not a multicast group: " + groupAddr);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkOpen();
        //if (!groupAddr.isMulticastAddress()) {
            //throw new IOException("Not a multicast group: " + groupAddr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.947 -0400", hash_original_method = "B2C00FA361C879157E99EDF94577EB31", hash_generated_method = "76683CAD084495F3D5087215A4174D19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void send(DatagramPacket packet, byte ttl) throws IOException {
        dsTaint.addTaint(packet.dsTaint);
        dsTaint.addTaint(ttl);
        checkOpen();
        InetAddress packAddr;
        packAddr = packet.getAddress();
        int currTTL;
        currTTL = getTimeToLive();
        {
            boolean var34C3FA09B2E514266A2C38DF6E52C4B1_1598028765 = (packAddr.isMulticastAddress() && (byte) currTTL != ttl);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.948 -0400", hash_original_method = "89C8198F5D22E8812FC96CB1AE49CBE2", hash_generated_method = "F6FD6921281035496CB6D4E96567DFC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInterface(InetAddress address) throws SocketException {
        dsTaint.addTaint(address.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.948 -0400", hash_original_method = "103D9F8CED47CA1D8B78CD3F071983B8", hash_generated_method = "F3FE849DD64218C68E2216212AD53D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        dsTaint.addTaint(networkInterface.dsTaint);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new SocketException("networkInterface == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.948 -0400", hash_original_method = "87E1DCD7CA258C3733B679C47E824196", hash_generated_method = "90F7CF8866CCE5D0253E8E30EF23D6F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeToLive(int ttl) throws IOException {
        dsTaint.addTaint(ttl);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        } //End block
        impl.setTimeToLive(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //if (ttl < 0 || ttl > 255) {
            //throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        //}
        //impl.setTimeToLive(ttl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.948 -0400", hash_original_method = "5513CDD24FF579269A679F40508B01F6", hash_generated_method = "A43DA1FC408C0314C4C5BBC70DE4FB82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setTTL(byte ttl) throws IOException {
        dsTaint.addTaint(ttl);
        checkOpen();
        impl.setTTL(ttl);
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setTTL(ttl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.949 -0400", hash_original_method = "EBCEB6AAB2ED917FE096C1D1630BA905", hash_generated_method = "C9D460F2C3C4DDA281D4BEA2C14EF8E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        dsTaint.addTaint(addr.dsTaint);
        dsTaint.addTaint(aPort);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.949 -0400", hash_original_method = "DC4B33B8ADF09E78AF384B12E0911A9B", hash_generated_method = "0F59F4D82764F096528C801523360BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getLoopbackMode() throws SocketException {
        checkOpen();
        boolean var9F17B8B0C8660863198CB1597BEE44E9_2113826847 = (!((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkOpen();
        //return !((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.949 -0400", hash_original_method = "3AC1197302083655B98FC683162962C9", hash_generated_method = "4C8A00A7D1FC439CA38E25DAEA260B5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLoopbackMode(boolean disable) throws SocketException {
        dsTaint.addTaint(disable);
        checkOpen();
        impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
        // ---------- Original Method ----------
        //checkOpen();
        //impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
    }

    
}

