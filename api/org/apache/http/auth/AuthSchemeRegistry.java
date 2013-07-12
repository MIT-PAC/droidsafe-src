package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.params.HttpParams;

public final class AuthSchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.008 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "7DEAAE1C48DF7EB41AD4414C102662D1")

    private Map<String,AuthSchemeFactory> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.009 -0400", hash_original_method = "22746583E1A94F633C7199B49397C3E9", hash_generated_method = "6E2C4AB92C73ECD444FE51CD49F9C6A6")
    public  AuthSchemeRegistry() {
        super();
        this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.010 -0400", hash_original_method = "86D80B5F63163F72174F2671E9B32DD3", hash_generated_method = "970DDA0131EC88D5489173557E097D76")
    public synchronized void register(
            final String name, 
            final AuthSchemeFactory factory) {
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1651626391 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1651626391.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1651626391;
        } 
    if(factory == null)        
        {
            IllegalArgumentException varF9F861B061C3B4B32DA6DA39601728A0_863662942 = new IllegalArgumentException("Authentication scheme factory may not be null");
            varF9F861B061C3B4B32DA6DA39601728A0_863662942.addTaint(taint);
            throw varF9F861B061C3B4B32DA6DA39601728A0_863662942;
        } 
        registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
        
        
             
         
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.010 -0400", hash_original_method = "65CA9EEB97401D491830ABAD4DFFB0A8", hash_generated_method = "AF0A88EA9ADE166E9EA5196E5C25DDA2")
    public synchronized void unregister(final String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1812020382 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1812020382.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1812020382;
        } 
        registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
        
        
             
         
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.011 -0400", hash_original_method = "8F2D5DDAEEB3D14130F6F0EEE6300B47", hash_generated_method = "1E4E18AB29BC9F34C62FDEB5A538D70B")
    public synchronized AuthScheme getAuthScheme(final String name, final HttpParams params) throws IllegalStateException {
        addTaint(params.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_40070238 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_40070238.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_40070238;
        } 
        AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
    if(factory != null)        
        {
AuthScheme varB5D01F4327DBBC343676B65A86A05A58_1193263039 =             factory.newInstance(params);
            varB5D01F4327DBBC343676B65A86A05A58_1193263039.addTaint(taint);
            return varB5D01F4327DBBC343676B65A86A05A58_1193263039;
        } 
        else
        {
            IllegalStateException var370EF9884C7AE53987ABC6CB85E3AE6C_369933180 = new IllegalStateException("Unsupported authentication scheme: " + name);
            var370EF9884C7AE53987ABC6CB85E3AE6C_369933180.addTaint(taint);
            throw var370EF9884C7AE53987ABC6CB85E3AE6C_369933180;
        } 
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.012 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "E6AF402C8E0670A92A3D604906160A2A")
    public synchronized List<String> getSchemeNames() {
List<String> varAAEC45CC0E27E189B466FC7E198A1AD8_1579106797 =         new ArrayList<String>(registeredSchemes.keySet());
        varAAEC45CC0E27E189B466FC7E198A1AD8_1579106797.addTaint(taint);
        return varAAEC45CC0E27E189B466FC7E198A1AD8_1579106797;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.013 -0400", hash_original_method = "34BF27E04F7109EDCEF6964572DA093F", hash_generated_method = "ECA387D72730AD7CD84F7F4CF7917EB4")
    public synchronized void setItems(final Map<String, AuthSchemeFactory> map) {
        addTaint(map.getTaint());
    if(map == null)        
        {
            return;
        } 
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
        
        
            
        
        
        
    }

    
}

