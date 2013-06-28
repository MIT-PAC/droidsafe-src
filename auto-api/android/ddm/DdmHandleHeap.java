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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.956 -0400", hash_original_method = "236E8F4E2F7DDA83D2B39E117A0E950F", hash_generated_method = "81842FAD8AC8408A0CA4E2FFE4F623DF")
    private  DdmHandleHeap() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.956 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.957 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.958 -0400", hash_original_method = "645397050BFF5ABB72125064EE5637C4", hash_generated_method = "B92438C2D00D04617ED2C1F8B0A47A31")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1850172168 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1891873655 = null; //Variable for return #2
        Chunk varB4EAC82CA7396A68D541C85D26508E83_132970852 = null; //Variable for return #3
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1401231541 = null; //Variable for return #4
        Chunk varB4EAC82CA7396A68D541C85D26508E83_75874821 = null; //Variable for return #5
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1751559612 = null; //Variable for return #6
        Chunk varB4EAC82CA7396A68D541C85D26508E83_248112287 = null; //Variable for return #7
        Chunk varB4EAC82CA7396A68D541C85D26508E83_568378329 = null; //Variable for return #8
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1575886904 = null; //Variable for return #9
        int type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1850172168 = handleHPIF(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1891873655 = handleHPSGNHSG(request, false);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_132970852 = handleHPDU(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1401231541 = handleHPDS(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_75874821 = handleHPSGNHSG(request, true);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1751559612 = handleHPGC(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_248112287 = handleREAE(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_568378329 = handleREAQ(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1575886904 = handleREAL(request);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1101608708; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_1850172168;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_1891873655;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_132970852;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_1401231541;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_75874821;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_1751559612;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_248112287;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_568378329;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1101608708 = varB4EAC82CA7396A68D541C85D26508E83_1575886904;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1101608708.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1101608708;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.959 -0400", hash_original_method = "0E2E7ADFAF4A415A5EE0645FFEAB4A6D", hash_generated_method = "3091C137A68E5995FEF7CF58EF896514")
    private Chunk handleHPIF(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_703488097 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1320070180 = null; //Variable for return #2
        ByteBuffer in = wrapChunk(request);
        int when = in.get();
        boolean ok = DdmVmInternal.heapInfoNotify(when);
        {
            varB4EAC82CA7396A68D541C85D26508E83_703488097 = createFailChunk(1, "Unsupported HPIF what");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1320070180 = null;
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_650984042; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_650984042 = varB4EAC82CA7396A68D541C85D26508E83_703488097;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_650984042 = varB4EAC82CA7396A68D541C85D26508E83_1320070180;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_650984042.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_650984042;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.960 -0400", hash_original_method = "A8B738C149F8A2DC880C585E17CFB83A", hash_generated_method = "FD8FBAD9F808ADC9125B738B60EF0AAF")
    private Chunk handleHPSGNHSG(Chunk request, boolean isNative) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1043311967 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_488849587 = null; //Variable for return #2
        ByteBuffer in = wrapChunk(request);
        int when = in.get();
        int what = in.get();
        boolean ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1043311967 = createFailChunk(1, "Unsupported HPSG what/when");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_488849587 = null;
        } //End block
        addTaint(request.getTaint());
        addTaint(isNative);
        Chunk varA7E53CE21691AB073D9660D615818899_1537074960; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1537074960 = varB4EAC82CA7396A68D541C85D26508E83_1043311967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1537074960 = varB4EAC82CA7396A68D541C85D26508E83_488849587;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1537074960.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1537074960;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.365 -0400", hash_original_method = "7193E5D1FD98ED03C267523A43581515", hash_generated_method = "47480C4D83F99748A0BDC39606781A0C")
    private Chunk handleHPDU(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_136613464 = null; //Variable for return #1
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
        byte[] reply = {result};
        varB4EAC82CA7396A68D541C85D26508E83_136613464 = new Chunk(CHUNK_HPDU, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_136613464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136613464;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.962 -0400", hash_original_method = "C41093B7B99D47CB32AB13B14E448339", hash_generated_method = "9FB3D16B1147619AB48E16B30CF2E8F3")
    private Chunk handleHPDS(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1721913082 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_476959878 = null; //Variable for return #2
        ByteBuffer in = wrapChunk(request);
        byte result;
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1721913082 = createFailChunk(1, failMsg);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_476959878 = null;
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1729545577; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1729545577 = varB4EAC82CA7396A68D541C85D26508E83_1721913082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1729545577 = varB4EAC82CA7396A68D541C85D26508E83_476959878;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1729545577.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1729545577;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.962 -0400", hash_original_method = "5AC6D538920D957D7D86B15E943C316B", hash_generated_method = "8914D3E0D52EACCE005B49F913D204F7")
    private Chunk handleHPGC(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_185742030 = null; //Variable for return #1
        Log.d("ddm-heap", "Heap GC request");
        System.gc();
        varB4EAC82CA7396A68D541C85D26508E83_185742030 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_185742030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185742030;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Heap GC request");
        //System.gc();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.963 -0400", hash_original_method = "C9F19EAFED9803F043951491F6273920", hash_generated_method = "BFE1486019ADE4EF0A0F59DC730016CB")
    private Chunk handleREAE(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1241908516 = null; //Variable for return #1
        ByteBuffer in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        DdmVmInternal.enableRecentAllocations(enable);
        varB4EAC82CA7396A68D541C85D26508E83_1241908516 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1241908516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241908516;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable;
        //enable = (in.get() != 0);
        //if (false)
            //Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        //DdmVmInternal.enableRecentAllocations(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.964 -0400", hash_original_method = "B480B93C7FE178F2CE62D90F1F153D77", hash_generated_method = "B28CC02EC327BFB162188AE0462E1EF6")
    private Chunk handleREAQ(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1188863809 = null; //Variable for return #1
        byte[] reply = new byte[1];
        reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        varB4EAC82CA7396A68D541C85D26508E83_1188863809 = new Chunk(CHUNK_REAQ, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1188863809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1188863809;
        // ---------- Original Method ----------
        //byte[] reply = new byte[1];
        //reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        //return new Chunk(CHUNK_REAQ, reply, 0, reply.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_method = "34D94CBD5BF588E49D545F9249DA1F17", hash_generated_method = "9D8B1E427D2F4F30D75ED7503E7B8136")
    private Chunk handleREAL(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_614538147 = null; //Variable for return #1
        Log.d("ddm-heap", "Recent allocations request");
        byte[] reply = DdmVmInternal.getRecentAllocations();
        varB4EAC82CA7396A68D541C85D26508E83_614538147 = new Chunk(CHUNK_REAL, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_614538147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614538147;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Recent allocations request");
        //byte[] reply = DdmVmInternal.getRecentAllocations();
        //return new Chunk(CHUNK_REAL, reply, 0, reply.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "7A7F9CC44B7B034C878382C5602CF69F", hash_generated_field = "411BA0ACAF305CEA5DCCB4C3873C0CEB")

    public static final int CHUNK_HPIF = type("HPIF");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "8AC54C20B6BB8E26FFE45C9478DE3452", hash_generated_field = "4B945A8D18FB044547723173E8828B0F")

    public static final int CHUNK_HPSG = type("HPSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "F0B6055080FD3881F029DFB7698693B8", hash_generated_field = "617F53DAD319B53151B4D07D25FED1CB")

    public static final int CHUNK_HPDU = type("HPDU");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "306AEC826A119F9C863B4C5D74E6C6C2", hash_generated_field = "AA917699D5C3FDA97B5F1F0266368E3F")

    public static final int CHUNK_HPDS = type("HPDS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "8C17FBC4ABADB25436144C26E90E834D", hash_generated_field = "FCD063CD9799A716CEE90882631AC5A2")

    public static final int CHUNK_NHSG = type("NHSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "85B2B8394EFC2A94CECAAB0BFCA48168", hash_generated_field = "259FF01A11C4E150E83356A0864ED45F")

    public static final int CHUNK_HPGC = type("HPGC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.965 -0400", hash_original_field = "EFB1E67A6EFB9AD535528C0554383AFD", hash_generated_field = "94DF4161B88336D5281295E3F052A420")

    public static final int CHUNK_REAE = type("REAE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.966 -0400", hash_original_field = "B72DCD9A9E095F179367D03EDE42943D", hash_generated_field = "AC2A957E2C3565B004E9A073E50036FF")

    public static final int CHUNK_REAQ = type("REAQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.966 -0400", hash_original_field = "2B6A15DF0BA29C89216213502D83DE2A", hash_generated_field = "3A20641A5356020A50C369C19549AAD0")

    public static final int CHUNK_REAL = type("REAL");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.966 -0400", hash_original_field = "FD99FB9675F3F378437B80C78914859D", hash_generated_field = "41155868F04C6605317B5CC3A6E20227")

    private static DdmHandleHeap mInstance = new DdmHandleHeap();
}

