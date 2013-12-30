package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class OperationApplicationException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.375 -0500", hash_original_field = "B084F1694C2F42B2E12BD00B22F90D87", hash_generated_field = "394223B065D0D359C43F3F4B72BA8F23")

    private  int mNumSuccessfulYieldPoints;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.377 -0500", hash_original_method = "825A0D209F83C788198717CC73F99489", hash_generated_method = "EBD0B0F99FF2C604FB89B76D245B60E1")
    
public OperationApplicationException() {
        super();
        mNumSuccessfulYieldPoints = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.380 -0500", hash_original_method = "77E2AE76D845D6FB97485837BDB7758B", hash_generated_method = "58BA31DDC3C9A54BC1C83A4000BFF5DD")
    
public OperationApplicationException(String message) {
        super(message);
        mNumSuccessfulYieldPoints = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.382 -0500", hash_original_method = "F0F6059D3EFC4E5FE3F6EC4FF0F2FDFB", hash_generated_method = "4D87044C18E1DF7AD9D251125DD54656")
    
public OperationApplicationException(String message, Throwable cause) {
        super(message, cause);
        mNumSuccessfulYieldPoints = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.385 -0500", hash_original_method = "64BB28A032D4059B850837C1A5699554", hash_generated_method = "28DBB51468FB5C82522EB1BFA29994AD")
    
public OperationApplicationException(Throwable cause) {
        super(cause);
        mNumSuccessfulYieldPoints = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.388 -0500", hash_original_method = "E4F3CE45A3791740F0C42342B2E05EC8", hash_generated_method = "F28A93ABC0AA99B7632949165293CCA0")
    
public OperationApplicationException(int numSuccessfulYieldPoints) {
        super();
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.391 -0500", hash_original_method = "8F9006EEA79EF42E9E468007193B747B", hash_generated_method = "B3D157F2D19B061E0795798F341FF4A8")
    
public OperationApplicationException(String message, int numSuccessfulYieldPoints) {
        super(message);
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.393 -0500", hash_original_method = "0D03973B4F1A76863E3DF446BDE01596", hash_generated_method = "7518C00CB505EC052EC9E46B85323AC3")
    
public int getNumSuccessfulYieldPoints() {
        return mNumSuccessfulYieldPoints;
    }

    
}

