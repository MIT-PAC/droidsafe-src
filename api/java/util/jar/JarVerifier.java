package java.util.jar;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class JarVerifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "36C03847AF0883885A22C7148FF9D945", hash_generated_field = "9E85BB611D3EE89CADB45020535E6B11")

    private String jarName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "39C63DDB96A31B9610CD976B896AD4F0", hash_generated_field = "1E6BF158A9ED964E950A909DB5592C82")

    private Manifest man;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "7F95040407D1DE1DD06100938FB014B8", hash_generated_field = "7597311A3575323E247960656BDFED83")

    private HashMap<String, byte[]> metaEntries = new HashMap<String, byte[]>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "EA27612449888A6254ED42A8C6C42B91", hash_generated_field = "EBE3D14483DFDBD581E4922AC5C6EF8C")

    private final Hashtable<String, HashMap<String, Attributes>> signatures = new Hashtable<String, HashMap<String, Attributes>>(
            5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "B44FC64946B64487171B584AE29B105E", hash_generated_field = "F2823AD67EF4110598FC3B6AEAEBB2CE")

    private final Hashtable<String, Certificate[]> certificates = new Hashtable<String, Certificate[]>(
            5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "D94070297E6AC792A9C25E0BCEB74EAB", hash_generated_field = "60F30BC5BC981A97975947915771AEC9")

    private final Hashtable<String, Certificate[]> verifiedEntries = new Hashtable<String, Certificate[]>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.955 -0400", hash_original_field = "C0B00F03876D83321535EB4B46A79FCE", hash_generated_field = "6B8C7E29F08A08768A13067ED2CA8C6A")

    int mainAttributesEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.956 -0400", hash_original_method = "4436059C4E8276439A6065FE93A5DE5F", hash_generated_method = "0A8DC9E44BE88658AD08D7EFC25F2EE1")
      JarVerifier(String name) {
        jarName = name;
        // ---------- Original Method ----------
        //jarName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.956 -0400", hash_original_method = "A00C668D834700B7DBCD83DF376B2F68", hash_generated_method = "93BFD21D7924EA8FE59FB04CA20FCFCB")
    private SecurityException invalidDigest(String signatureFile, String name, String jarName) {
        addTaint(jarName.getTaint());
        addTaint(name.getTaint());
        addTaint(signatureFile.getTaint());
        SecurityException var074A5CA52DC88256F635FF6342A6CFE2_541355204 = new SecurityException(signatureFile + " has invalid digest for " + name +
                " in " + jarName);
        var074A5CA52DC88256F635FF6342A6CFE2_541355204.addTaint(taint);
        throw var074A5CA52DC88256F635FF6342A6CFE2_541355204;
        // ---------- Original Method ----------
        //throw new SecurityException(signatureFile + " has invalid digest for " + name +
                //" in " + jarName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.956 -0400", hash_original_method = "6DF68FF1B39EE346E0EC276311EA5830", hash_generated_method = "E9909EEE094ED6D89F21516608369B7F")
    private SecurityException failedVerification(String jarName, String signatureFile) {
        addTaint(signatureFile.getTaint());
        addTaint(jarName.getTaint());
        SecurityException varB468A6384A0E268EB77C0514F32BE836_328428930 = new SecurityException(jarName + " failed verification of " + signatureFile);
        varB468A6384A0E268EB77C0514F32BE836_328428930.addTaint(taint);
        throw varB468A6384A0E268EB77C0514F32BE836_328428930;
        // ---------- Original Method ----------
        //throw new SecurityException(jarName + " failed verification of " + signatureFile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.957 -0400", hash_original_method = "6A6033A1386EA2314D4EF0CB331B3F5C", hash_generated_method = "A6D6AEA4E1119AA8191C8C723EACAA82")
     VerifierEntry initEntry(String name) {
        addTaint(name.getTaint());
        if(man == null || signatures.size() == 0)        
        {
VerifierEntry var540C13E9E156B687226421B24F2DF178_2020793903 =             null;
            var540C13E9E156B687226421B24F2DF178_2020793903.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2020793903;
        } //End block
        Attributes attributes = man.getAttributes(name);
        if(attributes == null)        
        {
VerifierEntry var540C13E9E156B687226421B24F2DF178_1873107919 =             null;
            var540C13E9E156B687226421B24F2DF178_1873107919.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1873107919;
        } //End block
        ArrayList<Certificate> certs = new ArrayList<Certificate>();
        Iterator<Map.Entry<String, HashMap<String, Attributes>>> it = signatures.entrySet().iterator();
        while
(it.hasNext())        
        {
            Map.Entry<String, HashMap<String, Attributes>> entry = it.next();
            HashMap<String, Attributes> hm = entry.getValue();
            if(hm.get(name) != null)            
            {
                String signatureFile = entry.getKey();
                certs.addAll(getSignerCertificates(signatureFile, certificates));
            } //End block
        } //End block
        if(certs.isEmpty())        
        {
VerifierEntry var540C13E9E156B687226421B24F2DF178_1348061010 =             null;
            var540C13E9E156B687226421B24F2DF178_1348061010.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1348061010;
        } //End block
        Certificate[] certificatesArray = certs.toArray(new Certificate[certs.size()]);
        String algorithms = attributes.getValue("Digest-Algorithms");
        if(algorithms == null)        
        {
            algorithms = "SHA SHA1";
        } //End block
        StringTokenizer tokens = new StringTokenizer(algorithms);
        while
(tokens.hasMoreTokens())        
        {
            String algorithm = tokens.nextToken();
            String hash = attributes.getValue(algorithm + "-Digest");
            if(hash == null)            
            {
                continue;
            } //End block
            byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);
            try 
            {
VerifierEntry var18BE1F5426B3001F1D977CE0544C7884_2081651157 =                 new VerifierEntry(name, MessageDigest
                        .getInstance(algorithm), hashBytes, certificatesArray);
                var18BE1F5426B3001F1D977CE0544C7884_2081651157.addTaint(taint);
                return var18BE1F5426B3001F1D977CE0544C7884_2081651157;
            } //End block
            catch (NoSuchAlgorithmException e)
            {
            } //End block
        } //End block
VerifierEntry var540C13E9E156B687226421B24F2DF178_498051392 =         null;
        var540C13E9E156B687226421B24F2DF178_498051392.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_498051392;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.959 -0400", hash_original_method = "B24E46A89F6B78A5F74DC1F8899F1D36", hash_generated_method = "33CAFEEEB0CFA2B159626EC9CC8BE3A5")
     void addMetaEntry(String name, byte[] buf) {
        addTaint(buf[0]);
        addTaint(name.getTaint());
        metaEntries.put(name.toUpperCase(Locale.US), buf);
        // ---------- Original Method ----------
        //metaEntries.put(name.toUpperCase(Locale.US), buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.959 -0400", hash_original_method = "8A8EDD1088AB3F7694E04A76DE584752", hash_generated_method = "5CB46C76A6D34058B6E97F0B50FFD4DF")
    synchronized boolean readCertificates() {
        if(metaEntries == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1887488291 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841031360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841031360;
        } //End block
        Iterator<String> it = metaEntries.keySet().iterator();
        while
(it.hasNext())        
        {
            String key = it.next();
            if(key.endsWith(".DSA") || key.endsWith(".RSA"))            
            {
                verifyCertificate(key);
                if(metaEntries == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1090568642 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564234770 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564234770;
                } //End block
                it.remove();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1863290540 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804009617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_804009617;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.980 -0400", hash_original_method = "E0F968F23AF085C0376D04DBFBF51D30", hash_generated_method = "FC84297C5D9DEF715DDA943B6B2FFCD4")
    private void verifyCertificate(String certFile) {
        addTaint(certFile.getTaint());
        String signatureFile = certFile.substring(0, certFile.lastIndexOf('.'))
                + ".SF";
        byte[] sfBytes = metaEntries.get(signatureFile);
        if(sfBytes == null)        
        {
            return;
        } //End block
        byte[] manifest = metaEntries.get(JarFile.MANIFEST_NAME);
        if(manifest == null)        
        {
            return;
        } //End block
        byte[] sBlockBytes = metaEntries.get(certFile);
        try 
        {
            Certificate[] signerCertChain = JarUtils.verifySignature(
                    new ByteArrayInputStream(sfBytes),
                    new ByteArrayInputStream(sBlockBytes));
            if(metaEntries == null)            
            {
                return;
            } //End block
            if(signerCertChain != null)            
            {
                certificates.put(signatureFile, signerCertChain);
            } //End block
        } //End block
        catch (IOException e)
        {
            return;
        } //End block
        catch (GeneralSecurityException e)
        {
            java.lang.SecurityException var9F75C122D2300A75696115F728064C23_583712666 = failedVerification(jarName, signatureFile);
            var9F75C122D2300A75696115F728064C23_583712666.addTaint(taint);
            throw var9F75C122D2300A75696115F728064C23_583712666;
        } //End block
        Attributes attributes = new Attributes();
        HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
        try 
        {
            InitManifest im = new InitManifest(sfBytes, attributes, Attributes.Name.SIGNATURE_VERSION);
            im.initEntries(entries, null);
        } //End block
        catch (IOException e)
        {
            return;
        } //End block
        boolean createdBySigntool = false;
        String createdBy = attributes.getValue("Created-By");
        if(createdBy != null)        
        {
            createdBySigntool = createdBy.indexOf("signtool") != -1;
        } //End block
        if(mainAttributesEnd > 0 && !createdBySigntool)        
        {
            String digestAttribute = "-Digest-Manifest-Main-Attributes";
            if(!verify(attributes, digestAttribute, manifest, 0, mainAttributesEnd, false, true))            
            {
                java.lang.SecurityException var9F75C122D2300A75696115F728064C23_1007195514 = failedVerification(jarName, signatureFile);
                var9F75C122D2300A75696115F728064C23_1007195514.addTaint(taint);
                throw var9F75C122D2300A75696115F728064C23_1007195514;
            } //End block
        } //End block
        String digestAttribute = createdBySigntool ? "-Digest"
                : "-Digest-Manifest";
        if(!verify(attributes, digestAttribute, manifest, 0, manifest.length,
                false, false))        
        {
            Iterator<Map.Entry<String, Attributes>> it = entries.entrySet()
                    .iterator();
            while
(it.hasNext())            
            {
                Map.Entry<String, Attributes> entry = it.next();
                Manifest.Chunk chunk = man.getChunk(entry.getKey());
                if(chunk == null)                
                {
                    return;
                } //End block
                if(!verify(entry.getValue(), "-Digest", manifest,
                        chunk.start, chunk.end, createdBySigntool, false))                
                {
                    java.lang.SecurityException var67613D444084A15067150FCA554C8CE7_709262172 = invalidDigest(signatureFile, entry.getKey(), jarName);
                    var67613D444084A15067150FCA554C8CE7_709262172.addTaint(taint);
                    throw var67613D444084A15067150FCA554C8CE7_709262172;
                } //End block
            } //End block
        } //End block
        metaEntries.put(signatureFile, null);
        signatures.put(signatureFile, entries);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.981 -0400", hash_original_method = "5E96175D15755C77B9F4C5D6341FECA1", hash_generated_method = "27CCBD8B39BAC0602317753C0A8767E5")
     void setManifest(Manifest mf) {
        man = mf;
        // ---------- Original Method ----------
        //man = mf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.981 -0400", hash_original_method = "61D9EDAFD8C0E1537C8EF2C7E942A904", hash_generated_method = "1D386BF2D9B4E3A96554DB5D0120F5DD")
     boolean isSignedJar() {
        boolean varAAB13CD57140FC9C26289A146A937C91_591242426 = (certificates.size() > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518426701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518426701;
        // ---------- Original Method ----------
        //return certificates.size() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.983 -0400", hash_original_method = "C1D665F8901BA184CF5172955B73AB34", hash_generated_method = "B28343B8C08B32EFE1B70558CF0E5DC6")
    private boolean verify(Attributes attributes, String entry, byte[] data,
            int start, int end, boolean ignoreSecondEndline, boolean ignorable) {
        addTaint(ignorable);
        addTaint(ignoreSecondEndline);
        addTaint(end);
        addTaint(start);
        addTaint(data[0]);
        addTaint(entry.getTaint());
        addTaint(attributes.getTaint());
        String algorithms = attributes.getValue("Digest-Algorithms");
        if(algorithms == null)        
        {
            algorithms = "SHA SHA1";
        } //End block
        StringTokenizer tokens = new StringTokenizer(algorithms);
        while
(tokens.hasMoreTokens())        
        {
            String algorithm = tokens.nextToken();
            String hash = attributes.getValue(algorithm + entry);
            if(hash == null)            
            {
                continue;
            } //End block
            MessageDigest md;
            try 
            {
                md = MessageDigest.getInstance(algorithm);
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                continue;
            } //End block
            if(ignoreSecondEndline && data[end - 1] == '\n'
                    && data[end - 2] == '\n')            
            {
                md.update(data, start, end - 1 - start);
            } //End block
            else
            {
                md.update(data, start, end - start);
            } //End block
            byte[] b = md.digest();
            byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);
            boolean var682244A446E71B106B75EA193A59EB60_2107503698 = (MessageDigest.isEqual(b, Base64.decode(hashBytes)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183928452 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_183928452;
        } //End block
        boolean var945E3CDAF82CC9611962E167614498BC_735044747 = (ignorable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651677871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651677871;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.984 -0400", hash_original_method = "4AB9D8996D4C7F856FC4CD4DD096303E", hash_generated_method = "65BFC23C799E50B8137021F6D5C37C07")
     Certificate[] getCertificates(String name) {
        addTaint(name.getTaint());
        Certificate[] verifiedCerts = verifiedEntries.get(name);
        if(verifiedCerts == null)        
        {
Certificate[] var540C13E9E156B687226421B24F2DF178_303711449 =             null;
            var540C13E9E156B687226421B24F2DF178_303711449.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_303711449;
        } //End block
Certificate[] var32B73750590266689C19084802167374_729626774 =         verifiedCerts.clone();
        var32B73750590266689C19084802167374_729626774.addTaint(taint);
        return var32B73750590266689C19084802167374_729626774;
        // ---------- Original Method ----------
        //Certificate[] verifiedCerts = verifiedEntries.get(name);
        //if (verifiedCerts == null) {
            //return null;
        //}
        //return verifiedCerts.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.985 -0400", hash_original_method = "98B5FDE1FF609AB4DAC6F710E4FAE37E", hash_generated_method = "B134C21CF39C711019A6E185A2A3E9BB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.985 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.985 -0400", hash_original_field = "C10F77963A2B21079156A0E5C5A4BB3C", hash_generated_field = "145A8FD0EC1911E7DDCA25F923899831")

        private MessageDigest digest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.985 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "670F24B05EDED2247F0B4CD66AB4EE15")

        private byte[] hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.986 -0400", hash_original_field = "3CC41D0F46073BA8D93EA9DB2412437F", hash_generated_field = "6029E7C21A5106D4483252478B646415")

        private Certificate[] certificates;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.987 -0400", hash_original_method = "519B899FEA5DD6CF74252B8A7E9BDF9B", hash_generated_method = "392088D1361F148BA7EABBED99C5FDBB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.987 -0400", hash_original_method = "977E904E5666EA1924971461B3999364", hash_generated_method = "50C4B56121CA2DEEF9871162D7716E97")
        @Override
        public void write(int value) {
            addTaint(value);
            digest.update((byte) value);
            // ---------- Original Method ----------
            //digest.update((byte) value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.987 -0400", hash_original_method = "8BB7D0A84FCC70584CF33970C6F95BDA", hash_generated_method = "60A10365C6398DC0656D7CD3D257F7AD")
        @Override
        public void write(byte[] buf, int off, int nbytes) {
            addTaint(nbytes);
            addTaint(off);
            addTaint(buf[0]);
            digest.update(buf, off, nbytes);
            // ---------- Original Method ----------
            //digest.update(buf, off, nbytes);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.210 -0400", hash_original_method = "E514DAB8C6AF0A1EE37FB72F5B8B9108", hash_generated_method = "5C4BD9472CDE665A3B734979B8A321D7")
         void verify() {
            byte[] d = digest.digest();
    if(!MessageDigest.isEqual(d, Base64.decode(hash)))            
            {
                SecurityException var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624 = invalidDigest(JarFile.MANIFEST_NAME, name, jarName);
                var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624.addTaint(taint);
                throw var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624;
            } //End block
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

