package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class StringWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.809 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "EB9E5A2DAF0C9C70707F8B833E05E535")

    private StringBuffer buf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.809 -0400", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "63358526500471A61BCE1FB30E5618B4")
    public  StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
        // ---------- Original Method ----------
        //buf = new StringBuffer(16);
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.819 -0400", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "60185B4E553DA2CA7D0B9CF3010AD32D")
    public  StringWriter(int initialSize) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.819 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.819 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.820 -0400", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "3825646A5E0A4C1832540BDE2E5B8329")
    public StringBuffer getBuffer() {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_119499976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119499976 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_119499976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119499976;
        // ---------- Original Method ----------
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.820 -0400", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "E2C50432A24451904F405DA9E9180B3B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_459516794 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_459516794 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_459516794.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_459516794;
        // ---------- Original Method ----------
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.821 -0400", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "456C47239C9B4A641FAC6BD147304202")
    @Override
    public void write(char[] chars, int offset, int count) {
        Arrays.checkOffsetAndCount(chars.length, offset, count);
        buf.append(chars, offset, count);
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(chars.length, offset, count);
        //if (count == 0) {
            //return;
        //}
        //buf.append(chars, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.825 -0400", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "3C1E2871B5843723DB538FF364E35157")
    @Override
    public void write(int oneChar) {
        buf.append((char) oneChar);
        addTaint(oneChar);
        // ---------- Original Method ----------
        //buf.append((char) oneChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.826 -0400", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "86764D1C2091DEC75C0126F96D97DD26")
    @Override
    public void write(String str) {
        buf.append(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //buf.append(str);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.826 -0400", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "EDB0899626E45FAEA12C12F32D79B2B2")
    @Override
    public void write(String str, int offset, int count) {
        String sub;
        sub = str.substring(offset, offset + count);
        buf.append(sub);
        addTaint(str.getTaint());
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //String sub = str.substring(offset, offset + count);
        //buf.append(sub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.833 -0400", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "76EE136898B847BA5D3BCEC2786C9636")
    @Override
    public StringWriter append(char c) {
        StringWriter varB4EAC82CA7396A68D541C85D26508E83_1729806551 = null; //Variable for return #1
        write(c);
        varB4EAC82CA7396A68D541C85D26508E83_1729806551 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1729806551.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729806551;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.840 -0400", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "053B7802D260F70A7E80A8E980739798")
    @Override
    public StringWriter append(CharSequence csq) {
        StringWriter varB4EAC82CA7396A68D541C85D26508E83_1005038164 = null; //Variable for return #1
        {
            csq = "null";
        } //End block
        write(csq.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1005038164 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1005038164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005038164;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.840 -0400", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "881C2C0BC3FC91F99BF14BBBE73B2C49")
    @Override
    public StringWriter append(CharSequence csq, int start, int end) {
        StringWriter varB4EAC82CA7396A68D541C85D26508E83_861326317 = null; //Variable for return #1
        {
            csq = "null";
        } //End block
        String output;
        output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        varB4EAC82CA7396A68D541C85D26508E83_861326317 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_861326317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861326317;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

