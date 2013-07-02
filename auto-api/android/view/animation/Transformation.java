package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Matrix;
import java.io.PrintWriter;

public class Transformation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.786 -0400", hash_original_field = "9FEB0FB4D7668A1A69C2CCE86D8FE6AA", hash_generated_field = "22DB0525CC1913C27DD5ABB85563881B")

    protected Matrix mMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.786 -0400", hash_original_field = "7574041472B9B2E76867A37482E74343", hash_generated_field = "57D7CB4B870C728DA589BE845D2CCF9A")

    protected float mAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.786 -0400", hash_original_field = "E809ABB3554FAD67C52E87DB28F12771", hash_generated_field = "DB4B986E23B155A24C9B9B73A0081B20")

    protected int mTransformationType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.786 -0400", hash_original_method = "B51BFBC203820EC809B8E082E20903C2", hash_generated_method = "3F4DA68BCEF9BF3D04E9F77E20D14323")
    public  Transformation() {
        clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.787 -0400", hash_original_method = "BA6C10BE71EC314AFE280F9349735494", hash_generated_method = "6F7AB4A86286C643C91F048E17B23CAB")
    public void clear() {
        {
            mMatrix = new Matrix();
        } 
        {
            mMatrix.reset();
        } 
        mAlpha = 1.0f;
        mTransformationType = TYPE_BOTH;
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.787 -0400", hash_original_method = "8DFDD7EF6072FC95D95C5176557C9475", hash_generated_method = "79494FF89CB9973CD816351A396D56B4")
    public int getTransformationType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579486271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579486271;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.787 -0400", hash_original_method = "B4636E05B9A8A9BE17FDDB51FD79878A", hash_generated_method = "39AC39ACD4F7908E138EDFE8ECD24ED9")
    public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.787 -0400", hash_original_method = "6A74ACE3E87C2A5E84C908FCAD2903E1", hash_generated_method = "AA3A3FDF21E49D36483D40C6AB86DBDC")
    public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.788 -0400", hash_original_method = "2FE33ABC0A8D366A40495EBCED9F5958", hash_generated_method = "B2C134E54DEE8C2414C9FCCC7ADE8EB3")
    public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.788 -0400", hash_original_method = "2E54F4327BDE93D0CE557FC100DEED67", hash_generated_method = "373F7E7AA24C0E46FE98DC4DD993962A")
    public Matrix getMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_1452495124 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1452495124 = mMatrix;
        varB4EAC82CA7396A68D541C85D26508E83_1452495124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1452495124;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.788 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "C9CD91170EA13924C0FBD5C314E4E67F")
    public void setAlpha(float alpha) {
        mAlpha = alpha;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.789 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "8288C654351E66E1836B6AC40A6D2FA1")
    public float getAlpha() {
        float var546ADE640B6EDFBC8A086EF31347E768_1141668607 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1141668607;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.789 -0400", hash_original_method = "6F2D8252A709B880F4404B074507697E", hash_generated_method = "C48C977B2AA7323F67D0F5108F4DAEFF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_984626214 = null; 
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        varB4EAC82CA7396A68D541C85D26508E83_984626214 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_984626214.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_984626214;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.790 -0400", hash_original_method = "9DDD7B6FB851EDEB6218261EF1A63117", hash_generated_method = "495477F5DE55D9A7ACE7CA207E2DCB11")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_683946207 = null; 
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        varB4EAC82CA7396A68D541C85D26508E83_683946207 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_683946207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_683946207;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.790 -0400", hash_original_method = "1DD4705BF9B7609556F25B5998828696", hash_generated_method = "25104FFC2C9DF4BC68754A056E7F4D39")
    public void toShortString(StringBuilder sb) {
        sb.append("{alpha=");
        sb.append(mAlpha);
        sb.append(" matrix=");
        mMatrix.toShortString(sb);
        sb.append('}');
        addTaint(sb.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.790 -0400", hash_original_method = "434986F5E9E4AD2D5C5ADC5B37E7986B", hash_generated_method = "6190B2B61A87EAE60402E95C7B997A34")
    public void printShortString(PrintWriter pw) {
        pw.print("{alpha=");
        pw.print(mAlpha);
        pw.print(" matrix=");
        mMatrix.printShortString(pw);
        pw.print('}');
        addTaint(pw.getTaint());
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.791 -0400", hash_original_field = "F11818DB7A7EB00BD5D53554D7B55ECA", hash_generated_field = "251BA68661EA4866D7BD703B646D7AF6")

    public static int TYPE_IDENTITY = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.791 -0400", hash_original_field = "98513AF7915E6589ABC1AC130C2FE67F", hash_generated_field = "C5981F1CB9C9F8B672D5F5D6F97B014F")

    public static int TYPE_ALPHA = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.791 -0400", hash_original_field = "2A6B39DACDDCF846D9229B4F5D21874A", hash_generated_field = "EDE84DD947CCFB723011B78BBFE5AD41")

    public static int TYPE_MATRIX = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.791 -0400", hash_original_field = "5D9EBA6F42EFD79BCEF2AD687D2845E4", hash_generated_field = "FC429AE0F94503BEF7A3ABEB76224BFA")

    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
}

