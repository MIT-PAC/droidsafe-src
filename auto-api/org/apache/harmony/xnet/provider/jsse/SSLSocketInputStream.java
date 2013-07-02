package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import javax.net.ssl.SSLException;

public final class SSLSocketInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "2C7B13E600B37D78F94DC218F890F609", hash_generated_field = "282EEB2007797BAF8E0177A8CE143E9E")

    private byte[] buffer = new byte[BUFFER_SIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private SSLSocketImpl owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "1A80603325954C59F3C3BAF88C9E5743", hash_generated_field = "6FD517E7C88B49B968357327B10F8730")

    private boolean end_reached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.052 -0400", hash_original_field = "8A70338F4980F5ECE771FDC59AF6CB2E", hash_generated_field = "ABB2CE89E11F7FB8542D3FE9B7058434")

    protected Adapter dataPoint = new Adapter();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.053 -0400", hash_original_method = "2B2DE235A31ECF6D427ED4CC1BA78F0B", hash_generated_method = "E318056FDC005244FC8100AFE22AA9B7")
    protected  SSLSocketInputStream(SSLSocketImpl owner) {
        this.owner = owner;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.054 -0400", hash_original_method = "A09BD0FC7A641BF0B6392C48D9B80DDB", hash_generated_method = "D50BB51FAE52E72979CFB5B32761475B")
    protected void setEnd() {
        end_reached = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.054 -0400", hash_original_method = "32329B6D4EFC7F65437C2D09A5400721", hash_generated_method = "DF35A7FDDCAABB11AEC3A6B9A105AF90")
    @Override
    public int available() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608619294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608619294;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.054 -0400", hash_original_method = "B0B2FCB9CE6FDF4EA578715FA3754421", hash_generated_method = "94D10BF77244A202799017548290E6EF")
    @Override
    public void close() throws IOException {
        buffer = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.055 -0400", hash_original_method = "92F5EAFF00040EF543528D1059933772", hash_generated_method = "DA52D3A8DFE2225A71F350D173067A9C")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream was closed.");
        } 
        {
            owner.needAppData();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682845163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682845163;
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.055 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "A41AE4C2D332476FC387636DDE1C2210")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read_b;
        int i = 0;
        {
            {
                boolean var58A5278A655D93F97DA0180416078C33_1229448356 = ((read_b = read()) == -1);
            } 
            b[off+i] = (byte) read_b;
        } 
        {
            boolean var455A44C366F5A1443EF5626F0B5953C6_1590502709 = ((available() != 0) && (i<len));
        } 
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513323197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513323197;
        
        
        
        
            
                
            
            
            
        
        
    }

    
    private class Adapter implements org.apache.harmony.xnet.provider.jsse.Appendable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.055 -0400", hash_original_method = "740A355E7DE5D3F2D284C3985F05A62D", hash_generated_method = "740A355E7DE5D3F2D284C3985F05A62D")
        public Adapter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.056 -0400", hash_original_method = "63D6CE2521D05DB3C4B970CFFD748CB7", hash_generated_method = "B725741D097F6AD731574B2ABFA701C6")
        public void append(byte[] src) {
            int length = src.length;
            {
                if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                        new SSLException("Could not accept income app data."));
            } 
            {
                System.arraycopy(buffer, pos, buffer, 0, end-pos);
                end -= pos;
                pos = 0;
            } 
            System.arraycopy(src, 0, buffer, end, length);
            end = end + length;
            addTaint(src[0]);
            
            
            
                
                        
            
            
                
                
                
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.056 -0400", hash_original_field = "D587EF8DA1B61B18373BDCDC15F9CE1A", hash_generated_field = "D64401C8A17B13BD371C7D5226CD92C1")

    private static final int BUFFER_SIZE = SSLRecordProtocol.MAX_DATA_LENGTH;
}

