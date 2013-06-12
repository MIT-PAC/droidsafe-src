package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

public final class SchemeRegistry {
    private final Map<String,Scheme> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.016 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "9F89098CD614897069B93F02C515710C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        // ---------- Original Method ----------
        //registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.016 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "5B2868C3FEE28944984ABD70C88E82E9")
    @DSModeled(DSC.SAFE)
    public synchronized final Scheme getScheme(String name) {
        dsTaint.addTaint(name);
        Scheme found;
        found = get(name);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("Scheme '"+name+"' not registered.");
        } //End block
        return (Scheme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Scheme found = get(name);
        //if (found == null) {
            //throw new IllegalStateException
                //("Scheme '"+name+"' not registered.");
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.016 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "B0A7B60DE281D67E963A8FAF941C6515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final Scheme getScheme(HttpHost host) {
        dsTaint.addTaint(host.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Host must not be null.");
        } //End block
        Scheme var77FF38ED695E1F93308FF3D2993C8F6D_1310161748 = (getScheme(host.getSchemeName()));
        return (Scheme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException("Host must not be null.");
        //}
        //return getScheme(host.getSchemeName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.016 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "E96DD6B1BA382A90644220937FE70AF7")
    @DSModeled(DSC.SAFE)
    public synchronized final Scheme get(String name) {
        dsTaint.addTaint(name);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme found;
        found = registeredSchemes.get(name);
        return (Scheme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme found = registeredSchemes.get(name);
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.017 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "4BDDCFC74A6B8C8E9A1126F524B5A9B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final Scheme register(Scheme sch) {
        dsTaint.addTaint(sch.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Scheme must not be null.");
        Scheme old;
        old = registeredSchemes.put(sch.getName(), sch);
        return (Scheme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sch == null)
            //throw new IllegalArgumentException("Scheme must not be null.");
        //Scheme old = registeredSchemes.put(sch.getName(), sch);
        //return old;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.017 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "379AF217E6806CDCBD9DD3E474D2EEE8")
    @DSModeled(DSC.SAFE)
    public synchronized final Scheme unregister(String name) {
        dsTaint.addTaint(name);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name must not be null.");
        Scheme gone;
        gone = registeredSchemes.remove(name);
        return (Scheme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme gone = registeredSchemes.remove(name);
        //return gone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.017 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "117E94991665ADFE478E5B5340B361B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final List<String> getSchemeNames() {
        List<String> varC52A45D319C3ED870E025B6C4E357C8A_962048144 = (new ArrayList<String>(registeredSchemes.keySet()));
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.017 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "E793005536AEA29055A06558B07F27A7")
    @DSModeled(DSC.SAFE)
    public synchronized void setItems(final Map<String, Scheme> map) {
        dsTaint.addTaint(map.dsTaint);
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
        // ---------- Original Method ----------
        //if (map == null) {
            //return;
        //}
        //registeredSchemes.clear();
        //registeredSchemes.putAll(map);
    }

    
}


