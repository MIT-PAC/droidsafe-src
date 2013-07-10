package org.apache.commons.io.output;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class ProxyWriter extends FilterWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.759 -0400", hash_original_method = "033B4CFD391086531B126612D5903ED1", hash_generated_method = "D79CCC2D9701130EB837876E07EFC628")
    public  ProxyWriter(Writer proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.762 -0400", hash_original_method = "94E64203D23ECC11F0966710C23548F3", hash_generated_method = "0ABBA075995969B3B91768424CBB42F9")
    @Override
    public Writer append(char c) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_1232138091 = null; 
        try 
        {
            beforeWrite(1);
            out.append(c);
            afterWrite(1);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1232138091 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1232138091.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1232138091;
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.765 -0400", hash_original_method = "391E9756F83F23FF347EF2129E3A0E99", hash_generated_method = "31D988F1AE5D8BD3C89C2B2F98494EB4")
    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_676904183 = null; 
        try 
        {
            beforeWrite(end - start);
            out.append(csq, start, end);
            afterWrite(end - start);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_676904183 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_676904183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_676904183;
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.766 -0400", hash_original_method = "AF511130F35AA3E3B287C842560F9DCE", hash_generated_method = "C1EB371BAF3EC889474A5948AE9A2E30")
    @Override
    public Writer append(CharSequence csq) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_1922535932 = null; 
        try 
        {
            int len = 0;
            {
                len = csq.length();
            } 
            beforeWrite(len);
            out.append(csq);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1922535932 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1922535932.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1922535932;
        
        
            
            
                
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.767 -0400", hash_original_method = "C10E35B15C5C34D2F11AD8F56A8AFBE7", hash_generated_method = "1EB9322108467DA4C5247F7E457F7B02")
    @Override
    public void write(int idx) throws IOException {
        try 
        {
            beforeWrite(1);
            out.write(idx);
            afterWrite(1);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(idx);
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.767 -0400", hash_original_method = "579B5F1267C3E5A23AE0501F4C0FD567", hash_generated_method = "F5DAFFDAC205B0F2FDFF9D8B1AAAA39F")
    @Override
    public void write(char[] chr) throws IOException {
        try 
        {
            int len = 0;
            {
                len = chr.length;
            } 
            beforeWrite(len);
            out.write(chr);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(chr[0]);
        
        
            
            
                
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.768 -0400", hash_original_method = "4BD1C735F7EB97F1200118825DBDCCC5", hash_generated_method = "BDD9621D828C3C2E87093A69A4AFBFEE")
    @Override
    public void write(char[] chr, int st, int len) throws IOException {
        try 
        {
            beforeWrite(len);
            out.write(chr, st, len);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(chr[0]);
        addTaint(st);
        addTaint(len);
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.768 -0400", hash_original_method = "6B60D7F6AE629840306B83B2B10FEDBF", hash_generated_method = "DE06630D9DD69B1AFCE7882C6D223AFD")
    @Override
    public void write(String str) throws IOException {
        try 
        {
            int len = 0;
            {
                len = str.length();
            } 
            beforeWrite(len);
            out.write(str);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(str.getTaint());
        
        
            
            
                
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.769 -0400", hash_original_method = "E5A50F6C55F59DD4142D90322431FA35", hash_generated_method = "D7C81C5C2B0EF2B381B61B35680E64DF")
    @Override
    public void write(String str, int st, int len) throws IOException {
        try 
        {
            beforeWrite(len);
            out.write(str, st, len);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(str.getTaint());
        addTaint(st);
        addTaint(len);
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.769 -0400", hash_original_method = "EEECDB779BCD3F1C16C4BB7414585E36", hash_generated_method = "F4E2890B99E6EE56D25924404E914D4A")
    @Override
    public void flush() throws IOException {
        try 
        {
            out.flush();
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.769 -0400", hash_original_method = "EA1F98341C1FEBB76DE541E0DAA4DDD0", hash_generated_method = "4AEAE5624C359BC6B9AE60F5188C3A93")
    @Override
    public void close() throws IOException {
        try 
        {
            out.close();
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.770 -0400", hash_original_method = "961C14EE073174624B2AA02C565F3907", hash_generated_method = "2210B044857E5790E2031B7C253A923D")
    protected void beforeWrite(int n) throws IOException {
        addTaint(n);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.770 -0400", hash_original_method = "634EDAC0BBD2C7E1FA3D5BDE9765B3F8", hash_generated_method = "9127223EA27B492B068981CDBB807693")
    protected void afterWrite(int n) throws IOException {
        addTaint(n);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.770 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        
        
    }

    
}

