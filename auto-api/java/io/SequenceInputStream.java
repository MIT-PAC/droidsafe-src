package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.810 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "18AD9586F739C9162783E991FCA98C7A")

    private Enumeration<? extends InputStream> e;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.810 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.831 -0400", hash_original_method = "29105F0198123C3B47FC811BDEDF639D", hash_generated_method = "13A34E29CFB1DAD7E615774D8C6954CE")
    public  SequenceInputStream(InputStream s1, InputStream s2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Vector<InputStream> inVector;
        inVector = new Vector<InputStream>(1);
        inVector.addElement(s2);
        e = inVector.elements();
        in = s1;
        addTaint(s2.getTaint());
        // ---------- Original Method ----------
        //if (s1 == null) {
            //throw new NullPointerException();
        //}
        //Vector<InputStream> inVector = new Vector<InputStream>(1);
        //inVector.addElement(s2);
        //e = inVector.elements();
        //in = s1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.832 -0400", hash_original_method = "4836B5679700B3654AB08A07E2FBBEF0", hash_generated_method = "738F5F95B8F3A2F112ED8EC9032D110D")
    public  SequenceInputStream(Enumeration<? extends InputStream> e) {
        this.e = e;
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_68486452 = (e.hasMoreElements());
            {
                in = e.nextElement();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.e = e;
        //if (e.hasMoreElements()) {
            //in = e.nextElement();
            //if (in == null) {
                //throw new NullPointerException();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.832 -0400", hash_original_method = "989AE899244AE453B2C16F0363EA8BF3", hash_generated_method = "78A5528CEB3283DFAF26F98D0B7A0E42")
    @Override
    public int available() throws IOException {
        {
            int varE4FA4B6C8AF71619986F605D31C31FCE_1122753566 = (in.available());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069912359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069912359;
        // ---------- Original Method ----------
        //if (e != null && in != null) {
            //return in.available();
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.840 -0400", hash_original_method = "1749070D39A948E7280B7E9ED33867CE", hash_generated_method = "A677E64EA09E5752BC180939C4F24EE7")
    @Override
    public void close() throws IOException {
        {
            nextStream();
        } //End block
        e = null;
        // ---------- Original Method ----------
        //while (in != null) {
            //nextStream();
        //}
        //e = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.845 -0400", hash_original_method = "AA61F30EE9F68EF2787A55BE84FD9C61", hash_generated_method = "54B1F0086F1724BF3D37EADBADB19765")
    private void nextStream() throws IOException {
        {
            in.close();
        } //End block
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_247436353 = (e.hasMoreElements());
            {
                in = e.nextElement();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
            {
                in = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (in != null) {
            //in.close();
        //}
        //if (e.hasMoreElements()) {
            //in = e.nextElement();
            //if (in == null) {
                //throw new NullPointerException();
            //}
        //} else {
            //in = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.845 -0400", hash_original_method = "2AFBD8CC3EA20986AC27924C0AD5D7EE", hash_generated_method = "19A89694DAF8A69BFA8586F64E5EB56E")
    @Override
    public int read() throws IOException {
        {
            int result;
            result = in.read();
            nextStream();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82760359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82760359;
        // ---------- Original Method ----------
        //while (in != null) {
            //int result = in.read();
            //if (result >= 0) {
                //return result;
            //}
            //nextStream();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.847 -0400", hash_original_method = "D0BE57C4BCBFEEAAABF8F255E34909BC", hash_generated_method = "D747CA8126F1B4F74490E1D547FE6855")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            int result;
            result = in.read(buffer, offset, count);
            nextStream();
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304433589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304433589;
        // ---------- Original Method ----------
        //if (in == null) {
            //return -1;
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //while (in != null) {
            //int result = in.read(buffer, offset, count);
            //if (result >= 0) {
                //return result;
            //}
            //nextStream();
        //}
        //return -1;
    }

    
}

