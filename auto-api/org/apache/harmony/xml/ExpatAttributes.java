package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.058 -0400", hash_original_method = "0D2CF6070C325F98E7CB203AC3F89A5D", hash_generated_method = "0D2CF6070C325F98E7CB203AC3F89A5D")
        public ExpatAttributes ()
    {
    }


    public abstract int getLength();

    
    abstract int getParserPointer();

    
    public abstract int getPointer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.059 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "C3325D23CC003C19A9A17A64062C7FA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getURI(int index) {
        dsTaint.addTaint(index);
        {
            boolean var203EB8F451F243B3D8A451211B677024_558745155 = (index < 0 || index >= getLength());
        } //End collapsed parenthetic
        String varF2484E9595FC3EE4BEA03C9CE34227BC_827389981 = (getURI(getParserPointer(), getPointer(), index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index < 0 || index >= getLength()) {
            //return null;
        //}
        //return getURI(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.059 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "118320556BCB40085FBB441AC3E0FA20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalName(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB7146D451FF05C9346A46AB43DC09A3E_2057077566 = ((index < 0 || index >= getLength()));
            Object var5AF2C25FE6C9225A49702AFC388B4707_1523604318 = (getLocalName(getParserPointer(), getPointer(), index));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getLocalName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.059 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "3A0FC60950E14B2C308FCF053A210639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQName(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB7146D451FF05C9346A46AB43DC09A3E_482067050 = ((index < 0 || index >= getLength()));
            Object varA3CEA0A2CC07A8CE7662E786DD5ED774_1536387940 = (getQName(getParserPointer(), getPointer(), index));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getQName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.060 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "7F53B5D0727005D6197172508873838A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getType(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB7146D451FF05C9346A46AB43DC09A3E_1896565633 = ((index < 0 || index >= getLength()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength()) ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.060 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "8F7A51927A7BE55CB26F2A858A701712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB7146D451FF05C9346A46AB43DC09A3E_252077096 = ((index < 0 || index >= getLength()));
            Object varA3838F13DB699C4A1FFC4B2B38DC0DF5_1194394046 = (getValueByIndex(getPointer(), index));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getValueByIndex(getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.060 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "5B652588AFB3028EA3F4AD5C3B948809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndex(String uri, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        int var475C57EF25B01A7CB049CE2D3EAD6E3C_95298557 = (getIndex(pointer, uri, localName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndex(pointer, uri, localName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.061 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "1CB00BD1A35C6BED00F43B27B6B21E73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndex(String qName) {
        dsTaint.addTaint(qName);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        int pointer;
        pointer = getPointer();
        int var96B5423CA7106BED454AAFC40E7EE7D4_644489031 = (getIndexForQName(pointer, qName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("uri");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndexForQName(pointer, qName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.061 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "DAE1E94730652EA42D142229D924B22F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getType(String uri, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        {
            boolean var01B7D3C37121DB1BAE57121ABA3800CC_1685275801 = (getIndex(uri, localName) == -1);
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //return getIndex(uri, localName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.061 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "F6B84D6F8B5BCBFDC2B944344D76B6C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getType(String qName) {
        dsTaint.addTaint(qName);
        {
            boolean var09BCCAB3B05F2B3CECC72C18F9A1EFA7_522159185 = (getIndex(qName) == -1);
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getIndex(qName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.061 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "2ED9C4796051638412FE69E525BC569C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(String uri, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        String var7754412F23BA45753F7F8E0ACB668C3D_699799878 = (getValue(pointer, uri, localName));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValue(pointer, uri, localName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.062 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "AC431587161D25FB9AE17EB62937A15F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(String qName) {
        dsTaint.addTaint(qName);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("qName");
        } //End block
        int pointer;
        pointer = getPointer();
        String varAAB7800DEB842EAC50B120E903CB1AB6_559120644 = (getValueForQName(pointer, qName));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("qName");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValueForQName(pointer, qName);
    }

    
        private static String getURI(int pointer, int attributePointer, int index) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String getLocalName(int pointer, int attributePointer, int index) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String getQName(int pointer, int attributePointer, int index) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String getValueByIndex(int attributePointer, int index) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static int getIndex(int attributePointer, String uri, String localName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int getIndexForQName(int attributePointer, String qName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String getValue(int attributePointer, String uri, String localName) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String getValueForQName(int attributePointer, String qName) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.063 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "FB0CA7C7800BC55D8D68FCC9B7FF9F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void freeAttributes(int pointer) {
        dsTaint.addTaint(pointer);
    }

    
    private static final String CDATA = "CDATA";
}

