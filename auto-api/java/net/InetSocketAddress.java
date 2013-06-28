package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InetSocketAddress extends SocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.340 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.340 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.340 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.340 -0400", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "D6A8A6FF7A7F9DF0030B1E8520AD5301")
    public  InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        // ---------- Original Method ----------
        //this.addr = null;
        //this.hostname = null;
        //this.port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.341 -0400", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "A47176D4EA4DC38BCEA4A38EAF031A75")
    public  InetSocketAddress(int port) {
        this((InetAddress) null, port);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.345 -0400", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "55D342B6DAFF1A4B8058A2CDA11585CD")
    public  InetSocketAddress(InetAddress address, int port) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("port=" + port);
        } //End block
        this.addr = (address == null) ? Inet4Address.ANY : address;
        this.hostname = null;
        this.port = port;
        // ---------- Original Method ----------
        //if (port < 0 || port > 65535) {
            //throw new IllegalArgumentException("port=" + port);
        //}
        //this.addr = (address == null) ? Inet4Address.ANY : address;
        //this.hostname = null;
        //this.port = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.346 -0400", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "53913BFDEB53BF8ACB1FE37F2F93B93D")
    public  InetSocketAddress(String host, int port) {
        this(host, port, true);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.347 -0400", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "20481F7916D9FE7BF90C514CD6DDEBCF")
      InetSocketAddress(String hostname, int port, boolean needResolved) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        } //End block
        InetAddress addr = null;
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
        this.hostname = hostname;
        this.port = port;
        addTaint(needResolved);
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

    
    public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(host, port, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.348 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "686246548CEB1A60B173E8FDE03DFBA3")
    public final int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608007257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608007257;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.349 -0400", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "0C99CF06EF03929D1A4F161388FF2714")
    public final InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_255273767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_255273767 = addr;
        varB4EAC82CA7396A68D541C85D26508E83_255273767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255273767;
        // ---------- Original Method ----------
        //return addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.349 -0400", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "94114946FB36D638A473C89918980B0E")
    public final String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_439769072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439769072 = (addr != null) ? addr.getHostName() : hostname;
        varB4EAC82CA7396A68D541C85D26508E83_439769072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439769072;
        // ---------- Original Method ----------
        //return (addr != null) ? addr.getHostName() : hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.349 -0400", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "D264F11425D9B9520EFF68DBD3076536")
    public final String getHostString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1806283465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1806283465 = (hostname != null) ? hostname : addr.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1806283465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1806283465;
        // ---------- Original Method ----------
        //return (hostname != null) ? hostname : addr.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.350 -0400", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "01E94D2B796644DAC76B1D1E93CB7703")
    public final boolean isUnresolved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790559341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790559341;
        // ---------- Original Method ----------
        //return addr == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.350 -0400", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "CED0D94A754200B284DF70D46C86F31F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_653319737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_653319737 = ((addr != null) ? addr.toString() : hostname) + ":" + port;
        varB4EAC82CA7396A68D541C85D26508E83_653319737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_653319737;
        // ---------- Original Method ----------
        //return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.350 -0400", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "01890A97F28F15B3A35B7BF52FD89F6F")
    @Override
    public final boolean equals(Object socketAddr) {
        InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;
        {
            boolean var3B82B4739FCD596C14527ADF43C9BB37_637317055 = (hostname.equals(iSockAddr.hostname));
        } //End block
        boolean var6FA612700D7A8E1504050944C0551B2F_1911592756 = (addr.equals(iSockAddr.addr));
        addTaint(socketAddr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842353068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842353068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.351 -0400", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "2E46F8764AAE6219735E993B2FEFB262")
    @Override
    public final int hashCode() {
        {
            int var54904730027C7FDA2FE45B7D0D3F5802_569139583 = (hostname.hashCode() + port);
        } //End block
        int varC52E3B425034D138439CCAB4739F0072_26141769 = (addr.hashCode() + port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026518035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026518035;
        // ---------- Original Method ----------
        //if (addr == null) {
            //return hostname.hashCode() + port;
        //}
        //return addr.hashCode() + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.351 -0400", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "D5A8E0129EC7516A4038EB463EBBA693")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.351 -0400", hash_original_field = "8AABC4CEB9087CA4231164B288223D7A", hash_generated_field = "CA65D985F490176D565176BDD0E73685")

    private static final long serialVersionUID = 5076001401234631237L;
}

