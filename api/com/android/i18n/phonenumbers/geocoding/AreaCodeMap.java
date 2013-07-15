package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.logging.Logger;

public class AreaCodeMap implements Externalizable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.300 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.300 -0400", hash_original_field = "655DFB6430742116AC3F2CDECF0CB692", hash_generated_field = "ED1850D47B6862466E3813601569EB4C")

    private AreaCodeMapStorageStrategy areaCodeMapStorage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.300 -0400", hash_original_method = "F2335FCA92B9F7475991523B74CDEDE4", hash_generated_method = "5AADB622CA81A6BC4039E9CFB4220F69")
    public  AreaCodeMap() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.300 -0400", hash_original_method = "2F443A9F7F25B3F1F0013A418F926218", hash_generated_method = "67CF871815EF3E47FD72386505496553")
     AreaCodeMapStorageStrategy getAreaCodeMapStorage() {
AreaCodeMapStorageStrategy var31ED7B04A16DD339604BD6A4FB648540_1920404784 =         areaCodeMapStorage;
        var31ED7B04A16DD339604BD6A4FB648540_1920404784.addTaint(taint);
        return var31ED7B04A16DD339604BD6A4FB648540_1920404784;
        // ---------- Original Method ----------
        //return areaCodeMapStorage;
    }

    
        private static int getSizeOfAreaCodeMapStorage(AreaCodeMapStorageStrategy mapStorage,
      SortedMap<Integer, String> areaCodeMap) throws IOException {
        mapStorage.readFromSortedMap(areaCodeMap);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        mapStorage.writeExternal(objectOutputStream);
        objectOutputStream.flush();
        int sizeOfStorage = byteArrayOutputStream.size();
        objectOutputStream.close();
        return sizeOfStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.301 -0400", hash_original_method = "541ED4E710A19E1EDF02867FA9DD727B", hash_generated_method = "CA13BCF3368D8BFF28D6CC5B9001FE18")
    private AreaCodeMapStorageStrategy createDefaultMapStorage() {
AreaCodeMapStorageStrategy var5612085B6FCF2B9D00F0475758608512_1509582090 =         new DefaultMapStorage();
        var5612085B6FCF2B9D00F0475758608512_1509582090.addTaint(taint);
        return var5612085B6FCF2B9D00F0475758608512_1509582090;
        // ---------- Original Method ----------
        //return new DefaultMapStorage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.302 -0400", hash_original_method = "A0A2E6205BB60A092B8D66A75357AACD", hash_generated_method = "1E943F9E1860837A0D5CFA25BF70A9DF")
    private AreaCodeMapStorageStrategy createFlyweightMapStorage() {
AreaCodeMapStorageStrategy var3D730F5F1921CF750D41B64D8DC60212_1750060108 =         new FlyweightMapStorage();
        var3D730F5F1921CF750D41B64D8DC60212_1750060108.addTaint(taint);
        return var3D730F5F1921CF750D41B64D8DC60212_1750060108;
        // ---------- Original Method ----------
        //return new FlyweightMapStorage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.302 -0400", hash_original_method = "F7090ADB0D57C526EAAF391F3C19F58E", hash_generated_method = "E8BBE716753C00DFB9C4FBC638FC39E0")
     AreaCodeMapStorageStrategy getSmallerMapStorage(SortedMap<Integer, String> areaCodeMap) {
        addTaint(areaCodeMap.getTaint());
        try 
        {
            AreaCodeMapStorageStrategy flyweightMapStorage = createFlyweightMapStorage();
            int sizeOfFlyweightMapStorage = getSizeOfAreaCodeMapStorage(flyweightMapStorage, areaCodeMap);
            AreaCodeMapStorageStrategy defaultMapStorage = createDefaultMapStorage();
            int sizeOfDefaultMapStorage = getSizeOfAreaCodeMapStorage(defaultMapStorage, areaCodeMap);
AreaCodeMapStorageStrategy var8A88CAC028C7AE1EFB478006CDA2705C_616635280 =             sizeOfFlyweightMapStorage < sizeOfDefaultMapStorage
          ? flyweightMapStorage : defaultMapStorage;
            var8A88CAC028C7AE1EFB478006CDA2705C_616635280.addTaint(taint);
            return var8A88CAC028C7AE1EFB478006CDA2705C_616635280;
        } //End block
        catch (IOException e)
        {
            LOGGER.severe(e.getMessage());
AreaCodeMapStorageStrategy varC8954BB945BA997C91E808EDD6426356_719382749 =             createFlyweightMapStorage();
            varC8954BB945BA997C91E808EDD6426356_719382749.addTaint(taint);
            return varC8954BB945BA997C91E808EDD6426356_719382749;
        } //End block
        // ---------- Original Method ----------
        //try {
      //AreaCodeMapStorageStrategy flyweightMapStorage = createFlyweightMapStorage();
      //int sizeOfFlyweightMapStorage = getSizeOfAreaCodeMapStorage(flyweightMapStorage, areaCodeMap);
      //AreaCodeMapStorageStrategy defaultMapStorage = createDefaultMapStorage();
      //int sizeOfDefaultMapStorage = getSizeOfAreaCodeMapStorage(defaultMapStorage, areaCodeMap);
      //return sizeOfFlyweightMapStorage < sizeOfDefaultMapStorage
          //? flyweightMapStorage : defaultMapStorage;
    //} catch (IOException e) {
      //LOGGER.severe(e.getMessage());
      //return createFlyweightMapStorage();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.304 -0400", hash_original_method = "B49B377AC81241FFFF2815B40FB81171", hash_generated_method = "6E42B9FA49378DBD52B19E16C35801DE")
    public void readAreaCodeMap(SortedMap<Integer, String> sortedAreaCodeMap) {
        areaCodeMapStorage = getSmallerMapStorage(sortedAreaCodeMap);
        // ---------- Original Method ----------
        //areaCodeMapStorage = getSmallerMapStorage(sortedAreaCodeMap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.305 -0400", hash_original_method = "E451B33DF0760BCBC0A94001216332F0", hash_generated_method = "750AE839AC42A3BEA36999DA395B3D9B")
    public void readExternal(ObjectInput objectInput) throws IOException {
        addTaint(objectInput.getTaint());
        boolean useFlyweightMapStorage = objectInput.readBoolean();
    if(useFlyweightMapStorage)        
        {
            areaCodeMapStorage = new FlyweightMapStorage();
        } //End block
        else
        {
            areaCodeMapStorage = new DefaultMapStorage();
        } //End block
        areaCodeMapStorage.readExternal(objectInput);
        // ---------- Original Method ----------
        //boolean useFlyweightMapStorage = objectInput.readBoolean();
        //if (useFlyweightMapStorage) {
      //areaCodeMapStorage = new FlyweightMapStorage();
    //} else {
      //areaCodeMapStorage = new DefaultMapStorage();
    //}
        //areaCodeMapStorage.readExternal(objectInput);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.306 -0400", hash_original_method = "E6F2985648B73053281BC07D9BFD7460", hash_generated_method = "CF24913F6D7DA86E6B71C3F7D58F187D")
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        addTaint(objectOutput.getTaint());
        objectOutput.writeBoolean(areaCodeMapStorage.isFlyweight());
        areaCodeMapStorage.writeExternal(objectOutput);
        // ---------- Original Method ----------
        //objectOutput.writeBoolean(areaCodeMapStorage.isFlyweight());
        //areaCodeMapStorage.writeExternal(objectOutput);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.307 -0400", hash_original_method = "C66AA501CE9C84CB206C0DD0D1F37167", hash_generated_method = "3DF357342DC29E8409E7C53B1CE394EF")
     String lookup(PhoneNumber number) {
        addTaint(number.getTaint());
        int numOfEntries = areaCodeMapStorage.getNumOfEntries();
    if(numOfEntries == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1520986698 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1520986698.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1520986698;
        } //End block
        long phonePrefix = Long.parseLong(number.getCountryCode() + phoneUtil.getNationalSignificantNumber(number));
        int currentIndex = numOfEntries - 1;
        SortedSet<Integer> currentSetOfLengths = areaCodeMapStorage.getPossibleLengths();
        while
(currentSetOfLengths.size() > 0)        
        {
            Integer possibleLength = currentSetOfLengths.last();
            String phonePrefixStr = String.valueOf(phonePrefix);
    if(phonePrefixStr.length() > possibleLength)            
            {
                phonePrefix = Long.parseLong(phonePrefixStr.substring(0, possibleLength));
            } //End block
            currentIndex = binarySearch(0, currentIndex, phonePrefix);
    if(currentIndex < 0)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1630030139 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1630030139.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1630030139;
            } //End block
            int currentPrefix = areaCodeMapStorage.getPrefix(currentIndex);
    if(phonePrefix == currentPrefix)            
            {
String var7368BDB434CA6DBDBA93D885B81D7AAE_92685531 =                 areaCodeMapStorage.getDescription(currentIndex);
                var7368BDB434CA6DBDBA93D885B81D7AAE_92685531.addTaint(taint);
                return var7368BDB434CA6DBDBA93D885B81D7AAE_92685531;
            } //End block
            currentSetOfLengths = currentSetOfLengths.headSet(possibleLength);
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1128596879 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1128596879.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1128596879;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.308 -0400", hash_original_method = "D192E9C758CA69648AA3FDEEAB806454", hash_generated_method = "E87B0203C4BF268C434CFAB40566D3DA")
    private int binarySearch(int start, int end, long value) {
        addTaint(value);
        addTaint(end);
        addTaint(start);
        int current = 0;
        while
(start <= end)        
        {
            current = (start + end) >>> 1;
            int currentValue = areaCodeMapStorage.getPrefix(current);
    if(currentValue == value)            
            {
                int var43B5C9175984C071F30B873FDCE0A000_1447047723 = (current);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504473328 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504473328;
            } //End block
            else
    if(currentValue > value)            
            {
                current--;
                end = current;
            } //End block
            else
            {
                start = current + 1;
            } //End block
        } //End block
        int var43B5C9175984C071F30B873FDCE0A000_1531633048 = (current);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246590573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246590573;
        // ---------- Original Method ----------
        //int current = 0;
        //while (start <= end) {
      //current = (start + end) >>> 1;
      //int currentValue = areaCodeMapStorage.getPrefix(current);
      //if (currentValue == value) {
        //return current;
      //} else if (currentValue > value) {
        //current--;
        //end = current;
      //} else {
        //start = current + 1;
      //}
    //}
        //return current;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.309 -0400", hash_original_method = "23EEAC8EFBFA0286A27EC362841462A0", hash_generated_method = "643C76A5F491213C9CAC85F16100DBA1")
    @Override
    public String toString() {
String var58B4A58B2055F11D369F061290364B41_1110648225 =         areaCodeMapStorage.toString();
        var58B4A58B2055F11D369F061290364B41_1110648225.addTaint(taint);
        return var58B4A58B2055F11D369F061290364B41_1110648225;
        // ---------- Original Method ----------
        //return areaCodeMapStorage.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.309 -0400", hash_original_field = "9935BD20EEAB0A04287343CC94754F8F", hash_generated_field = "6AC19EA0C920B63C3669AAC19476698A")

    private static final Logger LOGGER = Logger.getLogger(AreaCodeMap.class.getName());
}

