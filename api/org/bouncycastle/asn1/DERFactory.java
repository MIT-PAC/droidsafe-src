package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class DERFactory {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.314 -0500", hash_original_method = "B358167A9243B301CDBE42B13A7FCA2E", hash_generated_method = "161026F7D87A30FE47ECAD6DD6507C3F")
    
static DERSequence createSequence(ASN1EncodableVector v)
    {
        return v.size() < 1 ? EMPTY_SEQUENCE : new DERSequence(v);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.316 -0500", hash_original_method = "EC81E4E4BB5F30D96A37DECC8714E1EB", hash_generated_method = "F2CE75632A8093ACF382DC7FDD66F5EA")
    
static DERSet createSet(ASN1EncodableVector v)
    {
        return v.size() < 1 ? EMPTY_SET : new DERSet(v);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.319 -0500", hash_original_method = "32D8F434EAB688E38C9FF6F3D112EAB2", hash_generated_method = "8DE4FE4054A4A21E69EF88D5003288BA")
    
static DERSet createSet(ASN1EncodableVector v, boolean needsSorting)
    {
        return v.size() < 1 ? EMPTY_SET : new DERSet(v, needsSorting);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.310 -0500", hash_original_field = "35C81936FD9267339AED37BE9DA70342", hash_generated_field = "8DB0FE673D2D50C4769908D74217CDFF")

    static final DERSequence EMPTY_SEQUENCE = new DERSequence();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.312 -0500", hash_original_field = "BEC908BBA74E2C8336295439C3905E06", hash_generated_field = "FEBB06D705F432CF8A0E56C80DA23C00")

    static final DERSet EMPTY_SET = new DERSet();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.247 -0400", hash_original_method = "2DA71B0AE496B3C2B80EF0106AA885B2", hash_generated_method = "2DA71B0AE496B3C2B80EF0106AA885B2")
    public DERFactory ()
    {
        //Synthesized constructor
    }
}

