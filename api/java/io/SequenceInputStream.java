package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;




public class SequenceInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.578 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "18AD9586F739C9162783E991FCA98C7A")

    private Enumeration<? extends InputStream> e;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.579 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.581 -0400", hash_original_method = "29105F0198123C3B47FC811BDEDF639D", hash_generated_method = "EEC6EE1431DEE67F724DF43842662A1C")
    public  SequenceInputStream(InputStream s1, InputStream s2) {
        addTaint(s2.getTaint());
        if(s1 == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_512440164 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_512440164.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_512440164;
        } //End block
        Vector<InputStream> inVector = new Vector<InputStream>(1);
        inVector.addElement(s2);
        e = inVector.elements();
        in = s1;
        // ---------- Original Method ----------
        //if (s1 == null) {
            //throw new NullPointerException();
        //}
        //Vector<InputStream> inVector = new Vector<InputStream>(1);
        //inVector.addElement(s2);
        //e = inVector.elements();
        //in = s1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.583 -0400", hash_original_method = "4836B5679700B3654AB08A07E2FBBEF0", hash_generated_method = "474EF89E48A00FA50394E51566937285")
    public  SequenceInputStream(Enumeration<? extends InputStream> e) {
        this.e = e;
        if(e.hasMoreElements())        
        {
            in = e.nextElement();
            if(in == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_495493145 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_495493145.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_495493145;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.e = e;
        //if (e.hasMoreElements()) {
            //in = e.nextElement();
            //if (in == null) {
                //throw new NullPointerException();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.584 -0400", hash_original_method = "989AE899244AE453B2C16F0363EA8BF3", hash_generated_method = "BCB0AA11875FABFBD393D0645B438A3D")
    @Override
    public int available() throws IOException {
        if(e != null && in != null)        
        {
            int var443A4CD22A314221356D4EA83AFE1E61_411568125 = (in.available());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90802630 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90802630;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2091806774 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62307662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62307662;
        // ---------- Original Method ----------
        //if (e != null && in != null) {
            //return in.available();
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.584 -0400", hash_original_method = "1749070D39A948E7280B7E9ED33867CE", hash_generated_method = "2B90943E030B1A00BD1A5769357CB8FA")
    @Override
    public void close() throws IOException {
        while
(in != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.585 -0400", hash_original_method = "AA61F30EE9F68EF2787A55BE84FD9C61", hash_generated_method = "B9758684D5AD2B007F0A9F22B9F7FE1F")
    private void nextStream() throws IOException {
        if(in != null)        
        {
            in.close();
        } //End block
        if(e.hasMoreElements())        
        {
            in = e.nextElement();
            if(in == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_792228863 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_792228863.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_792228863;
            } //End block
        } //End block
        else
        {
            in = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.586 -0400", hash_original_method = "2AFBD8CC3EA20986AC27924C0AD5D7EE", hash_generated_method = "52BA9671FFCCD6C826B8699278D376A3")
    @Override
    public int read() throws IOException {
        while
(in != null)        
        {
            int result = in.read();
            if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_358337623 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008388185 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008388185;
            } //End block
            nextStream();
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1251415897 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048295184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048295184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.587 -0400", hash_original_method = "D0BE57C4BCBFEEAAABF8F255E34909BC", hash_generated_method = "22DF33D22A83C0F99910FAB1E44FC6F4")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        if(in == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_171929922 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599782349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599782349;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        while
(in != null)        
        {
            int result = in.read(buffer, offset, count);
            if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_54774603 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278208848 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278208848;
            } //End block
            nextStream();
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_231706915 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666529231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666529231;
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

