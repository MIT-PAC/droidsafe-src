package android.ddm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import android.os.Debug;





public class DdmHandleProfiling extends ChunkHandler {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.262 -0400", hash_original_method = "7648F12CCEF030214D1E836EAA9C8F00", hash_generated_method = "48A50242375078711F75A3CE1492C05E")
    private  DdmHandleProfiling() {
        // ---------- Original Method ----------
    }

    
    public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.263 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.263 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.264 -0400", hash_original_method = "DB7D0E34713769F576AB6489AD8FC572", hash_generated_method = "ADA4A4D65684DE5B92D019A7B0ACAD9F")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        if(false){ }        int type = request.type;
        if(type == CHUNK_MPRS)        
        {
Chunk varD405333C63322055B29474A3DFF14577_1821260640 =             handleMPRS(request);
            varD405333C63322055B29474A3DFF14577_1821260640.addTaint(taint);
            return varD405333C63322055B29474A3DFF14577_1821260640;
        } //End block
        else
        if(type == CHUNK_MPRE)        
        {
Chunk varEE85602BCCDDB2639E754C4E833BB583_548534922 =             handleMPRE(request);
            varEE85602BCCDDB2639E754C4E833BB583_548534922.addTaint(taint);
            return varEE85602BCCDDB2639E754C4E833BB583_548534922;
        } //End block
        else
        if(type == CHUNK_MPSS)        
        {
Chunk var74879BCA06E2E0836EAAE8F98F749454_150555016 =             handleMPSS(request);
            var74879BCA06E2E0836EAAE8F98F749454_150555016.addTaint(taint);
            return var74879BCA06E2E0836EAAE8F98F749454_150555016;
        } //End block
        else
        if(type == CHUNK_MPSE)        
        {
Chunk var77FCE6B01289CB3310D042893BB2A23D_367638574 =             handleMPSE(request);
            var77FCE6B01289CB3310D042893BB2A23D_367638574.addTaint(taint);
            return var77FCE6B01289CB3310D042893BB2A23D_367638574;
        } //End block
        else
        if(type == CHUNK_MPRQ)        
        {
Chunk var641B7C200B55AD640B34A04578B16E05_1824037277 =             handleMPRQ(request);
            var641B7C200B55AD640B34A04578B16E05_1824037277.addTaint(taint);
            return var641B7C200B55AD640B34A04578B16E05_1824037277;
        } //End block
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_903079637 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_903079637.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_903079637;
        } //End block
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-heap", "Handling " + name(request.type) + " chunk");
        //int type = request.type;
        //if (type == CHUNK_MPRS) {
            //return handleMPRS(request);
        //} else if (type == CHUNK_MPRE) {
            //return handleMPRE(request);
        //} else if (type == CHUNK_MPSS) {
            //return handleMPSS(request);
        //} else if (type == CHUNK_MPSE) {
            //return handleMPSE(request);
        //} else if (type == CHUNK_MPRQ) {
            //return handleMPRQ(request);
        //} else {
            //throw new RuntimeException("Unknown packet "
                //+ ChunkHandler.name(type));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.267 -0400", hash_original_method = "7940F56C64BA10714BAFA7B4E80C835C", hash_generated_method = "B4E949CDCB39203728C98E0F3AB58133")
    private Chunk handleMPRS(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int bufferSize = in.getInt();
        int flags = in.getInt();
        int len = in.getInt();
        String fileName = getString(in, len);
        if(false){ }        try 
        {
            Debug.startMethodTracing(fileName, bufferSize, flags);
Chunk var540C13E9E156B687226421B24F2DF178_1671660048 =             null;
            var540C13E9E156B687226421B24F2DF178_1671660048.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1671660048;
        } //End block
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_240016260 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_240016260.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_240016260;
        } //End block
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //int bufferSize = in.getInt();
        //int flags = in.getInt();
        //int len = in.getInt();
        //String fileName = getString(in, len);
        //if (false)
            //Log.v("ddm-heap", "Method profiling start: filename='" + fileName
                //+ "', size=" + bufferSize + ", flags=" + flags);
        //try {
            //Debug.startMethodTracing(fileName, bufferSize, flags);
            //return null;        
        //} catch (RuntimeException re) {
            //return createFailChunk(1, re.getMessage());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.269 -0400", hash_original_method = "C47365EF242409DEE5C5F31B2C812A87", hash_generated_method = "F0EF1B81CEA9DE5BF4A135AD7147A688")
    private Chunk handleMPRE(Chunk request) {
        addTaint(request.getTaint());
        byte result;
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } //End block
        catch (RuntimeException re)
        {
            result = 1;
        } //End block
        byte[] reply = { result };
Chunk varC625D22574896D3031709CE6201F38D1_1799395641 =         new Chunk(CHUNK_MPRE, reply, 0, reply.length);
        varC625D22574896D3031709CE6201F38D1_1799395641.addTaint(taint);
        return varC625D22574896D3031709CE6201F38D1_1799395641;
        // ---------- Original Method ----------
        //byte result;
        //try {
            //Debug.stopMethodTracing();
            //result = 0;
        //} catch (RuntimeException re) {
            //Log.w("ddm-heap", "Method profiling end failed: "
                //+ re.getMessage());
            //result = 1;
        //}
        //byte[] reply = { result };
        //return new Chunk(CHUNK_MPRE, reply, 0, reply.length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.270 -0400", hash_original_method = "0C48BE140EF77A3564208CCA411868CA", hash_generated_method = "83CEC5F43E781EAD09B7F28F4A37AC4F")
    private Chunk handleMPSS(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int bufferSize = in.getInt();
        int flags = in.getInt();
        if(false)        
        {
        } //End block
        try 
        {
            Debug.startMethodTracingDdms(bufferSize, flags);
Chunk var540C13E9E156B687226421B24F2DF178_1754943399 =             null;
            var540C13E9E156B687226421B24F2DF178_1754943399.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1754943399;
        } //End block
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_357964433 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_357964433.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_357964433;
        } //End block
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //int bufferSize = in.getInt();
        //int flags = in.getInt();
        //if (false) {
            //Log.v("ddm-heap", "Method prof stream start: size=" + bufferSize
                //+ ", flags=" + flags);
        //}
        //try {
            //Debug.startMethodTracingDdms(bufferSize, flags);
            //return null;        
        //} catch (RuntimeException re) {
            //return createFailChunk(1, re.getMessage());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.272 -0400", hash_original_method = "47063ECEB662F521C374596F0F7AD1C6", hash_generated_method = "5D7A522AE3EF0D6D25D34B6D83CEB448")
    private Chunk handleMPSE(Chunk request) {
        addTaint(request.getTaint());
        byte result;
        if(false)        
        {
        } //End block
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } //End block
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_1411458984 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_1411458984.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_1411458984;
        } //End block
Chunk var540C13E9E156B687226421B24F2DF178_1092363666 =         null;
        var540C13E9E156B687226421B24F2DF178_1092363666.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1092363666;
        // ---------- Original Method ----------
        //byte result;
        //if (false) {
            //Log.v("ddm-heap", "Method prof stream end");
        //}
        //try {
            //Debug.stopMethodTracing();
            //result = 0;
        //} catch (RuntimeException re) {
            //Log.w("ddm-heap", "Method prof stream end failed: "
                //+ re.getMessage());
            //return createFailChunk(1, re.getMessage());
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.273 -0400", hash_original_method = "0E3CEBD2C4AA1513EB9DBAF86A751F94", hash_generated_method = "10DF811D0161C9366CC037DEF8DA6EB8")
    private Chunk handleMPRQ(Chunk request) {
        addTaint(request.getTaint());
        int result = Debug.isMethodTracingActive() ? 1 : 0;
        byte[] reply = { (byte) result };
Chunk var25AD3756722E7B0F4EEC2479B0EE1A88_108086786 =         new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
        var25AD3756722E7B0F4EEC2479B0EE1A88_108086786.addTaint(taint);
        return var25AD3756722E7B0F4EEC2479B0EE1A88_108086786;
        // ---------- Original Method ----------
        //int result = Debug.isMethodTracingActive() ? 1 : 0;
        //byte[] reply = { (byte) result };
        //return new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.273 -0400", hash_original_field = "F5855C2CC22D4A653AC96BEEEDA26DA2", hash_generated_field = "7FFFFE3EB65969A45E28C911251E127E")

    public static final int CHUNK_MPRS = type("MPRS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.274 -0400", hash_original_field = "EE3CC7E6F5F4CCB0D28FF88878ACB038", hash_generated_field = "7F18F91381D75BE7FEA8B9EA463A84F4")

    public static final int CHUNK_MPRE = type("MPRE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.274 -0400", hash_original_field = "00DBD908EF0581304C88FAFB3BA10EEF", hash_generated_field = "27590C354FA31B4C05A287778E41C9D8")

    public static final int CHUNK_MPSS = type("MPSS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.274 -0400", hash_original_field = "78470172F92B6383D6DD1529F343A54F", hash_generated_field = "A2188CC3E8488D7886638119E037639F")

    public static final int CHUNK_MPSE = type("MPSE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.274 -0400", hash_original_field = "50342B8AC484C51A3C674CD2C378E988", hash_generated_field = "1621D64DD5751DA51B57A9D956F98541")

    public static final int CHUNK_MPRQ = type("MPRQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.274 -0400", hash_original_field = "0BC8A4CCE80D5531F80E14D9707C7F4F", hash_generated_field = "518411F24B65007CDBF385DFFC68993E")

    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();
}

