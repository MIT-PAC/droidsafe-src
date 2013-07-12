package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class StringWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.050 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "EB9E5A2DAF0C9C70707F8B833E05E535")

    private StringBuffer buf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.050 -0400", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "63358526500471A61BCE1FB30E5618B4")
    public  StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.051 -0400", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "8514F4D4C8EADED5B44F3B0F1045C14C")
    public  StringWriter(int initialSize) {
    if(initialSize < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2117245723 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2117245723.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2117245723;
        } 
        buf = new StringBuffer(initialSize);
        lock = buf;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.052 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.052 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.053 -0400", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "33C3B6E7FC71C2FF9C23A25E1A8D55C0")
    public StringBuffer getBuffer() {
StringBuffer var0D8E466677B8F245666E1A4B1E0924E6_262121077 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_262121077.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_262121077;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.054 -0400", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "BBFE608E63CB715DE1E446BCC012A49E")
    @Override
    public String toString() {
String var4FC680801218E6372BC708D6FA44AE60_1584033799 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1584033799.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1584033799;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.054 -0400", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "8B30BF7F12B571949DA372C9347EACE5")
    @Override
    public void write(char[] chars, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(chars[0]);
        Arrays.checkOffsetAndCount(chars.length, offset, count);
    if(count == 0)        
        {
            return;
        } 
        buf.append(chars, offset, count);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.055 -0400", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "01E91D957E82637CFC3C47E10D1867C5")
    @Override
    public void write(int oneChar) {
        addTaint(oneChar);
        buf.append((char) oneChar);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.056 -0400", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "B35CF84D879E60368FE32761B2308CB2")
    @Override
    public void write(String str) {
        addTaint(str.getTaint());
        buf.append(str);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.057 -0400", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "13A75375C9F789E104808755450CF2D4")
    @Override
    public void write(String str, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        String sub = str.substring(offset, offset + count);
        buf.append(sub);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.057 -0400", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "15EB26134AB9BD7C081513450515C384")
    @Override
    public StringWriter append(char c) {
        addTaint(c);
        write(c);
StringWriter var72A74007B2BE62B849F475C7BDA4658B_330838756 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_330838756.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_330838756;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.058 -0400", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "C735B4ED59ADF2BEFD364BA53313E6C0")
    @Override
    public StringWriter append(CharSequence csq) {
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } 
        write(csq.toString());
StringWriter var72A74007B2BE62B849F475C7BDA4658B_1128835944 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1128835944.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1128835944;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.062 -0400", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "7E6ADB3CDABE92FF3650078C4338A9A4")
    @Override
    public StringWriter append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } 
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
StringWriter var72A74007B2BE62B849F475C7BDA4658B_280057551 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_280057551.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_280057551;
        
        
            
        
        
        
        
    }

    
}

