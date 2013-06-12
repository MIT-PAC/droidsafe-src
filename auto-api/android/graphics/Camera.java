package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Camera {
    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.962 -0400", hash_original_method = "6DBF72AF7766D4EB810EDB03D8391F19", hash_generated_method = "7DA8BAFE95DFB86A49944FED8396EDAC")
    @DSModeled(DSC.SAFE)
    public Camera() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.962 -0400", hash_original_method = "5DCA6946AC737E3FB2C77FDB7C22A4F6", hash_generated_method = "D52A328E47AD07AE4625AF4F1E4D338F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void save() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "EB44B5F60968B7E1DB698EC75965A0FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "C7A05AF6A5D2D21D6919D5ED21917266", hash_generated_method = "320C9162CC80FD41C1F5DAB2BD7FD881")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "70760D1E35F31209F549560E00AD3199", hash_generated_method = "2DDC5B0F80685EABBCBAACA963874148")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateX(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "05F48791182D352B4D8C184739DC2F5C", hash_generated_method = "35FB17F64AD173D36C75AEE46E72D3CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateY(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "3974450583A9023F24B778633D301E40", hash_generated_method = "70E8479115BB70E4204A7EF1E5A6CF61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateZ(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "A07D6B0AFBCC00CEA34DA7A028A542EA", hash_generated_method = "51D44C1B82E592C613FCD3AA42AA17EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotate(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "46E0BCB01C5C707B28964C24224D27BF", hash_generated_method = "322CBE4671F491449435F15ED23EA25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocation(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "EEC65A3D99E4715BBC5254EBE009F300", hash_generated_method = "6BBFD1DD3FBB55678292AB78D275D616")
    @DSModeled(DSC.SAFE)
    public void getMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        nativeGetMatrix(matrix.native_instance);
        // ---------- Original Method ----------
        //nativeGetMatrix(matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "E58BA8CAEF8D98DCBC5CC423229EB1CE", hash_generated_method = "820A497A03E550A5871F418724307D50")
    @DSModeled(DSC.SAFE)
    public void applyToCanvas(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        nativeApplyToCanvas(canvas.mNativeCanvas);
        // ---------- Original Method ----------
        //nativeApplyToCanvas(canvas.mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.963 -0400", hash_original_method = "99C03287B9838C14044E9B6E324762A8", hash_generated_method = "D2EB6FF26AEFC2A389A0456619E8ADB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float dotWithNormal(float dx, float dy, float dz) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(dz);
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.964 -0400", hash_original_method = "C90BA6E6D8C2FEFD061454BA6E7AF7E1", hash_generated_method = "36EF9480E794CB62E5B4826F79807968")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.964 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "4A6DCA139FFC2AD3D51E5257D0A8DCC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.964 -0400", hash_original_method = "28277D643642440FCD7626A94746E337", hash_generated_method = "9A5E49C535F8A97BE2073B6FB14BF400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.964 -0400", hash_original_method = "8D274BB0506DF92F70FF4552532F47BF", hash_generated_method = "9C3B3B3AFA57A2DD77F887ED08DF844E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetMatrix(int native_matrix) {
        dsTaint.addTaint(native_matrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.964 -0400", hash_original_method = "969BE384F55540A8E1C5E65A0255064C", hash_generated_method = "446001C01BEDC1A86301A84C2F31E666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeApplyToCanvas(int native_canvas) {
        dsTaint.addTaint(native_canvas);
    }

    
}


