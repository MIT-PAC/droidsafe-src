package dk.brics.string.java;

import soot.ValueBox;
import dk.brics.string.intermediate.Hotspot;

/**
 * Contains a {@link Hotspot} statement and the {@link ValueBox} holding the expression
 * that was originally marked as the hotspot.
 */
public class HotspotValueBoxPair {
	// The reason we do not store ValueBox directly in the Hotspot-statement, is so
	// the intermediate representation is decoupled from both Soot and the Soot->Intermediate translator.
	
	private Hotspot hotspot;
	private ValueBox box;
	
	public HotspotValueBoxPair() {
	}
	public HotspotValueBoxPair(Hotspot hotspot, ValueBox box) {
		this.hotspot = hotspot;
		this.box = box;
	}
	
	public Hotspot getHotspot() {
		return hotspot;
	}
	public void setHotspot(Hotspot hotspot) {
		this.hotspot = hotspot;
	}
	public ValueBox getBox() {
		return box;
	}
	public void setBox(ValueBox box) {
		this.box = box;
	}
}
