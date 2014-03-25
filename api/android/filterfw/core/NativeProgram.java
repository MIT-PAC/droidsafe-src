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
import android.filterfw.core.Program;

/**
 * @hide
 */
public class NativeProgram extends Program {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.387 -0400", hash_original_field = "9E4FD8543244C11F15D39F4BEB5B8903", hash_generated_field = "5FADD543268208F1A2C9263DACDD9C76")


    private int nativeProgramId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.389 -0400", hash_original_field = "86EFEC189881D431D765CE915E4A8D83", hash_generated_field = "D808E5B5C18A4E356F684A7D4FCC63C8")

    private boolean mHasInitFunction     = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.391 -0400", hash_original_field = "3CD1E3C84F948A5D22559C5A880D5AFF", hash_generated_field = "978A9D6C8845025ED028D1945EF5BFB7")

    private boolean mHasTeardownFunction = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.394 -0400", hash_original_field = "6B63BB2577F0D673C278C8E1261DE15A", hash_generated_field = "0FDD4AF4933B74DAC344737E9885D828")

    private boolean mHasSetValueFunction = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.395 -0400", hash_original_field = "271C9258A1CF4960D763922C699B0B05", hash_generated_field = "68B1D68051031866AD54247664CA8D87")

    private boolean mHasGetValueFunction = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.397 -0400", hash_original_field = "F888AB12289A462C1110DC2CB7E8188A", hash_generated_field = "C6984C2479B9AC6B44A65332CD115574")

    private boolean mHasResetFunction = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.399 -0400", hash_original_field = "7286B1F76FE6DE391965FC9246672FF9", hash_generated_field = "A0684676DF87D106D2C87B72F1BE9355")

    private boolean mTornDown = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.402 -0400", hash_original_method = "EF6B8443D0B0CF50960907DDD5F68105", hash_generated_method = "CFF7021C7123E885A4FB91A9FC34E3ED")
    
public NativeProgram(String nativeLibName, String nativeFunctionPrefix) {
        // Allocate the native instance
        allocate();

        // Open the native library
        String fullLibName = "lib" + nativeLibName + ".so";
        if (!openNativeLibrary(fullLibName)) {
            throw new RuntimeException("Could not find native library named '" + fullLibName + "' " +
                                       "required for native program!");
        }

        // Bind the native functions
        String processFuncName = nativeFunctionPrefix + "_process";
        if (!bindProcessFunction(processFuncName)) {
            throw new RuntimeException("Could not find native program function name " +
                                       processFuncName + " in library " + fullLibName + "! " +
                                       "This function is required!");
        }

        String initFuncName = nativeFunctionPrefix + "_init";
        mHasInitFunction = bindInitFunction(initFuncName);

        String teardownFuncName = nativeFunctionPrefix + "_teardown";
        mHasTeardownFunction = bindTeardownFunction(teardownFuncName);

        String setValueFuncName = nativeFunctionPrefix + "_setvalue";
        mHasSetValueFunction = bindSetValueFunction(setValueFuncName);

        String getValueFuncName = nativeFunctionPrefix + "_getvalue";
        mHasGetValueFunction = bindGetValueFunction(getValueFuncName);

        String resetFuncName = nativeFunctionPrefix + "_reset";
        mHasResetFunction = bindResetFunction(resetFuncName);

        // Initialize the native code
        if (mHasInitFunction && !callNativeInit()) {
            throw new RuntimeException("Could not initialize NativeProgram!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.404 -0400", hash_original_method = "A8D9DA2DC24A5D24C17C9740CB452F66", hash_generated_method = "8AC1059543D2106B5AD17057D14E40F8")
    
public void tearDown() {
        if (mTornDown) return;
        if (mHasTeardownFunction && !callNativeTeardown()) {
            throw new RuntimeException("Could not tear down NativeProgram!");
        }
        deallocate();
        mTornDown = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.407 -0400", hash_original_method = "2974577D2FF10FE99BC709C128CCF288", hash_generated_method = "A7FFA151563851325AD4A7B46BFC3661")
    
@Override
    public void reset() {
        if (mHasResetFunction && !callNativeReset()) {
            throw new RuntimeException("Could not reset NativeProgram!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.409 -0400", hash_original_method = "1634EBECADA1FE321270115B4A33248F", hash_generated_method = "089C66A5C5C16B1989FEE832F678C8A4")
    
@Override
    protected void finalize() throws Throwable {
        tearDown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.411 -0400", hash_original_method = "BE487E00D582872B6928F533F20EA631", hash_generated_method = "4DBCFF52A516D9D63F16A074F28B156D")
    
@Override
    public void process(Frame[] inputs, Frame output) {
        if (mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        NativeFrame[] nativeInputs = new NativeFrame[inputs.length];
        for (int i = 0; i < inputs.length; ++i) {
            if (inputs[i] == null || inputs[i] instanceof NativeFrame) {
                nativeInputs[i] = (NativeFrame)inputs[i];
            } else {
                throw new RuntimeException("NativeProgram got non-native frame as input "+ i +"!");
            }
        }

        // Get the native output frame
        NativeFrame nativeOutput = null;
        if (output == null || output instanceof NativeFrame) {
            nativeOutput = (NativeFrame)output;
        } else {
            throw new RuntimeException("NativeProgram got non-native output frame!");
        }

        // Process!
        if (!callNativeProcess(nativeInputs, nativeOutput)) {
            throw new RuntimeException("Calling native process() caused error!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.414 -0400", hash_original_method = "533DBCCD1FB82ABD0489310768703CF5", hash_generated_method = "732E3F598AE7829DD1093D048C02D85E")
    
@Override
    public void setHostValue(String variableName, Object value) {
        if (mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        if (!mHasSetValueFunction) {
            throw new RuntimeException("Attempting to set native variable, but native code does not " +
                                       "define native setvalue function!");
        }
        if (!callNativeSetValue(variableName, value.toString())) {
            throw new RuntimeException("Error setting native value for variable '" + variableName + "'!");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.416 -0400", hash_original_method = "158D8F90EF08C4FC60EF48DEBD0E55BB", hash_generated_method = "83A2B9FDA40613CF587965342B21C438")
    
@Override
    public Object getHostValue(String variableName) {
        if (mTornDown) {
            throw new RuntimeException("NativeProgram already torn down!");
        }
        if (!mHasGetValueFunction) {
            throw new RuntimeException("Attempting to get native variable, but native code does not " +
                                       "define native getvalue function!");
        }
        return callNativeGetValue(variableName);
    }

    static {
        System.loadLibrary("filterfw");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.130 -0400", hash_original_method = "606CABFBE6CEF619DB8189367525C522", hash_generated_method = "041513B0EE3CC45A1EEDFCE2E59EB56E")
    
    private boolean allocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.132 -0400", hash_original_method = "9146149D3DCC230E7EA94BBBF3368A15", hash_generated_method = "E7FC21276ACAD27B060DD1829450FA9C")
    
    private boolean deallocate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.135 -0400", hash_original_method = "2A16798BAAF58E9C0902644312AE4C96", hash_generated_method = "5FEA9AA00CA1A7C2DF8BB94737ABD49F")
    
    private boolean nativeInit(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.056 -0400", hash_original_method = "EDFBA5170FC1AEB79109BC7DA0CA3F81", hash_generated_method = "D83398C3A44A270598A12E8EBE7EDF55")
    
    private boolean openNativeLibrary(String libName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += libName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.060 -0400", hash_original_method = "A18B0CB04C76BEFD8BDA3D587DD6D5ED", hash_generated_method = "4AACCBEC3B2C0693312FF10FF948334C")
    
    private boolean bindInitFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.063 -0400", hash_original_method = "AF36DC66D95255D05B92761F0B0AF14B", hash_generated_method = "3AB9FB6CC306C37CCE8DDCDD98F9DD4C")
    
    private boolean bindSetValueFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.067 -0400", hash_original_method = "951C017F6A3DB62B76B242CE4361AC0B", hash_generated_method = "A07DAC91C3D9E4029F850CB6125B0F91")
    
    private boolean bindGetValueFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.072 -0400", hash_original_method = "AF8AB256829AA4624261077B41141ED4", hash_generated_method = "8D61A6F3816D502839CA298726FD5AF8")
    
    private boolean bindProcessFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.076 -0400", hash_original_method = "FFD947916C968CB7419676711DFF8B55", hash_generated_method = "4357E1CC8B68D372C89616418F29193D")
    
    private boolean bindResetFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.081 -0400", hash_original_method = "90ABF7DBAFD9B313091F3F963485A45A", hash_generated_method = "39DFE23E733C030CFF55ECE94041D344")
    
    private boolean bindTeardownFunction(String funcName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += funcName.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.157 -0400", hash_original_method = "A8B4FE8D95A9EFAB156D3D53298ED8C4", hash_generated_method = "AE9141634CA0BCB5A23EAE94D8804D1E")
    
    private boolean callNativeInit(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.089 -0400", hash_original_method = "7A0743A8AD090CD973795EC8E9D29080", hash_generated_method = "185BFE27EE6FD57E846940FE4FAC2C3B")
    
    private boolean callNativeSetValue(String key, String value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += key.getTaintInt();
    	taintDouble += value.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.093 -0400", hash_original_method = "B78DA7D8F71349ED8BCEC32E6E5DBB68", hash_generated_method = "7057B1C804BC2139DF2E898A908B9960")
    
    private String  callNativeGetValue(String key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += key.getTaintInt();
    	addTaint(taintDouble);
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:22.097 -0400", hash_original_method = "DA32E3E33D7F3D40A803EF7263C04FE3", hash_generated_method = "34CF9D946FEFF6063063A0C7C3D2F4DA")
    
    private boolean callNativeProcess(NativeFrame[] inputs, NativeFrame output){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += inputs[0].getTaintInt();
    	taintDouble += output.getTaintInt();
    	addTaint(taintDouble);
    
    	return toTaintBoolean(taintDouble);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.170 -0400", hash_original_method = "0817ED5A93B361D3F369BA9A37FB243C", hash_generated_method = "F2526CE4EA0FC747100898B0CAA1944D")
    
    private boolean callNativeReset(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:44.172 -0400", hash_original_method = "7BEDC8CC0BE7FB55DC419DF8DE5919BD", hash_generated_method = "4C05CFF3AB2D3FDB5FCBEAF5082DD8BE")
    
    private boolean callNativeTeardown(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }





}
