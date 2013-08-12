package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;






public class InetSocketAddress extends SocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.694 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.694 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.695 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.695 -0400", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "D6A8A6FF7A7F9DF0030B1E8520AD5301")
    public  InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        // ---------- Original Method ----------
        //this.addr = null;
        //this.hostname = null;
        //this.port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.696 -0400", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "A47176D4EA4DC38BCEA4A38EAF031A75")
    public  InetSocketAddress(int port) {
        this((InetAddress) null, port);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.697 -0400", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "24D4F5688495039847A193F72239DB29")
    public  InetSocketAddress(InetAddress address, int port) {
        if(port < 0 || port > 65535)        
        {
            IllegalArgumentException var85A8ACB08F64870E8355BDC8963AF636_609099244 = new IllegalArgumentException("port=" + port);
            var85A8ACB08F64870E8355BDC8963AF636_609099244.addTaint(taint);
            throw var85A8ACB08F64870E8355BDC8963AF636_609099244;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.697 -0400", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "AAE39BB1651B916EC3C89DB87B8FB535")
    public  InetSocketAddress(String host, int port) {
        this(host, port, true);
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.699 -0400", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "EA0B2876AF6FA286FA924CF3262C5FED")
      InetSocketAddress(String hostname, int port, boolean needResolved) {
        addTaint(needResolved);
        if(hostname == null || port < 0 || port > 65535)        
        {
            IllegalArgumentException var6CDF6FA7F951A63D323FEB16F3FFED6C_1162735188 = new IllegalArgumentException("host=" + hostname + ", port=" + port);
            var6CDF6FA7F951A63D323FEB16F3FFED6C_1162735188.addTaint(taint);
            throw var6CDF6FA7F951A63D323FEB16F3FFED6C_1162735188;
        } //End block
        InetAddress addr = null;
        if(needResolved)        
        {
            try 
            {
                addr = InetAddress.getByName(hostname);
                hostname = null;
            } //End block
            catch (UnknownHostException ignored)
            {
            } //End block
        } //End block
        this.addr = addr;
        this.hostname = hostname;
        this.port = port;
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

    
    @DSModeled(DSC.SAFE)
    public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(host, port, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.700 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "C5E80346E961E14B78747C6E09CC79A5")
    public final int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1339703200 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295345340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295345340;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.700 -0400", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "8D8B5EFB6649A195601B0E4D839BB2D6")
    public final InetAddress getAddress() {
InetAddress var93F8352EAB50DBA73F526833D82E48F9_659594681 =         addr;
        var93F8352EAB50DBA73F526833D82E48F9_659594681.addTaint(taint);
        return var93F8352EAB50DBA73F526833D82E48F9_659594681;
        // ---------- Original Method ----------
        //return addr;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.701 -0400", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "182ABDE68546DECC752CD70F20A26CF1")
    public final String getHostName() {
String varAC60CAEE0ED0B1E182673A2E3E7A6307_1567749775 =         (addr != null) ? addr.getHostName() : hostname;
        varAC60CAEE0ED0B1E182673A2E3E7A6307_1567749775.addTaint(taint);
        return varAC60CAEE0ED0B1E182673A2E3E7A6307_1567749775;
        // ---------- Original Method ----------
        //return (addr != null) ? addr.getHostName() : hostname;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.701 -0400", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "20B17B93B0A9799B58880BA9E6D72148")
    public final String getHostString() {
String varA176FBB649535D87C7C729399E998756_1767560490 =         (hostname != null) ? hostname : addr.getHostAddress();
        varA176FBB649535D87C7C729399E998756_1767560490.addTaint(taint);
        return varA176FBB649535D87C7C729399E998756_1767560490;
        // ---------- Original Method ----------
        //return (hostname != null) ? hostname : addr.getHostAddress();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.701 -0400", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "6B025878AC95B0E7FDF1D3A442F9884A")
    public final boolean isUnresolved() {
        boolean varAF772B268FBA8C120460CEDF303B798C_83209549 = (addr == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235510768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235510768;
        // ---------- Original Method ----------
        //return addr == null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.702 -0400", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "40006086B41EA0656E88A7CC9ADA615B")
    @Override
    public String toString() {
String var1B7CAFC033DE18D29F647AE499B2444D_593277045 =         ((addr != null) ? addr.toString() : hostname) + ":" + port;
        var1B7CAFC033DE18D29F647AE499B2444D_593277045.addTaint(taint);
        return var1B7CAFC033DE18D29F647AE499B2444D_593277045;
        // ---------- Original Method ----------
        //return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.703 -0400", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "B6453D233C2695912BF9A7AA2605051E")
    @Override
    public final boolean equals(Object socketAddr) {
        addTaint(socketAddr.getTaint());
        if(this == socketAddr)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2047641167 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597044239 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597044239;
        } //End block
        if(!(socketAddr instanceof InetSocketAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1094673076 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932867517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932867517;
        } //End block
        InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;
        if(port != iSockAddr.port)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1465284174 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249726572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249726572;
        } //End block
        if((addr == null) && (iSockAddr.addr == null))        
        {
            boolean varBAB89A7C24C90095B361AC56141979C1_650009258 = (hostname.equals(iSockAddr.hostname));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215619430 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215619430;
        } //End block
        if(addr == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_753705501 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916881506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916881506;
        } //End block
        boolean var625AACD729EAE77DCC7B80EB17B04339_1561527541 = (addr.equals(iSockAddr.addr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716503043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716503043;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.705 -0400", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "0A5AECDD2FC9A80B1DADBBCEE8A4EEBE")
    @Override
    public final int hashCode() {
        if(addr == null)        
        {
            int var6A7487EEFDF19E84AC70A27C0BADA2F0_26875760 = (hostname.hashCode() + port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794058361 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794058361;
        } //End block
        int var00EDC9A626FBDEBADB981528C3D06165_1315910229 = (addr.hashCode() + port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107945453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107945453;
        // ---------- Original Method ----------
        //if (addr == null) {
            //return hostname.hashCode() + port;
        //}
        //return addr.hashCode() + port;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.705 -0400", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "F24508607C5B504D65DD7E44716575A0")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        // ---------- Original Method ----------
        //stream.defaultReadObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.706 -0400", hash_original_field = "8AABC4CEB9087CA4231164B288223D7A", hash_generated_field = "CA65D985F490176D565176BDD0E73685")

    private static final long serialVersionUID = 5076001401234631237L;
}

