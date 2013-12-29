package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class MGF1ParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.148 -0500", hash_original_field = "10CE8F1F78EDD7BBF72F597BEC146B49", hash_generated_field = "BFB08E237C9505534F2E92030BD73DDC")

    public static final MGF1ParameterSpec SHA1 =
        new MGF1ParameterSpec("SHA-1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.149 -0500", hash_original_field = "D83E0430D2B1F4F76482FAA2D9560617", hash_generated_field = "D057F24800CD8427CC225CA34AE84819")

    public static final MGF1ParameterSpec SHA256 =
        new MGF1ParameterSpec("SHA-256");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.150 -0500", hash_original_field = "CC398323760BDE9571DEA23A4CEF4B4E", hash_generated_field = "5A063E49D9C9031786762780E1DD8C95")

    public static final MGF1ParameterSpec SHA384 =
        new MGF1ParameterSpec("SHA-384");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.151 -0500", hash_original_field = "53DF5BA7EE7819B3490F868CBB87548D", hash_generated_field = "5C7C155C8D3D2252E2FDF04D3F5A55B9")

    public static final MGF1ParameterSpec SHA512 =
        new MGF1ParameterSpec("SHA-512");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.152 -0500", hash_original_field = "36F5394EE7368CDCE5DDD4FB3FFC034E", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private  String mdName;

    /**
     * Creates a new {@code MGF1ParameterSpec} with the specified message digest
     * algorithm name.
     *
     * @param mdName
     *            the name of the message digest algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.153 -0500", hash_original_method = "D3C3EAC31B08596AB735332742664A5B", hash_generated_method = "9083DB44731876B60195ECC253C6D87D")
    public MGF1ParameterSpec(String mdName) {
        this.mdName = mdName;
        if (this.mdName == null) {
            throw new NullPointerException("mdName == null");
        }
    }

    /**
     * Returns the name of the message digest algorithm.
     *
     * @return the name of the message digest algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.154 -0500", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "A1EBACCC408717497D9132DBD26B9843")
    public String getDigestAlgorithm() {
        return mdName;
    }
}

