package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import javax.net.ssl.SSLException;

public final class SSLSocketInputStream extends InputStream {
    private byte[] buffer = new byte[BUFFER_SIZE];
    private int pos;
    private int end;
    private SSLSocketImpl owner;
    private boolean end_reached = false;
    protected Adapter dataPoint = new Adapter();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.267 -0400", hash_original_method = "2B2DE235A31ECF6D427ED4CC1BA78F0B", hash_generated_method = "50C791FD4B2F98B52E4980735D2F5FB9")
    @DSModeled(DSC.SAFE)
    protected SSLSocketInputStream(SSLSocketImpl owner) {
        dsTaint.addTaint(owner.dsTaint);
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "A09BD0FC7A641BF0B6392C48D9B80DDB", hash_generated_method = "D50BB51FAE52E72979CFB5B32761475B")
    @DSModeled(DSC.SAFE)
    protected void setEnd() {
        end_reached = true;
        // ---------- Original Method ----------
        //end_reached = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "32329B6D4EFC7F65437C2D09A5400721", hash_generated_method = "CE149D9450429E03B2D2ADCB290E0826")
    @DSModeled(DSC.SAFE)
    @Override
    public int available() throws IOException {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end - pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "B0B2FCB9CE6FDF4EA578715FA3754421", hash_generated_method = "94D10BF77244A202799017548290E6EF")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        buffer = null;
        // ---------- Original Method ----------
        //buffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "92F5EAFF00040EF543528D1059933772", hash_generated_method = "705D4E0A2BA95204D29034AC4409D28A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream was closed.");
        } //End block
        {
            owner.needAppData();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IOException("Stream was closed.");
        //}
        //while (pos == end) {
            //if (end_reached) {
                //return -1;
            //}
            //owner.needAppData();
        //}
        //return buffer[pos++] & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "5A05EFE277717C2ADACADB7723B322E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        int read_b;
        int i;
        i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_1309488565 = ((read_b = read()) == -1);
            } //End collapsed parenthetic
            b[off+i] = (byte) read_b;
        } //End block
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_654984213 = ((available() != 0) && (i<len));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int read_b;
        //int i = 0;
        //do {
            //if ((read_b = read()) == -1) {
                //return (i == 0) ? -1 : i;
            //}
            //b[off+i] = (byte) read_b;
            //i++;
        //} while ((available() != 0) && (i<len));
        //return i;
    }

    
    private class Adapter implements org.apache.harmony.xnet.provider.jsse.Appendable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.268 -0400", hash_original_method = "B65CD654135FF6B63E7909150487BD6A", hash_generated_method = "B65CD654135FF6B63E7909150487BD6A")
                public Adapter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.269 -0400", hash_original_method = "63D6CE2521D05DB3C4B970CFFD748CB7", hash_generated_method = "648523E898C97D3455852F8FB36E5173")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void append(byte[] src) {
            dsTaint.addTaint(src[0]);
            int length;
            length = src.length;
            {
                if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                        new SSLException("Could not accept income app data."));
            } //End block
            {
                System.arraycopy(buffer, pos, buffer, 0, end-pos);
                end -= pos;
                pos = 0;
            } //End block
            System.arraycopy(src, 0, buffer, end, length);
            end = end + length;
            // ---------- Original Method ----------
            //int length = src.length;
            //if (BUFFER_SIZE - (end - pos) < length) {
                //throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                        //new SSLException("Could not accept income app data."));
            //}
            //if (end + length > BUFFER_SIZE) {
                //System.arraycopy(buffer, pos, buffer, 0, end-pos);
                //end -= pos;
                //pos = 0;
            //}
            //System.arraycopy(src, 0, buffer, end, length);
            //end = end + length;
        }

        
    }


    
    private static final int BUFFER_SIZE = SSLRecordProtocol.MAX_DATA_LENGTH;
}

