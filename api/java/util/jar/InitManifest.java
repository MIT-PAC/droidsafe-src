package java.util.jar;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Map;






class InitManifest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")

    private byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")

    private Attributes.Name name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "D35EF5459F3326BC22ECBC011607C3F6", hash_generated_field = "E3B6135907F2544C8BA6970CAAB07453")

    private final UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.685 -0400", hash_original_field = "62A5CA13629D08A86502F9F689F2892B", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")

    private int consecutiveLineBreaks = 0;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.686 -0400", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "5F0C3EE8D63657EC485ACAD85F870E5B")
      InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        addTaint(ver.getTaint());
        addTaint(main.getTaint());
        this.buf = buf;
        if(!readHeader() || (ver != null && !name.equals(ver)))        
        {
            IOException var0831C9BE204AB13EF0238C04376F6DD3_994917781 = new IOException("Missing version attribute: " + ver);
            var0831C9BE204AB13EF0238C04376F6DD3_994917781.addTaint(taint);
            throw var0831C9BE204AB13EF0238C04376F6DD3_994917781;
        } //End block
        main.put(name, value);
        while
(readHeader())        
        {
            main.put(name, value);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.687 -0400", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "4B1A7A17F801FDA7485B1553B0305BB0")
     void initEntries(Map<String, Attributes> entries,
            Map<String, Manifest.Chunk> chunks) throws IOException {
        addTaint(chunks.getTaint());
        addTaint(entries.getTaint());
        int mark = pos;
        while
(readHeader())        
        {
            if(!Attributes.Name.NAME.equals(name))            
            {
                IOException varAD9A06B8AAA3550867E8063419E348E5_989576548 = new IOException("Entry is not named");
                varAD9A06B8AAA3550867E8063419E348E5_989576548.addTaint(taint);
                throw varAD9A06B8AAA3550867E8063419E348E5_989576548;
            } //End block
            String entryNameValue = value;
            Attributes entry = entries.get(entryNameValue);
            if(entry == null)            
            {
                entry = new Attributes(12);
            } //End block
            while
(readHeader())            
            {
                entry.put(name, value);
            } //End block
            if(chunks != null)            
            {
                if(chunks.get(entryNameValue) != null)                
                {
                    IOException varCE5112C6459A339D160B40CEDAC59F04_511862852 = new IOException("A jar verifier does not support more than one entry with the same name");
                    varCE5112C6459A339D160B40CEDAC59F04_511862852.addTaint(taint);
                    throw varCE5112C6459A339D160B40CEDAC59F04_511862852;
                } //End block
                chunks.put(entryNameValue, new Manifest.Chunk(mark, pos));
                mark = pos;
            } //End block
            entries.put(entryNameValue, entry);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.688 -0400", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "C5F966E42A7AC09207C112A38A3AB975")
     int getPos() {
        int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1182999747 = (pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849791264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849791264;
        // ---------- Original Method ----------
        //return pos;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.688 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "900907833E116DA1E226E85844657A89")
    private boolean readHeader() throws IOException {
        if(consecutiveLineBreaks > 1)        
        {
            consecutiveLineBreaks = 0;
            boolean var68934A3E9455FA72420237EB05902327_2044602616 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773005846 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_773005846;
        } //End block
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        boolean var5E22E1CA341CF35C52AB9E4BC4A0FE1E_596658728 = (consecutiveLineBreaks > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593473564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_593473564;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.689 -0400", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "6B7BFD5658BB74276F733EA9E252937B")
    private void readName() throws IOException {
        int mark = pos;
        while
(pos < buf.length)        
        {
            if(buf[pos++] != ':')            
            {
                continue;
            } //End block
            String name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);
            if(buf[pos++] != ' ')            
            {
                IOException varDD22C780180FD1E1DC67DBA9556D737B_52891477 = new IOException(String.format("Invalid value for attribute '%s'", name));
                varDD22C780180FD1E1DC67DBA9556D737B_52891477.addTaint(taint);
                throw varDD22C780180FD1E1DC67DBA9556D737B_52891477;
            } //End block
            try 
            {
                this.name = new Attributes.Name(name);
            } //End block
            catch (IllegalArgumentException e)
            {
                IOException varDFC4605B531BC1C5380FD94E58912494_878609943 = new IOException(e.getMessage());
                varDFC4605B531BC1C5380FD94E58912494_878609943.addTaint(taint);
                throw varDFC4605B531BC1C5380FD94E58912494_878609943;
            } //End block
            return;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.690 -0400", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "260B9AFE843C2F0C6D7FEA3631B64457")
    private void readValue() throws IOException {
        boolean lastCr = false;
        int mark = pos;
        int last = pos;
        valueBuffer.rewind();
        while
(pos < buf.length)        
        {
            byte next = buf[pos++];
switch(next){
            case 0:
            IOException varDD8E7F95D988A494324394CA45192FFF_811680498 = new IOException("NUL character in a manifest");
            varDD8E7F95D988A494324394CA45192FFF_811680498.addTaint(taint);
            throw varDD8E7F95D988A494324394CA45192FFF_811680498;
            case '\n':
            if(lastCr)            
            {
                lastCr = false;
            } //End block
            else
            {
                consecutiveLineBreaks++;
            } //End block
            continue;
            case '\r':
            lastCr = true;
            consecutiveLineBreaks++;
            continue;
            case ' ':
            if(consecutiveLineBreaks == 1)            
            {
                valueBuffer.write(buf, mark, last - mark);
                mark = pos;
                consecutiveLineBreaks = 0;
                continue;
            } //End block
}            if(consecutiveLineBreaks >= 1)            
            {
                pos--;
                break;
            } //End block
            last = pos;
        } //End block
        valueBuffer.write(buf, mark, last - mark);
        value = valueBuffer.toString(Charsets.UTF_8);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

