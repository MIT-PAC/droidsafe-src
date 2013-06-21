package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Proxy {
    private Proxy.Type type;
    private SocketAddress address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.061 -0400", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "34B56A556619392FE0EA3A7CD3084A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Proxy(Proxy.Type type, SocketAddress sa) {
        dsTaint.addTaint(sa.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        } //End block
        // ---------- Original Method ----------
        //if (type == Type.DIRECT || sa == null) {
            //throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        //}
        //this.type = type;
        //address = sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.061 -0400", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "3B8506530C1D1E82DA5460F730015C73")
    @DSModeled(DSC.SAFE)
    private Proxy() {
        type = Type.DIRECT;
        address = null;
        // ---------- Original Method ----------
        //type = Type.DIRECT;
        //address = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.061 -0400", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "F9D7455E9C9CE494832B3BF72CFA4811")
    @DSModeled(DSC.SAFE)
    public Proxy.Type type() {
        return (Proxy.Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.061 -0400", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "6BE738A9649E2CD026EABC4ED3FBF42C")
    @DSModeled(DSC.SAFE)
    public SocketAddress address() {
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.061 -0400", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "384F41CB36AC8DC47FE3309DF7F490AA")
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_349872093 = (builder.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.062 -0400", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "D98DFB2E4531FE98C23E2770C7CB1C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Proxy another;
        another = (Proxy) obj;
        boolean varEAB7084851FAECD7616BC770C9D68717_269087352 = ((type == another.type) && address.equals(another.address));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.062 -0400", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "BF85FE4C32ACACC3FC16EC9E082A4BC6")
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

    
    public static final Proxy NO_PROXY = new Proxy();
}

