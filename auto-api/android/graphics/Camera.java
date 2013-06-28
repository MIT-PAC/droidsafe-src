package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Camera {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.327 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.327 -0400", hash_original_method = "6DBF72AF7766D4EB810EDB03D8391F19", hash_generated_method = "9D80413F5EE3D7B08611B8D24691ACD0")
    public  Camera() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.328 -0400", hash_original_method = "5DCA6946AC737E3FB2C77FDB7C22A4F6", hash_generated_method = "9783A2EFF47138D92A5A156983FE2BD4")
    public void save() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.328 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "17FCF523146E8D711A132189A0FA7A41")
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.328 -0400", hash_original_method = "C7A05AF6A5D2D21D6919D5ED21917266", hash_generated_method = "F6F4E68E666C8C573CD760178F00DB31")
    public void translate(float x, float y, float z) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.329 -0400", hash_original_method = "70760D1E35F31209F549560E00AD3199", hash_generated_method = "CE11D133F74034DDB5652BF60662FD5B")
    public void rotateX(float deg) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.329 -0400", hash_original_method = "05F48791182D352B4D8C184739DC2F5C", hash_generated_method = "AC20BC088B5F143023114EB9AA6DE10B")
    public void rotateY(float deg) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.329 -0400", hash_original_method = "3974450583A9023F24B778633D301E40", hash_generated_method = "58BFC2D658DDF70D1A1555F2CFB3CA7E")
    public void rotateZ(float deg) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.330 -0400", hash_original_method = "A07D6B0AFBCC00CEA34DA7A028A542EA", hash_generated_method = "DDF8F0B5E2F92451D7A8DB790B3860B5")
    public void rotate(float x, float y, float z) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.330 -0400", hash_original_method = "46E0BCB01C5C707B28964C24224D27BF", hash_generated_method = "F5B80A09FCF2C29EB9F03A129D5CD074")
    public void setLocation(float x, float y, float z) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.331 -0400", hash_original_method = "EEC65A3D99E4715BBC5254EBE009F300", hash_generated_method = "613CB390D6301108E1BFFC6312DC4FB0")
    public void getMatrix(Matrix matrix) {
        nativeGetMatrix(matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //nativeGetMatrix(matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.331 -0400", hash_original_method = "E58BA8CAEF8D98DCBC5CC423229EB1CE", hash_generated_method = "7C677829D3057E4D28499B91456FBFAD")
    public void applyToCanvas(Canvas canvas) {
        nativeApplyToCanvas(canvas.mNativeCanvas);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //nativeApplyToCanvas(canvas.mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.331 -0400", hash_original_method = "99C03287B9838C14044E9B6E324762A8", hash_generated_method = "CB9BB15144F70F4F9D43AA27417FC0B7")
    public float dotWithNormal(float dx, float dy, float dz) {
        float var546ADE640B6EDFBC8A086EF31347E768_1594257726 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1594257726;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.332 -0400", hash_original_method = "C90BA6E6D8C2FEFD061454BA6E7AF7E1", hash_generated_method = "15552963748D752DA9A1B1A94AAA61C5")
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDestructor();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.332 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.333 -0400", hash_original_method = "28277D643642440FCD7626A94746E337", hash_generated_method = "40B8A1DEDDB2AF371D7C81B74B0D4C7C")
    private void nativeDestructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.333 -0400", hash_original_method = "8D274BB0506DF92F70FF4552532F47BF", hash_generated_method = "1C2D3E392ABEB0A6679A282333D3FF5D")
    private void nativeGetMatrix(int native_matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.334 -0400", hash_original_method = "969BE384F55540A8E1C5E65A0255064C", hash_generated_method = "7CA8A28702D03152D0FDA788B442394C")
    private void nativeApplyToCanvas(int native_canvas) {
    }

    
}

