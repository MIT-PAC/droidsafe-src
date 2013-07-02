package org.apache.commons.io.output;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.OutputStream;

public class CountingOutputStream extends ProxyOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.654 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "F29FC271FD334863B167C81AE0015DDD")

    private long count = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.654 -0400", hash_original_method = "1D97F6B1ACCFDEF880E62EA3C5F540FF", hash_generated_method = "8F45D9E6FBE8B156244ABD928F33BDCB")
    public  CountingOutputStream( OutputStream out ) {
        super(out);
        addTaint(out.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.655 -0400", hash_original_method = "06A3A1AA076BADB04E4D922D26953A96", hash_generated_method = "D61040F019D093286583FA8CB82CAEF6")
    @Override
    protected synchronized void beforeWrite(int n) {
        count += n;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.655 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "022CAC1C44E21A518ED30FB8660D5E09")
    public int getCount() {
        long result = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042607356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042607356;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.655 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "4EA9C5E9AC00B820A8A7FD2BA981EC3A")
    public int resetCount() {
        long result = resetByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125675907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125675907;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.656 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "8779F82A64EF78F31D7146527022D08C")
    public synchronized long getByteCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1731318489 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1731318489;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.656 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "166B4D28AC13A69590318E06A28CBE98")
    public synchronized long resetByteCount() {
        long tmp = this.count;
        this.count = 0;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2097481897 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2097481897;
        
        
        
        
    }

    
}

