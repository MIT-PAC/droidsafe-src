package org.apache.commons.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.IOException;

public class FileExistsException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.330 -0400", hash_original_method = "F9315CC144268986DBB2C21411FC27E6", hash_generated_method = "BB3DBA80746EB2BEAAE78BD71D9CF641")
    public  FileExistsException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.330 -0400", hash_original_method = "969BBB2B9A0EFD63C3504D154290DE98", hash_generated_method = "A6A23BB911866303C055565D27B4F153")
    public  FileExistsException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.330 -0400", hash_original_method = "E6B23DB52F9D26F867FD6E13FC29AAA5", hash_generated_method = "ED91E36046B65D1CDD4DAA9CC0928B2D")
    public  FileExistsException(File file) {
        super("File " + file + " exists");
        addTaint(file.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.330 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

