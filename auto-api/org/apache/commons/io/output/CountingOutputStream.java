package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.OutputStream;

public class CountingOutputStream extends ProxyOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.368 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "F29FC271FD334863B167C81AE0015DDD")

    private long count = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.368 -0400", hash_original_method = "1D97F6B1ACCFDEF880E62EA3C5F540FF", hash_generated_method = "8F45D9E6FBE8B156244ABD928F33BDCB")
    public  CountingOutputStream( OutputStream out ) {
        super(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.375 -0400", hash_original_method = "06A3A1AA076BADB04E4D922D26953A96", hash_generated_method = "D61040F019D093286583FA8CB82CAEF6")
    @Override
    protected synchronized void beforeWrite(int n) {
        count += n;
        // ---------- Original Method ----------
        //count += n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.375 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "240531426103B0912BB049D0FDA6B6EA")
    public int getCount() {
        long result;
        result = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854133725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1854133725;
        // ---------- Original Method ----------
        //long result = getByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.376 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "D887E601B6AF7D3206F9A2390AB9CF52")
    public int resetCount() {
        long result;
        result = resetByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031556801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031556801;
        // ---------- Original Method ----------
        //long result = resetByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.376 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "218403E604953758A5F7992E9862D660")
    public synchronized long getByteCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1620047901 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1620047901;
        // ---------- Original Method ----------
        //return this.count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.377 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "9C8C3512A24DE93BC8F7355EB1745F73")
    public synchronized long resetByteCount() {
        long tmp;
        tmp = this.count;
        this.count = 0;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_24168262 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_24168262;
        // ---------- Original Method ----------
        //long tmp = this.count;
        //this.count = 0;
        //return tmp;
    }

    
}

