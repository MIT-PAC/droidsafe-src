package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class FileDescriptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.912 -0400", hash_original_field = "AFBBCDF48BBBB69A1D97A2B7954DC265", hash_generated_field = "AD84990C5A466F07845F94B14109703E")

    private int descriptor = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.912 -0400", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "85C5A980A68C0ECABEB30B9F109CBB75")
    public  FileDescriptor() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.912 -0400", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "EE61933B5F9A9EFBEFEB6AB62DB17D97")
    public void sync() throws SyncFailedException {
        try 
        {
            Libcore.os.fsync(this);
        } 
        catch (ErrnoException errnoException)
        {
            SyncFailedException sfe = new SyncFailedException(errnoException.getMessage());
            sfe.initCause(errnoException);
            if (DroidSafeAndroidRuntime.control) throw sfe;
        } 
        
        
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.912 -0400", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "D77745EBAEE38458064706CDEED6A100")
    public boolean valid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678729832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_678729832;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.913 -0400", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "242DF7782077EFF71DC0191CBAC61354")
    public final int getInt$() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317538111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317538111;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.913 -0400", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "9CD3F8ACD13BA5BC1DEAE478056B0187")
    public final void setInt$(int fd) {
        this.descriptor = fd;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.913 -0400", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "154CB08BE15BF827C1BE0067E0773498")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_572449225 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_572449225 = "FileDescriptor[" + descriptor + "]";
        varB4EAC82CA7396A68D541C85D26508E83_572449225.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_572449225;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.914 -0400", hash_original_field = "7676E3B9130801538577AFE480937409", hash_generated_field = "C19A0692982848458993186E6FD00EBE")

    public static final FileDescriptor in = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.914 -0400", hash_original_field = "3FBE3ACD5C7F74E400CC727D35F8EDD1", hash_generated_field = "D147B1CB00E288088DE893A1ECDA0D51")

    public static final FileDescriptor out = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.914 -0400", hash_original_field = "EDC700597AEE331203E95690400900DC", hash_generated_field = "B493CA9CC8E849FAF1BEFA5E04A026DF")

    public static final FileDescriptor err = new FileDescriptor();
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}

