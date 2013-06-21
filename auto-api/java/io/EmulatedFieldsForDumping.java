package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFieldsForDumping extends ObjectOutputStream.PutField {
    private ObjectOutputStream oos;
    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.514 -0400", hash_original_method = "D64C2A148CFECC0338F81243CC161580", hash_generated_method = "A3A47CFB004242B3CF8AA78D55EB4A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     EmulatedFieldsForDumping(ObjectOutputStream oos, ObjectStreamClass streamClass) {
        dsTaint.addTaint(streamClass.dsTaint);
        dsTaint.addTaint(oos.dsTaint);
        this.emulatedFields = new EmulatedFields(streamClass.fields(), (ObjectStreamField[]) null);
        // ---------- Original Method ----------
        //this.oos = oos;
        //this.emulatedFields = new EmulatedFields(streamClass.fields(), (ObjectStreamField[]) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.514 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "CFF77A1749457DBBC5DF1892912F9699")
    @DSModeled(DSC.SAFE)
     EmulatedFields emulatedFields() {
        return (EmulatedFields)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.514 -0400", hash_original_method = "BEEEBC5D4806AB4D59848CAB89CBF72F", hash_generated_method = "486D62A080E05819D600D464D52E0A30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, byte value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "19C83E4EF6515D56E4873B39EA152436", hash_generated_method = "A7DE313B75D308ECF1DE7310FB5FC762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, char value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "AC456BDE0EE43978AFAB7EF96C2FFCE8", hash_generated_method = "AF92B636B02918EDF116D7ED6130E6C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, double value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "821340AFE72172F29B54D2C504849DA8", hash_generated_method = "764BD5FD339F6E161191D45DDA5EC3F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, float value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "63AD54FC39DDE8BE3BBE5131906AC91A", hash_generated_method = "DBA287A1E7A484834F23A04890945511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "7C91E467656A70134D915DC378A85E85", hash_generated_method = "0E527006594E4A4E1C64306478665255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, long value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "B27C87FCD55A2BEDEC6F0B351B72701B", hash_generated_method = "CDF9D2B6D50CEE360FCA172CD823BCE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.515 -0400", hash_original_method = "8872C66D19E491C8A24E1F3793E76CF5", hash_generated_method = "600C4EA9EB0814ED50ABE6740E0DFB83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, short value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.516 -0400", hash_original_method = "7776E04A4027209B01392EB6C3502FA8", hash_generated_method = "F2135B10B4AF584A732B4C17E7B4783F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void put(String name, boolean value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.528 -0400", hash_original_method = "AB29CC034AE7D29F14B7C45BD47F3CB4", hash_generated_method = "2D6B0B12391C1C0B400E9CA0C70E2C25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @Deprecated
    public void write(ObjectOutput output) throws IOException {
        dsTaint.addTaint(output.dsTaint);
        {
            boolean varF39E87CF781D47F95AFBD29731E4D68F_1131193549 = (!output.equals(oos));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Attempting to write to a different stream than the one that created this PutField");
            } //End block
        } //End collapsed parenthetic
        {
            EmulatedFields.ObjectSlot slot = emulatedFields.slots()[0];
            {
                Object fieldValue;
                fieldValue = slot.getFieldValue();
                Class<?> type;
                type = slot.getField().getType();
                {
                    output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
                } //End block
                {
                    output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
                } //End block
                {
                    output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
                } //End block
                {
                    output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
                } //End block
                {
                    output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
                } //End block
                {
                    output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
                } //End block
                {
                    output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
                } //End block
                {
                    output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
                } //End block
                {
                    output.writeObject(fieldValue);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

