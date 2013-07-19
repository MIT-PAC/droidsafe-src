package org.apache.http.cookie;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class CookieSpecRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.164 -0400", hash_original_field = "601891FA30D304E1116F68409D06FF18", hash_generated_field = "010E9F60B3F377D0B23925E8DA25B64D")

    private Map<String,CookieSpecFactory> registeredSpecs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.166 -0400", hash_original_method = "87109D006D3940B2EC7D884D0D44DEE0", hash_generated_method = "849BE43B7A2F1D6C8BC4FFD5DDB64A6F")
    public  CookieSpecRegistry() {
        super();
        this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
        // ---------- Original Method ----------
        //this.registeredSpecs = new LinkedHashMap<String,CookieSpecFactory>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.167 -0400", hash_original_method = "BDFFC987379352646E2DC4AD0AE6816D", hash_generated_method = "69B4C0DA409097CD953A88C00626DCAA")
    public synchronized void register(final String name, final CookieSpecFactory factory) {
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1999820759 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1999820759.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1999820759;
        } //End block
        if(factory == null)        
        {
            IllegalArgumentException var757A45DB017EFA1F7F001BBD18D801AA_1716638973 = new IllegalArgumentException("Cookie spec factory may not be null");
            var757A45DB017EFA1F7F001BBD18D801AA_1716638973.addTaint(taint);
            throw var757A45DB017EFA1F7F001BBD18D801AA_1716638973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.168 -0400", hash_original_method = "7F517F7E1779C641A5E7B828D148D2B3", hash_generated_method = "74FB1139022E12F2F0FEE39B33D0A488")
    public synchronized void unregister(final String id) {
        addTaint(id.getTaint());
        if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1063098303 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1063098303.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1063098303;
        } //End block
        registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
        // ---------- Original Method ----------
        //if (id == null) {
             //throw new IllegalArgumentException("Id may not be null");
         //}
        //registeredSpecs.remove(id.toLowerCase(Locale.ENGLISH));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.168 -0400", hash_original_method = "8996807FE7E231444D0F4F50C2BE4E33", hash_generated_method = "696E04EA553A97AF1B1C627C3BFA2D0E")
    public synchronized CookieSpec getCookieSpec(final String name, final HttpParams params) throws IllegalStateException {
        addTaint(params.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_612974957 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_612974957.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_612974957;
        } //End block
        CookieSpecFactory factory = registeredSpecs.get(name.toLowerCase(Locale.ENGLISH));
        if(factory != null)        
        {
CookieSpec varB5D01F4327DBBC343676B65A86A05A58_1975905501 =             factory.newInstance(params);
            varB5D01F4327DBBC343676B65A86A05A58_1975905501.addTaint(taint);
            return varB5D01F4327DBBC343676B65A86A05A58_1975905501;
        } //End block
        else
        {
            IllegalStateException varA64FA39877616F5248C64E719D43B26D_1760017918 = new IllegalStateException("Unsupported cookie spec: " + name);
            varA64FA39877616F5248C64E719D43B26D_1760017918.addTaint(taint);
            throw varA64FA39877616F5248C64E719D43B26D_1760017918;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.169 -0400", hash_original_method = "44CB7B6D7C3249DF9FE20C6D12DA10E7", hash_generated_method = "C8515555A043050EA2B93C5DC5064FC3")
    public synchronized CookieSpec getCookieSpec(final String name) throws IllegalStateException {
        addTaint(name.getTaint());
CookieSpec varE7B6E3066EF70D61671A1A34D909B5FA_392463935 =         getCookieSpec(name, null);
        varE7B6E3066EF70D61671A1A34D909B5FA_392463935.addTaint(taint);
        return varE7B6E3066EF70D61671A1A34D909B5FA_392463935;
        // ---------- Original Method ----------
        //return getCookieSpec(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.169 -0400", hash_original_method = "4CC259988AD0BC6F5659CB623EFD31B9", hash_generated_method = "B166526F6B3163B4F82C6B9792E31D05")
    public synchronized List<String> getSpecNames() {
List<String> var0D64B20114CD92049F17A2CA0ADED285_104073448 =         new ArrayList<String>(registeredSpecs.keySet());
        var0D64B20114CD92049F17A2CA0ADED285_104073448.addTaint(taint);
        return var0D64B20114CD92049F17A2CA0ADED285_104073448;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSpecs.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.170 -0400", hash_original_method = "5E760DEDDE84B9034662300F5010E126", hash_generated_method = "08D373B67675D6B37FD85DD39B0A0D59")
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

