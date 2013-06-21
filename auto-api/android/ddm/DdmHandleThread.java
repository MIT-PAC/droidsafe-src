package android.ddm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;
import android.util.Log;
import java.nio.ByteBuffer;

public class DdmHandleThread extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.975 -0400", hash_original_method = "9014293089915C4268DF07C71EC6FF27", hash_generated_method = "FE5211883165D04E298E22C79DEA3B63")
    @DSModeled(DSC.SAFE)
    private DdmHandleThread() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.976 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.976 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.976 -0400", hash_original_method = "A7F2A84C27DF1EE7C10C6ACC7D9300BF", hash_generated_method = "4AD5C421866E848F5CE4682227484404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int type;
        type = request.type;
        {
            Chunk varA08E61E843BA70CBFE50956079D73ECC_198424114 = (handleTHEN(request));
        } //End block
        {
            Chunk varA7C340AEB8055F7EAC191468B5651D29_1379915504 = (handleTHST(request));
        } //End block
        {
            Chunk varFE7FCE2651454ED7AC13C7A8457673BC_1712370214 = (handleSTKL(request));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.977 -0400", hash_original_method = "BC156E08FEFB0A0F13BF2C52AB62FDFE", hash_generated_method = "E026C9C458A22BB15CC0D276A70AFABF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleTHEN(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        DdmVmInternal.threadNotify(enable);
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable = (in.get() != 0);
        //DdmVmInternal.threadNotify(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.977 -0400", hash_original_method = "2695125C08C32728E983ED92A17A93FC", hash_generated_method = "63D82C7AAA598A23E6197CF799727719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleTHST(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        byte[] status;
        status = DdmVmInternal.getThreadStats();
        Chunk var54B143A4B8CE07F159EEFF92ED4B257E_374359610 = (new Chunk(CHUNK_THST, status, 0, status.length));
        Chunk var2B596A8921193D4798407E272E134312_1577143477 = (createFailChunk(1, "Can't build THST chunk"));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //byte[] status = DdmVmInternal.getThreadStats();
        //if (status != null)
            //return new Chunk(CHUNK_THST, status, 0, status.length);
        //else
            //return createFailChunk(1, "Can't build THST chunk");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.978 -0400", hash_original_method = "D658C618BB2C2BBDA71F6A2C6E25EF76", hash_generated_method = "29FDA7A6F63B2E32F59D9783CC5C8D1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleSTKL(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        int threadId;
        threadId = in.getInt();
        StackTraceElement[] trace;
        trace = DdmVmInternal.getStackTraceById(threadId);
        {
            Chunk varA9927710B1F98F8E1F61BD2774A166C2_1656283922 = (createFailChunk(1, "Stack trace unavailable"));
        } //End block
        {
            Chunk varB3542A72377D64B0EAB1F596D175AE00_310911474 = (createStackChunk(trace, threadId));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.002 -0400", hash_original_method = "B0772B34720138634AE49D68BC346BA3", hash_generated_method = "02F17514144680DB94B2C59FE5A4CA1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk createStackChunk(StackTraceElement[] trace, int threadId) {
        dsTaint.addTaint(threadId);
        dsTaint.addTaint(trace[0].dsTaint);
        int bufferSize;
        bufferSize = 0;
        bufferSize += 4;
        bufferSize += 4;
        bufferSize += 4;
        {
            StackTraceElement elem = trace[0];
            {
                bufferSize += 4 + elem.getClassName().length() * 2;
                bufferSize += 4 + elem.getMethodName().length() * 2;
                bufferSize += 4;
                {
                    boolean var93B99DCE0D9ACE48F0C4400FF6C9D466_2097676702 = (elem.getFileName() != null);
                    bufferSize += elem.getFileName().length() * 2;
                } //End collapsed parenthetic
                bufferSize += 4;
            } //End block
        } //End collapsed parenthetic
        ByteBuffer out;
        out = ByteBuffer.allocate(bufferSize);
        out.putInt(0);
        out.putInt(threadId);
        out.putInt(trace.length);
        {
            StackTraceElement elem = trace[0];
            {
                out.putInt(elem.getClassName().length());
                putString(out, elem.getClassName());
                out.putInt(elem.getMethodName().length());
                putString(out, elem.getMethodName());
                {
                    boolean var93B99DCE0D9ACE48F0C4400FF6C9D466_1664355122 = (elem.getFileName() != null);
                    {
                        out.putInt(elem.getFileName().length());
                        putString(out, elem.getFileName());
                    } //End block
                    {
                        out.putInt(0);
                    } //End block
                } //End collapsed parenthetic
                out.putInt(elem.getLineNumber());
            } //End block
        } //End collapsed parenthetic
        Chunk var97F09A30E534748433B728A1418A337E_324533371 = (new Chunk(CHUNK_STKL, out));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final int CHUNK_THEN = type("THEN");
    public static final int CHUNK_THCR = type("THCR");
    public static final int CHUNK_THDE = type("THDE");
    public static final int CHUNK_THST = type("THST");
    public static final int CHUNK_STKL = type("STKL");
    private static DdmHandleThread mInstance = new DdmHandleThread();
}

