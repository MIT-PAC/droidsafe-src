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
import android.os.Debug;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

public class DdmHandleHeap extends ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.933 -0400", hash_original_method = "236E8F4E2F7DDA83D2B39E117A0E950F", hash_generated_method = "81842FAD8AC8408A0CA4E2FFE4F623DF")
    @DSModeled(DSC.SAFE)
    private DdmHandleHeap() {
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.934 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    @DSModeled(DSC.SAFE)
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.934 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.934 -0400", hash_original_method = "645397050BFF5ABB72125064EE5637C4", hash_generated_method = "2730745E59F3C24F926A5DC399C2386E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Chunk handleChunk(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        int type;
        type = request.type;
        {
            Chunk var92EF0A2A2BC6DDC6C6889747B8F0AB67_10083485 = (handleHPIF(request));
        } //End block
        {
            Chunk var236B1395F8925AFCEBBD2AB1251D9014_1960287997 = (handleHPSGNHSG(request, false));
        } //End block
        {
            Chunk varBE2E952E4D96341C50496FDB9FEC32DF_1989213683 = (handleHPDU(request));
        } //End block
        {
            Chunk var4F07AD8780E83529E893FCF988D018B1_80671251 = (handleHPDS(request));
        } //End block
        {
            Chunk var7521ABE535B9CFA906CCBF1A7F360688_1176524593 = (handleHPSGNHSG(request, true));
        } //End block
        {
            Chunk varA64C4999CC9E68C23CC296FD94A7B348_1780275767 = (handleHPGC(request));
        } //End block
        {
            Chunk varFB058650715BE7098E1B45BB70B03A78_2102226021 = (handleREAE(request));
        } //End block
        {
            Chunk var2AE67FE9DFDFC84C3366590D7ED31159_341537012 = (handleREAQ(request));
        } //End block
        {
            Chunk var1AFD7142DEE81C94593C18356A668E81_1135930778 = (handleREAL(request));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.935 -0400", hash_original_method = "0E2E7ADFAF4A415A5EE0645FFEAB4A6D", hash_generated_method = "CAA7947DBEDDD29E503C810A9EDF45AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHPIF(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        int when;
        when = in.get();
        boolean ok;
        ok = DdmVmInternal.heapInfoNotify(when);
        {
            Chunk var4BFCDB2B16288A754639EA0323005C94_597110961 = (createFailChunk(1, "Unsupported HPIF what"));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //int when = in.get();
        //if (false)
            //Log.v("ddm-heap", "Heap segment enable: when=" + when);
        //boolean ok = DdmVmInternal.heapInfoNotify(when);
        //if (!ok) {
            //return createFailChunk(1, "Unsupported HPIF what");
        //} else {
            //return null;        
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.935 -0400", hash_original_method = "A8B738C149F8A2DC880C585E17CFB83A", hash_generated_method = "EF1C2D32F34273BC3359C06EEAD12EF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHPSGNHSG(Chunk request, boolean isNative) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(isNative);
        ByteBuffer in;
        in = wrapChunk(request);
        int when;
        when = in.get();
        int what;
        what = in.get();
        boolean ok;
        ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        {
            Chunk varA5ACAE1539C525AA38C9EC6828BF29B0_1522706139 = (createFailChunk(1, "Unsupported HPSG what/when"));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //int when = in.get();
        //int what = in.get();
        //if (false)
            //Log.v("ddm-heap", "Heap segment enable: when=" + when
                //+ ", what=" + what + ", isNative=" + isNative);
        //boolean ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        //if (!ok) {
            //return createFailChunk(1, "Unsupported HPSG what/when");
        //} else {
            //return null;        
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.936 -0400", hash_original_method = "7193E5D1FD98ED03C267523A43581515", hash_generated_method = "60EBFFD5BC4526A231D2BE8BFB9046FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHPDU(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        byte result;
        int len;
        len = in.getInt();
        String fileName;
        fileName = getString(in, len);
        Log.d("ddm-heap", "Heap dump: file='" + fileName + "'");
        try 
        {
            Debug.dumpHprofData(fileName);
            result = 0;
        } //End block
        catch (UnsupportedOperationException uoe)
        {
            result = -1;
        } //End block
        catch (IOException ioe)
        {
            result = -1;
        } //End block
        catch (RuntimeException re)
        {
            result = -1;
        } //End block
        byte[] reply;
        Chunk varAEC2C940AE9CACA536CE23774FA558B0_1520644955 = (new Chunk(CHUNK_HPDU, reply, 0, reply.length));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //byte result;
        //int len = in.getInt();
        //String fileName = getString(in, len);
        //if (false)
            //Log.d("ddm-heap", "Heap dump: file='" + fileName + "'");
        //try {
            //Debug.dumpHprofData(fileName);
            //result = 0;
        //} catch (UnsupportedOperationException uoe) {
            //Log.w("ddm-heap", "hprof dumps not supported in this VM");
            //result = -1;
        //} catch (IOException ioe) {
            //result = -1;
        //} catch (RuntimeException re) {
            //result = -1;
        //}
        //byte[] reply = { result };
        //return new Chunk(CHUNK_HPDU, reply, 0, reply.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.936 -0400", hash_original_method = "C41093B7B99D47CB32AB13B14E448339", hash_generated_method = "174D379FD28E2802002C4C55B1A49CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHPDS(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        byte result;
        Log.d("ddm-heap", "Heap dump: [DDMS]");
        String failMsg;
        failMsg = null;
        try 
        {
            Debug.dumpHprofDataDdms();
        } //End block
        catch (UnsupportedOperationException uoe)
        {
            failMsg = "hprof dumps not supported in this VM";
        } //End block
        catch (RuntimeException re)
        {
            failMsg = "Exception: " + re.getMessage();
        } //End block
        {
            Chunk var58E113B39366FD996E37F665829E1F84_1869814691 = (createFailChunk(1, failMsg));
        } //End block
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //byte result;
        //if (false)
            //Log.d("ddm-heap", "Heap dump: [DDMS]");
        //String failMsg = null;
        //try {
            //Debug.dumpHprofDataDdms();
        //} catch (UnsupportedOperationException uoe) {
            //failMsg = "hprof dumps not supported in this VM";
        //} catch (RuntimeException re) {
            //failMsg = "Exception: " + re.getMessage();
        //}
        //if (failMsg != null) {
            //Log.w("ddm-heap", failMsg);
            //return createFailChunk(1, failMsg);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.937 -0400", hash_original_method = "5AC6D538920D957D7D86B15E943C316B", hash_generated_method = "E52469243364E27E4966E31993D4D668")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleHPGC(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        Log.d("ddm-heap", "Heap GC request");
        System.gc();
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Heap GC request");
        //System.gc();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.937 -0400", hash_original_method = "C9F19EAFED9803F043951491F6273920", hash_generated_method = "8E0313D72D002D167093D353CDD5D204")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleREAE(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        ByteBuffer in;
        in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        DdmVmInternal.enableRecentAllocations(enable);
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable;
        //enable = (in.get() != 0);
        //if (false)
            //Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        //DdmVmInternal.enableRecentAllocations(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.938 -0400", hash_original_method = "B480B93C7FE178F2CE62D90F1F153D77", hash_generated_method = "0F35B1181F656688E39A7D2027ECA011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleREAQ(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        byte[] reply;
        reply = new byte[1];
        reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        Chunk var32942C9EA483092E4A5885D793E5EF55_1319749196 = (new Chunk(CHUNK_REAQ, reply, 0, reply.length));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] reply = new byte[1];
        //reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        //return new Chunk(CHUNK_REAQ, reply, 0, reply.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.939 -0400", hash_original_method = "34D94CBD5BF588E49D545F9249DA1F17", hash_generated_method = "B297E9815BD530EDC8750C6254066F78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Chunk handleREAL(Chunk request) {
        dsTaint.addTaint(request.dsTaint);
        Log.d("ddm-heap", "Recent allocations request");
        byte[] reply;
        reply = DdmVmInternal.getRecentAllocations();
        Chunk var273B50A2512D9BD8B6425BE487BCCBF7_305817277 = (new Chunk(CHUNK_REAL, reply, 0, reply.length));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Recent allocations request");
        //byte[] reply = DdmVmInternal.getRecentAllocations();
        //return new Chunk(CHUNK_REAL, reply, 0, reply.length);
    }

    
    public static final int CHUNK_HPIF = type("HPIF");
    public static final int CHUNK_HPSG = type("HPSG");
    public static final int CHUNK_HPDU = type("HPDU");
    public static final int CHUNK_HPDS = type("HPDS");
    public static final int CHUNK_NHSG = type("NHSG");
    public static final int CHUNK_HPGC = type("HPGC");
    public static final int CHUNK_REAE = type("REAE");
    public static final int CHUNK_REAQ = type("REAQ");
    public static final int CHUNK_REAL = type("REAL");
    private static DdmHandleHeap mInstance = new DdmHandleHeap();
}

