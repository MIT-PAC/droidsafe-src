/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.mtp;

/**
 * Java wrapper for MTP/PTP support as USB responder.
 * {@hide}
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class MtpServer implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.228 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext; // accessed by native methods

    static {
        System.loadLibrary("media_jni");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.230 -0400", hash_original_method = "BD8F26FDC5527EB4E92BC62A3376CF64", hash_generated_method = "4B9039A96783CC919C56D7D3F1FC33AD")
    
public MtpServer(MtpDatabase database, boolean usePtp) {
        native_setup(database, usePtp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.232 -0400", hash_original_method = "B5FA8FEB72D8657A88924A25DA209806", hash_generated_method = "6B66A1E8B7AA63556A8145C7C18618C3")
    
public void start() {
        Thread thread = new Thread(this, "MtpServer");
        thread.start();
    }

    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.233 -0400", hash_original_method = "47A2D6674D1EEAC8AA96E1344486E702", hash_generated_method = "3F993A79C0313074FABF5C95414A3729")
    
@Override
    public void run() {
        native_run();
        native_cleanup();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.235 -0400", hash_original_method = "00E9FC2A3372ECE0E888D77AA580E97E", hash_generated_method = "0B00A7E983E30D0FBA7E5B13F506382A")
    
public void sendObjectAdded(int handle) {
        native_send_object_added(handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.236 -0400", hash_original_method = "A73ADCEEF9374529FD85595CDB0E21C3", hash_generated_method = "64C00D52864C9848B3DE5E6EB5F567E4")
    
public void sendObjectRemoved(int handle) {
        native_send_object_removed(handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.238 -0400", hash_original_method = "8DF9F88D7D957874999BF22D1196FB88", hash_generated_method = "773F2FC08DAA4963827F1EB2FD35F987")
    
public void addStorage(MtpStorage storage) {
        native_add_storage(storage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.239 -0400", hash_original_method = "1D4F66AC7A896EE347D02F572E34084B", hash_generated_method = "799A10754FFB6093744336CDF6B96447")
    
public void removeStorage(MtpStorage storage) {
        native_remove_storage(storage.getStorageId());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:03.936 -0400", hash_original_method = "5FEE514F50AD55E7B724713DA7FEC810", hash_generated_method = "A652C2FEBCEF4C6F8056F75E26CB7B49")
    
    private final void native_setup(MtpDatabase database, boolean usePtp){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += database.getTaintInt();
    	taintDouble += toTaintInt(usePtp);
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:05.611 -0400", hash_original_method = "E94ACA191BED3F3D7A2148F1B0D4EC8F", hash_generated_method = "B6ACDBFBA80903BACF89BA47C78574F7")
    
    private final void native_run(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:05.613 -0400", hash_original_method = "A098D63B2B29BB5A50065EC818943345", hash_generated_method = "0C6D1BF9D0265CD50B39BB36F125CCA6")
    
    private final void native_cleanup(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.176 -0400", hash_original_method = "469EF3FF9AABC1B1F9F45D9204598DB3", hash_generated_method = "7B5F7FC2A37C059BB342B311424A8590")
    
    private final void native_send_object_added(int handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.179 -0400", hash_original_method = "ACC0B9B028B3EF7A3717B1D0A68BC039", hash_generated_method = "09B5E2F005C7F7EEA1E01E074383C660")
    
    private final void native_send_object_removed(int handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.183 -0400", hash_original_method = "572AA0F12870D9D03E049A39CEEAB4F6", hash_generated_method = "F2577DC3B5C95051C042263F29B93B66")
    
    private final void native_add_storage(MtpStorage storage){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += storage.getTaintInt();
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.187 -0400", hash_original_method = "EDD5A18F5BAC4C91DE0CB60B2012854F", hash_generated_method = "B9EE075BA2D1DB002C86D274C88F0D3E")
    
    private final void native_remove_storage(int storageId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += storageId;
    	addTaint(taintDouble);
    }

}
