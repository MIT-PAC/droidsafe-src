package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Proxy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.122 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "0493BBFB1288023B7B163197BF9857A6")

    private Proxy.Type type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.122 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "E0A43CBF82D512E62F9819C96F9107F8")

    private SocketAddress address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.123 -0400", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "7498AB28D5E4D0AACA028E9FE8796E82")
    public  Proxy(Proxy.Type type, SocketAddress sa) {
    if(type == Type.DIRECT || sa == null)        
        {
            IllegalArgumentException varC693C0D94036BD60AD6E26795E42BD6A_1517318827 = new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
            varC693C0D94036BD60AD6E26795E42BD6A_1517318827.addTaint(taint);
            throw varC693C0D94036BD60AD6E26795E42BD6A_1517318827;
        } //End block
        this.type = type;
        address = sa;
        // ---------- Original Method ----------
        //if (type == Type.DIRECT || sa == null) {
            //throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        //}
        //this.type = type;
        //address = sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.123 -0400", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "3B8506530C1D1E82DA5460F730015C73")
    private  Proxy() {
        type = Type.DIRECT;
        address = null;
        // ---------- Original Method ----------
        //type = Type.DIRECT;
        //address = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.124 -0400", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "AB41055AA664DE42225454C7FBC6C287")
    public Proxy.Type type() {
Proxy.Type varC5B9F25B4EEAD3E8E2C33F9429204397_554150066 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_554150066.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_554150066;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.124 -0400", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "E4DBB9D2383DA33EA178E577345FB3FA")
    public SocketAddress address() {
SocketAddress var814577DDD37BAFB17E08CBEFDB411BAE_1258775609 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1258775609.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1258775609;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.124 -0400", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "6AE99F325FE7D4AB9D7EE4C4DAC61B59")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
    if(type != null)        
        {
            builder.append(type.toString());
        } //End block
        builder.append("@");
    if(type != Proxy.Type.DIRECT && address != null)        
        {
            builder.append(address.toString());
        } //End block
String varF4CF030572656354ACFDF83FEE21D7A6_1417552500 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1417552500.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1417552500;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //if (type != null) {
            //builder.append(type.toString());
        //}
        //builder.append("@");
        //if (type != Proxy.Type.DIRECT && address != null) {
            //builder.append(address.toString());
        //}
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.125 -0400", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "7315EB1C91B53ED6744CC12B80883F20")
    @Override
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1338303090 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106247437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106247437;
        } //End block
    if(!(obj instanceof Proxy))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1154858546 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1596712174 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1596712174;
        } //End block
        Proxy another = (Proxy) obj;
        boolean var936EFD08C12A47FB02C9277AA02F0328_1965443565 = ((type == another.type) && address.equals(another.address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252664168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252664168;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (!(obj instanceof Proxy)) {
            //return false;
        //}
        //Proxy another = (Proxy) obj;
        //return (type == another.type) && address.equals(another.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.126 -0400", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "AE3ECAE619AA4BE7A7A2FE32EC22B52B")
    @Override
    public final int hashCode() {
        int ret = 0;
        ret += type.hashCode();
    if(address != null)        
        {
            ret += address.hashCode();
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_330742641 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213047285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213047285;
        // ---------- Original Method ----------
        //int ret = 0;
        //ret += type.hashCode();
        //if (address != null) {
            //ret += address.hashCode();
        //}
        //return ret;
    }

    
    public enum Type {
        DIRECT,
        HTTP,
        SOCKS
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.126 -0400", hash_original_field = "00F7D85B1963E3DD128AB25CE9CD2640", hash_generated_field = "CFAF9C7805E2D3759922DBF914F8A204")

    public static final Proxy NO_PROXY = new Proxy();
}

