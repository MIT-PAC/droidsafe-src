package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    private ObjectStreamClass streamClass;
    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.532 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "B149867B0DB747939D8E78851BDFD518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        dsTaint.addTaint(streamClass.dsTaint);
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        // ---------- Original Method ----------
        //this.streamClass = streamClass;
        //emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.532 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "E2500C7FFF42597D72D562CF89B27508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        boolean var2D8F5507C12052930B02EE0D95FEAF56_860147979 = (emulatedFields.defaulted(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return emulatedFields.defaulted(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.533 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "CFF77A1749457DBBC5DF1892912F9699")
    @DSModeled(DSC.SAFE)
     EmulatedFields emulatedFields() {
        return (EmulatedFields)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.534 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "FDEAF4379596DF3314B5C79DBD49E715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        byte varC489F1A2DC32293B9EACB999DD2BEC9A_153652781 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.534 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "F85599E2EE71EBFB97BD583F7891B40D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        char varC489F1A2DC32293B9EACB999DD2BEC9A_193120861 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.535 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "F25DFD4A5A4E96FF641873ABA9924D6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        double varC489F1A2DC32293B9EACB999DD2BEC9A_2028161711 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.535 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "B55622FD540F031E13F18EF1BB503FB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        float varC489F1A2DC32293B9EACB999DD2BEC9A_494722958 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.535 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "372B3223C773BFD6FA9620753B5C393D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        int varC489F1A2DC32293B9EACB999DD2BEC9A_220080203 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.535 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "624B7B21C48D8F5B8D1C23B05B670389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        long varC489F1A2DC32293B9EACB999DD2BEC9A_244596537 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.536 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "AD9A5BE3D105E8753A9540A8A251406E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue.dsTaint);
        Object varC489F1A2DC32293B9EACB999DD2BEC9A_394282744 = (emulatedFields.get(name, defaultValue));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.536 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "CB6D1F34466DB8CFF987349EE8E8852F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        short varC489F1A2DC32293B9EACB999DD2BEC9A_652794352 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.536 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "F6C9ABFB84F1566421EB099B9D7F8296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        boolean varC489F1A2DC32293B9EACB999DD2BEC9A_2018095383 = (emulatedFields.get(name, defaultValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.536 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "AE5CA7B32DDDA2E0D18BC8391CE90BFB")
    @DSModeled(DSC.SAFE)
    @Override
    public ObjectStreamClass getObjectStreamClass() {
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return streamClass;
    }

    
}

