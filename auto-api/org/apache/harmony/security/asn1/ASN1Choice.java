package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class ASN1Choice extends ASN1Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.449 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "24AC453E9AFABA0FC5B4FCBCBDACD1C1")

    public ASN1Type[] type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.449 -0400", hash_original_field = "7C26F6AE97679422063D8D33A8623C57", hash_generated_field = "1F2CA11DFA4827FAB5EEB375959000C9")

    private int[][] identifiers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.450 -0400", hash_original_method = "C70F669111768591EE425211051DE956", hash_generated_method = "F2520B4491EEA36B63C8653568DE0C11")
    public  ASN1Choice(ASN1Type[] type) {
        super(TAG_CHOICE);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have at least one alternative: " + getClass().getName());
        } //End block
        TreeMap<BigInteger, BigInteger> map = new TreeMap<BigInteger, BigInteger>();
        {
            int index = 0;
            {
                ASN1Type t = type[index];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName());
                } //End block
                {
                    int[][] choiceToAdd = ((ASN1Choice) t).identifiers;
                    {
                        int j = 0;
                        {
                            addIdentifier(map, choiceToAdd[0][j], index);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varA8AA83764D0DD0DE889731A129D16D4D_776262446 = (t.checkTag(t.id));
                    {
                        addIdentifier(map, t.id, index);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var279EE3948D10B7047F50E4CB941EA1D7_2036321136 = (t.checkTag(t.constrId));
                    {
                        addIdentifier(map, t.constrId, index);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int size = map.size();
        identifiers = new int[2][size];
        Iterator<Map.Entry<BigInteger, BigInteger>> it = map.entrySet().iterator();
        {
            int i = 0;
            {
                Map.Entry<BigInteger, BigInteger> entry = it.next();
                BigInteger identifier = entry.getKey();
                identifiers[0][i] = identifier.intValue();
                identifiers[1][i] = entry.getValue().intValue();
            } //End block
        } //End collapsed parenthetic
        this.type = type;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.450 -0400", hash_original_method = "781B2DE1C4956E14672C3431AF37B058", hash_generated_method = "91ECCE3714C8D92F3E0F1AEC9E6A8858")
    private void addIdentifier(TreeMap<BigInteger, BigInteger> map, int identifier, int index) {
        {
            boolean var4778BC0ECAC2BF6471BF7B45A50CC4D3_1231620345 = (map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    + "with distinct tags: " + getClass().getName());
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        addTaint(identifier);
        addTaint(index);
        // ---------- Original Method ----------
        //if (map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null) {
            //throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    //+ "with distinct tags: " + getClass().getName());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.450 -0400", hash_original_method = "0D992D1A6B83EB18D65339F632B428D0", hash_generated_method = "C9295A7015E5CCF1D55233753B8A29F4")
    public final boolean checkTag(int identifier) {
        boolean var5EADA63A699424FBB2903D9673FA2514_379629885 = (Arrays.binarySearch(identifiers[0], identifier) >= 0);
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252866333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252866333;
        // ---------- Original Method ----------
        //return Arrays.binarySearch(identifiers[0], identifier) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.452 -0400", hash_original_method = "CA43C2DB32698BB605AF1C7E4ECA1770", hash_generated_method = "530E99B028EB7F3272027BACFC43A2B8")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_111426286 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1770685952 = null; //Variable for return #2
        int index = Arrays.binarySearch(identifiers[0], in.tag);
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());
        } //End block
        index = identifiers[1][index];
        in.content = type[index].decode(in);
        in.choiceIndex = index;
        {
            varB4EAC82CA7396A68D541C85D26508E83_111426286 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1770685952 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1695187923; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1695187923 = varB4EAC82CA7396A68D541C85D26508E83_111426286;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1695187923 = varB4EAC82CA7396A68D541C85D26508E83_1770685952;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1695187923.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1695187923;
        // ---------- Original Method ----------
        //int index = Arrays.binarySearch(identifiers[0], in.tag);
        //if (index < 0) {
            //throw new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());
        //}
        //index = identifiers[1][index];
        //in.content = type[index].decode(in);
        //in.choiceIndex = index;
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.452 -0400", hash_original_method = "C4E40B33E0FA7E203CD41695E7BB47C7", hash_generated_method = "4A256913D26E38A82CFC8964258335BD")
    public void encodeASN(BerOutputStream out) {
        encodeContent(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.453 -0400", hash_original_method = "2AF14DF9816B381764BA8B204B1F7CEE", hash_generated_method = "68823089CA394368911C87A5311A68D1")
    public final void encodeContent(BerOutputStream out) {
        out.encodeChoice(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeChoice(this);
    }

    
    public abstract int getIndex(Object object);

    
    public abstract Object getObjectToEncode(Object object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.454 -0400", hash_original_method = "C699EF204D8C8BCCF80A813C218D94FB", hash_generated_method = "6259E34FABBB4F0352FB23495EA31458")
    public final void setEncodingContent(BerOutputStream out) {
        out.getChoiceLength(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.getChoiceLength(this);
    }

    
}

