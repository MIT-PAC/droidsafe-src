package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class ASN1Choice extends ASN1Type {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.777 -0500", hash_original_field = "2C1BBE312A31324DECE23D8C64DF5B3B", hash_generated_field = "24AC453E9AFABA0FC5B4FCBCBDACD1C1")

    public  ASN1Type[] type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.779 -0500", hash_original_field = "B7433448C35E5B5D3B025182ABB7B6A8", hash_generated_field = "1F2CA11DFA4827FAB5EEB375959000C9")

    private  int[][] identifiers;

    /**
     * Constructs ASN.1 choice type.
     *
     * @param type -
     *            an array of one or more ASN.1 type alternatives.
     * @throws IllegalArgumentException -
     *             type parameter is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.783 -0500", hash_original_method = "C70F669111768591EE425211051DE956", hash_generated_method = "ECB540C395F0B3C523C66CC19489F4DE")
    
public ASN1Choice(ASN1Type[] type) {
        super(TAG_CHOICE); // has not tag number

        if (type.length == 0) {
            throw new IllegalArgumentException("ASN.1 choice type MUST have at least one alternative: " + getClass().getName());
        }

        // create map of all identifiers
        TreeMap<BigInteger, BigInteger> map = new TreeMap<BigInteger, BigInteger>();
        for (int index = 0; index < type.length; index++) {
            ASN1Type t = type[index];

            if (t instanceof ASN1Any) {
                // ASN.1 ANY is not allowed,
                // even it is a single component (not good for nested choices)
                throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName()); // FIXME name
            } else if (t instanceof ASN1Choice) {

                // add all choice's identifiers
                int[][] choiceToAdd = ((ASN1Choice) t).identifiers;
                for (int j = 0; j < choiceToAdd[0].length; j++) {
                    addIdentifier(map, choiceToAdd[0][j], index);
                }
                continue;
            }

            // add primitive identifier
            if (t.checkTag(t.id)) {
                addIdentifier(map, t.id, index);
            }

            // add constructed identifier
            if (t.checkTag(t.constrId)) {
                addIdentifier(map, t.constrId, index);
            }
        }

        // fill identifiers array
        int size = map.size();
        identifiers = new int[2][size];
        Iterator<Map.Entry<BigInteger, BigInteger>> it = map.entrySet().iterator();

        for (int i = 0; i < size; i++) {
            Map.Entry<BigInteger, BigInteger> entry = it.next();
            BigInteger identifier = entry.getKey();

            identifiers[0][i] = identifier.intValue();
            identifiers[1][i] = entry.getValue().intValue();
        }

        this.type = type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.785 -0500", hash_original_method = "781B2DE1C4956E14672C3431AF37B058", hash_generated_method = "DE4CA369F5857922E33DE14832CEE4A3")
    
private void addIdentifier(TreeMap<BigInteger, BigInteger> map, int identifier, int index){
        if (map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null) {
            throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    + "with distinct tags: " + getClass().getName());
        }
    }

    /**
     * Tests whether one of choice alternatives has the same identifier or not.
     *
     * @param identifier -
     *            ASN.1 identifier to be verified
     * @return - true if one of choice alternatives has the same identifier,
     *         otherwise false;
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.788 -0500", hash_original_method = "0D992D1A6B83EB18D65339F632B428D0", hash_generated_method = "1063C4C71B734E5825245F9683A30BB8")
    
public final boolean checkTag(int identifier) {
        return Arrays.binarySearch(identifiers[0], identifier) >= 0;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.790 -0500", hash_original_method = "CA43C2DB32698BB605AF1C7E4ECA1770", hash_generated_method = "75C78604FD7AD7879D8553AE9485C9D6")
    
public Object decode(BerInputStream in) throws IOException {
        int index = Arrays.binarySearch(identifiers[0], in.tag);
        if (index < 0) {
            throw new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());// FIXME message
        }

        index = identifiers[1][index];

        in.content = type[index].decode(in);

        // set index for getDecodedObject method
        in.choiceIndex = index;

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.792 -0500", hash_original_method = "C4E40B33E0FA7E203CD41695E7BB47C7", hash_generated_method = "ECC93E82640E3FFE8DBC8D014BC8B6D7")
    
public void encodeASN(BerOutputStream out) {
        encodeContent(out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.795 -0500", hash_original_method = "2AF14DF9816B381764BA8B204B1F7CEE", hash_generated_method = "8A9AD7B308A0AB119CE2D485EC4C2431")
    
public final void encodeContent(BerOutputStream out) {
        out.encodeChoice(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.797 -0500", hash_original_method = "42587D0F9A46971376C939ACA9930C2B", hash_generated_method = "9AD640E17D6E104A27C06EA877BD78B6")
    
public abstract int getIndex(Object object);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.799 -0500", hash_original_method = "75E7550C20B95169035A29D8C36DEBAE", hash_generated_method = "8D9E618D747BE46CF5FA8CB7E949B545")
    
public abstract Object getObjectToEncode(Object object);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.801 -0500", hash_original_method = "C699EF204D8C8BCCF80A813C218D94FB", hash_generated_method = "19B55BFCFFF920DC7496961FFC202211")
    
public final void setEncodingContent(BerOutputStream out) {
        out.getChoiceLength(this);
    }
    
}

