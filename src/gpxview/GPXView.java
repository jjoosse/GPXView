/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gpxview;

import gpx.GpxFile;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author Routz-15032012
 */
public class GPXView {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			GpxFile gpx = GpxFile.ReadGPXFile(args[0]);
			System.out.println(gpx.toString());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GPXView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (XMLStreamException ex) {
			Logger.getLogger(GPXView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
