package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.util.Objects;





public final class DerOutputStream extends BerOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.647 -0500", hash_original_field = "4040ED93930BBA179721E1277AF68B0B", hash_generated_field = "3574CD64DD2D9905361B05608C299821")

    private static final int initSize = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.648 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.649 -0500", hash_original_field = "12ABB8B44246D32AB98C2D52D1F73E4E", hash_generated_field = "C52414F914D6B3900289CC94A17C97EF")

    private int[][] len = new int[initSize][];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.650 -0500", hash_original_field = "EFF538056D0DE2BE1A9E60AF152BFB2D", hash_generated_field = "E2D5A50DFB56B71137A29AB502098A94")

    private Object[][] val = new Object[initSize][];

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.651 -0500", hash_original_method = "C2B2568E8FC3DE05B0E3A6791919A3B3", hash_generated_method = "D2133BB2AA64CD3D00C5E00CBFB27DFF")
    public DerOutputStream(ASN1Type asn1, Object object) {
        content = object;
        index = -1;
        asn1.setEncodingContent(this);
        encoded = new byte[asn1.getEncodedLength(this)];
        index = 0;
        asn1.encodeASN(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.652 -0500", hash_original_method = "D1F3147530CD958A60FC9468EBA6E51B", hash_generated_method = "AB9ABB496939671DC9DE2C9DC7E76DF2")
    @Override
public void encodeChoice(ASN1Choice choice) {
        ASN1Type type = (ASN1Type) val[index][0];
        content = val[index][1];
        index++;
        type.encodeASN(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.652 -0500", hash_original_method = "659D44CC0DC855D6C68F3262E359E7DB", hash_generated_method = "1385F097B611283D03C7FBA68A5DA4F1")
    @Override
public void encodeExplicit(ASN1Explicit explicit) {
        content = val[index][0];
        length = len[index][0];
        index++;
        explicit.type.encodeASN(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.653 -0500", hash_original_method = "DFC8E4A859D25CD29437C3A3C9B5952F", hash_generated_method = "9FF5DD9313208260C0730E05F6AF88E2")
    @Override
public void encodeSequence(ASN1Sequence sequence) {
        ASN1Type[] type = sequence.type;

        Object[] values = val[index];
        int[] compLens = len[index];

        index++;
        for (int i = 0; i < type.length; i++) {
            if (values[i] == null) {
                continue;
            }

            content = values[i];
            length = compLens[i];

            type[i].encodeASN(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.654 -0500", hash_original_method = "BF7126E0FE9EAA56B88F61BC0650EC8C", hash_generated_method = "B672B51C4A7014DA93FAC231BA993305")
    @Override
public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        encodeValueCollection(sequenceOf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.655 -0500", hash_original_method = "71BF5F5BDE90DADFEA034715FD60B59D", hash_generated_method = "10B3FDE0856C1B3352A4A35FC625EC43")
    @Override
public void encodeSetOf(ASN1SetOf setOf) {
        encodeValueCollection(setOf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.656 -0500", hash_original_method = "633BE494EAD83DB36EAB8BCAACE55EAA", hash_generated_method = "0635FDBF3C9EA0669DAFF7D858CBF1D2")
    private void encodeValueCollection(ASN1ValueCollection collection) {
        Object[] values = val[index];
        int[] compLens = len[index];

        index++;
        for (int i = 0; i < values.length; i++) {
            content = values[i];
            length = compLens[i];
            collection.type.encodeASN(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.657 -0500", hash_original_method = "4D1A9BCC2A43E189556FAAB3E35CA849", hash_generated_method = "9106C537F4B903FF67B0CC3E2EFA6503")
    private void push(int[] lengths, Object[] values) {
        index++;
        if (index == val.length) {

            int[][] newLen = new int[val.length * 2][];
            System.arraycopy(len, 0, newLen, 0, val.length);
            len = newLen;

            Object[][] newVal = new Object[val.length * 2][];
            System.arraycopy(val, 0, newVal, 0, val.length);
            val = newVal;
        }
        len[index] = lengths;
        val[index] = values;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.658 -0500", hash_original_method = "5A7B1508F1787808F49F0B5550C8CD51", hash_generated_method = "1C38B260C8232A958C4CC6032851C2DD")
    @Override
public void getChoiceLength(ASN1Choice choice) {
        int i = choice.getIndex(content);
        content = choice.getObjectToEncode(content);

        Object[] values = new Object[] { choice.type[i], content };

        push(null, values);

        choice.type[i].setEncodingContent(this);

        // in case if we get content bytes while getting its length
        // FIXME what about remove it: need redesign
        values[1] = content;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.661 -0500", hash_original_method = "3844D47826105180913F54E31B3EFD0D", hash_generated_method = "EE2CEE435746CB009BE5899F7095528C")
    @Override
public void getExplicitLength(ASN1Explicit explicit) {
        Object[] values = new Object[1];
        int[] compLens = new int[1];

        values[0] = content;

        push(compLens, values);

        explicit.type.setEncodingContent(this);

        // in case if we get content bytes while getting its length
        // FIXME what about remove it: need redesign
        values[0] = content;
        compLens[0] = length;

        length = explicit.type.getEncodedLength(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.662 -0500", hash_original_method = "987D6B9FDB5F0819C8D50266B95DAA65", hash_generated_method = "EC0860E561A3870FC980ED690999C0B6")
    @Override
public void getSequenceLength(ASN1Sequence sequence) {
        ASN1Type[] type = sequence.type;

        Object[] values = new Object[type.length];
        int[] compLens = new int[type.length];

        sequence.getValues(content, values);

        push(compLens, values);

        int seqLen = 0;
        for (int i = 0; i < type.length; i++) {
            // check optional types
            if (values[i] == null) {
                if (sequence.OPTIONAL[i]) {
                    continue;
                } else {
                    throw new RuntimeException();//FIXME type & message
                }
            }

            if (Objects.equal(sequence.DEFAULT[i], values[i])) {
                values[i] = null;
                continue;
            }

            content = values[i];

            type[i].setEncodingContent(this);

            compLens[i] = length;

            // in case if we get content bytes while getting its length
            // FIXME what about remove it: need redesign
            values[i] = content;

            seqLen += type[i].getEncodedLength(this);
        }
        length = seqLen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.663 -0500", hash_original_method = "61F1CA8B8AAFA23BA003E1AA8F8AE7F2", hash_generated_method = "7DB5FEE80C0A3684A7A5CDC5E36A4990")
    @Override
public void getSequenceOfLength(ASN1SequenceOf sequence) {
        getValueOfLength(sequence);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.663 -0500", hash_original_method = "59131DE1B6C7BF8D5BB2AE6524AB4AAF", hash_generated_method = "AC61C0477D9F869B4268923BC4E28C6B")
    @Override
public void getSetOfLength(ASN1SetOf setOf) {
        getValueOfLength(setOf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.664 -0500", hash_original_method = "437F3D994C4DC9FE69A29C0E967F3DCB", hash_generated_method = "32A905DF7A346AE1580B2436FA99C48F")
    private void getValueOfLength(ASN1ValueCollection collection) {
        //FIXME what about another way?
        Object[] cv = collection.getValues(content).toArray();

        Object[] values = new Object[cv.length];
        int[] compLens = new int[values.length];

        push(compLens, values);
        int seqLen = 0;
        for (int i = 0; i < values.length; i++) {

            content = cv[i];

            collection.type.setEncodingContent(this);

            compLens[i] = length;

            // in case if we get content bytes while getting its length
            // FIXME what about remove it: need redesign
            values[i] = content;

            seqLen += collection.type.getEncodedLength(this);
        }
        length = seqLen;
    }
}

