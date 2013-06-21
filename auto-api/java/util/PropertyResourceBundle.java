package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
    Properties resources;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.039 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "1933A970931A36E2C333E10EAFD6BEA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyResourceBundle(InputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        resources = new Properties();
        resources.load(stream);
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //resources = new Properties();
        //resources.load(stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.039 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "A1D9DF71F820DB3BFEB0ADFB028561BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyResourceBundle(Reader reader) throws IOException {
        dsTaint.addTaint(reader.dsTaint);
        resources = new Properties();
        resources.load(reader);
        // ---------- Original Method ----------
        //resources = new Properties();
        //resources.load(reader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.039 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "574F5817AD36A978173255E7BA348889")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Set<String> handleKeySet() {
        Set<String> var1DD2CE5349F6B49350AA8CC21730E132_1396796777 = (resources.stringPropertyNames());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resources.stringPropertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.040 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "0C2ABD9AE5AF7CD6AD5A6F31F7822589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
        Enumeration<String> var93251D1C5C3D7E0FFE3C53F9969DBB14_1067307249 = ((Enumeration<String>) resources.propertyNames());
        return (Enumeration<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Enumeration<String>) resources.propertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.043 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "62846AB7B529C6ED58054ADA5A397CBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Enumeration<String> getKeys() {
        {
            Enumeration<String> var5FBF4133BD30A62AD72716DC02BAD73B_318954011 = (getLocalKeys());
        } //End block
        Enumeration<String> var625A3120A876BF16699BC0AAFC5DF2C0_1874908875 = (new Enumeration<String>() {            Enumeration<String> local = getLocalKeys();
            Enumeration<String> pEnum = parent.getKeys();
            String nextElement;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.042 -0400", hash_original_method = "7E529D209593DF12DACEC799F2DDAEB1", hash_generated_method = "B88A1D9676537C87E34AF5EB822E9F40")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private boolean findNext() {
                {
                    boolean varFB08F8495966D42CE0B7EF938033E691_1017394146 = (pEnum.hasMoreElements());
                    {
                        String next;
                        next = pEnum.nextElement();
                        {
                            boolean var63E13E1355A534485559FF0118AB02D1_249068157 = (!resources.containsKey(next));
                            {
                                nextElement = next;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (nextElement != null) {
                    //return true;
                //}
                //while (pEnum.hasMoreElements()) {
                    //String next = pEnum.nextElement();
                    //if (!resources.containsKey(next)) {
                        //nextElement = next;
                        //return true;
                    //}
                //}
                //return false;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.042 -0400", hash_original_method = "0C8D02D40B56817F2309824D8D7773D2", hash_generated_method = "E07E2426026334C874BFE305E30018B6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasMoreElements() {
                {
                    boolean varB5A82D941C8D5D2B839EFA5550BB0E1C_1634481659 = (local.hasMoreElements());
                } //End collapsed parenthetic
                boolean var174166978333F2F6F3542277A713AECD_1138920944 = (findNext());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (local.hasMoreElements()) {
                    //return true;
                //}
                //return findNext();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.042 -0400", hash_original_method = "BE1AA467D8342A7EF3FB49068D3D4458", hash_generated_method = "D257ED767C682761AEB8162C6E7FDFA4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public String nextElement() {
                {
                    boolean varB5A82D941C8D5D2B839EFA5550BB0E1C_619599100 = (local.hasMoreElements());
                    {
                        String var4210010F4D5C394A6F7CC5D6CD63D144_635328349 = (local.nextElement());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var344C55B93210DAD8D1056CBD3E09F7ED_1739180396 = (findNext());
                    {
                        String result;
                        result = nextElement;
                        nextElement = null;
                    } //End block
                } //End collapsed parenthetic
                String var54AB11914E691CE87E8F3E054F9F6F5F_1693234730 = (pEnum.nextElement());
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //if (local.hasMoreElements()) {
                    //return local.nextElement();
                //}
                //if (findNext()) {
                    //String result = nextElement;
                    //nextElement = null;
                    //return result;
                //}
                //return pEnum.nextElement();
            }
});
        return (Enumeration<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.043 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "E9C2C5FD7F8DEB62B56B32DC0EBDAFD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object handleGetObject(String key) {
        dsTaint.addTaint(key);
        Object varE4B0F7F5A98437FB8999A9691BEDE0C0_1637987120 = (resources.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resources.get(key);
    }

    
}

