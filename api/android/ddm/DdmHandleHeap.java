package android.ddm;

// Droidsafe Imports
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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.165 -0400", hash_original_method = "236E8F4E2F7DDA83D2B39E117A0E950F", hash_generated_method = "81842FAD8AC8408A0CA4E2FFE4F623DF")
    private  DdmHandleHeap() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.166 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.169 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.173 -0400", hash_original_method = "645397050BFF5ABB72125064EE5637C4", hash_generated_method = "1202049A81C6B8473085432F9F2F3369")
    public Chunk handleChunk(Chunk request) {
        addTaint(request.getTaint());
        if(false){ }        int type = request.type;
        if(type == CHUNK_HPIF)        
        {
Chunk var507C28C650720AB8AB098F5E6CC9252D_1721683276 =             handleHPIF(request);
            var507C28C650720AB8AB098F5E6CC9252D_1721683276.addTaint(taint);
            return var507C28C650720AB8AB098F5E6CC9252D_1721683276;
        } //End block
        else
        if(type == CHUNK_HPSG)        
        {
Chunk var15468615A56ED6898585EB8EBE92B8C9_1511061303 =             handleHPSGNHSG(request, false);
            var15468615A56ED6898585EB8EBE92B8C9_1511061303.addTaint(taint);
            return var15468615A56ED6898585EB8EBE92B8C9_1511061303;
        } //End block
        else
        if(type == CHUNK_HPDU)        
        {
Chunk var36FEE34DA4864238209E222778A0525B_1531428800 =             handleHPDU(request);
            var36FEE34DA4864238209E222778A0525B_1531428800.addTaint(taint);
            return var36FEE34DA4864238209E222778A0525B_1531428800;
        } //End block
        else
        if(type == CHUNK_HPDS)        
        {
Chunk varA573BA562AE48603900019E1752B86AA_124220263 =             handleHPDS(request);
            varA573BA562AE48603900019E1752B86AA_124220263.addTaint(taint);
            return varA573BA562AE48603900019E1752B86AA_124220263;
        } //End block
        else
        if(type == CHUNK_NHSG)        
        {
Chunk var6A27A47C08E60C0724795EBF9540E597_1098730147 =             handleHPSGNHSG(request, true);
            var6A27A47C08E60C0724795EBF9540E597_1098730147.addTaint(taint);
            return var6A27A47C08E60C0724795EBF9540E597_1098730147;
        } //End block
        else
        if(type == CHUNK_HPGC)        
        {
Chunk var191DCB83DCDCFF8846E6D6F23DBBED00_1448902034 =             handleHPGC(request);
            var191DCB83DCDCFF8846E6D6F23DBBED00_1448902034.addTaint(taint);
            return var191DCB83DCDCFF8846E6D6F23DBBED00_1448902034;
        } //End block
        else
        if(type == CHUNK_REAE)        
        {
Chunk var92D91D3C20F148B1B2FC3B0F6F026D80_1444675787 =             handleREAE(request);
            var92D91D3C20F148B1B2FC3B0F6F026D80_1444675787.addTaint(taint);
            return var92D91D3C20F148B1B2FC3B0F6F026D80_1444675787;
        } //End block
        else
        if(type == CHUNK_REAQ)        
        {
Chunk var2A5B2934F5E7FF08D77FD810C2087D5D_991844548 =             handleREAQ(request);
            var2A5B2934F5E7FF08D77FD810C2087D5D_991844548.addTaint(taint);
            return var2A5B2934F5E7FF08D77FD810C2087D5D_991844548;
        } //End block
        else
        if(type == CHUNK_REAL)        
        {
Chunk var3C20A4609E2BAEC2C58361F49A9C8F7C_1855202040 =             handleREAL(request);
            var3C20A4609E2BAEC2C58361F49A9C8F7C_1855202040.addTaint(taint);
            return var3C20A4609E2BAEC2C58361F49A9C8F7C_1855202040;
        } //End block
        else
        {
            RuntimeException var87CCC2E1E27D81731A9B6FB9950FC20F_1182787536 = new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
            var87CCC2E1E27D81731A9B6FB9950FC20F_1182787536.addTaint(taint);
            throw var87CCC2E1E27D81731A9B6FB9950FC20F_1182787536;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.176 -0400", hash_original_method = "0E2E7ADFAF4A415A5EE0645FFEAB4A6D", hash_generated_method = "8F92A94F917C2BD479B415DE89A29AC4")
    private Chunk handleHPIF(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int when = in.get();
        if(false){ }        boolean ok = DdmVmInternal.heapInfoNotify(when);
        if(!ok)        
        {
Chunk var873AC430B8903268F5CD07959196B78A_1898777725 =             createFailChunk(1, "Unsupported HPIF what");
            var873AC430B8903268F5CD07959196B78A_1898777725.addTaint(taint);
            return var873AC430B8903268F5CD07959196B78A_1898777725;
        } //End block
        else
        {
Chunk var540C13E9E156B687226421B24F2DF178_905822194 =             null;
            var540C13E9E156B687226421B24F2DF178_905822194.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_905822194;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.177 -0400", hash_original_method = "A8B738C149F8A2DC880C585E17CFB83A", hash_generated_method = "652F854576BBC2CD53E55D3908169331")
    private Chunk handleHPSGNHSG(Chunk request, boolean isNative) {
        addTaint(isNative);
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        int when = in.get();
        int what = in.get();
        if(false){ }        boolean ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        if(!ok)        
        {
Chunk varC240AEF29521E6BA435BD666D35E414D_1392956938 =             createFailChunk(1, "Unsupported HPSG what/when");
            varC240AEF29521E6BA435BD666D35E414D_1392956938.addTaint(taint);
            return varC240AEF29521E6BA435BD666D35E414D_1392956938;
        } //End block
        else
        {
Chunk var540C13E9E156B687226421B24F2DF178_1377012565 =             null;
            var540C13E9E156B687226421B24F2DF178_1377012565.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1377012565;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.179 -0400", hash_original_method = "7193E5D1FD98ED03C267523A43581515", hash_generated_method = "85C37CF387617204C007175046773EA9")
    private Chunk handleHPDU(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        byte result;
        int len = in.getInt();
        String fileName = getString(in, len);
        if(false)        
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
        byte[] reply = { result };
Chunk var75564E282821E05102CC43D870C8A28C_754514911 =         new Chunk(CHUNK_HPDU, reply, 0, reply.length);
        var75564E282821E05102CC43D870C8A28C_754514911.addTaint(taint);
        return var75564E282821E05102CC43D870C8A28C_754514911;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.181 -0400", hash_original_method = "C41093B7B99D47CB32AB13B14E448339", hash_generated_method = "8E4C8B87957DBC7D5B6A9459D91666BF")
    private Chunk handleHPDS(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        byte result;
        if(false)        
        Log.d("ddm-heap", "Heap dump: [DDMS]");
        String failMsg = null;
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
        if(failMsg != null)        
        {
Chunk varF1E25A8E8DCA43ADCE409B073A9D9752_1135851213 =             createFailChunk(1, failMsg);
            varF1E25A8E8DCA43ADCE409B073A9D9752_1135851213.addTaint(taint);
            return varF1E25A8E8DCA43ADCE409B073A9D9752_1135851213;
        } //End block
        else
        {
Chunk var540C13E9E156B687226421B24F2DF178_1893892285 =             null;
            var540C13E9E156B687226421B24F2DF178_1893892285.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1893892285;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.182 -0400", hash_original_method = "5AC6D538920D957D7D86B15E943C316B", hash_generated_method = "4BA04FAA0C04FFA8CCC57BD50119449F")
    private Chunk handleHPGC(Chunk request) {
        addTaint(request.getTaint());
        if(false)        
        Log.d("ddm-heap", "Heap GC request");
        System.gc();
Chunk var540C13E9E156B687226421B24F2DF178_1546430422 =         null;
        var540C13E9E156B687226421B24F2DF178_1546430422.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1546430422;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Heap GC request");
        //System.gc();
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.182 -0400", hash_original_method = "C9F19EAFED9803F043951491F6273920", hash_generated_method = "0FAC5F9F6D06FC27FC1EFAE648F0E9CC")
    private Chunk handleREAE(Chunk request) {
        addTaint(request.getTaint());
        ByteBuffer in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        if(false)        
        Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        DdmVmInternal.enableRecentAllocations(enable);
Chunk var540C13E9E156B687226421B24F2DF178_1756033726 =         null;
        var540C13E9E156B687226421B24F2DF178_1756033726.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1756033726;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable;
        //enable = (in.get() != 0);
        //if (false)
            //Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        //DdmVmInternal.enableRecentAllocations(enable);
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.183 -0400", hash_original_method = "B480B93C7FE178F2CE62D90F1F153D77", hash_generated_method = "EDA5886CF1F27C0483D8B51AE0BFC8FF")
    private Chunk handleREAQ(Chunk request) {
        addTaint(request.getTaint());
        byte[] reply = new byte[1];
        reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
Chunk var3C84717D4949F40EA85D8C58F4D81EF2_1070376981 =         new Chunk(CHUNK_REAQ, reply, 0, reply.length);
        var3C84717D4949F40EA85D8C58F4D81EF2_1070376981.addTaint(taint);
        return var3C84717D4949F40EA85D8C58F4D81EF2_1070376981;
        // ---------- Original Method ----------
        //byte[] reply = new byte[1];
        //reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        //return new Chunk(CHUNK_REAQ, reply, 0, reply.length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_method = "34D94CBD5BF588E49D545F9249DA1F17", hash_generated_method = "5927FC4A581E44AB078C3B1378BE9ACC")
    private Chunk handleREAL(Chunk request) {
        addTaint(request.getTaint());
        if(false)        
        Log.d("ddm-heap", "Recent allocations request");
        byte[] reply = DdmVmInternal.getRecentAllocations();
Chunk varA8E3078214ACAD76145467E844E0C4F1_1948868361 =         new Chunk(CHUNK_REAL, reply, 0, reply.length);
        varA8E3078214ACAD76145467E844E0C4F1_1948868361.addTaint(taint);
        return varA8E3078214ACAD76145467E844E0C4F1_1948868361;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Recent allocations request");
        //byte[] reply = DdmVmInternal.getRecentAllocations();
        //return new Chunk(CHUNK_REAL, reply, 0, reply.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "7A7F9CC44B7B034C878382C5602CF69F", hash_generated_field = "411BA0ACAF305CEA5DCCB4C3873C0CEB")

    public static final int CHUNK_HPIF = type("HPIF");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "8AC54C20B6BB8E26FFE45C9478DE3452", hash_generated_field = "4B945A8D18FB044547723173E8828B0F")

    public static final int CHUNK_HPSG = type("HPSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "F0B6055080FD3881F029DFB7698693B8", hash_generated_field = "617F53DAD319B53151B4D07D25FED1CB")

    public static final int CHUNK_HPDU = type("HPDU");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "306AEC826A119F9C863B4C5D74E6C6C2", hash_generated_field = "AA917699D5C3FDA97B5F1F0266368E3F")

    public static final int CHUNK_HPDS = type("HPDS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "8C17FBC4ABADB25436144C26E90E834D", hash_generated_field = "FCD063CD9799A716CEE90882631AC5A2")

    public static final int CHUNK_NHSG = type("NHSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "85B2B8394EFC2A94CECAAB0BFCA48168", hash_generated_field = "259FF01A11C4E150E83356A0864ED45F")

    public static final int CHUNK_HPGC = type("HPGC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "EFB1E67A6EFB9AD535528C0554383AFD", hash_generated_field = "94DF4161B88336D5281295E3F052A420")

    public static final int CHUNK_REAE = type("REAE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "B72DCD9A9E095F179367D03EDE42943D", hash_generated_field = "AC2A957E2C3565B004E9A073E50036FF")

    public static final int CHUNK_REAQ = type("REAQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.184 -0400", hash_original_field = "2B6A15DF0BA29C89216213502D83DE2A", hash_generated_field = "3A20641A5356020A50C369C19549AAD0")

    public static final int CHUNK_REAL = type("REAL");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.185 -0400", hash_original_field = "FD99FB9675F3F378437B80C78914859D", hash_generated_field = "41155868F04C6605317B5CC3A6E20227")

    private static DdmHandleHeap mInstance = new DdmHandleHeap();
}

