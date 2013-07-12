package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL;

class GLLogWrapper extends GLWrapperBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "DBF54F78AEFB053436817860276B7F83", hash_generated_field = "EDE47FCB9653DA233FF2C90684B30260")

    private Writer mLog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "42897FB5102C10159726278B084E4D00", hash_generated_field = "16290804B51F21F78CA000CD0CBECA45")

    private boolean mLogArgumentNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "9FDC16DCB2EE57FF9BC6C05296BC9D85", hash_generated_field = "3D4AA24E99B2CD1AFB8EEE08DE93A4A1")

    private int mArgCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "6CEF95B4410DE09E4DC74283EDBF2772", hash_generated_field = "A9DF68375B541DEE0AA44386877F50FB")

    private PointerInfo mColorPointer = new PointerInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "6C89465838B283A8C8E572C65D567A8E", hash_generated_field = "87D4F61570DD8E7D4D301F37369FF34E")

    private PointerInfo mNormalPointer = new PointerInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "B0209E45804CC4828F5D58869D89329F", hash_generated_field = "5242A1D1405BD09806F1DEA0738B096B")

    private PointerInfo mTexCoordPointer = new PointerInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "7218E6CD5ED7BA5D52E9DA9E24634B09", hash_generated_field = "4A47E1B811ED2063048D8012EBBEE753")

    private PointerInfo mVertexPointer = new PointerInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "407F3A8950DACEB4BB64DF278E562D51", hash_generated_field = "1D813A80DF0D55B241736EF3E13F2BE1")

    boolean mColorArrayEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "53A3706EF02F7CD35D09E9BECC74EA88", hash_generated_field = "0EE9C70A9104622B1A8DAABD253D2C83")

    boolean mNormalArrayEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "C6477B3A34D0BA70DA7A37A4952B2628", hash_generated_field = "654D45C7A4BACCCE4C3B56A310E64894")

    boolean mTextureCoordArrayEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "EE85194B971C5397E945E84DF8AB6952", hash_generated_field = "C590BDCE263175357987A7A33D72C71E")

    boolean mVertexArrayEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.203 -0400", hash_original_field = "D7EE76CA018401AE175C123CE69D0589", hash_generated_field = "A4EAC03B43EBDC136945C29FC8E297E6")

    StringBuilder mStringBuilder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.204 -0400", hash_original_method = "A3493A9CF45B2508C26D55D69FE9C771", hash_generated_method = "B1949F077EADB10141DB0EEAACEAE8AB")
    public  GLLogWrapper(GL gl, Writer log, boolean logArgumentNames) {
        super(gl);
        addTaint(gl.getTaint());
        mLog = log;
        mLogArgumentNames = logArgumentNames;
        // ---------- Original Method ----------
        //mLog = log;
        //mLogArgumentNames = logArgumentNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.204 -0400", hash_original_method = "7B6C54876CD77673EA856C05F8287BB3", hash_generated_method = "EFC95C47D3C92B691A6C9858FD893B60")
    private void checkError() {
        int glError;
    if((glError = mgl.glGetError()) != 0)        
        {
            String errorMessage = "glError: " + Integer.toString(glError);
            logLine(errorMessage);
        } //End block
        // ---------- Original Method ----------
        //int glError;
        //if ((glError = mgl.glGetError()) != 0) {
            //String errorMessage = "glError: " + Integer.toString(glError);
            //logLine(errorMessage);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.205 -0400", hash_original_method = "B819F9C00E5D903C9B12858E84782EC6", hash_generated_method = "5F5D0216A34371FAE77555290CAD8A42")
    private void logLine(String message) {
        addTaint(message.getTaint());
        log(message + '\n');
        // ---------- Original Method ----------
        //log(message + '\n');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.205 -0400", hash_original_method = "55C0C6DBDFA700D90D9FD20B92BCF082", hash_generated_method = "1FD69062587B8774F2FBFC9AB6BCAD1D")
    private void log(String message) {
        addTaint(message.getTaint());
        try 
        {
            mLog.write(message);
        } //End block
        catch (IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mLog.write(message);
        //} catch (IOException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.205 -0400", hash_original_method = "FB0C650254ED9FCE75BB6E7EB1636546", hash_generated_method = "802B50CA37688C411C9409CBBB0D3E0E")
    private void begin(String name) {
        addTaint(name.getTaint());
        log(name + '(');
        mArgCount = 0;
        // ---------- Original Method ----------
        //log(name + '(');
        //mArgCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.206 -0400", hash_original_method = "54C70E45C8BA9C703732EB10FD7BBF7B", hash_generated_method = "DF33C133291E9F393FF306B9A4B6373D")
    private void arg(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(mArgCount++ > 0)        
        {
            log(", ");
        } //End block
    if(mLogArgumentNames)        
        {
            log(name + "=");
        } //End block
        log(value);
        // ---------- Original Method ----------
        //if (mArgCount++ > 0) {
            //log(", ");
        //}
        //if (mLogArgumentNames) {
            //log(name + "=");
        //}
        //log(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.206 -0400", hash_original_method = "34DADD61F74380F23C382DA05A595428", hash_generated_method = "B9D1C3BCA829E316DC2B840473E126DE")
    private void end() {
        log(");\n");
        flush();
        // ---------- Original Method ----------
        //log(");\n");
        //flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.206 -0400", hash_original_method = "0CDA8C40EE3F1BEB19FC35DF0C9C3B14", hash_generated_method = "927A3CC15B210A38C80E3F1C30213844")
    private void flush() {
        try 
        {
            mLog.flush();
        } //End block
        catch (IOException e)
        {
            mLog = null;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mLog.flush();
        //} catch (IOException e) {
            //mLog = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.207 -0400", hash_original_method = "955712C9576F8C997D3BDD787DE32104", hash_generated_method = "19E20715DF411A3C41FA9A57D5980F9C")
    private void arg(String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        arg(name, Boolean.toString(value));
        // ---------- Original Method ----------
        //arg(name, Boolean.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.207 -0400", hash_original_method = "B92E6D1514E3DF39AF9DE02825B78605", hash_generated_method = "28D5EDBB11EB9542D1E4EDDD6466965E")
    private void arg(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        arg(name, Integer.toString(value));
        // ---------- Original Method ----------
        //arg(name, Integer.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.207 -0400", hash_original_method = "AF09399FA6A192AE093560445EC66367", hash_generated_method = "5733F6CDB0ABD14CBBDCE26540441C2F")
    private void arg(String name, float value) {
        addTaint(value);
        addTaint(name.getTaint());
        arg(name, Float.toString(value));
        // ---------- Original Method ----------
        //arg(name, Float.toString(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.208 -0400", hash_original_method = "CEBA98C664D8642C3269C979FB98B560", hash_generated_method = "0CAD5606128D9C9F415A76C0D8E57A1A")
    private void returns(String result) {
        addTaint(result.getTaint());
        log(") returns " + result + ";\n");
        flush();
        // ---------- Original Method ----------
        //log(") returns " + result + ";\n");
        //flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.208 -0400", hash_original_method = "A943ABBAFE7E9588C2D5222F0375E708", hash_generated_method = "8FC8EA26A440313CE4C528916D1B6B45")
    private void returns(int result) {
        addTaint(result);
        returns(Integer.toString(result));
        // ---------- Original Method ----------
        //returns(Integer.toString(result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.208 -0400", hash_original_method = "8F13D6071DB2372AF6E5A020B3D63CE4", hash_generated_method = "542393EEB63C2D042450A446FDC1E9BC")
    private void arg(String name, int n, int[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, FORMAT_INT, arr, offset));
        // ---------- Original Method ----------
        //arg(name, toString(n, FORMAT_INT, arr, offset));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.209 -0400", hash_original_method = "9DAD69FE204FE91A679E79BA32F83523", hash_generated_method = "230ED1E2E2E8220616EC11E0C4CF3DED")
    private void arg(String name, int n, short[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, arr, offset));
        // ---------- Original Method ----------
        //arg(name, toString(n, arr, offset));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.209 -0400", hash_original_method = "4FD869DC81612135A661446E7D5E36EE", hash_generated_method = "6E29A39297765BCA8BE84D4E52A7100A")
    private void arg(String name, int n, float[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, arr, offset));
        // ---------- Original Method ----------
        //arg(name, toString(n, arr, offset));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.209 -0400", hash_original_method = "E08D3360122D211DABE718ED5E58458E", hash_generated_method = "9E216C65E5A8F7A6D23AF00F0E950303")
    private void formattedAppend(StringBuilder buf, int value, int format) {
        addTaint(format);
        addTaint(value);
        addTaint(buf.getTaint());
switch(format){
        case FORMAT_INT:
        buf.append(value);
        break;
        case FORMAT_FLOAT:
        buf.append(Float.intBitsToFloat(value));
        break;
        case FORMAT_FIXED:
        buf.append(value / 65536.0f);
        break;
}
        // ---------- Original Method ----------
        //switch (format) {
        //case FORMAT_INT:
            //buf.append(value);
            //break;
        //case FORMAT_FLOAT:
            //buf.append(Float.intBitsToFloat(value));
            //break;
        //case FORMAT_FIXED:
            //buf.append(value / 65536.0f);
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.210 -0400", hash_original_method = "A1072478259B736CFCA97CBC9F12C979", hash_generated_method = "68E3981D84FCDB70ABB28C27018F9071")
    private String toString(int n, int format, int[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(format);
        addTaint(n);
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
for(int i = 0;i < n;i++)
        {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
    if(index < 0 || index >= arrLen)            
            {
                buf.append("out of bounds");
            } //End block
            else
            {
                formattedAppend(buf, arr[index], format);
            } //End block
            buf.append('\n');
        } //End block
        buf.append("}");
String var4FC680801218E6372BC708D6FA44AE60_59257702 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_59257702.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_59257702;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append("{\n");
        //int arrLen = arr.length;
        //for (int i = 0; i < n; i++) {
            //int index = offset + i;
            //buf.append(" [" + index + "] = ");
            //if (index < 0 || index >= arrLen) {
                //buf.append("out of bounds");
            //} else {
                //formattedAppend(buf, arr[index], format);
            //}
            //buf.append('\n');
        //}
        //buf.append("}");
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.211 -0400", hash_original_method = "58E007C12B329BF9B88C8DD081E4D73F", hash_generated_method = "E05E406D39BCFB5FC0E297D42761C059")
    private String toString(int n, short[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
for(int i = 0;i < n;i++)
        {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
    if(index < 0 || index >= arrLen)            
            {
                buf.append("out of bounds");
            } //End block
            else
            {
                buf.append(arr[index]);
            } //End block
            buf.append('\n');
        } //End block
        buf.append("}");
String var4FC680801218E6372BC708D6FA44AE60_973632355 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_973632355.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_973632355;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append("{\n");
        //int arrLen = arr.length;
        //for (int i = 0; i < n; i++) {
            //int index = offset + i;
            //buf.append(" [" + index + "] = ");
            //if (index < 0 || index >= arrLen) {
                //buf.append("out of bounds");
            //} else {
                //buf.append(arr[index]);
            //}
            //buf.append('\n');
        //}
        //buf.append("}");
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.211 -0400", hash_original_method = "E0279213DB25FBCD6B1A1BF467A23599", hash_generated_method = "5D2CF1CA272BFB20C1FFCA332BF91D5D")
    private String toString(int n, float[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
for(int i = 0;i < n;i++)
        {
            int index = offset + i;
            buf.append("[" + index + "] = ");
    if(index < 0 || index >= arrLen)            
            {
                buf.append("out of bounds");
            } //End block
            else
            {
                buf.append(arr[index]);
            } //End block
            buf.append('\n');
        } //End block
        buf.append("}");
String var4FC680801218E6372BC708D6FA44AE60_2096178406 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_2096178406.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_2096178406;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append("{\n");
        //int arrLen = arr.length;
        //for (int i = 0; i < n; i++) {
            //int index = offset + i;
            //buf.append("[" + index + "] = ");
            //if (index < 0 || index >= arrLen) {
                //buf.append("out of bounds");
            //} else {
                //buf.append(arr[index]);
            //}
            //buf.append('\n');
        //}
        //buf.append("}");
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.212 -0400", hash_original_method = "BA7BACBB919EFD700D9FF40233C8DEDF", hash_generated_method = "131172A8ECDA302F76EAA8E3988201F6")
    private String toString(int n, FloatBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(n);
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
for(int i = 0;i < n;i++)
        {
            builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        } //End block
        builder.append("}");
String varF4CF030572656354ACFDF83FEE21D7A6_1537695601 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1537695601.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1537695601;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append("{\n");
        //for (int i = 0; i < n; i++) {
            //builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        //}
        //builder.append("}");
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.212 -0400", hash_original_method = "27E69164B5E7975B2DEDE9414DD97982", hash_generated_method = "7C647F49234853DB2CDBBD25045A7093")
    private String toString(int n, int format, IntBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(format);
        addTaint(n);
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
for(int i = 0;i < n;i++)
        {
            builder.append(" [" + i + "] = ");
            formattedAppend(builder, buf.get(i), format);
            builder.append('\n');
        } //End block
        builder.append("}");
String varF4CF030572656354ACFDF83FEE21D7A6_2090853386 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_2090853386.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_2090853386;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append("{\n");
        //for (int i = 0; i < n; i++) {
            //builder.append(" [" + i + "] = ");
            //formattedAppend(builder, buf.get(i), format);
            //builder.append('\n');
        //}
        //builder.append("}");
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.213 -0400", hash_original_method = "AB9E3C5D494B64EE75923B2568F2C9EC", hash_generated_method = "C271CB9381CA276FD3544D6A8FCA6B32")
    private String toString(int n, ShortBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(n);
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
for(int i = 0;i < n;i++)
        {
            builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        } //End block
        builder.append("}");
String varF4CF030572656354ACFDF83FEE21D7A6_1719382842 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_1719382842.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_1719382842;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append("{\n");
        //for (int i = 0; i < n; i++) {
            //builder.append(" [" + i + "] = " + buf.get(i) + '\n');
        //}
        //builder.append("}");
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.213 -0400", hash_original_method = "2014532B2F898B51396CE264BC99A9BE", hash_generated_method = "3BA29FC47CA15B5D22009C0EDBE9E6EF")
    private void arg(String name, int n, FloatBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, buf));
        // ---------- Original Method ----------
        //arg(name, toString(n, buf));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.214 -0400", hash_original_method = "1BF1A33030FB8855D976F59B22DED940", hash_generated_method = "0208B0FCB2F675E00B6BB3A088B61CB9")
    private void arg(String name, int n, IntBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, FORMAT_INT, buf));
        // ---------- Original Method ----------
        //arg(name, toString(n, FORMAT_INT, buf));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.214 -0400", hash_original_method = "177FB5028A84628CCF2CA388EC75CDD1", hash_generated_method = "7545B9D47459DFDAAC227C3F581459B3")
    private void arg(String name, int n, ShortBuffer buf) {
        addTaint(buf.getTaint());
        addTaint(n);
        addTaint(name.getTaint());
        arg(name, toString(n, buf));
        // ---------- Original Method ----------
        //arg(name, toString(n, buf));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.215 -0400", hash_original_method = "8C908BBB147F5EC443363AEC1AF393E3", hash_generated_method = "976FD0B40A6C94EF72156CD064DB278B")
    private void argPointer(int size, int type, int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        arg("size", size);
        arg("type", getPointerTypeName(type));
        arg("stride", stride);
        arg("pointer", pointer.toString());
        // ---------- Original Method ----------
        //arg("size", size);
        //arg("type", getPointerTypeName(type));
        //arg("stride", stride);
        //arg("pointer", pointer.toString());
    }

    
        private static String getHex(int value) {
        return "0x" + Integer.toHexString(value);
    }

    
        public static String getErrorString(int error) {
        switch (error) {
        case GL_NO_ERROR:
            return "GL_NO_ERROR";
        case GL_INVALID_ENUM:
            return "GL_INVALID_ENUM";
        case GL_INVALID_VALUE:
            return "GL_INVALID_VALUE";
        case GL_INVALID_OPERATION:
            return "GL_INVALID_OPERATION";
        case GL_STACK_OVERFLOW:
            return "GL_STACK_OVERFLOW";
        case GL_STACK_UNDERFLOW:
            return "GL_STACK_UNDERFLOW";
        case GL_OUT_OF_MEMORY:
            return "GL_OUT_OF_MEMORY";
        default:
            return getHex(error);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.216 -0400", hash_original_method = "D50915305D434E1A5F882494EC15D61A", hash_generated_method = "DC3C43B7E1223E5CF182010E3F708E12")
    private String getClearBufferMask(int mask) {
        addTaint(mask);
        StringBuilder b = new StringBuilder();
    if((mask & GL_DEPTH_BUFFER_BIT) != 0)        
        {
            b.append("GL_DEPTH_BUFFER_BIT");
            mask &= ~GL_DEPTH_BUFFER_BIT;
        } //End block
    if((mask & GL_STENCIL_BUFFER_BIT) != 0)        
        {
    if(b.length() > 0)            
            {
                b.append(" | ");
            } //End block
            b.append("GL_STENCIL_BUFFER_BIT");
            mask &= ~GL_STENCIL_BUFFER_BIT;
        } //End block
    if((mask & GL_COLOR_BUFFER_BIT) != 0)        
        {
    if(b.length() > 0)            
            {
                b.append(" | ");
            } //End block
            b.append("GL_COLOR_BUFFER_BIT");
            mask &= ~GL_COLOR_BUFFER_BIT;
        } //End block
    if(mask != 0)        
        {
    if(b.length() > 0)            
            {
                b.append(" | ");
            } //End block
            b.append(getHex(mask));
        } //End block
String var53F188277CD163A95D3D9B5184E22806_1376863362 =         b.toString();
        var53F188277CD163A95D3D9B5184E22806_1376863362.addTaint(taint);
        return var53F188277CD163A95D3D9B5184E22806_1376863362;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.217 -0400", hash_original_method = "7CCE6D819F0C24FC3AF1A95ABD2C3D96", hash_generated_method = "B08ABC5AE53F6CE3F2F089E7DBF6A99D")
    private String getFactor(int factor) {
        addTaint(factor);
switch(factor){
        case GL_ZERO:
String var0388E0355C936D8455DAC1F7A695BB3B_300851540 =         "GL_ZERO";
        var0388E0355C936D8455DAC1F7A695BB3B_300851540.addTaint(taint);
        return var0388E0355C936D8455DAC1F7A695BB3B_300851540;
        case GL_ONE:
String varE8C4B8C110185A114C688F643D382625_764032267 =         "GL_ONE";
        varE8C4B8C110185A114C688F643D382625_764032267.addTaint(taint);
        return varE8C4B8C110185A114C688F643D382625_764032267;
        case GL_SRC_COLOR:
String varCA936A2F7690434AD3B1D9DEC84ABA45_1207600137 =         "GL_SRC_COLOR";
        varCA936A2F7690434AD3B1D9DEC84ABA45_1207600137.addTaint(taint);
        return varCA936A2F7690434AD3B1D9DEC84ABA45_1207600137;
        case GL_ONE_MINUS_SRC_COLOR:
String varD8542C663B25692CF5CD9D14A266133F_2052916189 =         "GL_ONE_MINUS_SRC_COLOR";
        varD8542C663B25692CF5CD9D14A266133F_2052916189.addTaint(taint);
        return varD8542C663B25692CF5CD9D14A266133F_2052916189;
        case GL_DST_COLOR:
String var167DC048B2C56DC28F8B2F55486B4D9B_2090246102 =         "GL_DST_COLOR";
        var167DC048B2C56DC28F8B2F55486B4D9B_2090246102.addTaint(taint);
        return var167DC048B2C56DC28F8B2F55486B4D9B_2090246102;
        case GL_ONE_MINUS_DST_COLOR:
String var50228B9049EE054A3A837062668C0D40_1285911518 =         "GL_ONE_MINUS_DST_COLOR";
        var50228B9049EE054A3A837062668C0D40_1285911518.addTaint(taint);
        return var50228B9049EE054A3A837062668C0D40_1285911518;
        case GL_SRC_ALPHA:
String var3A542DE92592C2BC3E0E67DE6B12587A_555706229 =         "GL_SRC_ALPHA";
        var3A542DE92592C2BC3E0E67DE6B12587A_555706229.addTaint(taint);
        return var3A542DE92592C2BC3E0E67DE6B12587A_555706229;
        case GL_ONE_MINUS_SRC_ALPHA:
String var750DE2B968B19AA92F78E8E5598D1B6E_414945234 =         "GL_ONE_MINUS_SRC_ALPHA";
        var750DE2B968B19AA92F78E8E5598D1B6E_414945234.addTaint(taint);
        return var750DE2B968B19AA92F78E8E5598D1B6E_414945234;
        case GL_DST_ALPHA:
String var4F687960364352395503EE556565F309_1561299062 =         "GL_DST_ALPHA";
        var4F687960364352395503EE556565F309_1561299062.addTaint(taint);
        return var4F687960364352395503EE556565F309_1561299062;
        case GL_ONE_MINUS_DST_ALPHA:
String var9F512090EAB96E18AD111FFC6DEE0223_1485689621 =         "GL_ONE_MINUS_DST_ALPHA";
        var9F512090EAB96E18AD111FFC6DEE0223_1485689621.addTaint(taint);
        return var9F512090EAB96E18AD111FFC6DEE0223_1485689621;
        case GL_SRC_ALPHA_SATURATE:
String varE52ECD17DB9EFA1FA23DBACFC6EF2E03_1998156081 =         "GL_SRC_ALPHA_SATURATE";
        varE52ECD17DB9EFA1FA23DBACFC6EF2E03_1998156081.addTaint(taint);
        return varE52ECD17DB9EFA1FA23DBACFC6EF2E03_1998156081;
        default:
String var840A741A36C6E9A10DFD6A3AB19799AA_723207574 =         getHex(factor);
        var840A741A36C6E9A10DFD6A3AB19799AA_723207574.addTaint(taint);
        return var840A741A36C6E9A10DFD6A3AB19799AA_723207574;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.217 -0400", hash_original_method = "D293263142DE13A9C5B18E932B7DD8FD", hash_generated_method = "48711402F00D97D89555C5B3FE108B21")
    private String getShadeModel(int model) {
        addTaint(model);
switch(model){
        case GL_FLAT:
String varB70E283ADA98EFC964A9617AB4C520E2_1617064738 =         "GL_FLAT";
        varB70E283ADA98EFC964A9617AB4C520E2_1617064738.addTaint(taint);
        return varB70E283ADA98EFC964A9617AB4C520E2_1617064738;
        case GL_SMOOTH:
String var00B31F889F5CB275AA07BA5FF1826930_351146330 =         "GL_SMOOTH";
        var00B31F889F5CB275AA07BA5FF1826930_351146330.addTaint(taint);
        return var00B31F889F5CB275AA07BA5FF1826930_351146330;
        default:
String var7DB0EEEE1FF94A813E16434692E1FB9C_1204098533 =         getHex(model);
        var7DB0EEEE1FF94A813E16434692E1FB9C_1204098533.addTaint(taint);
        return var7DB0EEEE1FF94A813E16434692E1FB9C_1204098533;
}
        // ---------- Original Method ----------
        //switch(model) {
        //case GL_FLAT:
            //return "GL_FLAT";
        //case GL_SMOOTH:
            //return "GL_SMOOTH";
        //default:
            //return getHex(model);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.218 -0400", hash_original_method = "B475B71F7978A29CB571F01EF167C5F4", hash_generated_method = "9AB5E3B1A24327B9FB96A8165DED285C")
    private String getTextureTarget(int target) {
        addTaint(target);
switch(target){
        case GL_TEXTURE_2D:
String var7FCEDA9046BC405E068DB4252D95A7EF_1836644299 =         "GL_TEXTURE_2D";
        var7FCEDA9046BC405E068DB4252D95A7EF_1836644299.addTaint(taint);
        return var7FCEDA9046BC405E068DB4252D95A7EF_1836644299;
        default:
String varC5BCCB40D483945AD16346DCD4C1BFD9_950850500 =         getHex(target);
        varC5BCCB40D483945AD16346DCD4C1BFD9_950850500.addTaint(taint);
        return varC5BCCB40D483945AD16346DCD4C1BFD9_950850500;
}
        // ---------- Original Method ----------
        //switch (target) {
        //case GL_TEXTURE_2D:
            //return "GL_TEXTURE_2D";
        //default:
            //return getHex(target);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.218 -0400", hash_original_method = "A409E4F874EF601C9002CED64297404F", hash_generated_method = "CFF6A11592A730BE13917B5784F8532C")
    private String getTextureEnvTarget(int target) {
        addTaint(target);
switch(target){
        case GL_TEXTURE_ENV:
String var7B20551B604FC7C52D60FDD53B209DB6_369753553 =         "GL_TEXTURE_ENV";
        var7B20551B604FC7C52D60FDD53B209DB6_369753553.addTaint(taint);
        return var7B20551B604FC7C52D60FDD53B209DB6_369753553;
        default:
String varC5BCCB40D483945AD16346DCD4C1BFD9_963114930 =         getHex(target);
        varC5BCCB40D483945AD16346DCD4C1BFD9_963114930.addTaint(taint);
        return varC5BCCB40D483945AD16346DCD4C1BFD9_963114930;
}
        // ---------- Original Method ----------
        //switch (target) {
        //case GL_TEXTURE_ENV:
            //return "GL_TEXTURE_ENV";
        //default:
            //return getHex(target);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.219 -0400", hash_original_method = "240EE86688BBA555EFA549F8D5279211", hash_generated_method = "AA2ED5477C8625DD0DA930E28DB5FB48")
    private String getTextureEnvPName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_TEXTURE_ENV_MODE:
String var734B0AD3D3911219CB76444DE50697B9_1596848103 =         "GL_TEXTURE_ENV_MODE";
        var734B0AD3D3911219CB76444DE50697B9_1596848103.addTaint(taint);
        return var734B0AD3D3911219CB76444DE50697B9_1596848103;
        case GL_TEXTURE_ENV_COLOR:
String var808DCAD51E59640D1FBA1875D471199A_417535632 =         "GL_TEXTURE_ENV_COLOR";
        var808DCAD51E59640D1FBA1875D471199A_417535632.addTaint(taint);
        return var808DCAD51E59640D1FBA1875D471199A_417535632;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_59766863 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_59766863.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_59766863;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_TEXTURE_ENV_MODE:
            //return "GL_TEXTURE_ENV_MODE";
        //case GL_TEXTURE_ENV_COLOR:
            //return "GL_TEXTURE_ENV_COLOR";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.219 -0400", hash_original_method = "814F9443E35DD12509B9BA466EE8DCB2", hash_generated_method = "85A3931DAB6417AA33872EEAF8FDD372")
    private int getTextureEnvParamCount(int pname) {
        addTaint(pname);
switch(pname){
        case GL_TEXTURE_ENV_MODE:
        int varC4CA4238A0B923820DCC509A6F75849B_1064271671 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711922968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711922968;
        case GL_TEXTURE_ENV_COLOR:
        int varA87FF679A2F3E71D9181A67B7542122C_336522313 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7887563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7887563;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_1735169516 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718348608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718348608;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_TEXTURE_ENV_MODE:
            //return 1;
        //case GL_TEXTURE_ENV_COLOR:
            //return 4;
        //default:
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.220 -0400", hash_original_method = "66F5BFBCC2FD04908BD633D296370E3A", hash_generated_method = "DCD6A7CE49CD4185BB7BBF5B6A60601B")
    private String getTextureEnvParamName(float param) {
        addTaint(param);
        int iparam = (int) param;
    if(param == (float) iparam)        
        {
switch(iparam){
            case GL_REPLACE:
String var3A1F5F4E86BA07DF893EC9CCF78EE89B_1933102119 =             "GL_REPLACE";
            var3A1F5F4E86BA07DF893EC9CCF78EE89B_1933102119.addTaint(taint);
            return var3A1F5F4E86BA07DF893EC9CCF78EE89B_1933102119;
            case GL_MODULATE:
String varFAFF9FEC0F3EF825BE06012DB477D078_1355923823 =             "GL_MODULATE";
            varFAFF9FEC0F3EF825BE06012DB477D078_1355923823.addTaint(taint);
            return varFAFF9FEC0F3EF825BE06012DB477D078_1355923823;
            case GL_DECAL:
String var500B9C26707841E13AC49361D9E20781_1984882456 =             "GL_DECAL";
            var500B9C26707841E13AC49361D9E20781_1984882456.addTaint(taint);
            return var500B9C26707841E13AC49361D9E20781_1984882456;
            case GL_BLEND:
String var42B4DCC73F0775350CFF34F6FE00CA58_388790893 =             "GL_BLEND";
            var42B4DCC73F0775350CFF34F6FE00CA58_388790893.addTaint(taint);
            return var42B4DCC73F0775350CFF34F6FE00CA58_388790893;
            case GL_ADD:
String var0D41AB79B2E693C0AAFCD6DBFFF447D7_1314921472 =             "GL_ADD";
            var0D41AB79B2E693C0AAFCD6DBFFF447D7_1314921472.addTaint(taint);
            return var0D41AB79B2E693C0AAFCD6DBFFF447D7_1314921472;
            case GL_COMBINE:
String var9D5789599C8B24863070AF0B161C4495_737363835 =             "GL_COMBINE";
            var9D5789599C8B24863070AF0B161C4495_737363835.addTaint(taint);
            return var9D5789599C8B24863070AF0B161C4495_737363835;
            default:
String var7B2DE54FA3769EF164A155C968F33479_276895378 =             getHex(iparam);
            var7B2DE54FA3769EF164A155C968F33479_276895378.addTaint(taint);
            return var7B2DE54FA3769EF164A155C968F33479_276895378;
}
        } //End block
String var41CF4871428AE4E5BF75FAC31BD7499F_1339748215 =         Float.toString(param);
        var41CF4871428AE4E5BF75FAC31BD7499F_1339748215.addTaint(taint);
        return var41CF4871428AE4E5BF75FAC31BD7499F_1339748215;
        // ---------- Original Method ----------
        //int iparam = (int) param;
        //if (param == (float) iparam) {
            //switch (iparam) {
            //case GL_REPLACE:
                //return "GL_REPLACE";
            //case GL_MODULATE:
                //return "GL_MODULATE";
            //case GL_DECAL:
                //return "GL_DECAL";
            //case GL_BLEND:
                //return "GL_BLEND";
            //case GL_ADD:
                //return "GL_ADD";
            //case GL_COMBINE:
                //return "GL_COMBINE";
            //default:
                //return getHex(iparam);
            //}
        //}
        //return Float.toString(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.220 -0400", hash_original_method = "A5D3AB9FF6FE40C51BADE42E6771AE1F", hash_generated_method = "342611E264BD71B5B14D75D0AE0C6867")
    private String getMatrixMode(int matrixMode) {
        addTaint(matrixMode);
switch(matrixMode){
        case GL_MODELVIEW:
String varADFFC3B1E870FBB5A51660BF8DB07563_1121214422 =         "GL_MODELVIEW";
        varADFFC3B1E870FBB5A51660BF8DB07563_1121214422.addTaint(taint);
        return varADFFC3B1E870FBB5A51660BF8DB07563_1121214422;
        case GL_PROJECTION:
String varD0C76DC17BF8102AF2370FA1FB8E85D1_814042283 =         "GL_PROJECTION";
        varD0C76DC17BF8102AF2370FA1FB8E85D1_814042283.addTaint(taint);
        return varD0C76DC17BF8102AF2370FA1FB8E85D1_814042283;
        case GL_TEXTURE:
String varFB434291C97074F9FB2D82738AF113B3_88762796 =         "GL_TEXTURE";
        varFB434291C97074F9FB2D82738AF113B3_88762796.addTaint(taint);
        return varFB434291C97074F9FB2D82738AF113B3_88762796;
        default:
String varC63359BEBE10899C8958631BF0D303FF_377559618 =         getHex(matrixMode);
        varC63359BEBE10899C8958631BF0D303FF_377559618.addTaint(taint);
        return varC63359BEBE10899C8958631BF0D303FF_377559618;
}
        // ---------- Original Method ----------
        //switch (matrixMode) {
        //case GL_MODELVIEW:
            //return "GL_MODELVIEW";
        //case GL_PROJECTION:
            //return "GL_PROJECTION";
        //case GL_TEXTURE:
            //return "GL_TEXTURE";
        //default:
            //return getHex(matrixMode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.221 -0400", hash_original_method = "887401050582DE2609B785082BED790B", hash_generated_method = "C8B4F5D62E56167861F1FD8F205137BC")
    private String getClientState(int clientState) {
        addTaint(clientState);
switch(clientState){
        case GL_COLOR_ARRAY:
String varF4ACB422461D0556A34752B5224CBF4B_836229636 =         "GL_COLOR_ARRAY";
        varF4ACB422461D0556A34752B5224CBF4B_836229636.addTaint(taint);
        return varF4ACB422461D0556A34752B5224CBF4B_836229636;
        case GL_VERTEX_ARRAY:
String varE46E4997974654BB7653478435B31AC6_1129465614 =         "GL_VERTEX_ARRAY";
        varE46E4997974654BB7653478435B31AC6_1129465614.addTaint(taint);
        return varE46E4997974654BB7653478435B31AC6_1129465614;
        case GL_NORMAL_ARRAY:
String var3498813DA4E36D59FCADFB4203E9C8A9_953009958 =         "GL_NORMAL_ARRAY";
        var3498813DA4E36D59FCADFB4203E9C8A9_953009958.addTaint(taint);
        return var3498813DA4E36D59FCADFB4203E9C8A9_953009958;
        case GL_TEXTURE_COORD_ARRAY:
String var934AB1484A08D744244D8322FBFEA830_1905041886 =         "GL_TEXTURE_COORD_ARRAY";
        var934AB1484A08D744244D8322FBFEA830_1905041886.addTaint(taint);
        return var934AB1484A08D744244D8322FBFEA830_1905041886;
        default:
String varF0023A1C20D46A3CAEFA6083F72A1D1C_902719480 =         getHex(clientState);
        varF0023A1C20D46A3CAEFA6083F72A1D1C_902719480.addTaint(taint);
        return varF0023A1C20D46A3CAEFA6083F72A1D1C_902719480;
}
        // ---------- Original Method ----------
        //switch (clientState) {
        //case GL_COLOR_ARRAY:
            //return "GL_COLOR_ARRAY";
        //case GL_VERTEX_ARRAY:
            //return "GL_VERTEX_ARRAY";
        //case GL_NORMAL_ARRAY:
            //return "GL_NORMAL_ARRAY";
        //case GL_TEXTURE_COORD_ARRAY:
            //return "GL_TEXTURE_COORD_ARRAY";
        //default:
            //return getHex(clientState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.221 -0400", hash_original_method = "26644C965F0F84D320609302178980F8", hash_generated_method = "9632C4521FC80B0B1EDC469245DB235A")
    private String getCap(int cap) {
        addTaint(cap);
switch(cap){
        case GL_FOG:
String var4C10CF4D60E7DE2A909D190A144705F2_1363894075 =         "GL_FOG";
        var4C10CF4D60E7DE2A909D190A144705F2_1363894075.addTaint(taint);
        return var4C10CF4D60E7DE2A909D190A144705F2_1363894075;
        case GL_LIGHTING:
String var031C03B2D156E46F7FBB3B92385CD04B_828291025 =         "GL_LIGHTING";
        var031C03B2D156E46F7FBB3B92385CD04B_828291025.addTaint(taint);
        return var031C03B2D156E46F7FBB3B92385CD04B_828291025;
        case GL_TEXTURE_2D:
String var7FCEDA9046BC405E068DB4252D95A7EF_397051316 =         "GL_TEXTURE_2D";
        var7FCEDA9046BC405E068DB4252D95A7EF_397051316.addTaint(taint);
        return var7FCEDA9046BC405E068DB4252D95A7EF_397051316;
        case GL_CULL_FACE:
String varF6E31A85B385649478FD81F240DFABBB_1519917161 =         "GL_CULL_FACE";
        varF6E31A85B385649478FD81F240DFABBB_1519917161.addTaint(taint);
        return varF6E31A85B385649478FD81F240DFABBB_1519917161;
        case GL_ALPHA_TEST:
String var1FEA566B5C02088E013F0B21C0D21178_110605317 =         "GL_ALPHA_TEST";
        var1FEA566B5C02088E013F0B21C0D21178_110605317.addTaint(taint);
        return var1FEA566B5C02088E013F0B21C0D21178_110605317;
        case GL_BLEND:
String var42B4DCC73F0775350CFF34F6FE00CA58_1569934709 =         "GL_BLEND";
        var42B4DCC73F0775350CFF34F6FE00CA58_1569934709.addTaint(taint);
        return var42B4DCC73F0775350CFF34F6FE00CA58_1569934709;
        case GL_COLOR_LOGIC_OP:
String var989D1E6BB445EE7203640E78137C2C91_872158741 =         "GL_COLOR_LOGIC_OP";
        var989D1E6BB445EE7203640E78137C2C91_872158741.addTaint(taint);
        return var989D1E6BB445EE7203640E78137C2C91_872158741;
        case GL_DITHER:
String varC72B20727CF41FECA552A07699B49401_1883667139 =         "GL_DITHER";
        varC72B20727CF41FECA552A07699B49401_1883667139.addTaint(taint);
        return varC72B20727CF41FECA552A07699B49401_1883667139;
        case GL_STENCIL_TEST:
String varD56B0F74AE0C2CE5F48BC6A95F8B5139_1876886549 =         "GL_STENCIL_TEST";
        varD56B0F74AE0C2CE5F48BC6A95F8B5139_1876886549.addTaint(taint);
        return varD56B0F74AE0C2CE5F48BC6A95F8B5139_1876886549;
        case GL_DEPTH_TEST:
String var25217CF0DA2D9F7F3940A15581A435FF_189993972 =         "GL_DEPTH_TEST";
        var25217CF0DA2D9F7F3940A15581A435FF_189993972.addTaint(taint);
        return var25217CF0DA2D9F7F3940A15581A435FF_189993972;
        case GL_LIGHT0:
String varBDFA4EBF4CB0A8C7C2A83FD8495DD512_1569425815 =         "GL_LIGHT0";
        varBDFA4EBF4CB0A8C7C2A83FD8495DD512_1569425815.addTaint(taint);
        return varBDFA4EBF4CB0A8C7C2A83FD8495DD512_1569425815;
        case GL_LIGHT1:
String var9271E5CDE159A75EE864B7F7DE136936_893426789 =         "GL_LIGHT1";
        var9271E5CDE159A75EE864B7F7DE136936_893426789.addTaint(taint);
        return var9271E5CDE159A75EE864B7F7DE136936_893426789;
        case GL_LIGHT2:
String varC8B058834A657FF0BF3E1F7DBC16B180_605554179 =         "GL_LIGHT2";
        varC8B058834A657FF0BF3E1F7DBC16B180_605554179.addTaint(taint);
        return varC8B058834A657FF0BF3E1F7DBC16B180_605554179;
        case GL_LIGHT3:
String var20BE116EF4BBFCE4AE5DCF780291B990_1988005714 =         "GL_LIGHT3";
        var20BE116EF4BBFCE4AE5DCF780291B990_1988005714.addTaint(taint);
        return var20BE116EF4BBFCE4AE5DCF780291B990_1988005714;
        case GL_LIGHT4:
String var1A0DFB37C8EE14BE929EBDD4EE4403AE_2121735951 =         "GL_LIGHT4";
        var1A0DFB37C8EE14BE929EBDD4EE4403AE_2121735951.addTaint(taint);
        return var1A0DFB37C8EE14BE929EBDD4EE4403AE_2121735951;
        case GL_LIGHT5:
String var411239BDAB1F6DDF65D201F6C9E0B9D7_1822848011 =         "GL_LIGHT5";
        var411239BDAB1F6DDF65D201F6C9E0B9D7_1822848011.addTaint(taint);
        return var411239BDAB1F6DDF65D201F6C9E0B9D7_1822848011;
        case GL_LIGHT6:
String var886BDBC300969F9BFED36A2D89A7393A_1652584598 =         "GL_LIGHT6";
        var886BDBC300969F9BFED36A2D89A7393A_1652584598.addTaint(taint);
        return var886BDBC300969F9BFED36A2D89A7393A_1652584598;
        case GL_LIGHT7:
String var373F9D1D3488F929B633B5382DDD78B7_2128876583 =         "GL_LIGHT7";
        var373F9D1D3488F929B633B5382DDD78B7_2128876583.addTaint(taint);
        return var373F9D1D3488F929B633B5382DDD78B7_2128876583;
        case GL_POINT_SMOOTH:
String varCC799783F59D69282317E0BDEC20753A_896834263 =         "GL_POINT_SMOOTH";
        varCC799783F59D69282317E0BDEC20753A_896834263.addTaint(taint);
        return varCC799783F59D69282317E0BDEC20753A_896834263;
        case GL_LINE_SMOOTH:
String varEB92BABF839941F45C7D470CD404375B_1781531064 =         "GL_LINE_SMOOTH";
        varEB92BABF839941F45C7D470CD404375B_1781531064.addTaint(taint);
        return varEB92BABF839941F45C7D470CD404375B_1781531064;
        case GL_COLOR_MATERIAL:
String varA1F18D2D79B22D38D82CA3B49AA7052C_1312948663 =         "GL_COLOR_MATERIAL";
        varA1F18D2D79B22D38D82CA3B49AA7052C_1312948663.addTaint(taint);
        return varA1F18D2D79B22D38D82CA3B49AA7052C_1312948663;
        case GL_NORMALIZE:
String var6BE0D3E2B3E0109E13D5F33DC2643B46_137600537 =         "GL_NORMALIZE";
        var6BE0D3E2B3E0109E13D5F33DC2643B46_137600537.addTaint(taint);
        return var6BE0D3E2B3E0109E13D5F33DC2643B46_137600537;
        case GL_RESCALE_NORMAL:
String var4509A5243868ACB17BA17D7C01E5DD86_292255712 =         "GL_RESCALE_NORMAL";
        var4509A5243868ACB17BA17D7C01E5DD86_292255712.addTaint(taint);
        return var4509A5243868ACB17BA17D7C01E5DD86_292255712;
        case GL_VERTEX_ARRAY:
String varE46E4997974654BB7653478435B31AC6_554526370 =         "GL_VERTEX_ARRAY";
        varE46E4997974654BB7653478435B31AC6_554526370.addTaint(taint);
        return varE46E4997974654BB7653478435B31AC6_554526370;
        case GL_NORMAL_ARRAY:
String var3498813DA4E36D59FCADFB4203E9C8A9_1913674996 =         "GL_NORMAL_ARRAY";
        var3498813DA4E36D59FCADFB4203E9C8A9_1913674996.addTaint(taint);
        return var3498813DA4E36D59FCADFB4203E9C8A9_1913674996;
        case GL_COLOR_ARRAY:
String varF4ACB422461D0556A34752B5224CBF4B_51704481 =         "GL_COLOR_ARRAY";
        varF4ACB422461D0556A34752B5224CBF4B_51704481.addTaint(taint);
        return varF4ACB422461D0556A34752B5224CBF4B_51704481;
        case GL_TEXTURE_COORD_ARRAY:
String var934AB1484A08D744244D8322FBFEA830_1661150006 =         "GL_TEXTURE_COORD_ARRAY";
        var934AB1484A08D744244D8322FBFEA830_1661150006.addTaint(taint);
        return var934AB1484A08D744244D8322FBFEA830_1661150006;
        case GL_MULTISAMPLE:
String varE5B6A19C34B10415E017ABFA0A83EDA5_1892751900 =         "GL_MULTISAMPLE";
        varE5B6A19C34B10415E017ABFA0A83EDA5_1892751900.addTaint(taint);
        return varE5B6A19C34B10415E017ABFA0A83EDA5_1892751900;
        case GL_SAMPLE_ALPHA_TO_COVERAGE:
String varA12563996D0DE8D28569DED81CAB1C73_1417752995 =         "GL_SAMPLE_ALPHA_TO_COVERAGE";
        varA12563996D0DE8D28569DED81CAB1C73_1417752995.addTaint(taint);
        return varA12563996D0DE8D28569DED81CAB1C73_1417752995;
        case GL_SAMPLE_ALPHA_TO_ONE:
String var8035BD1BB45A34875CAD315986EA4930_1282577559 =         "GL_SAMPLE_ALPHA_TO_ONE";
        var8035BD1BB45A34875CAD315986EA4930_1282577559.addTaint(taint);
        return var8035BD1BB45A34875CAD315986EA4930_1282577559;
        case GL_SAMPLE_COVERAGE:
String var4BAAF076859A8492ED9A33127E0B2584_846433091 =         "GL_SAMPLE_COVERAGE";
        var4BAAF076859A8492ED9A33127E0B2584_846433091.addTaint(taint);
        return var4BAAF076859A8492ED9A33127E0B2584_846433091;
        case GL_SCISSOR_TEST:
String varEA4C4F0C5EDEAE7ACD61BB14C370DFDD_809575113 =         "GL_SCISSOR_TEST";
        varEA4C4F0C5EDEAE7ACD61BB14C370DFDD_809575113.addTaint(taint);
        return varEA4C4F0C5EDEAE7ACD61BB14C370DFDD_809575113;
        default:
String var7988E6ED7ECB3CDD25FE6FDA245358C7_483243742 =         getHex(cap);
        var7988E6ED7ECB3CDD25FE6FDA245358C7_483243742.addTaint(taint);
        return var7988E6ED7ECB3CDD25FE6FDA245358C7_483243742;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.222 -0400", hash_original_method = "97AC8E7B3D4194738E07F221B5D7327E", hash_generated_method = "BEFA47AE70E4F2C40E9A8B5F8A0EB780")
    private String getTexturePName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_TEXTURE_MAG_FILTER:
String var274AC4110D5890735670CC974BDEAFD6_131436996 =         "GL_TEXTURE_MAG_FILTER";
        var274AC4110D5890735670CC974BDEAFD6_131436996.addTaint(taint);
        return var274AC4110D5890735670CC974BDEAFD6_131436996;
        case GL_TEXTURE_MIN_FILTER:
String var727A4FB456234E2E9A041A4E3D601CE0_1386215394 =         "GL_TEXTURE_MIN_FILTER";
        var727A4FB456234E2E9A041A4E3D601CE0_1386215394.addTaint(taint);
        return var727A4FB456234E2E9A041A4E3D601CE0_1386215394;
        case GL_TEXTURE_WRAP_S:
String varECF02CB8B432BB56E5855E1722D17642_758192346 =         "GL_TEXTURE_WRAP_S";
        varECF02CB8B432BB56E5855E1722D17642_758192346.addTaint(taint);
        return varECF02CB8B432BB56E5855E1722D17642_758192346;
        case GL_TEXTURE_WRAP_T:
String varC42FC7B0336EE848350AC9FCFAD95486_183450428 =         "GL_TEXTURE_WRAP_T";
        varC42FC7B0336EE848350AC9FCFAD95486_183450428.addTaint(taint);
        return varC42FC7B0336EE848350AC9FCFAD95486_183450428;
        case GL_GENERATE_MIPMAP:
String var1EFBD6F2C6E16DD76FDE3553FD946FD5_20260634 =         "GL_GENERATE_MIPMAP";
        var1EFBD6F2C6E16DD76FDE3553FD946FD5_20260634.addTaint(taint);
        return var1EFBD6F2C6E16DD76FDE3553FD946FD5_20260634;
        case GL_TEXTURE_CROP_RECT_OES:
String var16D9B4BABA426C9095EF1389B64996E5_1161983181 =         "GL_TEXTURE_CROP_RECT_OES";
        var16D9B4BABA426C9095EF1389B64996E5_1161983181.addTaint(taint);
        return var16D9B4BABA426C9095EF1389B64996E5_1161983181;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_1701170547 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_1701170547.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_1701170547;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_TEXTURE_MAG_FILTER:
            //return "GL_TEXTURE_MAG_FILTER";
        //case GL_TEXTURE_MIN_FILTER:
            //return "GL_TEXTURE_MIN_FILTER";
        //case GL_TEXTURE_WRAP_S:
            //return "GL_TEXTURE_WRAP_S";
        //case GL_TEXTURE_WRAP_T:
            //return "GL_TEXTURE_WRAP_T";
        //case GL_GENERATE_MIPMAP:
            //return "GL_GENERATE_MIPMAP";
        //case GL_TEXTURE_CROP_RECT_OES:
            //return "GL_TEXTURE_CROP_RECT_OES";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.222 -0400", hash_original_method = "70E0C8289B892BD0B10D984411AC6166", hash_generated_method = "F02D45903A821491494916DB79D94BB6")
    private String getTextureParamName(float param) {
        addTaint(param);
        int iparam = (int) param;
    if(param == (float) iparam)        
        {
switch(iparam){
            case GL_CLAMP_TO_EDGE:
String var43728E83C5C426DA0ED680E33345A997_350720919 =             "GL_CLAMP_TO_EDGE";
            var43728E83C5C426DA0ED680E33345A997_350720919.addTaint(taint);
            return var43728E83C5C426DA0ED680E33345A997_350720919;
            case GL_REPEAT:
String varFBDF972558E1B949F120416FBE25D514_1997456650 =             "GL_REPEAT";
            varFBDF972558E1B949F120416FBE25D514_1997456650.addTaint(taint);
            return varFBDF972558E1B949F120416FBE25D514_1997456650;
            case GL_NEAREST:
String varFFB7697D893361BE4B5CD987589CD863_1732403218 =             "GL_NEAREST";
            varFFB7697D893361BE4B5CD987589CD863_1732403218.addTaint(taint);
            return varFFB7697D893361BE4B5CD987589CD863_1732403218;
            case GL_LINEAR:
String var1B3128E82FA874E8669726FAACD54848_460964489 =             "GL_LINEAR";
            var1B3128E82FA874E8669726FAACD54848_460964489.addTaint(taint);
            return var1B3128E82FA874E8669726FAACD54848_460964489;
            case GL_NEAREST_MIPMAP_NEAREST:
String var94025C29E720B551C52113854B024F37_897829592 =             "GL_NEAREST_MIPMAP_NEAREST";
            var94025C29E720B551C52113854B024F37_897829592.addTaint(taint);
            return var94025C29E720B551C52113854B024F37_897829592;
            case GL_LINEAR_MIPMAP_NEAREST:
String varF39BB3AD0F50793DD7B6B7218117132C_1426381617 =             "GL_LINEAR_MIPMAP_NEAREST";
            varF39BB3AD0F50793DD7B6B7218117132C_1426381617.addTaint(taint);
            return varF39BB3AD0F50793DD7B6B7218117132C_1426381617;
            case GL_NEAREST_MIPMAP_LINEAR:
String varD9CCBCD8F23943D1413D0BA09C5EE341_1648618692 =             "GL_NEAREST_MIPMAP_LINEAR";
            varD9CCBCD8F23943D1413D0BA09C5EE341_1648618692.addTaint(taint);
            return varD9CCBCD8F23943D1413D0BA09C5EE341_1648618692;
            case GL_LINEAR_MIPMAP_LINEAR:
String varDB0BBF9DC59A8B7C0C6BD62764902F4C_1218945107 =             "GL_LINEAR_MIPMAP_LINEAR";
            varDB0BBF9DC59A8B7C0C6BD62764902F4C_1218945107.addTaint(taint);
            return varDB0BBF9DC59A8B7C0C6BD62764902F4C_1218945107;
            default:
String var7B2DE54FA3769EF164A155C968F33479_1155633577 =             getHex(iparam);
            var7B2DE54FA3769EF164A155C968F33479_1155633577.addTaint(taint);
            return var7B2DE54FA3769EF164A155C968F33479_1155633577;
}
        } //End block
String var41CF4871428AE4E5BF75FAC31BD7499F_926024304 =         Float.toString(param);
        var41CF4871428AE4E5BF75FAC31BD7499F_926024304.addTaint(taint);
        return var41CF4871428AE4E5BF75FAC31BD7499F_926024304;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.223 -0400", hash_original_method = "28D99551C137ADB006DA3B79D8C13C8F", hash_generated_method = "E7C6CFA7FA5AD40E1C02A12C97FDB6A3")
    private String getFogPName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_FOG_DENSITY:
String var4F89877E779731002A5181AB1DF4E9D8_17729502 =         "GL_FOG_DENSITY";
        var4F89877E779731002A5181AB1DF4E9D8_17729502.addTaint(taint);
        return var4F89877E779731002A5181AB1DF4E9D8_17729502;
        case GL_FOG_START:
String var2C8B721D9995CD94BD313CE4305A9980_376004812 =         "GL_FOG_START";
        var2C8B721D9995CD94BD313CE4305A9980_376004812.addTaint(taint);
        return var2C8B721D9995CD94BD313CE4305A9980_376004812;
        case GL_FOG_END:
String var189F12B3C81E2507FDCF5B79C440ED06_863005695 =         "GL_FOG_END";
        var189F12B3C81E2507FDCF5B79C440ED06_863005695.addTaint(taint);
        return var189F12B3C81E2507FDCF5B79C440ED06_863005695;
        case GL_FOG_MODE:
String var2E98A2B2BD55843CF6DB1382D696DAA6_1105567359 =         "GL_FOG_MODE";
        var2E98A2B2BD55843CF6DB1382D696DAA6_1105567359.addTaint(taint);
        return var2E98A2B2BD55843CF6DB1382D696DAA6_1105567359;
        case GL_FOG_COLOR:
String var3BE483CA7CFB5D5AC319778576FA59F7_576043264 =         "GL_FOG_COLOR";
        var3BE483CA7CFB5D5AC319778576FA59F7_576043264.addTaint(taint);
        return var3BE483CA7CFB5D5AC319778576FA59F7_576043264;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_1560918792 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_1560918792.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_1560918792;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_FOG_DENSITY:
            //return "GL_FOG_DENSITY";
        //case GL_FOG_START:
            //return "GL_FOG_START";
        //case GL_FOG_END:
            //return "GL_FOG_END";
        //case GL_FOG_MODE:
            //return "GL_FOG_MODE";
        //case GL_FOG_COLOR:
            //return "GL_FOG_COLOR";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.223 -0400", hash_original_method = "9A07F659DA306C4A6520A0B0A227379C", hash_generated_method = "71C6041CEC0B63627C429FC2277CA5BA")
    private int getFogParamCount(int pname) {
        addTaint(pname);
switch(pname){
        case GL_FOG_DENSITY:
        int varC4CA4238A0B923820DCC509A6F75849B_1377685277 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787497358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787497358;
        case GL_FOG_START:
        int varC4CA4238A0B923820DCC509A6F75849B_1392187438 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747130227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747130227;
        case GL_FOG_END:
        int varC4CA4238A0B923820DCC509A6F75849B_1133586478 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148542195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148542195;
        case GL_FOG_MODE:
        int varC4CA4238A0B923820DCC509A6F75849B_134561974 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998656487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998656487;
        case GL_FOG_COLOR:
        int varA87FF679A2F3E71D9181A67B7542122C_1009038973 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309782373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309782373;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_2080414682 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490275517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490275517;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_FOG_DENSITY:
            //return 1;
        //case GL_FOG_START:
            //return 1;
        //case GL_FOG_END:
            //return 1;
        //case GL_FOG_MODE:
            //return 1;
        //case GL_FOG_COLOR:
            //return 4;
        //default:
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.223 -0400", hash_original_method = "4BE9513A027CB497279D1900B720EFAA", hash_generated_method = "5B1E52596C594C43EE928A0A36263DD3")
    private String getBeginMode(int mode) {
        addTaint(mode);
switch(mode){
        case GL_POINTS:
String varF8FF3ED081F67A7F78FAFB2AA841BBBA_1634488364 =         "GL_POINTS";
        varF8FF3ED081F67A7F78FAFB2AA841BBBA_1634488364.addTaint(taint);
        return varF8FF3ED081F67A7F78FAFB2AA841BBBA_1634488364;
        case GL_LINES:
String var258B22CBC2CCC8B2B52A648C2D0015B1_1087567930 =         "GL_LINES";
        var258B22CBC2CCC8B2B52A648C2D0015B1_1087567930.addTaint(taint);
        return var258B22CBC2CCC8B2B52A648C2D0015B1_1087567930;
        case GL_LINE_LOOP:
String var8C2C6C9FA3375E9446197A639EE82D03_626315174 =         "GL_LINE_LOOP";
        var8C2C6C9FA3375E9446197A639EE82D03_626315174.addTaint(taint);
        return var8C2C6C9FA3375E9446197A639EE82D03_626315174;
        case GL_LINE_STRIP:
String var0DCDAED54DA0098E052D5B3E07BF6366_1537787654 =         "GL_LINE_STRIP";
        var0DCDAED54DA0098E052D5B3E07BF6366_1537787654.addTaint(taint);
        return var0DCDAED54DA0098E052D5B3E07BF6366_1537787654;
        case GL_TRIANGLES:
String var94CCFEDEB86799B464C29D27F67BE059_726286083 =         "GL_TRIANGLES";
        var94CCFEDEB86799B464C29D27F67BE059_726286083.addTaint(taint);
        return var94CCFEDEB86799B464C29D27F67BE059_726286083;
        case GL_TRIANGLE_STRIP:
String varE337EE2AA171E3370D61623386C5839E_619841751 =         "GL_TRIANGLE_STRIP";
        varE337EE2AA171E3370D61623386C5839E_619841751.addTaint(taint);
        return varE337EE2AA171E3370D61623386C5839E_619841751;
        case GL_TRIANGLE_FAN:
String var295E1E0E3C7978E4794E44076D873D52_1123480140 =         "GL_TRIANGLE_FAN";
        var295E1E0E3C7978E4794E44076D873D52_1123480140.addTaint(taint);
        return var295E1E0E3C7978E4794E44076D873D52_1123480140;
        default:
String var7FC1C26E2EBB1099D9597F452FB535CF_2109387062 =         getHex(mode);
        var7FC1C26E2EBB1099D9597F452FB535CF_2109387062.addTaint(taint);
        return var7FC1C26E2EBB1099D9597F452FB535CF_2109387062;
}
        // ---------- Original Method ----------
        //switch (mode) {
        //case GL_POINTS:
            //return "GL_POINTS";
        //case GL_LINES:
            //return "GL_LINES";
        //case GL_LINE_LOOP:
            //return "GL_LINE_LOOP";
        //case GL_LINE_STRIP:
            //return "GL_LINE_STRIP";
        //case GL_TRIANGLES:
            //return "GL_TRIANGLES";
        //case GL_TRIANGLE_STRIP:
            //return "GL_TRIANGLE_STRIP";
        //case GL_TRIANGLE_FAN:
            //return "GL_TRIANGLE_FAN";
        //default:
            //return getHex(mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.224 -0400", hash_original_method = "3E6AD0069200B69D18E8139DEB14B886", hash_generated_method = "F1678503ED173978713BB51C39BD2555")
    private String getIndexType(int type) {
        addTaint(type);
switch(type){
        case GL_UNSIGNED_SHORT:
String varC5F8A640D58433C0227AC117AF905C6A_1532075516 =         "GL_UNSIGNED_SHORT";
        varC5F8A640D58433C0227AC117AF905C6A_1532075516.addTaint(taint);
        return varC5F8A640D58433C0227AC117AF905C6A_1532075516;
        case GL_UNSIGNED_BYTE:
String var57BBBC4345FE1B8748CDEC045A79B6FC_1956704004 =         "GL_UNSIGNED_BYTE";
        var57BBBC4345FE1B8748CDEC045A79B6FC_1956704004.addTaint(taint);
        return var57BBBC4345FE1B8748CDEC045A79B6FC_1956704004;
        default:
String varD1FC67380EDAAC4DC9A33E588E1EDA29_1490912942 =         getHex(type);
        varD1FC67380EDAAC4DC9A33E588E1EDA29_1490912942.addTaint(taint);
        return varD1FC67380EDAAC4DC9A33E588E1EDA29_1490912942;
}
        // ---------- Original Method ----------
        //switch (type) {
        //case GL_UNSIGNED_SHORT:
            //return "GL_UNSIGNED_SHORT";
        //case GL_UNSIGNED_BYTE:
            //return "GL_UNSIGNED_BYTE";
        //default:
            //return getHex(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.224 -0400", hash_original_method = "4AD6E894CAD89C639D3AE3693A5D4F5F", hash_generated_method = "0A87FF9389D5CE6CB0CEFE0B2447DC09")
    private String getIntegerStateName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_ALPHA_BITS:
String var5ACF2DDED321BB77C708D523BF7B4ABD_1373071815 =         "GL_ALPHA_BITS";
        var5ACF2DDED321BB77C708D523BF7B4ABD_1373071815.addTaint(taint);
        return var5ACF2DDED321BB77C708D523BF7B4ABD_1373071815;
        case GL_ALIASED_LINE_WIDTH_RANGE:
String varA2A476B2A3F456072D7E073A9B997150_320177034 =         "GL_ALIASED_LINE_WIDTH_RANGE";
        varA2A476B2A3F456072D7E073A9B997150_320177034.addTaint(taint);
        return varA2A476B2A3F456072D7E073A9B997150_320177034;
        case GL_ALIASED_POINT_SIZE_RANGE:
String var3D9866D0B6F8525631A03AFC264C7072_1734599173 =         "GL_ALIASED_POINT_SIZE_RANGE";
        var3D9866D0B6F8525631A03AFC264C7072_1734599173.addTaint(taint);
        return var3D9866D0B6F8525631A03AFC264C7072_1734599173;
        case GL_BLUE_BITS:
String varC4ED1490187D5AA1CBE5B8A98E461B19_2103919032 =         "GL_BLUE_BITS";
        varC4ED1490187D5AA1CBE5B8A98E461B19_2103919032.addTaint(taint);
        return varC4ED1490187D5AA1CBE5B8A98E461B19_2103919032;
        case GL_COMPRESSED_TEXTURE_FORMATS:
String var6D1FB4A7288D4C4661A69178221EEA00_522969813 =         "GL_COMPRESSED_TEXTURE_FORMATS";
        var6D1FB4A7288D4C4661A69178221EEA00_522969813.addTaint(taint);
        return var6D1FB4A7288D4C4661A69178221EEA00_522969813;
        case GL_DEPTH_BITS:
String var9A327563085610DBC70A5D3D964AFC52_1227687085 =         "GL_DEPTH_BITS";
        var9A327563085610DBC70A5D3D964AFC52_1227687085.addTaint(taint);
        return var9A327563085610DBC70A5D3D964AFC52_1227687085;
        case GL_GREEN_BITS:
String var2AB8AB95E609DD4ABAEB52CEA17861D2_1394741023 =         "GL_GREEN_BITS";
        var2AB8AB95E609DD4ABAEB52CEA17861D2_1394741023.addTaint(taint);
        return var2AB8AB95E609DD4ABAEB52CEA17861D2_1394741023;
        case GL_MAX_ELEMENTS_INDICES:
String var1DEB4A8226B46A05FEB4302B1068BFEF_1508500800 =         "GL_MAX_ELEMENTS_INDICES";
        var1DEB4A8226B46A05FEB4302B1068BFEF_1508500800.addTaint(taint);
        return var1DEB4A8226B46A05FEB4302B1068BFEF_1508500800;
        case GL_MAX_ELEMENTS_VERTICES:
String var0ADBDF57D8D7522F8931B5F7C0F0414B_1687546147 =         "GL_MAX_ELEMENTS_VERTICES";
        var0ADBDF57D8D7522F8931B5F7C0F0414B_1687546147.addTaint(taint);
        return var0ADBDF57D8D7522F8931B5F7C0F0414B_1687546147;
        case GL_MAX_LIGHTS:
String var458339C2FA6A390D06223D149F5F6C26_631823543 =         "GL_MAX_LIGHTS";
        var458339C2FA6A390D06223D149F5F6C26_631823543.addTaint(taint);
        return var458339C2FA6A390D06223D149F5F6C26_631823543;
        case GL_MAX_TEXTURE_SIZE:
String varF4520799B9FAD262729AE64C9EB8D786_930894886 =         "GL_MAX_TEXTURE_SIZE";
        varF4520799B9FAD262729AE64C9EB8D786_930894886.addTaint(taint);
        return varF4520799B9FAD262729AE64C9EB8D786_930894886;
        case GL_MAX_VIEWPORT_DIMS:
String varE9D3668926AD6E547A0257BE37D4BCD4_968916777 =         "GL_MAX_VIEWPORT_DIMS";
        varE9D3668926AD6E547A0257BE37D4BCD4_968916777.addTaint(taint);
        return varE9D3668926AD6E547A0257BE37D4BCD4_968916777;
        case GL_MAX_MODELVIEW_STACK_DEPTH:
String varAA20655F65C9D986210CF454F2361AC3_1828564727 =         "GL_MAX_MODELVIEW_STACK_DEPTH";
        varAA20655F65C9D986210CF454F2361AC3_1828564727.addTaint(taint);
        return varAA20655F65C9D986210CF454F2361AC3_1828564727;
        case GL_MAX_PROJECTION_STACK_DEPTH:
String var9BB09DF1DF87A5FEC964586B6C9A8682_2050508251 =         "GL_MAX_PROJECTION_STACK_DEPTH";
        var9BB09DF1DF87A5FEC964586B6C9A8682_2050508251.addTaint(taint);
        return var9BB09DF1DF87A5FEC964586B6C9A8682_2050508251;
        case GL_MAX_TEXTURE_STACK_DEPTH:
String var5FE6A52AEF33CD8133A35F457A311FB0_1805918223 =         "GL_MAX_TEXTURE_STACK_DEPTH";
        var5FE6A52AEF33CD8133A35F457A311FB0_1805918223.addTaint(taint);
        return var5FE6A52AEF33CD8133A35F457A311FB0_1805918223;
        case GL_MAX_TEXTURE_UNITS:
String var962453C99D1735B2FB2FD371A183FAF7_1928991074 =         "GL_MAX_TEXTURE_UNITS";
        var962453C99D1735B2FB2FD371A183FAF7_1928991074.addTaint(taint);
        return var962453C99D1735B2FB2FD371A183FAF7_1928991074;
        case GL_NUM_COMPRESSED_TEXTURE_FORMATS:
String var441AFA33F98F6D4B5B6BF3EF73C50D2A_1519394480 =         "GL_NUM_COMPRESSED_TEXTURE_FORMATS";
        var441AFA33F98F6D4B5B6BF3EF73C50D2A_1519394480.addTaint(taint);
        return var441AFA33F98F6D4B5B6BF3EF73C50D2A_1519394480;
        case GL_RED_BITS:
String varB81CCD1E57D8008662C6A0FD8B32CA93_1257812358 =         "GL_RED_BITS";
        varB81CCD1E57D8008662C6A0FD8B32CA93_1257812358.addTaint(taint);
        return varB81CCD1E57D8008662C6A0FD8B32CA93_1257812358;
        case GL_SMOOTH_LINE_WIDTH_RANGE:
String varE2513A38476C3BFC869AFD1B632CD718_1929731757 =         "GL_SMOOTH_LINE_WIDTH_RANGE";
        varE2513A38476C3BFC869AFD1B632CD718_1929731757.addTaint(taint);
        return varE2513A38476C3BFC869AFD1B632CD718_1929731757;
        case GL_SMOOTH_POINT_SIZE_RANGE:
String var355C330DD84FFF90DC26845E03DA8A53_706192360 =         "GL_SMOOTH_POINT_SIZE_RANGE";
        var355C330DD84FFF90DC26845E03DA8A53_706192360.addTaint(taint);
        return var355C330DD84FFF90DC26845E03DA8A53_706192360;
        case GL_STENCIL_BITS:
String var8ABE853E0E48A010C95BB326268AE479_985244663 =         "GL_STENCIL_BITS";
        var8ABE853E0E48A010C95BB326268AE479_985244663.addTaint(taint);
        return var8ABE853E0E48A010C95BB326268AE479_985244663;
        case GL_SUBPIXEL_BITS:
String var25574C890933BEE3814D56EAA5AB7EA4_2143701203 =         "GL_SUBPIXEL_BITS";
        var25574C890933BEE3814D56EAA5AB7EA4_2143701203.addTaint(taint);
        return var25574C890933BEE3814D56EAA5AB7EA4_2143701203;
        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
String var97855235A0751B559981795566C54E4F_1984018943 =         "GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES";
        var97855235A0751B559981795566C54E4F_1984018943.addTaint(taint);
        return var97855235A0751B559981795566C54E4F_1984018943;
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
String varF3A9006FE9C025F0A707A2E7568D36B1_1737735980 =         "GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES";
        varF3A9006FE9C025F0A707A2E7568D36B1_1737735980.addTaint(taint);
        return varF3A9006FE9C025F0A707A2E7568D36B1_1737735980;
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
String varAD6F4332580DD01C81DD1E26A21C9188_1586337178 =         "GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES";
        varAD6F4332580DD01C81DD1E26A21C9188_1586337178.addTaint(taint);
        return varAD6F4332580DD01C81DD1E26A21C9188_1586337178;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_1349900910 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_1349900910.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_1349900910;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.227 -0400", hash_original_method = "4AADCBB739A6C2527D915F46779132DE", hash_generated_method = "0821FCF7389F6ED4E25383848B055E87")
    private int getIntegerStateSize(int pname) {
        addTaint(pname);
switch(pname){
        case GL_ALPHA_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_172668064 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060176254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060176254;
        case GL_ALIASED_LINE_WIDTH_RANGE:
        int varC81E728D9D4C2F636F067F89CC14862C_1960569508 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429850153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429850153;
        case GL_ALIASED_POINT_SIZE_RANGE:
        int varC81E728D9D4C2F636F067F89CC14862C_866431383 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012373069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012373069;
        case GL_BLUE_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_1954060019 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77806328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77806328;
        case GL_COMPRESSED_TEXTURE_FORMATS:
        {
            int[] buffer = new int[1];
            mgl.glGetIntegerv(GL_NUM_COMPRESSED_TEXTURE_FORMATS, buffer, 0);
            int var8A6BC19381673FA226DB1B0828B91CF3_1712617167 = (buffer[0]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475137279 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475137279;
        } //End block
        case GL_DEPTH_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_1124046935 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574859752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574859752;
        case GL_GREEN_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_2015060374 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500513529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500513529;
        case GL_MAX_ELEMENTS_INDICES:
        int varC4CA4238A0B923820DCC509A6F75849B_132169914 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502913456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502913456;
        case GL_MAX_ELEMENTS_VERTICES:
        int varC4CA4238A0B923820DCC509A6F75849B_1417930042 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993517779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993517779;
        case GL_MAX_LIGHTS:
        int varC4CA4238A0B923820DCC509A6F75849B_2119545018 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628527429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628527429;
        case GL_MAX_TEXTURE_SIZE:
        int varC4CA4238A0B923820DCC509A6F75849B_1680171738 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808395823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808395823;
        case GL_MAX_VIEWPORT_DIMS:
        int varC81E728D9D4C2F636F067F89CC14862C_461528407 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237616210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237616210;
        case GL_MAX_MODELVIEW_STACK_DEPTH:
        int varC4CA4238A0B923820DCC509A6F75849B_250330639 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760060560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760060560;
        case GL_MAX_PROJECTION_STACK_DEPTH:
        int varC4CA4238A0B923820DCC509A6F75849B_1881847618 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142453912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142453912;
        case GL_MAX_TEXTURE_STACK_DEPTH:
        int varC4CA4238A0B923820DCC509A6F75849B_595729490 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324110930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324110930;
        case GL_MAX_TEXTURE_UNITS:
        int varC4CA4238A0B923820DCC509A6F75849B_198494948 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547250707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547250707;
        case GL_NUM_COMPRESSED_TEXTURE_FORMATS:
        int varC4CA4238A0B923820DCC509A6F75849B_1228970329 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661773840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661773840;
        case GL_RED_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_406731873 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479637486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479637486;
        case GL_SMOOTH_LINE_WIDTH_RANGE:
        int varC81E728D9D4C2F636F067F89CC14862C_2090385547 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749093630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749093630;
        case GL_SMOOTH_POINT_SIZE_RANGE:
        int varC81E728D9D4C2F636F067F89CC14862C_596123718 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978756185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1978756185;
        case GL_STENCIL_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_331497227 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399803548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399803548;
        case GL_SUBPIXEL_BITS:
        int varC4CA4238A0B923820DCC509A6F75849B_592767343 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072625304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072625304;
        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
        int varC74D97B01EAE257E44AA9D5BADE97BAF_996483802 = (16);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679793731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679793731;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_48534935 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353041890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353041890;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.228 -0400", hash_original_method = "6506A323D3627F82CBA6E7723B0EB9F3", hash_generated_method = "09A67FAB628C203C244DD1C4888DD5C4")
    private int getIntegerStateFormat(int pname) {
        addTaint(pname);
switch(pname){
        case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
        case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
        int varE3C7E24156EB466F035FE296D33D8DD8_580487847 = (FORMAT_FLOAT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863547498 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863547498;
        default:
        int varD18D486C3BB397B01D550C691993BD8A_1531045122 = (FORMAT_INT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894415322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894415322;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES:
        //case GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES:
        //case GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES:
            //return FORMAT_FLOAT;
        //default:
            //return FORMAT_INT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.229 -0400", hash_original_method = "4D3E62DAA5E69B9689FE052B7C9786D8", hash_generated_method = "7CB73F806F3A35DB57722FC18DC67682")
    private String getHintTarget(int target) {
        addTaint(target);
switch(target){
        case GL_FOG_HINT:
String varFA690F177821447AA6D75205C5A02A38_1264127961 =         "GL_FOG_HINT";
        varFA690F177821447AA6D75205C5A02A38_1264127961.addTaint(taint);
        return varFA690F177821447AA6D75205C5A02A38_1264127961;
        case GL_LINE_SMOOTH_HINT:
String var5913352A87E92A65637EB97DD4A3A54D_957926395 =         "GL_LINE_SMOOTH_HINT";
        var5913352A87E92A65637EB97DD4A3A54D_957926395.addTaint(taint);
        return var5913352A87E92A65637EB97DD4A3A54D_957926395;
        case GL_PERSPECTIVE_CORRECTION_HINT:
String varD152170C4D1D385B63C0688D7F8E0B8D_277247700 =         "GL_PERSPECTIVE_CORRECTION_HINT";
        varD152170C4D1D385B63C0688D7F8E0B8D_277247700.addTaint(taint);
        return varD152170C4D1D385B63C0688D7F8E0B8D_277247700;
        case GL_POINT_SMOOTH_HINT:
String varA19ED7A4C93825AB71F05393141E352E_216695057 =         "GL_POINT_SMOOTH_HINT";
        varA19ED7A4C93825AB71F05393141E352E_216695057.addTaint(taint);
        return varA19ED7A4C93825AB71F05393141E352E_216695057;
        case GL_POLYGON_SMOOTH_HINT:
String var789ADDFD1BE9230171F1F5CCD233654B_425589855 =         "GL_POLYGON_SMOOTH_HINT";
        var789ADDFD1BE9230171F1F5CCD233654B_425589855.addTaint(taint);
        return var789ADDFD1BE9230171F1F5CCD233654B_425589855;
        case GL_GENERATE_MIPMAP_HINT:
String varFFF174D4713455BB0ACC0133615DC6B1_149149817 =         "GL_GENERATE_MIPMAP_HINT";
        varFFF174D4713455BB0ACC0133615DC6B1_149149817.addTaint(taint);
        return varFFF174D4713455BB0ACC0133615DC6B1_149149817;
        default:
String varC5BCCB40D483945AD16346DCD4C1BFD9_1255125845 =         getHex(target);
        varC5BCCB40D483945AD16346DCD4C1BFD9_1255125845.addTaint(taint);
        return varC5BCCB40D483945AD16346DCD4C1BFD9_1255125845;
}
        // ---------- Original Method ----------
        //switch (target) {
        //case GL_FOG_HINT:
            //return "GL_FOG_HINT";
        //case GL_LINE_SMOOTH_HINT:
            //return "GL_LINE_SMOOTH_HINT";
        //case GL_PERSPECTIVE_CORRECTION_HINT:
            //return "GL_PERSPECTIVE_CORRECTION_HINT";
        //case GL_POINT_SMOOTH_HINT:
            //return "GL_POINT_SMOOTH_HINT";
        //case GL_POLYGON_SMOOTH_HINT:
            //return "GL_POLYGON_SMOOTH_HINT";
        //case GL_GENERATE_MIPMAP_HINT:
            //return "GL_GENERATE_MIPMAP_HINT";
        //default:
            //return getHex(target);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.229 -0400", hash_original_method = "4CBC7095C8EC2BFC380BB54CFA1150A6", hash_generated_method = "B00D9378248A5B7F1108BA1A9E9EDCA0")
    private String getHintMode(int mode) {
        addTaint(mode);
switch(mode){
        case GL_FASTEST:
String var75768A0E51B2038F360FEE965BEB6278_601606339 =         "GL_FASTEST";
        var75768A0E51B2038F360FEE965BEB6278_601606339.addTaint(taint);
        return var75768A0E51B2038F360FEE965BEB6278_601606339;
        case GL_NICEST:
String var3471BC6435F2ABB5D3CBBBFE0BA3DEF9_338274626 =         "GL_NICEST";
        var3471BC6435F2ABB5D3CBBBFE0BA3DEF9_338274626.addTaint(taint);
        return var3471BC6435F2ABB5D3CBBBFE0BA3DEF9_338274626;
        case GL_DONT_CARE:
String varCDDD54166C69AE5A47A6112642182DD8_1310907629 =         "GL_DONT_CARE";
        varCDDD54166C69AE5A47A6112642182DD8_1310907629.addTaint(taint);
        return varCDDD54166C69AE5A47A6112642182DD8_1310907629;
        default:
String var7FC1C26E2EBB1099D9597F452FB535CF_185003334 =         getHex(mode);
        var7FC1C26E2EBB1099D9597F452FB535CF_185003334.addTaint(taint);
        return var7FC1C26E2EBB1099D9597F452FB535CF_185003334;
}
        // ---------- Original Method ----------
        //switch (mode) {
        //case GL_FASTEST:
            //return "GL_FASTEST";
        //case GL_NICEST:
            //return "GL_NICEST";
        //case GL_DONT_CARE:
            //return "GL_DONT_CARE";
        //default:
            //return getHex(mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.229 -0400", hash_original_method = "BE1CA8C5489B5964B68DFDD8E3046F1A", hash_generated_method = "AA93B0A3A92141D3B4265A90B604B251")
    private String getFaceName(int face) {
        addTaint(face);
switch(face){
        case GL_FRONT_AND_BACK:
String varE1B6F93855CD0F8A44382B3D3484BC1F_1780092436 =         "GL_FRONT_AND_BACK";
        varE1B6F93855CD0F8A44382B3D3484BC1F_1780092436.addTaint(taint);
        return varE1B6F93855CD0F8A44382B3D3484BC1F_1780092436;
        default:
String varD1678B9B653067F48DEDC0D2C1EFDF64_374027785 =         getHex(face);
        varD1678B9B653067F48DEDC0D2C1EFDF64_374027785.addTaint(taint);
        return varD1678B9B653067F48DEDC0D2C1EFDF64_374027785;
}
        // ---------- Original Method ----------
        //switch (face) {
        //case GL_FRONT_AND_BACK:
            //return "GL_FRONT_AND_BACK";
        //default:
            //return getHex(face);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.230 -0400", hash_original_method = "AA6E7FD439F75BBDF66BBAE581FA29DC", hash_generated_method = "B566B134FDEC3AB75825584BA0BFED11")
    private String getMaterialPName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_AMBIENT:
String varFDACBE6EE05B67ED6B133D9C184DD891_122384491 =         "GL_AMBIENT";
        varFDACBE6EE05B67ED6B133D9C184DD891_122384491.addTaint(taint);
        return varFDACBE6EE05B67ED6B133D9C184DD891_122384491;
        case GL_DIFFUSE:
String var360AE1406453D217A450CFAC442765B2_546984377 =         "GL_DIFFUSE";
        var360AE1406453D217A450CFAC442765B2_546984377.addTaint(taint);
        return var360AE1406453D217A450CFAC442765B2_546984377;
        case GL_SPECULAR:
String var880B3D11071001AEE945D9FEF804907B_564422653 =         "GL_SPECULAR";
        var880B3D11071001AEE945D9FEF804907B_564422653.addTaint(taint);
        return var880B3D11071001AEE945D9FEF804907B_564422653;
        case GL_EMISSION:
String varDB0C75AA8062C6BED0F44F2FE786DB4F_944855712 =         "GL_EMISSION";
        varDB0C75AA8062C6BED0F44F2FE786DB4F_944855712.addTaint(taint);
        return varDB0C75AA8062C6BED0F44F2FE786DB4F_944855712;
        case GL_SHININESS:
String var42BD19B4065E0A4251E79EB5E9B3F8D1_107290188 =         "GL_SHININESS";
        var42BD19B4065E0A4251E79EB5E9B3F8D1_107290188.addTaint(taint);
        return var42BD19B4065E0A4251E79EB5E9B3F8D1_107290188;
        case GL_AMBIENT_AND_DIFFUSE:
String var91149B6AD16CEF3EDEB3E58B682B6596_121263674 =         "GL_AMBIENT_AND_DIFFUSE";
        var91149B6AD16CEF3EDEB3E58B682B6596_121263674.addTaint(taint);
        return var91149B6AD16CEF3EDEB3E58B682B6596_121263674;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_167681089 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_167681089.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_167681089;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_AMBIENT:
            //return "GL_AMBIENT";
        //case GL_DIFFUSE:
            //return "GL_DIFFUSE";
        //case GL_SPECULAR:
            //return "GL_SPECULAR";
        //case GL_EMISSION:
            //return "GL_EMISSION";
        //case GL_SHININESS:
            //return "GL_SHININESS";
        //case GL_AMBIENT_AND_DIFFUSE:
            //return "GL_AMBIENT_AND_DIFFUSE";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.230 -0400", hash_original_method = "B0395F459DFDFEE2447C01CFFCEE6702", hash_generated_method = "88F75986EF0CB8687CE2B183DC739500")
    private int getMaterialParamCount(int pname) {
        addTaint(pname);
switch(pname){
        case GL_AMBIENT:
        int varA87FF679A2F3E71D9181A67B7542122C_2056082548 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464687543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464687543;
        case GL_DIFFUSE:
        int varA87FF679A2F3E71D9181A67B7542122C_1304255189 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303532165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303532165;
        case GL_SPECULAR:
        int varA87FF679A2F3E71D9181A67B7542122C_1043477528 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154449717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154449717;
        case GL_EMISSION:
        int varA87FF679A2F3E71D9181A67B7542122C_42385535 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270331684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270331684;
        case GL_SHININESS:
        int varC4CA4238A0B923820DCC509A6F75849B_1640975128 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534920580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534920580;
        case GL_AMBIENT_AND_DIFFUSE:
        int varA87FF679A2F3E71D9181A67B7542122C_1351276569 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538316148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538316148;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_148623793 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356558387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356558387;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_AMBIENT:
            //return 4;
        //case GL_DIFFUSE:
            //return 4;
        //case GL_SPECULAR:
            //return 4;
        //case GL_EMISSION:
            //return 4;
        //case GL_SHININESS:
            //return 1;
        //case GL_AMBIENT_AND_DIFFUSE:
            //return 4;
        //default:
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.231 -0400", hash_original_method = "1120552551378876CBD5B26DC66EC81D", hash_generated_method = "5AF3544803EC6F958AA63D9650EFCBB4")
    private String getLightName(int light) {
        addTaint(light);
    if(light >= GL_LIGHT0 && light <= GL_LIGHT7)        
        {
String var054439158506CBA8A39A80227C5487C2_1398567920 =             "GL_LIGHT" + Integer.toString(light);
            var054439158506CBA8A39A80227C5487C2_1398567920.addTaint(taint);
            return var054439158506CBA8A39A80227C5487C2_1398567920;
        } //End block
String varA56BF31A21B14BF74666C55011828245_1687023895 =         getHex(light);
        varA56BF31A21B14BF74666C55011828245_1687023895.addTaint(taint);
        return varA56BF31A21B14BF74666C55011828245_1687023895;
        // ---------- Original Method ----------
        //if (light >= GL_LIGHT0 && light <= GL_LIGHT7) {
            //return "GL_LIGHT" + Integer.toString(light);
        //}
        //return getHex(light);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.231 -0400", hash_original_method = "3E656EADB323CE9823F4DF06359C055F", hash_generated_method = "E287564B30CE873D17FC170D9CC7D11D")
    private String getLightPName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_AMBIENT:
String varFDACBE6EE05B67ED6B133D9C184DD891_255384592 =         "GL_AMBIENT";
        varFDACBE6EE05B67ED6B133D9C184DD891_255384592.addTaint(taint);
        return varFDACBE6EE05B67ED6B133D9C184DD891_255384592;
        case GL_DIFFUSE:
String var360AE1406453D217A450CFAC442765B2_268583476 =         "GL_DIFFUSE";
        var360AE1406453D217A450CFAC442765B2_268583476.addTaint(taint);
        return var360AE1406453D217A450CFAC442765B2_268583476;
        case GL_SPECULAR:
String var880B3D11071001AEE945D9FEF804907B_1464191720 =         "GL_SPECULAR";
        var880B3D11071001AEE945D9FEF804907B_1464191720.addTaint(taint);
        return var880B3D11071001AEE945D9FEF804907B_1464191720;
        case GL_POSITION:
String var3D358CF5ED7B1170B081BE29DC843FD4_657246200 =         "GL_POSITION";
        var3D358CF5ED7B1170B081BE29DC843FD4_657246200.addTaint(taint);
        return var3D358CF5ED7B1170B081BE29DC843FD4_657246200;
        case GL_SPOT_DIRECTION:
String var76225BFB33FAF1E3F6B7A6B32F85B5F8_641724248 =         "GL_SPOT_DIRECTION";
        var76225BFB33FAF1E3F6B7A6B32F85B5F8_641724248.addTaint(taint);
        return var76225BFB33FAF1E3F6B7A6B32F85B5F8_641724248;
        case GL_SPOT_EXPONENT:
String var2F938C17B7B59042D6697CAA267906AC_502664003 =         "GL_SPOT_EXPONENT";
        var2F938C17B7B59042D6697CAA267906AC_502664003.addTaint(taint);
        return var2F938C17B7B59042D6697CAA267906AC_502664003;
        case GL_SPOT_CUTOFF:
String var81D580DE9CAF3458172D1077FE79CA2D_1220667423 =         "GL_SPOT_CUTOFF";
        var81D580DE9CAF3458172D1077FE79CA2D_1220667423.addTaint(taint);
        return var81D580DE9CAF3458172D1077FE79CA2D_1220667423;
        case GL_CONSTANT_ATTENUATION:
String var801F05315269D80CBE75711103DFE775_1349634201 =         "GL_CONSTANT_ATTENUATION";
        var801F05315269D80CBE75711103DFE775_1349634201.addTaint(taint);
        return var801F05315269D80CBE75711103DFE775_1349634201;
        case GL_LINEAR_ATTENUATION:
String varD69BB3A76957EE510F4C162DE08D10AC_569781689 =         "GL_LINEAR_ATTENUATION";
        varD69BB3A76957EE510F4C162DE08D10AC_569781689.addTaint(taint);
        return varD69BB3A76957EE510F4C162DE08D10AC_569781689;
        case GL_QUADRATIC_ATTENUATION:
String var8A87A9BFA9A63F0E1DFDF9AB4FC48DB7_173662986 =         "GL_QUADRATIC_ATTENUATION";
        var8A87A9BFA9A63F0E1DFDF9AB4FC48DB7_173662986.addTaint(taint);
        return var8A87A9BFA9A63F0E1DFDF9AB4FC48DB7_173662986;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_1794535072 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_1794535072.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_1794535072;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_AMBIENT:
            //return "GL_AMBIENT";
        //case GL_DIFFUSE:
            //return "GL_DIFFUSE";
        //case GL_SPECULAR:
            //return "GL_SPECULAR";
        //case GL_POSITION:
            //return "GL_POSITION";
        //case GL_SPOT_DIRECTION:
            //return "GL_SPOT_DIRECTION";
        //case GL_SPOT_EXPONENT:
            //return "GL_SPOT_EXPONENT";
        //case GL_SPOT_CUTOFF:
            //return "GL_SPOT_CUTOFF";
        //case GL_CONSTANT_ATTENUATION:
            //return "GL_CONSTANT_ATTENUATION";
        //case GL_LINEAR_ATTENUATION:
            //return "GL_LINEAR_ATTENUATION";
        //case GL_QUADRATIC_ATTENUATION:
            //return "GL_QUADRATIC_ATTENUATION";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.232 -0400", hash_original_method = "53908AF1FF50B43C5A4BA064020594CA", hash_generated_method = "4D32D5E0FC7904F20B285F9995643BE8")
    private int getLightParamCount(int pname) {
        addTaint(pname);
switch(pname){
        case GL_AMBIENT:
        int varA87FF679A2F3E71D9181A67B7542122C_1284573444 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561078685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561078685;
        case GL_DIFFUSE:
        int varA87FF679A2F3E71D9181A67B7542122C_1606468788 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991024561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991024561;
        case GL_SPECULAR:
        int varA87FF679A2F3E71D9181A67B7542122C_760207277 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359476565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359476565;
        case GL_POSITION:
        int varA87FF679A2F3E71D9181A67B7542122C_956519192 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646439870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646439870;
        case GL_SPOT_DIRECTION:
        int varECCBC87E4B5CE2FE28308FD9F2A7BAF3_1342224952 = (3);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915610380 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915610380;
        case GL_SPOT_EXPONENT:
        int varC4CA4238A0B923820DCC509A6F75849B_836097512 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60417472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60417472;
        case GL_SPOT_CUTOFF:
        int varC4CA4238A0B923820DCC509A6F75849B_420655951 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204466053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204466053;
        case GL_CONSTANT_ATTENUATION:
        int varC4CA4238A0B923820DCC509A6F75849B_1083472966 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759304261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759304261;
        case GL_LINEAR_ATTENUATION:
        int varC4CA4238A0B923820DCC509A6F75849B_2079235586 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422745546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422745546;
        case GL_QUADRATIC_ATTENUATION:
        int varC4CA4238A0B923820DCC509A6F75849B_1392305554 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811572876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811572876;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_1297592061 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355721372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355721372;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_AMBIENT:
            //return 4;
        //case GL_DIFFUSE:
            //return 4;
        //case GL_SPECULAR:
            //return 4;
        //case GL_POSITION:
            //return 4;
        //case GL_SPOT_DIRECTION:
            //return 3;
        //case GL_SPOT_EXPONENT:
            //return 1;
        //case GL_SPOT_CUTOFF:
            //return 1;
        //case GL_CONSTANT_ATTENUATION:
            //return 1;
        //case GL_LINEAR_ATTENUATION:
            //return 1;
        //case GL_QUADRATIC_ATTENUATION:
            //return 1;
        //default:
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.232 -0400", hash_original_method = "E7E2148BEA6DA3A2392A3015CEC490ED", hash_generated_method = "DB0707C369BBA755E15FDFFDD100415C")
    private String getLightModelPName(int pname) {
        addTaint(pname);
switch(pname){
        case GL_LIGHT_MODEL_AMBIENT:
String var3F04652D221AF877BF1B0065402449C4_360129024 =         "GL_LIGHT_MODEL_AMBIENT";
        var3F04652D221AF877BF1B0065402449C4_360129024.addTaint(taint);
        return var3F04652D221AF877BF1B0065402449C4_360129024;
        case GL_LIGHT_MODEL_TWO_SIDE:
String varF68EE1CE6BA72926858517BDE3EF100B_586027854 =         "GL_LIGHT_MODEL_TWO_SIDE";
        varF68EE1CE6BA72926858517BDE3EF100B_586027854.addTaint(taint);
        return varF68EE1CE6BA72926858517BDE3EF100B_586027854;
        default:
String var17EB31AEABC63CBC4D8F00A7873C8076_575439550 =         getHex(pname);
        var17EB31AEABC63CBC4D8F00A7873C8076_575439550.addTaint(taint);
        return var17EB31AEABC63CBC4D8F00A7873C8076_575439550;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_LIGHT_MODEL_AMBIENT:
            //return "GL_LIGHT_MODEL_AMBIENT";
        //case GL_LIGHT_MODEL_TWO_SIDE:
            //return "GL_LIGHT_MODEL_TWO_SIDE";
        //default:
            //return getHex(pname);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.233 -0400", hash_original_method = "2FC4AD179486887F278ED181B7A670E7", hash_generated_method = "F17CFCF4A7D48BB6A62426163E473FFB")
    private int getLightModelParamCount(int pname) {
        addTaint(pname);
switch(pname){
        case GL_LIGHT_MODEL_AMBIENT:
        int varA87FF679A2F3E71D9181A67B7542122C_303311587 = (4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375238617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375238617;
        case GL_LIGHT_MODEL_TWO_SIDE:
        int varC4CA4238A0B923820DCC509A6F75849B_1422299830 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990466102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990466102;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_1983690896 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030775783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030775783;
}
        // ---------- Original Method ----------
        //switch (pname) {
        //case GL_LIGHT_MODEL_AMBIENT:
            //return 4;
        //case GL_LIGHT_MODEL_TWO_SIDE:
            //return 1;
        //default:
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.234 -0400", hash_original_method = "B46D74FDB30D00E40B69968F15E78E9C", hash_generated_method = "36DF8A9CE812F4FD9BE783E6A2AD5DBA")
    private String getPointerTypeName(int type) {
        addTaint(type);
switch(type){
        case GL_BYTE:
String varD12E2D847F139BC29754CC81AEE3DDD1_703688626 =         "GL_BYTE";
        varD12E2D847F139BC29754CC81AEE3DDD1_703688626.addTaint(taint);
        return varD12E2D847F139BC29754CC81AEE3DDD1_703688626;
        case GL_UNSIGNED_BYTE:
String var57BBBC4345FE1B8748CDEC045A79B6FC_184221804 =         "GL_UNSIGNED_BYTE";
        var57BBBC4345FE1B8748CDEC045A79B6FC_184221804.addTaint(taint);
        return var57BBBC4345FE1B8748CDEC045A79B6FC_184221804;
        case GL_SHORT:
String var47E45700BAD2D2F616B44CDEA2BB8334_1217102539 =         "GL_SHORT";
        var47E45700BAD2D2F616B44CDEA2BB8334_1217102539.addTaint(taint);
        return var47E45700BAD2D2F616B44CDEA2BB8334_1217102539;
        case GL_FIXED:
String varFA520E2580C2A821532573F53E93B9AC_1604742320 =         "GL_FIXED";
        varFA520E2580C2A821532573F53E93B9AC_1604742320.addTaint(taint);
        return varFA520E2580C2A821532573F53E93B9AC_1604742320;
        case GL_FLOAT:
String var3AD5420291D028815380D9165DF30534_1805161101 =         "GL_FLOAT";
        var3AD5420291D028815380D9165DF30534_1805161101.addTaint(taint);
        return var3AD5420291D028815380D9165DF30534_1805161101;
        default:
String varD1FC67380EDAAC4DC9A33E588E1EDA29_1124764355 =         getHex(type);
        varD1FC67380EDAAC4DC9A33E588E1EDA29_1124764355.addTaint(taint);
        return varD1FC67380EDAAC4DC9A33E588E1EDA29_1124764355;
}
        // ---------- Original Method ----------
        //switch (type) {
        //case GL_BYTE:
            //return "GL_BYTE";
        //case GL_UNSIGNED_BYTE:
            //return "GL_UNSIGNED_BYTE";
        //case GL_SHORT:
            //return "GL_SHORT";
        //case GL_FIXED:
            //return "GL_FIXED";
        //case GL_FLOAT:
            //return "GL_FLOAT";
        //default:
            //return getHex(type);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.245 -0400", hash_original_method = "264061652DFBCDB545DDBBFC810F3CBE", hash_generated_method = "D6A6C3F7ADF85FDA9766F2B8039710CD")
    private ByteBuffer toByteBuffer(int byteCount, Buffer input) {
        addTaint(input.getTaint());
        addTaint(byteCount);
        ByteBuffer result = null;
        boolean convertWholeBuffer = (byteCount < 0);
    if(input instanceof ByteBuffer)        
        {
            ByteBuffer input2 = (ByteBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = input2.limit() - position;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
for(int i = 0;i < byteCount;i++)
            {
                result.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof CharBuffer)        
        {
            CharBuffer input2 = (CharBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position) * 2;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            CharBuffer result2 = result.asCharBuffer();
for(int i = 0;i < byteCount / 2;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof ShortBuffer)        
        {
            ShortBuffer input2 = (ShortBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position)* 2;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            ShortBuffer result2 = result.asShortBuffer();
for(int i = 0;i < byteCount / 2;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof IntBuffer)        
        {
            IntBuffer input2 = (IntBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position) * 4;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            IntBuffer result2 = result.asIntBuffer();
for(int i = 0;i < byteCount / 4;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof FloatBuffer)        
        {
            FloatBuffer input2 = (FloatBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position) * 4;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            FloatBuffer result2 = result.asFloatBuffer();
for(int i = 0;i < byteCount / 4;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof DoubleBuffer)        
        {
            DoubleBuffer input2 = (DoubleBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position) * 8;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            DoubleBuffer result2 = result.asDoubleBuffer();
for(int i = 0;i < byteCount / 8;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
    if(input instanceof LongBuffer)        
        {
            LongBuffer input2 = (LongBuffer) input;
            int position = input2.position();
    if(convertWholeBuffer)            
            {
                byteCount = (input2.limit() - position) * 8;
            } //End block
            result = ByteBuffer.allocate(byteCount).order(input2.order());
            LongBuffer result2 = result.asLongBuffer();
for(int i = 0;i < byteCount / 8;i++)
            {
                result2.put(input2.get());
            } //End block
            input2.position(position);
        } //End block
        else
        {
            RuntimeException varCB5E332CEC15D5BC2E552D3AE6650C14_513938529 = new RuntimeException("Unimplemented Buffer subclass.");
            varCB5E332CEC15D5BC2E552D3AE6650C14_513938529.addTaint(taint);
            throw varCB5E332CEC15D5BC2E552D3AE6650C14_513938529;
        } //End block
        result.rewind();
        result.order(ByteOrder.nativeOrder());
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_2016967994 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2016967994.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2016967994;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.247 -0400", hash_original_method = "C8E7852B6B6AC81F3528792CCE165447", hash_generated_method = "0FBEB931CB72EDD2FDE78390DED97D46")
    private char[] toCharIndices(int count, int type, Buffer indices) {
        addTaint(indices.getTaint());
        addTaint(type);
        addTaint(count);
        char[] result = new char[count];
switch(type){
        case GL_UNSIGNED_BYTE:
        {
            ByteBuffer byteBuffer = toByteBuffer(count, indices);
            byte[] array = byteBuffer.array();
            int offset = byteBuffer.arrayOffset();
for(int i = 0;i < count;i++)
            {
                result[i] = (char) (0xff & array[offset + i]);
            } //End block
        } //End block
        break;
        case GL_UNSIGNED_SHORT:
        {
            CharBuffer charBuffer;
    if(indices instanceof CharBuffer)            
            {
                charBuffer = (CharBuffer) indices;
            } //End block
            else
            {
                ByteBuffer byteBuffer = toByteBuffer(count * 2, indices);
                charBuffer = byteBuffer.asCharBuffer();
            } //End block
            int oldPosition = charBuffer.position();
            charBuffer.position(0);
            charBuffer.get(result);
            charBuffer.position(oldPosition);
        } //End block
        break;
        default:
        break;
}        char[] varB4A88417B3D0170D754C647C30B7216A_151823506 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_2015148537 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2015148537;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.249 -0400", hash_original_method = "9E2FED0978BD5C803285B27767A7E21D", hash_generated_method = "03CB6FAB1EF19B43493741CA5F919E46")
    private void doArrayElement(StringBuilder builder, boolean enabled,
            String name, PointerInfo pointer, int index) {
        addTaint(index);
        addTaint(pointer.getTaint());
        addTaint(name.getTaint());
        addTaint(enabled);
        addTaint(builder.getTaint());
    if(!enabled)        
        {
            return;
        } //End block
        builder.append(" ");
        builder.append(name + ":{");
    if(pointer == null || pointer.mTempByteBuffer == null)        
        {
            builder.append("undefined }");
            return;
        } //End block
    if(pointer.mStride < 0)        
        {
            builder.append("invalid stride");
            return;
        } //End block
        int stride = pointer.getStride();
        ByteBuffer byteBuffer = pointer.mTempByteBuffer;
        int size = pointer.mSize;
        int type = pointer.mType;
        int sizeofType = pointer.sizeof(type);
        int byteOffset = stride * index;
for(int i = 0;i < size;i++)
        {
    if(i > 0)            
            {
                builder.append(", ");
            } //End block
switch(type){
            case GL_BYTE:
            {
                byte d = byteBuffer.get(byteOffset);
                builder.append(Integer.toString(d));
            } //End block
            break;
            case GL_UNSIGNED_BYTE:
            {
                byte d = byteBuffer.get(byteOffset);
                builder.append(Integer.toString(0xff & d));
            } //End block
            break;
            case GL_SHORT:
            {
                ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
                short d = shortBuffer.get(byteOffset / 2);
                builder.append(Integer.toString(d));
            } //End block
            break;
            case GL_FIXED:
            {
                IntBuffer intBuffer = byteBuffer.asIntBuffer();
                int d = intBuffer.get(byteOffset / 4);
                builder.append(Integer.toString(d));
            } //End block
            break;
            case GL_FLOAT:
            {
                FloatBuffer intBuffer = byteBuffer.asFloatBuffer();
                float d = intBuffer.get(byteOffset / 4);
                builder.append(Float.toString(d));
            } //End block
            break;
            default:
            builder.append("?");
            break;
}            byteOffset += sizeofType;
        } //End block
        builder.append("}");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.250 -0400", hash_original_method = "18ED24BBE3A59BF79B22AC9820775324", hash_generated_method = "A466AEF7D70AFCF204929B83564F867D")
    private void doElement(StringBuilder builder, int ordinal, int vertexIndex) {
        addTaint(vertexIndex);
        addTaint(ordinal);
        addTaint(builder.getTaint());
        builder.append(" [" + ordinal + " : " + vertexIndex + "] =");
        doArrayElement(builder, mVertexArrayEnabled, "v", mVertexPointer,
                vertexIndex);
        doArrayElement(builder, mNormalArrayEnabled, "n", mNormalPointer,
                vertexIndex);
        doArrayElement(builder, mColorArrayEnabled, "c", mColorPointer,
                vertexIndex);
        doArrayElement(builder, mTextureCoordArrayEnabled, "t",
                mTexCoordPointer, vertexIndex);
        builder.append("\n");
        // ---------- Original Method ----------
        //builder.append(" [" + ordinal + " : " + vertexIndex + "] =");
        //doArrayElement(builder, mVertexArrayEnabled, "v", mVertexPointer,
                //vertexIndex);
        //doArrayElement(builder, mNormalArrayEnabled, "n", mNormalPointer,
                //vertexIndex);
        //doArrayElement(builder, mColorArrayEnabled, "c", mColorPointer,
                //vertexIndex);
        //doArrayElement(builder, mTextureCoordArrayEnabled, "t",
                //mTexCoordPointer, vertexIndex);
        //builder.append("\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.250 -0400", hash_original_method = "77D79B214B9356E4551CAEF16D65F140", hash_generated_method = "7D35DDA55AEDC27B661B5C22E1D4A896")
    private void bindArrays() {
    if(mColorArrayEnabled)        
        mColorPointer.bindByteBuffer();
    if(mNormalArrayEnabled)        
        mNormalPointer.bindByteBuffer();
    if(mTextureCoordArrayEnabled)        
        mTexCoordPointer.bindByteBuffer();
    if(mVertexArrayEnabled)        
        mVertexPointer.bindByteBuffer();
        // ---------- Original Method ----------
        //if (mColorArrayEnabled)
            //mColorPointer.bindByteBuffer();
        //if (mNormalArrayEnabled)
            //mNormalPointer.bindByteBuffer();
        //if (mTextureCoordArrayEnabled)
            //mTexCoordPointer.bindByteBuffer();
        //if (mVertexArrayEnabled)
            //mVertexPointer.bindByteBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.251 -0400", hash_original_method = "2D64969A785416C0A5F6948AE4F12F17", hash_generated_method = "769FF29C057685CB2B59B20529BEB7E3")
    private void unbindArrays() {
    if(mColorArrayEnabled)        
        mColorPointer.unbindByteBuffer();
    if(mNormalArrayEnabled)        
        mNormalPointer.unbindByteBuffer();
    if(mTextureCoordArrayEnabled)        
        mTexCoordPointer.unbindByteBuffer();
    if(mVertexArrayEnabled)        
        mVertexPointer.unbindByteBuffer();
        // ---------- Original Method ----------
        //if (mColorArrayEnabled)
            //mColorPointer.unbindByteBuffer();
        //if (mNormalArrayEnabled)
            //mNormalPointer.unbindByteBuffer();
        //if (mTextureCoordArrayEnabled)
            //mTexCoordPointer.unbindByteBuffer();
        //if (mVertexArrayEnabled)
            //mVertexPointer.unbindByteBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.251 -0400", hash_original_method = "8BEFE81F11FDFA0803FB840CFDBECE18", hash_generated_method = "62219D2A0CE0F6E5159B158DB282AB47")
    private void startLogIndices() {
        mStringBuilder = new StringBuilder();
        mStringBuilder.append("\n");
        bindArrays();
        // ---------- Original Method ----------
        //mStringBuilder = new StringBuilder();
        //mStringBuilder.append("\n");
        //bindArrays();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.251 -0400", hash_original_method = "D9D1714867A0E29CB1E483FA3BEF276D", hash_generated_method = "7DFED89D747BA06C9971FF312944F5EA")
    private void endLogIndices() {
        log(mStringBuilder.toString());
        unbindArrays();
        // ---------- Original Method ----------
        //log(mStringBuilder.toString());
        //unbindArrays();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.252 -0400", hash_original_method = "8567ECC1E9E342CC5CB7FB31476FB01D", hash_generated_method = "EF3504FE8E55B1C705775736FCBC6B53")
    public void glActiveTexture(int texture) {
        addTaint(texture);
        begin("glActiveTexture");
        arg("texture", texture);
        end();
        mgl.glActiveTexture(texture);
        checkError();
        // ---------- Original Method ----------
        //begin("glActiveTexture");
        //arg("texture", texture);
        //end();
        //mgl.glActiveTexture(texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.252 -0400", hash_original_method = "0725FDE76DEF9A8A399D8C991E3F0B9C", hash_generated_method = "D6BD478A8D1CC1037A3009AECD004C66")
    public void glAlphaFunc(int func, float ref) {
        addTaint(ref);
        addTaint(func);
        begin("glAlphaFunc");
        arg("func", func);
        arg("ref", ref);
        end();
        mgl.glAlphaFunc(func, ref);
        checkError();
        // ---------- Original Method ----------
        //begin("glAlphaFunc");
        //arg("func", func);
        //arg("ref", ref);
        //end();
        //mgl.glAlphaFunc(func, ref);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.252 -0400", hash_original_method = "8B2A6A1FA66E5C47953D46C94A5964A1", hash_generated_method = "5DD1AE8B00C3F4635293E99646634324")
    public void glAlphaFuncx(int func, int ref) {
        addTaint(ref);
        addTaint(func);
        begin("glAlphaFuncx");
        arg("func", func);
        arg("ref", ref);
        end();
        mgl.glAlphaFuncx(func, ref);
        checkError();
        // ---------- Original Method ----------
        //begin("glAlphaFuncx");
        //arg("func", func);
        //arg("ref", ref);
        //end();
        //mgl.glAlphaFuncx(func, ref);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.253 -0400", hash_original_method = "2496CCD38076BE2E29CA5ED8924E8FF4", hash_generated_method = "E38AA0566AD67B95A29AE9789E985387")
    public void glBindTexture(int target, int texture) {
        addTaint(texture);
        addTaint(target);
        begin("glBindTexture");
        arg("target", getTextureTarget(target));
        arg("texture", texture);
        end();
        mgl.glBindTexture(target, texture);
        checkError();
        // ---------- Original Method ----------
        //begin("glBindTexture");
        //arg("target", getTextureTarget(target));
        //arg("texture", texture);
        //end();
        //mgl.glBindTexture(target, texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.253 -0400", hash_original_method = "0DC054B8BC438D7CFE9ABA322CEC8552", hash_generated_method = "B12F1493C8414C99DC1C74F5830F4BD5")
    public void glBlendFunc(int sfactor, int dfactor) {
        addTaint(dfactor);
        addTaint(sfactor);
        begin("glBlendFunc");
        arg("sfactor", getFactor(sfactor));
        arg("dfactor", getFactor(dfactor));
        end();
        mgl.glBlendFunc(sfactor, dfactor);
        checkError();
        // ---------- Original Method ----------
        //begin("glBlendFunc");
        //arg("sfactor", getFactor(sfactor));
        //arg("dfactor", getFactor(dfactor));
        //end();
        //mgl.glBlendFunc(sfactor, dfactor);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.253 -0400", hash_original_method = "DAAFDFBAA0B614EDE64AD30A9A6E435C", hash_generated_method = "261075F4F1D7C0CD495FB716B6AE4B75")
    public void glClear(int mask) {
        addTaint(mask);
        begin("glClear");
        arg("mask", getClearBufferMask(mask));
        end();
        mgl.glClear(mask);
        checkError();
        // ---------- Original Method ----------
        //begin("glClear");
        //arg("mask", getClearBufferMask(mask));
        //end();
        //mgl.glClear(mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.254 -0400", hash_original_method = "5FC26FF6CD80F973822B829D90EC13B7", hash_generated_method = "F7A34C2AE6D2124483AEAFDED1432C28")
    public void glClearColor(float red, float green, float blue, float alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glClearColor");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl.glClearColor(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glClearColor");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl.glClearColor(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.254 -0400", hash_original_method = "E2509AF8FA7B5B572B3BAE8F7D333138", hash_generated_method = "95B005EF246EA379359C8ABCFED6D257")
    public void glClearColorx(int red, int green, int blue, int alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glClearColor");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl.glClearColorx(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glClearColor");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl.glClearColorx(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.254 -0400", hash_original_method = "3A25B6FEC6D86140F22D47BB1DDC177A", hash_generated_method = "1CCF46E881ADD7495BF654104816C761")
    public void glClearDepthf(float depth) {
        addTaint(depth);
        begin("glClearDepthf");
        arg("depth", depth);
        end();
        mgl.glClearDepthf(depth);
        checkError();
        // ---------- Original Method ----------
        //begin("glClearDepthf");
        //arg("depth", depth);
        //end();
        //mgl.glClearDepthf(depth);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.254 -0400", hash_original_method = "4BD589682D48F3C7707333082B6EC6AD", hash_generated_method = "13595CEFF5766E70560B3C55FB0FD5B4")
    public void glClearDepthx(int depth) {
        addTaint(depth);
        begin("glClearDepthx");
        arg("depth", depth);
        end();
        mgl.glClearDepthx(depth);
        checkError();
        // ---------- Original Method ----------
        //begin("glClearDepthx");
        //arg("depth", depth);
        //end();
        //mgl.glClearDepthx(depth);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.255 -0400", hash_original_method = "C7BEC8E54C7C957D6E7E3E016A6FE1BA", hash_generated_method = "77F8A926A08A5E255AFFD2F0AF3CDF28")
    public void glClearStencil(int s) {
        addTaint(s);
        begin("glClearStencil");
        arg("s", s);
        end();
        mgl.glClearStencil(s);
        checkError();
        // ---------- Original Method ----------
        //begin("glClearStencil");
        //arg("s", s);
        //end();
        //mgl.glClearStencil(s);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.255 -0400", hash_original_method = "DDCE3AF31C0959191021E8C7743FFE7F", hash_generated_method = "49DBD2E06B46096611F7437C316DC324")
    public void glClientActiveTexture(int texture) {
        addTaint(texture);
        begin("glClientActiveTexture");
        arg("texture", texture);
        end();
        mgl.glClientActiveTexture(texture);
        checkError();
        // ---------- Original Method ----------
        //begin("glClientActiveTexture");
        //arg("texture", texture);
        //end();
        //mgl.glClientActiveTexture(texture);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.255 -0400", hash_original_method = "6D76049DA5F77453E4E9D5A87906CC2F", hash_generated_method = "D96DE4EB86A195D39C7508061FFCE0DD")
    public void glColor4f(float red, float green, float blue, float alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glColor4f");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl.glColor4f(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glColor4f");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl.glColor4f(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.256 -0400", hash_original_method = "BE66C4ED7282BD136506403FACE26B19", hash_generated_method = "F6EF3FFF0C9EEB6A63ABB1CF32A00A0F")
    public void glColor4x(int red, int green, int blue, int alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glColor4x");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl.glColor4x(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glColor4x");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl.glColor4x(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.257 -0400", hash_original_method = "870742C84E0B72750B196AA2FF1325D8", hash_generated_method = "DC254ABB193028D8D158E18A22839AEB")
    public void glColorMask(boolean red, boolean green, boolean blue,
            boolean alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glColorMask");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl.glColorMask(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glColorMask");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl.glColorMask(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.258 -0400", hash_original_method = "F9F0FDA519223D64121F8A9877DB530E", hash_generated_method = "E7D45278A151993656DE9461428BC683")
    public void glColorPointer(int size, int type, int stride, Buffer pointer) {
        begin("glColorPointer");
        argPointer(size, type, stride, pointer);
        end();
        mColorPointer = new PointerInfo(size, type, stride, pointer);
        mgl.glColorPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glColorPointer");
        //argPointer(size, type, stride, pointer);
        //end();
        //mColorPointer = new PointerInfo(size, type, stride, pointer);
        //mgl.glColorPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.259 -0400", hash_original_method = "17D3A67B77DD369DD4ABAC1595F31E23", hash_generated_method = "431A5A9265052A1C7E332E146033CE93")
    public void glCompressedTexImage2D(int target, int level,
            int internalformat, int width, int height, int border,
            int imageSize, Buffer data) {
        addTaint(data.getTaint());
        addTaint(imageSize);
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        begin("glCompressedTexImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        arg("imageSize", imageSize);
        arg("data", data.toString());
        end();
        mgl.glCompressedTexImage2D(target, level, internalformat, width,
                height, border, imageSize, data);
        checkError();
        // ---------- Original Method ----------
        //begin("glCompressedTexImage2D");
        //arg("target", getTextureTarget(target));
        //arg("level", level);
        //arg("internalformat", internalformat);
        //arg("width", width);
        //arg("height", height);
        //arg("border", border);
        //arg("imageSize", imageSize);
        //arg("data", data.toString());
        //end();
        //mgl.glCompressedTexImage2D(target, level, internalformat, width,
                //height, border, imageSize, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.260 -0400", hash_original_method = "CEDB97427223E63C4F16F0E556BB55B7", hash_generated_method = "0D67B4984D3973E40D6B12E745A4414C")
    public void glCompressedTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int imageSize,
            Buffer data) {
        addTaint(data.getTaint());
        addTaint(imageSize);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        begin("glCompressedTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("imageSize", imageSize);
        arg("data", data.toString());
        end();
        mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                height, format, imageSize, data);
        checkError();
        // ---------- Original Method ----------
        //begin("glCompressedTexSubImage2D");
        //arg("target", getTextureTarget(target));
        //arg("level", level);
        //arg("xoffset", xoffset);
        //arg("yoffset", yoffset);
        //arg("width", width);
        //arg("height", height);
        //arg("format", format);
        //arg("imageSize", imageSize);
        //arg("data", data.toString());
        //end();
        //mgl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width,
                //height, format, imageSize, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.261 -0400", hash_original_method = "F8E44C3AEED19446978405EB93D8610D", hash_generated_method = "85CF19978283AB9E46171CE0A78D92B8")
    public void glCopyTexImage2D(int target, int level, int internalformat,
            int x, int y, int width, int height, int border) {
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        begin("glCopyTexImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("internalformat", internalformat);
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        end();
        mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                height, border);
        checkError();
        // ---------- Original Method ----------
        //begin("glCopyTexImage2D");
        //arg("target", getTextureTarget(target));
        //arg("level", level);
        //arg("internalformat", internalformat);
        //arg("x", x);
        //arg("y", y);
        //arg("width", width);
        //arg("height", height);
        //arg("border", border);
        //end();
        //mgl.glCopyTexImage2D(target, level, internalformat, x, y, width,
                //height, border);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.261 -0400", hash_original_method = "4A0D670FCA04E0D914C9719120DE9E74", hash_generated_method = "993B84C6A6D5470746442E4533633587")
    public void glCopyTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        begin("glCopyTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();
        mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                height);
        checkError();
        // ---------- Original Method ----------
        //begin("glCopyTexSubImage2D");
        //arg("target", getTextureTarget(target));
        //arg("level", level);
        //arg("xoffset", xoffset);
        //arg("yoffset", yoffset);
        //arg("x", x);
        //arg("y", y);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width,
                //height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.262 -0400", hash_original_method = "52A58515AC112AE2469A0F30AE3AF71E", hash_generated_method = "302D2A952E89D062D4B66C263F5D5FC2")
    public void glCullFace(int mode) {
        addTaint(mode);
        begin("glCullFace");
        arg("mode", mode);
        end();
        mgl.glCullFace(mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glCullFace");
        //arg("mode", mode);
        //end();
        //mgl.glCullFace(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.262 -0400", hash_original_method = "51C4CA113A443136059F7099E505E355", hash_generated_method = "4A04C4C3C70A6242643050583BB197D6")
    public void glDeleteTextures(int n, int[] textures, int offset) {
        addTaint(offset);
        addTaint(textures[0]);
        addTaint(n);
        begin("glDeleteTextures");
        arg("n", n);
        arg("textures", n, textures, offset);
        arg("offset", offset);
        end();
        mgl.glDeleteTextures(n, textures, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteTextures");
        //arg("n", n);
        //arg("textures", n, textures, offset);
        //arg("offset", offset);
        //end();
        //mgl.glDeleteTextures(n, textures, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.263 -0400", hash_original_method = "8A2F6FBD519C49A754C2C116C38B966B", hash_generated_method = "1D139F25C445D3E4E75E8327763BF980")
    public void glDeleteTextures(int n, IntBuffer textures) {
        addTaint(textures.getTaint());
        addTaint(n);
        begin("glDeleteTextures");
        arg("n", n);
        arg("textures", n, textures);
        end();
        mgl.glDeleteTextures(n, textures);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteTextures");
        //arg("n", n);
        //arg("textures", n, textures);
        //end();
        //mgl.glDeleteTextures(n, textures);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.264 -0400", hash_original_method = "427BBAC7E233265CDD5D944F4AC3AB3A", hash_generated_method = "8B7918FFD4C8AAAA9546733B323E073F")
    public void glDepthFunc(int func) {
        addTaint(func);
        begin("glDepthFunc");
        arg("func", func);
        end();
        mgl.glDepthFunc(func);
        checkError();
        // ---------- Original Method ----------
        //begin("glDepthFunc");
        //arg("func", func);
        //end();
        //mgl.glDepthFunc(func);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.265 -0400", hash_original_method = "614AE8B97F79C66F0020D862E160FB15", hash_generated_method = "B5EF2D1B7E539643D685EB92759BDFC9")
    public void glDepthMask(boolean flag) {
        addTaint(flag);
        begin("glDepthMask");
        arg("flag", flag);
        end();
        mgl.glDepthMask(flag);
        checkError();
        // ---------- Original Method ----------
        //begin("glDepthMask");
        //arg("flag", flag);
        //end();
        //mgl.glDepthMask(flag);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.266 -0400", hash_original_method = "86889785AAC498DCABCC4829759E53BA", hash_generated_method = "DB3AD7A23913589DD1A7DE7E1086CF2D")
    public void glDepthRangef(float near, float far) {
        addTaint(far);
        addTaint(near);
        begin("glDepthRangef");
        arg("near", near);
        arg("far", far);
        end();
        mgl.glDepthRangef(near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glDepthRangef");
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glDepthRangef(near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.266 -0400", hash_original_method = "C4CFC5E76FD90D5DE856EA46A6BD2F94", hash_generated_method = "436C65FC355FEC48711A766597548300")
    public void glDepthRangex(int near, int far) {
        addTaint(far);
        addTaint(near);
        begin("glDepthRangex");
        arg("near", near);
        arg("far", far);
        end();
        mgl.glDepthRangex(near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glDepthRangex");
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glDepthRangex(near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.267 -0400", hash_original_method = "0E29F4F82F989596A0795E7D408BBDA9", hash_generated_method = "4E6CA283AC8F35D9B9351895A70AB763")
    public void glDisable(int cap) {
        addTaint(cap);
        begin("glDisable");
        arg("cap", getCap(cap));
        end();
        mgl.glDisable(cap);
        checkError();
        // ---------- Original Method ----------
        //begin("glDisable");
        //arg("cap", getCap(cap));
        //end();
        //mgl.glDisable(cap);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.279 -0400", hash_original_method = "0B23BC91825AF458EEA5F4AC0A7F02CA", hash_generated_method = "D4EC35CB3F0D328FCFEC8DCCBB99CABB")
    public void glDisableClientState(int array) {
        addTaint(array);
        begin("glDisableClientState");
        arg("array", getClientState(array));
        end();
switch(array){
        case GL_COLOR_ARRAY:
        mColorArrayEnabled = false;
        break;
        case GL_NORMAL_ARRAY:
        mNormalArrayEnabled = false;
        break;
        case GL_TEXTURE_COORD_ARRAY:
        mTextureCoordArrayEnabled = false;
        break;
        case GL_VERTEX_ARRAY:
        mVertexArrayEnabled = false;
        break;
}        mgl.glDisableClientState(array);
        checkError();
        // ---------- Original Method ----------
        //begin("glDisableClientState");
        //arg("array", getClientState(array));
        //end();
        //switch (array) {
        //case GL_COLOR_ARRAY:
            //mColorArrayEnabled = false;
            //break;
        //case GL_NORMAL_ARRAY:
            //mNormalArrayEnabled = false;
            //break;
        //case GL_TEXTURE_COORD_ARRAY:
            //mTextureCoordArrayEnabled = false;
            //break;
        //case GL_VERTEX_ARRAY:
            //mVertexArrayEnabled = false;
            //break;
        //}
        //mgl.glDisableClientState(array);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.279 -0400", hash_original_method = "B8B8A917FC846F2FCFF92B923002E5E6", hash_generated_method = "418DB4AFADA1967BAF3553CA310231B1")
    public void glDrawArrays(int mode, int first, int count) {
        addTaint(count);
        addTaint(first);
        addTaint(mode);
        begin("glDrawArrays");
        arg("mode", mode);
        arg("first", first);
        arg("count", count);
        startLogIndices();
for(int i = 0;i < count;i++)
        {
            doElement(mStringBuilder, i, first + i);
        } //End block
        endLogIndices();
        end();
        mgl.glDrawArrays(mode, first, count);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawArrays");
        //arg("mode", mode);
        //arg("first", first);
        //arg("count", count);
        //startLogIndices();
        //for (int i = 0; i < count; i++) {
            //doElement(mStringBuilder, i, first + i);
        //}
        //endLogIndices();
        //end();
        //mgl.glDrawArrays(mode, first, count);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.279 -0400", hash_original_method = "BB870BAE718C31AE354DA627C6185ADE", hash_generated_method = "42C0BBEB4684906E8CB36C8520575E14")
    public void glDrawElements(int mode, int count, int type, Buffer indices) {
        addTaint(indices.getTaint());
        addTaint(type);
        addTaint(count);
        addTaint(mode);
        begin("glDrawElements");
        arg("mode", getBeginMode(mode));
        arg("count", count);
        arg("type", getIndexType(type));
        char[] indexArray = toCharIndices(count, type, indices);
        int indexArrayLength = indexArray.length;
        startLogIndices();
for(int i = 0;i < indexArrayLength;i++)
        {
            doElement(mStringBuilder, i, indexArray[i]);
        } //End block
        endLogIndices();
        end();
        mgl.glDrawElements(mode, count, type, indices);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawElements");
        //arg("mode", getBeginMode(mode));
        //arg("count", count);
        //arg("type", getIndexType(type));
        //char[] indexArray = toCharIndices(count, type, indices);
        //int indexArrayLength = indexArray.length;
        //startLogIndices();
        //for (int i = 0; i < indexArrayLength; i++) {
            //doElement(mStringBuilder, i, indexArray[i]);
        //}
        //endLogIndices();
        //end();
        //mgl.glDrawElements(mode, count, type, indices);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.279 -0400", hash_original_method = "037B187DF286D0F9A044C40D200FDB6A", hash_generated_method = "C685EC809E8B22FC28D0FE778D53A57B")
    public void glEnable(int cap) {
        addTaint(cap);
        begin("glEnable");
        arg("cap", getCap(cap));
        end();
        mgl.glEnable(cap);
        checkError();
        // ---------- Original Method ----------
        //begin("glEnable");
        //arg("cap", getCap(cap));
        //end();
        //mgl.glEnable(cap);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "9048A27AF44734D74E80C5A5F043B8EE", hash_generated_method = "B38A1912436358AC7196016EE22285B1")
    public void glEnableClientState(int array) {
        addTaint(array);
        begin("glEnableClientState");
        arg("array", getClientState(array));
        end();
switch(array){
        case GL_COLOR_ARRAY:
        mColorArrayEnabled = true;
        break;
        case GL_NORMAL_ARRAY:
        mNormalArrayEnabled = true;
        break;
        case GL_TEXTURE_COORD_ARRAY:
        mTextureCoordArrayEnabled = true;
        break;
        case GL_VERTEX_ARRAY:
        mVertexArrayEnabled = true;
        break;
}        mgl.glEnableClientState(array);
        checkError();
        // ---------- Original Method ----------
        //begin("glEnableClientState");
        //arg("array", getClientState(array));
        //end();
        //switch (array) {
        //case GL_COLOR_ARRAY:
            //mColorArrayEnabled = true;
            //break;
        //case GL_NORMAL_ARRAY:
            //mNormalArrayEnabled = true;
            //break;
        //case GL_TEXTURE_COORD_ARRAY:
            //mTextureCoordArrayEnabled = true;
            //break;
        //case GL_VERTEX_ARRAY:
            //mVertexArrayEnabled = true;
            //break;
        //}
        //mgl.glEnableClientState(array);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "4919B1BA0D6263390F67068E116D4AA3", hash_generated_method = "F7633D6888AEFF58E1F2ADE8508F1789")
    public void glFinish() {
        begin("glFinish");
        end();
        mgl.glFinish();
        checkError();
        // ---------- Original Method ----------
        //begin("glFinish");
        //end();
        //mgl.glFinish();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "423312DFA71D365E2950BA08C10F885F", hash_generated_method = "9CED5A326B9AA4005893E484EEF8BA5F")
    public void glFlush() {
        begin("glFlush");
        end();
        mgl.glFlush();
        checkError();
        // ---------- Original Method ----------
        //begin("glFlush");
        //end();
        //mgl.glFlush();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "4E1B2154F1082860A31A1C62D2E4DF3D", hash_generated_method = "AC96BA39B9E9E7770B8BD3F8E30118A1")
    public void glFogf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        begin("glFogf");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl.glFogf(pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogf");
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl.glFogf(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "780C4FF306524B2422381942E74CA09A", hash_generated_method = "EBC6176D18FE54284AC2B542B2789C19")
    public void glFogfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glFogfv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glFogfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogfv");
        //arg("pname", getFogPName(pname));
        //arg("params", getFogParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glFogfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "B62F50FDE96FA84C6C837ACAD485B847", hash_generated_method = "336C971F86DE021C699056B1706E9034")
    public void glFogfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glFogfv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params);
        end();
        mgl.glFogfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogfv");
        //arg("pname", getFogPName(pname));
        //arg("params", getFogParamCount(pname), params);
        //end();
        //mgl.glFogfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.280 -0400", hash_original_method = "24AB7D8BC7EC6CB5502C17F690AAFA75", hash_generated_method = "AEA4BC57105C9361FAFA1B3F5F246715")
    public void glFogx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        begin("glFogx");
        arg("pname", getFogPName(pname));
        arg("param", param);
        end();
        mgl.glFogx(pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogx");
        //arg("pname", getFogPName(pname));
        //arg("param", param);
        //end();
        //mgl.glFogx(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "E730360244E81B4BDA1EE45B23499CC9", hash_generated_method = "50A26C288CB5FAF5BBA0C69883C750B3")
    public void glFogxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glFogxv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glFogxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogxv");
        //arg("pname", getFogPName(pname));
        //arg("params", getFogParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glFogxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "1E7C310CA6843784009209329096AF49", hash_generated_method = "C24B981285A30853EA965E74A9A01639")
    public void glFogxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glFogxv");
        arg("pname", getFogPName(pname));
        arg("params", getFogParamCount(pname), params);
        end();
        mgl.glFogxv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glFogxv");
        //arg("pname", getFogPName(pname));
        //arg("params", getFogParamCount(pname), params);
        //end();
        //mgl.glFogxv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "F9B3ED29E2742323457BDEB93D48C2D2", hash_generated_method = "873EA0DA097E2ED99C81756322FB7AEF")
    public void glFrontFace(int mode) {
        addTaint(mode);
        begin("glFrontFace");
        arg("mode", mode);
        end();
        mgl.glFrontFace(mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glFrontFace");
        //arg("mode", mode);
        //end();
        //mgl.glFrontFace(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "606F640A21534CBC3236331EB1800408", hash_generated_method = "7C3DC9F55D519A7695C67C1480E62E92")
    public void glFrustumf(float left, float right, float bottom, float top,
            float near, float far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        begin("glFrustumf");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();
        mgl.glFrustumf(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glFrustumf");
        //arg("left", left);
        //arg("right", right);
        //arg("bottom", bottom);
        //arg("top", top);
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glFrustumf(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "1C689FBDFE8C0AF744CFD0AE99B1B614", hash_generated_method = "EDD4D3303EDA3EE796A681A2EB7BB840")
    public void glFrustumx(int left, int right, int bottom, int top, int near,
            int far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        begin("glFrustumx");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();
        mgl.glFrustumx(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glFrustumx");
        //arg("left", left);
        //arg("right", right);
        //arg("bottom", bottom);
        //arg("top", top);
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glFrustumx(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.281 -0400", hash_original_method = "B5718C155B7A074626FB445A982478A0", hash_generated_method = "E35A87B4879355A42D8C7881C2BFA34A")
    public void glGenTextures(int n, int[] textures, int offset) {
        addTaint(offset);
        addTaint(textures[0]);
        addTaint(n);
        begin("glGenTextures");
        arg("n", n);
        arg("textures", Arrays.toString(textures));
        arg("offset", offset);
        mgl.glGenTextures(n, textures, offset);
        returns(toString(n, FORMAT_INT, textures, offset));
        checkError();
        // ---------- Original Method ----------
        //begin("glGenTextures");
        //arg("n", n);
        //arg("textures", Arrays.toString(textures));
        //arg("offset", offset);
        //mgl.glGenTextures(n, textures, offset);
        //returns(toString(n, FORMAT_INT, textures, offset));
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "E12690B2C5EC417C8BBBC8A0CE38078D", hash_generated_method = "01EFE64B440907F839DA2FB7534A9BD5")
    public void glGenTextures(int n, IntBuffer textures) {
        addTaint(textures.getTaint());
        addTaint(n);
        begin("glGenTextures");
        arg("n", n);
        arg("textures", textures.toString());
        mgl.glGenTextures(n, textures);
        returns(toString(n, FORMAT_INT, textures));
        checkError();
        // ---------- Original Method ----------
        //begin("glGenTextures");
        //arg("n", n);
        //arg("textures", textures.toString());
        //mgl.glGenTextures(n, textures);
        //returns(toString(n, FORMAT_INT, textures));
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "825E7C95315F0ABF8F0608D611FC7623", hash_generated_method = "3E1CEC4234DCBA1C4D1D48709592753F")
    public int glGetError() {
        begin("glGetError");
        int result = mgl.glGetError();
        returns(result);
        int varB4A88417B3D0170D754C647C30B7216A_348662340 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269218188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269218188;
        // ---------- Original Method ----------
        //begin("glGetError");
        //int result = mgl.glGetError();
        //returns(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "4A5DBEAE0C4B83B570F7F956E537E4DC", hash_generated_method = "93EDBC11886EB41238FCD8C68BAD43A7")
    public void glGetIntegerv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(pname));
        arg("params", Arrays.toString(params));
        arg("offset", offset);
        mgl.glGetIntegerv(pname, params, offset);
        returns(toString(getIntegerStateSize(pname),
                getIntegerStateFormat(pname), params, offset));
        checkError();
        // ---------- Original Method ----------
        //begin("glGetIntegerv");
        //arg("pname", getIntegerStateName(pname));
        //arg("params", Arrays.toString(params));
        //arg("offset", offset);
        //mgl.glGetIntegerv(pname, params, offset);
        //returns(toString(getIntegerStateSize(pname),
                //getIntegerStateFormat(pname), params, offset));
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "D8BB277A5C1B18C544D5870F1AE2547E", hash_generated_method = "B272D3F9039837819586BE59B98BFB59")
    public void glGetIntegerv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glGetIntegerv");
        arg("pname", getIntegerStateName(pname));
        arg("params", params.toString());
        mgl.glGetIntegerv(pname, params);
        returns(toString(getIntegerStateSize(pname),
                getIntegerStateFormat(pname), params));
        checkError();
        // ---------- Original Method ----------
        //begin("glGetIntegerv");
        //arg("pname", getIntegerStateName(pname));
        //arg("params", params.toString());
        //mgl.glGetIntegerv(pname, params);
        //returns(toString(getIntegerStateSize(pname),
                //getIntegerStateFormat(pname), params));
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "4432C28844C2D8E1383E36AA64E7B8D0", hash_generated_method = "B6E20FFDE0FA080F42F66082153E1BA9")
    public String glGetString(int name) {
        addTaint(name);
        begin("glGetString");
        arg("name", name);
        String result = mgl.glGetString(name);
        returns(result);
        checkError();
String varDC838461EE2FA0CA4C9BBB70A15456B0_1015806564 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1015806564.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1015806564;
        // ---------- Original Method ----------
        //begin("glGetString");
        //arg("name", name);
        //String result = mgl.glGetString(name);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.282 -0400", hash_original_method = "AF745F825DACE04A0ECC75847B84890F", hash_generated_method = "04A35E633AF432C2784306533E3BCBF5")
    public void glHint(int target, int mode) {
        addTaint(mode);
        addTaint(target);
        begin("glHint");
        arg("target", getHintTarget(target));
        arg("mode", getHintMode(mode));
        end();
        mgl.glHint(target, mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glHint");
        //arg("target", getHintTarget(target));
        //arg("mode", getHintMode(mode));
        //end();
        //mgl.glHint(target, mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "43C83C35A2BF58278F129718A0CCB8E0", hash_generated_method = "CF8DA0AA963B0F696BF54ACAF6A63D19")
    public void glLightModelf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        begin("glLightModelf");
        arg("pname", getLightModelPName(pname));
        arg("param", param);
        end();
        mgl.glLightModelf(pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelf");
        //arg("pname", getLightModelPName(pname));
        //arg("param", param);
        //end();
        //mgl.glLightModelf(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "D2E9F716BA3428524C591D8E73952F94", hash_generated_method = "79619B1A537C4C5F4D36503FCB5C9F0C")
    public void glLightModelfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glLightModelfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelfv");
        //arg("pname", getLightModelPName(pname));
        //arg("params", getLightModelParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLightModelfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "1B40E32FEACEE93AAE84D6059C83E19B", hash_generated_method = "F343FEC7F94AB6283E9B98AF93D08AE4")
    public void glLightModelfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params);
        end();
        mgl.glLightModelfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelfv");
        //arg("pname", getLightModelPName(pname));
        //arg("params", getLightModelParamCount(pname), params);
        //end();
        //mgl.glLightModelfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "0AB22F507F3AEC2B8DBB51B6125611F1", hash_generated_method = "7F6268B45DA48F62272AB7B133A5DC1D")
    public void glLightModelx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        begin("glLightModelx");
        arg("pname", getLightModelPName(pname));
        arg("param", param);
        end();
        mgl.glLightModelx(pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelx");
        //arg("pname", getLightModelPName(pname));
        //arg("param", param);
        //end();
        //mgl.glLightModelx(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "7A81EF6B335025A246A977F4DDB5523B", hash_generated_method = "11F98499D301BFC8CC68C798FEC59959")
    public void glLightModelxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glLightModelxv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glLightModelxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelxv");
        //arg("pname", getLightModelPName(pname));
        //arg("params", getLightModelParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLightModelxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.283 -0400", hash_original_method = "EDD6AB43EFA62E0429922574FF165465", hash_generated_method = "5F6E332259E4A5DBD1C9E4ED882C6604")
    public void glLightModelxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glLightModelfv");
        arg("pname", getLightModelPName(pname));
        arg("params", getLightModelParamCount(pname), params);
        end();
        mgl.glLightModelxv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightModelfv");
        //arg("pname", getLightModelPName(pname));
        //arg("params", getLightModelParamCount(pname), params);
        //end();
        //mgl.glLightModelxv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "BE7CBC21E4DF919F60B7ABC9E9A39229", hash_generated_method = "24DB0C7922674A7B461DDE6231C0BAE7")
    public void glLightf(int light, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(light);
        begin("glLightf");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("param", param);
        end();
        mgl.glLightf(light, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightf");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("param", param);
        //end();
        //mgl.glLightf(light, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "5819BC859DAA10078044F74898ED27A2", hash_generated_method = "22FFEA4070DE637A48581DB4004BDD2B")
    public void glLightfv(int light, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        begin("glLightfv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glLightfv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightfv");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("params", getLightParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLightfv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "05509FB05D551D5C0F24E5461A019E9D", hash_generated_method = "F2FC947B2C42F31CF7E18DDF326DAF97")
    public void glLightfv(int light, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        begin("glLightfv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params);
        end();
        mgl.glLightfv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightfv");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("params", getLightParamCount(pname), params);
        //end();
        //mgl.glLightfv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "C59713C3F2C98A691DF6ED0D9CC56790", hash_generated_method = "352F67ABFC4CC32D890406CF6C94BD16")
    public void glLightx(int light, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(light);
        begin("glLightx");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("param", param);
        end();
        mgl.glLightx(light, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightx");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("param", param);
        //end();
        //mgl.glLightx(light, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "CEE405D8204834CFD4958E9296841BF9", hash_generated_method = "0E8A3DF0491EDF313148E0021AA21D3D")
    public void glLightxv(int light, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        begin("glLightxv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glLightxv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightxv");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("params", getLightParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLightxv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.284 -0400", hash_original_method = "5C3C884B4EA1E90B2851FFFCF57AA8C3", hash_generated_method = "7237CCD48C7633C9617E029410FF7F3C")
    public void glLightxv(int light, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        begin("glLightxv");
        arg("light", getLightName(light));
        arg("pname", getLightPName(pname));
        arg("params", getLightParamCount(pname), params);
        end();
        mgl.glLightxv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glLightxv");
        //arg("light", getLightName(light));
        //arg("pname", getLightPName(pname));
        //arg("params", getLightParamCount(pname), params);
        //end();
        //mgl.glLightxv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "F761C45249D7FF175A805273D5BBA766", hash_generated_method = "570CAEC7D437C9EC0E9F1FB972545442")
    public void glLineWidth(float width) {
        addTaint(width);
        begin("glLineWidth");
        arg("width", width);
        end();
        mgl.glLineWidth(width);
        checkError();
        // ---------- Original Method ----------
        //begin("glLineWidth");
        //arg("width", width);
        //end();
        //mgl.glLineWidth(width);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "F4E2E52749E3281D62ECD99114FEB263", hash_generated_method = "300CCABD7E6F2AD9364B400AF7E9B513")
    public void glLineWidthx(int width) {
        addTaint(width);
        begin("glLineWidthx");
        arg("width", width);
        end();
        mgl.glLineWidthx(width);
        checkError();
        // ---------- Original Method ----------
        //begin("glLineWidthx");
        //arg("width", width);
        //end();
        //mgl.glLineWidthx(width);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "F88B218CE09E1C5C548020A1E54977C3", hash_generated_method = "8DB0672DBA6B8F56F2E70B7A67F50117")
    public void glLoadIdentity() {
        begin("glLoadIdentity");
        end();
        mgl.glLoadIdentity();
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadIdentity");
        //end();
        //mgl.glLoadIdentity();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "687C39CD5DEC5AADF092840F28B619FD", hash_generated_method = "D405C7AE6125B9E6F8AF3F80DC9335DA")
    public void glLoadMatrixf(float[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        begin("glLoadMatrixf");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();
        mgl.glLoadMatrixf(m, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadMatrixf");
        //arg("m", 16, m, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLoadMatrixf(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "880E32EF2604F1595B752E9CCFE7F69E", hash_generated_method = "2E12E29EA9BFC05DF27EB646112680B5")
    public void glLoadMatrixf(FloatBuffer m) {
        addTaint(m.getTaint());
        begin("glLoadMatrixf");
        arg("m", 16, m);
        end();
        mgl.glLoadMatrixf(m);
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadMatrixf");
        //arg("m", 16, m);
        //end();
        //mgl.glLoadMatrixf(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "476A0BC5D3776D45E97995A37B0A37E6", hash_generated_method = "41A89969CF4DC5D67B81C47E46220572")
    public void glLoadMatrixx(int[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        begin("glLoadMatrixx");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();
        mgl.glLoadMatrixx(m, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadMatrixx");
        //arg("m", 16, m, offset);
        //arg("offset", offset);
        //end();
        //mgl.glLoadMatrixx(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "8F70779E25DE9596BE3929AE54958722", hash_generated_method = "FA9FAD5705AF1381765FEB958056219E")
    public void glLoadMatrixx(IntBuffer m) {
        addTaint(m.getTaint());
        begin("glLoadMatrixx");
        arg("m", 16, m);
        end();
        mgl.glLoadMatrixx(m);
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadMatrixx");
        //arg("m", 16, m);
        //end();
        //mgl.glLoadMatrixx(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.285 -0400", hash_original_method = "3FD0E924214C79DB2C00A21CEE462ABB", hash_generated_method = "0907A76F2C9459623CA9A39A6196C45C")
    public void glLogicOp(int opcode) {
        addTaint(opcode);
        begin("glLogicOp");
        arg("opcode", opcode);
        end();
        mgl.glLogicOp(opcode);
        checkError();
        // ---------- Original Method ----------
        //begin("glLogicOp");
        //arg("opcode", opcode);
        //end();
        //mgl.glLogicOp(opcode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.286 -0400", hash_original_method = "936946C97699308AE2CF16FF909FE5B3", hash_generated_method = "4E49D92D4FB3EFF8DF8568CBB735B004")
    public void glMaterialf(int face, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(face);
        begin("glMaterialf");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("param", param);
        end();
        mgl.glMaterialf(face, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialf");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("param", param);
        //end();
        //mgl.glMaterialf(face, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.286 -0400", hash_original_method = "D41282511741456A16F4BE2E43CE842E", hash_generated_method = "A5F705781BAF6125F7B2B0B14BB53F49")
    public void glMaterialfv(int face, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        begin("glMaterialfv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glMaterialfv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialfv");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("params", getMaterialParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glMaterialfv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.286 -0400", hash_original_method = "9C665EB85D69DD7B8F9D999AFD512769", hash_generated_method = "A70CADFDD7143A0A7285E2864FAD4012")
    public void glMaterialfv(int face, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        begin("glMaterialfv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params);
        end();
        mgl.glMaterialfv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialfv");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("params", getMaterialParamCount(pname), params);
        //end();
        //mgl.glMaterialfv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.286 -0400", hash_original_method = "387A298350B07625BDFDB1B9DE2A4675", hash_generated_method = "97B701CA2D7FF2D711F89E2D42F94430")
    public void glMaterialx(int face, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(face);
        begin("glMaterialx");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("param", param);
        end();
        mgl.glMaterialx(face, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialx");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("param", param);
        //end();
        //mgl.glMaterialx(face, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.286 -0400", hash_original_method = "CBFD548600D9445E6341587A5303FFB2", hash_generated_method = "70C8DFFEEA97383ACE5795C15053EA52")
    public void glMaterialxv(int face, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        begin("glMaterialxv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glMaterialxv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialxv");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("params", getMaterialParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glMaterialxv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.287 -0400", hash_original_method = "4C8733D8C4D7688FBA1548248BF2DDEA", hash_generated_method = "C1FD8C0CE8064CA5C762D347E08AE80A")
    public void glMaterialxv(int face, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        begin("glMaterialxv");
        arg("face", getFaceName(face));
        arg("pname", getMaterialPName(pname));
        arg("params", getMaterialParamCount(pname), params);
        end();
        mgl.glMaterialxv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glMaterialxv");
        //arg("face", getFaceName(face));
        //arg("pname", getMaterialPName(pname));
        //arg("params", getMaterialParamCount(pname), params);
        //end();
        //mgl.glMaterialxv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.287 -0400", hash_original_method = "BEE3E754BA2B56E36F6E1425F4D645D1", hash_generated_method = "BB5B81CC90FEB8975C3D0D4C581C9548")
    public void glMatrixMode(int mode) {
        addTaint(mode);
        begin("glMatrixMode");
        arg("mode", getMatrixMode(mode));
        end();
        mgl.glMatrixMode(mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glMatrixMode");
        //arg("mode", getMatrixMode(mode));
        //end();
        //mgl.glMatrixMode(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.287 -0400", hash_original_method = "8612501CF000DA9CE87F4C45AF0190A3", hash_generated_method = "43BAE16DB3404E609E3D9D6245FFB99D")
    public void glMultMatrixf(float[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        begin("glMultMatrixf");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();
        mgl.glMultMatrixf(m, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultMatrixf");
        //arg("m", 16, m, offset);
        //arg("offset", offset);
        //end();
        //mgl.glMultMatrixf(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.287 -0400", hash_original_method = "AB97FC4290D8B0A3F5FCBE4FBF022286", hash_generated_method = "A5D10435EA89CF5C11B8BF595B7FDCF2")
    public void glMultMatrixf(FloatBuffer m) {
        addTaint(m.getTaint());
        begin("glMultMatrixf");
        arg("m", 16, m);
        end();
        mgl.glMultMatrixf(m);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultMatrixf");
        //arg("m", 16, m);
        //end();
        //mgl.glMultMatrixf(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.287 -0400", hash_original_method = "92FDBB22C33889299245E7F12194D7C7", hash_generated_method = "E5944A0026212A53A8C536683E159CEE")
    public void glMultMatrixx(int[] m, int offset) {
        addTaint(offset);
        addTaint(m[0]);
        begin("glMultMatrixx");
        arg("m", 16, m, offset);
        arg("offset", offset);
        end();
        mgl.glMultMatrixx(m, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultMatrixx");
        //arg("m", 16, m, offset);
        //arg("offset", offset);
        //end();
        //mgl.glMultMatrixx(m, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.288 -0400", hash_original_method = "687C4E76B5EEC57D6750FED61FC116C8", hash_generated_method = "2370D8A04AD55F1C44E18C679E619498")
    public void glMultMatrixx(IntBuffer m) {
        addTaint(m.getTaint());
        begin("glMultMatrixx");
        arg("m", 16, m);
        end();
        mgl.glMultMatrixx(m);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultMatrixx");
        //arg("m", 16, m);
        //end();
        //mgl.glMultMatrixx(m);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.288 -0400", hash_original_method = "A988E1C9140DEB4EBB9B24D3314588F7", hash_generated_method = "A62F9DE16FCC3B6D57B338ECF9BD0C85")
    public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
        addTaint(q);
        addTaint(r);
        addTaint(t);
        addTaint(s);
        addTaint(target);
        begin("glMultiTexCoord4f");
        arg("target", target);
        arg("s", s);
        arg("t", t);
        arg("r", r);
        arg("q", q);
        end();
        mgl.glMultiTexCoord4f(target, s, t, r, q);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultiTexCoord4f");
        //arg("target", target);
        //arg("s", s);
        //arg("t", t);
        //arg("r", r);
        //arg("q", q);
        //end();
        //mgl.glMultiTexCoord4f(target, s, t, r, q);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.288 -0400", hash_original_method = "85A9C417EFE7C5EEA1B7083D0FD21661", hash_generated_method = "460CEC1D1A56C8B61F615F5B4B2F3548")
    public void glMultiTexCoord4x(int target, int s, int t, int r, int q) {
        addTaint(q);
        addTaint(r);
        addTaint(t);
        addTaint(s);
        addTaint(target);
        begin("glMultiTexCoord4x");
        arg("target", target);
        arg("s", s);
        arg("t", t);
        arg("r", r);
        arg("q", q);
        end();
        mgl.glMultiTexCoord4x(target, s, t, r, q);
        checkError();
        // ---------- Original Method ----------
        //begin("glMultiTexCoord4x");
        //arg("target", target);
        //arg("s", s);
        //arg("t", t);
        //arg("r", r);
        //arg("q", q);
        //end();
        //mgl.glMultiTexCoord4x(target, s, t, r, q);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.288 -0400", hash_original_method = "7DE7615C0A0E812379EF8154DBA60ABA", hash_generated_method = "D191D53922FA1DCFAB741A6300100F9B")
    public void glNormal3f(float nx, float ny, float nz) {
        addTaint(nz);
        addTaint(ny);
        addTaint(nx);
        begin("glNormal3f");
        arg("nx", nx);
        arg("ny", ny);
        arg("nz", nz);
        end();
        mgl.glNormal3f(nx, ny, nz);
        checkError();
        // ---------- Original Method ----------
        //begin("glNormal3f");
        //arg("nx", nx);
        //arg("ny", ny);
        //arg("nz", nz);
        //end();
        //mgl.glNormal3f(nx, ny, nz);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.289 -0400", hash_original_method = "96F295208F045988498392EB2AFDCBE8", hash_generated_method = "63FEEF1A47A2B41BA91703F5A24803E3")
    public void glNormal3x(int nx, int ny, int nz) {
        addTaint(nz);
        addTaint(ny);
        addTaint(nx);
        begin("glNormal3x");
        arg("nx", nx);
        arg("ny", ny);
        arg("nz", nz);
        end();
        mgl.glNormal3x(nx, ny, nz);
        checkError();
        // ---------- Original Method ----------
        //begin("glNormal3x");
        //arg("nx", nx);
        //arg("ny", ny);
        //arg("nz", nz);
        //end();
        //mgl.glNormal3x(nx, ny, nz);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.289 -0400", hash_original_method = "4CDD75BE9076420CDF6781B5A1C0C14A", hash_generated_method = "BC8CA0340FECAA01604B66F7108F74B2")
    public void glNormalPointer(int type, int stride, Buffer pointer) {
        begin("glNormalPointer");
        arg("type", type);
        arg("stride", stride);
        arg("pointer", pointer.toString());
        end();
        mNormalPointer = new PointerInfo(3, type, stride, pointer);
        mgl.glNormalPointer(type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glNormalPointer");
        //arg("type", type);
        //arg("stride", stride);
        //arg("pointer", pointer.toString());
        //end();
        //mNormalPointer = new PointerInfo(3, type, stride, pointer);
        //mgl.glNormalPointer(type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.289 -0400", hash_original_method = "CC5F9AB73FB02ADBE5D8C7CC273C82BE", hash_generated_method = "6DEC9689FDDFFBED5C2217039E209C2E")
    public void glOrthof(float left, float right, float bottom, float top,
            float near, float far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        begin("glOrthof");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();
        mgl.glOrthof(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glOrthof");
        //arg("left", left);
        //arg("right", right);
        //arg("bottom", bottom);
        //arg("top", top);
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glOrthof(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.290 -0400", hash_original_method = "D9852318860C3F9C023ED9A734CD971A", hash_generated_method = "3D59F0DE4C35CF9705714F6EAAAD4380")
    public void glOrthox(int left, int right, int bottom, int top, int near,
            int far) {
        addTaint(far);
        addTaint(near);
        addTaint(top);
        addTaint(bottom);
        addTaint(right);
        addTaint(left);
        begin("glOrthox");
        arg("left", left);
        arg("right", right);
        arg("bottom", bottom);
        arg("top", top);
        arg("near", near);
        arg("far", far);
        end();
        mgl.glOrthox(left, right, bottom, top, near, far);
        checkError();
        // ---------- Original Method ----------
        //begin("glOrthox");
        //arg("left", left);
        //arg("right", right);
        //arg("bottom", bottom);
        //arg("top", top);
        //arg("near", near);
        //arg("far", far);
        //end();
        //mgl.glOrthox(left, right, bottom, top, near, far);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.290 -0400", hash_original_method = "E1BB93D74FF29863494383E778333B81", hash_generated_method = "CB55A265CE8F3AE290B13EE9FDF75FFC")
    public void glPixelStorei(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        begin("glPixelStorei");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl.glPixelStorei(pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glPixelStorei");
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl.glPixelStorei(pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.290 -0400", hash_original_method = "76CD1D614E9C29778EAF9BE33C6AC95E", hash_generated_method = "15EC5B73620D1B28E7FB54B775BA671A")
    public void glPointSize(float size) {
        addTaint(size);
        begin("glPointSize");
        arg("size", size);
        end();
        mgl.glPointSize(size);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointSize");
        //arg("size", size);
        //end();
        //mgl.glPointSize(size);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.290 -0400", hash_original_method = "49C03CEE24AC3E5D2F2B86D001DFA2CB", hash_generated_method = "3B08FD8ACECD9421437726FA360D4F99")
    public void glPointSizex(int size) {
        addTaint(size);
        begin("glPointSizex");
        arg("size", size);
        end();
        mgl.glPointSizex(size);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointSizex");
        //arg("size", size);
        //end();
        //mgl.glPointSizex(size);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.291 -0400", hash_original_method = "216A378FAD292A41D04F329E10BF6584", hash_generated_method = "9F1F196E3BA737650C96FB275200A24E")
    public void glPolygonOffset(float factor, float units) {
        addTaint(units);
        addTaint(factor);
        begin("glPolygonOffset");
        arg("factor", factor);
        arg("units", units);
        end();
        mgl.glPolygonOffset(factor, units);
        checkError();
        // ---------- Original Method ----------
        //begin("glPolygonOffset");
        //arg("factor", factor);
        //arg("units", units);
        //end();
        //mgl.glPolygonOffset(factor, units);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.291 -0400", hash_original_method = "DA9EEDED2F49B9E40FF2DF4FFC3ED016", hash_generated_method = "2FE844A29EDA74A2DC818C9C5189ACDD")
    public void glPolygonOffsetx(int factor, int units) {
        addTaint(units);
        addTaint(factor);
        begin("glPolygonOffsetx");
        arg("factor", factor);
        arg("units", units);
        end();
        mgl.glPolygonOffsetx(factor, units);
        checkError();
        // ---------- Original Method ----------
        //begin("glPolygonOffsetx");
        //arg("factor", factor);
        //arg("units", units);
        //end();
        //mgl.glPolygonOffsetx(factor, units);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.291 -0400", hash_original_method = "E0C7AB77CC18EDB6C1A8822FA08F2B0A", hash_generated_method = "FFDF1F841A88D62C825F12A8517C1A02")
    public void glPopMatrix() {
        begin("glPopMatrix");
        end();
        mgl.glPopMatrix();
        checkError();
        // ---------- Original Method ----------
        //begin("glPopMatrix");
        //end();
        //mgl.glPopMatrix();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.291 -0400", hash_original_method = "6DACA4E8433EC8FB8ACBC7A4B896895D", hash_generated_method = "16010D98D4ED73B6279ACB9EE3C40B56")
    public void glPushMatrix() {
        begin("glPushMatrix");
        end();
        mgl.glPushMatrix();
        checkError();
        // ---------- Original Method ----------
        //begin("glPushMatrix");
        //end();
        //mgl.glPushMatrix();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.292 -0400", hash_original_method = "1FC2D294CFB625D57F0C66A824B8D0C9", hash_generated_method = "20550D63AE0E49F7E4614548CF2C0E04")
    public void glReadPixels(int x, int y, int width, int height, int format,
            int type, Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        begin("glReadPixels");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();
        mgl.glReadPixels(x, y, width, height, format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //begin("glReadPixels");
        //arg("x", x);
        //arg("y", y);
        //arg("width", width);
        //arg("height", height);
        //arg("format", format);
        //arg("type", type);
        //arg("pixels", pixels.toString());
        //end();
        //mgl.glReadPixels(x, y, width, height, format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.292 -0400", hash_original_method = "86C197E31CF22A62AC9FE6EAB3D542F2", hash_generated_method = "EBD2D8D82CC56DE53A8056AB423B5F9F")
    public void glRotatef(float angle, float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(angle);
        begin("glRotatef");
        arg("angle", angle);
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glRotatef(angle, x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glRotatef");
        //arg("angle", angle);
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glRotatef(angle, x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.293 -0400", hash_original_method = "D032860203F65851FE32D2D2E6C02375", hash_generated_method = "A595F05BDDCD125872A0B32AD157265A")
    public void glRotatex(int angle, int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(angle);
        begin("glRotatex");
        arg("angle", angle);
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glRotatex(angle, x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glRotatex");
        //arg("angle", angle);
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glRotatex(angle, x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.293 -0400", hash_original_method = "D8FFE313F54D472FE54AE109823120A2", hash_generated_method = "547E383C1D6BFF876070941BA3E804B6")
    public void glSampleCoverage(float value, boolean invert) {
        addTaint(invert);
        addTaint(value);
        begin("glSampleCoveragex");
        arg("value", value);
        arg("invert", invert);
        end();
        mgl.glSampleCoverage(value, invert);
        checkError();
        // ---------- Original Method ----------
        //begin("glSampleCoveragex");
        //arg("value", value);
        //arg("invert", invert);
        //end();
        //mgl.glSampleCoverage(value, invert);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.293 -0400", hash_original_method = "0B3B4600402FD7A8792E136EC4739B11", hash_generated_method = "2DF1A941650A5CC4C982267BEABFE236")
    public void glSampleCoveragex(int value, boolean invert) {
        addTaint(invert);
        addTaint(value);
        begin("glSampleCoveragex");
        arg("value", value);
        arg("invert", invert);
        end();
        mgl.glSampleCoveragex(value, invert);
        checkError();
        // ---------- Original Method ----------
        //begin("glSampleCoveragex");
        //arg("value", value);
        //arg("invert", invert);
        //end();
        //mgl.glSampleCoveragex(value, invert);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.293 -0400", hash_original_method = "93595DB9272CE8DE11430AFE816D5F43", hash_generated_method = "2385D7FA40E3AEC67DEAD627A21137D0")
    public void glScalef(float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glScalef");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glScalef(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glScalef");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glScalef(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.293 -0400", hash_original_method = "7B35710BC2AB65E8950A6808B54E6418", hash_generated_method = "250A2FCBE83AF22BB97A08BF4CC6F194")
    public void glScalex(int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glScalex");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glScalex(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glScalex");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glScalex(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "DF9B1B600FB2D7DA84EE7E4C47142374", hash_generated_method = "6561E63527F0AE16242B89B30EE9A0F8")
    public void glScissor(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        begin("glScissor");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();
        mgl.glScissor(x, y, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glScissor");
        //arg("x", x);
        //arg("y", y);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl.glScissor(x, y, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "AD0E84D18B813E8777234A51390B757D", hash_generated_method = "7F47683AE4457DCF680517492F15214E")
    public void glShadeModel(int mode) {
        addTaint(mode);
        begin("glShadeModel");
        arg("mode", getShadeModel(mode));
        end();
        mgl.glShadeModel(mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glShadeModel");
        //arg("mode", getShadeModel(mode));
        //end();
        //mgl.glShadeModel(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "B16614109EDB4D98A3001CD4605F1195", hash_generated_method = "587520120607199C5EE7F13621A9C031")
    public void glStencilFunc(int func, int ref, int mask) {
        addTaint(mask);
        addTaint(ref);
        addTaint(func);
        begin("glStencilFunc");
        arg("func", func);
        arg("ref", ref);
        arg("mask", mask);
        end();
        mgl.glStencilFunc(func, ref, mask);
        checkError();
        // ---------- Original Method ----------
        //begin("glStencilFunc");
        //arg("func", func);
        //arg("ref", ref);
        //arg("mask", mask);
        //end();
        //mgl.glStencilFunc(func, ref, mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "9D511E02BADCED3EEC804B1620E4AD35", hash_generated_method = "EBF386800230907B1C06F2A00B341477")
    public void glStencilMask(int mask) {
        addTaint(mask);
        begin("glStencilMask");
        arg("mask", mask);
        end();
        mgl.glStencilMask(mask);
        checkError();
        // ---------- Original Method ----------
        //begin("glStencilMask");
        //arg("mask", mask);
        //end();
        //mgl.glStencilMask(mask);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "445ACDB6B83AE298891E797CC73F7C8B", hash_generated_method = "A1F5EC749B66C1F7906180F6A4456457")
    public void glStencilOp(int fail, int zfail, int zpass) {
        addTaint(zpass);
        addTaint(zfail);
        addTaint(fail);
        begin("glStencilOp");
        arg("fail", fail);
        arg("zfail", zfail);
        arg("zpass", zpass);
        end();
        mgl.glStencilOp(fail, zfail, zpass);
        checkError();
        // ---------- Original Method ----------
        //begin("glStencilOp");
        //arg("fail", fail);
        //arg("zfail", zfail);
        //arg("zpass", zpass);
        //end();
        //mgl.glStencilOp(fail, zfail, zpass);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "8CE56D81302A70F79172F83575A87867", hash_generated_method = "B4926AF7306B2C6A952AB2CF35CF7725")
    public void glTexCoordPointer(int size, int type, int stride, Buffer pointer) {
        begin("glTexCoordPointer");
        argPointer(size, type, stride, pointer);
        end();
        mTexCoordPointer = new PointerInfo(size, type, stride, pointer);
        mgl.glTexCoordPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexCoordPointer");
        //argPointer(size, type, stride, pointer);
        //end();
        //mTexCoordPointer = new PointerInfo(size, type, stride, pointer);
        //mgl.glTexCoordPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.294 -0400", hash_original_method = "A22ACE33D3E4A09C05233B2FF790E64C", hash_generated_method = "3A91103540DE11AEB9FD5E70037262E4")
    public void glTexEnvf(int target, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvf");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("param", getTextureEnvParamName(param));
        end();
        mgl.glTexEnvf(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvf");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("param", getTextureEnvParamName(param));
        //end();
        //mgl.glTexEnvf(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.295 -0400", hash_original_method = "ADEF831FBD02DBD86AF48DF9DC789AC8", hash_generated_method = "F2A7031B2075E257D9BB720895D4F1CE")
    public void glTexEnvfv(int target, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glTexEnvfv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvfv");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("params", getTextureEnvParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glTexEnvfv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.295 -0400", hash_original_method = "864B2C28E798D802302BFA91D4161B21", hash_generated_method = "FB3545801BE3197D50FC3C32F5A1BAD5")
    public void glTexEnvfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvfv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params);
        end();
        mgl.glTexEnvfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvfv");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("params", getTextureEnvParamCount(pname), params);
        //end();
        //mgl.glTexEnvfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.295 -0400", hash_original_method = "C17E57F5559AEF12C94D6CF5F868E617", hash_generated_method = "F829F3E00B3A5441AF3E2B1116608A6D")
    public void glTexEnvx(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvx");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("param", param);
        end();
        mgl.glTexEnvx(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvx");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("param", param);
        //end();
        //mgl.glTexEnvx(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.295 -0400", hash_original_method = "A17A2FD28E78C904BEC8410F37290575", hash_generated_method = "A1593587A2D7FF0FD1FFD57041F0B7C8")
    public void glTexEnvxv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params, offset);
        arg("offset", offset);
        end();
        mgl.glTexEnvxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvxv");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("params", getTextureEnvParamCount(pname), params, offset);
        //arg("offset", offset);
        //end();
        //mgl.glTexEnvxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.295 -0400", hash_original_method = "F00237E41CAC47D001F8ACEA0F58DAF7", hash_generated_method = "7F1B9D4218BF00B14B394039131C4893")
    public void glTexEnvxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvxv");
        arg("target", getTextureEnvTarget(target));
        arg("pname", getTextureEnvPName(pname));
        arg("params", getTextureEnvParamCount(pname), params);
        end();
        mgl.glTexEnvxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvxv");
        //arg("target", getTextureEnvTarget(target));
        //arg("pname", getTextureEnvPName(pname));
        //arg("params", getTextureEnvParamCount(pname), params);
        //end();
        //mgl.glTexEnvxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.296 -0400", hash_original_method = "011E94FC51CD7DFAF3DF4BFD8D5857BA", hash_generated_method = "E0F971B2BDD478A7F7F33F4A575BFCD8")
    public void glTexImage2D(int target, int level, int internalformat,
            int width, int height, int border, int format, int type,
            Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(border);
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(level);
        addTaint(target);
        begin("glTexImage2D");
        arg("target", target);
        arg("level", level);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        arg("border", border);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();
        mgl.glTexImage2D(target, level, internalformat, width, height, border,
                format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexImage2D");
        //arg("target", target);
        //arg("level", level);
        //arg("internalformat", internalformat);
        //arg("width", width);
        //arg("height", height);
        //arg("border", border);
        //arg("format", format);
        //arg("type", type);
        //arg("pixels", pixels.toString());
        //end();
        //mgl.glTexImage2D(target, level, internalformat, width, height, border,
                //format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.296 -0400", hash_original_method = "DDDDC6FF259314F2A5D05C75F951145D", hash_generated_method = "C41DFEDB1B9C252927CAE7A3EB6AE616")
    public void glTexParameterf(int target, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterf");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("param", getTextureParamName(param));
        end();
        mgl.glTexParameterf(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterf");
        //arg("target", getTextureTarget(target));
        //arg("pname", getTexturePName(pname));
        //arg("param", getTextureParamName(param));
        //end();
        //mgl.glTexParameterf(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.296 -0400", hash_original_method = "0602BC1A27E3B85EFD8A003CECB00874", hash_generated_method = "10553A5EA5BC088F5AE653E5CFE87525")
    public void glTexParameterx(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterx");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("param", param);
        end();
        mgl.glTexParameterx(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterx");
        //arg("target", getTextureTarget(target));
        //arg("pname", getTexturePName(pname));
        //arg("param", param);
        //end();
        //mgl.glTexParameterx(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.303 -0400", hash_original_method = "DAEE78FBCC7407DC537852B2B260381B", hash_generated_method = "7975C6CD3BDC56077A4D5C8231832A0E")
    public void glTexParameteriv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameteriv");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("params", 4, params, offset);
        end();
        mgl11.glTexParameteriv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameteriv");
        //arg("target", getTextureTarget(target));
        //arg("pname", getTexturePName(pname));
        //arg("params", 4, params, offset);
        //end();
        //mgl11.glTexParameteriv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.304 -0400", hash_original_method = "DD3FE44849ED1CB6B9C3AC6BFE440888", hash_generated_method = "A44C198ACBDE1EBB6B975B631CFD2B8F")
    public void glTexParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexParameteriv");
        arg("target", getTextureTarget(target));
        arg("pname", getTexturePName(pname));
        arg("params", 4, params);
        end();
        mgl11.glTexParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameteriv");
        //arg("target", getTextureTarget(target));
        //arg("pname", getTexturePName(pname));
        //arg("params", 4, params);
        //end();
        //mgl11.glTexParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.304 -0400", hash_original_method = "D0E4565FEEA624282D81073F513C1845", hash_generated_method = "11AFB05ECA2CE4E3FA8A9BDD25B258B0")
    public void glTexSubImage2D(int target, int level, int xoffset,
            int yoffset, int width, int height, int format, int type,
            Buffer pixels) {
        addTaint(pixels.getTaint());
        addTaint(type);
        addTaint(format);
        addTaint(height);
        addTaint(width);
        addTaint(yoffset);
        addTaint(xoffset);
        addTaint(level);
        addTaint(target);
        begin("glTexSubImage2D");
        arg("target", getTextureTarget(target));
        arg("level", level);
        arg("xoffset", xoffset);
        arg("yoffset", yoffset);
        arg("width", width);
        arg("height", height);
        arg("format", format);
        arg("type", type);
        arg("pixels", pixels.toString());
        end();
        mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                format, type, pixels);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexSubImage2D");
        //arg("target", getTextureTarget(target));
        //arg("level", level);
        //arg("xoffset", xoffset);
        //arg("yoffset", yoffset);
        //arg("width", width);
        //arg("height", height);
        //arg("format", format);
        //arg("type", type);
        //arg("pixels", pixels.toString());
        //end();
        //mgl.glTexSubImage2D(target, level, xoffset, yoffset, width, height,
                //format, type, pixels);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.304 -0400", hash_original_method = "6237DE4F39B9C0DD8B4D4591974E579B", hash_generated_method = "A1B3A26FD6382573F010A6100C0A3B83")
    public void glTranslatef(float x, float y, float z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glTranslatef");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glTranslatef(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glTranslatef");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glTranslatef(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.304 -0400", hash_original_method = "20667205749A7EF5D7FD523F7BEF786A", hash_generated_method = "1F11666A821DCEEA3CB50FC577319480")
    public void glTranslatex(int x, int y, int z) {
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glTranslatex");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        end();
        mgl.glTranslatex(x, y, z);
        checkError();
        // ---------- Original Method ----------
        //begin("glTranslatex");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //end();
        //mgl.glTranslatex(x, y, z);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.304 -0400", hash_original_method = "965A17780E8361A91EAC387D26D1622D", hash_generated_method = "EED33DC9AE0AAC73A6F1328D84F61C7B")
    public void glVertexPointer(int size, int type, int stride, Buffer pointer) {
        begin("glVertexPointer");
        argPointer(size, type, stride, pointer);
        end();
        mVertexPointer = new PointerInfo(size, type, stride, pointer);
        mgl.glVertexPointer(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glVertexPointer");
        //argPointer(size, type, stride, pointer);
        //end();
        //mVertexPointer = new PointerInfo(size, type, stride, pointer);
        //mgl.glVertexPointer(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.311 -0400", hash_original_method = "D3E732269F4A090032B6FB75CDC1094D", hash_generated_method = "6E7D75601D80395045EFBFE403C7BABE")
    public void glViewport(int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        begin("glViewport");
        arg("x", x);
        arg("y", y);
        arg("width", width);
        arg("height", height);
        end();
        mgl.glViewport(x, y, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glViewport");
        //arg("x", x);
        //arg("y", y);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl.glViewport(x, y, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.311 -0400", hash_original_method = "9CADFA145D5EB2143B81CBA64BA23463", hash_generated_method = "9C541624BF20ED58CF75A42B13B084F3")
    public void glClipPlanef(int plane, float[] equation, int offset) {
        addTaint(offset);
        addTaint(equation[0]);
        addTaint(plane);
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation, offset);
        arg("offset", offset);
        end();
        mgl11.glClipPlanef(plane, equation, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glClipPlanef");
        //arg("plane", plane);
        //arg("equation", 4, equation, offset);
        //arg("offset", offset);
        //end();
        //mgl11.glClipPlanef(plane, equation, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.311 -0400", hash_original_method = "85538846DBE9D66EF7B7888CF781577E", hash_generated_method = "3A4821307994C184C46A67FABF1756C9")
    public void glClipPlanef(int plane, FloatBuffer equation) {
        addTaint(equation.getTaint());
        addTaint(plane);
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation);
        end();
        mgl11.glClipPlanef(plane, equation);
        checkError();
        // ---------- Original Method ----------
        //begin("glClipPlanef");
        //arg("plane", plane);
        //arg("equation", 4, equation);
        //end();
        //mgl11.glClipPlanef(plane, equation);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.311 -0400", hash_original_method = "4C969A7F06E92847E1AFBAAD459DDBA5", hash_generated_method = "E4C4EA76191C4A333A9D7C6ECD85B9FF")
    public void glClipPlanex(int plane, int[] equation, int offset) {
        addTaint(offset);
        addTaint(equation[0]);
        addTaint(plane);
        begin("glClipPlanex");
        arg("plane", plane);
        arg("equation", 4, equation, offset);
        arg("offset", offset);
        end();
        mgl11.glClipPlanex(plane, equation, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glClipPlanex");
        //arg("plane", plane);
        //arg("equation", 4, equation, offset);
        //arg("offset", offset);
        //end();
        //mgl11.glClipPlanex(plane, equation, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.312 -0400", hash_original_method = "0B5D59DDF9DA3F300DDA46337FD3385D", hash_generated_method = "0F981D50B83B02E100A87190F901F047")
    public void glClipPlanex(int plane, IntBuffer equation) {
        addTaint(equation.getTaint());
        addTaint(plane);
        begin("glClipPlanef");
        arg("plane", plane);
        arg("equation", 4, equation);
        end();
        mgl11.glClipPlanex(plane, equation);
        checkError();
        // ---------- Original Method ----------
        //begin("glClipPlanef");
        //arg("plane", plane);
        //arg("equation", 4, equation);
        //end();
        //mgl11.glClipPlanex(plane, equation);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.312 -0400", hash_original_method = "9AEED6FBBEDDBBFB8CA6D980B6BF5E58", hash_generated_method = "6E6A1A6F60FA355C6EBFF855568AC30C")
    public void glDrawTexfOES(float x, float y, float z,
        float width, float height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glDrawTexfOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexfOES");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl11Ext.glDrawTexfOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.312 -0400", hash_original_method = "C18A7403550BE93CDB0A64E0DDF3C5AF", hash_generated_method = "CD1E101ABD4939B09A0358492CEB390A")
    public void glDrawTexfvOES(float[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        begin("glDrawTexfvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexfvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexfvOES");
        //arg("coords", 5, coords, offset);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glDrawTexfvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.312 -0400", hash_original_method = "2653CD989ED785E48C62BAD0521A80EF", hash_generated_method = "36ED9AE8AA230099F8BAB5503C08539F")
    public void glDrawTexfvOES(FloatBuffer coords) {
        addTaint(coords.getTaint());
        begin("glDrawTexfvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexfvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexfvOES");
        //arg("coords", 5, coords);
        //end();
        //mgl11Ext.glDrawTexfvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.312 -0400", hash_original_method = "CB1FCBCDBF1A3F61200BEDE6649BE4DA", hash_generated_method = "18A32475EC53BC9298C4B3C8BD233A99")
    public void glDrawTexiOES(int x, int y, int z, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glDrawTexiOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexiOES");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl11Ext.glDrawTexiOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.313 -0400", hash_original_method = "66AD6F482CD9F2FDC30C988FD5ECCF4C", hash_generated_method = "4381BCED45702F42575208E190FD3D7D")
    public void glDrawTexivOES(int[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        begin("glDrawTexivOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexivOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexivOES");
        //arg("coords", 5, coords, offset);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glDrawTexivOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.313 -0400", hash_original_method = "FB09BC541D2C24A3C37D913F5C51A002", hash_generated_method = "8E9C611E426CC637A488A3767204ACE6")
    public void glDrawTexivOES(IntBuffer coords) {
        addTaint(coords.getTaint());
        begin("glDrawTexivOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexivOES(coords);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexivOES");
        //arg("coords", 5, coords);
        //end();
        //mgl11Ext.glDrawTexivOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.313 -0400", hash_original_method = "C2D1EB0C8029347A6625C35DD3AAEC2A", hash_generated_method = "64C5D9B38933396E6FEB0123FB4D0E9A")
    public void glDrawTexsOES(short x, short y, short z,
        short width, short height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glDrawTexsOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexsOES");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl11Ext.glDrawTexsOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.313 -0400", hash_original_method = "D2EB8EC38B4CC4F91A6AA276AEE85541", hash_generated_method = "DF510F2F3A0BB3EA9CB001536D2C36FB")
    public void glDrawTexsvOES(short[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        begin("glDrawTexsvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexsvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexsvOES");
        //arg("coords", 5, coords, offset);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glDrawTexsvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.314 -0400", hash_original_method = "F51BEDCA1D6F6785C6C721E8CC2FBE94", hash_generated_method = "5593BA5E43826605FE1AA058517F70E7")
    public void glDrawTexsvOES(ShortBuffer coords) {
        addTaint(coords.getTaint());
        begin("glDrawTexsvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexsvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexsvOES");
        //arg("coords", 5, coords);
        //end();
        //mgl11Ext.glDrawTexsvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.316 -0400", hash_original_method = "5061E46D01D14FE03282BCFBD1BABA7C", hash_generated_method = "1DCB6344FB78891CC1F73E4F4A82ED11")
    public void glDrawTexxOES(int x, int y, int z, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(z);
        addTaint(y);
        addTaint(x);
        begin("glDrawTexxOES");
        arg("x", x);
        arg("y", y);
        arg("z", z);
        arg("width", width);
        arg("height", height);
        end();
        mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexxOES");
        //arg("x", x);
        //arg("y", y);
        //arg("z", z);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl11Ext.glDrawTexxOES(x, y, z, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.317 -0400", hash_original_method = "9743785194981AB410283518D731F731", hash_generated_method = "39C56B94D83DBFD635E398CAB3CC7A03")
    public void glDrawTexxvOES(int[] coords, int offset) {
        addTaint(offset);
        addTaint(coords[0]);
        begin("glDrawTexxvOES");
        arg("coords", 5, coords, offset);
        arg("offset", offset);
        end();
        mgl11Ext.glDrawTexxvOES(coords, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexxvOES");
        //arg("coords", 5, coords, offset);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glDrawTexxvOES(coords, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.317 -0400", hash_original_method = "865108D0187ACA1114F35594F70D238B", hash_generated_method = "7EDFFFF052D5C0C2206914E6FC1A4F59")
    public void glDrawTexxvOES(IntBuffer coords) {
        addTaint(coords.getTaint());
        begin("glDrawTexxvOES");
        arg("coords", 5, coords);
        end();
        mgl11Ext.glDrawTexxvOES(coords);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawTexxvOES");
        //arg("coords", 5, coords);
        //end();
        //mgl11Ext.glDrawTexxvOES(coords);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.318 -0400", hash_original_method = "1BA8E855F04581FD7EA4EBD5DC11117A", hash_generated_method = "49F384BB38B3574B820E645FD777B157")
    public int glQueryMatrixxOES(int[] mantissa, int mantissaOffset,
        int[] exponent, int exponentOffset) {
        addTaint(exponentOffset);
        addTaint(exponent[0]);
        addTaint(mantissaOffset);
        addTaint(mantissa[0]);
        begin("glQueryMatrixxOES");
        arg("mantissa", Arrays.toString(mantissa));
        arg("exponent", Arrays.toString(exponent));
        end();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            exponent, exponentOffset);
        returns(toString(16, FORMAT_FIXED, mantissa, mantissaOffset));
        returns(toString(16, FORMAT_INT, exponent, exponentOffset));
        checkError();
        int var9F7D0EE82B6A6CA7DDEAE841F3253059_650231353 = (valid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594158823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594158823;
        // ---------- Original Method ----------
        //begin("glQueryMatrixxOES");
        //arg("mantissa", Arrays.toString(mantissa));
        //arg("exponent", Arrays.toString(exponent));
        //end();
        //int valid = mgl10Ext.glQueryMatrixxOES(mantissa, mantissaOffset,
            //exponent, exponentOffset);
        //returns(toString(16, FORMAT_FIXED, mantissa, mantissaOffset));
        //returns(toString(16, FORMAT_INT, exponent, exponentOffset));
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.318 -0400", hash_original_method = "02D82882D216B0B47C2D0767A306D636", hash_generated_method = "FB9F6B7FEE727205DEDEC0AAEF4ED04C")
    public int glQueryMatrixxOES(IntBuffer mantissa, IntBuffer exponent) {
        addTaint(exponent.getTaint());
        addTaint(mantissa.getTaint());
        begin("glQueryMatrixxOES");
        arg("mantissa", mantissa.toString());
        arg("exponent", exponent.toString());
        end();
        int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        returns(toString(16, FORMAT_FIXED, mantissa));
        returns(toString(16, FORMAT_INT, exponent));
        checkError();
        int var9F7D0EE82B6A6CA7DDEAE841F3253059_1944660643 = (valid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644560432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644560432;
        // ---------- Original Method ----------
        //begin("glQueryMatrixxOES");
        //arg("mantissa", mantissa.toString());
        //arg("exponent", exponent.toString());
        //end();
        //int valid = mgl10Ext.glQueryMatrixxOES(mantissa, exponent);
        //returns(toString(16, FORMAT_FIXED, mantissa));
        //returns(toString(16, FORMAT_INT, exponent));
        //checkError();
        //return valid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.318 -0400", hash_original_method = "79C98D67E2C2957CCE19D903D86F48F4", hash_generated_method = "B3D1672DAE90E58681D000861BF887E0")
    public void glBindBuffer(int target, int buffer) {
        addTaint(buffer);
        addTaint(target);
        begin("glBindBuffer");
        arg("target", target);
        arg("buffer", buffer);
        end();
        mgl11.glBindBuffer(target, buffer);
        checkError();
        // ---------- Original Method ----------
        //begin("glBindBuffer");
        //arg("target", target);
        //arg("buffer", buffer);
        //end();
        //mgl11.glBindBuffer(target, buffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.318 -0400", hash_original_method = "CFA9CC965A97B436966D65BB7CC13B13", hash_generated_method = "54E97C6229BB8D1BA65A351CF3F55F4D")
    public void glBufferData(int target, int size, Buffer data, int usage) {
        addTaint(usage);
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(target);
        begin("glBufferData");
        arg("target", target);
        arg("size", size);
        arg("data", data.toString());
        arg("usage", usage);
        end();
        mgl11.glBufferData(target, size, data, usage);
        checkError();
        // ---------- Original Method ----------
        //begin("glBufferData");
        //arg("target", target);
        //arg("size", size);
        //arg("data", data.toString());
        //arg("usage", usage);
        //end();
        //mgl11.glBufferData(target, size, data, usage);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.319 -0400", hash_original_method = "2D9FCC9DA0375DB81D5D80FFB10846B0", hash_generated_method = "83478910CBBD141D9063D26E891E9F07")
    public void glBufferSubData(int target, int offset, int size, Buffer data) {
        addTaint(data.getTaint());
        addTaint(size);
        addTaint(offset);
        addTaint(target);
        begin("glBufferSubData");
        arg("target", target);
        arg("offset", offset);
        arg("size", size);
        arg("data", data.toString());
        end();
        mgl11.glBufferSubData(target, offset, size, data);
        checkError();
        // ---------- Original Method ----------
        //begin("glBufferSubData");
        //arg("target", target);
        //arg("offset", offset);
        //arg("size", size);
        //arg("data", data.toString());
        //end();
        //mgl11.glBufferSubData(target, offset, size, data);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.319 -0400", hash_original_method = "38D503FD9C8B4ADD2B7F612F10730C49", hash_generated_method = "C146F82F835EBFBB22E429237856CD99")
    public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        addTaint(alpha);
        addTaint(blue);
        addTaint(green);
        addTaint(red);
        begin("glColor4ub");
        arg("red", red);
        arg("green", green);
        arg("blue", blue);
        arg("alpha", alpha);
        end();
        mgl11.glColor4ub(red, green, blue, alpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glColor4ub");
        //arg("red", red);
        //arg("green", green);
        //arg("blue", blue);
        //arg("alpha", alpha);
        //end();
        //mgl11.glColor4ub(red, green, blue, alpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.319 -0400", hash_original_method = "DF5E0282021F86CB2227CAD1AEAA3AE2", hash_generated_method = "9731CEDAF9744EC902DEED22C0491077")
    public void glDeleteBuffers(int n, int[] buffers, int offset) {
        addTaint(offset);
        addTaint(buffers[0]);
        addTaint(n);
        begin("glDeleteBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        arg("offset", offset);
        end();
        mgl11.glDeleteBuffers(n, buffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteBuffers");
        //arg("n", n);
        //arg("buffers", buffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glDeleteBuffers(n, buffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "624AEEC2C2CEDEA054A3519AA4A82323", hash_generated_method = "4A772FE064AA53894DA05B824857EED9")
    public void glDeleteBuffers(int n, IntBuffer buffers) {
        addTaint(buffers.getTaint());
        addTaint(n);
        begin("glDeleteBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        end();
        mgl11.glDeleteBuffers(n, buffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteBuffers");
        //arg("n", n);
        //arg("buffers", buffers.toString());
        //end();
        //mgl11.glDeleteBuffers(n, buffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "36A39DBC0F5F5BEE8C744DD8630485FB", hash_generated_method = "7E931DDC35E3C6D3FB2ADA8AFC9C1A0C")
    public void glGenBuffers(int n, int[] buffers, int offset) {
        addTaint(offset);
        addTaint(buffers[0]);
        addTaint(n);
        begin("glGenBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        arg("offset", offset);
        end();
        mgl11.glGenBuffers(n, buffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenBuffers");
        //arg("n", n);
        //arg("buffers", buffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGenBuffers(n, buffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "BE63AFDAFAFB9BEC4B5910C0424448D8", hash_generated_method = "EAEDF1FD1EF2D0235EE83EED32DF1C0E")
    public void glGenBuffers(int n, IntBuffer buffers) {
        addTaint(buffers.getTaint());
        addTaint(n);
        begin("glGenBuffers");
        arg("n", n);
        arg("buffers", buffers.toString());
        end();
        mgl11.glGenBuffers(n, buffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenBuffers");
        //arg("n", n);
        //arg("buffers", buffers.toString());
        //end();
        //mgl11.glGenBuffers(n, buffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "D49FD57B9EDDEB8A333068EB1EC59B27", hash_generated_method = "E6E658D141CFD51F303A8DBAF2A793A3")
    public void glGetBooleanv(int pname, boolean[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glGetBooleanv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetBooleanv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetBooleanv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetBooleanv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "51B341CF444D33A052C3AED89B0ADFDD", hash_generated_method = "027929251440E218B0546F1CD12384EF")
    public void glGetBooleanv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glGetBooleanv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetBooleanv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetBooleanv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetBooleanv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.320 -0400", hash_original_method = "1BDFA42CE3765237F848F8B2B63C5535", hash_generated_method = "EC7E1B762A01012E236B3BC954BEBD6A")
    public void glGetBufferParameteriv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glGetBufferParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetBufferParameteriv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetBufferParameteriv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetBufferParameteriv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.321 -0400", hash_original_method = "0330F0FB2F5D3C5756F5CCFBB6F98087", hash_generated_method = "59D3DDB7D266630942469D18DC4B15B9")
    public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glGetBufferParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetBufferParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetBufferParameteriv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetBufferParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.321 -0400", hash_original_method = "25E0B8CDFE08613F8C93B892E2B783FC", hash_generated_method = "100A9C85AB7272B6397EE2822D10304B")
    public void glGetClipPlanef(int pname, float[] eqn, int offset) {
        addTaint(offset);
        addTaint(eqn[0]);
        addTaint(pname);
        begin("glGetClipPlanef");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        arg("offset", offset);
        end();
        mgl11.glGetClipPlanef(pname, eqn, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetClipPlanef");
        //arg("pname", pname);
        //arg("eqn", eqn.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetClipPlanef(pname, eqn, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.321 -0400", hash_original_method = "6B1337E1EE7C67573B1B64D6774FD937", hash_generated_method = "9D4C2D4BA3154078C66CC4107B5B1EF6")
    public void glGetClipPlanef(int pname, FloatBuffer eqn) {
        addTaint(eqn.getTaint());
        addTaint(pname);
        begin("glGetClipPlanef");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        end();
        mgl11.glGetClipPlanef(pname, eqn);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetClipPlanef");
        //arg("pname", pname);
        //arg("eqn", eqn.toString());
        //end();
        //mgl11.glGetClipPlanef(pname, eqn);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.321 -0400", hash_original_method = "037B64CF94A7EF11AD0816F42C72D3F6", hash_generated_method = "0D54884DF106B6EC21F8BE5B9D8F5377")
    public void glGetClipPlanex(int pname, int[] eqn, int offset) {
        addTaint(offset);
        addTaint(eqn[0]);
        addTaint(pname);
        begin("glGetClipPlanex");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        arg("offset", offset);
        end();
        mgl11.glGetClipPlanex(pname, eqn, offset);
        // ---------- Original Method ----------
        //begin("glGetClipPlanex");
        //arg("pname", pname);
        //arg("eqn", eqn.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetClipPlanex(pname, eqn, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.322 -0400", hash_original_method = "52082623BD03AD7465BF11E5122D8706", hash_generated_method = "88CDB380E723F2364C5AA1273581C456")
    public void glGetClipPlanex(int pname, IntBuffer eqn) {
        addTaint(eqn.getTaint());
        addTaint(pname);
        begin("glGetClipPlanex");
        arg("pname", pname);
        arg("eqn", eqn.toString());
        end();
        mgl11.glGetClipPlanex(pname, eqn);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetClipPlanex");
        //arg("pname", pname);
        //arg("eqn", eqn.toString());
        //end();
        //mgl11.glGetClipPlanex(pname, eqn);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.322 -0400", hash_original_method = "1176578E59CDA354160C624EF757BD48", hash_generated_method = "C63EA1F6836ADD900F9C5BFFA7691B37")
    public void glGetFixedv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glGetFixedv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetFixedv(pname, params, offset);
        // ---------- Original Method ----------
        //begin("glGetFixedv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetFixedv(pname, params, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.322 -0400", hash_original_method = "3A4E477101BC30252F2768BC91347C36", hash_generated_method = "44C71F6AD500722186B9BEBDE078933D")
    public void glGetFixedv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glGetFixedv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetFixedv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetFixedv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetFixedv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.322 -0400", hash_original_method = "2E83138077BCAC0010C969653414AD04", hash_generated_method = "CF12069B25990EA9FB201FAE4F7CADAF")
    public void glGetFloatv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glGetFloatv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetFloatv(pname, params, offset);
        // ---------- Original Method ----------
        //begin("glGetFloatv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetFloatv(pname, params, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.323 -0400", hash_original_method = "6AB73CCB4472CB8AD2F054C3A5970178", hash_generated_method = "65BBFBBA28FE386B2427FFD33FA24209")
    public void glGetFloatv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glGetFloatv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetFloatv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetFloatv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetFloatv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.323 -0400", hash_original_method = "51A9727F905475D76A5957677B81226F", hash_generated_method = "F085610E805E924D1A8690749099EEAC")
    public void glGetLightfv(int light, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        begin("glGetLightfv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetLightfv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetLightfv");
        //arg("light", light);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetLightfv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.323 -0400", hash_original_method = "E66F7CF2C608F21E1E90842355B23A5A", hash_generated_method = "C93FB97E70C2DD2A704D158963620723")
    public void glGetLightfv(int light, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        begin("glGetLightfv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetLightfv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetLightfv");
        //arg("light", light);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetLightfv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.324 -0400", hash_original_method = "E83D766969B35040C9A169CE4C510624", hash_generated_method = "BEE86683EAE95CD24C0AC32956851A38")
    public void glGetLightxv(int light, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(light);
        begin("glGetLightxv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetLightxv(light, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetLightxv");
        //arg("light", light);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetLightxv(light, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.324 -0400", hash_original_method = "6288DF336931CB05169EC9276B0D68D3", hash_generated_method = "0A8A5CC974437AFEB38291E1471212B1")
    public void glGetLightxv(int light, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(light);
        begin("glGetLightxv");
        arg("light", light);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetLightxv(light, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetLightxv");
        //arg("light", light);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetLightxv(light, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.325 -0400", hash_original_method = "482C6685F4C42A94390CCEDA3874A04D", hash_generated_method = "1D7DFC8A1970FE8CF30DB11193CA93B8")
    public void glGetMaterialfv(int face, int pname, float[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        begin("glGetMaterialfv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetMaterialfv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetMaterialfv");
        //arg("face", face);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetMaterialfv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.325 -0400", hash_original_method = "201112BB8BA75F2DB9D5DF300E3AB123", hash_generated_method = "123ADD1856F5032640995C7F53178FE0")
    public void glGetMaterialfv(int face, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        begin("glGetMaterialfv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetMaterialfv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetMaterialfv");
        //arg("face", face);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetMaterialfv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.325 -0400", hash_original_method = "D3E20C73CC4FE1487043FD2B0DDDD236", hash_generated_method = "3CDC351825C69F2395C0B39290682105")
    public void glGetMaterialxv(int face, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(face);
        begin("glGetMaterialxv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetMaterialxv(face, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetMaterialxv");
        //arg("face", face);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetMaterialxv(face, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.325 -0400", hash_original_method = "F15DB76CDF761063EA7EE91130FCCA1C", hash_generated_method = "1AA8921A6BC2B1D617C93C7CF7CDF046")
    public void glGetMaterialxv(int face, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(face);
        begin("glGetMaterialxv");
        arg("face", face);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetMaterialxv(face, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetMaterialxv");
        //arg("face", face);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetMaterialxv(face, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.326 -0400", hash_original_method = "66B2642F95864E07E8FB25E2B5082F1A", hash_generated_method = "3F12426C603335BC2E1C903636CA3462")
    public void glGetTexEnviv(int env, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(env);
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexEnviv");
        //arg("env", env);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetTexEnviv(env, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.327 -0400", hash_original_method = "ED4578155288559B620D3D7080E4312B", hash_generated_method = "AA66F647727D760EC95410967775BBCB")
    public void glGetTexEnviv(int env, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(env);
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexEnviv(env, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexEnviv");
        //arg("env", env);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetTexEnviv(env, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.327 -0400", hash_original_method = "26C49480E5A470482939BDD32DD36E50", hash_generated_method = "4FE26FCAB3EE5BBC50490B3A022F4955")
    public void glGetTexEnvxv(int env, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(env);
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(env, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexEnviv");
        //arg("env", env);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetTexEnviv(env, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.327 -0400", hash_original_method = "E0E1CE0B7F1886B6EFED117FB4065CA6", hash_generated_method = "80FFBD8B08CE03DD5D111DD84E2A42CB")
    public void glGetTexEnvxv(int env, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(env);
        begin("glGetTexEnviv");
        arg("env", env);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexEnvxv(env, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexEnviv");
        //arg("env", env);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetTexEnvxv(env, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.327 -0400", hash_original_method = "0F3A08DF0C87DD814661A01CC509B43C", hash_generated_method = "139D511BC1D6B9566DE01ABBD24DE77B")
    public void glGetTexParameterfv(int target, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexParameterfv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameterfv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetTexParameterfv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.327 -0400", hash_original_method = "FABD2A0E542E183FD9C4FE79A0BA6C61", hash_generated_method = "87A4D57B6D2B6C60374A4A23D393BD9E")
    public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameterfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameterfv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetTexParameterfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.328 -0400", hash_original_method = "BBAD5ACA898863B0EBC35B8803FB9F3D", hash_generated_method = "CDE4D974DA4B67490114A5BD9070F89A")
    public void glGetTexParameteriv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexEnviv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameteriv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetTexEnviv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.329 -0400", hash_original_method = "540D7C8CB9CD23B9B01DAE94A38E14AF", hash_generated_method = "82B533A0B9B2F4538992A67995CD3DD0")
    public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameteriv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameteriv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameteriv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetTexParameteriv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.329 -0400", hash_original_method = "3163D2F410D94B9024F75B7547E0C3E3", hash_generated_method = "3E8890A33D92A1EE4523123759199F9E")
    public void glGetTexParameterxv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glGetTexParameterxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameterxv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glGetTexParameterxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.329 -0400", hash_original_method = "1D20993377AEB3F7A0B0E7DC7E217DD0", hash_generated_method = "903DBD8FEF1432C55BE9435BCF070E5C")
    public void glGetTexParameterxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glGetTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetTexParameterxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexParameterxv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetTexParameterxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.329 -0400", hash_original_method = "6B9785D331C2E858FA29AE7DA0D1B803", hash_generated_method = "DAF998C3C6E741A5D50C9382EEE230E9")
    public boolean glIsBuffer(int buffer) {
        addTaint(buffer);
        begin("glIsBuffer");
        arg("buffer", buffer);
        end();
        boolean result = mgl11.glIsBuffer(buffer);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_1805032218 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925356783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925356783;
        // ---------- Original Method ----------
        //begin("glIsBuffer");
        //arg("buffer", buffer);
        //end();
        //boolean result = mgl11.glIsBuffer(buffer);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.329 -0400", hash_original_method = "1AD1E600FF9A83F906FAEDDFF57AA5B6", hash_generated_method = "399D21E44E5F0FCE4E3DB032E20F9CC9")
    public boolean glIsEnabled(int cap) {
        addTaint(cap);
        begin("glIsEnabled");
        arg("cap", cap);
        end();
        boolean result = mgl11.glIsEnabled(cap);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_518894896 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354177062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354177062;
        // ---------- Original Method ----------
        //begin("glIsEnabled");
        //arg("cap", cap);
        //end();
        //boolean result = mgl11.glIsEnabled(cap);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.330 -0400", hash_original_method = "0FD2BACB2FEAAD5003D96D2F6F829064", hash_generated_method = "AB4A55A3FDA1F8581C58CCF7694B5B6E")
    public boolean glIsTexture(int texture) {
        addTaint(texture);
        begin("glIsTexture");
        arg("texture", texture);
        end();
        boolean result = mgl11.glIsTexture(texture);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_16114554 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877728857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877728857;
        // ---------- Original Method ----------
        //begin("glIsTexture");
        //arg("texture", texture);
        //end();
        //boolean result = mgl11.glIsTexture(texture);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.330 -0400", hash_original_method = "4434284BAE8152D50F6CAEB48E264BCA", hash_generated_method = "231B2EB996F9725F6ED396059BA17AC9")
    public void glPointParameterf(int pname, float param) {
        addTaint(param);
        addTaint(pname);
        begin("glPointParameterf");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glPointParameterf( pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterf");
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11.glPointParameterf( pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "305C3B842F3FF114E036AEA8482C3307", hash_generated_method = "79064B82AE6CB064703B2611AA87E964")
    public void glPointParameterfv(int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glPointParameterfv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterfv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glPointParameterfv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "949DF2F7152FA59021AB77D76958EFD9", hash_generated_method = "D53624D4EF3FA66A08B2DABD6F0A7574")
    public void glPointParameterfv(int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glPointParameterfv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterfv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glPointParameterfv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "D150C38C9D48CC1A83918BF1E26BF21F", hash_generated_method = "D7B002BFE0F50EC353F74969A88B1BA4")
    public void glPointParameterx(int pname, int param) {
        addTaint(param);
        addTaint(pname);
        begin("glPointParameterfv");
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glPointParameterx( pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterfv");
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11.glPointParameterx( pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "4DC2E958B1028A79B487F04DB436CDC6", hash_generated_method = "FA6193D8195153CCEEC67CD03A9EDB33")
    public void glPointParameterxv(int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        begin("glPointParameterxv");
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glPointParameterxv(pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterxv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glPointParameterxv(pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "C55305BED941314F1A9C9B8472FF501F", hash_generated_method = "AF2289C898E60875AF7C114465E339AF")
    public void glPointParameterxv(int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        begin("glPointParameterxv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glPointParameterxv( pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointParameterxv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glPointParameterxv( pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.331 -0400", hash_original_method = "FD66F4C41E1D11118BA5779006D7A981", hash_generated_method = "2ED49F64D740FD3DAFEFC752BB959B34")
    public void glPointSizePointerOES(int type, int stride, Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        begin("glPointSizePointerOES");
        arg("type", type);
        arg("stride", stride);
        arg("params", pointer.toString());
        end();
        mgl11.glPointSizePointerOES( type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glPointSizePointerOES");
        //arg("type", type);
        //arg("stride", stride);
        //arg("params", pointer.toString());
        //end();
        //mgl11.glPointSizePointerOES( type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.332 -0400", hash_original_method = "7A777D65C6D69E6095F6ADFA0B80508D", hash_generated_method = "876C1818D19A42D4AD68AF3100206A7E")
    public void glTexEnvi(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnvi");
        arg("target", target);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glTexEnvi(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnvi");
        //arg("target", target);
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11.glTexEnvi(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.334 -0400", hash_original_method = "B84E3D84C7D28B80E45025FB1EE344CC", hash_generated_method = "3289877FF83BB397859804045553783A")
    public void glTexEnviv(int target, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexEnviv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexEnviv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnviv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glTexEnviv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.334 -0400", hash_original_method = "596BAF2194FFAB1EB8D7822E12BEF314", hash_generated_method = "DE5D24807A1D3EDB0AD75C8F3258B35A")
    public void glTexEnviv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexEnviv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexEnviv( target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexEnviv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glTexEnviv( target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.334 -0400", hash_original_method = "F91D584D006EFDAAACF005F4F66F0398", hash_generated_method = "83EE0F2A3E6A188EE8486D6EF6A600C9")
    public void glTexParameterfv(int target, int pname, float[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexParameterfv( target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterfv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glTexParameterfv( target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.334 -0400", hash_original_method = "3435AA73DA9923F97CBB67D135D5584E", hash_generated_method = "ADE90CB18760F9BC8D12C0D5B7E8A602")
    public void glTexParameterfv(int target, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterfv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexParameterfv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterfv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glTexParameterfv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "07CC406D5F2784E78C454F48595A2D00", hash_generated_method = "A458E30D15E93E4D22B9B389BE953C84")
    public void glTexParameteri(int target, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11.glTexParameteri(target, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterxv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11.glTexParameteri(target, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "273DD4FAA8A70680294276539FB369C0", hash_generated_method = "AB8C64F97DDC30BC0CFBDA594409A99E")
    public void glTexParameterxv(int target, int pname, int[] params,
            int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11.glTexParameterxv(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterxv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11.glTexParameterxv(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "2075B6D1DB4F033BEB2D89D653B6CB6D", hash_generated_method = "E045171D73F7A5743804BA3D0A29FBD4")
    public void glTexParameterxv(int target, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glTexParameterxv");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glTexParameterxv(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexParameterxv");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glTexParameterxv(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "0B1AE3EA13B753BEF7CDDB7D4FDA419D", hash_generated_method = "B8E322FF943BE1687FBFADDF1954701E")
    public void glColorPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glColorPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glColorPointer(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glColorPointer");
        //arg("size", size);
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11.glColorPointer(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "AAEC91A3DF139FE81A9767750F6793D5", hash_generated_method = "D482482652D9B29A8B76BFA2DFC06FA9")
    public void glDrawElements(int mode, int count, int type, int offset) {
        addTaint(offset);
        addTaint(type);
        addTaint(count);
        addTaint(mode);
        begin("glDrawElements");
        arg("mode", mode);
        arg("count", count);
        arg("type", type);
        arg("offset", offset);
        end();
        mgl11.glDrawElements(mode, count, type, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDrawElements");
        //arg("mode", mode);
        //arg("count", count);
        //arg("type", type);
        //arg("offset", offset);
        //end();
        //mgl11.glDrawElements(mode, count, type, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.335 -0400", hash_original_method = "60A1256295E839C4D45E05AF6D558D8B", hash_generated_method = "C385C25B96D387D1F29BB31BFA057663")
    public void glGetPointerv(int pname, Buffer[] params) {
        addTaint(params[0].getTaint());
        addTaint(pname);
        begin("glGetPointerv");
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11.glGetPointerv(pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetPointerv");
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11.glGetPointerv(pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.336 -0400", hash_original_method = "FEDAC0A9DEC1266CF068E55758CD2493", hash_generated_method = "8786232426CBAC7BF5C178016FAC6A16")
    public void glNormalPointer(int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        begin("glNormalPointer");
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glNormalPointer(type, stride, offset);
        // ---------- Original Method ----------
        //begin("glNormalPointer");
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11.glNormalPointer(type, stride, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.336 -0400", hash_original_method = "DA1881A2EEF20840CCC98BF020E67BD0", hash_generated_method = "B847896213F37606E9A0AD359D56B036")
    public void glTexCoordPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glTexCoordPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glTexCoordPointer(size, type, stride, offset);
        // ---------- Original Method ----------
        //begin("glTexCoordPointer");
        //arg("size", size);
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11.glTexCoordPointer(size, type, stride, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.336 -0400", hash_original_method = "36FE060B86348B3B1148EFC3F53E7802", hash_generated_method = "655BE52CE162D362831301C3A1E8D9E0")
    public void glVertexPointer(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glVertexPointer");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11.glVertexPointer(size, type, stride, offset);
        // ---------- Original Method ----------
        //begin("glVertexPointer");
        //arg("size", size);
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11.glVertexPointer(size, type, stride, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.336 -0400", hash_original_method = "56EA13855F9D8C15AC2F4F16ACF2BAD0", hash_generated_method = "37D0A6E2EF7C5B9BF9FCA1B0AEFC1A79")
    public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
        addTaint(matrixpaletteindex);
        begin("glCurrentPaletteMatrixOES");
        arg("matrixpaletteindex", matrixpaletteindex);
        end();
        mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        checkError();
        // ---------- Original Method ----------
        //begin("glCurrentPaletteMatrixOES");
        //arg("matrixpaletteindex", matrixpaletteindex);
        //end();
        //mgl11Ext.glCurrentPaletteMatrixOES(matrixpaletteindex);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.337 -0400", hash_original_method = "35478D1CDD4C06716A4E2591613C3204", hash_generated_method = "6370A88EB36AD041610D1E744D7BC520")
    public void glLoadPaletteFromModelViewMatrixOES() {
        begin("glLoadPaletteFromModelViewMatrixOES");
        end();
        mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        checkError();
        // ---------- Original Method ----------
        //begin("glLoadPaletteFromModelViewMatrixOES");
        //end();
        //mgl11Ext.glLoadPaletteFromModelViewMatrixOES();
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.337 -0400", hash_original_method = "03AC97935CDCC62E8A8EC9D4D8594CBE", hash_generated_method = "7CC48A30749AAE4C40939670EEA3E105")
    public void glMatrixIndexPointerOES(int size, int type, int stride,
            Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glMatrixIndexPointerOES");
        argPointer(size, type, stride, pointer);
        end();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glMatrixIndexPointerOES");
        //argPointer(size, type, stride, pointer);
        //end();
        //mgl11Ext.glMatrixIndexPointerOES(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.337 -0400", hash_original_method = "15A38F791432104E54B02A81BD91298B", hash_generated_method = "BF47E963D7B9716B59CFDB7FA5618E25")
    public void glMatrixIndexPointerOES(int size, int type, int stride,
            int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glMatrixIndexPointerOES");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glMatrixIndexPointerOES");
        //arg("size", size);
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glMatrixIndexPointerOES(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.337 -0400", hash_original_method = "D7F62CABFCAB2B782790DA8BF3A5F81B", hash_generated_method = "9AB2ED8C554F6C0870176FC59579182E")
    public void glWeightPointerOES(int size, int type, int stride,
            Buffer pointer) {
        addTaint(pointer.getTaint());
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glWeightPointerOES");
        argPointer(size, type, stride, pointer);
        end();
        mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        checkError();
        // ---------- Original Method ----------
        //begin("glWeightPointerOES");
        //argPointer(size, type, stride, pointer);
        //end();
        //mgl11Ext.glWeightPointerOES(size, type, stride, pointer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.338 -0400", hash_original_method = "929C2DA030422B90FCA87AFFBB277E59", hash_generated_method = "197564754B5643E467A08D0ACD74BF93")
    public void glWeightPointerOES(int size, int type, int stride, int offset) {
        addTaint(offset);
        addTaint(stride);
        addTaint(type);
        addTaint(size);
        begin("glWeightPointerOES");
        arg("size", size);
        arg("type", type);
        arg("stride", stride);
        arg("offset", offset);
        end();
        mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glWeightPointerOES");
        //arg("size", size);
        //arg("type", type);
        //arg("stride", stride);
        //arg("offset", offset);
        //end();
        //mgl11Ext.glWeightPointerOES(size, type, stride, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.338 -0400", hash_original_method = "E77F873E668F8C0CE2F5C8974547F621", hash_generated_method = "738AE7E88B8525BFDC2F5C085757D83E")
    @Override
    public void glBindFramebufferOES(int target, int framebuffer) {
        addTaint(framebuffer);
        addTaint(target);
        begin("glBindFramebufferOES");
        arg("target", target);
        arg("framebuffer", framebuffer);
        end();
        mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        checkError();
        // ---------- Original Method ----------
        //begin("glBindFramebufferOES");
        //arg("target", target);
        //arg("framebuffer", framebuffer);
        //end();
        //mgl11ExtensionPack.glBindFramebufferOES(target, framebuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.338 -0400", hash_original_method = "A8A4B7A7443FA6EBE6E4D943AD45B00E", hash_generated_method = "9344BB5F997B97388BD247FD1CC4B72D")
    @Override
    public void glBindRenderbufferOES(int target, int renderbuffer) {
        addTaint(renderbuffer);
        addTaint(target);
        begin("glBindRenderbufferOES");
        arg("target", target);
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        checkError();
        // ---------- Original Method ----------
        //begin("glBindRenderbufferOES");
        //arg("target", target);
        //arg("renderbuffer", renderbuffer);
        //end();
        //mgl11ExtensionPack.glBindRenderbufferOES(target, renderbuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.342 -0400", hash_original_method = "158661D288C415C1238721FD58EBABB8", hash_generated_method = "E98C0077BFD0A881B83472D6766C21D2")
    @Override
    public void glBlendEquation(int mode) {
        addTaint(mode);
        begin("glBlendEquation");
        arg("mode", mode);
        end();
        mgl11ExtensionPack.glBlendEquation(mode);
        checkError();
        // ---------- Original Method ----------
        //begin("glBlendEquation");
        //arg("mode", mode);
        //end();
        //mgl11ExtensionPack.glBlendEquation(mode);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.342 -0400", hash_original_method = "1F240B30CD77B7B90E937BB1FD93D32C", hash_generated_method = "BB92032BBF8EF6B09483763AF6B39006")
    @Override
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        addTaint(modeAlpha);
        addTaint(modeRGB);
        begin("glBlendEquationSeparate");
        arg("modeRGB", modeRGB);
        arg("modeAlpha", modeAlpha);
        end();
        mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glBlendEquationSeparate");
        //arg("modeRGB", modeRGB);
        //arg("modeAlpha", modeAlpha);
        //end();
        //mgl11ExtensionPack.glBlendEquationSeparate(modeRGB, modeAlpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.342 -0400", hash_original_method = "DBB248C6792EA3906C0326D7F236F09A", hash_generated_method = "931C470006DABA3376014D954AFEB34D")
    @Override
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha,
            int dstAlpha) {
        addTaint(dstAlpha);
        addTaint(srcAlpha);
        addTaint(dstRGB);
        addTaint(srcRGB);
        begin("glBlendFuncSeparate");
        arg("srcRGB", srcRGB);
        arg("dstRGB", dstRGB);
        arg("srcAlpha", srcAlpha);
        arg("dstAlpha", dstAlpha);
        end();
        mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        checkError();
        // ---------- Original Method ----------
        //begin("glBlendFuncSeparate");
        //arg("srcRGB", srcRGB);
        //arg("dstRGB", dstRGB);
        //arg("srcAlpha", srcAlpha);
        //arg("dstAlpha", dstAlpha);
        //end();
        //mgl11ExtensionPack.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.342 -0400", hash_original_method = "7D6042BBF52B8B65B385F14F7FA0E569", hash_generated_method = "78AC29F6DB9818EC129952E3FDB7380F")
    @Override
    public int glCheckFramebufferStatusOES(int target) {
        addTaint(target);
        begin("glCheckFramebufferStatusOES");
        arg("target", target);
        end();
        int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        checkError();
        int varB4A88417B3D0170D754C647C30B7216A_892794962 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033107821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033107821;
        // ---------- Original Method ----------
        //begin("glCheckFramebufferStatusOES");
        //arg("target", target);
        //end();
        //int result = mgl11ExtensionPack.glCheckFramebufferStatusOES(target);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.343 -0400", hash_original_method = "372A8FA79AEC7DB477299D2C5D1E2A6F", hash_generated_method = "A4BE68131776175C1F0AAC4EAB9041AB")
    @Override
    public void glDeleteFramebuffersOES(int n, int[] framebuffers, int offset) {
        addTaint(offset);
        addTaint(framebuffers[0]);
        addTaint(n);
        begin("glDeleteFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteFramebuffersOES");
        //arg("n", n);
        //arg("framebuffers", framebuffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.343 -0400", hash_original_method = "2D9352B5D029EE3E8C03E4A1B1DC9B9B", hash_generated_method = "988AE67EC8FD773042D88F879A6FF534")
    @Override
    public void glDeleteFramebuffersOES(int n, IntBuffer framebuffers) {
        addTaint(framebuffers.getTaint());
        addTaint(n);
        begin("glDeleteFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        end();
        mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteFramebuffersOES");
        //arg("n", n);
        //arg("framebuffers", framebuffers.toString());
        //end();
        //mgl11ExtensionPack.glDeleteFramebuffersOES(n, framebuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.343 -0400", hash_original_method = "827EC3DAA32EB74EF8461B36ACB50C25", hash_generated_method = "528A1F8D5566CC0256E423807B96014F")
    @Override
    public void glDeleteRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        addTaint(offset);
        addTaint(renderbuffers[0]);
        addTaint(n);
        begin("glDeleteRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteRenderbuffersOES");
        //arg("n", n);
        //arg("renderbuffers", renderbuffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.344 -0400", hash_original_method = "20D8ABDA98BA2D5246C059B7C8739ECA", hash_generated_method = "96BE14BED36A594115DAF80B7DE0C7F3")
    @Override
    public void glDeleteRenderbuffersOES(int n, IntBuffer renderbuffers) {
        addTaint(renderbuffers.getTaint());
        addTaint(n);
        begin("glDeleteRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        end();
        mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glDeleteRenderbuffersOES");
        //arg("n", n);
        //arg("renderbuffers", renderbuffers.toString());
        //end();
        //mgl11ExtensionPack.glDeleteRenderbuffersOES(n, renderbuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "6F475A0F0CB56F25CDE245EA62E021F9", hash_generated_method = "3611FEFF0AEDFE9D78A84E3079FE6AB0")
    @Override
    public void glFramebufferRenderbufferOES(int target, int attachment,
            int renderbuffertarget, int renderbuffer) {
        addTaint(renderbuffer);
        addTaint(renderbuffertarget);
        addTaint(attachment);
        addTaint(target);
        begin("glFramebufferRenderbufferOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("renderbuffertarget", renderbuffertarget);
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        checkError();
        // ---------- Original Method ----------
        //begin("glFramebufferRenderbufferOES");
        //arg("target", target);
        //arg("attachment", attachment);
        //arg("renderbuffertarget", renderbuffertarget);
        //arg("renderbuffer", renderbuffer);
        //end();
        //mgl11ExtensionPack.glFramebufferRenderbufferOES(target, attachment, renderbuffertarget, renderbuffer);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "8751850D98C9ED7FB29D9CD40877157F", hash_generated_method = "FE13641030A56C529E299CC7A744BBF3")
    @Override
    public void glFramebufferTexture2DOES(int target, int attachment,
            int textarget, int texture, int level) {
        addTaint(level);
        addTaint(texture);
        addTaint(textarget);
        addTaint(attachment);
        addTaint(target);
        begin("glFramebufferTexture2DOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("textarget", textarget);
        arg("texture", texture);
        arg("level", level);
        end();
        mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        checkError();
        // ---------- Original Method ----------
        //begin("glFramebufferTexture2DOES");
        //arg("target", target);
        //arg("attachment", attachment);
        //arg("textarget", textarget);
        //arg("texture", texture);
        //arg("level", level);
        //end();
        //mgl11ExtensionPack.glFramebufferTexture2DOES(target, attachment, textarget, texture, level);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "48891B79641038350E4AE7FF8D617104", hash_generated_method = "F77F6F8A7960C454F9A33E80B24E64DD")
    @Override
    public void glGenerateMipmapOES(int target) {
        addTaint(target);
        begin("glGenerateMipmapOES");
        arg("target", target);
        end();
        mgl11ExtensionPack.glGenerateMipmapOES(target);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenerateMipmapOES");
        //arg("target", target);
        //end();
        //mgl11ExtensionPack.glGenerateMipmapOES(target);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "40CE6725F9C7FA7EA51D8A6D7FA3FEEE", hash_generated_method = "6215F8CA05267A88B9E89202E22D7743")
    @Override
    public void glGenFramebuffersOES(int n, int[] framebuffers, int offset) {
        addTaint(offset);
        addTaint(framebuffers[0]);
        addTaint(n);
        begin("glGenFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenFramebuffersOES");
        //arg("n", n);
        //arg("framebuffers", framebuffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "6A580B7E14BA9495073FFECBB16303C8", hash_generated_method = "79ACC24D8DFF38F4C53343521A0BB8CB")
    @Override
    public void glGenFramebuffersOES(int n, IntBuffer framebuffers) {
        addTaint(framebuffers.getTaint());
        addTaint(n);
        begin("glGenFramebuffersOES");
        arg("n", n);
        arg("framebuffers", framebuffers.toString());
        end();
        mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenFramebuffersOES");
        //arg("n", n);
        //arg("framebuffers", framebuffers.toString());
        //end();
        //mgl11ExtensionPack.glGenFramebuffersOES(n, framebuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.345 -0400", hash_original_method = "E85D13A31D2128B6318C5054325A533E", hash_generated_method = "DCCF3525E998A17FDC9B83B9A1576B08")
    @Override
    public void glGenRenderbuffersOES(int n, int[] renderbuffers, int offset) {
        addTaint(offset);
        addTaint(renderbuffers[0]);
        addTaint(n);
        begin("glGenRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenRenderbuffersOES");
        //arg("n", n);
        //arg("renderbuffers", renderbuffers.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.346 -0400", hash_original_method = "F34B5CD6DFE0BE30C3C28142D34AFC07", hash_generated_method = "F8B5C65BBCFE9481E25CD0E6310B65AE")
    @Override
    public void glGenRenderbuffersOES(int n, IntBuffer renderbuffers) {
        addTaint(renderbuffers.getTaint());
        addTaint(n);
        begin("glGenRenderbuffersOES");
        arg("n", n);
        arg("renderbuffers", renderbuffers.toString());
        end();
        mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        checkError();
        // ---------- Original Method ----------
        //begin("glGenRenderbuffersOES");
        //arg("n", n);
        //arg("renderbuffers", renderbuffers.toString());
        //end();
        //mgl11ExtensionPack.glGenRenderbuffersOES(n, renderbuffers);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.347 -0400", hash_original_method = "70D50BC50BA4FB405BF6ABDC7E890470", hash_generated_method = "97E6A7D580CF4902C94810520E0B5469")
    @Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(attachment);
        addTaint(target);
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetFramebufferAttachmentParameterivOES");
        //arg("target", target);
        //arg("attachment", attachment);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.347 -0400", hash_original_method = "F5945C1AA7A5C201BBFC39B975E9D889", hash_generated_method = "752E23B3C9BB5EAEEB15DFFB842B93FB")
    @Override
    public void glGetFramebufferAttachmentParameterivOES(int target,
            int attachment, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(attachment);
        addTaint(target);
        begin("glGetFramebufferAttachmentParameterivOES");
        arg("target", target);
        arg("attachment", attachment);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetFramebufferAttachmentParameterivOES");
        //arg("target", target);
        //arg("attachment", attachment);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glGetFramebufferAttachmentParameterivOES(target, attachment, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.347 -0400", hash_original_method = "7E506FAE04F28D19CC194506D81706A7", hash_generated_method = "D7BA2C15528EE45DF632C0D7D504D9F0")
    @Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(target);
        begin("glGetRenderbufferParameterivOES");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetRenderbufferParameterivOES");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.347 -0400", hash_original_method = "BA383F1D8BCC9E9005D6C5B4FDDF8AF4", hash_generated_method = "1F4B95DC74C4E6A6D8CCB0A2FB805683")
    @Override
    public void glGetRenderbufferParameterivOES(int target, int pname,
            IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(target);
        begin("glGetRenderbufferParameterivOES");
        arg("target", target);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetRenderbufferParameterivOES");
        //arg("target", target);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glGetRenderbufferParameterivOES(target, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.347 -0400", hash_original_method = "C3F01D78373307DD84FCCE6B3B5B2899", hash_generated_method = "A19EE2A12085C02BD1C1D6D84897B62C")
    @Override
    public void glGetTexGenfv(int coord, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGenfv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGetTexGenfv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.349 -0400", hash_original_method = "F06E55A7F5E3D8E8FC357F0BE936E11B", hash_generated_method = "0A774D69444FDB3E0EE8EF977DB8111E")
    @Override
    public void glGetTexGenfv(int coord, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGenfv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glGetTexGenfv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.349 -0400", hash_original_method = "EA7169848BC2EAE9985144D566B53338", hash_generated_method = "115F4B61E578B5EE889F74BEE776D152")
    @Override
    public void glGetTexGeniv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGeniv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGetTexGeniv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.349 -0400", hash_original_method = "BACD60145789C346FD5547F693851D4B", hash_generated_method = "F5074D64EA6A3B841CD68A734053E302")
    @Override
    public void glGetTexGeniv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGeniv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glGetTexGeniv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.349 -0400", hash_original_method = "971C5F9665759126170C545C89B7DA86", hash_generated_method = "F43037B1990D8799E9EDDCCB765DC131")
    @Override
    public void glGetTexGenxv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGenxv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glGetTexGenxv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.350 -0400", hash_original_method = "FE5A58FBAEA96832C2D2DA0E698824E7", hash_generated_method = "55B511F1F87467BF7EA3EDDAAE3A4A5C")
    @Override
    public void glGetTexGenxv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glGetTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glGetTexGenxv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glGetTexGenxv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.350 -0400", hash_original_method = "F40ECC8CF4D14FE34FA5FA9B11214CC4", hash_generated_method = "0E55D96BC8B3AAB8CB845BD281CD5F48")
    @Override
    public boolean glIsFramebufferOES(int framebuffer) {
        addTaint(framebuffer);
        begin("glIsFramebufferOES");
        arg("framebuffer", framebuffer);
        end();
        boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_33314499 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659413735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659413735;
        // ---------- Original Method ----------
        //begin("glIsFramebufferOES");
        //arg("framebuffer", framebuffer);
        //end();
        //boolean result = mgl11ExtensionPack.glIsFramebufferOES(framebuffer);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.350 -0400", hash_original_method = "8F4C4857FFC99CE99F3F0A009BA01FB0", hash_generated_method = "40E9F5690F42AB898EBE3096CBEE345A")
    @Override
    public boolean glIsRenderbufferOES(int renderbuffer) {
        addTaint(renderbuffer);
        begin("glIsRenderbufferOES");
        arg("renderbuffer", renderbuffer);
        end();
        mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        checkError();
        boolean var68934A3E9455FA72420237EB05902327_151912538 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845444725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845444725;
        // ---------- Original Method ----------
        //begin("glIsRenderbufferOES");
        //arg("renderbuffer", renderbuffer);
        //end();
        //mgl11ExtensionPack.glIsRenderbufferOES(renderbuffer);
        //checkError();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.351 -0400", hash_original_method = "BBC044233862C82E6F9485381BF2EFAC", hash_generated_method = "4363F76D3976F54B28DF19658A72B18C")
    @Override
    public void glRenderbufferStorageOES(int target, int internalformat,
            int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(internalformat);
        addTaint(target);
        begin("glRenderbufferStorageOES");
        arg("target", target);
        arg("internalformat", internalformat);
        arg("width", width);
        arg("height", height);
        end();
        mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        checkError();
        // ---------- Original Method ----------
        //begin("glRenderbufferStorageOES");
        //arg("target", target);
        //arg("internalformat", internalformat);
        //arg("width", width);
        //arg("height", height);
        //end();
        //mgl11ExtensionPack.glRenderbufferStorageOES(target, internalformat, width, height);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.351 -0400", hash_original_method = "5B61ED130837A79F1176AF47B6DE593C", hash_generated_method = "C2EB51390BE70FBBE42C4FEA6FBD1D54")
    @Override
    public void glTexGenf(int coord, int pname, float param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenf");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGenf(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenf");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11ExtensionPack.glTexGenf(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.351 -0400", hash_original_method = "49199B8EC9F410EF81E538A2A5BA4CF1", hash_generated_method = "9045B46D6C3BFFA8A4B74604A40D2D14")
    @Override
    public void glTexGenfv(int coord, int pname, float[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenfv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glTexGenfv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.351 -0400", hash_original_method = "E25A823820D6AC5F127FFC2606DF6362", hash_generated_method = "562BDD4F50AFFA3D589FB71E68DF39F3")
    @Override
    public void glTexGenfv(int coord, int pname, FloatBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenfv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenfv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glTexGenfv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.351 -0400", hash_original_method = "1D228209471FF3E94635E5910E3BB6B6", hash_generated_method = "2EC810D02A2E3BCA5C4421BB33DD2495")
    @Override
    public void glTexGeni(int coord, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGeni");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGeni(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGeni");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11ExtensionPack.glTexGeni(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.352 -0400", hash_original_method = "6E7250885E975DA213108772499C9737", hash_generated_method = "445514F560DB0885A53FADEACB4FD229")
    @Override
    public void glTexGeniv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGeniv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glTexGeniv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_method = "25685DDF3F658D52B7E613A0BE3A1EC5", hash_generated_method = "F1B25E7F7CE0C18F9CDCE1A12F20A88D")
    @Override
    public void glTexGeniv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glTexGeniv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGeniv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glTexGeniv(coord, pname, params);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_method = "B00241C250B7D64FCF33453DD29CABC3", hash_generated_method = "0A691591BF9CF189B25FC0B9E760122B")
    @Override
    public void glTexGenx(int coord, int pname, int param) {
        addTaint(param);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenx");
        arg("coord", coord);
        arg("pname", pname);
        arg("param", param);
        end();
        mgl11ExtensionPack.glTexGenx(coord, pname, param);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenx");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("param", param);
        //end();
        //mgl11ExtensionPack.glTexGenx(coord, pname, param);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_method = "2830984F509DAD563B76F6673B473FE1", hash_generated_method = "16D7089D7033F687FE35F927943AE7A4")
    @Override
    public void glTexGenxv(int coord, int pname, int[] params, int offset) {
        addTaint(offset);
        addTaint(params[0]);
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        arg("offset", offset);
        end();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenxv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //arg("offset", offset);
        //end();
        //mgl11ExtensionPack.glTexGenxv(coord, pname, params, offset);
        //checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_method = "0816B8D048093B188D49101678893C82", hash_generated_method = "ED84E9D3BDE54BE80B52C69FF0480CDB")
    @Override
    public void glTexGenxv(int coord, int pname, IntBuffer params) {
        addTaint(params.getTaint());
        addTaint(pname);
        addTaint(coord);
        begin("glTexGenxv");
        arg("coord", coord);
        arg("pname", pname);
        arg("params", params.toString());
        end();
        mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        checkError();
        // ---------- Original Method ----------
        //begin("glTexGenxv");
        //arg("coord", coord);
        //arg("pname", pname);
        //arg("params", params.toString());
        //end();
        //mgl11ExtensionPack.glTexGenxv(coord, pname, params);
        //checkError();
    }

    
    private class PointerInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "3EDC173302C44782B549729423A96285")

        public int mSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "BCA5032BEC302D6E3F1E48450124488B")

        public int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_field = "9CCC51CD9B18977918E63A8F326DB6C2", hash_generated_field = "6624AFD44A7010F5D0816425FC289D54")

        public int mStride;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_field = "6E8C3226312C5A58D10CE91CEAFF2F8E", hash_generated_field = "E2041423E08DAE75956670E0FA5FE676")

        public Buffer mPointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.353 -0400", hash_original_field = "CC08E5B51C761496FC45785B51E748E6", hash_generated_field = "0C6917C29B6D542F201988508655F8BB")

        public ByteBuffer mTempByteBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.354 -0400", hash_original_method = "2509173D0AE6A11561E2EDCFDAA6FFC8", hash_generated_method = "51CC6407DCF00513E197FB9A315A08C4")
        public  PointerInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.355 -0400", hash_original_method = "744E1DCF58D39C70267D81DF3BD13F28", hash_generated_method = "DB36014DE0E1682A2BA069EA82B188A5")
        public  PointerInfo(int size, int type, int stride, Buffer pointer) {
            mSize = size;
            mType = type;
            mStride = stride;
            mPointer = pointer;
            // ---------- Original Method ----------
            //mSize = size;
            //mType = type;
            //mStride = stride;
            //mPointer = pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.355 -0400", hash_original_method = "F900B23CD310C985564C675BA1B721DF", hash_generated_method = "A774F9888E3FDDBF949FDA34F4C0D59F")
        public int sizeof(int type) {
            addTaint(type);
switch(type){
            case GL_UNSIGNED_BYTE:
            int varC4CA4238A0B923820DCC509A6F75849B_854332878 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502501833 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502501833;
            case GL_BYTE:
            int varC4CA4238A0B923820DCC509A6F75849B_1242157629 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996566983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996566983;
            case GL_SHORT:
            int varC81E728D9D4C2F636F067F89CC14862C_1204040084 = (2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541245839 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541245839;
            case GL_FIXED:
            int varA87FF679A2F3E71D9181A67B7542122C_2085320394 = (4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001721784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001721784;
            case GL_FLOAT:
            int varA87FF679A2F3E71D9181A67B7542122C_273529252 = (4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954674341 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954674341;
            default:
            int varCFCD208495D565EF66E7DFF9F98764DA_749857770 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923741030 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923741030;
}
            // ---------- Original Method ----------
            //switch (type) {
            //case GL_UNSIGNED_BYTE:
                //return 1;
            //case GL_BYTE:
                //return 1;
            //case GL_SHORT:
                //return 2;
            //case GL_FIXED:
                //return 4;
            //case GL_FLOAT:
                //return 4;
            //default:
                //return 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_method = "026A802AC136EE8CA246416A4A83001B", hash_generated_method = "472CA572DC6EC5DB8953FD065EF29A07")
        public int getStride() {
            int var9E95A309D40EA19CFE29EC0E636D0CFA_967052724 = (mStride > 0 ? mStride : sizeof(mType) * mSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895882381 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895882381;
            // ---------- Original Method ----------
            //return mStride > 0 ? mStride : sizeof(mType) * mSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_method = "CE219A6CF66D5CC900891E4666E4C00F", hash_generated_method = "4F46BB203F1321E126F71625F24110B5")
        public void bindByteBuffer() {
            mTempByteBuffer = mPointer == null ? null : toByteBuffer(-1, mPointer);
            // ---------- Original Method ----------
            //mTempByteBuffer = mPointer == null ? null : toByteBuffer(-1, mPointer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_method = "D17614F7FAC564729C1CBF8DA38BB52A", hash_generated_method = "6221050C1BE13543EB30A39BF2099676")
        public void unbindByteBuffer() {
            mTempByteBuffer = null;
            // ---------- Original Method ----------
            //mTempByteBuffer = null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_field = "5A409ED0021753EE29F1EAE0EABA8E22", hash_generated_field = "3866C56C9CFA78B1B66267D690279408")

    private static final int FORMAT_INT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_field = "3A966DFF286ADE6DD1C9388625D038E9", hash_generated_field = "3E17079C1A79E951B778EA8A93284F34")

    private static final int FORMAT_FLOAT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:31.356 -0400", hash_original_field = "49CB41B026A1199BF96A0584A03543C4", hash_generated_field = "7A5C46A8E85097CB5D81C4F327A64E41")

    private static final int FORMAT_FIXED = 2;
}

