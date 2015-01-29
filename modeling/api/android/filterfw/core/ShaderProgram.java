/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Frame;
import android.filterfw.core.NativeAllocatorTag;
import android.filterfw.core.Program;
import android.filterfw.core.StopWatchMap;
import android.filterfw.core.VertexFrame;
import android.filterfw.geometry.Quad;
import android.opengl.GLES20;

/**
 * @hide
 */
public class ShaderProgram extends Program {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.253 -0400", hash_original_method = "2BD9EC1D8D1387516051B03B20785CC6", hash_generated_method = "62C77DF6DA89062F34FD1B0F81412B4A")
    
public static ShaderProgram createIdentity(FilterContext context) {
        ShaderProgram program = nativeCreateIdentity(getGLEnvironment(context));
        program.setTimer();
        return program;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.293 -0400", hash_original_method = "9DC15703B6178CD05A15434A6791CC68", hash_generated_method = "9E866D876133639880CA47C1370027E7")
    
private static GLEnvironment getGLEnvironment(FilterContext context) {
        GLEnvironment result = context != null ? context.getGLEnvironment() : null;
        if (result == null) {
            throw new NullPointerException("Attempting to create ShaderProgram with no GL "
                + "environment in place!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.049 -0400", hash_original_method = "CDDA88AF8AEE279B6188DA2AF8807AA1", hash_generated_method = "284710CDE1C2B7BD679B75E2F7C1F7E2")
    
    private static ShaderProgram nativeCreateIdentity(GLEnvironment glEnv){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += glEnv.getTaintInt();
    
    	ShaderProgram retObj = new ShaderProgram(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.237 -0400", hash_original_field = "2997954D90226209869558A38138D2C4", hash_generated_field = "A4DE4B4D843E75EEA85A7DD019A2F6CE")

    private int shaderProgramId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.239 -0400", hash_original_field = "9452392755D4B9DB97BB4BD054F03F43", hash_generated_field = "E1B9BD1DBDAA8063BF9373C763FDCE1A")

    private int mMaxTileSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.240 -0400", hash_original_field = "8BDB18895FCC3C3DE30D4A8182B759B0", hash_generated_field = "36BA6D777A2DEF7FA06871FE424D0166")

    // are still programs living in it.
    private GLEnvironment mGLEnvironment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.242 -0400", hash_original_field = "9B00ED9622D774FE98BBA25FBA3C718F", hash_generated_field = "F65B4040D4A62DDAA67369124ECCF33C")

    private StopWatchMap mTimer = null;

    // Used from native layer for creating empty wrapper only!
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.246 -0400", hash_original_method = "EBB0A24BB54A3C2183FA64B479A47560", hash_generated_method = "2763176A91C5FE20A497F8E1AF3714FB")
    
private ShaderProgram() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.248 -0400", hash_original_method = "AE9127A25AD2517487B4B7EE6A90CDA6", hash_generated_method = "0A5DD2E2508C7439FFFA670A0CD1D994")
    
private ShaderProgram(NativeAllocatorTag tag) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.250 -0400", hash_original_method = "6BD214ABA690DDDD240A6F23D5999ED6", hash_generated_method = "ECA18A7C244011146B0C9C6D33F433B8")
    
public ShaderProgram(FilterContext context, String fragmentShader) {
        mGLEnvironment = getGLEnvironment(context);
        allocate(mGLEnvironment, null, fragmentShader);
        if (!compileAndLink()) {
            throw new RuntimeException("Could not compile and link shader!");
        }
        this.setTimer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.251 -0400", hash_original_method = "32737B50335631A6F61260996AB8FFEB", hash_generated_method = "E4FAF561494436D37EBAF316A9912E50")
    
public ShaderProgram(FilterContext context, String vertexShader, String fragmentShader) {
        mGLEnvironment = getGLEnvironment(context);
        allocate(mGLEnvironment, vertexShader, fragmentShader);
        if (!compileAndLink()) {
            throw new RuntimeException("Could not compile and link shader!");
        }
        this.setTimer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.244 -0400", hash_original_method = "6BB1E70899391AD0D25BCF750ABE6A8F", hash_generated_method = "E49D9FCAAE31C8B0660D5D3014140D6B")
    
private void setTimer() {
        mTimer = new StopWatchMap();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.255 -0400", hash_original_method = "1504DE42C90FC69DAFAB55F0869300BF", hash_generated_method = "2EEA13C3DB2B0DF9F7581C8C3D6CEC6D")
    
@Override
    protected void finalize() throws Throwable {
        deallocate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.256 -0400", hash_original_method = "775B48885FEEEE864377B7024CEEE1C9", hash_generated_method = "D79682786AAE3AD98CE337A50C288E86")
    
public GLEnvironment getGLEnvironment() {
        return mGLEnvironment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.259 -0400", hash_original_method = "5DE0534F25E21D859A2D0954022F8CDF", hash_generated_method = "C526B7FAD2141F7552FF456FC317D9D5")
    
@Override
    public void process(Frame[] inputs, Frame output) {
        if (mTimer.LOG_MFF_RUNNING_TIMES) {
          mTimer.start("glFinish");
          GLES20.glFinish();
          mTimer.stop("glFinish");
        }

        // Get the GL input frames
        // TODO: We do the same in the NativeProgram... can we find a better way?!
        GLFrame[] glInputs = new GLFrame[inputs.length];
        for (int i = 0; i < inputs.length; ++i) {
            if (inputs[i] instanceof GLFrame) {
                glInputs[i] = (GLFrame)inputs[i];
            } else {
                throw new RuntimeException("ShaderProgram got non-GL frame as input " + i + "!");
            }
        }

        // Get the GL output frame
        GLFrame glOutput = null;
        if (output instanceof GLFrame) {
            glOutput = (GLFrame)output;
        } else {
            throw new RuntimeException("ShaderProgram got non-GL output frame!");
        }

        // Adjust tiles to meet maximum tile size requirement
        if (mMaxTileSize > 0) {
            int xTiles = (output.getFormat().getWidth() + mMaxTileSize - 1) / mMaxTileSize;
            int yTiles = (output.getFormat().getHeight() + mMaxTileSize - 1) / mMaxTileSize;
            setShaderTileCounts(xTiles, yTiles);
        }

        // Process!
        if (!shaderProcess(glInputs, glOutput)) {
            throw new RuntimeException("Error executing ShaderProgram!");
        }

        if (mTimer.LOG_MFF_RUNNING_TIMES) {
          GLES20.glFinish();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.261 -0400", hash_original_method = "04EECC9975AC42765786EBB5CFB9825A", hash_generated_method = "48411680E81DF1D57F575BE2E7795AE6")
    
@Override
    public void setHostValue(String variableName, Object value) {
        if (!setUniformValue(variableName, value)) {
            throw new RuntimeException("Error setting uniform value for variable '" +
                                       variableName + "'!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.263 -0400", hash_original_method = "3DA20383920306F379A48A5BE9364144", hash_generated_method = "A97C5C97642E0A5DA60EB7D4940354E1")
    
@Override
    public Object getHostValue(String variableName) {
        return getUniformValue(variableName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.265 -0400", hash_original_method = "4CF0B6ACA5C5D6252751C0C1210ECDBC", hash_generated_method = "41ECF144126EBC62C44691036462EE99")
    
public void setAttributeValues(String attributeName, float[] data, int componentCount) {
        if (!setShaderAttributeValues(attributeName, data, componentCount)) {
            throw new RuntimeException("Error setting attribute value for attribute '" +
                                       attributeName + "'!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.267 -0400", hash_original_method = "EF76F102239AD9488B87164DCD078594", hash_generated_method = "0F80212510F1C4711E959908DF960D0E")
    
public void setAttributeValues(String attributeName,
                                   VertexFrame vertexData,
                                   int type,
                                   int componentCount,
                                   int strideInBytes,
                                   int offsetInBytes,
                                   boolean normalize) {
        if (!setShaderAttributeVertexFrame(attributeName,
                                           vertexData,
                                           type,
                                           componentCount,
                                           strideInBytes,
                                           offsetInBytes,
                                           normalize)) {
            throw new RuntimeException("Error setting attribute value for attribute '" +
                                       attributeName + "'!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.269 -0400", hash_original_method = "763C8515856505F67519375A5AA1D612", hash_generated_method = "0F10EFB77A57B8282477B500B7F12555")
    
public void setSourceRegion(Quad region) {
        setSourceRegion(region.p0.x, region.p0.y,
                        region.p1.x, region.p1.y,
                        region.p2.x, region.p2.y,
                        region.p3.x, region.p3.y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.271 -0400", hash_original_method = "C536D075FBDF744AD4AEF2D183B94695", hash_generated_method = "6B1CB533B8FAD7A561AB446A3E574E86")
    
public void setTargetRegion(Quad region) {
        setTargetRegion(region.p0.x, region.p0.y,
                        region.p1.x, region.p1.y,
                        region.p2.x, region.p2.y,
                        region.p3.x, region.p3.y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.273 -0400", hash_original_method = "897822FAD3E84F8913613761E339A564", hash_generated_method = "2A2FF24FB1BF5D567D934032B12E0B8D")
    
public void setSourceRect(float x, float y, float width, float height) {
        setSourceRegion(x, y, x + width, y, x, y + height, x + width, y + height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.274 -0400", hash_original_method = "F58E34D67A280527F5928E58994D8C0E", hash_generated_method = "565429F53096E38D9828B9688E1C5C87")
    
public void setTargetRect(float x, float y, float width, float height) {
        setTargetRegion(x, y, x + width, y, x, y + height, x + width, y + height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.276 -0400", hash_original_method = "29576BE94042AAFFBC84FC11EBB5FEEE", hash_generated_method = "288DAAFB21A424CC1F1E63C7E3F74F4A")
    
public void setClearsOutput(boolean clears) {
        if (!setShaderClearsOutput(clears)) {
            throw new RuntimeException("Could not set clears-output flag to " + clears + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.280 -0400", hash_original_method = "BAD695006CB0180A7B0E3DD75E420801", hash_generated_method = "251B1B9B4FB1CD17F3630A72536CEA26")
    
public void setClearColor(float r, float g, float b) {
        if (!setShaderClearColor(r, g, b)) {
            throw new RuntimeException("Could not set clear color to " + r + "," + g + "," + b + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.281 -0400", hash_original_method = "4EDA2C5699F628E98D047C0D0D891DF2", hash_generated_method = "9FB4F233011AD4FF1B57F24BD7A59008")
    
public void setBlendEnabled(boolean enable) {
        if (!setShaderBlendEnabled(enable)) {
            throw new RuntimeException("Could not set Blending " + enable + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.284 -0400", hash_original_method = "F743795CF35775237C5FD48321A93CC7", hash_generated_method = "43812E73B9B809DFB95D5120E8B9BA66")
    
public void setBlendFunc(int sfactor, int dfactor) {
        if (!setShaderBlendFunc(sfactor, dfactor)) {
            throw new RuntimeException("Could not set BlendFunc " + sfactor +","+ dfactor + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.286 -0400", hash_original_method = "710CD251D2DA048402017307FE7DAE54", hash_generated_method = "383C9BB51393B4973B6AD5ACD528581A")
    
public void setDrawMode(int drawMode) {
        if (!setShaderDrawMode(drawMode)) {
            throw new RuntimeException("Could not set GL draw-mode to " + drawMode + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.287 -0400", hash_original_method = "67EF6CE79CE6905E89A3C18F1FDEDB55", hash_generated_method = "F5C47ED5317D9D03A695B9C28DE0BC7D")
    
public void setVertexCount(int count) {
        if (!setShaderVertexCount(count)) {
            throw new RuntimeException("Could not set GL vertex count to " + count + "!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.289 -0400", hash_original_method = "72729B7C54CC6E0D1F2CDB852CC79F37", hash_generated_method = "A93A1611351366972EF188C25B53229E")
    
public void setMaximumTileSize(int size) {
        mMaxTileSize = size;
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.291 -0400", hash_original_method = "55BE2AFE744B5F6494D915D6BF1A5EC4", hash_generated_method = "7B31502AA89BE478EBCEB2FAA108D2F4")
    
public void beginDrawing() {
        if (!beginShaderDrawing()) {
            throw new RuntimeException("Could not prepare shader-program for drawing!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.016 -0400", hash_original_method = "AD8EBD757B796519C7E5ACF0CFD1BD15", hash_generated_method = "62E417014727322DCD9F3B4CA7393ACC")
    
    private boolean allocate(GLEnvironment glEnv,
                                        String vertexShader,
                                        String fragmentShader){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += glEnv.getTaintInt();
    	taintDouble += vertexShader.getTaintInt();
    	taintDouble += fragmentShader.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:45.090 -0400", hash_original_method = "9146149D3DCC230E7EA94BBBF3368A15", hash_generated_method = "E7FC21276ACAD27B060DD1829450FA9C")
    
    private boolean deallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:45.093 -0400", hash_original_method = "8AF148E20F2332AA6C9887D50C0F196C", hash_generated_method = "94778360B3ACE73928DE8B6E44A291EC")
    
    private boolean compileAndLink(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.027 -0400", hash_original_method = "56CACE7B1111C40C912A571DEA490194", hash_generated_method = "60DE510454E6012A957ADDB59F73DBAE")
    
    private boolean shaderProcess(GLFrame[] inputs, GLFrame output){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += inputs[0].getTaintInt();
    	taintDouble += output.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.031 -0400", hash_original_method = "02242603F41A919B6900325BC0CB472A", hash_generated_method = "400D93FBD418C26255680F8581E00D4A")
    
    private boolean setUniformValue(String name, Object value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += name.getTaintInt();
    	taintDouble += value.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.035 -0400", hash_original_method = "0375EA9105518F02B068F631222F799F", hash_generated_method = "1FA273FA8F6DD7AF2403597560FCD31F")
    
    private Object getUniformValue(String name){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += name.getTaintInt();
    	addTaint(taintDouble);
    
    	Object retObj = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.040 -0400", hash_original_method = "4F9E5F5A1C81EB9F81B8A264C64333EA", hash_generated_method = "8B7120AD46851075F3D32EC12153E400")
    
    public boolean setSourceRegion(float x0, float y0, float x1, float y1,
                                              float x2, float y2, float x3, float y3){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x0;
    	taintDouble += y0;
    	taintDouble += x1;
    	taintDouble += y1;
    	taintDouble += x2;
    	taintDouble += y2;
    	taintDouble += x3;
    	taintDouble += y3;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.044 -0400", hash_original_method = "0A6D1E9787CD1A3592E7EE16DE33F6B5", hash_generated_method = "4E06F509C514A883DFD5876F7F9761A4")
    
    private boolean setTargetRegion(float x0, float y0, float x1, float y1,
                                               float x2, float y2, float x3, float y3){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += x0;
    	taintDouble += y0;
    	taintDouble += x1;
    	taintDouble += y1;
    	taintDouble += x2;
    	taintDouble += y2;
    	taintDouble += x3;
    	taintDouble += y3;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:55.171 -0400", hash_original_method = "DA0853BF797039D07ABAFD6B37FC6FE4", hash_generated_method = "00648FEA05B728146448D30C3B3F27A9")
    
    private boolean setShaderClearsOutput(boolean clears){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((clears) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:55.174 -0400", hash_original_method = "A877920A933240EB26149604AF6DAB65", hash_generated_method = "5837E6038E807F3EECE2CB085E972852")
    
    private boolean setShaderBlendEnabled(boolean enable){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((enable) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.061 -0400", hash_original_method = "A703E8E2D56F488E1B7A9936A9DB9BCF", hash_generated_method = "12F09D52B4C49EB64D19D862A7BF10CD")
    
    private boolean setShaderBlendFunc(int sfactor, int dfactor){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sfactor;
    	taintDouble += dfactor;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.065 -0400", hash_original_method = "174C7B19100D70D5D83DBF0E71D8C40D", hash_generated_method = "A75019B7BA64CDAF150422CDE400D3BC")
    
    private boolean setShaderClearColor(float r, float g, float b){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += r;
    	taintDouble += g;
    	taintDouble += b;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.069 -0400", hash_original_method = "4F5825A74EACEDBEA33A8AE3B2BA1DE1", hash_generated_method = "965FE68B00B4D6A1D4B05AD04B7F1030")
    
    private boolean setShaderDrawMode(int drawMode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += drawMode;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.074 -0400", hash_original_method = "7E24AA3DE2F23987F17F823DAD41B466", hash_generated_method = "CE408237BB5377D7CF0AE12235E9F108")
    
    private boolean setShaderTileCounts(int xCount, int yCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += xCount;
    	taintDouble += yCount;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.077 -0400", hash_original_method = "F5CCA9000D603F753022C746FC4B770D", hash_generated_method = "D5DD67C845ABF42485BFFC0509F8D0FC")
    
    private boolean setShaderVertexCount(int vertexCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += vertexCount;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:45.136 -0400", hash_original_method = "CE528040139B9F0A51E33CE767D23A1B", hash_generated_method = "A5062FD61C3787A7DB9FD9C359858447")
    
    private boolean beginShaderDrawing(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:23.085 -0400", hash_original_method = "166895198048089D3756FB69404DAC65", hash_generated_method = "24CD0C16BA9C77F60B1E51E82A2B5D5A")
    
    private boolean setShaderAttributeValues(String attributeName,
                                                        float[] data,
                                                        int componentCount){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += attributeName.getTaintInt();
    	taintDouble += data[0];
    	taintDouble += componentCount;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:55.199 -0400", hash_original_method = "B344A961881B5E424A682809764F8CAF", hash_generated_method = "4196466FAF318599905A2517E6F18EB7")
    
    private boolean setShaderAttributeVertexFrame(String attributeName,
                                                             VertexFrame vertexData,
                                                             int type,
                                                             int componentCount,
                                                             int strideInBytes,
                                                             int offsetInBytes,
                                                             boolean normalize){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += attributeName.getTaintInt();
    	taintDouble += vertexData.getTaintInt();
    	taintDouble += type;
    	taintDouble += componentCount;
    	taintDouble += strideInBytes;
    	taintDouble += offsetInBytes;
    	taintDouble += ((normalize) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

}
