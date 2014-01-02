package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

import org.apache.http.util.CharArrayBuffer;






public class ProtocolVersion implements Serializable, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.439 -0500", hash_original_field = "5E85D215BFAA18FC64FC27988D1D0AFA", hash_generated_field = "2E5C9D3BADDF86EB2D1874D5612C1631")


    private static final long serialVersionUID = 8950662842175091068L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.441 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected  String protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.443 -0500", hash_original_field = "3429B9B927DA5BA7A29A4446ED4AE1AD", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected  int major;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.446 -0500", hash_original_field = "D7BC9E20147A52C3B5DEF2B2E1296DB1", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected  int minor;

    
    /**
     * Create a protocol version designator.
     *
     * @param protocol   the name of the protocol, for example "HTTP"
     * @param major      the major version number of the protocol
     * @param minor      the minor version number of the protocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.448 -0500", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "F77686E53CB4E6C7B22C14E4E0BD743D")
    
public ProtocolVersion(String protocol, int major, int minor) {
        if (protocol == null) {
            throw new IllegalArgumentException
                ("Protocol name must not be null.");
        }
        if (major < 0) {
            throw new IllegalArgumentException
                ("Protocol major version number must not be negative.");
        }
        if (minor < 0) {
            throw new IllegalArgumentException
                ("Protocol minor version number may not be negative");
        }
        this.protocol = protocol;
        this.major = major;
        this.minor = minor;
    }

    /**
     * Returns the name of the protocol.
     * 
     * @return the protocol name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.451 -0500", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "4DF996DD4ED6E38DFDC56EAB9AE5D939")
    
public final String getProtocol() {
        return protocol;
    }

    /**
     * Returns the major version number of the protocol.
     * 
     * @return the major version number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.453 -0500", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "08886D75F019C3803FA9A61CFB99DF38")
    
public final int getMajor() {
        return major;
    }

    /**
     * Returns the minor version number of the HTTP protocol.
     * 
     * @return the minor version number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.456 -0500", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "CAC469D5D6AF87D1E5BC56D62AE1D0E5")
    
public final int getMinor() {
        return minor;
    }


    /**
     * Obtains a specific version of this protocol.
     * This can be used by derived classes to instantiate themselves instead
     * of the base class, and to define constants for commonly used versions.
     * <br/>
     * The default implementation in this class returns <code>this</code>
     * if the version matches, and creates a new {@link ProtocolVersion}
     * otherwise.
     *
     * @param major     the major version
     * @param minor     the minor version
     *
     * @return  a protocol version with the same protocol name
     *          and the argument version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.458 -0500", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "F8521B05C219D3B88DC4641B9F7617C2")
    
public ProtocolVersion forVersion(int major, int minor) {

        if ((major == this.major) && (minor == this.minor)) {
            return this;
        }

        // argument checking is done in the constructor
        return new ProtocolVersion(this.protocol, major, minor);
    }


    /**
     * Obtains a hash code consistent with {@link #equals}.
     *
     * @return  the hashcode of this protocol version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.460 -0500", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "AC0473F27DD69A23C193144C2851A18A")
    
public final int hashCode() {
        return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

        
    /**
     * Checks equality of this protocol version with an object.
     * The object is equal if it is a protocl version with the same
     * protocol name, major version number, and minor version number.
     * The specific class of the object is <i>not</i> relevant,
     * instances of derived classes with identical attributes are
     * equal to instances of the base class and vice versa.
     *
     * @param obj       the object to compare with
     *
     * @return  <code>true</code> if the argument is the same protocol version,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.463 -0500", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "7D77327781AF9C48E35C6EC2E191C842")
    
public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolVersion)) {
            return false;
        }
        ProtocolVersion that = (ProtocolVersion) obj;

        return ((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor));
    }


    /**
     * Checks whether this protocol can be compared to another one.
     * Only protocol versions with the same protocol name can be
     * {@link #compareToVersion compared}.
     *
     * @param that      the protocol version to consider
     *
     * @return  <code>true</code> if {@link #compareToVersion compareToVersion}
     *          can be called with the argument, <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.465 -0500", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "6C065B7873D0588BE97286774A896273")
    
public boolean isComparable(ProtocolVersion that) {
        return (that != null) && this.protocol.equals(that.protocol);
    }


    /**
     * Compares this protocol version with another one.
     * Only protocol versions with the same protocol name can be compared.
     * This method does <i>not</i> define a total ordering, as it would be
     * required for {@link java.lang.Comparable}.
     *
     * @param that      the protocl version to compare with
     *  
     * @return   a negative integer, zero, or a positive integer
     *           as this version is less than, equal to, or greater than
     *           the argument version.
     *
     * @throws IllegalArgumentException
     *         if the argument has a different protocol name than this object,
     *         or if the argument is <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.467 -0500", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "BE65ABE5DCEED1091C216F58F742E5C4")
    
public int compareToVersion(ProtocolVersion that) {
        if (that == null) {
            throw new IllegalArgumentException
                ("Protocol version must not be null."); 
        }
        if (!this.protocol.equals(that.protocol)) {
            throw new IllegalArgumentException
                ("Versions for different protocols cannot be compared. " +
                 this + " " + that);
        }

        int delta = getMajor() - that.getMajor();
        if (delta == 0) {
            delta = getMinor() - that.getMinor();
        }
        return delta;
    }


    /**
     * Tests if this protocol version is greater or equal to the given one.
     *
     * @param version   the version against which to check this version
     *
     * @return  <code>true</code> if this protocol version is
     *          {@link #isComparable comparable} to the argument
     *          and {@link #compareToVersion compares} as greater or equal,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.469 -0500", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "F5D0E2CEBBA0D53949FF1561E59A2401")
    
public final boolean greaterEquals(ProtocolVersion version) {
        return isComparable(version) && (compareToVersion(version) >= 0);
    }


    /**
     * Tests if this protocol version is less or equal to the given one.
     *
     * @param version   the version against which to check this version
     *
     * @return  <code>true</code> if this protocol version is
     *          {@link #isComparable comparable} to the argument
     *          and {@link #compareToVersion compares} as less or equal,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.473 -0500", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "BFCB6019F74FF0DB7DAA3F0B6215B3B1")
    
public final boolean lessEquals(ProtocolVersion version) {
        return isComparable(version) && (compareToVersion(version) <= 0);
    }


    /**
     * Converts this protocol version to a string.
     *
     * @return  a protocol version string, like "HTTP/1.1"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.475 -0500", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "4E039E1AE81D078882436CC8AA6BF17D")
    
public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol); 
        buffer.append('/'); 
        buffer.append(Integer.toString(this.major)); 
        buffer.append('.'); 
        buffer.append(Integer.toString(this.minor)); 
        return buffer.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.477 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    
public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

