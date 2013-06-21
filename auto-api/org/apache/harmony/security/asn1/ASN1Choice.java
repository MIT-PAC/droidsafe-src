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
    public ASN1Type[] type;
    private int[][] identifiers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.932 -0400", hash_original_method = "C70F669111768591EE425211051DE956", hash_generated_method = "9442930A5124A6B8BD5A6588664E583B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Choice(ASN1Type[] type) {
        super(TAG_CHOICE);
        dsTaint.addTaint(type[0].dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have at least one alternative: " + getClass().getName());
        } //End block
        TreeMap<BigInteger, BigInteger> map;
        map = new TreeMap<BigInteger, BigInteger>();
        {
            int index;
            index = 0;
            {
                ASN1Type t;
                t = type[index];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName());
                } //End block
                {
                    int[][] choiceToAdd;
                    choiceToAdd = ((ASN1Choice) t).identifiers;
                    {
                        int j;
                        j = 0;
                        {
                            addIdentifier(map, choiceToAdd[0][j], index);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varA8AA83764D0DD0DE889731A129D16D4D_1446467749 = (t.checkTag(t.id));
                    {
                        addIdentifier(map, t.id, index);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var279EE3948D10B7047F50E4CB941EA1D7_1305645889 = (t.checkTag(t.constrId));
                    {
                        addIdentifier(map, t.constrId, index);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int size;
        size = map.size();
        identifiers = new int[2][size];
        Iterator<Map.Entry<BigInteger, BigInteger>> it;
        it = map.entrySet().iterator();
        {
            int i;
            i = 0;
            {
                Map.Entry<BigInteger, BigInteger> entry;
                entry = it.next();
                BigInteger identifier;
                identifier = entry.getKey();
                identifiers[0][i] = identifier.intValue();
                identifiers[1][i] = entry.getValue().intValue();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.932 -0400", hash_original_method = "781B2DE1C4956E14672C3431AF37B058", hash_generated_method = "59DA9551C7519F52B7B376BE73DBB6EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addIdentifier(TreeMap<BigInteger, BigInteger> map, int identifier, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(map.dsTaint);
        dsTaint.addTaint(identifier);
        {
            boolean var4778BC0ECAC2BF6471BF7B45A50CC4D3_1026576089 = (map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    + "with distinct tags: " + getClass().getName());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null) {
            //throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    //+ "with distinct tags: " + getClass().getName());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.932 -0400", hash_original_method = "0D992D1A6B83EB18D65339F632B428D0", hash_generated_method = "B1B1CF02097D8F528149BF1C7BC99998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        boolean var5EADA63A699424FBB2903D9673FA2514_2001352160 = (Arrays.binarySearch(identifiers[0], identifier) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Arrays.binarySearch(identifiers[0], identifier) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.933 -0400", hash_original_method = "CA43C2DB32698BB605AF1C7E4ECA1770", hash_generated_method = "4DF36EC7A1DB16D9FCE2F9B1A345F644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        int index;
        index = Arrays.binarySearch(identifiers[0], in.tag);
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());
        } //End block
        index = identifiers[1][index];
        in.content = type[index].decode(in);
        in.choiceIndex = index;
        Object var883E4A51D9FE1FCA5622395E00C94DE9_414259159 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.933 -0400", hash_original_method = "C4E40B33E0FA7E203CD41695E7BB47C7", hash_generated_method = "E3435BA3A634E76D6454DF010E930665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        encodeContent(out);
        // ---------- Original Method ----------
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.933 -0400", hash_original_method = "2AF14DF9816B381764BA8B204B1F7CEE", hash_generated_method = "9F6E32BC97F4055674E83BAAA44D1574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeChoice(this);
        // ---------- Original Method ----------
        //out.encodeChoice(this);
    }

    
    public abstract int getIndex(Object object);

    
    public abstract Object getObjectToEncode(Object object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.934 -0400", hash_original_method = "C699EF204D8C8BCCF80A813C218D94FB", hash_generated_method = "61B0A8BC35557C1A49706F8E171C21DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getChoiceLength(this);
        // ---------- Original Method ----------
        //out.getChoiceLength(this);
    }

    
}

