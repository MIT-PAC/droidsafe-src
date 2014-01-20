package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Version {

	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.773 -0500", hash_original_method = "6FE0C5C71DBE96BC9C08E7883680FC72", hash_generated_method = "2AE3C8350E3868EDE79E75332785E172")
	
public static String id() {
		return "3.8.1";
	}
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.771 -0500", hash_original_method = "783F8C18B2BD3982CB7AF1593B9B73BB", hash_generated_method = "76698DAF4316C635D6C0141D8EFD3E22")
	
private Version() {
		// don't instantiate
	}
    
}

