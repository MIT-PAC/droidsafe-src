package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;

public final class Marker
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.477 -0400", hash_original_method = "24A1D6C5EA12F74B2DBCF503CA643BCC", hash_generated_method = "0DBEFD36EAA2E10A844FDA9101FF6587")
    
public Marker(DSOnlyType dontcare)
    {

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.481 -0400", hash_original_method = "231BF356D5958220FFB804538066F712", hash_generated_method = "DA93DD4DA31E7CD1208BF90EE2F8137E")
    
public void remove()
    {
      
    }

    String id;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.484 -0400", hash_original_method = "371E8A9C5581A58D8CB6E1EF384C3C9B", hash_generated_method = "67F89896A41B0BF511A3A3C7C8AD06C5")
    
public String getId()
    {
    	return id;
    }

    LatLng  position;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.487 -0400", hash_original_method = "56D048931926A0EB72B281C0B7D06F28", hash_generated_method = "FDC65120113E21E1BA8C0956A36F2610")
    
public void setPosition(LatLng  r1)
    {
    	position = r1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.490 -0400", hash_original_method = "0AB3FBC6A63404630533C4D7045AF049", hash_generated_method = "6866B1D62D2FCE1CB5710EB3D6C64361")
    
public LatLng getPosition()
    {
    	return position;
    }
BitmapDescriptor icon; 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.494 -0400", hash_original_method = "922F8B99FCB02FBCC2FE8B48BC5BE12F", hash_generated_method = "5C27E183717BAE86E63E4E4E21F73093")
    
public void setIcon(BitmapDescriptor  r1)
    {
    	icon = r1;
    }

    float anchor;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.498 -0400", hash_original_method = "03861937CAF6669246DA1E4C983E1B76", hash_generated_method = "328A45B74B436A368EDB76FA659D0073")
    
public void setAnchor(float  f0, float  f1)
    {
    	anchor = f0 + f1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.501 -0400", hash_original_method = "BFFA992CE9FC00C9A2818B89EDB38E2E", hash_generated_method = "98F1A7193A92DA41A794937BD54B1404")
    
public void setInfoWindowAnchor(float  f0, float  f1)
    {
    	anchor = f0 + f1;
   
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.505 -0400", hash_original_method = "690275C59E475B61A88E5C37E6B34563", hash_generated_method = "3D4DE30156CD3516CDC78F684E90BD5B")
    
public void setTitle(String  r1)
    {
    	title = r1;
    }
    
    String title;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.508 -0400", hash_original_method = "61F0013D65C468103CD4A131AE4E2ADB", hash_generated_method = "AE9A1602FD8C48929A83A41DB77A5F76")
    
public String getTitle()
    {
    	return title;
    }

    String snippet;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.511 -0400", hash_original_method = "C22B770B5A974DBE8AD666FC9A765EEA", hash_generated_method = "7C5A457CEDCCE54E9F0E63C700DF0ED1")
    
public void setSnippet(String  r1)
    {
    	snippet = r1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.514 -0400", hash_original_method = "9EBDDF0A32F6E0192B9A0371704A4016", hash_generated_method = "1BDB76B760F84FFF1285034EB1F308E8")
    
public String getSnippet()
    {
    	return snippet;
    }
    
    boolean draggable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.519 -0400", hash_original_method = "BB8C825B50AF71C09DF54B0F24221519", hash_generated_method = "AFF635AE6DAADEF53AF85F92CCF3BD1C")
    
public void setDraggable(boolean  z0)
    {
    	draggable = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.522 -0400", hash_original_method = "4D03DA6AC7AD7D167C15F77F6D8102B1", hash_generated_method = "10E273B329D20F6D51D7994CE665692D")
    
public boolean isDraggable()
    {
    	return draggable;
    }
    
    boolean infoWindowVisible;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.525 -0400", hash_original_method = "A4C17FA4A2BA944E8EEAFD532536106C", hash_generated_method = "18D394FE31960D44AA6D44006F095A23")
public void showInfoWindow()
    {
    	infoWindowVisible = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.528 -0400", hash_original_method = "B35CCA0A6A8B636D63022AA7E7DCBD2B", hash_generated_method = "1D8167DBABBDFE2FDD7326E4C5B8CD52")
    
public void hideInfoWindow()
    {
    	infoWindowVisible = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.531 -0400", hash_original_method = "8D76AACB143A508A5B646E1AB78B8E65", hash_generated_method = "66548B84B87BF139EBBFD4CB8AF69B6D")
    
public boolean isInfoWindowShown()
    {
    	return infoWindowVisible;
    }

    boolean visible;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.534 -0400", hash_original_method = "E7F2B1A55AB0349F3AEDF8864F6C9438", hash_generated_method = "E546593ED72E523D3E7C0C638AFA540D")
    
public void setVisible(boolean  z0)
    {
    	visible = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.538 -0400", hash_original_method = "54BACB0DF395CF67FBFBCB871EF21C15", hash_generated_method = "A708A17EBB08B498F06CC30F9BCCF2B3")
    
public boolean isVisible()
    {
    	return visible;
    }

    boolean flat;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.542 -0400", hash_original_method = "159676D71E2CE78C0C0283BB7419CFF7", hash_generated_method = "D5C9E5E6091BBADB2561587CD9BC2E39")
    
public void setFlat(boolean  z0)
    {
    	flat = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.546 -0400", hash_original_method = "9200FF2FB4F43BCC996D6BB0712C9D6F", hash_generated_method = "FCB616CB05972D51D6B3274D1C4171C6")
    
public boolean isFlat()
    {
    	return flat;
    }

    float rotation;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.549 -0400", hash_original_method = "76FCE28E1EAA3329D84D86A03B5F5526", hash_generated_method = "04B3DBC1E61DD2FD10B318C900FC5A94")
    
public void setRotation(float  f0)
    {
    	rotation = f0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.553 -0400", hash_original_method = "428334D532CA6F432C8DA0567F9131FC", hash_generated_method = "496E2A27AA7AB9B3DC8B8CE43CADAC7A")
    
public float getRotation()
    {
    	return rotation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.556 -0400", hash_original_method = "5BA095083939E0B7A323853DD32C2BDA", hash_generated_method = "005A90DB270B56E57B420D24B539222D")
    
public void setAlpha(float  f0)
    {
    	alpha = f0;
    }

    float alpha;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.559 -0400", hash_original_method = "98DE7AC826862833ACB0EC5B5541EB7B", hash_generated_method = "5AF145933F604670EA18181FA2E307B2")
    
public float getAlpha()
    {
    	return alpha;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.563 -0400", hash_original_method = "C70DEA8A17B60956FD21E629F9CB17C2", hash_generated_method = "7F54E6BD2F54D378E444277D129FFD39")
    
public boolean equals(Object  r1)
    {
    	return DSUtils.toTaintBoolean(hashCode() + r1.hashCode());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.566 -0400", hash_original_method = "118FFFE90FA4340C330BF58E930B7855", hash_generated_method = "BAF5CD51F04870B2E81141E4E2BD653A")
    
public int hashCode()
    {
    	return (int)(alpha + anchor + rotation  +
    			    DSUtils.toTaintFloat(draggable || flat || visible) +
    			    icon.hashCode() + id.hashCode() +
    			    position.hashCode() +
    			    title.hashCode() +
    			    snippet.hashCode());
    }
}
