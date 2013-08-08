package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public class Proxy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.314 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "0493BBFB1288023B7B163197BF9857A6")

    private Proxy.Type type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.314 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "E0A43CBF82D512E62F9819C96F9107F8")

    private SocketAddress address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.314 -0400", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "608B138C06962BF757719FBD1B9B394F")
    public  Proxy(Proxy.Type type, SocketAddress sa) {
        if(type == Type.DIRECT || sa == null)        
        {
            IllegalArgumentException varC693C0D94036BD60AD6E26795E42BD6A_1317027368 = new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
            varC693C0D94036BD60AD6E26795E42BD6A_1317027368.addTaint(taint);
            throw varC693C0D94036BD60AD6E26795E42BD6A_1317027368;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.315 -0400", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "3B8506530C1D1E82DA5460F730015C73")
    private  Proxy() {
        type = Type.DIRECT;
        address = null;
        // ---------- Original Method ----------
        //type = Type.DIRECT;
        //address = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.315 -0400", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "8BC82B98B010505D1521143087367A6E")
    public Proxy.Type type() {
Proxy.Type varC5B9F25B4EEAD3E8E2C33F9429204397_41021089 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_41021089.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_41021089;
        // ---------- Original Method ----------
        //return type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.315 -0400", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "6749C369593EEC038C36470910309107")
    public SocketAddress address() {
SocketAddress var814577DDD37BAFB17E08CBEFDB411BAE_110786773 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_110786773.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_110786773;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.315 -0400", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "5D04DBCD05E74C42010542C6B6514480")
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
String varF4CF030572656354ACFDF83FEE21D7A6_388580493 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_388580493.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_388580493;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.316 -0400", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "FDC2D51ABBF5273538231578A9A4266F")
    @Override
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1708167946 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472775796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472775796;
        } //End block
        if(!(obj instanceof Proxy))        
        {
            boolean var68934A3E9455FA72420237EB05902327_31971341 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073740064 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073740064;
        } //End block
        Proxy another = (Proxy) obj;
        boolean var936EFD08C12A47FB02C9277AA02F0328_1505001818 = ((type == another.type) && address.equals(another.address));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679768852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679768852;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.317 -0400", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "96041993D1A5834DF9D900C0C93A641F")
    @Override
    public final int hashCode() {
        int ret = 0;
        ret += type.hashCode();
        if(address != null)        
        {
            ret += address.hashCode();
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1066875477 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635354055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635354055;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.317 -0400", hash_original_field = "00F7D85B1963E3DD128AB25CE9CD2640", hash_generated_field = "CFAF9C7805E2D3759922DBF914F8A204")

    public static final Proxy NO_PROXY = new Proxy();
}

