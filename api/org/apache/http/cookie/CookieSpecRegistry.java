package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.params.HttpParams;

public final class CookieSpecRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.876 -0400", hash_original_field = "601891FA30D304E1116F68409D06FF18", hash_generated_field = "010E9F60B3F377D0B23925E8DA25B64D")

    private Map<String,CookieSpecFactory> registeredSpecs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.876 -0400", hash_original_method = "87109D006D3940B2EC7D884D0D44DEE0", hash_generated_method = "849BE43B7A2F1D6C8BC4FFD5DDB64A6F")
    public  CookieSpecRegistry() {
        super();
        this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
        // ---------- Original Method ----------
        //this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.877 -0400", hash_original_method = "BDFFC987379352646E2DC4AD0AE6816D", hash_generated_method = "C2D0178A33EE568199212624BF590DDD")
    public synchronized void register(final String name, final CookieSpecFactory factory) {
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1526138361 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1526138361.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1526138361;
        } //End block
    if(factory == null)        
        {
            IllegalArgumentException var757A45DB017EFA1F7F001BBD18D801AA_1125369819 = new IllegalArgumentException("Cookie spec factory may not be null");
            var757A45DB017EFA1F7F001BBD18D801AA_1125369819.addTaint(taint);
            throw var757A45DB017EFA1F7F001BBD18D801AA_1125369819;
        } //End block
        registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
        // ---------- Original Method ----------
        //if (name == null) {
             //throw new IllegalArgumentException("Name may not be null");
         //}
        //if (factory == null) {
            //throw new IllegalArgumentException("Cookie spec factory may not be null");
        //}
        //registeredSpecs.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.877 -0400", hash_original_method = "7F517F7E1779C641A5E7B828D148D2B3", hash_generated_method = "2871B189D2CBF41259B7FB5E4D205C3B")
    public synchronized void unregister(final String id) {
        addTaint(id.getTaint());
    if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1050696711 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1050696711.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1050696711;
        } //End block
        registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
        // ---------- Original Method ----------
        //if (id == null) {
             //throw new IllegalArgumentException("Id may not be null");
         //}
        //registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.877 -0400", hash_original_method = "8996807FE7E231444D0F4F50C2BE4E33", hash_generated_method = "8D4519BA00CE2B0726F523658C94FDA4")
    public synchronized CookieSpec getCookieSpec(final String name, final HttpParams params) throws IllegalStateException {
        addTaint(params.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1008174989 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1008174989.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1008174989;
        } //End block
        CookieSpecFactory factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
    if(factory != null)        
        {
CookieSpec varB5D01F4327DBBC343676B65A86A05A58_1985582208 =             factory.newInstance(params);
            varB5D01F4327DBBC343676B65A86A05A58_1985582208.addTaint(taint);
            return varB5D01F4327DBBC343676B65A86A05A58_1985582208;
        } //End block
        else
        {
            IllegalStateException varA64FA39877616F5248C64E719D43B26D_1047738880 = new IllegalStateException("Unsupported cookie spec: " + name);
            varA64FA39877616F5248C64E719D43B26D_1047738880.addTaint(taint);
            throw varA64FA39877616F5248C64E719D43B26D_1047738880;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //CookieSpecFactory factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
        //if (factory != null) {
            //return factory.newInstance(params);
        //} else {
            //throw new IllegalStateException("Unsupported cookie spec: " + name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.878 -0400", hash_original_method = "44CB7B6D7C3249DF9FE20C6D12DA10E7", hash_generated_method = "530BC36DFD70DE9782579C63EE328B78")
    public synchronized CookieSpec getCookieSpec(final String name) throws IllegalStateException {
        addTaint(name.getTaint());
CookieSpec varE7B6E3066EF70D61671A1A34D909B5FA_1568037100 =         getCookieSpec(name, null);
        varE7B6E3066EF70D61671A1A34D909B5FA_1568037100.addTaint(taint);
        return varE7B6E3066EF70D61671A1A34D909B5FA_1568037100;
        // ---------- Original Method ----------
        //return getCookieSpec(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.878 -0400", hash_original_method = "4CC259988AD0BC6F5659CB623EFD31B9", hash_generated_method = "0B4393051804C2F286EE7EE78A8D69FD")
    public synchronized List<String> getSpecNames() {
List<String> var0D64B20114CD92049F17A2CA0ADED285_1341563496 =         new ArrayList<String>(registeredSpecs.keySet());
        var0D64B20114CD92049F17A2CA0ADED285_1341563496.addTaint(taint);
        return var0D64B20114CD92049F17A2CA0ADED285_1341563496;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSpecs.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.878 -0400", hash_original_method = "5E760DEDDE84B9034662300F5010E126", hash_generated_method = "08D373B67675D6B37FD85DD39B0A0D59")
    public synchronized void setItems(final Map<String, CookieSpecFactory> map) {
        addTaint(map.getTaint());
    if(map == null)        
        {
            return;
        } //End block
        registeredSpecs.clear();
        registeredSpecs.putAll(map);
        // ---------- Original Method ----------
        //if (map == null) {
            //return;
        //}
        //registeredSpecs.clear();
        //registeredSpecs.putAll(map);
    }

    
}

