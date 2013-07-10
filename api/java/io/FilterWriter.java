package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class FilterWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.023 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.023 -0400", hash_original_method = "C9832951E5B51AA5FF45C56E637B6353", hash_generated_method = "0518BC8718C104755E1F89522C6C593B")
    protected  FilterWriter(Writer out) {
        super(out);
        this.out = out;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.023 -0400", hash_original_method = "05673170CC0D0E023F5651E2EFB2043A", hash_generated_method = "94C6CB902C2854801839EF30B1F788BE")
    @Override
    public void close() throws IOException {
        {
            out.close();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.024 -0400", hash_original_method = "6E517A9D20FAB02C8C7ECBD26B835783", hash_generated_method = "960BD9BBA6BC1ADBE288DF0F94F784FE")
    @Override
    public void flush() throws IOException {
        {
            out.flush();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.024 -0400", hash_original_method = "8844CE5B6BE403964369DBE67DE17A9B", hash_generated_method = "7D161DDB87EA579116A09D11C19820B6")
    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        {
            out.write(buffer, offset, count);
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.024 -0400", hash_original_method = "C0F1D18AD38B0E8F448CFE46E5D9188A", hash_generated_method = "7961F43820296547C7B25BCCA29A2B7C")
    @Override
    public void write(int oneChar) throws IOException {
        {
            out.write(oneChar);
        } 
        addTaint(oneChar);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.024 -0400", hash_original_method = "C7C8D1E997868E998D408F658DA19BDC", hash_generated_method = "5631F3D3A55B6B07C1F0B03BD8461C35")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        {
            out.write(str, offset, count);
        } 
        addTaint(str.getTaint());
        addTaint(offset);
        addTaint(count);
        
        
            
        
    }

    
}

