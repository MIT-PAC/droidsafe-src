package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.util.Objects;

public final class DerOutputStream extends BerOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.875 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.875 -0400", hash_original_field = "45A90C37895E078835D56B8AFDCF2071", hash_generated_field = "C52414F914D6B3900289CC94A17C97EF")

    private int[][] len = new int[initSize][];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.875 -0400", hash_original_field = "C41911D1B8E9B3900AF8C1C42380D96C", hash_generated_field = "E2D5A50DFB56B71137A29AB502098A94")

    private Object[][] val = new Object[initSize][];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.875 -0400", hash_original_method = "C2B2568E8FC3DE05B0E3A6791919A3B3", hash_generated_method = "E91B4BFCEE602CDF16A29176E748A164")
    public  DerOutputStream(ASN1Type asn1, Object object) {
        content = object;
        index = -1;
        asn1.setEncodingContent(this);
        encoded = new byte[asn1.getEncodedLength(this)];
        index = 0;
        asn1.encodeASN(this);
        addTaint(asn1.getTaint());
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //content = object;
        //index = -1;
        //asn1.setEncodingContent(this);
        //encoded = new byte[asn1.getEncodedLength(this)];
        //index = 0;
        //asn1.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.876 -0400", hash_original_method = "D1F3147530CD958A60FC9468EBA6E51B", hash_generated_method = "4332F5E6F383DE3E0CFF3C8B576C9769")
    @Override
    public void encodeChoice(ASN1Choice choice) {
        ASN1Type type = (ASN1Type) val[index][0];
        content = val[index][1];
        type.encodeASN(this);
        addTaint(choice.getTaint());
        // ---------- Original Method ----------
        //ASN1Type type = (ASN1Type) val[index][0];
        //content = val[index][1];
        //index++;
        //type.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.876 -0400", hash_original_method = "659D44CC0DC855D6C68F3262E359E7DB", hash_generated_method = "7D23805463CEEF4D9C2B50A59D507B52")
    @Override
    public void encodeExplicit(ASN1Explicit explicit) {
        content = val[index][0];
        length = len[index][0];
        explicit.type.encodeASN(this);
        addTaint(explicit.getTaint());
        // ---------- Original Method ----------
        //content = val[index][0];
        //length = len[index][0];
        //index++;
        //explicit.type.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.877 -0400", hash_original_method = "DFC8E4A859D25CD29437C3A3C9B5952F", hash_generated_method = "BE44F2CDEC195A2839F5A8CC11B166DA")
    @Override
    public void encodeSequence(ASN1Sequence sequence) {
        ASN1Type[] type = sequence.type;
        Object[] values = val[index];
        int[] compLens = len[index];
        {
            int i = 0;
            {
                content = values[i];
                length = compLens[i];
                type[i].encodeASN(this);
            } //End block
        } //End collapsed parenthetic
        addTaint(sequence.getTaint());
        // ---------- Original Method ----------
        //ASN1Type[] type = sequence.type;
        //Object[] values = val[index];
        //int[] compLens = len[index];
        //index++;
        //for (int i = 0; i < type.length; i++) {
            //if (values[i] == null) {
                //continue;
            //}
            //content = values[i];
            //length = compLens[i];
            //type[i].encodeASN(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.877 -0400", hash_original_method = "BF7126E0FE9EAA56B88F61BC0650EC8C", hash_generated_method = "5826C7F2CCD0254F55B74A84A80DE538")
    @Override
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        encodeValueCollection(sequenceOf);
        addTaint(sequenceOf.getTaint());
        // ---------- Original Method ----------
        //encodeValueCollection(sequenceOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.878 -0400", hash_original_method = "71BF5F5BDE90DADFEA034715FD60B59D", hash_generated_method = "CF6827D29AC566791559AC6AE47155C5")
    @Override
    public void encodeSetOf(ASN1SetOf setOf) {
        encodeValueCollection(setOf);
        addTaint(setOf.getTaint());
        // ---------- Original Method ----------
        //encodeValueCollection(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.878 -0400", hash_original_method = "633BE494EAD83DB36EAB8BCAACE55EAA", hash_generated_method = "F1D037BB5907A3E797F84C2EED54A0C8")
    private void encodeValueCollection(ASN1ValueCollection collection) {
        Object[] values = val[index];
        int[] compLens = len[index];
        {
            int i = 0;
            {
                content = values[i];
                length = compLens[i];
                collection.type.encodeASN(this);
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //Object[] values = val[index];
        //int[] compLens = len[index];
        //index++;
        //for (int i = 0; i < values.length; i++) {
            //content = values[i];
            //length = compLens[i];
            //collection.type.encodeASN(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.879 -0400", hash_original_method = "4D1A9BCC2A43E189556FAAB3E35CA849", hash_generated_method = "C9C34D76960A40BC2069CEA614CAB7FD")
    private void push(int[] lengths, Object[] values) {
        {
            int[][] newLen = new int[val.length * 2][];
            System.arraycopy(len, 0, newLen, 0, val.length);
            len = newLen;
            Object[][] newVal = new Object[val.length * 2][];
            System.arraycopy(val, 0, newVal, 0, val.length);
            val = newVal;
        } //End block
        len[index] = lengths;
        val[index] = values;
        // ---------- Original Method ----------
        //index++;
        //if (index == val.length) {
            //int[][] newLen = new int[val.length * 2][];
            //System.arraycopy(len, 0, newLen, 0, val.length);
            //len = newLen;
            //Object[][] newVal = new Object[val.length * 2][];
            //System.arraycopy(val, 0, newVal, 0, val.length);
            //val = newVal;
        //}
        //len[index] = lengths;
        //val[index] = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.880 -0400", hash_original_method = "5A7B1508F1787808F49F0B5550C8CD51", hash_generated_method = "DE95F9EF11DCEB6C32E5870602A14A73")
    @Override
    public void getChoiceLength(ASN1Choice choice) {
        int i = choice.getIndex(content);
        content = choice.getObjectToEncode(content);
        Object[] values = new Object[] { choice.type[i], content };
        push(null, values);
        choice.type[i].setEncodingContent(this);
        values[1] = content;
        addTaint(choice.getTaint());
        // ---------- Original Method ----------
        //int i = choice.getIndex(content);
        //content = choice.getObjectToEncode(content);
        //Object[] values = new Object[] { choice.type[i], content };
        //push(null, values);
        //choice.type[i].setEncodingContent(this);
        //values[1] = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.880 -0400", hash_original_method = "3844D47826105180913F54E31B3EFD0D", hash_generated_method = "A90EB8CEB44AFE5F4550262FFFE26066")
    @Override
    public void getExplicitLength(ASN1Explicit explicit) {
        Object[] values = new Object[1];
        int[] compLens = new int[1];
        values[0] = content;
        push(compLens, values);
        explicit.type.setEncodingContent(this);
        values[0] = content;
        compLens[0] = length;
        length = explicit.type.getEncodedLength(this);
        addTaint(explicit.getTaint());
        // ---------- Original Method ----------
        //Object[] values = new Object[1];
        //int[] compLens = new int[1];
        //values[0] = content;
        //push(compLens, values);
        //explicit.type.setEncodingContent(this);
        //values[0] = content;
        //compLens[0] = length;
        //length = explicit.type.getEncodedLength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.881 -0400", hash_original_method = "987D6B9FDB5F0819C8D50266B95DAA65", hash_generated_method = "D52C5836DAFEA11BF997A4A7DEFC96F7")
    @Override
    public void getSequenceLength(ASN1Sequence sequence) {
        ASN1Type[] type = sequence.type;
        Object[] values = new Object[type.length];
        int[] compLens = new int[type.length];
        sequence.getValues(content, values);
        push(compLens, values);
        int seqLen = 0;
        {
            int i = 0;
            {
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
                    } //End block
                } //End block
                {
                    boolean var6B38A6F8D3CEEABFA627682F66C06685_1093640918 = (Objects.equal(sequence.DEFAULT[i], values[i]));
                    {
                        values[i] = null;
                    } //End block
                } //End collapsed parenthetic
                content = values[i];
                type[i].setEncodingContent(this);
                compLens[i] = length;
                values[i] = content;
                seqLen += type[i].getEncodedLength(this);
            } //End block
        } //End collapsed parenthetic
        length = seqLen;
        addTaint(sequence.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.881 -0400", hash_original_method = "61F1CA8B8AAFA23BA003E1AA8F8AE7F2", hash_generated_method = "2E65A6D87E4E46D541B1DB9139AC431C")
    @Override
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        getValueOfLength(sequence);
        addTaint(sequence.getTaint());
        // ---------- Original Method ----------
        //getValueOfLength(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.882 -0400", hash_original_method = "59131DE1B6C7BF8D5BB2AE6524AB4AAF", hash_generated_method = "51513E2E37FF01580F6C6DD9A7CC8D30")
    @Override
    public void getSetOfLength(ASN1SetOf setOf) {
        getValueOfLength(setOf);
        addTaint(setOf.getTaint());
        // ---------- Original Method ----------
        //getValueOfLength(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.882 -0400", hash_original_method = "437F3D994C4DC9FE69A29C0E967F3DCB", hash_generated_method = "40476A50AC5B1DC7A3C5B78A7D1B6BED")
    private void getValueOfLength(ASN1ValueCollection collection) {
        Object[] cv = collection.getValues(content).toArray();
        Object[] values = new Object[cv.length];
        int[] compLens = new int[values.length];
        push(compLens, values);
        int seqLen = 0;
        {
            int i = 0;
            {
                content = cv[i];
                collection.type.setEncodingContent(this);
                compLens[i] = length;
                values[i] = content;
                seqLen += collection.type.getEncodedLength(this);
            } //End block
        } //End collapsed parenthetic
        length = seqLen;
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //Object[] cv = collection.getValues(content).toArray();
        //Object[] values = new Object[cv.length];
        //int[] compLens = new int[values.length];
        //push(compLens, values);
        //int seqLen = 0;
        //for (int i = 0; i < values.length; i++) {
            //content = cv[i];
            //collection.type.setEncodingContent(this);
            //compLens[i] = length;
            //values[i] = content;
            //seqLen += collection.type.getEncodedLength(this);
        //}
        //length = seqLen;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.882 -0400", hash_original_field = "4CC15007CF874E708F8CE8EBA49B547E", hash_generated_field = "3574CD64DD2D9905361B05608C299821")

    private static final int initSize = 32;
}

