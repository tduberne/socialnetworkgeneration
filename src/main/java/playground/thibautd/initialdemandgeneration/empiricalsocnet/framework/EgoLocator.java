/* *********************************************************************** *
 * project: org.matsim.*
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2013 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package playground.thibautd.initialdemandgeneration.empiricalsocnet.framework;

import playground.thibautd.initialdemandgeneration.empiricalsocnet.snowball.SnowballLocator;
import playground.thibautd.utils.spatialcollections.SpatialCollectionUtils;

/**
 * <p>
 * Defines the coordinates of the {@link Ego} corresponding to a {@link CliqueStub} in a Cartesian plane.
 * In addition to spatial coordinates of the home location, dimensions can include socio-demographic characteristics,
 * such as age, gender, or any other dimension relevant to the choice of social contacts.
 * </p>
 * 
 * <p>
 * Refer to {@link SnowballLocator} for an example implementation.
 * </p>
 * 
 * @author thibautd
 */
public interface EgoLocator extends SpatialCollectionUtils.Coordinate<CliqueStub> {
	int getDimensionality();
}
