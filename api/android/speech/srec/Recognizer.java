/*
 * ---------------------------------------------------------------------------
 * Recognizer.java
 * 
 * Copyright 2007 Nuance Communciations, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not
 * use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * ---------------------------------------------------------------------------
 */

package android.speech.srec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.util.Locale;

/**
 * Simple, synchronous speech recognizer, using the Nuance SREC package.
 * Usages proceeds as follows:
 * 
 * <ul>
 * <li>Create a <code>Recognizer</code>.
 * <li>Create a <code>Recognizer.Grammar</code>.
 * <li>Setup the <code>Recognizer.Grammar</code>.
 * <li>Reset the <code>Recognizer.Grammar</code> slots, if needed.
 * <li>Fill the <code>Recognizer.Grammar</code> slots, if needed.
 * <li>Compile the <code>Recognizer.Grammar</code>, if needed.
 * <li>Save the filled <code>Recognizer.Grammar</code>, if needed.
 * <li>Start the <code>Recognizer</code>.
 * <li>Loop over <code>advance</code> and <code>putAudio</code> until recognition complete.
 * <li>Fetch and process results, or notify of failure.
 * <li>Stop the <code>Recognizer</code>.
 * <li>Destroy the <code>Recognizer</code>.
 * </ul>
 * 
 * <p>Below is example code</p>
 * 
 * <pre class="prettyprint">
 * 
 * // create and start audio input
 * InputStream audio = new MicrophoneInputStream(11025, 11025*5);
 * // create a Recognizer
 * String cdir = Recognizer.getConfigDir(null);
 * Recognizer recognizer = new Recognizer(cdir + "/baseline11k.par");
 * // create and load a Grammar
 * Recognizer.Grammar grammar = recognizer.new Grammar(cdir + "/grammars/VoiceDialer.g2g");
 * // setup the Grammar to work with the Recognizer
 * grammar.setupRecognizer();
 * // fill the Grammar slots with names and save, if required
 * grammar.resetAllSlots();
 * for (String name : names) grammar.addWordToSlot("@Names", name, null, 1, "V=1");
 * grammar.compile();
 * grammar.save(".../foo.g2g");
 * // start the Recognizer
 * recognizer.start();
 * // loop over Recognizer events
 * while (true) {
 *     switch (recognizer.advance()) {
 *     case Recognizer.EVENT_INCOMPLETE:
 *     case Recognizer.EVENT_STARTED:
 *     case Recognizer.EVENT_START_OF_VOICING:
 *     case Recognizer.EVENT_END_OF_VOICING:
 *         // let the Recognizer continue to run
 *         continue;
 *     case Recognizer.EVENT_RECOGNITION_RESULT:
 *         // success, so fetch results here!
 *         for (int i = 0; i < recognizer.getResultCount(); i++) {
 *             String result = recognizer.getResult(i, Recognizer.KEY_LITERAL);
 *         }
 *         break;
 *     case Recognizer.EVENT_NEED_MORE_AUDIO:
 *         // put more audio in the Recognizer
 *         recognizer.putAudio(audio);
 *         continue;
 *     default:
 *         notifyFailure();
 *         break;
 *     }
 *     break;
 * }
 * // stop the Recognizer
 * recognizer.stop();
 * // destroy the Recognizer
 * recognizer.destroy();
 * // stop the audio device
 * audio.close();
 * 
 * </pre>
 */
public final class Recognizer {
    static {
        System.loadLibrary("srec_jni");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.565 -0400", hash_original_field = "5080775A99D45CC6DDFCF03BE6022990", hash_generated_field = "28B7F77EC056AE8A59F8AC3C83B7FC39")

    private static String TAG = "Recognizer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.575 -0400", hash_original_field = "3488A26F340F9C164A711388BEE3FB0D", hash_generated_field = "A9F59F619A46E1A734F97229DA9AD65C")

    public static final String KEY_CONFIDENCE = "conf";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.583 -0400", hash_original_field = "F9B2D3C8F09BA1B22B731AF95F6A84E3", hash_generated_field = "FCD4281938FEC01A4ED630172896067E")

    public static final String KEY_LITERAL = "literal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.589 -0400", hash_original_field = "44B6FE31D4DD3F76781BA6AB0EEFB714", hash_generated_field = "C3761003171DD262A57E60ED818404EC")

    public static final String KEY_MEANING = "meaning";
    
    /**
     * Get the pathname of the SREC configuration directory corresponding to the
     * language indicated by the Locale.
     * This directory contains dictionaries, speech models,
     * configuration files, and other data needed by the Recognizer.
     * @param locale <code>Locale</code> corresponding to the desired language,
     * or null for default, currently <code>Locale.US</code>.
     * @return Pathname of the configuration directory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.629 -0400", hash_original_method = "5493F78C87F3F712784A5C1E5ACCD609", hash_generated_method = "288DBD9C058E35DA3300DA77BF6C61CA")
    
public static String getConfigDir(Locale locale) {
        if (locale == null) locale = Locale.US;
        String dir = "/system/usr/srec/config/" +
                locale.toString().replace('_', '.').toLowerCase();
        if ((new File(dir)).isDirectory()) return dir;
        return null;
    }
    
    /* an example session captured, for reference
    void doall() {
        if (PMemInit ( )
           || lhs_audioinOpen ( WAVE_MAPPER, SREC_TEST_DEFAULT_AUDIO_FREQUENCY, &audio_in_handle )
           || srec_test_init_application_data ( &applicationData, argc, argv )
           || SR_SessionCreate ( "/system/usr/srec/config/en.us/baseline11k.par" )
           || SR_RecognizerCreate ( &applicationData.recognizer )
           || SR_RecognizerSetup ( applicationData.recognizer)
           || ESR_SessionGetLCHAR ( L("cmdline.vocabulary"), filename, &flen )
           || SR_VocabularyLoad ( filename, &applicationData.vocabulary )
           || SR_VocabularyGetLanguage ( applicationData.vocabulary, &applicationData.locale )
           || (applicationData.nametag = NULL)
           || SR_NametagsCreate ( &applicationData.nametags )
           || (LSTRCPY ( applicationData.grammars [0].grammar_path, "/system/usr/srec/config/en.us/grammars/VoiceDialer.g2g" ), 0)
           || (LSTRCPY ( applicationData.grammars [0].grammarID, "BothTags" ), 0)
           || (LSTRCPY ( applicationData.grammars [0].ruleName, "trash" ), 0)
           || (applicationData.grammars [0].is_ve_grammar = ESR_FALSE, 0)
           || SR_GrammarLoad (applicationData.grammars [0].grammar_path, &applicationData.grammars [applicationData.grammarCount].grammar )
           || SR_GrammarSetupVocabulary ( applicationData.grammars [0].grammar, applicationData.vocabulary )
           || SR_GrammarSetupRecognizer( applicationData.grammars [0].grammar, applicationData.recognizer )
           || SR_GrammarSetDispatchFunction ( applicationData.grammars [0].grammar, L("myDSMCallback"), NULL, myDSMCallback )
           || (applicationData.grammarCount++, 0)
           || SR_RecognizerActivateRule ( applicationData.recognizer, applicationData.grammars [0].grammar,
                           applicationData.grammars [0].ruleName, 1 )
           || (applicationData.active_grammar_num = 0, 0)
           || lhs_audioinStart ( audio_in_handle )
           || SR_RecognizerStart ( applicationData.recognizer )
           || strl ( applicationData.grammars [0].grammar, &applicationData, audio_in_handle, &recognition_count )
           || SR_RecognizerStop ( applicationData.recognizer )
           || lhs_audioinStop ( audio_in_handle )
           || SR_RecognizerDeactivateRule ( applicationData.recognizer, applicationData.grammars [0].grammar, applicationData.grammars [0].ruleName )
           || (applicationData.active_grammar_num = -1, 0)
           || SR_GrammarDestroy ( applicationData.grammars [0].grammar )
           || (applicationData.grammarCount--, 0)
           || SR_NametagsDestroy ( applicationData.nametags )
           || (applicationData.nametags = NULL, 0)
           || SR_VocabularyDestroy ( applicationData.vocabulary )
           || (applicationData.vocabulary = NULL)
           || SR_RecognizerUnsetup ( applicationData.recognizer) // releases acoustic models
           || SR_RecognizerDestroy ( applicationData.recognizer )
           || (applicationData.recognizer = NULL)
           || SR_SessionDestroy ( )
           || srec_test_shutdown_application_data ( &applicationData )
           || lhs_audioinClose ( &audio_in_handle )
           || PMemShutdown ( )
    }
    */

    //
    // PMem native methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.814 -0400", hash_original_method = "5937AF5165A3242A336E7DD8114E7737", hash_generated_method = "C9D96CF65461B1E5E89CCE29FE1BE5F7")
    
    private static void PMemInit(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.822 -0400", hash_original_method = "0FE1CB7A8F64192D556D7C73E4E789B0", hash_generated_method = "816FB2541E545D4178C517272DE2CEF4")
    
    private static void PMemShutdown(){
    	//Formerly a native method
    }

    //
    // SR_Session native methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.829 -0400", hash_original_method = "CB67A4A0682C4C9E364765F74226BA70", hash_generated_method = "7C354F02704306F23AF3DEBEE0183318")
    
    private static void SR_SessionCreate(String filename){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.836 -0400", hash_original_method = "1708C64C0212B37EB64B4CF999B93CAA", hash_generated_method = "2F4A62AA8722A492CDB2D51889D7AA0A")
    
    private static void SR_SessionDestroy(){
    	//Formerly a native method
    }

    /**
     * Represents a grammar loaded into the Recognizer.
     */
    public class Grammar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.644 -0400", hash_original_field = "35A4AA96C74D06029E263D076DEF0080", hash_generated_field = "AAF82375D12922935AB50FAB64C8BB12")

        private int mGrammar = 0;

        /**
         * Create a <code>Grammar</code> instance.
         * @param g2gFileName pathname of g2g file.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.652 -0400", hash_original_method = "21FDE1E7DBC4A0A5AEE7F5845398B503", hash_generated_method = "B740A096E1BAF578B1B2C46C2B2FC316")
        
public Grammar(String g2gFileName) throws IOException {
            mGrammar = SR_GrammarLoad(g2gFileName);
            SR_GrammarSetupVocabulary(mGrammar, mVocabulary);
        }

        /**
         * Reset all slots.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.660 -0400", hash_original_method = "29EA35F6FB0E6D052E871169B2D3DF12", hash_generated_method = "F779F844A3F9E5AA3C3DEACB8DA1C9E6")
        
public void resetAllSlots() {
            SR_GrammarResetAllSlots(mGrammar);
        }

        /**
         * Add a word to a slot.
         * 
         * @param slot slot name.
         * @param word word to insert.
         * @param pron pronunciation, or null to derive from word.
         * @param weight weight to give the word.  One is normal, 50 is low.
         * @param tag semantic meaning tag string.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.668 -0400", hash_original_method = "069C034E3A1DA1F7A4E9BE0CC1AAD9AD", hash_generated_method = "92E6B8FD2C7A39C6406C98C9AF69301C")
        
public void addWordToSlot(String slot, String word, String pron, int weight, String tag) {
            SR_GrammarAddWordToSlot(mGrammar, slot, word, pron, weight, tag); 
        }

        /**
         * Compile all slots.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.674 -0400", hash_original_method = "CC62B3AE287BE9611AD8DB95C455A800", hash_generated_method = "9D58C88BAC8C9AE7235FE5DA19972734")
        
public void compile() {
            SR_GrammarCompile(mGrammar);
        }

        /**
         * Setup <code>Grammar</code> with <code>Recognizer</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.680 -0400", hash_original_method = "D072026C8067E44AB24AC588257A4915", hash_generated_method = "918F89F38826546C6B14C9DEF02661C7")
        
public void setupRecognizer() {
            SR_GrammarSetupRecognizer(mGrammar, mRecognizer);
            mActiveGrammar = this;
        }

        /**
         * Save <code>Grammar</code> to g2g file.
         * 
         * @param g2gFileName
         * @throws IOException
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.686 -0400", hash_original_method = "F17DBFC7F57232A5AE529942C4D7251B", hash_generated_method = "ADCC31AFFCFC94B7E77FBB5033D03DEE")
        
public void save(String g2gFileName) throws IOException {
            SR_GrammarSave(mGrammar, g2gFileName);
        }

        /**
         * Release resources associated with this <code>Grammar</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.692 -0400", hash_original_method = "FBD9644058871D6B70CEE26395B2811C", hash_generated_method = "6CE490EC4D592776EFA25C8337BE8F7F")
        
public void destroy() {
            // TODO: need to do cleanup and disassociation with Recognizer
            if (mGrammar != 0) {
                SR_GrammarDestroy(mGrammar);
                mGrammar = 0;
            }
        }

        /**
         * Clean up resources.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.698 -0400", hash_original_method = "6716C894A456D859682D2AB42908EF6B", hash_generated_method = "98BB3A25E2A1A577EC358E8063919095")
        
protected void finalize() {
            if (mGrammar != 0) {
                destroy();
                throw new IllegalStateException("someone forgot to destroy Grammar");
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.843 -0400", hash_original_field = "6A4564A1099AB321068CBC0F8BA8368B", hash_generated_field = "7143FCA5495FF6C7B17F86447CC38285")

    // SR_Recognizer native methods
    //
    
    /**
     * Reserved value.
     */
    public final static int EVENT_INVALID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.850 -0400", hash_original_field = "BA550F932657B0BA9B4D237608ED17AD", hash_generated_field = "70872739D956C520B5FC0DCC80B43055")

    public final static int EVENT_NO_MATCH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.856 -0400", hash_original_field = "95DEC247F9966EBADDDC0C9B3104118A", hash_generated_field = "F7769DCAC0D400746AEFAFF29EA9E5A5")

    public final static int EVENT_INCOMPLETE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.862 -0400", hash_original_field = "C725585CCF5063F72FA5298570B02AD9", hash_generated_field = "E201BDFAB1DBA9BC53DF9B263EB9B471")

    public final static int EVENT_STARTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.868 -0400", hash_original_field = "C871A15DC22ED30653C9FD636B506B4C", hash_generated_field = "8F954B6DB7AB8A44CCF107F2C7338186")

    public final static int EVENT_STOPPED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.874 -0400", hash_original_field = "6AD7557A9DDB99F7AE5FF1399BF8D3F8", hash_generated_field = "FD707CA91482AAB5EBAC3A5E2954684C")

    public final static int EVENT_START_OF_VOICING = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.879 -0400", hash_original_field = "5767B4B70E53BCAB1617BE9E39CA1390", hash_generated_field = "50E731FF73945F165BD091F720C793AA")

    public final static int EVENT_END_OF_VOICING = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.885 -0400", hash_original_field = "0FCB7C1892F6FB63DEB1C0FD40CD2430", hash_generated_field = "E0A50BF75DC775B0FB8CFABA932AD251")

    public final static int EVENT_SPOKE_TOO_SOON = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.891 -0400", hash_original_field = "BD5DC5B3F6B9B3C97833FCB6586D3246", hash_generated_field = "85438312EBA030BDDDC158AAEEE32532")

    public final static int EVENT_RECOGNITION_RESULT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.897 -0400", hash_original_field = "19C8F248B18FAFB5580184FAA20CCFE0", hash_generated_field = "479E856C9C044FA2683ED465AB04CA1E")

    public final static int EVENT_START_OF_UTTERANCE_TIMEOUT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.903 -0400", hash_original_field = "E667C1749D583D1F23168AA292CDEB1D", hash_generated_field = "97A88BCD01DC35FF4EADB1556F6C3A3F")

    public final static int EVENT_RECOGNITION_TIMEOUT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.909 -0400", hash_original_field = "F8BBC012DB4456F359561ADF8FF94D6E", hash_generated_field = "49AB02BFB60755A400351303235BEF05")

    public final static int EVENT_NEED_MORE_AUDIO = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.915 -0400", hash_original_field = "BEE0D982F00C48AC7A7668479E0DE888", hash_generated_field = "D4EA24FD23CA321125D5B4E3A2A2C316")

    public final static int EVENT_MAX_SPEECH = 12;

    /**
     * Produce a displayable string from an <code>advance</code> event.
     * @param event
     * @return String representing the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.922 -0400", hash_original_method = "F030DEB01ADC64D40D54BAE8E454A29C", hash_generated_method = "1F7CB548621A095D6F27F0E779C5AF70")
    
public static String eventToString(int event) {
        switch (event) {
            case EVENT_INVALID:
                return "EVENT_INVALID";
            case EVENT_NO_MATCH:
                return "EVENT_NO_MATCH";
            case EVENT_INCOMPLETE:
                return "EVENT_INCOMPLETE";
            case EVENT_STARTED:
                return "EVENT_STARTED";
            case EVENT_STOPPED:
                return "EVENT_STOPPED";
            case EVENT_START_OF_VOICING:
                return "EVENT_START_OF_VOICING";
            case EVENT_END_OF_VOICING:
                return "EVENT_END_OF_VOICING";
            case EVENT_SPOKE_TOO_SOON:
                return "EVENT_SPOKE_TOO_SOON";
            case EVENT_RECOGNITION_RESULT:
                return "EVENT_RECOGNITION_RESULT";
            case EVENT_START_OF_UTTERANCE_TIMEOUT:
                return "EVENT_START_OF_UTTERANCE_TIMEOUT";
            case EVENT_RECOGNITION_TIMEOUT:
                return "EVENT_RECOGNITION_TIMEOUT";
            case EVENT_NEED_MORE_AUDIO:
                return "EVENT_NEED_MORE_AUDIO";
            case EVENT_MAX_SPEECH:
                return "EVENT_MAX_SPEECH";
        }
        return "EVENT_" + event;
    }

    //
    // SR_Recognizer methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.930 -0400", hash_original_method = "BDB8E8D9188F49439CC4CF0C959ADB01", hash_generated_method = "B157E0C8CB8E4EBB8EC206A8BCD5972F")
    
    private static void SR_RecognizerStart(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.937 -0400", hash_original_method = "8C8E2D5458F72653EB7279AF771CC079", hash_generated_method = "7D5A4474C613147E76680AB00F4202DE")
    
    private static void SR_RecognizerStop(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.944 -0400", hash_original_method = "908EE4062C606CA59E5636A5C4B49EA3", hash_generated_method = "64CA11DD5FC91427122762B2EDEB397F")
    
    private static int SR_RecognizerCreate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.952 -0400", hash_original_method = "3961DFFCCC4DFADFA408C58E19C8324B", hash_generated_method = "887953F4DFFA1A2315CEECBD4623B549")
    
    private static void SR_RecognizerDestroy(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.959 -0400", hash_original_method = "6ECB030C5F7896EED2C1EA0C3542E40F", hash_generated_method = "A3B83DD3D2F620599323A2ADB8798D47")
    
    private static void SR_RecognizerSetup(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.965 -0400", hash_original_method = "22B665850E551792C08ECD876CBC7C9F", hash_generated_method = "15A11C094DF1641A2EBCE4E3A76B1149")
    
    private static void SR_RecognizerUnsetup(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.974 -0400", hash_original_method = "E2298B01B197C2DDC609D7C9E731A875", hash_generated_method = "7C4AC6A51E3B2F7DBADF423E52B10C64")
    
    private static boolean SR_RecognizerIsSetup(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.982 -0400", hash_original_method = "EE3D30598F907AF82632A27CD3FA386A", hash_generated_method = "1B6816FE6D8BE3857F208226BB972083")
    
    private static String SR_RecognizerGetParameter(int recognizer, String key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += key.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.990 -0400", hash_original_method = "D97EBBFA8899079CDE0E64E7F70266E7", hash_generated_method = "941AF07CA9669A4FA5EC844C9FDDF903")
    
    private static int SR_RecognizerGetSize_tParameter(int recognizer, String key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += key.getTaintInt();
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.998 -0400", hash_original_method = "18C897378414522512E6B3E233476810", hash_generated_method = "8EBF397A186A8EB2F0F3F4BD7AA78152")
    
    private static boolean SR_RecognizerGetBoolParameter(int recognizer, String key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += key.getTaintInt();
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.008 -0400", hash_original_method = "47E73C37E9F871351FC4AF213D2D9450", hash_generated_method = "28E2B2EDFD9A1B3DA292EE3DEBC49AC5")
    
    private static void SR_RecognizerSetParameter(int recognizer, String key, String value){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.016 -0400", hash_original_method = "59327F6B99C77A5F7E787DC4A30A0A90", hash_generated_method = "1F9A0209B5E210338F995BB2D645061A")
    
    private static void SR_RecognizerSetSize_tParameter(int recognizer,
                String key, int value){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.024 -0400", hash_original_method = "DBA8E92E7E83CCB19691103FE452E747", hash_generated_method = "C6D853EEB60327C64A810191F45B0C96")
    
    private static void SR_RecognizerSetBoolParameter(int recognizer, String key,
                boolean value){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.032 -0400", hash_original_method = "0069D2CEDC7860BA59E32DE02BA443A0", hash_generated_method = "7DBE460A7C044D34379764828B9C7B14")
    
    private static void SR_RecognizerSetupRule(int recognizer, int grammar,
                String ruleName){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.039 -0400", hash_original_method = "EB19E10DA785A68C292216D5A82C476C", hash_generated_method = "444722F9AC1F858EA40C40F5DEFD8CF7")
    
    private static boolean SR_RecognizerHasSetupRules(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.046 -0400", hash_original_method = "537E5446E86719D75C5D95B3959101A3", hash_generated_method = "BC3BFA9317046164BCB44FABDDBA8416")
    
    private static void SR_RecognizerActivateRule(int recognizer, int grammar,
                String ruleName, int weight){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.054 -0400", hash_original_method = "F34526496C52FB0FDB2BA5110D221EE7", hash_generated_method = "24CAB41BB764648D2DB2E98D5CC4BF0C")
    
    private static void SR_RecognizerDeactivateRule(int recognizer, int grammar,
                String ruleName){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.061 -0400", hash_original_method = "B5831795B8C897333A120902D072CE26", hash_generated_method = "02015BCAD35B5C40D3AA6F515E72BB91")
    
    private static void SR_RecognizerDeactivateAllRules(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.070 -0400", hash_original_method = "72A58CB3380837764D497A0EE16A592D", hash_generated_method = "510A3526A5828A5908A5A3919FFC991D")
    
    private static boolean SR_RecognizerIsActiveRule(int recognizer, int grammar,
                String ruleName){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += grammar;
    	taintDouble += ruleName.getTaintInt();
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.079 -0400", hash_original_method = "DC0531E1DC2F95AE8FF1B0E8FDE49D40", hash_generated_method = "ED0F2732C06AC5DD36670063CFB49DD4")
    
    private static boolean SR_RecognizerCheckGrammarConsistency(int recognizer,
                int grammar){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += grammar;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.086 -0400", hash_original_method = "3D6905A3B4A06E25FA07C6234A68E23E", hash_generated_method = "FF2F37645A4BDF68E1198ACFA4AFC6E1")
    
    private static int SR_RecognizerPutAudio(int recognizer, byte[] buffer, int offset,
                int length, boolean isLast){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += buffer[0];
    	taintDouble += offset;
    	taintDouble += length;
    	taintDouble += toTaintInt(isLast);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.095 -0400", hash_original_method = "720BA36FA590AB492684955BA9F6F803", hash_generated_method = "E2733A4307B3F6F99B1A1CB6B15AE668")
    
    private static int SR_RecognizerAdvance(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return (int)taintDouble;
    }

    // private static native void SR_RecognizerLoadUtterance(int recognizer,
    //         const LCHAR* filename);
    // private static native void SR_RecognizerLoadWaveFile(int recognizer,
    //         const LCHAR* filename);
    // private static native void SR_RecognizerSetLockFunction(int recognizer,
    //         SR_RecognizerLockFunction function, void* data);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.101 -0400", hash_original_method = "02CDD8FEA68692DD1D61729103451D83", hash_generated_method = "D4578D5E334DB74F8E9189BB0F310F04")
    
    private static boolean SR_RecognizerIsSignalClipping(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.109 -0400", hash_original_method = "585FFD43DE9EAA93FE7E9CE1D99699C8", hash_generated_method = "8838B6AD7544A14D8774830388362779")
    
    private static boolean SR_RecognizerIsSignalDCOffset(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.116 -0400", hash_original_method = "35CE95561D33754A9785ECBDF23F3983", hash_generated_method = "1A70AB8384907DF11FDF54B88E650EEB")
    
    private static boolean SR_RecognizerIsSignalNoisy(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.123 -0400", hash_original_method = "E3A9C2972834ABBDD94A33DD53E183DA", hash_generated_method = "A5BB242CB53401A4A3571E8FA385FF59")
    
    private static boolean SR_RecognizerIsSignalTooQuiet(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.131 -0400", hash_original_method = "CA3290A7A5FB7731F42F3B3E2E6B1CF3", hash_generated_method = "F543BC9F60F1FFFA921FFE600E993B72")
    
    private static boolean SR_RecognizerIsSignalTooFewSamples(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.142 -0400", hash_original_method = "A583B65DD7C7318216DF3A9B984945F6", hash_generated_method = "7715EAA17CE0074EEC463A53523EE6CB")
    
    private static boolean SR_RecognizerIsSignalTooManySamples(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return toTaintBoolean(taintDouble);
    }

    // private static native void SR_Recognizer_Change_Sample_Rate (size_t new_sample_rate);
    
    //
    // SR_AcousticState native methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.148 -0400", hash_original_method = "E0D86AEB4030B94089BA4B540A804142", hash_generated_method = "830D5F83FB2DAD0A28DCF92EEDF3B89D")
    
    private static void SR_AcousticStateReset(int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.156 -0400", hash_original_method = "5C6A31426CDDED03EF8FAA73ADE30235", hash_generated_method = "A9684A5185FF6884AC738B038BB9F193")
    
    private static void SR_AcousticStateSet(int recognizer, String state){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.164 -0400", hash_original_method = "B54081250B4828F97A9E47B930CCBD22", hash_generated_method = "A8FB5FDC88E288B4113365B9B9BFCC17")
    
    private static String SR_AcousticStateGet(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    //
    // SR_Grammar native methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.171 -0400", hash_original_method = "39803DA6832F6306DE376FB0A24ABA3B", hash_generated_method = "214B8C1E594583510158B52552D455BA")
    
    private static void SR_GrammarCompile(int grammar){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.191 -0400", hash_original_method = "530BC572C2298815371969E30DE323CF", hash_generated_method = "F6F63F1BC2B3D9E4DD412069D72FC4A6")
    
    private static void SR_GrammarAddWordToSlot(int grammar, String slot,
                String word, String pronunciation, int weight, String tag){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.199 -0400", hash_original_method = "9FE2B5DBB697316DA8400F77102C1159", hash_generated_method = "74C27DC3B8AE6D9A3318E1B522B72E0B")
    
    private static void SR_GrammarResetAllSlots(int grammar){
    	//Formerly a native method
    }

    // private static native void SR_GrammarAddNametagToSlot(int grammar, String slot,
    // const struct SR_Nametag_t* nametag, int weight, String tag);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.205 -0400", hash_original_method = "7F0130B827399D0589D3816F987A025F", hash_generated_method = "B8D9DDD02CA135D8339EE6559B041008")
    
    private static void SR_GrammarSetupVocabulary(int grammar, int vocabulary){
    	//Formerly a native method
    }

    // private static native void SR_GrammarSetupModels(int grammar, SR_AcousticModels* models);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.211 -0400", hash_original_method = "C2A3B9EB95A70D698884C680BBBE78D1", hash_generated_method = "490C47D03786DDBCDD2A81F7534CAEF0")
    
    private static void SR_GrammarSetupRecognizer(int grammar, int recognizer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.217 -0400", hash_original_method = "19038B6F01DC9ED2E2ECDC0600E08674", hash_generated_method = "F9F80EFC8D4553A4FA5A8B42FB1C269F")
    
    private static void SR_GrammarUnsetupRecognizer(int grammar){
    	//Formerly a native method
    }

    // private static native void SR_GrammarGetModels(int grammar,SR_AcousticModels** models);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.223 -0400", hash_original_method = "DF05C003E325FBD435583BED48D05C43", hash_generated_method = "CD5F7FFE60EE0E393601D6B3994849E1")
    
    private static int SR_GrammarCreate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.229 -0400", hash_original_method = "97EBA50EA106462BAF759576EF996328", hash_generated_method = "5739157401341389826B33F92A3E5DCC")
    
    private static void SR_GrammarDestroy(int grammar){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.235 -0400", hash_original_method = "39154B50DFEBE5B1ACB7FA3487E5623C", hash_generated_method = "16BC9CADA61CC1EB37346A29E3768178")
    
    private static int SR_GrammarLoad(String filename){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += filename.getTaintInt();
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.241 -0400", hash_original_method = "6E55E9CD6EDDE53E07DF96884ACCD387", hash_generated_method = "52B56A8F2D47FAE5D79E1242FD238398")
    
    private static void SR_GrammarSave(int grammar, String filename){
    	//Formerly a native method
    }

    // private static native void SR_GrammarSetDispatchFunction(int grammar,
    //         const LCHAR* name, void* userData, SR_GrammarDispatchFunction function);
    // private static native void SR_GrammarSetParameter(int grammar, const
    //         LCHAR* key, void* value);
    // private static native void SR_GrammarSetSize_tParameter(int grammar,
    //         const LCHAR* key, size_t value);
    // private static native void SR_GrammarGetParameter(int grammar, const
    //         LCHAR* key, void** value);
    // private static native void SR_GrammarGetSize_tParameter(int grammar,
    //         const LCHAR* key, size_t* value);
    // private static native void SR_GrammarCheckParse(int grammar, const LCHAR*
    //         transcription, SR_SemanticResult** result, size_t* resultCount);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.247 -0400", hash_original_method = "C206E61590B525F76E7BE86CE35CE57B", hash_generated_method = "86EA8109CF80A25F922293A9D2E9F60C")
    
    private static void SR_GrammarAllowOnly(int grammar, String transcription){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.253 -0400", hash_original_method = "A4AB7B3E77B56A18FC9759DE86579823", hash_generated_method = "C015FF5C26056C4518A4E521AB80C9B7")
    
    private static void SR_GrammarAllowAll(int grammar){
    	//Formerly a native method
    }

    //
    // SR_Vocabulary native methods
    //
    // private static native int SR_VocabularyCreate();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.259 -0400", hash_original_method = "4A7B0AA6434C1DBBA730290FBCCB3FB7", hash_generated_method = "B8CFAA21AC7BFB6CD2B0F180D0CE06BB")
    
    private static int SR_VocabularyLoad(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    // private static native void SR_VocabularySave(SR_Vocabulary* self,
    //         const LCHAR* filename);
    // private static native void SR_VocabularyAddWord(SR_Vocabulary* self,
    //         const LCHAR* word);
    // private static native void SR_VocabularyGetLanguage(SR_Vocabulary* self,
    //         ESR_Locale* locale);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.265 -0400", hash_original_method = "8943F3A546791AE02C4CB26A16D03D1A", hash_generated_method = "A03C3B644F01DD1AC24BC0D954F5FA67")
    
    private static void SR_VocabularyDestroy(int vocabulary){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.271 -0400", hash_original_method = "1B04AFB39D080AA7A730806E814F5A4D", hash_generated_method = "00B1C4C5FC4DCF88179BA1A4075CCF43")
    
    private static String SR_VocabularyGetPronunciation(int vocabulary, String word){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += vocabulary;
    	taintDouble += word.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    //
    // SR_RecognizerResult native methods
    //
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.278 -0400", hash_original_method = "9E47BD1D351831D399E33C83944180E6", hash_generated_method = "AA795EDA825EF60B9FF109E2E97F42EE")
    
    private static byte[] SR_RecognizerResultGetWaveform(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.284 -0400", hash_original_method = "131F200944952C99C4B11899ACC84B2A", hash_generated_method = "5EEACEBA509E678A13B341BE21C9A4ED")
    
    private static int SR_RecognizerResultGetSize(int recognizer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.291 -0400", hash_original_method = "DBF49E2591E1DB409211925C2696CBBE", hash_generated_method = "5088D16CD7DDC8B42EAB3DE24894FDB2")
    
    private static int SR_RecognizerResultGetKeyCount(int recognizer, int nbest){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += nbest;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.297 -0400", hash_original_method = "115A350155EAB4338A522A81116A2450", hash_generated_method = "BF7AE84378885EE6172D96B0D15E179E")
    
    private static String[] SR_RecognizerResultGetKeyList(int recognizer, int nbest){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += nbest;
    
    	String[] retObj = new String[1]; 
    	retObj[0] = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:22.304 -0400", hash_original_method = "5CD354A77A5E3E706632A24880A78861", hash_generated_method = "B1CBCDAF99A70B959DA449D5399CFA31")
    
    private static String SR_RecognizerResultGetValue(int recognizer,
                int nbest, String key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += recognizer;
    	taintDouble += nbest;
    	taintDouble += key.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.595 -0400", hash_original_field = "47B49414EC2CF8697BEA79560463204D", hash_generated_field = "8BCFA45B377CEF6CD5BC788A2A233277")

    private int mVocabulary = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.613 -0400", hash_original_field = "C947A795CD946599A1CC519FC6FBE78A", hash_generated_field = "1E8C240554D3782B60A84B8FEF9B1704")

    private int mRecognizer = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.619 -0400", hash_original_field = "40E5DF6CACAF60734E7A4F401EF74416", hash_generated_field = "B3E13B9EA915CCAE6FB1F634C4A81D4B")

    private Grammar mActiveGrammar = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.753 -0400", hash_original_field = "2DBBF9FDEBAF456AD6DA23CEBE913C7F", hash_generated_field = "629B8F1075D8A846E6B68A0B4CB32AA0")

    private byte[] mPutAudioBuffer = null;

    /**
     * Create an instance of a SREC speech recognizer.
     * 
     * @param configFile pathname of the baseline*.par configuration file,
     * which in turn contains references to dictionaries, speech models,
     * and other data needed to configure and operate the recognizer.
     * A separate config file is needed for each audio sample rate.
     * Two files, baseline11k.par and baseline8k.par, which correspond to
     * 11025 and 8000 hz, are present in the directory indicated by
     * {@link #getConfigDir}.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.637 -0400", hash_original_method = "F8A0DDB3115C5147D3DD94FC7549A17E", hash_generated_method = "42B9DFACC4ACC9A5FC37A54BAE9C5364")
    
public Recognizer(String configFile) throws IOException {
        PMemInit();
        SR_SessionCreate(configFile);
        mRecognizer = SR_RecognizerCreate();
        SR_RecognizerSetup(mRecognizer);
        mVocabulary = SR_VocabularyLoad();
    }

    /**
     * Start recognition
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.722 -0400", hash_original_method = "2E413CDCDC92249000630030E3446FB8", hash_generated_method = "411393EBF5782B8B2161A44F61B72E0D")
    
public void start() {
        // TODO: shouldn't be here?
        SR_RecognizerActivateRule(mRecognizer, mActiveGrammar.mGrammar, "trash", 1);
        SR_RecognizerStart(mRecognizer);
    }
    
    /**
     * Process some audio and return the current status.
     * @return recognition event, one of:
     * <ul>
     * <li><code>EVENT_INVALID</code>
     * <li><code>EVENT_NO_MATCH</code>
     * <li><code>EVENT_INCOMPLETE</code>
     * <li><code>EVENT_STARTED</code>
     * <li><code>EVENT_STOPPED</code>
     * <li><code>EVENT_START_OF_VOICING</code>
     * <li><code>EVENT_END_OF_VOICING</code>
     * <li><code>EVENT_SPOKE_TOO_SOON</code>
     * <li><code>EVENT_RECOGNITION_RESULT</code>
     * <li><code>EVENT_START_OF_UTTERANCE_TIMEOUT</code>
     * <li><code>EVENT_RECOGNITION_TIMEOUT</code>
     * <li><code>EVENT_NEED_MORE_AUDIO</code>
     * <li><code>EVENT_MAX_SPEECH</code>
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.728 -0400", hash_original_method = "E7CCB98064AA32ED0B661F6C268E4C15", hash_generated_method = "91245A789931B90D6E40E3826EA79AF4")
    
public int advance() {
        return SR_RecognizerAdvance(mRecognizer);
    }
    
    /**
     * Put audio samples into the <code>Recognizer</code>.
     * @param buf holds the audio samples.
     * @param offset offset of the first sample.
     * @param length number of bytes containing samples.
     * @param isLast indicates no more audio data, normally false.
     * @return number of bytes accepted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.735 -0400", hash_original_method = "25FB9095A58ECF23DA22A6408C7A6931", hash_generated_method = "FAEAED8AB6D7F191F63A387BA265B7D4")
    
public int putAudio(byte[] buf, int offset, int length, boolean isLast) {
        return SR_RecognizerPutAudio(mRecognizer, buf, offset, length, isLast);
    }
    
    /**
     * Read audio samples from an <code>InputStream</code> and put them in the
     * <code>Recognizer</code>.
     * @param audio <code>InputStream</code> containing PCM audio samples.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.745 -0400", hash_original_method = "61A67766390FCF947C6793F74C913E87", hash_generated_method = "063251D2CD803D840AE1E23C5BC70368")
    
public void putAudio(InputStream audio) throws IOException {
        // make sure the audio buffer is allocated
        if (mPutAudioBuffer == null) mPutAudioBuffer = new byte[512];
        // read some data
        int nbytes = audio.read(mPutAudioBuffer);
        // eof, so signal Recognizer
        if (nbytes == -1) {
            SR_RecognizerPutAudio(mRecognizer, mPutAudioBuffer, 0, 0, true);
        }
        // put it into the Recognizer
        else if (nbytes != SR_RecognizerPutAudio(mRecognizer, mPutAudioBuffer, 0, nbytes, false)) {
            throw new IOException("SR_RecognizerPutAudio failed nbytes=" + nbytes);
        }
    }

    /**
     * Get the number of recognition results.  Must be called after
     * <code>EVENT_RECOGNITION_RESULT</code> is returned by
     * <code>advance</code>, but before <code>stop</code>.
     * 
     * @return number of results in nbest list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.758 -0400", hash_original_method = "BF771AF250C4A791E299E0988901CB69", hash_generated_method = "EB1416E724E8BBB04396C28A2EA99CAD")
    
public int getResultCount() {
        return SR_RecognizerResultGetSize(mRecognizer);
    }

    /**
     * Get a set of keys for the result.  Must be called after
     * <code>EVENT_RECOGNITION_RESULT</code> is returned by
     * <code>advance</code>, but before <code>stop</code>.
     * 
     * @param index index of result.
     * @return array of keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.765 -0400", hash_original_method = "48D30F74DF1B738D35E15867FEAF7644", hash_generated_method = "5ED174B852F4BCCBEAE9E2478704ECAF")
    
public String[] getResultKeys(int index) {
        return SR_RecognizerResultGetKeyList(mRecognizer, index);
    }

    /**
     * Get a result value.  Must be called after
     * <code>EVENT_RECOGNITION_RESULT</code> is returned by
     * <code>advance</code>, but before <code>stop</code>.
     * 
     * @param index index of the result.
     * @param key key of the result.  This is typically one of
     * <code>KEY_CONFIDENCE</code>, <code>KEY_LITERAL</code>, or
     * <code>KEY_MEANING</code>, but the user can also define their own keys
     * in a grxml file, or in the <code>tag</code> slot of
     * <code>Grammar.addWordToSlot</code>.
     * @return the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.770 -0400", hash_original_method = "F40EA76C1E44FAE3FD520BA99E63C1E0", hash_generated_method = "D926C79030195906142D892317C2A882")
    
public String getResult(int index, String key) {
        return SR_RecognizerResultGetValue(mRecognizer, index, key);
    }

    /**
     * Stop the <code>Recognizer</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.775 -0400", hash_original_method = "5FCAC44BDC2A7F1CC8FB3837FD1118B9", hash_generated_method = "211D4B144F9A7E0B9FE154FE655316F1")
    
public void stop() {
        SR_RecognizerStop(mRecognizer);
        SR_RecognizerDeactivateRule(mRecognizer, mActiveGrammar.mGrammar, "trash");
    }
    
    /**
     * Reset the acoustic state vectorto it's default value.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.780 -0400", hash_original_method = "D8BB1AB0E92CDF8DD026A00C992F4645", hash_generated_method = "C913745F5E264D78361CBE26507A8D30")
    
public void resetAcousticState() {
        SR_AcousticStateReset(mRecognizer);
    }
    
    /**
     * Set the acoustic state vector.
     * @param state String containing the acoustic state vector.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.784 -0400", hash_original_method = "95D0FD0615DB4F66A56BE33A0783144A", hash_generated_method = "896F96D95C9268EE9F70C3B34C667377")
    
public void setAcousticState(String state) {
        SR_AcousticStateSet(mRecognizer, state);
    }
    
    /**
     * Get the acoustic state vector.
     * @return String containing the acoustic state vector.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.789 -0400", hash_original_method = "7A1CD0BE952AA33CA5BC0235F6F13A5B", hash_generated_method = "DC1E9072FBA89A1E49751D060FDB0DCE")
    
public String getAcousticState() {
        return SR_AcousticStateGet(mRecognizer);
    }

    /**
     * Clean up resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.796 -0400", hash_original_method = "2E8D93AE88211F36AAD6D20A55107D4A", hash_generated_method = "975822625C32FDCFC35DD05272224E5E")
    
public void destroy() {
        try {
            if (mVocabulary != 0) SR_VocabularyDestroy(mVocabulary);
        } finally {
            mVocabulary = 0;
            try {
                if (mRecognizer != 0) SR_RecognizerUnsetup(mRecognizer);
            } finally {
                try {
                    if (mRecognizer != 0) SR_RecognizerDestroy(mRecognizer);
                } finally {
                    mRecognizer = 0;
                    try {
                        SR_SessionDestroy();
                    } finally {
                        PMemShutdown();
                    }
                }
            }
        }
    }

    /**
     * Clean up resources.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:21.802 -0400", hash_original_method = "AAC17ED6F21DB1AA39943BA358CCD6BE", hash_generated_method = "873117076B828C3677075711DA431F87")
    
protected void finalize() throws Throwable {
        if (mVocabulary != 0 || mRecognizer != 0) {
            destroy();
            throw new IllegalStateException("someone forgot to destroy Recognizer");
        }
    }
    // private static native void SR_RecognizerResultGetLocale(int recognizer, ESR_Locale* locale);
}
