package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.net.http.SslError;
import java.net.MalformedURLException;
import java.net.URL;

final class SslCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.919 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "E7D6180A9A0AC63D2200ADF169A7E529")

    private Bundle table;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.919 -0400", hash_original_method = "81BA7CE42C429B1D2F4A8FA68B131FF3", hash_generated_method = "EE496E3F3072DFAFBDE3B99BD9B2BC37")
    private  SslCertLookupTable() {
        table = new Bundle();
        // ---------- Original Method ----------
        //table = new Bundle();
    }

    
    @DSModeled(DSC.SPEC)
    public static SslCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslCertLookupTable();
        }
        return sTable;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.920 -0400", hash_original_method = "D1D349299054A2A05843F53D2271E3F3", hash_generated_method = "132CBC29873CD844CD84EF9A625617F7")
    public void setIsAllowed(SslError sslError) {
        addTaint(sslError.getTaint());
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        {
            return;
        } //End block
        table.putInt(host, sslError.getPrimaryError());
        // ---------- Original Method ----------
        //String host;
        //try {
            //host = new URL(sslError.getUrl()).getHost();
        //} catch(MalformedURLException e) {
            //return;
        //}
        //table.putInt(host, sslError.getPrimaryError());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.921 -0400", hash_original_method = "BE69D625DE69B336FE62B540E51D9D21", hash_generated_method = "89D5403BA9AADBB030D0A329B839D6DF")
    public boolean isAllowed(SslError sslError) {
        addTaint(sslError.getTaint());
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1051078536 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402315926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_402315926;
        } //End block
        boolean varA54A5D7738C823F006F606F4EBE004BB_215228770 = (table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789751893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789751893;
        // ---------- Original Method ----------
        //String host;
        //try {
            //host = new URL(sslError.getUrl()).getHost();
        //} catch(MalformedURLException e) {
            //return false;
        //}
        //return table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.922 -0400", hash_original_method = "ACAE13D192212363EBD03A770903E836", hash_generated_method = "50263D7EA683F7C86C6DCDB42989A20A")
    public void clear() {
        table.clear();
        // ---------- Original Method ----------
        //table.clear();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.922 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "2A9D3A10505DE76D3665C10F8539BC83")

    private static SslCertLookupTable sTable;
}

