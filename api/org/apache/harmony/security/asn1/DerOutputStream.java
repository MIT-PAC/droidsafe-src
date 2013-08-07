package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.util.Objects;





public final class DerOutputStream extends BerOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_field = "45A90C37895E078835D56B8AFDCF2071", hash_generated_field = "C52414F914D6B3900289CC94A17C97EF")

    private int[][] len = new int[initSize][];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_field = "C41911D1B8E9B3900AF8C1C42380D96C", hash_generated_field = "E2D5A50DFB56B71137A29AB502098A94")

    private Object[][] val = new Object[initSize][];
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_method = "C2B2568E8FC3DE05B0E3A6791919A3B3", hash_generated_method = "DD97B51F13357288F097F2DBE10163B9")
    public  DerOutputStream(ASN1Type asn1, Object object) {
        addTaint(object.getTaint());
        addTaint(asn1.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_method = "D1F3147530CD958A60FC9468EBA6E51B", hash_generated_method = "057BAFA8F7674F33D82362BD074FB9B5")
    @Override
    public void encodeChoice(ASN1Choice choice) {
        addTaint(choice.getTaint());
        ASN1Type type = (ASN1Type) val[index][0];
        content = val[index][1];
        index++;
        type.encodeASN(this);
        // ---------- Original Method ----------
        //ASN1Type type = (ASN1Type) val[index][0];
        //content = val[index][1];
        //index++;
        //type.encodeASN(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.920 -0400", hash_original_method = "659D44CC0DC855D6C68F3262E359E7DB", hash_generated_method = "316F7A823F3543AAEDA49A53DBE3685F")
    @Override
    public void encodeExplicit(ASN1Explicit explicit) {
        addTaint(explicit.getTaint());
        content = val[index][0];
        length = len[index][0];
        index++;
        explicit.type.encodeASN(this);
        // ---------- Original Method ----------
        //content = val[index][0];
        //length = len[index][0];
        //index++;
        //explicit.type.encodeASN(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.921 -0400", hash_original_method = "DFC8E4A859D25CD29437C3A3C9B5952F", hash_generated_method = "49813B4A8F80CD85A5AC3B0984F82F24")
    @Override
    public void encodeSequence(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        ASN1Type[] type = sequence.type;
        Object[] values = val[index];
        int[] compLens = len[index];
        index++;
for(int i = 0;i < type.length;i++)
        {
            if(values[i] == null)            
            {
                continue;
            } //End block
            content = values[i];
            length = compLens[i];
            type[i].encodeASN(this);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.921 -0400", hash_original_method = "BF7126E0FE9EAA56B88F61BC0650EC8C", hash_generated_method = "979E147F629ADF383FDE475846DC758A")
    @Override
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        addTaint(sequenceOf.getTaint());
        encodeValueCollection(sequenceOf);
        // ---------- Original Method ----------
        //encodeValueCollection(sequenceOf);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.921 -0400", hash_original_method = "71BF5F5BDE90DADFEA034715FD60B59D", hash_generated_method = "2885DF32A551EC4E1446E5D56C5818AF")
    @Override
    public void encodeSetOf(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        encodeValueCollection(setOf);
        // ---------- Original Method ----------
        //encodeValueCollection(setOf);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.923 -0400", hash_original_method = "633BE494EAD83DB36EAB8BCAACE55EAA", hash_generated_method = "95EA7F631AADF71E3FABCAEF5941F4B0")
    private void encodeValueCollection(ASN1ValueCollection collection) {
        addTaint(collection.getTaint());
        Object[] values = val[index];
        int[] compLens = len[index];
        index++;
for(int i = 0;i < values.length;i++)
        {
            content = values[i];
            length = compLens[i];
            collection.type.encodeASN(this);
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.924 -0400", hash_original_method = "4D1A9BCC2A43E189556FAAB3E35CA849", hash_generated_method = "F1071627A0104779CCFA0A0C19C0D01C")
    private void push(int[] lengths, Object[] values) {
        index++;
        if(index == val.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.925 -0400", hash_original_method = "5A7B1508F1787808F49F0B5550C8CD51", hash_generated_method = "BBAD595CB40DF225A09E8A174D76766D")
    @Override
    public void getChoiceLength(ASN1Choice choice) {
        addTaint(choice.getTaint());
        int i = choice.getIndex(content);
        content = choice.getObjectToEncode(content);
        Object[] values = new Object[] { choice.type[i], content };
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.926 -0400", hash_original_method = "3844D47826105180913F54E31B3EFD0D", hash_generated_method = "E5C6111A046F4D5F52772A46F3E5D5DA")
    @Override
    public void getExplicitLength(ASN1Explicit explicit) {
        addTaint(explicit.getTaint());
        Object[] values = new Object[1];
        int[] compLens = new int[1];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.927 -0400", hash_original_method = "987D6B9FDB5F0819C8D50266B95DAA65", hash_generated_method = "E0DF66864669BD75ECDBA5CC31B7792F")
    @Override
    public void getSequenceLength(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        ASN1Type[] type = sequence.type;
        Object[] values = new Object[type.length];
        int[] compLens = new int[type.length];
        sequence.getValues(content, values);
        push(compLens, values);
        int seqLen = 0;
for(int i = 0;i < type.length;i++)
        {
            if(values[i] == null)            
            {
                if(sequence.OPTIONAL[i])                
                {
                    continue;
                } //End block
                else
                {
                    RuntimeException varF1484B21EF4EE84F790184975238945B_1736933682 = new RuntimeException();
                    varF1484B21EF4EE84F790184975238945B_1736933682.addTaint(taint);
                    throw varF1484B21EF4EE84F790184975238945B_1736933682;
                } //End block
            } //End block
            if(Objects.equal(sequence.DEFAULT[i], values[i]))            
            {
                values[i] = null;
                continue;
            } //End block
            content = values[i];
            type[i].setEncodingContent(this);
            compLens[i] = length;
            values[i] = content;
            seqLen += type[i].getEncodedLength(this);
        } //End block
        length = seqLen;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.927 -0400", hash_original_method = "61F1CA8B8AAFA23BA003E1AA8F8AE7F2", hash_generated_method = "6D3E3BBC23E25F11897075F7BB9361EC")
    @Override
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        addTaint(sequence.getTaint());
        getValueOfLength(sequence);
        // ---------- Original Method ----------
        //getValueOfLength(sequence);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.927 -0400", hash_original_method = "59131DE1B6C7BF8D5BB2AE6524AB4AAF", hash_generated_method = "6D98F2A1A66A3AAFFCB5501C4A781E25")
    @Override
    public void getSetOfLength(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        getValueOfLength(setOf);
        // ---------- Original Method ----------
        //getValueOfLength(setOf);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.927 -0400", hash_original_method = "437F3D994C4DC9FE69A29C0E967F3DCB", hash_generated_method = "BA87351CB696B6E9F6FD3E829CE90F5F")
    private void getValueOfLength(ASN1ValueCollection collection) {
        addTaint(collection.getTaint());
        Object[] cv = collection.getValues(content).toArray();
        Object[] values = new Object[cv.length];
        int[] compLens = new int[values.length];
        push(compLens, values);
        int seqLen = 0;
for(int i = 0;i < values.length;i++)
        {
            content = cv[i];
            collection.type.setEncodingContent(this);
            compLens[i] = length;
            values[i] = content;
            seqLen += collection.type.getEncodedLength(this);
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.927 -0400", hash_original_field = "4CC15007CF874E708F8CE8EBA49B547E", hash_generated_field = "3574CD64DD2D9905361B05608C299821")

    private static final int initSize = 32;
}

