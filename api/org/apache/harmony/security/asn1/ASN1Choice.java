package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class ASN1Choice extends ASN1Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.552 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "24AC453E9AFABA0FC5B4FCBCBDACD1C1")

    public ASN1Type[] type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.552 -0400", hash_original_field = "7C26F6AE97679422063D8D33A8623C57", hash_generated_field = "1F2CA11DFA4827FAB5EEB375959000C9")

    private int[][] identifiers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.553 -0400", hash_original_method = "C70F669111768591EE425211051DE956", hash_generated_method = "0A521D76BFC104F2FD3AF9160B4CE00B")
    public  ASN1Choice(ASN1Type[] type) {
        super(TAG_CHOICE);
    if(type.length == 0)        
        {
            IllegalArgumentException varA30EE3C21D9252CC8F55AED295BFD0EC_1130010787 = new IllegalArgumentException("ASN.1 choice type MUST have at least one alternative: " + getClass().getName());
            varA30EE3C21D9252CC8F55AED295BFD0EC_1130010787.addTaint(taint);
            throw varA30EE3C21D9252CC8F55AED295BFD0EC_1130010787;
        } 
        TreeMap<BigInteger, BigInteger> map = new TreeMap<BigInteger, BigInteger>();
for(int index = 0;index < type.length;index++)
        {
            ASN1Type t = type[index];
    if(t instanceof ASN1Any)            
            {
                IllegalArgumentException varB134C14190723899B6D3F2385B1E9F0C_1785650688 = new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName());
                varB134C14190723899B6D3F2385B1E9F0C_1785650688.addTaint(taint);
                throw varB134C14190723899B6D3F2385B1E9F0C_1785650688;
            } 
            else
    if(t instanceof ASN1Choice)            
            {
                int[][] choiceToAdd = ((ASN1Choice) t).identifiers;
for(int j = 0;j < choiceToAdd[0].length;j++)
                {
                    addIdentifier(map, choiceToAdd[0][j], index);
                } 
                continue;
            } 
    if(t.checkTag(t.id))            
            {
                addIdentifier(map, t.id, index);
            } 
    if(t.checkTag(t.constrId))            
            {
                addIdentifier(map, t.constrId, index);
            } 
        } 
        int size = map.size();
        identifiers = new int[2][size];
        Iterator<Map.Entry<BigInteger, BigInteger>> it = map.entrySet().iterator();
for(int i = 0;i < size;i++)
        {
            Map.Entry<BigInteger, BigInteger> entry = it.next();
            BigInteger identifier = entry.getKey();
            identifiers[0][i] = identifier.intValue();
            identifiers[1][i] = entry.getValue().intValue();
        } 
        this.type = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.553 -0400", hash_original_method = "781B2DE1C4956E14672C3431AF37B058", hash_generated_method = "6619B2372C6500698B9FDDACE7E23935")
    private void addIdentifier(TreeMap<BigInteger, BigInteger> map, int identifier, int index) {
        addTaint(index);
        addTaint(identifier);
        addTaint(map.getTaint());
    if(map.put(BigInteger.valueOf(identifier), BigInteger.valueOf(index)) != null)        
        {
            IllegalArgumentException varB87B397221009831B18100BEA781D46C_170683237 = new IllegalArgumentException("ASN.1 choice type MUST have alternatives "
                    + "with distinct tags: " + getClass().getName());
            varB87B397221009831B18100BEA781D46C_170683237.addTaint(taint);
            throw varB87B397221009831B18100BEA781D46C_170683237;
        } 
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.554 -0400", hash_original_method = "0D992D1A6B83EB18D65339F632B428D0", hash_generated_method = "840081F81E3E8EDBEDC14378142B0D24")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var575F61571EA47E113B0429F030740FA4_1040505965 = (Arrays.binarySearch(identifiers[0], identifier) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490230323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490230323;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.554 -0400", hash_original_method = "CA43C2DB32698BB605AF1C7E4ECA1770", hash_generated_method = "40CF517C370788FC820F8D4690BDD822")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        int index = Arrays.binarySearch(identifiers[0], in.tag);
    if(index < 0)        
        {
            ASN1Exception varD4634E00844A07C6957E981700EF8C29_813595634 = new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());
            varD4634E00844A07C6957E981700EF8C29_813595634.addTaint(taint);
            throw varD4634E00844A07C6957E981700EF8C29_813595634;
        } 
        index = identifiers[1][index];
        in.content = type[index].decode(in);
        in.choiceIndex = index;
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_801179619 =             null;
            var540C13E9E156B687226421B24F2DF178_801179619.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_801179619;
        } 
Object var6AD043AF0280111F31D0D60A6CD70863_454351114 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_454351114.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_454351114;
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.554 -0400", hash_original_method = "C4E40B33E0FA7E203CD41695E7BB47C7", hash_generated_method = "F1BD1732956943D5CBB4D73510B3D15D")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        encodeContent(out);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.554 -0400", hash_original_method = "2AF14DF9816B381764BA8B204B1F7CEE", hash_generated_method = "6D3608C9807EBDFA390F9212E511F218")
    public final void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeChoice(this);
        
        
    }

    
    public abstract int getIndex(Object object);

    
    public abstract Object getObjectToEncode(Object object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.555 -0400", hash_original_method = "C699EF204D8C8BCCF80A813C218D94FB", hash_generated_method = "D12448A90C879F9ACB156082386AB5C8")
    public final void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.getChoiceLength(this);
        
        
    }

    
}

