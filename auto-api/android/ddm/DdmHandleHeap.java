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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.719 -0400", hash_original_method = "236E8F4E2F7DDA83D2B39E117A0E950F", hash_generated_method = "81842FAD8AC8408A0CA4E2FFE4F623DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.720 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.721 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.743 -0400", hash_original_method = "645397050BFF5ABB72125064EE5637C4", hash_generated_method = "76EBD44D0129F9D52FF379C0BA54AA42")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1952385598 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1595382404 = null; //Variable for return #2
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1006585952 = null; //Variable for return #3
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1397933268 = null; //Variable for return #4
        Chunk varB4EAC82CA7396A68D541C85D26508E83_337056377 = null; //Variable for return #5
        Chunk varB4EAC82CA7396A68D541C85D26508E83_389748468 = null; //Variable for return #6
        Chunk varB4EAC82CA7396A68D541C85D26508E83_329917476 = null; //Variable for return #7
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1943116158 = null; //Variable for return #8
        Chunk varB4EAC82CA7396A68D541C85D26508E83_320997697 = null; //Variable for return #9
        int type;
        type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1952385598 = handleHPIF(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1595382404 = handleHPSGNHSG(request, false);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1006585952 = handleHPDU(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1397933268 = handleHPDS(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_337056377 = handleHPSGNHSG(request, true);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_389748468 = handleHPGC(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_329917476 = handleREAE(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1943116158 = handleREAQ(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_320997697 = handleREAL(request);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_2017205650; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_1952385598;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_1595382404;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_1006585952;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_1397933268;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_337056377;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_389748468;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_329917476;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_1943116158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2017205650 = varB4EAC82CA7396A68D541C85D26508E83_320997697;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2017205650.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2017205650;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.745 -0400", hash_original_method = "0E2E7ADFAF4A415A5EE0645FFEAB4A6D", hash_generated_method = "EB77CE54AED5A0C80B36A3377220AA5A")
    private Chunk handleHPIF(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_21078914 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_262329986 = null; //Variable for return #2
        ByteBuffer in;
        in = wrapChunk(request);
        int when;
        when = in.get();
        boolean ok;
        ok = DdmVmInternal.heapInfoNotify(when);
        {
            varB4EAC82CA7396A68D541C85D26508E83_21078914 = createFailChunk(1, "Unsupported HPIF what");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_262329986 = null;
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_2097716450; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2097716450 = varB4EAC82CA7396A68D541C85D26508E83_21078914;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2097716450 = varB4EAC82CA7396A68D541C85D26508E83_262329986;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2097716450.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2097716450;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.771 -0400", hash_original_method = "A8B738C149F8A2DC880C585E17CFB83A", hash_generated_method = "E7961853EA4CD31AB0ED24514DD9BA42")
    private Chunk handleHPSGNHSG(Chunk request, boolean isNative) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_868468041 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_120356251 = null; //Variable for return #2
        ByteBuffer in;
        in = wrapChunk(request);
        int when;
        when = in.get();
        int what;
        what = in.get();
        boolean ok;
        ok = DdmVmInternal.heapSegmentNotify(when, what, isNative);
        {
            varB4EAC82CA7396A68D541C85D26508E83_868468041 = createFailChunk(1, "Unsupported HPSG what/when");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_120356251 = null;
        } //End block
        addTaint(request.getTaint());
        addTaint(isNative);
        Chunk varA7E53CE21691AB073D9660D615818899_298957832; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_298957832 = varB4EAC82CA7396A68D541C85D26508E83_868468041;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_298957832 = varB4EAC82CA7396A68D541C85D26508E83_120356251;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_298957832.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_298957832;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.774 -0400", hash_original_method = "7193E5D1FD98ED03C267523A43581515", hash_generated_method = "CF1542175D5098D19D52EF5CE9589AAD")
    private Chunk handleHPDU(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1024802610 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1024802610 = new Chunk(CHUNK_HPDU, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1024802610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024802610;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.794 -0400", hash_original_method = "C41093B7B99D47CB32AB13B14E448339", hash_generated_method = "34C7CEF3DD4EDA9A21F6802F365EDCA2")
    private Chunk handleHPDS(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1549054278 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_12779931 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1549054278 = createFailChunk(1, failMsg);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_12779931 = null;
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_629871702; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_629871702 = varB4EAC82CA7396A68D541C85D26508E83_1549054278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_629871702 = varB4EAC82CA7396A68D541C85D26508E83_12779931;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_629871702.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_629871702;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.796 -0400", hash_original_method = "5AC6D538920D957D7D86B15E943C316B", hash_generated_method = "3883112F3350422189DF8065438DA10C")
    private Chunk handleHPGC(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1281983464 = null; //Variable for return #1
        Log.d("ddm-heap", "Heap GC request");
        System.gc();
        varB4EAC82CA7396A68D541C85D26508E83_1281983464 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1281983464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281983464;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Heap GC request");
        //System.gc();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.810 -0400", hash_original_method = "C9F19EAFED9803F043951491F6273920", hash_generated_method = "03D4D289FF176FC2C02EB5ED7ACC33A2")
    private Chunk handleREAE(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_506662763 = null; //Variable for return #1
        ByteBuffer in;
        in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        DdmVmInternal.enableRecentAllocations(enable);
        varB4EAC82CA7396A68D541C85D26508E83_506662763 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_506662763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_506662763;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable;
        //enable = (in.get() != 0);
        //if (false)
            //Log.d("ddm-heap", "Recent allocation enable request: " + enable);
        //DdmVmInternal.enableRecentAllocations(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.819 -0400", hash_original_method = "B480B93C7FE178F2CE62D90F1F153D77", hash_generated_method = "A67E9B2C6CCD0AC3AEBF7B0F9F9123B7")
    private Chunk handleREAQ(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_987084555 = null; //Variable for return #1
        byte[] reply;
        reply = new byte[1];
        reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        varB4EAC82CA7396A68D541C85D26508E83_987084555 = new Chunk(CHUNK_REAQ, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_987084555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_987084555;
        // ---------- Original Method ----------
        //byte[] reply = new byte[1];
        //reply[0] = DdmVmInternal.getRecentAllocationStatus() ? (byte)1 :(byte)0;
        //return new Chunk(CHUNK_REAQ, reply, 0, reply.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.830 -0400", hash_original_method = "34D94CBD5BF588E49D545F9249DA1F17", hash_generated_method = "D3F1F006FC54F97C666F3D63165ED8C3")
    private Chunk handleREAL(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1757721757 = null; //Variable for return #1
        Log.d("ddm-heap", "Recent allocations request");
        byte[] reply;
        reply = DdmVmInternal.getRecentAllocations();
        varB4EAC82CA7396A68D541C85D26508E83_1757721757 = new Chunk(CHUNK_REAL, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1757721757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757721757;
        // ---------- Original Method ----------
        //if (false)
            //Log.d("ddm-heap", "Recent allocations request");
        //byte[] reply = DdmVmInternal.getRecentAllocations();
        //return new Chunk(CHUNK_REAL, reply, 0, reply.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.834 -0400", hash_original_field = "7A7F9CC44B7B034C878382C5602CF69F", hash_generated_field = "411BA0ACAF305CEA5DCCB4C3873C0CEB")

    public static final int CHUNK_HPIF = type("HPIF");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.834 -0400", hash_original_field = "8AC54C20B6BB8E26FFE45C9478DE3452", hash_generated_field = "4B945A8D18FB044547723173E8828B0F")

    public static final int CHUNK_HPSG = type("HPSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "F0B6055080FD3881F029DFB7698693B8", hash_generated_field = "617F53DAD319B53151B4D07D25FED1CB")

    public static final int CHUNK_HPDU = type("HPDU");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "306AEC826A119F9C863B4C5D74E6C6C2", hash_generated_field = "AA917699D5C3FDA97B5F1F0266368E3F")

    public static final int CHUNK_HPDS = type("HPDS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "8C17FBC4ABADB25436144C26E90E834D", hash_generated_field = "FCD063CD9799A716CEE90882631AC5A2")

    public static final int CHUNK_NHSG = type("NHSG");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "85B2B8394EFC2A94CECAAB0BFCA48168", hash_generated_field = "259FF01A11C4E150E83356A0864ED45F")

    public static final int CHUNK_HPGC = type("HPGC");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "EFB1E67A6EFB9AD535528C0554383AFD", hash_generated_field = "94DF4161B88336D5281295E3F052A420")

    public static final int CHUNK_REAE = type("REAE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "B72DCD9A9E095F179367D03EDE42943D", hash_generated_field = "AC2A957E2C3565B004E9A073E50036FF")

    public static final int CHUNK_REAQ = type("REAQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "2B6A15DF0BA29C89216213502D83DE2A", hash_generated_field = "3A20641A5356020A50C369C19549AAD0")

    public static final int CHUNK_REAL = type("REAL");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.835 -0400", hash_original_field = "FD99FB9675F3F378437B80C78914859D", hash_generated_field = "41155868F04C6605317B5CC3A6E20227")

    private static DdmHandleHeap mInstance = new DdmHandleHeap();
}

