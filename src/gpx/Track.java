/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gpx;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Routz-15032012
 */
public class Track {

	private String name;
	private Date StartTime;
	private ArrayList<TrackSegment> TrackSegmentList;
	private double distance=0;

	public Track() {
		TrackSegmentList = new ArrayList<>();
	}

	/**
	 * Get the value of TrackSegmentList
	 *
	 * @return the value of TrackSegmentList
	 */
	public ArrayList<TrackSegment> getTrackSegmentList() {
		return TrackSegmentList;
	}

	/**
	 * Set the value of TrackSegmentList
	 *
	 * @param TrackSegmentList new value of TrackSegmentList
	 */
	public void setTrackSegmentList(ArrayList<TrackSegment> TrackSegmentList) {
		this.TrackSegmentList = TrackSegmentList;
		distance = 0;
	}

	/**
	 * Get the value of StartTime
	 *
	 * @return the value of StartTime
	 */
	public Date getStartTime() {
		return StartTime;
	}

	/**
	 * Set the value of StartTime
	 *
	 * @param StartTime new value of StartTime
	 */
	public void setStartTime(Date StartTime) {
		this.StartTime = StartTime;
	}

	/**
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of name
	 *
	 * @param name new value of name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Track{" + "name=" + name + ", StartTime=" + StartTime + ", TrackSegmentList=" + TrackSegmentList + '}';
	}

	public double getDistance() {
		if (distance == 0.0 && TrackSegmentList.size() > 0) {
			distance = calculateDistance();
		}
		return distance;
	}
	
		/**
	 *
	 * @return Total track distance by calculating distance of each TrackSegment
	 */
	private double calculateDistance() {
		double dist=0;
		for (TrackSegment seg : TrackSegmentList ) {
			dist += seg.calculateDistance();
		}
		return dist;
	}
}
