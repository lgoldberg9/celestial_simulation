package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.physics.Centroid;
import edu.grinnell.celestialvisualizer.physics.Physics;
import edu.grinnell.celestialvisualizer.util.Quadrant;
import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

/**
 * A node consisting of a centroid and four sub-quad trees 
 * for the four possible sub-divisions of the space: 
 *   upper left, upper right, lower left, and lower right.
 */
public class CentroidNode implements Node {

	private Centroid centroidNode;
	private Node UPPER_LEFT;
	private Node UPPER_RIGHT;
	private Node LOWER_LEFT;
	private Node LOWER_RIGHT;
	
	public CentroidNode(Centroid centroidNode, Node ul, Node ur, Node ll, Node lr) {
		this.centroidNode = centroidNode;
		this.UPPER_LEFT = ul;
		this.UPPER_RIGHT = ur;
		this.LOWER_LEFT = ll;
		this.LOWER_RIGHT = lr;
	}

	@Override
	public boolean lookup(Point pos, BoundingBox bb) {
		switch (bb.quadrantOf(pos)) {
		case UPPER_LEFT:
			return UPPER_LEFT.lookup(pos, bb.getQuadrant(bb.quadrantOf(pos)));
		case UPPER_RIGHT:
			return UPPER_RIGHT.lookup(pos, bb.getQuadrant(bb.quadrantOf(pos)));
		case LOWER_LEFT:
			return LOWER_LEFT.lookup(pos, bb.getQuadrant(bb.quadrantOf(pos)));
		case LOWER_RIGHT:
			return LOWER_RIGHT.lookup(pos, bb.getQuadrant(bb.quadrantOf(pos)));
		default: 
			throw new IllegalStateException();
		}
	}

	@Override
	public Vector2d calculateAcceleration(Point p, BoundingBox bb, double thresh) {
		if (this.centroidNode.getPosition().distance(p).magnitude() < thresh || bb.contains(p)) {
			Vector2d acceleration = Vector2d.zero;

			acceleration = acceleration.add(UPPER_LEFT.calculateAcceleration(p, bb.getQuadrant(Quadrant.UPPER_LEFT), thresh));
			acceleration = acceleration.add(UPPER_RIGHT.calculateAcceleration(p, bb.getQuadrant(Quadrant.UPPER_RIGHT), thresh));
			acceleration = acceleration.add(LOWER_LEFT.calculateAcceleration(p, bb.getQuadrant(Quadrant.LOWER_LEFT), thresh));
			acceleration = acceleration.add(LOWER_RIGHT.calculateAcceleration(p, bb.getQuadrant(Quadrant.LOWER_RIGHT), thresh));
			
			return acceleration;
		} else {
			return Physics.calculateAccelerationOn(p, this.centroidNode.getMass(), 
					this.centroidNode.getPosition());
		}
	}

	@Override
	public Node insert(double mass, Point p, BoundingBox bb) {
		centroidNode = centroidNode.add(new Centroid(mass, p));
		switch (bb.quadrantOf(p)) {
		case UPPER_LEFT:
			this.UPPER_LEFT = UPPER_LEFT.insert(mass, p, bb.getQuadrant(bb.quadrantOf(p)));
			return this;
		case UPPER_RIGHT:
			this.UPPER_RIGHT = UPPER_RIGHT.insert(mass, p, bb.getQuadrant(bb.quadrantOf(p)));
			return this;
		case LOWER_LEFT:
			this.LOWER_LEFT = LOWER_LEFT.insert(mass, p, bb.getQuadrant(bb.quadrantOf(p)));
			return this;
		case LOWER_RIGHT:
			this.LOWER_RIGHT = LOWER_RIGHT.insert(mass, p, bb.getQuadrant(bb.quadrantOf(p)));
			return this;
		default: 
			throw new IllegalStateException();
		}
	}
	
	@Override
	public boolean equals(Object other) {
		CentroidNode otherTree = (CentroidNode) other;
		return this.UPPER_LEFT.equals(otherTree.UPPER_LEFT) &&
				this.UPPER_RIGHT.equals(otherTree.UPPER_RIGHT) &&
				this.LOWER_LEFT.equals(otherTree.LOWER_LEFT) &&
				this.LOWER_RIGHT.equals(otherTree.LOWER_RIGHT) &&
				this.centroidNode.equals(otherTree.centroidNode);
	}
}
