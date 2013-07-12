package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class FileWriter extends OutputStreamWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.662 -0400", hash_original_method = "B243913791A4955722C7446949980DA0", hash_generated_method = "5D4D46EFA53E8F28CC5F5E95CC8BCF0D")
    public  FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.663 -0400", hash_original_method = "79860F10C9F09BC3FC3374E75EC2439D", hash_generated_method = "4738AF70786DD2FD1F62C8315A1A0D5D")
    public  FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
        addTaint(append);
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.664 -0400", hash_original_method = "83907072F4E4E17B7331DF75EE7AA617", hash_generated_method = "50D1C76FC466FB770B374EED9727EA88")
    public  FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
        addTaint(fd.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.665 -0400", hash_original_method = "7A60608F9C8A66E68FB25FC3BD2DB01D", hash_generated_method = "0F92FC2994F73FEE5081DE3B38725F95")
    public  FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
        addTaint(filename.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.667 -0400", hash_original_method = "754E5DA17049F1720720C66817C48E5C", hash_generated_method = "678E38A273450234BB73D178C8BC8C9F")
    public  FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
        addTaint(append);
        addTaint(filename.getTaint());
        
    }

    
}

