package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class StringWriter extends Writer {
    private StringBuffer buf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "A4F1BF80B5A8855C41870C1935961134")
    @DSModeled(DSC.SAFE)
    public StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
        // ---------- Original Method ----------
        //buf = new StringBuffer(16);
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "790CF8E37F52EBDD7C0F9C6D30DE4F38")
    @DSModeled(DSC.SAFE)
    public StringWriter(int initialSize) {
        dsTaint.addTaint(initialSize);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "43913192A45340DD2B1DDA454AD68C8F")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "E4D40EC6493188B29F77D031E968A12F")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "612045700C0DA578580289DD4CCAEB80")
    @DSModeled(DSC.SAFE)
    public StringBuffer getBuffer() {
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "56A5AF3C7E1CC9F8281546E9A3BC412E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var0C174602EFE4BFBCB80A7056CFA680FB_188724726 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "BE1014619068891AB670C8CD57B18BFD")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(char[] chars, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(chars);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.710 -0400", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "C2356FD3BBAEB49150A35748E2A77DBD")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int oneChar) {
        dsTaint.addTaint(oneChar);
        buf.append((char) oneChar);
        // ---------- Original Method ----------
        //buf.append((char) oneChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "D3065F1D8F672C1F75CCEB1C51D34D98")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(String str) {
        dsTaint.addTaint(str);
        buf.append(str);
        // ---------- Original Method ----------
        //buf.append(str);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "EB9236A9D192B5EB479C72BEF05C1B72")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(String str, int offset, int count) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        String sub;
        sub = str.substring(offset, offset + count);
        buf.append(sub);
        // ---------- Original Method ----------
        //String sub = str.substring(offset, offset + count);
        //buf.append(sub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "12F814F20FEC630FC7F5335253DFE4CD")
    @DSModeled(DSC.SAFE)
    @Override
    public StringWriter append(char c) {
        dsTaint.addTaint(c);
        write(c);
        return (StringWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "69A27DFF7729FACFDE9D1F0ECDCAE9F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "24B13480E7B7265852C97BFF4FBC3AC6")
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


