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
import android.os.Debug;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

public class DdmHandleProfiling extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.962 -0400", hash_original_method = "7648F12CCEF030214D1E836EAA9C8F00", hash_generated_method = "48A50242375078711F75A3CE1492C05E")
    @DSModeled(DSC.SAFE)
    private DdmHandleProfiling() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.962 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.962 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.963 -0400", hash_original_method = "DB7D0E34713769F576AB6489AD8FC572", hash_generated_method = "B0B2C86C8306DC57571C3E39E57A60C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int type;
        type = request.type;
        {
            Chunk varDB128DFFD2730D5C02C3694CE0E3C88D_1076790721 = (handleMPRS(request));
        } //End block
        {
            Chunk varA91AC8EE72F776D4ABF91026B2655B3F_1407864712 = (handleMPRE(request));
        } //End block
        {
            Chunk varE47FCEC5887C6602E6E9A67CA73BF78D_1811454169 = (handleMPSS(request));
        } //End block
        {
            Chunk var9C026BECF100FA4E7C4AE65131661506_1181321965 = (handleMPSE(request));
        } //End block
        {
            Chunk varDEAAA9ADE4110254CAA6C544ACBDE546_1633251894 = (handleMPRQ(request));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.963 -0400", hash_original_method = "7940F56C64BA10714BAFA7B4E80C835C", hash_generated_method = "7999F4D4D1905B5CA9DDE4316C94C5BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleMPRS(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        int bufferSize;
        bufferSize = in.getInt();
        int flags;
        flags = in.getInt();
        int len;
        len = in.getInt();
        String fileName;
        fileName = getString(in, len);
        try 
        {
            Debug.startMethodTracing(fileName, bufferSize, flags);
        } //End block
        catch (RuntimeException re)
        {
            Chunk var579AF8FCC4A99A623F7FE38F562FF3D4_1298736120 = (createFailChunk(1, re.getMessage()));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.964 -0400", hash_original_method = "C47365EF242409DEE5C5F31B2C812A87", hash_generated_method = "9E43F14F537E61A6255ACC856DC5BEBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleMPRE(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
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
        byte[] reply;
        Chunk var6AF297710BFE182F7442525999274790_340878088 = (new Chunk(CHUNK_MPRE, reply, 0, reply.length));
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.964 -0400", hash_original_method = "0C48BE140EF77A3564208CCA411868CA", hash_generated_method = "3F2C20FE5B4931C52B1BDC0F42EE40FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleMPSS(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        int bufferSize;
        bufferSize = in.getInt();
        int flags;
        flags = in.getInt();
        try 
        {
            Debug.startMethodTracingDdms(bufferSize, flags);
        } //End block
        catch (RuntimeException re)
        {
            Chunk var579AF8FCC4A99A623F7FE38F562FF3D4_2081250717 = (createFailChunk(1, re.getMessage()));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.964 -0400", hash_original_method = "47063ECEB662F521C374596F0F7AD1C6", hash_generated_method = "3F58355332444FF9FF4E7029B1EE061F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleMPSE(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        byte result;
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } //End block
        catch (RuntimeException re)
        {
            Chunk var579AF8FCC4A99A623F7FE38F562FF3D4_435665054 = (createFailChunk(1, re.getMessage()));
        } //End block
        return (Chunk)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.965 -0400", hash_original_method = "0E3CEBD2C4AA1513EB9DBAF86A751F94", hash_generated_method = "58C78DD31BF02D2AB921F4C09DADBC8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleMPRQ(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int result;
        boolean var1CCE90F3EA3D9C9EE69CE8E366F38561_1696464677 = (Debug.isMethodTracingActive());
        result = 1;
        result = 0;
        byte[] reply;
        Chunk varF4651DE4AE0EE2DF6DA3F15C003F1172_935075581 = (new Chunk(CHUNK_MPRQ, reply, 0, reply.length));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int result = Debug.isMethodTracingActive() ? 1 : 0;
        //byte[] reply = { (byte) result };
        //return new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
    }

    
    public static final int CHUNK_MPRS = type("MPRS");
    public static final int CHUNK_MPRE = type("MPRE");
    public static final int CHUNK_MPSS = type("MPSS");
    public static final int CHUNK_MPSE = type("MPSE");
    public static final int CHUNK_MPRQ = type("MPRQ");
    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();
}

