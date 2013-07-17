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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.260 -0400", hash_original_field = "DC1D71BBB5C4D2A5E936DB79EF10C19F", hash_generated_field = "B44E589F36524A8564E741C819F5943D")

    private Log log;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.261 -0400", hash_original_method = "B4B1AB4B499B8A15063D0CC014BEC991", hash_generated_method = "FBE8B17783F099F7154A4AC40DE90B09")
    public  Wire(Log log) {
        this.log = log;
        // ---------- Original Method ----------
        //this.log = log;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.263 -0400", hash_original_method = "8AB487D8D5FB9334AB649D48E9DFB74A", hash_generated_method = "96754D9F7E98A4F3A15C3BC8F64D7256")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.265 -0400", hash_original_method = "3293A063039621258FD717F75AAE20F6", hash_generated_method = "EA90335B1F231C0E03E9FF7F82D839BF")
    public boolean enabled() {
        boolean varF9714C35AB36CA5601F98E2200BBE3AC_1657933017 = (log.isDebugEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59478827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59478827;
        // ---------- Original Method ----------
        //return log.isDebugEnabled();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.265 -0400", hash_original_method = "41909751022A9CA66D19EAE8E0D21F96", hash_generated_method = "E74DB71056FE456161684EF741AEB283")
    public void output(InputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_1070719374 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_1070719374.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_1070719374;
        } //End block
        wire(">> ", outstream);
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", outstream);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.266 -0400", hash_original_method = "9B3D263B2ABEC36BE45DD8B457A2FB5F", hash_generated_method = "A19BF23A728A5F9B7413ACA099A2571C")
    public void input(InputStream instream) throws IOException {
        addTaint(instream.getTaint());
        if(instream == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_1327078901 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_1327078901.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_1327078901;
        } //End block
        wire("<< ", instream);
        // ---------- Original Method ----------
        //if (instream == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", instream);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.267 -0400", hash_original_method = "FC3E92A1F886275998FB021C6804D6A9", hash_generated_method = "61FF89E32BAD8A5162DFDDD5CDD414B1")
    public void output(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(b == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_1444674521 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_1444674521.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_1444674521;
        } //End block
        wire(">> ", new ByteArrayInputStream(b, off, len));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", new ByteArrayInputStream(b, off, len));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.268 -0400", hash_original_method = "7AB6B9BAC192F7B379ECF2E9CAEC39DE", hash_generated_method = "3CFC32BA63E3FC39217E308E48A6C673")
    public void input(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(b == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_173049316 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_173049316.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_173049316;
        } //End block
        wire("<< ", new ByteArrayInputStream(b, off, len));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", new ByteArrayInputStream(b, off, len));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.268 -0400", hash_original_method = "C456100C17A97A0094094ACD8A59EB30", hash_generated_method = "D409B6D6C4EE6E9932DF4E5BF8F55534")
    public void output(byte[] b) throws IOException {
        addTaint(b[0]);
        if(b == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_141353183 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_141353183.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_141353183;
        } //End block
        wire(">> ", new ByteArrayInputStream(b));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //wire(">> ", new ByteArrayInputStream(b));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.269 -0400", hash_original_method = "CACCE18D78F1F755698157152E4CF23A", hash_generated_method = "42BD715F0B4F34B6F5433D5977157D67")
    public void input(byte[] b) throws IOException {
        addTaint(b[0]);
        if(b == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_768046812 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_768046812.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_768046812;
        } //End block
        wire("<< ", new ByteArrayInputStream(b));
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //wire("<< ", new ByteArrayInputStream(b));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.270 -0400", hash_original_method = "98C5B0073473ADAA98ACDF73DE6F6267", hash_generated_method = "B4A46F207D2BBAC5A7EDB382988D2536")
    public void output(int b) throws IOException {
        addTaint(b);
        output(new byte[] {(byte) b});
        // ---------- Original Method ----------
        //output(new byte[] {(byte) b});
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.270 -0400", hash_original_method = "95BA17E717E6FE2824B7813CA2829BC6", hash_generated_method = "7D889AA18AF09DE3BF7D147223C2250C")
    public void input(int b) throws IOException {
        addTaint(b);
        input(new byte[] {(byte) b});
        // ---------- Original Method ----------
        //input(new byte[] {(byte) b});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.271 -0400", hash_original_method = "F3C5064419E81BE1694ED79F4A4E0F84", hash_generated_method = "5B36452DA0885C3AC8305BFA61262381")
    public void output(final String s) throws IOException {
        addTaint(s.getTaint());
        if(s == null)        
        {
            IllegalArgumentException var91ADD4620ED43F45967EB40A1A3359AB_808785450 = new IllegalArgumentException("Output may not be null");
            var91ADD4620ED43F45967EB40A1A3359AB_808785450.addTaint(taint);
            throw var91ADD4620ED43F45967EB40A1A3359AB_808785450;
        } //End block
        output(s.getBytes());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new IllegalArgumentException("Output may not be null"); 
        //}
        //output(s.getBytes());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.272 -0400", hash_original_method = "A406219181E10CB21A7EC7720CD1AF08", hash_generated_method = "1A51A22D37E02C6AA2F4DAA4177EEEEE")
    public void input(final String s) throws IOException {
        addTaint(s.getTaint());
        if(s == null)        
        {
            IllegalArgumentException varC4554915823C05F7220C82D9CA8CD62E_358507470 = new IllegalArgumentException("Input may not be null");
            varC4554915823C05F7220C82D9CA8CD62E_358507470.addTaint(taint);
            throw varC4554915823C05F7220C82D9CA8CD62E_358507470;
        } //End block
        input(s.getBytes());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new IllegalArgumentException("Input may not be null"); 
        //}
        //input(s.getBytes());
    }

    
}

