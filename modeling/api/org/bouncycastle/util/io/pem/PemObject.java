package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class PemObject implements PemObjectGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.473 -0500", hash_original_field = "7FC72EDBDC144E03FDCF91DEC400EE6B", hash_generated_field = "4F4BAD0CB2525EB0C5709334AA057CD9")

    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.475 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")


    private String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.477 -0500", hash_original_field = "2E4A517DF74BC5A5A497BA92F88228C9", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List   headers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.479 -0500", hash_original_field = "6A9B1BF6E4F51C5BBC665A9F39B095B2", hash_generated_field = "2AFA79670796B1E0B73AB75D7B8465D5")

    private byte[] content;

    /**
     * Generic constructor for object without headers.
     *
     * @param type pem object type.
     * @param content the binary content of the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.481 -0500", hash_original_method = "E8E4F9BE36AC2F3679718F77E354BD1D", hash_generated_method = "89B5D831DEA5B0FBA78CC16B78A5B788")
    
public PemObject(String type, byte[] content)
    {
        this(type, EMPTY_LIST, content);
    }

    /**
     * Generic constructor for object with headers.
     *
     * @param type pem object type.
     * @param headers a list of PemHeader objects.
     * @param content the binary content of the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.484 -0500", hash_original_method = "A9F012093AAD72893A58BFC7BE174583", hash_generated_method = "84F40E6254DDCBCDBCBA3C5361BB2E39")
    
public PemObject(String type, List headers, byte[] content)
    {
        this.type = type;
        this.headers = Collections.unmodifiableList(headers);
        this.content = content;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.486 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "375DB45064AFC367CAD6F27C4CB89612")
    
public String getType()
    {
        return type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.489 -0500", hash_original_method = "7A0337E547AB2E290525371E494B1A30", hash_generated_method = "F78A5E12031E80805D54D72C555C686D")
    
public List getHeaders()
    {
        return headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.491 -0500", hash_original_method = "CA0902D8AF35560815DA28546D2C787A", hash_generated_method = "C4C76DE2503F6B38706CB739F50B958E")
    
public byte[] getContent()
    {
        return content;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.493 -0500", hash_original_method = "E898D78DBFB1F3FB89A6D402FC0A6D27", hash_generated_method = "24E49ADB9FCCC07E26887964990D2F1E")
    
public PemObject generate()
        throws PemGenerationException
    {
        return this;
    }
}

