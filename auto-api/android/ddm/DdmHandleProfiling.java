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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.022 -0400", hash_original_method = "7648F12CCEF030214D1E836EAA9C8F00", hash_generated_method = "48A50242375078711F75A3CE1492C05E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.023 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.024 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.026 -0400", hash_original_method = "DB7D0E34713769F576AB6489AD8FC572", hash_generated_method = "32ECEA94B0B8DA20AE874FE4955BAA1F")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1227449155 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_370246816 = null; //Variable for return #2
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1959846048 = null; //Variable for return #3
        Chunk varB4EAC82CA7396A68D541C85D26508E83_747257615 = null; //Variable for return #4
        Chunk varB4EAC82CA7396A68D541C85D26508E83_43449335 = null; //Variable for return #5
        int type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1227449155 = handleMPRS(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_370246816 = handleMPRE(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1959846048 = handleMPSS(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_747257615 = handleMPSE(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_43449335 = handleMPRQ(request);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_2066070676; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2066070676 = varB4EAC82CA7396A68D541C85D26508E83_1227449155;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2066070676 = varB4EAC82CA7396A68D541C85D26508E83_370246816;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2066070676 = varB4EAC82CA7396A68D541C85D26508E83_1959846048;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2066070676 = varB4EAC82CA7396A68D541C85D26508E83_747257615;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2066070676 = varB4EAC82CA7396A68D541C85D26508E83_43449335;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2066070676.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2066070676;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.028 -0400", hash_original_method = "7940F56C64BA10714BAFA7B4E80C835C", hash_generated_method = "81479AA3212207D63E858510C22895D7")
    private Chunk handleMPRS(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_339155724 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_959211450 = null; //Variable for return #2
        ByteBuffer in = wrapChunk(request);
        int bufferSize = in.getInt();
        int flags = in.getInt();
        int len = in.getInt();
        String fileName = getString(in, len);
        try 
        {
            Debug.startMethodTracing(fileName, bufferSize, flags);
            varB4EAC82CA7396A68D541C85D26508E83_339155724 = null;
        } //End block
        catch (RuntimeException re)
        {
            varB4EAC82CA7396A68D541C85D26508E83_959211450 = createFailChunk(1, re.getMessage());
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_209330201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_209330201 = varB4EAC82CA7396A68D541C85D26508E83_339155724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_209330201 = varB4EAC82CA7396A68D541C85D26508E83_959211450;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_209330201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_209330201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.382 -0400", hash_original_method = "C47365EF242409DEE5C5F31B2C812A87", hash_generated_method = "A679BAAE8C0B48CF50E9B5F5D297FAE7")
    private Chunk handleMPRE(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_581480896 = null; //Variable for return #1
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
        byte[] reply = {result};
        varB4EAC82CA7396A68D541C85D26508E83_581480896 = new Chunk(CHUNK_MPRE, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_581480896.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_581480896;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.030 -0400", hash_original_method = "0C48BE140EF77A3564208CCA411868CA", hash_generated_method = "577ABC0E379CBE779809EB3E7B8E1FC3")
    private Chunk handleMPSS(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_304086113 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1576227092 = null; //Variable for return #2
        ByteBuffer in = wrapChunk(request);
        int bufferSize = in.getInt();
        int flags = in.getInt();
        try 
        {
            Debug.startMethodTracingDdms(bufferSize, flags);
            varB4EAC82CA7396A68D541C85D26508E83_304086113 = null;
        } //End block
        catch (RuntimeException re)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1576227092 = createFailChunk(1, re.getMessage());
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_230635789; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_230635789 = varB4EAC82CA7396A68D541C85D26508E83_304086113;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_230635789 = varB4EAC82CA7396A68D541C85D26508E83_1576227092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_230635789.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_230635789;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.032 -0400", hash_original_method = "47063ECEB662F521C374596F0F7AD1C6", hash_generated_method = "F924FC0C58BBDAE77A15172FF19D2BCA")
    private Chunk handleMPSE(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_617233398 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1621361757 = null; //Variable for return #2
        byte result;
        try 
        {
            Debug.stopMethodTracing();
            result = 0;
        } //End block
        catch (RuntimeException re)
        {
            varB4EAC82CA7396A68D541C85D26508E83_617233398 = createFailChunk(1, re.getMessage());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1621361757 = null;
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_430770704; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_430770704 = varB4EAC82CA7396A68D541C85D26508E83_617233398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_430770704 = varB4EAC82CA7396A68D541C85D26508E83_1621361757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_430770704.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_430770704;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.400 -0400", hash_original_method = "0E3CEBD2C4AA1513EB9DBAF86A751F94", hash_generated_method = "CB7917A733E793CFD34D101CB8CBC561")
    private Chunk handleMPRQ(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1690965948 = null; //Variable for return #1
        int result;
        boolean var1CCE90F3EA3D9C9EE69CE8E366F38561_198695051 = (Debug.isMethodTracingActive());
        result = 1;
        result = 0;
        byte[] reply = {(byte) result};
        varB4EAC82CA7396A68D541C85D26508E83_1690965948 = new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1690965948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690965948;
        // ---------- Original Method ----------
        //int result = Debug.isMethodTracingActive() ? 1 : 0;
        //byte[] reply = { (byte) result };
        //return new Chunk(CHUNK_MPRQ, reply, 0, reply.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.032 -0400", hash_original_field = "F5855C2CC22D4A653AC96BEEEDA26DA2", hash_generated_field = "7FFFFE3EB65969A45E28C911251E127E")

    public static final int CHUNK_MPRS = type("MPRS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.032 -0400", hash_original_field = "EE3CC7E6F5F4CCB0D28FF88878ACB038", hash_generated_field = "7F18F91381D75BE7FEA8B9EA463A84F4")

    public static final int CHUNK_MPRE = type("MPRE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.033 -0400", hash_original_field = "00DBD908EF0581304C88FAFB3BA10EEF", hash_generated_field = "27590C354FA31B4C05A287778E41C9D8")

    public static final int CHUNK_MPSS = type("MPSS");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.033 -0400", hash_original_field = "78470172F92B6383D6DD1529F343A54F", hash_generated_field = "A2188CC3E8488D7886638119E037639F")

    public static final int CHUNK_MPSE = type("MPSE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.033 -0400", hash_original_field = "50342B8AC484C51A3C674CD2C378E988", hash_generated_field = "1621D64DD5751DA51B57A9D956F98541")

    public static final int CHUNK_MPRQ = type("MPRQ");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.033 -0400", hash_original_field = "0BC8A4CCE80D5531F80E14D9707C7F4F", hash_generated_field = "518411F24B65007CDBF385DFFC68993E")

    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();
}

