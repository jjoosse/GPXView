/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Routz-15032012
 */
public class GpxFile {

	private static Date parseTime(String xmlString) {
		return javax.xml.bind.DatatypeConverter.parseDateTime(xmlString).getTime();
	}

	private Track track;
	private static final int START = 0;
	private static final int GPX = 1;
	private static final int TRACK = 2;
	private static final int TRACKNAME = 3;
	private static final int TRACKTIME = 4;
	private static final int TRACKSEG = 5;
	private static final int TRACKPOINT = 6;
	private static final int TRACKPOINTELE = 7;
	private static final int TRACKPOINTTIME = 8;

	/**
	 * Get the value of track
	 *
	 * @return the value of track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * Set the value of track
	 *
	 * @param track new value of track
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "GpxFile{" + "track=" + track + '}';
	}

	
	public static GpxFile ReadGPXFile(String filename) throws FileNotFoundException, XMLStreamException {
		int state = START;
		GpxFile g = new GpxFile();
		Track t = null;
		TrackSegment s = null;
		TrackPoint p = null;
		StringBuilder tmp = new StringBuilder();
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
		while (xmlr.hasNext()) {
			switch (xmlr.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					switch (state) {
						case START:
							if (xmlr.getLocalName().equals("gpx")) {
								state = GPX;
							}
							break;
						case GPX:
							if (xmlr.getLocalName().equals("trk")) {
								t = new Track();
								state = TRACK;
							}
							break;
						case TRACK:
							if (xmlr.getLocalName().equals("trkseg")) {
								s = new TrackSegment();
								state = TRACKSEG;
							} else if (xmlr.getLocalName().equals("name")) {
								state = TRACKNAME;
								tmp.setLength(0);
							} else if (xmlr.getLocalName().equals("time")) {
								state = TRACKTIME;
								tmp.setLength(0);
							}
							break;
						case TRACKSEG:
							if (xmlr.getLocalName().equals("trkpt")) {
								state = TRACKPOINT;
								double lat = Double.parseDouble(xmlr.getAttributeValue("", "lat"));
								double lon = Double.parseDouble(xmlr.getAttributeValue("", "lon"));
								p = new TrackPoint(lat, lon);
							}
							break;
						case TRACKPOINT:
							if (xmlr.getLocalName().equals("ele")) {
								state = TRACKPOINTELE;
								tmp.setLength(0);
							} else if (xmlr.getLocalName().equals("time")) {
								state = TRACKPOINTTIME;
								tmp.setLength(0);
							}
							break;
						default:
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					switch (state) {
						case TRACKPOINTTIME:
							p.setTime(parseTime(tmp.toString()));
							state = TRACKPOINT;
							break;
						case TRACKPOINTELE:
							p.setElevation(Double.parseDouble(tmp.toString()));
							state = TRACKPOINT;
							break;
						case TRACKPOINT:
							s.getTrackPointList().add(p);
							state = TRACKSEG;
							break;
						case TRACKSEG:
							t.getTrackSegmentList().add(s);
							state = TRACK;
							break;
						case TRACK:
							g.setTrack(t);
							state = GPX;
							break;
						case TRACKNAME:
							t.setName(tmp.toString());
							state = TRACK;
							break;
						case TRACKTIME:
							t.setStartTime(parseTime(tmp.toString()));
							state = TRACK;
							break;
						case GPX:
							break;
						default:
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tmp.append(xmlr.getText());
					break;
				case XMLStreamConstants.CDATA:
					tmp.append(xmlr.getText());
					break;
				default:
					break;
			}
			xmlr.next();
		}
		return g;
	}
}
