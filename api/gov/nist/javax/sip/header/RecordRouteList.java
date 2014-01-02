package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.RecordRouteHeader;






public class RecordRouteList extends SIPHeaderList<RecordRoute> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.029 -0500", hash_original_field = "B0DC857C2908D5BF29D064D99C5D0A7B", hash_generated_field = "44C63522FD239381EAF8817DE94BC086")


    private static final long serialVersionUID = 1724940469426766691L;
    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.035 -0500", hash_original_method = "7184B4196316005943D81815B77BA6D1", hash_generated_method = "B58F4A0BC8477F540E5D9BBD21E7CA93")
    
public RecordRouteList() {
        super(RecordRoute.class, RecordRouteHeader.NAME);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:06.032 -0500", hash_original_method = "7817AF16B5252B16AA7B12BAE88CFC40", hash_generated_method = "411BE966881C61BB191D691B0EF06140")
    
public Object clone() {
        RecordRouteList retval = new RecordRouteList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

