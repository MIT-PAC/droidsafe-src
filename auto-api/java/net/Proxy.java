package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Proxy {
    public static final Proxy NO_PROXY = new Proxy();
    private Proxy.Type type;
    private SocketAddress address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "AA0A5377157062D7B8B7DAFF0453FA32")
    @DSModeled(DSC.SAFE)
    public Proxy(Proxy.Type type, SocketAddress sa) {
        dsTaint.addTaint(sa.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        {
            throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        } //End block
        // ---------- Original Method ----------
        //if (type == Type.DIRECT || sa == null) {
            //throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        //}
        //this.type = type;
        //address = sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "22B4A2EFDD3349512AD67BD9C8B0C602")
    @DSModeled(DSC.SAFE)
    private Proxy() {
        type = Type.DIRECT;
        address = null;
        // ---------- Original Method ----------
        //type = Type.DIRECT;
        //address = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "435834E9D107D3579787D01EAFFD4DCA")
    @DSModeled(DSC.SAFE)
    public Proxy.Type type() {
        return (Proxy.Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "62465EFA3E868CCB039223378347874E")
    @DSModeled(DSC.SAFE)
    public SocketAddress address() {
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "888105DE517AE2CAF7F0851BB7D2CFDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        {
            builder.append(type.toString());
        } //End block
        builder.append("@");
        {
            builder.append(address.toString());
        } //End block
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1072472404 = (builder.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "47F644B007FD35C6CDACF4E987D33134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Proxy another;
        another = (Proxy) obj;
        boolean varEAB7084851FAECD7616BC770C9D68717_1009131080 = ((type == another.type) && address.equals(another.address));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.265 -0400", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "A10754E580116CD8C51D700FDB192030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        int ret;
        ret = 0;
        ret += type.hashCode();
        {
            ret += address.hashCode();
        } //End block
        return dsTaint.getTaintInt();
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

    
}


