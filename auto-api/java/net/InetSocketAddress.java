package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;

public class InetSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 5076001401234631237L;
    private InetAddress addr;
    private String hostname;
    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "BE78D5122142812F375C65B274F89AAD")
    @DSModeled(DSC.SAFE)
    public InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        // ---------- Original Method ----------
        //this.addr = null;
        //this.hostname = null;
        //this.port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "A8E780D4FC6530ABA9CA690DFB002FE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetSocketAddress(int port) {
        this((InetAddress) null, port);
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "49FA611A8C81254042163D58C52140FA")
    @DSModeled(DSC.SAFE)
    public InetSocketAddress(InetAddress address, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("port=" + port);
        } //End block
        this.addr = (address == null) ? Inet4Address.ANY : address;
        this.hostname = null;
        // ---------- Original Method ----------
        //if (port < 0 || port > 65535) {
            //throw new IllegalArgumentException("port=" + port);
        //}
        //this.addr = (address == null) ? Inet4Address.ANY : address;
        //this.hostname = null;
        //this.port = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "61CD9388724923D52CBF8A0A59A24D5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetSocketAddress(String host, int port) {
        this(host, port, true);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "0D944917473325E181F95783E75F10F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InetSocketAddress(String hostname, int port, boolean needResolved) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(needResolved);
        dsTaint.addTaint(hostname);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        } //End block
        InetAddress addr;
        addr = null;
        {
            try 
            {
                addr = InetAddress.getByName(hostname);
                hostname = null;
            } //End block
            catch (UnknownHostException ignored)
            { }
        } //End block
        this.addr = addr;
        // ---------- Original Method ----------
        //if (hostname == null || port < 0 || port > 65535) {
            //throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        //}
        //InetAddress addr = null;
        //if (needResolved) {
            //try {
                //addr = InetAddress.getByName(hostname);
                //hostname = null;
            //} catch (UnknownHostException ignored) {
            //}
        //}
        //this.addr = addr;
        //this.hostname = hostname;
        //this.port = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "D59CB5797FE9FDEEAB13B54DF3C64F08", hash_generated_method = "B3021AE91BF852E930D2D98E82380796")
    public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(host, port, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "F0363CA6E15DF39AC9E825A9F1003596")
    @DSModeled(DSC.SAFE)
    public final int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "B33102DF0BF38E2B336125836A8B4B81")
    @DSModeled(DSC.SAFE)
    public final InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.241 -0400", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "539F6011F70A1AB9E7AAF1581C2B82E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getHostName() {
        {
            Object varE653169325A358B014DF0B00755562BB_1645522582 = (addr.getHostName());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (addr != null) ? addr.getHostName() : hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "CC2747C273DC3902D2F4E26ECC021672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getHostString() {
        {
            Object varA21D5A0F2A9EB6E2550C23B5F9E0C851_1879702086 = (addr.getHostAddress());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (hostname != null) ? hostname : addr.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "3CD0603AC4D83B932115832119C829B6")
    @DSModeled(DSC.SAFE)
    public final boolean isUnresolved() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addr == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "490541BE10DB5CBB8ED567FD40103F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var665C07C6BF613767EDF9B8458BBE60BC_710831649 = (((addr != null) ? addr.toString() : hostname) + ":" + port); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "807A9594A0A8A132FD89A611E94039BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object socketAddr) {
        dsTaint.addTaint(socketAddr.dsTaint);
        InetSocketAddress iSockAddr;
        iSockAddr = (InetSocketAddress) socketAddr;
        {
            boolean var3B82B4739FCD596C14527ADF43C9BB37_871451953 = (hostname.equals(iSockAddr.hostname));
        } //End block
        boolean var6FA612700D7A8E1504050944C0551B2F_1778796471 = (addr.equals(iSockAddr.addr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == socketAddr) {
            //return true;
        //}
        //if (!(socketAddr instanceof InetSocketAddress)) {
            //return false;
        //}
        //InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;
        //if (port != iSockAddr.port) {
            //return false;
        //}
        //if ((addr == null) && (iSockAddr.addr == null)) {
            //return hostname.equals(iSockAddr.hostname);
        //}
        //if (addr == null) {
            //return false;
        //}
        //return addr.equals(iSockAddr.addr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "99B26314DC610CA0B9239A92F4A15F7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        {
            int var54904730027C7FDA2FE45B7D0D3F5802_611096753 = (hostname.hashCode() + port);
        } //End block
        int varC52E3B425034D138439CCAB4739F0072_2094484332 = (addr.hashCode() + port);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (addr == null) {
            //return hostname.hashCode() + port;
        //}
        //return addr.hashCode() + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.242 -0400", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "C53B51CC5D92E156CA65E3BF45B4C452")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        // ---------- Original Method ----------
        //stream.defaultReadObject();
    }

    
}


