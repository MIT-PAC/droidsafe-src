package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.params.HttpParams;




public final class AuthSchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.244 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "7DEAAE1C48DF7EB41AD4414C102662D1")

    private Map<String,AuthSchemeFactory> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.245 -0400", hash_original_method = "22746583E1A94F633C7199B49397C3E9", hash_generated_method = "6E2C4AB92C73ECD444FE51CD49F9C6A6")
    public  AuthSchemeRegistry() {
        super();
        this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
        // ---------- Original Method ----------
        //this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.246 -0400", hash_original_method = "86D80B5F63163F72174F2671E9B32DD3", hash_generated_method = "AE562970A5DA49FDD297B24300398DE7")
    public synchronized void register(
            final String name, 
            final AuthSchemeFactory factory) {
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1320320704 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1320320704.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1320320704;
        } //End block
        if(factory == null)        
        {
            IllegalArgumentException varF9F861B061C3B4B32DA6DA39601728A0_1988309447 = new IllegalArgumentException("Authentication scheme factory may not be null");
            varF9F861B061C3B4B32DA6DA39601728A0_1988309447.addTaint(taint);
            throw varF9F861B061C3B4B32DA6DA39601728A0_1988309447;
        } //End block
        registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //if (factory == null) {
            //throw new IllegalArgumentException("Authentication scheme factory may not be null");
        //}
        //registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.247 -0400", hash_original_method = "65CA9EEB97401D491830ABAD4DFFB0A8", hash_generated_method = "D59D635CE7D005A0C95B45F101EBA254")
    public synchronized void unregister(final String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1950164106 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1950164106.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1950164106;
        } //End block
        registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.247 -0400", hash_original_method = "8F2D5DDAEEB3D14130F6F0EEE6300B47", hash_generated_method = "98A24817DC9BEAED9C33757C42A2DF0A")
    public synchronized AuthScheme getAuthScheme(final String name, final HttpParams params) throws IllegalStateException {
        addTaint(params.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1120625454 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1120625454.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1120625454;
        } //End block
        AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
        if(factory != null)        
        {
AuthScheme varB5D01F4327DBBC343676B65A86A05A58_1232253554 =             factory.newInstance(params);
            varB5D01F4327DBBC343676B65A86A05A58_1232253554.addTaint(taint);
            return varB5D01F4327DBBC343676B65A86A05A58_1232253554;
        } //End block
        else
        {
            IllegalStateException var370EF9884C7AE53987ABC6CB85E3AE6C_1751440707 = new IllegalStateException("Unsupported authentication scheme: " + name);
            var370EF9884C7AE53987ABC6CB85E3AE6C_1751440707.addTaint(taint);
            throw var370EF9884C7AE53987ABC6CB85E3AE6C_1751440707;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
        //if (factory != null) {
            //return factory.newInstance(params);
        //} else {
            //throw new IllegalStateException("Unsupported authentication scheme: " + name);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.248 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "246197864AFC8F9AA8D9D52353B51B90")
    public synchronized List<String> getSchemeNames() {
List<String> varAAEC45CC0E27E189B466FC7E198A1AD8_1551861263 =         new ArrayList<String>(registeredSchemes.keySet());
        varAAEC45CC0E27E189B466FC7E198A1AD8_1551861263.addTaint(taint);
        return varAAEC45CC0E27E189B466FC7E198A1AD8_1551861263;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.249 -0400", hash_original_method = "34BF27E04F7109EDCEF6964572DA093F", hash_generated_method = "ECA387D72730AD7CD84F7F4CF7917EB4")
    public synchronized void setItems(final Map<String, AuthSchemeFactory> map) {
        addTaint(map.getTaint());
        if(map == null)        
        {
            return;
        } //End block
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

