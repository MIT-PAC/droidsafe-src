package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.net.http.SslError;
import java.net.MalformedURLException;
import java.net.URL;

final class SslCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.514 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "E7D6180A9A0AC63D2200ADF169A7E529")

    private Bundle table;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.515 -0400", hash_original_method = "81BA7CE42C429B1D2F4A8FA68B131FF3", hash_generated_method = "EE496E3F3072DFAFBDE3B99BD9B2BC37")
    private  SslCertLookupTable() {
        table = new Bundle();
        // ---------- Original Method ----------
        //table = new Bundle();
    }

    
    public static SslCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslCertLookupTable();
        }
        return sTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.515 -0400", hash_original_method = "D1D349299054A2A05843F53D2271E3F3", hash_generated_method = "BAC5EFFD31CE56F1BB3F1D5EAF36E851")
    public void setIsAllowed(SslError sslError) {
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        { }
        table.putInt(host, sslError.getPrimaryError());
        addTaint(sslError.getTaint());
        // ---------- Original Method ----------
        //String host;
        //try {
            //host = new URL(sslError.getUrl()).getHost();
        //} catch(MalformedURLException e) {
            //return;
        //}
        //table.putInt(host, sslError.getPrimaryError());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.516 -0400", hash_original_method = "BE69D625DE69B336FE62B540E51D9D21", hash_generated_method = "D7392C7B48CF2DA739A89E6ADE1D3362")
    public boolean isAllowed(SslError sslError) {
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        { }
        boolean var15B3CC325E4DD7AAC65B476211A99A1B_359884790 = (table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host));
        addTaint(sslError.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503072555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503072555;
        // ---------- Original Method ----------
        //String host;
        //try {
            //host = new URL(sslError.getUrl()).getHost();
        //} catch(MalformedURLException e) {
            //return false;
        //}
        //return table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.516 -0400", hash_original_method = "ACAE13D192212363EBD03A770903E836", hash_generated_method = "50263D7EA683F7C86C6DCDB42989A20A")
    public void clear() {
        table.clear();
        // ---------- Original Method ----------
        //table.clear();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.516 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "2A9D3A10505DE76D3665C10F8539BC83")

    private static SslCertLookupTable sTable;
}

