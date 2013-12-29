package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public final class StructUtsname {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.948 -0500", hash_original_field = "97ED6A6DCDD685F9B3DC68D91EF7195D", hash_generated_field = "06EE67511C7267E177679ED8D9906A87")

    public  String sysname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.948 -0500", hash_original_field = "063CA11C88281A66D3723E0AA05932E2", hash_generated_field = "5A29BC3D798865B30AF3074E4C0D6EEE")

    public  String nodename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.949 -0500", hash_original_field = "1274981E6885D0667CEE13BB63F79D31", hash_generated_field = "704FF7DA5C540CEA121D5F9E29DC7423")

    public  String release;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.950 -0500", hash_original_field = "E7C7F9C42A2A22D94FED803CEAE19197", hash_generated_field = "541C5F053DD8C944D595E47B62A0349B")

    public  String version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.951 -0500", hash_original_field = "9081D9187256DBF84B010DA1BCB2D192", hash_generated_field = "E93761CEF58612877F770D81A7789428")

    public  String machine;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.952 -0500", hash_original_method = "ABD276C824D50C395959B30AFCABD3AD", hash_generated_method = "ABD276C824D50C395959B30AFCABD3AD")
    StructUtsname(String sysname, String nodename, String release, String version, String machine) {
        this.sysname = sysname;
        this.nodename = nodename;
        this.release = release;
        this.version = version;
        this.machine = machine;
    }

    
}

