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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.725 -0400", hash_original_field = "2C7B13E600B37D78F94DC218F890F609", hash_generated_field = "282EEB2007797BAF8E0177A8CE143E9E")

    private byte[] buffer = new byte[BUFFER_SIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.725 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.725 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.726 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private SSLSocketImpl owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.726 -0400", hash_original_field = "1A80603325954C59F3C3BAF88C9E5743", hash_generated_field = "6FD517E7C88B49B968357327B10F8730")

    private boolean end_reached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.726 -0400", hash_original_field = "8A70338F4980F5ECE771FDC59AF6CB2E", hash_generated_field = "ABB2CE89E11F7FB8542D3FE9B7058434")

    protected Adapter dataPoint = new Adapter();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.726 -0400", hash_original_method = "2B2DE235A31ECF6D427ED4CC1BA78F0B", hash_generated_method = "E318056FDC005244FC8100AFE22AA9B7")
    protected  SSLSocketInputStream(SSLSocketImpl owner) {
        this.owner = owner;
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.726 -0400", hash_original_method = "A09BD0FC7A641BF0B6392C48D9B80DDB", hash_generated_method = "D50BB51FAE52E72979CFB5B32761475B")
    protected void setEnd() {
        end_reached = true;
        // ---------- Original Method ----------
        //end_reached = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.727 -0400", hash_original_method = "32329B6D4EFC7F65437C2D09A5400721", hash_generated_method = "57B0CACA72E9665C51104BDCB7DAE110")
    @Override
    public int available() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665069496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665069496;
        // ---------- Original Method ----------
        //return end - pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.727 -0400", hash_original_method = "B0B2FCB9CE6FDF4EA578715FA3754421", hash_generated_method = "94D10BF77244A202799017548290E6EF")
    @Override
    public void close() throws IOException {
        buffer = null;
        // ---------- Original Method ----------
        //buffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.727 -0400", hash_original_method = "92F5EAFF00040EF543528D1059933772", hash_generated_method = "E33D434513DF9A1904C23BC6811CAC45")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream was closed.");
        } //End block
        {
            owner.needAppData();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724598874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724598874;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.740 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "C3B3652D19ED881C2B98E28BAA1FC3AA")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read_b;
        int i;
        i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_1365639992 = ((read_b = read()) == -1);
            } //End collapsed parenthetic
            b[off+i] = (byte) read_b;
        } //End block
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_786035795 = ((available() != 0) && (i<len));
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859541185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859541185;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.741 -0400", hash_original_method = "740A355E7DE5D3F2D284C3985F05A62D", hash_generated_method = "740A355E7DE5D3F2D284C3985F05A62D")
        public Adapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.742 -0400", hash_original_method = "63D6CE2521D05DB3C4B970CFFD748CB7", hash_generated_method = "D8396DC36B257802F235EFAB9D33FDF5")
        public void append(byte[] src) {
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
            addTaint(src[0]);
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.743 -0400", hash_original_field = "D587EF8DA1B61B18373BDCDC15F9CE1A", hash_generated_field = "DEFA5AD8B687B67B5F446711800A505E")

    private static int BUFFER_SIZE = SSLRecordProtocol.MAX_DATA_LENGTH;
}

