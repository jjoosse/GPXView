/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gpx;

import java.util.ArrayList;

/**
 *
 * @author Routz-15032012
 */
public class TrackSegment {

	private ArrayList<TrackPoint> TrackPointList;

	public TrackSegment() {
		this.TrackPointList = new ArrayList<>();
	}

	/**
	 * Get the value of TrackPointList
	 *
	 * @return the value of TrackPointList
	 */
	public ArrayList<TrackPoint> getTrackPointList() {
		return TrackPointList;
	}

	/**
	 * Set the value of TrackPointList
	 *
	 * @param TrackPointList new value of TrackPointList
	 */
	public void setTrackPointList(ArrayList<TrackPoint> TrackPointList) {
		this.TrackPointList = TrackPointList;
	}

	@Override
	public String toString() {
		return "TrackSegment{" + "TrackPointList=" + TrackPointList + '}';
	}
	
}
