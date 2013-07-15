package org.apache.commons.io.output;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProxyOutputStream extends FilterOutputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.746 -0400", hash_original_method = "994F669A59E4B3A0EE398298B336F810", hash_generated_method = "4A02CEA12D4DA08BE8C171559684AE92")
    public  ProxyOutputStream(OutputStream proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.747 -0400", hash_original_method = "C10E35B15C5C34D2F11AD8F56A8AFBE7", hash_generated_method = "1EB9322108467DA4C5247F7E457F7B02")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.747 -0400", hash_original_method = "E4B5E15EBD1DC0F51B6909882AA2B9D3", hash_generated_method = "F4E34B83D1F14807C1DAEFC9962EEBD5")
    @Override
    public void write(byte[] bts) throws IOException {
        try 
        {
            int len;
            len = bts.length;
            len = 0;
            beforeWrite(len);
            out.write(bts);
            afterWrite(len);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(bts[0]);
        
        
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.747 -0400", hash_original_method = "6659C26B9D2F6D845755120D9E3C542C", hash_generated_method = "217D7A766B6705DA4C6D2740C7645D3D")
    @Override
    public void write(byte[] bts, int st, int end) throws IOException {
        try 
        {
            beforeWrite(end);
            out.write(bts, st, end);
            afterWrite(end);
        } 
        catch (IOException e)
        {
            handleIOException(e);
        } 
        addTaint(bts[0]);
        addTaint(st);
        addTaint(end);
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.748 -0400", hash_original_method = "EEECDB779BCD3F1C16C4BB7414585E36", hash_generated_method = "F4E2890B99E6EE56D25924404E914D4A")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.748 -0400", hash_original_method = "EA1F98341C1FEBB76DE541E0DAA4DDD0", hash_generated_method = "4AEAE5624C359BC6B9AE60F5188C3A93")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.748 -0400", hash_original_method = "961C14EE073174624B2AA02C565F3907", hash_generated_method = "2210B044857E5790E2031B7C253A923D")
    protected void beforeWrite(int n) throws IOException {
        addTaint(n);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.748 -0400", hash_original_method = "634EDAC0BBD2C7E1FA3D5BDE9765B3F8", hash_generated_method = "9127223EA27B492B068981CDBB807693")
    protected void afterWrite(int n) throws IOException {
        addTaint(n);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.749 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        
        
    }

    
}

