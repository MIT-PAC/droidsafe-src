package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.util.Objects;

public final class DerOutputStream extends BerOutputStream {
    private int index;
    private int[][] len = new int[initSize][];
    private Object[][] val = new Object[initSize][];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.113 -0400", hash_original_method = "C2B2568E8FC3DE05B0E3A6791919A3B3", hash_generated_method = "66CE1F7DEEC9846E03A5861F3FA8EB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DerOutputStream(ASN1Type asn1, Object object) {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(asn1.dsTaint);
        content = object;
        index = -1;
        asn1.setEncodingContent(this);
        encoded = new byte[asn1.getEncodedLength(this)];
        index = 0;
        asn1.encodeASN(this);
        // ---------- Original Method ----------
        //content = object;
        //index = -1;
        //asn1.setEncodingContent(this);
        //encoded = new byte[asn1.getEncodedLength(this)];
        //index = 0;
        //asn1.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.114 -0400", hash_original_method = "D1F3147530CD958A60FC9468EBA6E51B", hash_generated_method = "5992DB43DCF62FB90E2533D8D0441AB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeChoice(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        ASN1Type type;
        type = (ASN1Type) val[index][0];
        content = val[index][1];
        type.encodeASN(this);
        // ---------- Original Method ----------
        //ASN1Type type = (ASN1Type) val[index][0];
        //content = val[index][1];
        //index++;
        //type.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.114 -0400", hash_original_method = "659D44CC0DC855D6C68F3262E359E7DB", hash_generated_method = "ED9D08864973982E6D18945679C7C521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeExplicit(ASN1Explicit explicit) {
        dsTaint.addTaint(explicit.dsTaint);
        content = val[index][0];
        length = len[index][0];
        explicit.type.encodeASN(this);
        // ---------- Original Method ----------
        //content = val[index][0];
        //length = len[index][0];
        //index++;
        //explicit.type.encodeASN(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.114 -0400", hash_original_method = "DFC8E4A859D25CD29437C3A3C9B5952F", hash_generated_method = "E7B84AB6F4B0ED64D6A833CAF03815B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeSequence(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        ASN1Type[] type;
        type = sequence.type;
        Object[] values;
        values = val[index];
        int[] compLens;
        compLens = len[index];
        {
            int i;
            i = 0;
            {
                content = values[i];
                length = compLens[i];
                type[i].encodeASN(this);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.114 -0400", hash_original_method = "BF7126E0FE9EAA56B88F61BC0650EC8C", hash_generated_method = "D15C8C5917DFD25E3F5601E9152E6C91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        dsTaint.addTaint(sequenceOf.dsTaint);
        encodeValueCollection(sequenceOf);
        // ---------- Original Method ----------
        //encodeValueCollection(sequenceOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.115 -0400", hash_original_method = "71BF5F5BDE90DADFEA034715FD60B59D", hash_generated_method = "FF298F2DAF35A59004D7729F80884A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeSetOf(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        encodeValueCollection(setOf);
        // ---------- Original Method ----------
        //encodeValueCollection(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.115 -0400", hash_original_method = "633BE494EAD83DB36EAB8BCAACE55EAA", hash_generated_method = "CB2A00572A2A2F2E65E7508614A9A9CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void encodeValueCollection(ASN1ValueCollection collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] values;
        values = val[index];
        int[] compLens;
        compLens = len[index];
        {
            int i;
            i = 0;
            {
                content = values[i];
                length = compLens[i];
                collection.type.encodeASN(this);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.115 -0400", hash_original_method = "4D1A9BCC2A43E189556FAAB3E35CA849", hash_generated_method = "753084752F1B9E3C7F0A454DE5BD34BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void push(int[] lengths, Object[] values) {
        dsTaint.addTaint(values[0].dsTaint);
        dsTaint.addTaint(lengths[0]);
        {
            int[][] newLen;
            newLen = new int[val.length * 2][];
            System.arraycopy(len, 0, newLen, 0, val.length);
            len = newLen;
            Object[][] newVal;
            newVal = new Object[val.length * 2][];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.116 -0400", hash_original_method = "5A7B1508F1787808F49F0B5550C8CD51", hash_generated_method = "CB80FA139FFCEE60BD1C7EE03143230F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getChoiceLength(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        int i;
        i = choice.getIndex(content);
        content = choice.getObjectToEncode(content);
        Object[] values;
        values = new Object[] { choice.type[i], content };
        push(null, values);
        choice.type[i].setEncodingContent(this);
        values[1] = content;
        // ---------- Original Method ----------
        //int i = choice.getIndex(content);
        //content = choice.getObjectToEncode(content);
        //Object[] values = new Object[] { choice.type[i], content };
        //push(null, values);
        //choice.type[i].setEncodingContent(this);
        //values[1] = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.116 -0400", hash_original_method = "3844D47826105180913F54E31B3EFD0D", hash_generated_method = "D5DB879876B16DCE291920AB7A4080EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getExplicitLength(ASN1Explicit explicit) {
        dsTaint.addTaint(explicit.dsTaint);
        Object[] values;
        values = new Object[1];
        int[] compLens;
        compLens = new int[1];
        values[0] = content;
        push(compLens, values);
        explicit.type.setEncodingContent(this);
        values[0] = content;
        compLens[0] = length;
        length = explicit.type.getEncodedLength(this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.116 -0400", hash_original_method = "987D6B9FDB5F0819C8D50266B95DAA65", hash_generated_method = "792796B9D79E98D483799D5A1AB5A6E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getSequenceLength(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        ASN1Type[] type;
        type = sequence.type;
        Object[] values;
        values = new Object[type.length];
        int[] compLens;
        compLens = new int[type.length];
        sequence.getValues(content, values);
        push(compLens, values);
        int seqLen;
        seqLen = 0;
        {
            int i;
            i = 0;
            {
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
                    } //End block
                } //End block
                {
                    boolean var6B38A6F8D3CEEABFA627682F66C06685_2083027105 = (Objects.equal(sequence.DEFAULT[i], values[i]));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.117 -0400", hash_original_method = "61F1CA8B8AAFA23BA003E1AA8F8AE7F2", hash_generated_method = "135A80E3DC8E6663729940632FA7F382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        getValueOfLength(sequence);
        // ---------- Original Method ----------
        //getValueOfLength(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.117 -0400", hash_original_method = "59131DE1B6C7BF8D5BB2AE6524AB4AAF", hash_generated_method = "58E36841CE0183677C71392FD4EAB871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getSetOfLength(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        getValueOfLength(setOf);
        // ---------- Original Method ----------
        //getValueOfLength(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.117 -0400", hash_original_method = "437F3D994C4DC9FE69A29C0E967F3DCB", hash_generated_method = "6EB9417083F6EF5D0B0D4E344E2E1B60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getValueOfLength(ASN1ValueCollection collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] cv;
        cv = collection.getValues(content).toArray();
        Object[] values;
        values = new Object[cv.length];
        int[] compLens;
        compLens = new int[values.length];
        push(compLens, values);
        int seqLen;
        seqLen = 0;
        {
            int i;
            i = 0;
            {
                content = cv[i];
                collection.type.setEncodingContent(this);
                compLens[i] = length;
                values[i] = content;
                seqLen += collection.type.getEncodedLength(this);
            } //End block
        } //End collapsed parenthetic
        length = seqLen;
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

    
    private static final int initSize = 32;
}

