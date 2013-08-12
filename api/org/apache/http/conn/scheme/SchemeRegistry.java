package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;




public final class SchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.997 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private Map<String,Scheme> registeredSchemes;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.998 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "19CED71237E12F258C2D993EF51D05E7")
    public  SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        // ---------- Original Method ----------
        //registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.999 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "76C98AB3BC2A8C9A49FEE044A5B56C51")
    public synchronized final Scheme getScheme(String name) {
        addTaint(name.getTaint());
        Scheme found = get(name);
        if(found == null)        
        {
            IllegalStateException var6884E92B52C3BE0FDC62B88FB30CBF3F_1145279090 = new IllegalStateException
                ("Scheme '"+name+"' not registered.");
            var6884E92B52C3BE0FDC62B88FB30CBF3F_1145279090.addTaint(taint);
            throw var6884E92B52C3BE0FDC62B88FB30CBF3F_1145279090;
        } //End block
Scheme varF632CA15DF7F0948C110F1E316CEC23E_570473413 =         found;
        varF632CA15DF7F0948C110F1E316CEC23E_570473413.addTaint(taint);
        return varF632CA15DF7F0948C110F1E316CEC23E_570473413;
        // ---------- Original Method ----------
        //Scheme found = get(name);
        //if (found == null) {
            //throw new IllegalStateException
                //("Scheme '"+name+"' not registered.");
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.999 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "407A06A97DFB71FCA81CF682C518D890")
    public synchronized final Scheme getScheme(HttpHost host) {
        addTaint(host.getTaint());
        if(host == null)        
        {
            IllegalArgumentException var56A347237082B1EF739CF618A747705D_327107728 = new IllegalArgumentException("Host must not be null.");
            var56A347237082B1EF739CF618A747705D_327107728.addTaint(taint);
            throw var56A347237082B1EF739CF618A747705D_327107728;
        } //End block
Scheme var55C1532E08A9503EBC39F2B3BF2C8B26_903193103 =         getScheme(host.getSchemeName());
        var55C1532E08A9503EBC39F2B3BF2C8B26_903193103.addTaint(taint);
        return var55C1532E08A9503EBC39F2B3BF2C8B26_903193103;
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException("Host must not be null.");
        //}
        //return getScheme(host.getSchemeName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.000 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "7A149CAE52C80712007FA34DF614000C")
    public synchronized final Scheme get(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
        IllegalArgumentException var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1259097876 = new IllegalArgumentException("Name must not be null.");
        var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1259097876.addTaint(taint);
        throw var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1259097876;
        }
        Scheme found = registeredSchemes.get(name);
Scheme varF632CA15DF7F0948C110F1E316CEC23E_2138424350 =         found;
        varF632CA15DF7F0948C110F1E316CEC23E_2138424350.addTaint(taint);
        return varF632CA15DF7F0948C110F1E316CEC23E_2138424350;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme found = registeredSchemes.get(name);
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.000 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "43ADC0D3341C1DF5433D079E6396C947")
    public synchronized final Scheme register(Scheme sch) {
        addTaint(sch.getTaint());
        if(sch == null)        
        {
        IllegalArgumentException varC3E55E01B090127A9E8F799F49539F37_2095459638 = new IllegalArgumentException("Scheme must not be null.");
        varC3E55E01B090127A9E8F799F49539F37_2095459638.addTaint(taint);
        throw varC3E55E01B090127A9E8F799F49539F37_2095459638;
        }
        Scheme old = registeredSchemes.put(sch.getName(), sch);
Scheme varC9682C20C4B1FD7FBB3E018F7AF09BF2_706147822 =         old;
        varC9682C20C4B1FD7FBB3E018F7AF09BF2_706147822.addTaint(taint);
        return varC9682C20C4B1FD7FBB3E018F7AF09BF2_706147822;
        // ---------- Original Method ----------
        //if (sch == null)
            //throw new IllegalArgumentException("Scheme must not be null.");
        //Scheme old = registeredSchemes.put(sch.getName(), sch);
        //return old;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.000 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "A9F7ED93EBED10BEE5E2835D72E9DC48")
    public synchronized final Scheme unregister(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
        IllegalArgumentException var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1300369570 = new IllegalArgumentException("Name must not be null.");
        var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1300369570.addTaint(taint);
        throw var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1300369570;
        }
        Scheme gone = registeredSchemes.remove(name);
Scheme var9CA2A4D09CDE28FB110DF0CCFBCA11B5_994071496 =         gone;
        var9CA2A4D09CDE28FB110DF0CCFBCA11B5_994071496.addTaint(taint);
        return var9CA2A4D09CDE28FB110DF0CCFBCA11B5_994071496;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme gone = registeredSchemes.remove(name);
        //return gone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.001 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "539378F06BB6E306843FCBC3C0A4175C")
    public synchronized final List<String> getSchemeNames() {
List<String> varAAEC45CC0E27E189B466FC7E198A1AD8_643193981 =         new ArrayList<String>(registeredSchemes.keySet());
        varAAEC45CC0E27E189B466FC7E198A1AD8_643193981.addTaint(taint);
        return varAAEC45CC0E27E189B466FC7E198A1AD8_643193981;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.001 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "EC2D8F9D92F392360BC6888D3D75A7AA")
    public synchronized void setItems(final Map<String, Scheme> map) {
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

