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
    private Bundle table;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.744 -0400", hash_original_method = "81BA7CE42C429B1D2F4A8FA68B131FF3", hash_generated_method = "EE496E3F3072DFAFBDE3B99BD9B2BC37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SslCertLookupTable() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.744 -0400", hash_original_method = "D1D349299054A2A05843F53D2271E3F3", hash_generated_method = "F73761A7182C4B00145D263ADCEEC0ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsAllowed(SslError sslError) {
        dsTaint.addTaint(sslError.dsTaint);
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.745 -0400", hash_original_method = "BE69D625DE69B336FE62B540E51D9D21", hash_generated_method = "5FCAFD2A6CDCC5AB5C60A73F3F58A5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAllowed(SslError sslError) {
        dsTaint.addTaint(sslError.dsTaint);
        String host;
        try 
        {
            host = new URL(sslError.getUrl()).getHost();
        } //End block
        catch (MalformedURLException e)
        { }
        boolean var15B3CC325E4DD7AAC65B476211A99A1B_368528184 = (table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String host;
        //try {
            //host = new URL(sslError.getUrl()).getHost();
        //} catch(MalformedURLException e) {
            //return false;
        //}
        //return table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.745 -0400", hash_original_method = "ACAE13D192212363EBD03A770903E836", hash_generated_method = "50263D7EA683F7C86C6DCDB42989A20A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        table.clear();
        // ---------- Original Method ----------
        //table.clear();
    }

    
    private static SslCertLookupTable sTable;
}

