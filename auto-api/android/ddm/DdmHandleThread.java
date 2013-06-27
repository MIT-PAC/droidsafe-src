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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.938 -0400", hash_original_method = "9014293089915C4268DF07C71EC6FF27", hash_generated_method = "FE5211883165D04E298E22C79DEA3B63")
    private  DdmHandleThread() {
        // ---------- Original Method ----------
    }

    
        public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.939 -0400", hash_original_method = "FF1AB110B94FCC8AEFA697D75FFC57DD", hash_generated_method = "234EA70F7C5F3B8EA6891C34DC4DD59D")
    public void connected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.939 -0400", hash_original_method = "7ECE87C8E0B6AC612BF4B05EB3BE89DA", hash_generated_method = "A03BB8B8FD980F77D1775E26C3251D60")
    public void disconnected() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.947 -0400", hash_original_method = "A7F2A84C27DF1EE7C10C6ACC7D9300BF", hash_generated_method = "E0B821B3742C76CC536175FC46EAFBF6")
    public Chunk handleChunk(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1059039922 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_945469077 = null; //Variable for return #2
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1280294404 = null; //Variable for return #3
        int type;
        type = request.type;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1059039922 = handleTHEN(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_945469077 = handleTHST(request);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1280294404 = handleSTKL(request);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown packet "
                + ChunkHandler.name(type));
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1353415178; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1353415178 = varB4EAC82CA7396A68D541C85D26508E83_1059039922;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1353415178 = varB4EAC82CA7396A68D541C85D26508E83_945469077;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1353415178 = varB4EAC82CA7396A68D541C85D26508E83_1280294404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1353415178.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1353415178;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.968 -0400", hash_original_method = "BC156E08FEFB0A0F13BF2C52AB62FDFE", hash_generated_method = "204CF92A3C87E449CA437E35D3F420F6")
    private Chunk handleTHEN(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_77910386 = null; //Variable for return #1
        ByteBuffer in;
        in = wrapChunk(request);
        boolean enable;
        enable = (in.get() != 0);
        DdmVmInternal.threadNotify(enable);
        varB4EAC82CA7396A68D541C85D26508E83_77910386 = null;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_77910386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_77910386;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //boolean enable = (in.get() != 0);
        //DdmVmInternal.threadNotify(enable);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.969 -0400", hash_original_method = "2695125C08C32728E983ED92A17A93FC", hash_generated_method = "2395EE7E0A9F6E06FE10A0996E947504")
    private Chunk handleTHST(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1689753269 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_2123438490 = null; //Variable for return #2
        ByteBuffer in;
        in = wrapChunk(request);
        byte[] status;
        status = DdmVmInternal.getThreadStats();
        varB4EAC82CA7396A68D541C85D26508E83_1689753269 = new Chunk(CHUNK_THST, status, 0, status.length);
        varB4EAC82CA7396A68D541C85D26508E83_2123438490 = createFailChunk(1, "Can't build THST chunk");
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_935140741; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_935140741 = varB4EAC82CA7396A68D541C85D26508E83_1689753269;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_935140741 = varB4EAC82CA7396A68D541C85D26508E83_2123438490;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_935140741.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_935140741;
        // ---------- Original Method ----------
        //ByteBuffer in = wrapChunk(request);
        //byte[] status = DdmVmInternal.getThreadStats();
        //if (status != null)
            //return new Chunk(CHUNK_THST, status, 0, status.length);
        //else
            //return createFailChunk(1, "Can't build THST chunk");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.987 -0400", hash_original_method = "D658C618BB2C2BBDA71F6A2C6E25EF76", hash_generated_method = "C4477E34D61C22BD579B23DBCFD1522E")
    private Chunk handleSTKL(Chunk request) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_98662679 = null; //Variable for return #1
        Chunk varB4EAC82CA7396A68D541C85D26508E83_864887463 = null; //Variable for return #2
        ByteBuffer in;
        in = wrapChunk(request);
        int threadId;
        threadId = in.getInt();
        StackTraceElement[] trace;
        trace = DdmVmInternal.getStackTraceById(threadId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_98662679 = createFailChunk(1, "Stack trace unavailable");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_864887463 = createStackChunk(trace, threadId);
        } //End block
        addTaint(request.getTaint());
        Chunk varA7E53CE21691AB073D9660D615818899_1555627745; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1555627745 = varB4EAC82CA7396A68D541C85D26508E83_98662679;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1555627745 = varB4EAC82CA7396A68D541C85D26508E83_864887463;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1555627745.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1555627745;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.238 -0400", hash_original_method = "B0772B34720138634AE49D68BC346BA3", hash_generated_method = "E865EFFD9B79757FD81CECD167315A3C")
    private Chunk createStackChunk(StackTraceElement[] trace, int threadId) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_208281268 = null; //Variable for return #1
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
                    boolean var93B99DCE0D9ACE48F0C4400FF6C9D466_539652833 = (elem.getFileName() != null);
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
                    boolean var93B99DCE0D9ACE48F0C4400FF6C9D466_797342778 = (elem.getFileName() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_208281268 = new Chunk(CHUNK_STKL, out);
        addTaint(trace[0].getTaint());
        addTaint(threadId);
        varB4EAC82CA7396A68D541C85D26508E83_208281268.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_208281268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.238 -0400", hash_original_field = "DD50DBD67A5E5DC1110188F9F71C903E", hash_generated_field = "6FD8B0A025617CAABDC74F5512BD1925")

    public static final int CHUNK_THEN = type("THEN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.238 -0400", hash_original_field = "01CEDF6E4A0B4BF2A1DFCF52F7C7E336", hash_generated_field = "76B61FBE133D3C178633BE3ED16C7D88")

    public static final int CHUNK_THCR = type("THCR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.238 -0400", hash_original_field = "A60580E875FCE044104AAB21C07B6657", hash_generated_field = "6C54A1712C9684C82DFE10C559A7239B")

    public static final int CHUNK_THDE = type("THDE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.239 -0400", hash_original_field = "BDA31750CF04DAD7FEF6959DFBE41BDC", hash_generated_field = "0037B4EAFA33D36A94E59F46954153B0")

    public static final int CHUNK_THST = type("THST");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.239 -0400", hash_original_field = "02E3E404B7350BC0FCCEAF2613E84FEC", hash_generated_field = "05661DA41737F5FE00F60ABE023BA158")

    public static final int CHUNK_STKL = type("STKL");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.239 -0400", hash_original_field = "7633E0A01D950255DC3FF633A87D0525", hash_generated_field = "80D0E25C8F1F0092137DF49E7789674E")

    private static DdmHandleThread mInstance = new DdmHandleThread();
}

