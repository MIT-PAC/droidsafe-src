package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class PSSParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.827 -0500", hash_original_field = "B8CD3B9F05B91977BFC2524DB8A32887", hash_generated_field = "D0AAC5950354538CCC2B6FA63F8FA841")

    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.830 -0500", hash_original_field = "36F5394EE7368CDCE5DDD4FB3FFC034E", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private  String mdName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.832 -0500", hash_original_field = "3DD6356F2F0307DD01152DB75FA8F37F", hash_generated_field = "7037C1B56C4829059706BDC8C763F05D")

    private  String mgfName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.834 -0500", hash_original_field = "C46E9702C9F13DA823F1655075E5F230", hash_generated_field = "54888600845BA61DA06DAEAE4F3D1B9B")

    private  AlgorithmParameterSpec mgfSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.837 -0500", hash_original_field = "D520D66E66AC488076497DB103C3B286", hash_generated_field = "0F7BFD027DD96EC08A17C4071735F2F7")

    private  int trailerField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.840 -0500", hash_original_field = "DE6607255F288BE2551AD688C9D6A0B9", hash_generated_field = "9F16D70DF9DD07F0831E6FA13D5B763E")

    private  int saltLen;

    /**
     * Creates a new {@code PSSParameterSpec} with the specified salt length
     * and the default values.
     *
     * @param saltLen
     *            the salt length (in bits).
     * @throws IllegalArgumentException
     *             if {@code saltLen} is negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.843 -0500", hash_original_method = "DF0A0B659FB6696FF8FDF8F1667A2EB8", hash_generated_method = "34EC30FCAF837AC19AC69A6AE03110CE")
    
public PSSParameterSpec(int saltLen) {
        if (saltLen < 0) {
            throw new IllegalArgumentException("saltLen < 0");
        }
        this.saltLen = saltLen;
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.trailerField = 1;
    }

    /**
     * Creates a new {@code PSSParameterSpec} with the specified message digest
     * name, mask generation function name, mask generation function parameters,
     * salt length, and trailer field value.
     *
     * @param mdName
     *            the name of the message digest algorithm.
     * @param mgfName
     *            the name of the mask generation function algorithm.
     * @param mgfSpec
     *            the parameter for the mask generation function algorithm.
     * @param saltLen
     *            the salt length (in bits).
     * @param trailerField
     *            the trailer field value.
     * @throws IllegalArgumentException
     *             if {@code saltLen} or {@code trailerField} is negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.846 -0500", hash_original_method = "2EEF33BA597A16DAC82E184329E7377A", hash_generated_method = "78D2D1B870956F103AC6A1EE3FCCBA65")
    
public PSSParameterSpec(String mdName, String mgfName,
            AlgorithmParameterSpec mgfSpec, int saltLen, int trailerField) {

        if (mdName == null) {
            throw new NullPointerException("mdName == null");
        }
        if (mgfName == null) {
            throw new NullPointerException("mgfName == null");
        }
        if (saltLen < 0) {
            throw new IllegalArgumentException("saltLen < 0");
        }
        if (trailerField < 0) {
            throw new IllegalArgumentException("trailerField < 0");
        }
        this.mdName = mdName;
        this.mgfName = mgfName;
        this.mgfSpec = mgfSpec;
        this.saltLen = saltLen;
        this.trailerField = trailerField;
    }

    /**
     * Returns the length of the salt (in bits).
     *
     * @return the length of the salt (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.849 -0500", hash_original_method = "B164C3A01C2D5FB8FE5C16711A461B38", hash_generated_method = "9381B8CFB8FCC4E39FD3A885FA8D0AD3")
    
public int getSaltLength() {
        return saltLen;
    }

    /**
     * Returns the name of the message digest algorithm.
     *
     * @return the name of the message digest algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.851 -0500", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "A1EBACCC408717497D9132DBD26B9843")
    
public String getDigestAlgorithm() {
        return mdName;
    }

    /**
     * Returns the name of the mask generation function algorithm.
     *
     * @return the name of the mask generation function algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.853 -0500", hash_original_method = "11682E81B271E60CD76F4E3CFB1D831D", hash_generated_method = "63D7F42B4F9554E56638CEECA5106E0A")
    
public String getMGFAlgorithm() {
        return mgfName;
    }

    /**
     * Returns the parameter for the mask generation function algorithm.
     *
     * @return the parameter for the mask generation function algorithm, or
     *         {@code null} if none specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.856 -0500", hash_original_method = "79BC41FB5304035884EA00639B685A6D", hash_generated_method = "CA25C4BCA40D04E5E4B77A9C7A5D62BB")
    
public AlgorithmParameterSpec getMGFParameters() {
        return mgfSpec;
    }

    /**
     * Returns the trailer field value.
     *
     * @return the trailer field value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.858 -0500", hash_original_method = "61A230854EAEDDEEB7E5A3E90232200C", hash_generated_method = "C48F1ED809EAC3BA584F2A6D91F24FAD")
    
public int getTrailerField() {
        return trailerField;
    }
}

