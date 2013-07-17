package android.ddm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;
import android.util.Log;
import java.nio.ByteBuffer;

public class DdmHandleThread extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.303 -0400", hash_original_method = "9014293089915C4268DF07C71EC6FF27", hash_generated_method = "FE5211883165D04E298E22C79DEA3B63")
    private  DdmHandleThread() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.303 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.304 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.305 -0400", hash_original_method = "A7F2A84C27DF1EE7C10C6ACC7D9300BF", hash_generated_method = "6D8FE241BF25C9474BD2342F7C7D48AD")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        if(false){ }        int type = request.type;
        if(type == CHUNK_THEN)        
        {
Chunk varB2CDA7F3AC4EF82CE796D2D7EC33BFF3_1490652424 =             handleTHEN(request);
            varB2CDA7F3AC4EF82CE796D2D7EC33BFF3_1490652424.addTaint(taint);
            return varB2CDA7F3AC4EF82CE796D2D7EC33BFF3_1490652424;
        } //End block
        else
        if(type == CHUNK_THST)        
        {
Chunk varC8251A98ECB04F47D00B0AE8F4D8B30B_1743366282 =             handleTHST(request);
            varC8251A98ECB04F47D00B0AE8F4D8B30B_1743366282.addTaint(taint);
            return varC8251A98ECB04F47D00B0AE8F4D8B30B_1743366282;
        } //End block
        else
        if(type == CHUNK_STKL)        
        {
Chunk var915E84D3B2DBFD5953D12B23FDC42D0B_1876171072 =             handleSTKL(request);
            var915E84D3B2DBFD5953D12B23FDC42D0B_1876171072.addTaint(taint);
            return var915E84D3B2DBFD5953D12B23FDC42D0B_1876171072;
        } //End block
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1274723587 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1274723587.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1274723587;
        } //End block
        // ---------- Original Method ----------
        //if (false)
            //Log.v("ddm-thread", "Handling " + name(request.type) + " chunk");
        //int type = request.type;
        //if (type == CHUNK_THEN) {
            //return handleTHEN(request);
        //} else if (type == CHUNK_THST) {
            //return handleTHST(request);
        //} else if (type == CHUNK_STKL) {
            //return handleSTKL(request);
        //} else {
            //throw new RuntimeException("Unknown packet "
                //+ ChunkHandler.name(type));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.306 -0400", hash_original_method = "BC156E08FEFB0A0F13BF2C52AB62FDFE", hash_generated_method = "3BE3DCF347FE757DB057BAD567E22977")
    private Chunk handleTHEN(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        boolean enable = (in.get() != 0);
        DdmVmInternal.threadNotify(enable);
Chunk var540C13E9E156B687226421B24F2DF178_1764613891 =         null;
        var540C13E9E156B687226421B24F2DF178_1764613891.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1764613891;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable = (in.get() != 0);
        //DdmVmInternal.threadNotify(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.307 -0400", hash_original_method = "2695125C08C32728E983ED92A17A93FC", hash_generated_method = "F34786EAAB215FD61015363B34355849")
    private Chunk handleTHST(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        byte[] status = DdmVmInternal.getThreadStats();
        if(status != null)        
        {
Chunk varF59E9937ECA8DC4D04EFCA3808CA7AB3_678724639 =         new Chunk(CHUNK_THST, status, 0, status.length);
        varF59E9937ECA8DC4D04EFCA3808CA7AB3_678724639.addTaint(taint);
        return varF59E9937ECA8DC4D04EFCA3808CA7AB3_678724639;
        }
        else
        {
Chunk var3F84CD09A45C8D277213099EBB773786_2028604339 =         createFailChunk(1, "Can't build THST chunk");
        var3F84CD09A45C8D277213099EBB773786_2028604339.addTaint(taint);
        return var3F84CD09A45C8D277213099EBB773786_2028604339;
        }
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //byte[] status = DdmVmInternal.getThreadStats();
        //if (status != null)
            //return new Chunk(CHUNK_THST, status, 0, status.length);
        //else
            //return createFailChunk(1, "Can't build THST chunk");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.307 -0400", hash_original_method = "D658C618BB2C2BBDA71F6A2C6E25EF76", hash_generated_method = "D945A38D399695A288E42D37E0A9F50E")
    private Chunk handleSTKL(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int threadId;
        threadId = in.getInt();
        StackTraceElement[] trace = DdmVmInternal.getStackTraceById(threadId);
        if(trace == null)        
        {
Chunk var8CA022FB90C2D87C64EE58731230EEDE_783467546 =             createFailChunk(1, "Stack trace unavailable");
            var8CA022FB90C2D87C64EE58731230EEDE_783467546.addTaint(taint);
            return var8CA022FB90C2D87C64EE58731230EEDE_783467546;
        } //End block
        else
        {
Chunk var406F849EDFDF4E0E2112FC951EC90BBE_1736767733 =             createStackChunk(trace, threadId);
            var406F849EDFDF4E0E2112FC951EC90BBE_1736767733.addTaint(taint);
            return var406F849EDFDF4E0E2112FC951EC90BBE_1736767733;
        } //End block
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //int threadId;
        //threadId = in.getInt();
        //StackTraceElement[] trace = DdmVmInternal.getStackTraceById(threadId);
        //if (trace == null) {
            //return createFailChunk(1, "Stack trace unavailable");
        //} else {
            //return createStackChunk(trace, threadId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_method = "B0772B34720138634AE49D68BC346BA3", hash_generated_method = "BA09AC7F7D00E444B92CE4DAB5151D8D")
    private Chunk createStackChunk(StackTraceElement[] trace, int threadId) {
        addTaint(threadId);
        addTaint(trace[0].getTaint());
        int bufferSize = 0;
        bufferSize += 4;
        bufferSize += 4;
        bufferSize += 4;
for(StackTraceElement elem : trace)
        {
            bufferSize += 4 + elem.getClassName().length() * 2;
            bufferSize += 4 + elem.getMethodName().length() * 2;
            bufferSize += 4;
            if(elem.getFileName() != null)            
            bufferSize += elem.getFileName().length() * 2;
            bufferSize += 4;
        } //End block
        ByteBuffer out = ByteBuffer.allocate(bufferSize);
        out.putInt(0);
        out.putInt(threadId);
        out.putInt(trace.length);
for(StackTraceElement elem : trace)
        {
            out.putInt(elem.getClassName().length());
            putString(out, elem.getClassName());
            out.putInt(elem.getMethodName().length());
            putString(out, elem.getMethodName());
            if(elem.getFileName() != null)            
            {
                out.putInt(elem.getFileName().length());
                putString(out, elem.getFileName());
            } //End block
            else
            {
                out.putInt(0);
            } //End block
            out.putInt(elem.getLineNumber());
        } //End block
Chunk varA57913B67BC896B770CE2FE3F68C25A2_344000403 =         new Chunk(CHUNK_STKL, out);
        varA57913B67BC896B770CE2FE3F68C25A2_344000403.addTaint(taint);
        return varA57913B67BC896B770CE2FE3F68C25A2_344000403;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "DD50DBD67A5E5DC1110188F9F71C903E", hash_generated_field = "6FD8B0A025617CAABDC74F5512BD1925")

    public static final int CHUNK_THEN = type("THEN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "01CEDF6E4A0B4BF2A1DFCF52F7C7E336", hash_generated_field = "76B61FBE133D3C178633BE3ED16C7D88")

    public static final int CHUNK_THCR = type("THCR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "A60580E875FCE044104AAB21C07B6657", hash_generated_field = "6C54A1712C9684C82DFE10C559A7239B")

    public static final int CHUNK_THDE = type("THDE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "BDA31750CF04DAD7FEF6959DFBE41BDC", hash_generated_field = "0037B4EAFA33D36A94E59F46954153B0")

    public static final int CHUNK_THST = type("THST");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "02E3E404B7350BC0FCCEAF2613E84FEC", hash_generated_field = "05661DA41737F5FE00F60ABE023BA158")

    public static final int CHUNK_STKL = type("STKL");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.310 -0400", hash_original_field = "7633E0A01D950255DC3FF633A87D0525", hash_generated_field = "80D0E25C8F1F0092137DF49E7789674E")

    private static DdmHandleThread mInstance = new DdmHandleThread();
}

