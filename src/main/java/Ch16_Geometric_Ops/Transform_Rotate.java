/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 *  image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2016 Wilhelm Burger, Mark J. Burge. All rights reserved. 
 * Visit http://imagingbook.com for additional details.
 *******************************************************************************/
package Ch16_Geometric_Ops;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import imagingbook.lib.image.ImageMapper;
import imagingbook.lib.interpolation.InterpolationMethod;
import imagingbook.pub.geometry.mappings.Mapping;
import imagingbook.pub.geometry.mappings.linear.Rotation;


public class Transform_Rotate implements PlugInFilter {
	
	static double angle = 15; // rotation angle (in degrees)

    public int setup(String arg, ImagePlus imp) {
        return DOES_ALL;
    }

    public void run(ImageProcessor ip) {
    	
		Mapping imap = new Rotation((2 * Math.PI * angle) / 360).getInverse();	// inverse (target to source)
		ImageMapper mapper = new ImageMapper(imap, InterpolationMethod.Bicubic);
		mapper.map(ip);
//		imap.applyTo(ip, InterpolationMethod.Bicubic);
    }
}
