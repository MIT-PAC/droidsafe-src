package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.634 -0400", hash_original_field = "C87A8CA60F0891B79D192FA86F019916", hash_generated_field = "D91EA2DC02C3EC2AB5BA639FC5E59C31")

    private StringBuilder builder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.634 -0400", hash_original_method = "0F8886FC3E573AEC69371F58BBD3CDEF", hash_generated_method = "C1177F3DFC86ACC1993095105E85554E")
    public  StringBuilderWriter() {
        this.builder = new StringBuilder();
        // ---------- Original Method ----------
        //this.builder = new StringBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.634 -0400", hash_original_method = "7EF54AD3CF929444DD9C4F80FE3F6C6F", hash_generated_method = "2D7EB5F7BE2E8EE3154F90A6663BC149")
    public  StringBuilderWriter(int capacity) {
        this.builder = new StringBuilder(capacity);
        // ---------- Original Method ----------
        //this.builder = new StringBuilder(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.637 -0400", hash_original_method = "1B264769CCFA0A0E39B7C5DD9D4CA02B", hash_generated_method = "34DD1720B5F2A1EBBE3CD8EA6B0F3506")
    public  StringBuilderWriter(StringBuilder builder) {
        this.builder = builder != null ? builder : new StringBuilder();
        // ---------- Original Method ----------
        //this.builder = builder != null ? builder : new StringBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.638 -0400", hash_original_method = "1288124DBF43C46402FB70C838950E72", hash_generated_method = "C2E1208742E8424BA9ABA5E65C59EF7A")
    @Override
    public Writer append(char value) {
        Writer varB4EAC82CA7396A68D541C85D26508E83_740954971 = null; //Variable for return #1
        builder.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_740954971 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_740954971.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_740954971;
        // ---------- Original Method ----------
        //builder.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.638 -0400", hash_original_method = "E2F995DD283D6A0A833AF2D339D19742", hash_generated_method = "02AE2DA85A8CCA16D7A9D39CE5822D52")
    @Override
    public Writer append(CharSequence value) {
        Writer varB4EAC82CA7396A68D541C85D26508E83_1099196549 = null; //Variable for return #1
        builder.append(value);
        varB4EAC82CA7396A68D541C85D26508E83_1099196549 = this;
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1099196549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1099196549;
        // ---------- Original Method ----------
        //builder.append(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.642 -0400", hash_original_method = "FBCD01EFCECB3326031D766445C3DB2F", hash_generated_method = "74263475CFE5CEF38DF0039C365187AE")
    @Override
    public Writer append(CharSequence value, int start, int end) {
        Writer varB4EAC82CA7396A68D541C85D26508E83_671842408 = null; //Variable for return #1
        builder.append(value, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_671842408 = this;
        addTaint(value.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_671842408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671842408;
        // ---------- Original Method ----------
        //builder.append(value, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.643 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.651 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.652 -0400", hash_original_method = "57CA96DC87E6760D66D655253DABAA82", hash_generated_method = "1E194711879A0107416B68CCDC759346")
    @Override
    public void write(String value) {
        {
            builder.append(value);
        } //End block
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (value != null) {
            //builder.append(value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.653 -0400", hash_original_method = "F2F4EE164E03551E9A5ECDB103942BDC", hash_generated_method = "138463377562FDE75E075C57C173E796")
    @Override
    public void write(char[] value, int offset, int length) {
        {
            builder.append(value, offset, length);
        } //End block
        addTaint(value[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (value != null) {
            //builder.append(value, offset, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.653 -0400", hash_original_method = "0D111D6CF8966EDDBE82FC68A5093A5D", hash_generated_method = "F4B3E6079DBFD2AF1615AB80AFFC7A43")
    public StringBuilder getBuilder() {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_304066698 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_304066698 = builder;
        varB4EAC82CA7396A68D541C85D26508E83_304066698.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304066698;
        // ---------- Original Method ----------
        //return builder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.658 -0400", hash_original_method = "E91A134CF2A6965AC8B4CE2DD48C1D34", hash_generated_method = "7BD7EE97D6800C986A4D0616E4800064")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_960061749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_960061749 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_960061749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_960061749;
        // ---------- Original Method ----------
        //return builder.toString();
    }

    
}

