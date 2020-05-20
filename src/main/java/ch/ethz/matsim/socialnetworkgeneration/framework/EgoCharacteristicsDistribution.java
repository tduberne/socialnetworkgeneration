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
package ch.ethz.matsim.socialnetworkgeneration.framework;

import org.matsim.api.core.v01.population.Person;
import org.matsim.core.utils.collections.Tuple;

import ch.ethz.matsim.socialnetworkgeneration.snowball.cliquedistributionsnowball.CliqueEgoDistribution;

import java.util.Collection;

/**
 * <p>
 * Functional interface that create an {@link Ego} and a collection of {@link CliqueStub}s
 * for a {@link Person}.
 * </p>
 * 
 * <p>
 * Look at chapter 5 of <a href="https://doi.org/10.3929/ethz-b-000165685">this dissertation</a> for a description of those concepts.
 * </p>
 * 
 * <p>
 * Look at {@link CliqueEgoDistribution} for an example implementation.
 * </p>
 * 
 * @author thibautd
 */
public interface EgoCharacteristicsDistribution {
	Tuple<Ego,Collection<CliqueStub>> sampleEgo( Person person );
}
