package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public final class Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.464 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.464 -0400", hash_original_field = "29ADE661BC5B8F8B761C72AAE89589BE", hash_generated_field = "EE0A679D7069D3BF51EFF346308E2FC4")

    private SocketFactory socketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.464 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.464 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "656433D6E22132E512C250C9ABEE8490")

    private boolean layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.464 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.482 -0400", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "A608D30D93F6507F6FF6A6D9A7087CDE")
    public  Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Scheme name may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Socket factory may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Port is invalid: " + port);
        } //End block
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.socketFactory = factory;
        this.defaultPort = port;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.483 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "574835CBAC0627433E348621D8FE57B2")
    public final int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529633495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529633495;
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.483 -0400", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "1EE45FE45C92B83794EAA4F6CAEF2788")
    public final SocketFactory getSocketFactory() {
        SocketFactory varB4EAC82CA7396A68D541C85D26508E83_1748151065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748151065 = socketFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1748151065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748151065;
        // ---------- Original Method ----------
        //return socketFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.484 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "C415D4053E806E601CE0E91F1B15840A")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_881759855 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881759855 = name;
        varB4EAC82CA7396A68D541C85D26508E83_881759855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881759855;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.484 -0400", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "82D2D7BDA009F838BD94406BA2BDF17D")
    public final boolean isLayered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756475370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756475370;
        // ---------- Original Method ----------
        //return layered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.495 -0400", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "688D1544F97DDF41A1021E74B74B1D8F")
    public final int resolvePort(int port) {
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754236405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754236405;
        // ---------- Original Method ----------
        //return ((port <= 0) || (port > 0xffff)) ? defaultPort : port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.501 -0400", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "3471BCDC56FDA1FA093A240094A28212")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1588417922 = null; //Variable for return #1
        {
            StringBuilder buffer;
            buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1588417922 = stringRep;
        varB4EAC82CA7396A68D541C85D26508E83_1588417922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1588417922;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.501 -0400", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "A43AF83791CE196976EFCB71F9D11BF0")
    @Override
    public final boolean equals(Object obj) {
        Scheme s;
        s = (Scheme) obj;
        boolean var815103F6CF63892700C652AA1AF81A32_1535109804 = ((name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                ));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447402403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447402403;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.502 -0400", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "C984DE01E7D537C6BB3DC502E529DFD4")
    @Override
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47722276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47722276;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.defaultPort);
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.layered);
        //hash = LangUtils.hashCode(hash, this.socketFactory);
        //return hash;
    }

    
}

