package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class StringWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.769 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "EB9E5A2DAF0C9C70707F8B833E05E535")

    private StringBuffer buf;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.770 -0400", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "63358526500471A61BCE1FB30E5618B4")
    public  StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
        // ---------- Original Method ----------
        //buf = new StringBuffer(16);
        //lock = buf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.770 -0400", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "2DE8CF66A9C473D805DF037081FD1CB9")
    public  StringWriter(int initialSize) {
        if(initialSize < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2028166911 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2028166911.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2028166911;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.771 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.771 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.771 -0400", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "016A806D5A8AD007B3D8D0AE3A9CD185")
    public StringBuffer getBuffer() {
StringBuffer var0D8E466677B8F245666E1A4B1E0924E6_286612027 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_286612027.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_286612027;
        // ---------- Original Method ----------
        //return buf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.772 -0400", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "E82DBF37E523942DC6B1029616EA4FD3")
    @Override
    public String toString() {
String var4FC680801218E6372BC708D6FA44AE60_42704342 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_42704342.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_42704342;
        // ---------- Original Method ----------
        //return buf.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.772 -0400", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "8B30BF7F12B571949DA372C9347EACE5")
    @Override
    public void write(char[] chars, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(chars[0]);
        Arrays.checkOffsetAndCount(chars.length, offset, count);
        if(count == 0)        
        {
            return;
        } //End block
        buf.append(chars, offset, count);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(chars.length, offset, count);
        //if (count == 0) {
            //return;
        //}
        //buf.append(chars, offset, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.774 -0400", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "01E91D957E82637CFC3C47E10D1867C5")
    @Override
    public void write(int oneChar) {
        addTaint(oneChar);
        buf.append((char) oneChar);
        // ---------- Original Method ----------
        //buf.append((char) oneChar);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.775 -0400", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "B35CF84D879E60368FE32761B2308CB2")
    @Override
    public void write(String str) {
        addTaint(str.getTaint());
        buf.append(str);
        // ---------- Original Method ----------
        //buf.append(str);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.775 -0400", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "13A75375C9F789E104808755450CF2D4")
    @Override
    public void write(String str, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        String sub = str.substring(offset, offset + count);
        buf.append(sub);
        // ---------- Original Method ----------
        //String sub = str.substring(offset, offset + count);
        //buf.append(sub);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.775 -0400", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "E6B521AF5648386784F031DF6462395D")
    @Override
    public StringWriter append(char c) {
        addTaint(c);
        write(c);
StringWriter var72A74007B2BE62B849F475C7BDA4658B_956205892 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_956205892.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_956205892;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.776 -0400", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "03A0420806DCAF4B19C45E7E116BCAF6")
    @Override
    public StringWriter append(CharSequence csq) {
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        write(csq.toString());
StringWriter var72A74007B2BE62B849F475C7BDA4658B_473046218 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_473046218.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_473046218;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.776 -0400", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "EB97611AE7833AED61E533A9399CAE0A")
    @Override
    public StringWriter append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
StringWriter var72A74007B2BE62B849F475C7BDA4658B_947504147 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_947504147.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_947504147;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

