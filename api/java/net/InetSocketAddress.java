package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InetSocketAddress extends SocketAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.798 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.798 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.798 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.799 -0400", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "D6A8A6FF7A7F9DF0030B1E8520AD5301")
    public  InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        // ---------- Original Method ----------
        //this.addr = null;
        //this.hostname = null;
        //this.port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.799 -0400", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "A47176D4EA4DC38BCEA4A38EAF031A75")
    public  InetSocketAddress(int port) {
        this((InetAddress) null, port);
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.800 -0400", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "DFA95EBF69C5FFC3F032CBA3CA0E77BF")
    public  InetSocketAddress(InetAddress address, int port) {
    if(port < 0 || port > 65535)        
        {
            IllegalArgumentException var85A8ACB08F64870E8355BDC8963AF636_1666235347 = new IllegalArgumentException("port=" + port);
            var85A8ACB08F64870E8355BDC8963AF636_1666235347.addTaint(taint);
            throw var85A8ACB08F64870E8355BDC8963AF636_1666235347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.801 -0400", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "AAE39BB1651B916EC3C89DB87B8FB535")
    public  InetSocketAddress(String host, int port) {
        this(host, port, true);
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.802 -0400", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "266247CF7550C143E52F4806800F2A71")
      InetSocketAddress(String hostname, int port, boolean needResolved) {
        addTaint(needResolved);
    if(hostname == null || port < 0 || port > 65535)        
        {
            IllegalArgumentException var6CDF6FA7F951A63D323FEB16F3FFED6C_473371318 = new IllegalArgumentException("host=" + hostname + ", port=" + port);
            var6CDF6FA7F951A63D323FEB16F3FFED6C_473371318.addTaint(taint);
            throw var6CDF6FA7F951A63D323FEB16F3FFED6C_473371318;
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

    
        public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(host, port, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.803 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "9163F55A04A1D73267D90A6F9C7C16D5")
    public final int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1198874680 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766950991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766950991;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.803 -0400", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "4F7CC6E08A4471C054DFEF1D3CF80900")
    public final InetAddress getAddress() {
InetAddress var93F8352EAB50DBA73F526833D82E48F9_397726426 =         addr;
        var93F8352EAB50DBA73F526833D82E48F9_397726426.addTaint(taint);
        return var93F8352EAB50DBA73F526833D82E48F9_397726426;
        // ---------- Original Method ----------
        //return addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.804 -0400", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "B33E41E2109FEDF6D809A68435713E80")
    public final String getHostName() {
String varAC60CAEE0ED0B1E182673A2E3E7A6307_893171917 =         (addr != null) ? addr.getHostName() : hostname;
        varAC60CAEE0ED0B1E182673A2E3E7A6307_893171917.addTaint(taint);
        return varAC60CAEE0ED0B1E182673A2E3E7A6307_893171917;
        // ---------- Original Method ----------
        //return (addr != null) ? addr.getHostName() : hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.804 -0400", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "4A349D9CB0C9DE267D6A32619C933655")
    public final String getHostString() {
String varA176FBB649535D87C7C729399E998756_1281109013 =         (hostname != null) ? hostname : addr.getHostAddress();
        varA176FBB649535D87C7C729399E998756_1281109013.addTaint(taint);
        return varA176FBB649535D87C7C729399E998756_1281109013;
        // ---------- Original Method ----------
        //return (hostname != null) ? hostname : addr.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.804 -0400", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "B1058DF8346D23F1852FE68BC315BAC8")
    public final boolean isUnresolved() {
        boolean varAF772B268FBA8C120460CEDF303B798C_1292870208 = (addr == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917602495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917602495;
        // ---------- Original Method ----------
        //return addr == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.805 -0400", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "96E34404E7E1B0654BC24FCB7AC3468E")
    @Override
    public String toString() {
String var1B7CAFC033DE18D29F647AE499B2444D_551237079 =         ((addr != null) ? addr.toString() : hostname) + ":" + port;
        var1B7CAFC033DE18D29F647AE499B2444D_551237079.addTaint(taint);
        return var1B7CAFC033DE18D29F647AE499B2444D_551237079;
        // ---------- Original Method ----------
        //return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.805 -0400", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "9BFFCD5F5A7A6410EB0A702BD2A7CCAA")
    @Override
    public final boolean equals(Object socketAddr) {
        addTaint(socketAddr.getTaint());
    if(this == socketAddr)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1113278648 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104587834 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104587834;
        } //End block
    if(!(socketAddr instanceof InetSocketAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_865555202 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703524657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_703524657;
        } //End block
        InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;
    if(port != iSockAddr.port)        
        {
            boolean var68934A3E9455FA72420237EB05902327_984221644 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532754372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_532754372;
        } //End block
    if((addr == null) && (iSockAddr.addr == null))        
        {
            boolean varBAB89A7C24C90095B361AC56141979C1_1911578426 = (hostname.equals(iSockAddr.hostname));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459445365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459445365;
        } //End block
    if(addr == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_235069207 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776697712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776697712;
        } //End block
        boolean var625AACD729EAE77DCC7B80EB17B04339_1795315201 = (addr.equals(iSockAddr.addr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121072492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121072492;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.806 -0400", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "5BB230824ED06E1F55032FD0C39FC164")
    @Override
    public final int hashCode() {
    if(addr == null)        
        {
            int var6A7487EEFDF19E84AC70A27C0BADA2F0_16127556 = (hostname.hashCode() + port);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756857787 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756857787;
        } //End block
        int var00EDC9A626FBDEBADB981528C3D06165_1050192754 = (addr.hashCode() + port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930092101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930092101;
        // ---------- Original Method ----------
        //if (addr == null) {
            //return hostname.hashCode() + port;
        //}
        //return addr.hashCode() + port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.807 -0400", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "F24508607C5B504D65DD7E44716575A0")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        // ---------- Original Method ----------
        //stream.defaultReadObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.807 -0400", hash_original_field = "8AABC4CEB9087CA4231164B288223D7A", hash_generated_field = "CA65D985F490176D565176BDD0E73685")

    private static final long serialVersionUID = 5076001401234631237L;
}

