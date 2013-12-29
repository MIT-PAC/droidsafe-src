package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public class DERBoolean extends ASN1Object {

    /**
     * return a boolean from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.473 -0500", hash_original_method = "FB93B9FA961BDE708CF373AF862EE775", hash_generated_method = "81B9E817C32A79AFC25CF51EB7D82DC9")
    public static DERBoolean getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERBoolean)
        {
            return (DERBoolean)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a DERBoolean from the passed in boolean.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.474 -0500", hash_original_method = "12CF07C5AAB49BEB306BFE5A85B22AE7", hash_generated_method = "6283A35CF4CACCE1DA2B0DBEE32E34F1")
    public static DERBoolean getInstance(
        boolean  value)
    {
        return (value ? TRUE : FALSE);
    }

    // BEGIN android-added
    /**
     * return a DERBoolean from the passed in array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.476 -0500", hash_original_method = "058DD12DC1EF6BF12288639CD00DE4B4", hash_generated_method = "4FF19FDBB67DC2DB82D3C9830FC3F309")
    public static DERBoolean getInstance(
        byte[] octets)
    {
        return (octets[0] != 0) ? TRUE : FALSE;
    }
    // END android-added

    /**
     * return a Boolean from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.476 -0500", hash_original_method = "221C8C8E0B6AC01012B2EF929B821075", hash_generated_method = "CD6D56A62750AC1CDB60FEB46FF886D6")
    public static DERBoolean getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERBoolean)
        {
            return getInstance(o);
        }
        else
        {
            // BEGIN android-changed
            return getInstance(((ASN1OctetString)o).getOctets());
            // END android-changed
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.471 -0500", hash_original_field = "443DB74997906F631C0EAFA70F40D420", hash_generated_field = "AD41B06028B6D238FF4AF850CAEFE733")


    public static final DERBoolean FALSE = new DERBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.472 -0500", hash_original_field = "E89193EB5853DE40403321C6D830E58C", hash_generated_field = "74021F0F40550CDAE080A69CBD04BF42")

    public static final DERBoolean TRUE  = new DERBoolean(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.470 -0500", hash_original_field = "6072D19D08473B81BB367C06EAF7BB24", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private  byte  value;
    
    // BEGIN android-removed
    // public DERBoolean(
    //     byte[]       value)
    // {
    //     if (value.length != 1)
    //     {
    //         throw new IllegalArgumentException("byte value should have 1 byte in it");
    //     }
    //
    //     this.value = value[0];
    // }
    // END android-removed

    // BEGIN android-changed
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.477 -0500", hash_original_method = "DE46F6E30E17087250BC7B7B32B3A323", hash_generated_method = "5A219D441428D1125BACF930CE955448")
    protected DERBoolean(
        boolean     value)
    // END android-changed
    {
        this.value = (value) ? (byte)0xff : (byte)0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.478 -0500", hash_original_method = "CAF36277BE2299D4A97B34E514847231", hash_generated_method = "29A62DE073FBD036677FFAF66EE992BE")
    public boolean isTrue()
    {
        return (value != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.479 -0500", hash_original_method = "17536CB7674727E81A6C11BC3F7B5C5B", hash_generated_method = "17536CB7674727E81A6C11BC3F7B5C5B")
    void encode(
        DEROutputStream out)
        throws IOException
    {
        byte[]  bytes = new byte[1];

        bytes[0] = value;

        out.writeEncoded(BOOLEAN, bytes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.480 -0500", hash_original_method = "7025372BC5443A52FED5B1B11C72A34D", hash_generated_method = "00E8C2C86738BD9C8747DB13B52CEBCE")
    protected boolean asn1Equals(
        DERObject  o)
    {
        if ((o == null) || !(o instanceof DERBoolean))
        {
            return false;
        }

        return (value == ((DERBoolean)o).value);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.480 -0500", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "E753536894997596C3E77EBC8B110A20")
    public int hashCode()
    {
        return value;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.481 -0500", hash_original_method = "9F6A9420185E5E125B8A61B3882EDFBB", hash_generated_method = "6F5ED01EEA806972F85AD45A6EFD5D78")
    public String toString()
    {
      return (value != 0) ? "TRUE" : "FALSE";
    }
}

