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
    private byte[] buf;
    private int pos;
    private Attributes.Name name;
    private String value;
    private UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
    private int consecutiveLineBreaks = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.294 -0400", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "E7C3825C43CD5193EBDE170781FF59D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        dsTaint.addTaint(ver.dsTaint);
        dsTaint.addTaint(buf[0]);
        dsTaint.addTaint(main.dsTaint);
        {
            boolean var9E29E253D6ABB79AF10DD0A4E178856A_1113195314 = (!readHeader() || (ver != null && !name.equals(ver)));
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Missing version attribute: " + ver);
            } //End block
        } //End collapsed parenthetic
        main.put(name, value);
        {
            boolean var35ADE6BA859A15F942E020A106087697_194477778 = (readHeader());
            {
                main.put(name, value);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.294 -0400", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "EEB5FA450AEFABB560C309B926C85139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initEntries(Map<String, Attributes> entries,
            Map<String, Manifest.Chunk> chunks) throws IOException {
        dsTaint.addTaint(chunks.dsTaint);
        dsTaint.addTaint(entries.dsTaint);
        int mark;
        mark = pos;
        {
            boolean var35ADE6BA859A15F942E020A106087697_558956800 = (readHeader());
            {
                {
                    boolean var8FE37595366FFA77198F59E1EA14B5E2_204566084 = (!Attributes.Name.NAME.equals(name));
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
                    boolean varB8609CBB8545DA425D762EBCABD99D2B_1486562531 = (readHeader());
                    {
                        entry.put(name, value);
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean varF76ED97608AF354A98063ECB70E73AE5_1406321180 = (chunks.get(entryNameValue) != null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.294 -0400", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "C82050469DD1112B92E5CB9C16207A1D")
    @DSModeled(DSC.SAFE)
     int getPos() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.294 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "71DF75FD8E54AB32897971EAA20BADDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean readHeader() throws IOException {
        {
            consecutiveLineBreaks = 0;
        } //End block
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.295 -0400", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "93244440739F6CAB1B8C2C66C2A3A09B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.295 -0400", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "DAD88D41749B90CCD9FA951A7AF76A57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

