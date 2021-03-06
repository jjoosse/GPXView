/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpx;

import java.util.Date;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticMeasurement;
import org.gavaghan.geodesy.GlobalPosition;

/**
 *
 * @author Routz-15032012
 */
public class TrackPoint {

	private double lat;

	private double lon;

	private double elevation;

	private Date time;

	public TrackPoint(double lat, double lon, double elevation, Date time) {
		this.lat = lat;
		this.lon = lon;
		this.elevation = elevation;
		this.time = time;
	}

	TrackPoint(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * Get the value of time
	 *
	 * @return the value of time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Set the value of time
	 *
	 * @param time new value of time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Get the value of elevation
	 *
	 * @return the value of elevation
	 */
	public double getElevation() {
		return elevation;
	}

	/**
	 * Set the value of elevation
	 *
	 * @param elevation new value of elevation
	 */
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	/**
	 * Get the value of lon
	 *
	 * @return the value of lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Set the value of lon
	 *
	 * @param lon new value of lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Get the value of lat
	 *
	 * @return the value of lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Set the value of lat
	 *
	 * @param lat new value of lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "TrackPoint{" + "lat=" + lat + ", lon=" + lon + ", elevation=" + elevation + ", time=" + time + '}';
	}
	
	/**
	 * Calculates the distance between this point and the TrackPoint 
	 * passed as argument.
	 * 
	 * @param tp TrackPoint to calculate distance to.
	 * @return distance in meters
	 */
public double CalculateDistance(TrackPoint tp) {
	// instantiate the calculator
		GeodeticCalculator geoCalc = new GeodeticCalculator();

		// select a reference elllipsoid
		Ellipsoid reference = Ellipsoid.WGS84;
		GlobalPosition first = new GlobalPosition(this.getLat(), this.getLon(), this.getElevation());
		GlobalPosition second = new GlobalPosition(tp.getLat(),tp.getLon(),tp.getElevation());
		GeodeticMeasurement geoMeasurement = 
			geoCalc.calculateGeodeticMeasurement(reference, first, second);
		return geoMeasurement.getPointToPointDistance();
}
}
