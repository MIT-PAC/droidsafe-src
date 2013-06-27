package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DOMException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "5E518509D078CBA65D8E1C88B69CC66E")

    public short code;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_method = "0AC2D186CABB78D2BA6332ECA7EA8409", hash_generated_method = "6EE45E0AB1EA9141ECF7CB0D810AF53E")
    public  DOMException(short code, String message) {
        super(message);
        this.code = code;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.code = code;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "EB3D51C4FBCDEFA204E0D77375D72DD3", hash_generated_field = "DD2E2F5E5252C6BEA6752B347D710596")

    public static final short INDEX_SIZE_ERR            = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "5FBB112017A7AA326A58CDA65F2845E5", hash_generated_field = "3D6F297A2B43744FF37BF31B6C7EC120")

    public static final short DOMSTRING_SIZE_ERR        = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "F545E743C0A4652F50DC4021AA0091D7", hash_generated_field = "72E1BDD1917135729A2087F22C52544B")

    public static final short HIERARCHY_REQUEST_ERR     = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "8EE4F6BA8B83585D8863A1FD46C0767E", hash_generated_field = "DA44178BBE9462B7B5AB6772EFFE2C08")

    public static final short WRONG_DOCUMENT_ERR        = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "429216474F2FAF5B8DDBF0A0D8416207", hash_generated_field = "805486A980FBA93F673D7A276AA1A7EE")

    public static final short INVALID_CHARACTER_ERR     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "509CBCFBDD88D5AD3688E1156FE40E30", hash_generated_field = "170FEEB0666CD34719E74694BA75E81D")

    public static final short NO_DATA_ALLOWED_ERR       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "F09B19F21BB1A8B1EC2AAD6B12E54CBF", hash_generated_field = "973982CA2917A22A966A20AD088B1C09")

    public static final short NO_MODIFICATION_ALLOWED_ERR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "1598F85C1F1E02F431F1585A3BDB637C", hash_generated_field = "730B5D6777E7B9A774A72656EAF616CC")

    public static final short NOT_FOUND_ERR             = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "2B882869B12D4CC74B3F712435A3DF97", hash_generated_field = "8989E69EBF8D6238CFC6296AF0DF2B4D")

    public static final short NOT_SUPPORTED_ERR         = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "4DDF2F25CA3AF0E6BD075A47F160BEC2", hash_generated_field = "DA038D207206C798D80C9B363424AE9E")

    public static final short INUSE_ATTRIBUTE_ERR       = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "E42A41F33CA920F92EA33562810F6AB3", hash_generated_field = "1A5F7AD9042CDA9D782BB551172B8D84")

    public static final short INVALID_STATE_ERR         = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "41F220155C6D824EB7B6BEF4F9FF94E4", hash_generated_field = "D912D179B57CCD669AD836CBB1F4BDCA")

    public static final short SYNTAX_ERR                = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "7244FA3B7441F746C716532C0D10A734", hash_generated_field = "8DBD09678B3B6D6C756910B90AEA9402")

    public static final short INVALID_MODIFICATION_ERR  = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.857 -0400", hash_original_field = "51AA4502905C8291DB85F5A43F5926E6", hash_generated_field = "6FD5A9FD4914965940037196C9AEC3BA")

    public static final short NAMESPACE_ERR             = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.858 -0400", hash_original_field = "9ECA9A90056C78B4D846FF04459DE6A6", hash_generated_field = "0B93A7653B41AE8C961FFA5C9611C848")

    public static final short INVALID_ACCESS_ERR        = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.858 -0400", hash_original_field = "648A4525747362C7267384CA5B9FCEFA", hash_generated_field = "379AD170D52C4CAEDDE41321EB27BD66")

    public static final short VALIDATION_ERR            = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.858 -0400", hash_original_field = "88DC69EEC0E4DA67340C7273590F634A", hash_generated_field = "BEBAC5E1BFC1F09667C1415091497B1D")

    public static final short TYPE_MISMATCH_ERR         = 17;
}

