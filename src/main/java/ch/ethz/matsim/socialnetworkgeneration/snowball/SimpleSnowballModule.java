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
package ch.ethz.matsim.socialnetworkgeneration.snowball;

import ch.ethz.matsim.socialnetworkgeneration.framework.CliquesFiller;
import ch.ethz.matsim.socialnetworkgeneration.framework.EgoCharacteristicsDistribution;
import ch.ethz.matsim.socialnetworkgeneration.framework.EgoLocator;
import ch.ethz.matsim.socialnetworkgeneration.snowball.cliquedistributionsnowball.CliqueEgoDistribution;
import ch.ethz.matsim.socialnetworkgeneration.snowball.cliquedistributionsnowball.CliquesDistributionCliquesFiller;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigGroup;

import ch.ethz.matsim.socialnetworkgeneration.utils.spatialcollections.SpatialCollectionUtils;

/**
 * @author thibautd
 */
public class SimpleSnowballModule extends AbstractModule {
	private final SnowballCliques snowballCliques;

	// could use matsim module to avoid passing config, but better to read data in constructor (configure might be called
	// several times)
	public SimpleSnowballModule( final Config config ) {
		final SnowballSamplingConfigGroup configGroup =
				(SnowballSamplingConfigGroup) config.getModule(
					SnowballSamplingConfigGroup.GROUP_NAME );
		this.snowballCliques = SnowballCliques.readCliques(
											ConfigGroup.getInputFileURL(
													config.getContext(),
													configGroup.getInputCliquesCsv() ).getPath() );
	}

	@Override
	protected void configure() {
		// this should remain the same between methods
		bind( EgoLocator.class ).to( SnowballLocator.class );
		bind( Position.class ).to( SnowballLocator.class );
		bind( new TypeLiteral<SpatialCollectionUtils.Metric<double[]>>(){} ).to( SnowballLocator.class );

		bind( SocialPositions.class );

		bind( SnowballCliques.class ).toInstance( snowballCliques );

		bind( EgoCharacteristicsDistribution.class ).to( CliqueEgoDistribution.class );
		bind( CliquesFiller.class ).to( CliquesDistributionCliquesFiller.class );
	}
}
