package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class Indentation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.099 -0500", hash_original_field = "286452610CAD998336F0009181E4D242", hash_generated_field = "008AF28A46BB87C2DFA1C38C4F2D39CE")

    private int indentation;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.102 -0500", hash_original_method = "3ED5D9003C94B37DFE34F7E548B0A049", hash_generated_method = "01789C865C695B271AD5A54B932E1C62")
    
protected Indentation() {
        indentation = 0;
    }

    /**
     * Constructor
     *
     * @param initval
     *            int to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.106 -0500", hash_original_method = "B9B0555312A93A148C3D06FF260FB7DE", hash_generated_method = "D2E394F768C3A530F3743E0CE1C9A205")
    
protected Indentation(int initval) {
        indentation = initval;
    }

    /**
     * set the indentation field
     *
     * @param initval
     *            int to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.109 -0500", hash_original_method = "9806D9C99234026338307AC4AA946059", hash_generated_method = "A13866161903B966FAF171C70C0335FA")
    
protected void setIndentation(int initval) {
        indentation = initval;
    }

    /**
     * get the number of indentation.
     *
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.111 -0500", hash_original_method = "8C516A01A1E7AEB883F43E447DEEB28B", hash_generated_method = "88E060C72D3FDD5F4DBA6C40D22247F7")
    
protected int getCount() {
        return indentation;
    }

    /**
     * increment the indentation field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.114 -0500", hash_original_method = "6FB962D7C77F4582D7627B370471C9FF", hash_generated_method = "2A8F5ED724913FB64F6B26D3051E347C")
    
protected void increment() {
        indentation++;
    }

    /**
     * decrement the indentation field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.117 -0500", hash_original_method = "54F21AAA256E1C615958DA1382F121C5", hash_generated_method = "3B0FD0BAFEA6252F801DC513665ED3E6")
    
protected void decrement() {
        indentation--;
    }

    /**
     * get the indentation
     *
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.120 -0500", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "BDD6C135FB07D8AC261FA4D2B4D2AE55")
    
protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        return new String(chars);
    }
    
}

