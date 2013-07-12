package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.999 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "18AD9586F739C9162783E991FCA98C7A")

    private Enumeration<? extends InputStream> e;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:48.999 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.000 -0400", hash_original_method = "29105F0198123C3B47FC811BDEDF639D", hash_generated_method = "AC54376F30B72AF1ED81C0530AE4D718")
    public  SequenceInputStream(InputStream s1, InputStream s2) {
        addTaint(s2.getTaint());
    if(s1 == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1625151410 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1625151410.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1625151410;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.001 -0400", hash_original_method = "4836B5679700B3654AB08A07E2FBBEF0", hash_generated_method = "5831835CAB4FA1610202FC39F2109FEE")
    public  SequenceInputStream(Enumeration<? extends InputStream> e) {
        this.e = e;
    if(e.hasMoreElements())        
        {
            in = e.nextElement();
    if(in == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_960806365 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_960806365.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_960806365;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.001 -0400", hash_original_method = "989AE899244AE453B2C16F0363EA8BF3", hash_generated_method = "A59391C28D99C8453B8E861F563767DB")
    @Override
    public int available() throws IOException {
    if(e != null && in != null)        
        {
            int var443A4CD22A314221356D4EA83AFE1E61_1022427586 = (in.available());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171986611 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171986611;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1167787380 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210004351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210004351;
        // ---------- Original Method ----------
        //if (e != null && in != null) {
            //return in.available();
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.002 -0400", hash_original_method = "1749070D39A948E7280B7E9ED33867CE", hash_generated_method = "2B90943E030B1A00BD1A5769357CB8FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.002 -0400", hash_original_method = "AA61F30EE9F68EF2787A55BE84FD9C61", hash_generated_method = "A690DA2B0F20A7343B3E824C7EA69170")
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
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1737663066 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1737663066.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1737663066;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.003 -0400", hash_original_method = "2AFBD8CC3EA20986AC27924C0AD5D7EE", hash_generated_method = "7AF27550205695D0DD7618C660C9DFED")
    @Override
    public int read() throws IOException {
        while
(in != null)        
        {
            int result = in.read();
    if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_1053741861 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714198702 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714198702;
            } //End block
            nextStream();
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_715763770 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103124616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103124616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:49.003 -0400", hash_original_method = "D0BE57C4BCBFEEAAABF8F255E34909BC", hash_generated_method = "8B62B27106C9644B24FDB32DC58BD644")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
    if(in == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_118748114 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943969314 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943969314;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        while
(in != null)        
        {
            int result = in.read(buffer, offset, count);
    if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_1023144275 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862972097 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862972097;
            } //End block
            nextStream();
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2056328797 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498703944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498703944;
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

