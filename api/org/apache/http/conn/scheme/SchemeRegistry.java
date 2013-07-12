package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

public final class SchemeRegistry {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.661 -0400", hash_original_field = "49E3DD06FF2AA56D06FA884BEB565B65", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private Map<String,Scheme> registeredSchemes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.663 -0400", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "19CED71237E12F258C2D993EF51D05E7")
    public  SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
        // ---------- Original Method ----------
        //registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.664 -0400", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "A5FE37A8700B969BDCF2E7688807BC25")
    public synchronized final Scheme getScheme(String name) {
        addTaint(name.getTaint());
        Scheme found = get(name);
    if(found == null)        
        {
            IllegalStateException var6884E92B52C3BE0FDC62B88FB30CBF3F_1508319987 = new IllegalStateException
                ("Scheme '"+name+"' not registered.");
            var6884E92B52C3BE0FDC62B88FB30CBF3F_1508319987.addTaint(taint);
            throw var6884E92B52C3BE0FDC62B88FB30CBF3F_1508319987;
        } //End block
Scheme varF632CA15DF7F0948C110F1E316CEC23E_28508320 =         found;
        varF632CA15DF7F0948C110F1E316CEC23E_28508320.addTaint(taint);
        return varF632CA15DF7F0948C110F1E316CEC23E_28508320;
        // ---------- Original Method ----------
        //Scheme found = get(name);
        //if (found == null) {
            //throw new IllegalStateException
                //("Scheme '"+name+"' not registered.");
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.664 -0400", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "D6B43EEF9CE8F81A160F74211878DC6E")
    public synchronized final Scheme getScheme(HttpHost host) {
        addTaint(host.getTaint());
    if(host == null)        
        {
            IllegalArgumentException var56A347237082B1EF739CF618A747705D_1588762819 = new IllegalArgumentException("Host must not be null.");
            var56A347237082B1EF739CF618A747705D_1588762819.addTaint(taint);
            throw var56A347237082B1EF739CF618A747705D_1588762819;
        } //End block
Scheme var55C1532E08A9503EBC39F2B3BF2C8B26_345795983 =         getScheme(host.getSchemeName());
        var55C1532E08A9503EBC39F2B3BF2C8B26_345795983.addTaint(taint);
        return var55C1532E08A9503EBC39F2B3BF2C8B26_345795983;
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException("Host must not be null.");
        //}
        //return getScheme(host.getSchemeName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.665 -0400", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "B96BEAB4216045C4FF836F352B612DC2")
    public synchronized final Scheme get(String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
        IllegalArgumentException var1A12BD9ABEBD2A7B8E88E94E48BB0D74_488951594 = new IllegalArgumentException("Name must not be null.");
        var1A12BD9ABEBD2A7B8E88E94E48BB0D74_488951594.addTaint(taint);
        throw var1A12BD9ABEBD2A7B8E88E94E48BB0D74_488951594;
        }
        Scheme found = registeredSchemes.get(name);
Scheme varF632CA15DF7F0948C110F1E316CEC23E_1388658982 =         found;
        varF632CA15DF7F0948C110F1E316CEC23E_1388658982.addTaint(taint);
        return varF632CA15DF7F0948C110F1E316CEC23E_1388658982;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme found = registeredSchemes.get(name);
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.665 -0400", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "5790BA84699EC5322953106821B52459")
    public synchronized final Scheme register(Scheme sch) {
        addTaint(sch.getTaint());
    if(sch == null)        
        {
        IllegalArgumentException varC3E55E01B090127A9E8F799F49539F37_894449866 = new IllegalArgumentException("Scheme must not be null.");
        varC3E55E01B090127A9E8F799F49539F37_894449866.addTaint(taint);
        throw varC3E55E01B090127A9E8F799F49539F37_894449866;
        }
        Scheme old = registeredSchemes.put(sch.getName(), sch);
Scheme varC9682C20C4B1FD7FBB3E018F7AF09BF2_135225325 =         old;
        varC9682C20C4B1FD7FBB3E018F7AF09BF2_135225325.addTaint(taint);
        return varC9682C20C4B1FD7FBB3E018F7AF09BF2_135225325;
        // ---------- Original Method ----------
        //if (sch == null)
            //throw new IllegalArgumentException("Scheme must not be null.");
        //Scheme old = registeredSchemes.put(sch.getName(), sch);
        //return old;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.666 -0400", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "D6E751FEF25826D9AD9CAC5D0CD72A12")
    public synchronized final Scheme unregister(String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
        IllegalArgumentException var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1449204478 = new IllegalArgumentException("Name must not be null.");
        var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1449204478.addTaint(taint);
        throw var1A12BD9ABEBD2A7B8E88E94E48BB0D74_1449204478;
        }
        Scheme gone = registeredSchemes.remove(name);
Scheme var9CA2A4D09CDE28FB110DF0CCFBCA11B5_1983636612 =         gone;
        var9CA2A4D09CDE28FB110DF0CCFBCA11B5_1983636612.addTaint(taint);
        return var9CA2A4D09CDE28FB110DF0CCFBCA11B5_1983636612;
        // ---------- Original Method ----------
        //if (name == null)
            //throw new IllegalArgumentException("Name must not be null.");
        //Scheme gone = registeredSchemes.remove(name);
        //return gone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.666 -0400", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "14B544C9CF1A7D10DE81E67326C5839B")
    public synchronized final List<String> getSchemeNames() {
List<String> varAAEC45CC0E27E189B466FC7E198A1AD8_382848093 =         new ArrayList<String>(registeredSchemes.keySet());
        varAAEC45CC0E27E189B466FC7E198A1AD8_382848093.addTaint(taint);
        return varAAEC45CC0E27E189B466FC7E198A1AD8_382848093;
        // ---------- Original Method ----------
        //return new ArrayList<String>(registeredSchemes.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.666 -0400", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "EC2D8F9D92F392360BC6888D3D75A7AA")
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

