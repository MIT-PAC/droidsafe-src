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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.273 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.273 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.273 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.274 -0400", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "D6A8A6FF7A7F9DF0030B1E8520AD5301")
    public  InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        // ---------- Original Method ----------
        //this.addr = null;
        //this.hostname = null;
        //this.port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.274 -0400", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "A47176D4EA4DC38BCEA4A38EAF031A75")
    public  InetSocketAddress(int port) {
        this((InetAddress) null, port);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.274 -0400", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "55D342B6DAFF1A4B8058A2CDA11585CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.275 -0400", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "53913BFDEB53BF8ACB1FE37F2F93B93D")
    public  InetSocketAddress(String host, int port) {
        this(host, port, true);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.275 -0400", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "1D51A5480FF64409B3DD30EE76ADDC77")
      InetSocketAddress(String hostname, int port, boolean needResolved) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.283 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "367C47B698617F02541FD091CBAB9BC7")
    public final int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694942001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694942001;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.288 -0400", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "479C7D207F70EC1CD47D3CC55C1E9228")
    public final InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1677629217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1677629217 = addr;
        varB4EAC82CA7396A68D541C85D26508E83_1677629217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677629217;
        // ---------- Original Method ----------
        //return addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.288 -0400", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "709A50BC8F490F89434D082D88C46E49")
    public final String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049123339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049123339 = (addr != null) ? addr.getHostName() : hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1049123339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049123339;
        // ---------- Original Method ----------
        //return (addr != null) ? addr.getHostName() : hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.289 -0400", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "3B6B7E55955435D8DEF51B087EA6D54B")
    public final String getHostString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1347028241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1347028241 = (hostname != null) ? hostname : addr.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1347028241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347028241;
        // ---------- Original Method ----------
        //return (hostname != null) ? hostname : addr.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.289 -0400", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "3F9C4F0607AE3935E8F0588B17E0A623")
    public final boolean isUnresolved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317189753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_317189753;
        // ---------- Original Method ----------
        //return addr == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.289 -0400", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "CF8F1A3B30B8ED5531767AFB2D801EE4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_660852225 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_660852225 = ((addr != null) ? addr.toString() : hostname) + ":" + port;
        varB4EAC82CA7396A68D541C85D26508E83_660852225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_660852225;
        // ---------- Original Method ----------
        //return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.305 -0400", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "03DF2DBB9494DEEEB2256999F30CC1C7")
    @Override
    public final boolean equals(Object socketAddr) {
        InetSocketAddress iSockAddr;
        iSockAddr = (InetSocketAddress) socketAddr;
        {
            boolean var3B82B4739FCD596C14527ADF43C9BB37_1105808481 = (hostname.equals(iSockAddr.hostname));
        } //End block
        boolean var6FA612700D7A8E1504050944C0551B2F_784215482 = (addr.equals(iSockAddr.addr));
        addTaint(socketAddr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472436431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472436431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.305 -0400", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "FE78375C9526DB7E3B83854972C1BEF5")
    @Override
    public final int hashCode() {
        {
            int var54904730027C7FDA2FE45B7D0D3F5802_875585757 = (hostname.hashCode() + port);
        } //End block
        int varC52E3B425034D138439CCAB4739F0072_1594023260 = (addr.hashCode() + port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284073681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284073681;
        // ---------- Original Method ----------
        //if (addr == null) {
            //return hostname.hashCode() + port;
        //}
        //return addr.hashCode() + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.305 -0400", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "D5A8E0129EC7516A4038EB463EBBA693")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.306 -0400", hash_original_field = "8AABC4CEB9087CA4231164B288223D7A", hash_generated_field = "CF6FC5BAA720179133699F4A86A36D6A")

    private static long serialVersionUID = 5076001401234631237L;
}

