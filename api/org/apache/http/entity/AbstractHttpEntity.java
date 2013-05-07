package org.apache.http.entity;

import org.apache.http.HttpEntity;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractHttpEntity implements HttpEntity {
	@DSModeled(DSC.SAFE)
	protected AbstractHttpEntity() {}

}
