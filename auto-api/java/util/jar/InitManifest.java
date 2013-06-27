package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Map;

class InitManifest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")

    private byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")

    private Attributes.Name name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "D35EF5459F3326BC22ECBC011607C3F6", hash_generated_field = "CA09FFFF9B17FA8B8340E28775F612C8")

    private UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_field = "62A5CA13629D08A86502F9F689F2892B", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")

    private int consecutiveLineBreaks = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.355 -0400", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "EA1BC213CA2A02E556EF8C6F69CC69DB")
      InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        this.buf = buf;
        {
            boolean var9E29E253D6ABB79AF10DD0A4E178856A_989142897 = (!readHeader() || (ver != null && !name.equals(ver)));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Missing version attribute: " + ver);
            } //End block
        } //End collapsed parenthetic
        main.put(name, value);
        {
            boolean var35ADE6BA859A15F942E020A106087697_36723754 = (readHeader());
            {
                main.put(name, value);
            } //End block
        } //End collapsed parenthetic
        addTaint(main.getTaint());
        addTaint(ver.getTaint());
        // ---------- Original Method ----------
        //this.buf = buf;
        //if (!readHeader() || (ver != null && !name.equals(ver))) {
            //throw new IOException("Missing version attribute: " + ver);
        //}
        //main.put(name, value);
        //while (readHeader()) {
            //main.put(name, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.368 -0400", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "8ECAF1D6BA0C3132C3E4A4502A73D822")
     void initEntries(Map<String, Attributes> entries,
            Map<String, Manifest.Chunk> chunks) throws IOException {
        int mark;
        mark = pos;
        {
            boolean var35ADE6BA859A15F942E020A106087697_1971344733 = (readHeader());
            {
                {
                    boolean var8FE37595366FFA77198F59E1EA14B5E2_1999841483 = (!Attributes.Name.NAME.equals(name));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Entry is not named");
                    } //End block
                } //End collapsed parenthetic
                String entryNameValue;
                entryNameValue = value;
                Attributes entry;
                entry = entries.get(entryNameValue);
                {
                    entry = new Attributes(12);
                } //End block
                {
                    boolean varB8609CBB8545DA425D762EBCABD99D2B_1778184173 = (readHeader());
                    {
                        entry.put(name, value);
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean varF76ED97608AF354A98063ECB70E73AE5_1422509262 = (chunks.get(entryNameValue) != null);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException("A jar verifier does not support more than one entry with the same name");
                        } //End block
                    } //End collapsed parenthetic
                    chunks.put(entryNameValue, new Manifest.Chunk(mark, pos));
                    mark = pos;
                } //End block
                entries.put(entryNameValue, entry);
            } //End block
        } //End collapsed parenthetic
        addTaint(entries.getTaint());
        addTaint(chunks.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.369 -0400", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "54BA216F307D5E1B34992FFEE129458F")
     int getPos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1885934078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1885934078;
        // ---------- Original Method ----------
        //return pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.370 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "794DF7D46FFDDBACEF23EB4CA6DD3480")
    private boolean readHeader() throws IOException {
        {
            consecutiveLineBreaks = 0;
        } //End block
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759842552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_759842552;
        // ---------- Original Method ----------
        //if (consecutiveLineBreaks > 1) {
            //consecutiveLineBreaks = 0;
            //return false;
        //}
        //readName();
        //consecutiveLineBreaks = 0;
        //readValue();
        //return consecutiveLineBreaks > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.475 -0400", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "93244440739F6CAB1B8C2C66C2A3A09B")
    private void readName() throws IOException {
        int mark;
        mark = pos;
        {
            String name;
            name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(String.format("Invalid value for attribute '%s'", name));
            } //End block
            try 
            {
                this.name = new Attributes.Name(name);
            } //End block
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(e.getMessage());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int mark = pos;
        //while (pos < buf.length) {
            //if (buf[pos++] != ':') {
                //continue;
            //}
            //String name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);
            //if (buf[pos++] != ' ') {
                //throw new IOException(String.format("Invalid value for attribute '%s'", name));
            //}
            //try {
                //this.name = new Attributes.Name(name);
            //} catch (IllegalArgumentException e) {
                //throw new IOException(e.getMessage());
            //}
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.478 -0400", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "DAD88D41749B90CCD9FA951A7AF76A57")
    private void readValue() throws IOException {
        boolean lastCr;
        lastCr = false;
        int mark;
        mark = pos;
        int last;
        last = pos;
        valueBuffer.rewind();
        {
            byte next;
            next = buf[pos++];
            //Begin case 0 
            if (DroidSafeAndroidRuntime.control) throw new IOException("NUL character in a manifest");
            //End case 0 
            //Begin case '\n' 
            {
                lastCr = false;
            } //End block
            //End case '\n' 
            //Begin case '\r' 
            lastCr = true;
            //End case '\r' 
            //Begin case ' ' 
            {
                valueBuffer.write(buf, mark, last - mark);
                mark = pos;
                consecutiveLineBreaks = 0;
            } //End block
            //End case ' ' 
            last = pos;
        } //End block
        valueBuffer.write(buf, mark, last - mark);
        value = valueBuffer.toString(Charsets.UTF_8);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

