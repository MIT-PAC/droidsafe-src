package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.apache.commons.logging.Log;

public class Wire {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.955 -0400", hash_original_field = "DC1D71BBB5C4D2A5E936DB79EF10C19F", hash_generated_field = "B44E589F36524A8564E741C819F5943D")

    private Log log;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.956 -0400", hash_original_method = "B4B1AB4B499B8A15063D0CC014BEC991", hash_generated_method = "FBE8B17783F099F7154A4AC40DE90B09")
    public  Wire(Log log) {
        this.log = log;
        // ---------- Original Method ----------
        //this.log = log;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.957 -0400", hash_original_method = "8AB487D8D5FB9334AB649D48E9DFB74A", hash_generated_method = "96754D9F7E98A4F3A15C3BC8F64D7256")
    private void wire(String header, InputStream instream) throws IOException {
        addTaint(instream.getTaint());
        addTaint(header.getTaint());
        StringBuilder buffer = new StringBuilder();
        int ch;
        while
((ch = instream.read()) != -1)        
        {
    if(ch == 13)            
            {
                buffer.append("[\\r]");
            } //End block
            else
    if(ch == 10)            
            {
                buffer.append("[\\n]\"");
                buffer.insert(0, "\"");
                buffer.insert(0, header);
                log.debug(buffer.toString());
                buffer.setLength(0);
            } //End block
            else
    if((ch < 32) || (ch > 127))            
            {
                buffer.append("[0x");
                buffer.append(Integer.toHexString(ch));
                buffer.append("]");
            } //End block
            else
            {
                buffer.append((char) ch);
            } //End block
        } //End block
    if(buffer.length() > 0)        
        {
            buffer.append('\"');
            buffer.insert(0, '\"');
            buffer.insert(0, header);
            log.debug(buffer.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.957 -0400", hash_original_method = "3293A063039621258FD717F75AAE20F6", hash_generated_method = "E39921ECFA6DB14FD11027FF246BBAF4")
    public boolean enabled() {
        boolean varF9714C35AB36CA5601F98E2200BBE3AC_118993757 = (log.isDebugEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691057198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691057198;
        // ---------- Original Method ----------
        //return log.isDebugEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.958 -0400", hash_original_method = "41909751022A9CA66D19EAE8E0D21F96", hash_generated_method = "903B9466C12F472E25550F1FD53AA1D5")
    public void output(InputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
    if(outstream == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_853583713 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_853583713.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_853583713;
        } //End block
        wire(">> ", outstream);
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", outstream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.958 -0400", hash_original_method = "9B3D263B2ABEC36BE45DD8B457A2FB5F", hash_generated_method = "449AF39614183BD4E1DED6A2B708202A")
    public void input(InputStream instream) throws IOException {
        addTaint(instream.getTaint());
    if(instream == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_1305972580 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_1305972580.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_1305972580;
        } //End block
        wire("<< ", instream);
        // ---------- Original Method ----------
        //if (instream == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", instream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.959 -0400", hash_original_method = "FC3E92A1F886275998FB021C6804D6A9", hash_generated_method = "989672677B6860D8E7507821C13E670B")
    public void output(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(b == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_1270579546 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_1270579546.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_1270579546;
        } //End block
        wire(">> ", new ByteArrayInputStream(b, off, len));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", new ByteArrayInputStream(b, off, len));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.959 -0400", hash_original_method = "7AB6B9BAC192F7B379ECF2E9CAEC39DE", hash_generated_method = "6A55CA41A17DF78D90C8C78542CE1859")
    public void input(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(b == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_2068486751 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_2068486751.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_2068486751;
        } //End block
        wire("<< ", new ByteArrayInputStream(b, off, len));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", new ByteArrayInputStream(b, off, len));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.959 -0400", hash_original_method = "C456100C17A97A0094094ACD8A59EB30", hash_generated_method = "14FBD79C14C609CFEE03B269734DE694")
    public void output(byte[] b) throws IOException {
        addTaint(b[0]);
    if(b == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_1910314813 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_1910314813.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_1910314813;
        } //End block
        wire(">> ", new ByteArrayInputStream(b));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", new ByteArrayInputStream(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.960 -0400", hash_original_method = "CACCE18D78F1F755698157152E4CF23A", hash_generated_method = "39727B4F684EBBA0DF3429200AAB68CF")
    public void input(byte[] b) throws IOException {
        addTaint(b[0]);
    if(b == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_1461168558 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_1461168558.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_1461168558;
        } //End block
        wire("<< ", new ByteArrayInputStream(b));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", new ByteArrayInputStream(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.960 -0400", hash_original_method = "98C5B0073473ADAA98ACDF73DE6F6267", hash_generated_method = "B4A46F207D2BBAC5A7EDB382988D2536")
    public void output(int b) throws IOException {
        addTaint(b);
        output(new byte[] {(byte) b});
        // ---------- Original Method ----------
        //output(new byte[] {(byte) b});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.960 -0400", hash_original_method = "95BA17E717E6FE2824B7813CA2829BC6", hash_generated_method = "7D889AA18AF09DE3BF7D147223C2250C")
    public void input(int b) throws IOException {
        addTaint(b);
        input(new byte[] {(byte) b});
        // ---------- Original Method ----------
        //input(new byte[] {(byte) b});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.961 -0400", hash_original_method = "F3C5064419E81BE1694ED79F4A4E0F84", hash_generated_method = "8A0469DBB3E0B00486BDE8556C95B34D")
    public void output(final String s) throws IOException {
        addTaint(s.getTaint());
    if(s == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_1190661733 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_1190661733.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_1190661733;
        } //End block
        output(s.getBytes());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //output(s.getBytes());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.961 -0400", hash_original_method = "A406219181E10CB21A7EC7720CD1AF08", hash_generated_method = "E7B01A698325550E10875CA6226552BB")
    public void input(final String s) throws IOException {
        addTaint(s.getTaint());
    if(s == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_1259894303 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_1259894303.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_1259894303;
        } //End block
        input(s.getBytes());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //input(s.getBytes());
    }

    
}

