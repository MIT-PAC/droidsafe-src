package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class MediaRange extends SIPObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.978 -0500", hash_original_field = "9B445054D3DA4317BA4EC07ED3B61EBC", hash_generated_field = "3BDB1FA41CCA61D52855E12BDAC970C8")

    private static final long serialVersionUID = -6297125815438079210L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.982 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.985 -0500", hash_original_field = "CC0F1C7C603FCDCAAE35E383853082DA", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.989 -0500", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "332D28D485461FAA474C57BB36549724")
    
public MediaRange() {
    }

    /** get type field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.992 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "375DB45064AFC367CAD6F27C4CB89612")
    
public String getType() {
        return type;
    }

    /** get the subType field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.996 -0500", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "50ACC84C398159867407D12731DDC0B0")
    
public String getSubtype() {
        return subtype;
    }

    /**
     * Set the type member
     * @param t String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.000 -0500", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "720CC17B340206378ED96147D95F1162")
    
public void setType(String t) {
        type = t;
    }

    /**
     * Set the subtype member
     * @param s String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.003 -0500", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "1CF547D83A92409E1DCA7135E1253D08")
    
public void setSubtype(String s) {
        subtype = s;
    }

    /**
     * Encode the object.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.007 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.010 -0500", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "4EB3B8FC3BDDE15E42CE4D630BFAC5C1")
    
public StringBuffer encode(StringBuffer buffer) {
        return buffer.append(type)
                .append(SLASH)
                .append(subtype);
    }
}

