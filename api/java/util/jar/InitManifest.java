package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Map;

class InitManifest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")

    private byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")

    private Attributes.Name name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "D35EF5459F3326BC22ECBC011607C3F6", hash_generated_field = "E3B6135907F2544C8BA6970CAAB07453")

    private final UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.978 -0400", hash_original_field = "62A5CA13629D08A86502F9F689F2892B", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")

    private int consecutiveLineBreaks = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.979 -0400", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "77518E536DAA6BFEBECB839C42488C42")
      InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        this.buf = buf;
        {
            boolean var9E29E253D6ABB79AF10DD0A4E178856A_26454999 = (!readHeader() || (ver != null && !name.equals(ver)));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Missing version attribute: " + ver);
            } 
        } 
        main.put(name, value);
        {
            boolean var35ADE6BA859A15F942E020A106087697_1280774589 = (readHeader());
            {
                main.put(name, value);
            } 
        } 
        addTaint(main.getTaint());
        addTaint(ver.getTaint());
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.981 -0400", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "B9F9335202074113C14FB824DD94CD80")
     void initEntries(Map<String, Attributes> entries,
            Map<String, Manifest.Chunk> chunks) throws IOException {
        int mark = pos;
        {
            boolean var35ADE6BA859A15F942E020A106087697_730558374 = (readHeader());
            {
                {
                    boolean var8FE37595366FFA77198F59E1EA14B5E2_1265354000 = (!Attributes.Name.NAME.equals(name));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Entry is not named");
                    } 
                } 
                String entryNameValue = value;
                Attributes entry = entries.get(entryNameValue);
                {
                    entry = new Attributes(12);
                } 
                {
                    boolean varB8609CBB8545DA425D762EBCABD99D2B_499597796 = (readHeader());
                    {
                        entry.put(name, value);
                    } 
                } 
                {
                    {
                        boolean varF76ED97608AF354A98063ECB70E73AE5_415708324 = (chunks.get(entryNameValue) != null);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException("A jar verifier does not support more than one entry with the same name");
                        } 
                    } 
                    chunks.put(entryNameValue, new Manifest.Chunk(mark, pos));
                    mark = pos;
                } 
                entries.put(entryNameValue, entry);
            } 
        } 
        addTaint(entries.getTaint());
        addTaint(chunks.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.982 -0400", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "941AC7091D861D059F66D990B9ECAF34")
     int getPos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009535124 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009535124;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.983 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "C05AA540E624AB5F0C5F9D66F3CFADBE")
    private boolean readHeader() throws IOException {
        {
            consecutiveLineBreaks = 0;
        } 
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28593584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28593584;
        
        
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.984 -0400", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "3769104D34A4EEB920CE9DEBC34278D4")
    private void readName() throws IOException {
        int mark = pos;
        {
            String name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(String.format("Invalid value for attribute '%s'", name));
            } 
            try 
            {
                this.name = new Attributes.Name(name);
            } 
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e.getMessage());
            } 
        } 
        
        
        
            
                
            
            
            
                
            
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.984 -0400", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "7F8D1E929B3B8FCD6D0EDA91511E8703")
    private void readValue() throws IOException {
        boolean lastCr = false;
        int mark = pos;
        int last = pos;
        valueBuffer.rewind();
        {
            byte next = buf[pos++];
            
            if (DroidSafeAndroidRuntime.control) throw new IOException("NUL character in a manifest");
            
            
            {
                lastCr = false;
            } 
            
            
            lastCr = true;
            
            
            {
                valueBuffer.write(buf, mark, last - mark);
                mark = pos;
                consecutiveLineBreaks = 0;
            } 
            
            last = pos;
        } 
        valueBuffer.write(buf, mark, last - mark);
        value = valueBuffer.toString(Charsets.UTF_8);
        
        
    }

    
}

