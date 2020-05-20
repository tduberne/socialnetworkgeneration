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
package ch.ethz.matsim.socialnetworkgeneration.toy;

import ch.ethz.matsim.socialnetworkgeneration.framework.CliqueStub;
import ch.ethz.matsim.socialnetworkgeneration.framework.EgoLocator;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.population.Person;

/**
 * @author thibautd
 */
public class ToyEgoLocator implements EgoLocator {
	@Override
	public int getDimensionality() {
		return 2;
	}

	@Override
	public double[] getCoord( final CliqueStub object ) {
		final Person p = object.getEgo().getPerson();
		final Coord c = (Coord) p.getCustomAttributes().get( "coord" );
		return new double[]{ c.getX() , c.getY() };
	}
}
