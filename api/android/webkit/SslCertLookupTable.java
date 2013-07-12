package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.net.http.SslError;
import java.net.MalformedURLException;
import java.net.URL;

final class SslCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.081 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "E7D6180A9A0AC63D2200ADF169A7E529")

    private Bundle table;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.082 -0400", hash_original_method = "81BA7CE42C429B1D2F4A8FA68B131FF3", hash_generated_method = "EE496E3F3072DFAFBDE3B99BD9B2BC37")
    private  SslCertLookupTable() {
        table = new Bundle();
        
        
    }

    
        @DSModeled(DSC.SPEC)
    public static SslCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslCertLookupTable();
        }
        return sTable;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.083 -0400", hash_original_method = "D1D349299054A2A05843F53D2271E3F3", hash_generated_method = "132CBC29873CD844CD84EF9A625617F7")
    public void setIsAllowed(SslError sslError) {
        addTaint(sslError.getTaint());
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } 
        catch (MalformedURLException e)
        {
            return;
        } 
        table.putInt(host, sslError.getPrimaryError());
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.084 -0400", hash_original_method = "BE69D625DE69B336FE62B540E51D9D21", hash_generated_method = "315A91BA84ED0B2E03F9A2160530F036")
    public boolean isAllowed(SslError sslError) {
        addTaint(sslError.getTaint());
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } 
        catch (MalformedURLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1845394708 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560948689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560948689;
        } 
        boolean varA54A5D7738C823F006F606F4EBE004BB_125978325 = (table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235481693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235481693;
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.084 -0400", hash_original_method = "ACAE13D192212363EBD03A770903E836", hash_generated_method = "50263D7EA683F7C86C6DCDB42989A20A")
    public void clear() {
        table.clear();
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.085 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "2A9D3A10505DE76D3665C10F8539BC83")

    private static SslCertLookupTable sTable;
}

