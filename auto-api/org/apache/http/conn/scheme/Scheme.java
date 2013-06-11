package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;
import org.apache.http.util.LangUtils;

public final class Scheme {
    private final String name;
    private final SocketFactory socketFactory;
    private final int defaultPort;
    private final boolean layered;
    private String stringRep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "2D1FACCFCA298ABBAE2D51C212CBA4F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(name);
        dsTaint.addTaint(factory.dsTaint);
        {
            throw new IllegalArgumentException
                ("Scheme name may not be null");
        } //End block
        {
            throw new IllegalArgumentException
                ("Socket factory may not be null");
        } //End block
        {
            throw new IllegalArgumentException
                ("Port is invalid: " + port);
        } //End block
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.layered = (factory instanceof LayeredSocketFactory);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException
                //("Scheme name may not be null");
        //}
        //if (factory == null) {
            //throw new IllegalArgumentException
                //("Socket factory may not be null");
        //}
        //if ((port <= 0) || (port > 0xffff)) {
            //throw new IllegalArgumentException
                //("Port is invalid: " + port);
        //}
        //this.name = name.toLowerCase(Locale.ENGLISH);
        //this.socketFactory = factory;
        //this.defaultPort = port;
        //this.layered = (factory instanceof LayeredSocketFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "A1114938FB04CF56C8DCFD1C11D6C5A7")
    @DSModeled(DSC.SAFE)
    public final int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "5DFBEC71AB885AA93EE2C635A63BDFA1")
    @DSModeled(DSC.SAFE)
    public final SocketFactory getSocketFactory() {
        return (SocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socketFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A892EF72E38635393E1E3CB08CBDBB43")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "E739C901F2812A767FAB29C09E9BEF3C")
    @DSModeled(DSC.SAFE)
    public final boolean isLayered() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "10BE69EFF2C9F83485FDE34CCEC125CF")
    @DSModeled(DSC.SAFE)
    public final int resolvePort(int port) {
        dsTaint.addTaint(port);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((port <= 0) || (port > 0xffff)) ? defaultPort : port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "D0D88A7C4221E3F5BB2605F87869BA3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        {
            StringBuilder buffer;
            buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (stringRep == null) {
            //StringBuilder buffer = new StringBuilder();
            //buffer.append(this.name);
            //buffer.append(':');
            //buffer.append(Integer.toString(this.defaultPort));
            //stringRep = buffer.toString();
        //}
        //return stringRep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "1BBC2BBF022A644C456119740E644919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        Scheme s;
        s = (Scheme) obj;
        boolean var815103F6CF63892700C652AA1AF81A32_726889624 = ((name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj == null) return false;
        //if (this == obj) return true;
        //if (!(obj instanceof Scheme)) return false;
        //Scheme s = (Scheme) obj;
        //return (name.equals(s.name) &&
                //defaultPort == s.defaultPort &&
                //layered == s.layered &&
                //socketFactory.equals(s.socketFactory)
                //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.013 -0400", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "49FEF716F9A499EB2A226E06F4ECBF60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.defaultPort);
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.layered);
        //hash = LangUtils.hashCode(hash, this.socketFactory);
        //return hash;
    }

    
}


