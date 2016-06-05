package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.physics.Centroid;
import edu.grinnell.celestialvisualizer.physics.Physics;
import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

/**
 * A node consisting of a single body (represented by a mass and position).
 */
public class LeafNode implements Node {

	private static final double EPSILON = 0.00001;
	private double mass;
	private Point position;
	
	public LeafNode(double mass, Point position) {
		this.mass = mass;
		this.position = position;
	}

	@Override
	public boolean lookup(Point pos, BoundingBox bb) {
		return this.position.equals(pos);
	}

	@Override
	public Vector2d calculateAcceleration(Point p, BoundingBox bb, double thresh) {
		return Physics.calculateAccelerationOn(p, this.mass, this.position);
	}

	@Override
	public Node insert(double mass, Point p, BoundingBox bb) {
		if (this.position.equals(p)) {
			return new LeafNode(this.mass + mass, p);
		} else {
			CentroidNode newCentroid = 
					new CentroidNode(new Centroid(0, new Point(0,0)),
					new EmptyNode(), new EmptyNode(), new EmptyNode(), new EmptyNode());
			
			newCentroid.insert(this.mass, this.position, bb);
			newCentroid.insert(mass, p, bb);
			
			return newCentroid;
		}
	}
	//delta comparison, abs value of difference look at point class equals
	@Override
	public boolean equals(Object other) {
		if (other instanceof LeafNode) {
			LeafNode otherNode = (LeafNode) other;
			return (Math.abs(this.mass - otherNode.mass)) < EPSILON && 
					Math.abs(this.position.distance(otherNode.position).magnitude()) < EPSILON;
		} else {
			return false;
		}
	}

}
