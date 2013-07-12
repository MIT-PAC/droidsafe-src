package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Map;

class InitManifest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")

    private byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")

    private Attributes.Name name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "D35EF5459F3326BC22ECBC011607C3F6", hash_generated_field = "E3B6135907F2544C8BA6970CAAB07453")

    private final UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.003 -0400", hash_original_field = "62A5CA13629D08A86502F9F689F2892B", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")

    private int consecutiveLineBreaks = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.004 -0400", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "F9A8AC098A84003841C57BF8C0F18D43")
      InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        addTaint(ver.getTaint());
        addTaint(main.getTaint());
        this.buf = buf;
    if(!readHeader() || (ver != null && !name.equals(ver)))        
        {
            IOException var0831C9BE204AB13EF0238C04376F6DD3_833549185 = new IOException("Missing version attribute: " + ver);
            var0831C9BE204AB13EF0238C04376F6DD3_833549185.addTaint(taint);
            throw var0831C9BE204AB13EF0238C04376F6DD3_833549185;
        } 
        main.put(name, value);
        while
(readHeader())        
        {
            main.put(name, value);
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.005 -0400", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "B6B4A3764B13FCB4C1F319F39195DD05")
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
                IOException varAD9A06B8AAA3550867E8063419E348E5_1196987842 = new IOException("Entry is not named");
                varAD9A06B8AAA3550867E8063419E348E5_1196987842.addTaint(taint);
                throw varAD9A06B8AAA3550867E8063419E348E5_1196987842;
            } 
            String entryNameValue = value;
            Attributes entry = entries.get(entryNameValue);
    if(entry == null)            
            {
                entry = new Attributes(12);
            } 
            while
(readHeader())            
            {
                entry.put(name, value);
            } 
    if(chunks != null)            
            {
    if(chunks.get(entryNameValue) != null)                
                {
                    IOException varCE5112C6459A339D160B40CEDAC59F04_1743647491 = new IOException("A jar verifier does not support more than one entry with the same name");
                    varCE5112C6459A339D160B40CEDAC59F04_1743647491.addTaint(taint);
                    throw varCE5112C6459A339D160B40CEDAC59F04_1743647491;
                } 
                chunks.put(entryNameValue, new Manifest.Chunk(mark, pos));
                mark = pos;
            } 
            entries.put(entryNameValue, entry);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.005 -0400", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "24EBB4184C14A79962A37F3D0675C854")
     int getPos() {
        int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_2062740336 = (pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941798907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941798907;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.006 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "B92E5011EDD97BBDC1B1D0820D3CF743")
    private boolean readHeader() throws IOException {
    if(consecutiveLineBreaks > 1)        
        {
            consecutiveLineBreaks = 0;
            boolean var68934A3E9455FA72420237EB05902327_755453544 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885630790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_885630790;
        } 
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        boolean var5E22E1CA341CF35C52AB9E4BC4A0FE1E_1699249025 = (consecutiveLineBreaks > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882608792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882608792;
        
        
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.007 -0400", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "0770E2199C85A0C2A15019939A1CED4B")
    private void readName() throws IOException {
        int mark = pos;
        while
(pos < buf.length)        
        {
    if(buf[pos++] != ':')            
            {
                continue;
            } 
            String name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);
    if(buf[pos++] != ' ')            
            {
                IOException varDD22C780180FD1E1DC67DBA9556D737B_2142827190 = new IOException(String.format("Invalid value for attribute '%s'", name));
                varDD22C780180FD1E1DC67DBA9556D737B_2142827190.addTaint(taint);
                throw varDD22C780180FD1E1DC67DBA9556D737B_2142827190;
            } 
            try 
            {
                this.name = new Attributes.Name(name);
            } 
            catch (IllegalArgumentException e)
            {
                IOException varDFC4605B531BC1C5380FD94E58912494_2123656203 = new IOException(e.getMessage());
                varDFC4605B531BC1C5380FD94E58912494_2123656203.addTaint(taint);
                throw varDFC4605B531BC1C5380FD94E58912494_2123656203;
            } 
            return;
        } 
        
        
        
            
                
            
            
            
                
            
            
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.008 -0400", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "1D8765973928EE0FC19AA891CF232998")
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
            IOException varDD8E7F95D988A494324394CA45192FFF_500140369 = new IOException("NUL character in a manifest");
            varDD8E7F95D988A494324394CA45192FFF_500140369.addTaint(taint);
            throw varDD8E7F95D988A494324394CA45192FFF_500140369;
            case '\n':
    if(lastCr)            
            {
                lastCr = false;
            } 
            else
            {
                consecutiveLineBreaks++;
            } 
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
            } 
}    if(consecutiveLineBreaks >= 1)            
            {
                pos--;
                break;
            } 
            last = pos;
        } 
        valueBuffer.write(buf, mark, last - mark);
        value = valueBuffer.toString(Charsets.UTF_8);
        
        
    }

    
}

