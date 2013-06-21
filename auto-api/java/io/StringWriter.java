package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class StringWriter extends Writer {
    private StringBuffer buf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.345 -0400", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "63358526500471A61BCE1FB30E5618B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
        // ---------- Original Method ----------
        //buf = new StringBuffer(16);
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.345 -0400", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "807AFB68DA80E4AD4C7D297DEAA39A97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringWriter(int initialSize) {
        dsTaint.addTaint(initialSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        buf = new StringBuffer(initialSize);
        lock = buf;
        // ---------- Original Method ----------
        //if (initialSize < 0) {
            //throw new IllegalArgumentException();
        //}
        //buf = new StringBuffer(initialSize);
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "ECB6BE3A710A30D1905E9D74F16AED1B")
    @DSModeled(DSC.SAFE)
    public StringBuffer getBuffer() {
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "AB864A14F4EEDFEF0B7D80B65590C11F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var0C174602EFE4BFBCB80A7056CFA680FB_270735313 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "BFC96D830624F027EB9D23FC2317CBB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(char[] chars, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(chars[0]);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(chars.length, offset, count);
        buf.append(chars, offset, count);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(chars.length, offset, count);
        //if (count == 0) {
            //return;
        //}
        //buf.append(chars, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.346 -0400", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "52335A7ADE5CCC7C8EC236AC97EC44A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int oneChar) {
        dsTaint.addTaint(oneChar);
        buf.append((char) oneChar);
        // ---------- Original Method ----------
        //buf.append((char) oneChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.347 -0400", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "114906EA1E276408128AC004993953D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str) {
        dsTaint.addTaint(str);
        buf.append(str);
        // ---------- Original Method ----------
        //buf.append(str);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.347 -0400", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "CA87E6195797D55CE4E2E391596E40E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        String sub;
        sub = str.substring(offset, offset + count);
        buf.append(sub);
        // ---------- Original Method ----------
        //String sub = str.substring(offset, offset + count);
        //buf.append(sub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.347 -0400", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "A5433A2F0DA3E26F7A1F23BB0686D787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringWriter append(char c) {
        dsTaint.addTaint(c);
        write(c);
        return (StringWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.347 -0400", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "4FA009C97D0B8C315F724642B3388133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringWriter append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            csq = "null";
        } //End block
        write(csq.toString());
        return (StringWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.347 -0400", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "00AC6F6B16A1DCA7F311E91475862EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringWriter append(CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        {
            csq = "null";
        } //End block
        String output;
        output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return (StringWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

