package android.ddm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.os.Debug;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

public class DdmHandleProfiling extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.438 -0400", hash_original_method = "7648F12CCEF030214D1E836EAA9C8F00", hash_generated_method = "48A50242375078711F75A3CE1492C05E")
    private  DdmHandleProfiling() {
        
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.439 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.439 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.440 -0400", hash_original_method = "DB7D0E34713769F576AB6489AD8FC572", hash_generated_method = "0A86CEC9F3A99DBCE850510E73D5B7FE")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
    if(false){ }        int type = request.type;
    if(type == CHUNK_MPRS)        
        {
Chunk varD405333C63322055B29474A3DFF14577_1370638594 =             handleMPRS(request);
            varD405333C63322055B29474A3DFF14577_1370638594.addTaint(taint);
            return varD405333C63322055B29474A3DFF14577_1370638594;
        } 
        else
    if(type == CHUNK_MPRE)        
        {
Chunk varEE85602BCCDDB2639E754C4E833BB583_871079055 =             handleMPRE(request);
            varEE85602BCCDDB2639E754C4E833BB583_871079055.addTaint(taint);
            return varEE85602BCCDDB2639E754C4E833BB583_871079055;
        } 
        else
    if(type == CHUNK_MPSS)        
        {
Chunk var74879BCA06E2E0836EAAE8F98F749454_1908787558 =             handleMPSS(request);
            var74879BCA06E2E0836EAAE8F98F749454_1908787558.addTaint(taint);
            return var74879BCA06E2E0836EAAE8F98F749454_1908787558;
        } 
        else
    if(type == CHUNK_MPSE)        
        {
Chunk var77FCE6B01289CB3310D042893BB2A23D_2032033255 =             handleMPSE(request);
            var77FCE6B01289CB3310D042893BB2A23D_2032033255.addTaint(taint);
            return var77FCE6B01289CB3310D042893BB2A23D_2032033255;
        } 
        else
    if(type == CHUNK_MPRQ)        
        {
Chunk var641B7C200B55AD640B34A04578B16E05_1973653050 =             handleMPRQ(request);
            var641B7C200B55AD640B34A04578B16E05_1973653050.addTaint(taint);
            return var641B7C200B55AD640B34A04578B16E05_1973653050;
        } 
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1343610575 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1343610575.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1343610575;
        } 
        
        
            
        
        
            
        
            
        
            
        
            
        
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.441 -0400", hash_original_method = "7940F56C64BA10714BAFA7B4E80C835C", hash_generated_method = "9055FFC8E978CD853B32B5258D4F2E3B")
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
Chunk var540C13E9E156B687226421B24F2DF178_443479265 =             null;
            var540C13E9E156B687226421B24F2DF178_443479265.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_443479265;
        } 
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_423565279 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_423565279.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_423565279;
        } 
        
        
        
        
        
        
        
            
                
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.442 -0400", hash_original_method = "C47365EF242409DEE5C5F31B2C812A87", hash_generated_method = "47511561AFDE93BD45BB718C2CEE69B2")
    private Chunk handleMPRE(Chunk request) {
        addTaint(request.getTaint());
        byte result;
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } 
        catch (RuntimeException re)
        {
            result = 1;
        } 
        byte[] reply = { result };
Chunk varC625D22574896D3031709CE6201F38D1_1218828792 =         new Chunk(CHUNK_MPRE, reply, 0, reply.length);
        varC625D22574896D3031709CE6201F38D1_1218828792.addTaint(taint);
        return varC625D22574896D3031709CE6201F38D1_1218828792;
        
        
        
            
            
        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.443 -0400", hash_original_method = "0C48BE140EF77A3564208CCA411868CA", hash_generated_method = "4B50CC5CB6CFFBD66BEB2E0E5BF3D304")
    private Chunk handleMPSS(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int bufferSize = in.getInt();
        int flags = in.getInt();
    if(false)        
        {
        } 
        try 
        {
            Debug.startMethodTracingDdms(bufferSize, flags);
Chunk var540C13E9E156B687226421B24F2DF178_506757381 =             null;
            var540C13E9E156B687226421B24F2DF178_506757381.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_506757381;
        } 
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_2009849720 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_2009849720.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_2009849720;
        } 
        
        
        
        
        
            
                
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.444 -0400", hash_original_method = "47063ECEB662F521C374596F0F7AD1C6", hash_generated_method = "54CE46C2876CFF4079D9969102A57C88")
    private Chunk handleMPSE(Chunk request) {
        addTaint(request.getTaint());
        byte result;
    if(false)        
        {
        } 
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } 
        catch (RuntimeException re)
        {
Chunk varF626287F27C1788E68DEB751CDE022DB_901129872 =             createFailChunk(1, re.getMessage());
            varF626287F27C1788E68DEB751CDE022DB_901129872.addTaint(taint);
            return varF626287F27C1788E68DEB751CDE022DB_901129872;
        } 
Chunk var540C13E9E156B687226421B24F2DF178_1172900104 =         null;
        var540C13E9E156B687226421B24F2DF178_1172900104.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1172900104;
        
        
        
            
        
        
            
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.448 -0400", hash_original_method = "0E3CEBD2C4AA1513EB9DBAF86A751F94", hash_generated_method = "71DAC0BD848EDD14B53E230E80AF03AC")
    private Chunk handleMPRQ(Chunk request) {
        addTaint(request.getTaint());
        int result = Debug.isMethodTracingActive() ? 1 : 0;
        byte[] reply = { (byte) result };
Chunk var25AD3756722E7B0F4EEC2479B0EE1A88_579929714 =         new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
        var25AD3756722E7B0F4EEC2479B0EE1A88_579929714.addTaint(taint);
        return var25AD3756722E7B0F4EEC2479B0EE1A88_579929714;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.450 -0400", hash_original_field = "F5855C2CC22D4A653AC96BEEEDA26DA2", hash_generated_field = "7FFFFE3EB65969A45E28C911251E127E")

    public static final int CHUNK_MPRS = type("MPRS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.450 -0400", hash_original_field = "EE3CC7E6F5F4CCB0D28FF88878ACB038", hash_generated_field = "7F18F91381D75BE7FEA8B9EA463A84F4")

    public static final int CHUNK_MPRE = type("MPRE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.451 -0400", hash_original_field = "00DBD908EF0581304C88FAFB3BA10EEF", hash_generated_field = "27590C354FA31B4C05A287778E41C9D8")

    public static final int CHUNK_MPSS = type("MPSS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.451 -0400", hash_original_field = "78470172F92B6383D6DD1529F343A54F", hash_generated_field = "A2188CC3E8488D7886638119E037639F")

    public static final int CHUNK_MPSE = type("MPSE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.451 -0400", hash_original_field = "50342B8AC484C51A3C674CD2C378E988", hash_generated_field = "1621D64DD5751DA51B57A9D956F98541")

    public static final int CHUNK_MPRQ = type("MPRQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.452 -0400", hash_original_field = "0BC8A4CCE80D5531F80E14D9707C7F4F", hash_generated_field = "518411F24B65007CDBF385DFFC68993E")

    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();
}

