package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class FileDescriptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.758 -0400", hash_original_field = "AFBBCDF48BBBB69A1D97A2B7954DC265", hash_generated_field = "AD84990C5A466F07845F94B14109703E")

    private int descriptor = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.758 -0400", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "85C5A980A68C0ECABEB30B9F109CBB75")
    public  FileDescriptor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.759 -0400", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "25AFC79BFB4F60369D19193124ED8FC0")
    public void sync() throws SyncFailedException {
        try 
        {
            Libcore.os.fsync(this);
        } //End block
        catch (ErrnoException errnoException)
        {
            SyncFailedException sfe;
            sfe = new SyncFailedException(errnoException.getMessage());
            sfe.initCause(errnoException);
            if (DroidSafeAndroidRuntime.control) throw sfe;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.fsync(this);
        //} catch (ErrnoException errnoException) {
            //SyncFailedException sfe = new SyncFailedException(errnoException.getMessage());
            //sfe.initCause(errnoException);
            //throw sfe;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.759 -0400", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "D6DF899D825B93446ED5EC68185612E6")
    public boolean valid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574837698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574837698;
        // ---------- Original Method ----------
        //return descriptor != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.759 -0400", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "E0E1A9098755B9497957AAAE3BAD9476")
    public final int getInt$() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543145001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543145001;
        // ---------- Original Method ----------
        //return descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.760 -0400", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "9CD3F8ACD13BA5BC1DEAE478056B0187")
    public final void setInt$(int fd) {
        this.descriptor = fd;
        // ---------- Original Method ----------
        //this.descriptor = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.760 -0400", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "A371017BAD80D1D6AD45388A06635416")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_647652020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_647652020 = "FileDescriptor[" + descriptor + "]";
        varB4EAC82CA7396A68D541C85D26508E83_647652020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_647652020;
        // ---------- Original Method ----------
        //return "FileDescriptor[" + descriptor + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.760 -0400", hash_original_field = "7676E3B9130801538577AFE480937409", hash_generated_field = "C19A0692982848458993186E6FD00EBE")

    public static final FileDescriptor in = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.760 -0400", hash_original_field = "3FBE3ACD5C7F74E400CC727D35F8EDD1", hash_generated_field = "D147B1CB00E288088DE893A1ECDA0D51")

    public static final FileDescriptor out = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.760 -0400", hash_original_field = "EDC700597AEE331203E95690400900DC", hash_generated_field = "B493CA9CC8E849FAF1BEFA5E04A026DF")

    public static final FileDescriptor err = new FileDescriptor();
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}

