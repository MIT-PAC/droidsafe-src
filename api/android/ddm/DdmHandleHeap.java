package android.ddm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import org.apache.harmony.dalvik.ddmc.DdmVmInternal;

import android.os.Debug;
import android.util.Log;

public class DdmHandleHeap extends ChunkHandler {

    /**
     * Register for the messages we're interested in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.839 -0500", hash_original_method = "1FFC4B4C2E79E9CC23B79BF8518B2CC3", hash_generated_method = "19FA681955D461FBB93FC0FCED0FD2DE")
    
public static void register() {
        DdmServer.registerHandler(CHUNK_HPIF, mInstance);
        DdmServer.registerHandler(CHUNK_HPSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPDU, mInstance);
        DdmServer.registerHandler(CHUNK_HPDS, mInstance);
        DdmServer.registerHandler(CHUNK_NHSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPGC, mInstance);
        DdmServer.registerHandler(CHUNK_REAE, mInstance);
        DdmServer.registerHandler(CHUNK_REAQ, mInstance);
        DdmServer.registerHandler(CHUNK_REAL, mInstance);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.811 -0500", hash_original_field = "02C9789580638B8C7211F58E7804CFD7", hash_generated_field = "411BA0ACAF305CEA5DCCB4C3873C0CEB")

    public static final int CHUNK_HPIF = type("HPIF");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.814 -0500", hash_original_field = "DEC46A5F79E23A211228873455371898", hash_generated_field = "4B945A8D18FB044547723173E8828B0F")

    public static final int CHUNK_HPSG = type("HPSG");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.816 -0500", hash_original_field = "757E1B7844252D735D93F28CC75F0A03", hash_generated_field = "617F53DAD319B53151B4D07D25FED1CB")

    public static final int CHUNK_HPDU = type("HPDU");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.819 -0500", hash_original_field = "67F7F123472B2CBBA6CE12AADFB7B3C9", hash_generated_field = "AA917699D5C3FDA97B5F1F0266368E3F")

    public static final int CHUNK_HPDS = type("HPDS");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.821 -0500", hash_original_field = "4AD03ADA214B4BA5D1835CB184F144C8", hash_generated_field = "FCD063CD9799A716CEE90882631AC5A2")

    public static final int CHUNK_NHSG = type("NHSG");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.823 -0500", hash_original_field = "BFA661F1DC454639F162094989C914F6", hash_generated_field = "259FF01A11C4E150E83356A0864ED45F")

    public static final int CHUNK_HPGC = type("HPGC");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.826 -0500", hash_original_field = "D63E704D47278662B6ED241DAE492784", hash_generated_field = "94DF4161B88336D5281295E3F052A420")

    public static final int CHUNK_REAE = type("REAE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.828 -0500", hash_original_field = "A97C1884F94A47F95D85435E67C4AE80", hash_generated_field = "AC2A957E2C3565B004E9A073E50036FF")

    public static final int CHUNK_REAQ = type("REAQ");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.831 -0500", hash_original_field = "40BB3FD5382D04C7FD85A00C911D13D4", hash_generated_field = "3A20641A5356020A50C369C19549AAD0")

    public static final int CHUNK_REAL = type("REAL");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.833 -0500", hash_original_field = "4EBAF2E25D8864FA832149DF1156E814", hash_generated_field = "41155868F04C6605317B5CC3A6E20227")

    private static DdmHandleHeap mInstance = new DdmHandleHeap();

    /* singleton, do not instantiate */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.836 -0500", hash_original_method = "236E8F4E2F7DDA83D2B39E117A0E950F", hash_generated_method = "2F7ED6C719B01917EBA38C9269ACFFB4")
    
private DdmHandleHeap() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.841 -0500", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "B371B1A5EBF86980C6290FA035BAE684")
    
public void connected() {}

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.843 -0500", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "5061C51BA9AB55A45A330545ECB336D2")
    
public void disconnected() {}

    /**
     * Handle a chunk of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.845 -0500", hash_original_method = "645397050BFF5ABB72125064EE5637C4", hash_generated_method = "662E9C42E1E46F49F7BC446F9F5F8C89")
    
public Chunk handleChunk(Chunk request) {
        if (false)
            Log.v("ddm-heap", "Handling " + name(request.type) + " chunk");
        int type = request.type;

        if (type == CHUNK_HPIF) {
            return handleHPIF(request);
        } else if (type == CHUNK_HPSG) {
            return handleHPSGNHSG(request, false);
        } else if (type == CHUNK_HPDU) {
            return handleHPDU(request);
        } else if (type == CHUNK_HPDS) {
            return handleHPDS(request);
        } else if (type == CHUNK_NHSG) {
            return handleHPSGNHSG(request, true);
        } else if (type == CHUNK_HPGC) {
            return handleHPGC(request);
        } else if (type == CHUNK_REAE) {
            return handleREAE(request);
        } else if (type == CHUNK_REAQ) {
            return handleREAQ(request);
        } else if (type == CHUNK_REAL) {
            return handleREAL(request);
        } else {
            throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        }
    }

    /*
     * Handle a "HeaP InFo" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.848 -0500", hash_original_method = "0E2E7ADFAF4A415A5EE0645FFEAB4A6D", hash_generated_method = "B3A318D35A881DEE30B5FE479504B57C")
    
private Chunk handleHPIF(Chunk request) {
        ByteBuffer in = wrapChunk(request);

        int when = in.get();
        if (false)
            Log.v("ddm-heap", "Heap segment enable: when=" + when);

        boolean ok = DdmVmInternal.heapInfoNotify(when);
        if (!ok) {
            return createFailChunk(1, "Unsupported HPIF what");
        } else {
            return null;        // empty response
        }
    }

    /*
     * Handle a "HeaP SeGment" or "Native Heap SeGment" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.850 -0500", hash_original_method = "A8B738C149F8A2DC880C585E17CFB83A", hash_generated_method = "4CF941C6F5E545562598774A8DFFA42F")
    
private Chunk handleHPSGNHSG(Chunk request, boolean isNative) {
        ByteBuffer in = wrapChunk(request);

        int when = in.get();
        int what = in.get();
        if (false)
            Log.v("ddm-heap", "Heap segment enable: when=" + when
                + ", what=" + what + ", isNative=" + isNative);

        boolean ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        if (!ok) {
            return createFailChunk(1, "Unsupported HPSG what/when");
        } else {
            // TODO: if "when" is non-zero and we want to see a dump
            //       right away, initiate a GC.
            return null;        // empty response
        }
    }

    /*
     * Handle a "HeaP DUmp" request.
     *
     * This currently just returns a result code.  We could pull up
     * the entire contents of the file and return them, but hprof dump
     * files can be a few megabytes.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.853 -0500", hash_original_method = "7193E5D1FD98ED03C267523A43581515", hash_generated_method = "54A24673FF106DDD869BF4968EC0A0A4")
    
private Chunk handleHPDU(Chunk request) {
        ByteBuffer in = wrapChunk(request);
        byte result;

        /* get the filename for the output file */
        int len = in.getInt();
        String fileName = getString(in, len);
        if (false)
            Log.d("ddm-heap", "Heap dump: file='" + fileName + "'");

        try {
            Debug.dumpHprofData(fileName);
            result = 0;
        } catch (UnsupportedOperationException uoe) {
            Log.w("ddm-heap", "hprof dumps not supported in this VM");
            result = -1;
        } catch (IOException ioe) {
            result = -1;
        } catch (RuntimeException re) {
            result = -1;
        }

        /* create a non-empty reply so the handler fires on completion */
        byte[] reply = { result };
        return new Chunk(CHUNK_HPDU, reply, 0, reply.length);
    }

    /*
     * Handle a "HeaP Dump Streaming" request.
     *
     * This tells the VM to create a heap dump and send it directly to
     * DDMS.  The dumps are large enough that we don't want to copy the
     * data into a byte[] and send it from here.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.855 -0500", hash_original_method = "C41093B7B99D47CB32AB13B14E448339", hash_generated_method = "B9BEC7F61928D35156B4ACE56B42BF06")
    
private Chunk handleHPDS(Chunk request) {
        ByteBuffer in = wrapChunk(request);
        byte result;

        /* get the filename for the output file */
        if (false)
            Log.d("ddm-heap", "Heap dump: [DDMS]");

        String failMsg = null;
        try {
            Debug.dumpHprofDataDdms();
        } catch (UnsupportedOperationException uoe) {
            failMsg = "hprof dumps not supported in this VM";
        } catch (RuntimeException re) {
            failMsg = "Exception: " + re.getMessage();
        }

        if (failMsg != null) {
            Log.w("ddm-heap", failMsg);
            return createFailChunk(1, failMsg);
        } else {
            return null;
        }
    }

    /*
     * Handle a "HeaP Garbage Collection" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.857 -0500", hash_original_method = "5AC6D538920D957D7D86B15E943C316B", hash_generated_method = "B7B0C0C694682797A32F853A24F4B406")
    
private Chunk handleHPGC(Chunk request) {
        //ByteBuffer in = wrapChunk(request);

        if (false)
            Log.d("ddm-heap", "Heap GC request");
        System.gc();

        return null;        // empty response
    }

    /*
     * Handle a "REcent Allocation Enable" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.859 -0500", hash_original_method = "C9F19EAFED9803F043951491F6273920", hash_generated_method = "0459ED362AA523343B5A997852C706F0")
    
private Chunk handleREAE(Chunk request) {
        ByteBuffer in = wrapChunk(request);
        boolean enable;

        enable = (in.get() != 0);

        if (false)
            Log.d("ddm-heap", "Recent allocation enable request: " + enable);

        DdmVmInternal.enableRecentAllocations(enable);

        return null;        // empty response
    }

    /*
     * Handle a "REcent Allocation Query" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.862 -0500", hash_original_method = "B480B93C7FE178F2CE62D90F1F153D77", hash_generated_method = "1FA79415431A118A3486A23E3F8BBC7A")
    
private Chunk handleREAQ(Chunk request) {
        //ByteBuffer in = wrapChunk(request);

        byte[] reply = new byte[1];
        reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        return new Chunk(CHUNK_REAQ, reply, 0, reply.length);
    }

    /*
     * Handle a "REcent ALlocations" request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:21.864 -0500", hash_original_method = "34D94CBD5BF588E49D545F9249DA1F17", hash_generated_method = "D7B765B028B66BFA45929E1E6AAEDA4F")
    
private Chunk handleREAL(Chunk request) {
        //ByteBuffer in = wrapChunk(request);

        if (false)
            Log.d("ddm-heap", "Recent allocations request");

        /* generate the reply in a ready-to-go format */
        byte[] reply = DdmVmInternal.getRecentAllocations();
        return new Chunk(CHUNK_REAL, reply, 0, reply.length);
    }
}

