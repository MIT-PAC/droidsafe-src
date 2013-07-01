package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import libcore.io.Base64;
import org.apache.harmony.security.utils.JarUtils;

class JarVerifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "36C03847AF0883885A22C7148FF9D945", hash_generated_field = "9E85BB611D3EE89CADB45020535E6B11")

    private String jarName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "39C63DDB96A31B9610CD976B896AD4F0", hash_generated_field = "1E6BF158A9ED964E950A909DB5592C82")

    private Manifest man;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "7F95040407D1DE1DD06100938FB014B8", hash_generated_field = "7597311A3575323E247960656BDFED83")

    private HashMap<String, byte[]> metaEntries = new HashMap<String, byte[]>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "EA27612449888A6254ED42A8C6C42B91", hash_generated_field = "EBE3D14483DFDBD581E4922AC5C6EF8C")

    private final Hashtable<String, HashMap<String, Attributes>> signatures = new Hashtable<String, HashMap<String, Attributes>>(
            5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "B44FC64946B64487171B584AE29B105E", hash_generated_field = "F2823AD67EF4110598FC3B6AEAEBB2CE")

    private final Hashtable<String, Certificate[]> certificates = new Hashtable<String, Certificate[]>(
            5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "D94070297E6AC792A9C25E0BCEB74EAB", hash_generated_field = "60F30BC5BC981A97975947915771AEC9")

    private final Hashtable<String, Certificate[]> verifiedEntries = new Hashtable<String, Certificate[]>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.164 -0400", hash_original_field = "C0B00F03876D83321535EB4B46A79FCE", hash_generated_field = "6B8C7E29F08A08768A13067ED2CA8C6A")

    int mainAttributesEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.165 -0400", hash_original_method = "4436059C4E8276439A6065FE93A5DE5F", hash_generated_method = "0A8DC9E44BE88658AD08D7EFC25F2EE1")
      JarVerifier(String name) {
        jarName = name;
        // ---------- Original Method ----------
        //jarName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.165 -0400", hash_original_method = "A00C668D834700B7DBCD83DF376B2F68", hash_generated_method = "0AE4DE462D27C99BF7511E5F32568FA9")
    private SecurityException invalidDigest(String signatureFile, String name, String jarName) {throw new SecurityException(signatureFile + " has invalid digest for " + name +
                " in " + jarName);
        // ---------- Original Method ----------
        //throw new SecurityException(signatureFile + " has invalid digest for " + name +
                //" in " + jarName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.166 -0400", hash_original_method = "6DF68FF1B39EE346E0EC276311EA5830", hash_generated_method = "AAA875AEE235418D0232F225DF87CC81")
    private SecurityException failedVerification(String jarName, String signatureFile) {
    	throw new SecurityException(jarName + " failed verification of " + signatureFile);
        // ---------- Original Method ----------
        //throw new SecurityException(jarName + " failed verification of " + signatureFile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.167 -0400", hash_original_method = "6A6033A1386EA2314D4EF0CB331B3F5C", hash_generated_method = "36DE4DF93177EA1C79EFE1DC4465DB6C")
     VerifierEntry initEntry(String name) {
        VerifierEntry varB4EAC82CA7396A68D541C85D26508E83_2009555559 = null; //Variable for return #1
        VerifierEntry varB4EAC82CA7396A68D541C85D26508E83_1513237032 = null; //Variable for return #2
        VerifierEntry varB4EAC82CA7396A68D541C85D26508E83_2142503619 = null; //Variable for return #3
        VerifierEntry varB4EAC82CA7396A68D541C85D26508E83_445668025 = null; //Variable for return #4
        VerifierEntry varB4EAC82CA7396A68D541C85D26508E83_990773497 = null; //Variable for return #5
        {
            boolean var1739105B34C5F197F51A0EEC2FCE22C4_1175864499 = (man == null || signatures.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2009555559 = null;
            } //End block
        } //End collapsed parenthetic
        Attributes attributes = man.getAttributes(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1513237032 = null;
        } //End block
        ArrayList<Certificate> certs = new ArrayList<Certificate>();
        Iterator<Map.Entry<String, HashMap<String, Attributes>>> it = signatures.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_193350089 = (it.hasNext());
            {
                Map.Entry<String, HashMap<String, Attributes>> entry = it.next();
                HashMap<String, Attributes> hm = entry.getValue();
                {
                    boolean varA11FBA9D7341E0328282C6ADC9E3B007_1437556007 = (hm.get(name) != null);
                    {
                        String signatureFile = entry.getKey();
                        certs.addAll(getSignerCertificates(signatureFile, certificates));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD07177C898FD12D837B9D5964F0C24CD_1307279813 = (certs.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2142503619 = null;
            } //End block
        } //End collapsed parenthetic
        Certificate[] certificatesArray = certs.toArray(new Certificate[certs.size()]);
        String algorithms = attributes.getValue("Digest-Algorithms");
        {
            algorithms = "SHA SHA1";
        } //End block
        StringTokenizer tokens = new StringTokenizer(algorithms);
        {
            boolean var4A8B7054AF091A6B38EB732ACFC1CEDB_943921526 = (tokens.hasMoreTokens());
            {
                String algorithm = tokens.nextToken();
                String hash = attributes.getValue(algorithm + "-Digest");
                byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_445668025 = new VerifierEntry(name, MessageDigest
                        .getInstance(algorithm), hashBytes, certificatesArray);
                } //End block
                catch (NoSuchAlgorithmException e)
                { }
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_990773497 = null;
        addTaint(name.getTaint());
        VerifierEntry varA7E53CE21691AB073D9660D615818899_872336549; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_872336549 = varB4EAC82CA7396A68D541C85D26508E83_2009555559;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_872336549 = varB4EAC82CA7396A68D541C85D26508E83_1513237032;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_872336549 = varB4EAC82CA7396A68D541C85D26508E83_2142503619;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_872336549 = varB4EAC82CA7396A68D541C85D26508E83_445668025;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_872336549 = varB4EAC82CA7396A68D541C85D26508E83_990773497;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_872336549.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_872336549;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.168 -0400", hash_original_method = "B24E46A89F6B78A5F74DC1F8899F1D36", hash_generated_method = "ED12B2ED3232D85AB068B860172E6DC0")
     void addMetaEntry(String name, byte[] buf) {
        metaEntries.put(name.toUpperCase(Locale.US), buf);
        addTaint(name.getTaint());
        addTaint(buf[0]);
        // ---------- Original Method ----------
        //metaEntries.put(name.toUpperCase(Locale.US), buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.169 -0400", hash_original_method = "8A8EDD1088AB3F7694E04A76DE584752", hash_generated_method = "6EEE1266FEFA5F996E702616D944654F")
    synchronized boolean readCertificates() {
        Iterator<String> it = metaEntries.keySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_283888451 = (it.hasNext());
            {
                String key = it.next();
                {
                    boolean var4681B3668908FCE90CF6A905CFCA3F33_682663019 = (key.endsWith(".DSA") || key.endsWith(".RSA"));
                    {
                        verifyCertificate(key);
                        it.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358038154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358038154;
        // ---------- Original Method ----------
        //if (metaEntries == null) {
            //return false;
        //}
        //Iterator<String> it = metaEntries.keySet().iterator();
        //while (it.hasNext()) {
            //String key = it.next();
            //if (key.endsWith(".DSA") || key.endsWith(".RSA")) {
                //verifyCertificate(key);
                //if (metaEntries == null) {
                    //return false;
                //}
                //it.remove();
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.170 -0400", hash_original_method = "E0F968F23AF085C0376D04DBFBF51D30", hash_generated_method = "B1D3F5BB33870A06DA7679E1E6C4DB26")
    private void verifyCertificate(String certFile) {
        String signatureFile = certFile.substring(0, certFile.lastIndexOf('.'))
                + ".SF";
        byte[] sfBytes = metaEntries.get(signatureFile);
        byte[] manifest = metaEntries.get(JarFile.MANIFEST_NAME);
        byte[] sBlockBytes = metaEntries.get(certFile);
        try 
        {
            Certificate[] signerCertChain = JarUtils.verifySignature(
                    new ByteArrayInputStream(sfBytes),
                    new ByteArrayInputStream(sBlockBytes));
            {
                certificates.put(signatureFile, signerCertChain);
            } //End block
        } //End block
        catch (IOException e)
        { }
        catch (GeneralSecurityException e)
        {
            if (DroidSafeAndroidRuntime.control) throw failedVerification(jarName, signatureFile);
        } //End block
        Attributes attributes = new Attributes();
        HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
        try 
        {
            InitManifest im = new InitManifest(sfBytes, attributes, Attributes.Name.SIGNATURE_VERSION);
            im.initEntries(entries, null);
        } //End block
        catch (IOException e)
        { }
        boolean createdBySigntool = false;
        String createdBy = attributes.getValue("Created-By");
        {
            createdBySigntool = createdBy.indexOf("signtool") != -1;
        } //End block
        {
            String digestAttribute = "-Digest-Manifest-Main-Attributes";
            {
                boolean var9660D2ABC682B0CBB44B33389EFC28FB_355256716 = (!verify(attributes, digestAttribute, manifest, 0, mainAttributesEnd, false, true));
                {
                    if (DroidSafeAndroidRuntime.control) throw failedVerification(jarName, signatureFile);
                } //End block
            } //End collapsed parenthetic
        } //End block
        String digestAttribute;
        digestAttribute = "-Digest";
        digestAttribute = "-Digest-Manifest";
        {
            boolean varBF55E30490CA8C888FC67F88CD7AD658_991264678 = (!verify(attributes, digestAttribute, manifest, 0, manifest.length,
                false, false));
            {
                Iterator<Map.Entry<String, Attributes>> it = entries.entrySet()
                    .iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_64684306 = (it.hasNext());
                    {
                        Map.Entry<String, Attributes> entry = it.next();
                        Manifest.Chunk chunk = man.getChunk(entry.getKey());
                        {
                            boolean varAC1C8F34BDBC7D9F713C0353FA7B6FAF_2145213274 = (!verify(entry.getValue(), "-Digest", manifest,
                        chunk.start, chunk.end, createdBySigntool, false));
                            {
                                if (DroidSafeAndroidRuntime.control) throw invalidDigest(signatureFile, entry.getKey(), jarName);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        metaEntries.put(signatureFile, null);
        signatures.put(signatureFile, entries);
        addTaint(certFile.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.171 -0400", hash_original_method = "5E96175D15755C77B9F4C5D6341FECA1", hash_generated_method = "27CCBD8B39BAC0602317753C0A8767E5")
     void setManifest(Manifest mf) {
        man = mf;
        // ---------- Original Method ----------
        //man = mf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.171 -0400", hash_original_method = "61D9EDAFD8C0E1537C8EF2C7E942A904", hash_generated_method = "98A4FB0641DAFFDF8403F108EBAA2BBA")
     boolean isSignedJar() {
        boolean var7CAE1A061A4DC00175B4D2E783D22316_214087782 = (certificates.size() > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321411457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321411457;
        // ---------- Original Method ----------
        //return certificates.size() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.173 -0400", hash_original_method = "C1D665F8901BA184CF5172955B73AB34", hash_generated_method = "DFD5E017C55FABA71FE4043016A21B81")
    private boolean verify(Attributes attributes, String entry, byte[] data,
            int start, int end, boolean ignoreSecondEndline, boolean ignorable) {
        String algorithms = attributes.getValue("Digest-Algorithms");
        {
            algorithms = "SHA SHA1";
        } //End block
        StringTokenizer tokens = new StringTokenizer(algorithms);
        {
            boolean var4A8B7054AF091A6B38EB732ACFC1CEDB_1359234788 = (tokens.hasMoreTokens());
            {
                String algorithm = tokens.nextToken();
                String hash = attributes.getValue(algorithm + entry);
                MessageDigest md;
                try 
                {
                    md = MessageDigest.getInstance(algorithm);
                } //End block
                catch (NoSuchAlgorithmException e)
                { return false; }
                {
                    md.update(data, start, end - 1 - start);
                } //End block
                {
                    md.update(data, start, end - start);
                } //End block
                byte[] b = md.digest();
                byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);
                boolean varF4F3230BCA44283481584F405E42E5C9_759340487 = (MessageDigest.isEqual(b, Base64.decode(hashBytes)));
            } //End block
        } //End collapsed parenthetic
        addTaint(attributes.getTaint());
        addTaint(entry.getTaint());
        addTaint(data[0]);
        addTaint(start);
        addTaint(end);
        addTaint(ignoreSecondEndline);
        addTaint(ignorable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354020947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354020947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.174 -0400", hash_original_method = "4AB9D8996D4C7F856FC4CD4DD096303E", hash_generated_method = "E24BA93F7F8858E60AFEB131AFEC0A2E")
     Certificate[] getCertificates(String name) {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_418306706 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1856893491 = null; //Variable for return #2
        Certificate[] verifiedCerts = verifiedEntries.get(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_418306706 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1856893491 = verifiedCerts.clone();
        addTaint(name.getTaint());
        Certificate[] varA7E53CE21691AB073D9660D615818899_80022366; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_80022366 = varB4EAC82CA7396A68D541C85D26508E83_418306706;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_80022366 = varB4EAC82CA7396A68D541C85D26508E83_1856893491;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_80022366.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_80022366;
        // ---------- Original Method ----------
        //Certificate[] verifiedCerts = verifiedEntries.get(name);
        //if (verifiedCerts == null) {
            //return null;
        //}
        //return verifiedCerts.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.174 -0400", hash_original_method = "98B5FDE1FF609AB4DAC6F710E4FAE37E", hash_generated_method = "B134C21CF39C711019A6E185A2A3E9BB")
     void removeMetaEntries() {
        metaEntries = null;
        // ---------- Original Method ----------
        //metaEntries = null;
    }

    
    public static Vector<Certificate> getSignerCertificates(
            String signatureFileName, Map<String, Certificate[]> certificates) {
        Vector<Certificate> result = new Vector<Certificate>();
        Certificate[] certChain = certificates.get(signatureFileName);
        if (certChain != null) {
            for (Certificate element : certChain) {
                result.add(element);
            }
        }
        return result;
    }

    
    class VerifierEntry extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.175 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.175 -0400", hash_original_field = "C10F77963A2B21079156A0E5C5A4BB3C", hash_generated_field = "145A8FD0EC1911E7DDCA25F923899831")

        private MessageDigest digest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.175 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "670F24B05EDED2247F0B4CD66AB4EE15")

        private byte[] hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.175 -0400", hash_original_field = "3CC41D0F46073BA8D93EA9DB2412437F", hash_generated_field = "6029E7C21A5106D4483252478B646415")

        private Certificate[] certificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.175 -0400", hash_original_method = "519B899FEA5DD6CF74252B8A7E9BDF9B", hash_generated_method = "392088D1361F148BA7EABBED99C5FDBB")
          VerifierEntry(String name, MessageDigest digest, byte[] hash,
                Certificate[] certificates) {
            this.name = name;
            this.digest = digest;
            this.hash = hash;
            this.certificates = certificates;
            // ---------- Original Method ----------
            //this.name = name;
            //this.digest = digest;
            //this.hash = hash;
            //this.certificates = certificates;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.176 -0400", hash_original_method = "977E904E5666EA1924971461B3999364", hash_generated_method = "851854E1A229E9345EDE284398C8B3C4")
        @Override
        public void write(int value) {
            digest.update((byte) value);
            addTaint(value);
            // ---------- Original Method ----------
            //digest.update((byte) value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.177 -0400", hash_original_method = "8BB7D0A84FCC70584CF33970C6F95BDA", hash_generated_method = "2F17822BA892ADFF099CD9A221F557B2")
        @Override
        public void write(byte[] buf, int off, int nbytes) {
            digest.update(buf, off, nbytes);
            addTaint(buf[0]);
            addTaint(off);
            addTaint(nbytes);
            // ---------- Original Method ----------
            //digest.update(buf, off, nbytes);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.178 -0400", hash_original_method = "E514DAB8C6AF0A1EE37FB72F5B8B9108", hash_generated_method = "8ED832EFEF49AABDEBB416EBB1DA3862")
         void verify() {
            byte[] d = digest.digest();
            {
                boolean varF713951728C54611E5DA59160EF2FDFA_793011099 = (!MessageDigest.isEqual(d, Base64.decode(hash)));
                {
                    if (DroidSafeAndroidRuntime.control) throw invalidDigest(JarFile.MANIFEST_NAME, name, jarName);
                } //End block
            } //End collapsed parenthetic
            verifiedEntries.put(name, certificates);
            // ---------- Original Method ----------
            //byte[] d = digest.digest();
            //if (!MessageDigest.isEqual(d, Base64.decode(hash))) {
                //throw invalidDigest(JarFile.MANIFEST_NAME, name, jarName);
            //}
            //verifiedEntries.put(name, certificates);
        }

        
    }


    
}

