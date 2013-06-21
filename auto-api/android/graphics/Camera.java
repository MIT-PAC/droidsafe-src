package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Camera {
    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.128 -0400", hash_original_method = "6DBF72AF7766D4EB810EDB03D8391F19", hash_generated_method = "9D80413F5EE3D7B08611B8D24691ACD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Camera() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.129 -0400", hash_original_method = "5DCA6946AC737E3FB2C77FDB7C22A4F6", hash_generated_method = "9783A2EFF47138D92A5A156983FE2BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void save() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.129 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "17FCF523146E8D711A132189A0FA7A41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.130 -0400", hash_original_method = "C7A05AF6A5D2D21D6919D5ED21917266", hash_generated_method = "8A41A50701DE24A44DCDC0A67335529D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.132 -0400", hash_original_method = "70760D1E35F31209F549560E00AD3199", hash_generated_method = "F91B6F1AC5D2A8FE6CA8CD46FC1BA196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateX(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.133 -0400", hash_original_method = "05F48791182D352B4D8C184739DC2F5C", hash_generated_method = "C1188A45617F1B45584A21AE39F94F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateY(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.133 -0400", hash_original_method = "3974450583A9023F24B778633D301E40", hash_generated_method = "04231773A46CBFBD33A7670B69CE01D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotateZ(float deg) {
        dsTaint.addTaint(deg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.133 -0400", hash_original_method = "A07D6B0AFBCC00CEA34DA7A028A542EA", hash_generated_method = "92769DF29DEE40D992EC2BA51BC1BEAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotate(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.133 -0400", hash_original_method = "46E0BCB01C5C707B28964C24224D27BF", hash_generated_method = "666292D9581FFAEDDCA903D2A5E77985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocation(float x, float y, float z) {
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.134 -0400", hash_original_method = "EEC65A3D99E4715BBC5254EBE009F300", hash_generated_method = "1814E60FA22263B1412EAABBB76E8577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        nativeGetMatrix(matrix.native_instance);
        // ---------- Original Method ----------
        //nativeGetMatrix(matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.134 -0400", hash_original_method = "E58BA8CAEF8D98DCBC5CC423229EB1CE", hash_generated_method = "119CF0C764FED6A0AE699D83247534D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyToCanvas(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        nativeApplyToCanvas(canvas.mNativeCanvas);
        // ---------- Original Method ----------
        //nativeApplyToCanvas(canvas.mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.134 -0400", hash_original_method = "99C03287B9838C14044E9B6E324762A8", hash_generated_method = "801E96479E4430E6A92BC6B067EDC774")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float dotWithNormal(float dx, float dy, float dz) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(dz);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.134 -0400", hash_original_method = "C90BA6E6D8C2FEFD061454BA6E7AF7E1", hash_generated_method = "15552963748D752DA9A1B1A94AAA61C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.135 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.135 -0400", hash_original_method = "28277D643642440FCD7626A94746E337", hash_generated_method = "40B8A1DEDDB2AF371D7C81B74B0D4C7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.135 -0400", hash_original_method = "8D274BB0506DF92F70FF4552532F47BF", hash_generated_method = "428527B2C1576533570B484288B36209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetMatrix(int native_matrix) {
        dsTaint.addTaint(native_matrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.135 -0400", hash_original_method = "969BE384F55540A8E1C5E65A0255064C", hash_generated_method = "1B0579E773219873B040BD3C093C06CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeApplyToCanvas(int native_canvas) {
        dsTaint.addTaint(native_canvas);
    }

    
}

