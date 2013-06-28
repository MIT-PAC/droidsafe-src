package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class HttpVersion extends ProtocolVersion implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.480 -0400", hash_original_method = "150D62CB24782FBFD68E18019E7202DB", hash_generated_method = "EC7C68D31A048E254DAD7BE44F999E3B")
    public  HttpVersion(int major, int minor) {
        super(HTTP, major, minor);
        addTaint(major);
        addTaint(minor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_method = "102B5DD63D8812CA09E006716DE254FA", hash_generated_method = "6F74AE6E05C7FBDE461CDC5DF85918DC")
    public ProtocolVersion forVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_336533236 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_951443867 = null; //Variable for return #2
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_926351358 = null; //Variable for return #3
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_548085673 = null; //Variable for return #4
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1173957345 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_336533236 = this;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_951443867 = HTTP_1_0;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_926351358 = HTTP_1_1;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_548085673 = HTTP_0_9;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1173957345 = new HttpVersion(major, minor);
        addTaint(major);
        addTaint(minor);
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_1647819714; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1647819714 = varB4EAC82CA7396A68D541C85D26508E83_336533236;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1647819714 = varB4EAC82CA7396A68D541C85D26508E83_951443867;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1647819714 = varB4EAC82CA7396A68D541C85D26508E83_926351358;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1647819714 = varB4EAC82CA7396A68D541C85D26508E83_548085673;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1647819714 = varB4EAC82CA7396A68D541C85D26508E83_1173957345;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1647819714.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1647819714;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //if (major == 1) {
            //if (minor == 0) {
                //return HTTP_1_0;
            //}
            //if (minor == 1) {
                //return HTTP_1_1;
            //}
        //}
        //if ((major == 0) && (minor == 9)) {
            //return HTTP_0_9;
        //}
        //return new HttpVersion(major, minor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_field = "D2B91B05E2609572189EF6CCE02A44D3", hash_generated_field = "4AA18FBAD714C83CF6883EBA6D23F39C")

    private static final long serialVersionUID = -5856653513894415344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_field = "5BC6464C73A79B42771FD59D331B1E8E", hash_generated_field = "BD0B770B1DA58B440FD2A9FDBB7EFD6F")

    public static final String HTTP = "HTTP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_field = "7DA3371948BD80535FAFD5437F115A9E", hash_generated_field = "F13F8B26DBE79268EEE81DDB7ABECF4F")

    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_field = "793E47850E63B266B1ABA0AB1FF24EE7", hash_generated_field = "16A7185B0988E5CE22D3E365290FDDBF")

    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.482 -0400", hash_original_field = "B3E73FA4EB1CB3473D353EBAE8B995B4", hash_generated_field = "E158A70472CF43C3AF1C153DDD6B4EF4")

    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
}

