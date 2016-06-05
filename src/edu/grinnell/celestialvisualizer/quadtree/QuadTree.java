package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.physics.Centroid;
import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

/**
 * A quadTree divides a two-dimensional space into four parts, or quadrants.
 * It is used to calculate the acceleration of specific points in space.
 */
public class QuadTree {
    
	private Node root;
	
	public QuadTree() {
		this.root = new EmptyNode();
	}
	
	// The documentation here is contained in the Node interface.
	
    public boolean lookup(Point pos, BoundingBox bb) {
    	if (pos == null || bb == null) {
    		throw new IllegalArgumentException();
    	} else {
    		return this.root.lookup(pos, bb);
    	}
    }
    
    public Vector2d calculateAcceleration(Point p, BoundingBox bb, double eps) {
    	if (p == null || bb == null) {
    		throw new IllegalArgumentException();
    	} else {
    		return this.root.calculateAcceleration(p, bb, eps);
    	}
    }
    
    public void insert(double mass, Point pos, BoundingBox bb) {
    	if (pos == null || bb == null) {
    		throw new IllegalArgumentException();
    	} else {
    		this.root = this.root.insert(mass, pos, bb);
    	}
    }
    
    @Override
    public boolean equals(Object other) {
    	if (other == null) {
    		throw new IllegalArgumentException();
    	} else if (other instanceof QuadTree) {
    		QuadTree otherTree = (QuadTree) other;
    		return this.root.equals(otherTree.root);
    	} else {
    		return false;
    	}
    }
    
    /**
     * Example 1 from the homework assignment.
     * @return q0, a quadTree.
     */
    public static QuadTree q0() {
    	QuadTree q = new QuadTree();
    	return q;
    }
    
    /**
     * Example 2 from the homework assignment.
     * @return q1, a quadTree.
     */
    public static QuadTree q1() {
    	QuadTree q = new QuadTree();
    	q.root = new LeafNode(1.0, new Point(1.5, 2.5));
    	return q;
    }
    
    /**
     * Example 3 from the homework assignment.
     * @return q2, a quadTree.
     */
    public static QuadTree q2() {
    	QuadTree q = new QuadTree();
    	Centroid b1 = new Centroid(1.0, new Point(1.5, 2.5));
    	Centroid b2 = new Centroid(1.0, new Point(2.1, 2.1));
    	q.root = new CentroidNode(
    			b1.add(b2),
    			new EmptyNode(),                           // upper left
    			new EmptyNode(),                           // upper right
    			new LeafNode(1.0, new Point(1.5, 2.5)),    // lower left
    			new LeafNode(1.0, new Point(2.1, 2.1)));   // lower right
    	return q;
    }
    
    /**
     * Example 4 from the homework assignment.
     * @return q3, a quadTree.
     */
    public static QuadTree q3() {
    	QuadTree q = new QuadTree();
    	Centroid b1 = new Centroid(1.0, new Point(1.5, 2.5));
    	Centroid b2 = new Centroid(1.0, new Point(2.1, 2.1));
    	Centroid b3 = new Centroid(2.0, new Point(1.0, 1.0));
    	q.root = new CentroidNode(
    			b1.add(b2).add(b3),
    			new LeafNode(2.0, new Point(1.0, 1.0)),    // upper left
    			new EmptyNode(),                           // upper right
    			new LeafNode(1.0, new Point(1.5, 2.5)),    // lower left
    			new LeafNode(1.0, new Point(2.1, 2.1)));   // lower right
    	return q;
    }
    
    /**
     * Example 5 from the homework assignment.
     * @return q4, a quadTree.
     */
    public static final QuadTree q4() {
    	QuadTree q = new QuadTree();
    	Centroid b1 = new Centroid(1.0, new Point(1.5, 2.5));
    	Centroid b2 = new Centroid(1.0, new Point(2.1, 2.1));
    	Centroid b3 = new Centroid(2.0, new Point(1.0, 1.0));
    	Centroid b4 = new Centroid(1.0, new Point(2.6, 2.8));
    	Centroid c1 = b2.add(b4);
    	Centroid c2 = c1.add(b3).add(b1);
    	q.root = new CentroidNode(c2,
    			new LeafNode(2.0, new Point(1.0, 1.0)),      // level 1—upper left
    			new EmptyNode(),                             // level 1—upper right
    			new LeafNode(1.0, new Point(1.5, 2.5)),      // level 1—lower left
    			new CentroidNode(c1,                         // level 1—lower right
    					new CentroidNode(c1,                       //   level 2—upper left
    							new LeafNode(1.0, new Point(2.1, 2.1)),  //     level 3—upper left
    							new EmptyNode(),                         //     level 3—upper right
    							new EmptyNode(),                         //     level 3—lower left
    							new LeafNode(1.0, new Point(2.6, 2.8))   //     level 3—lower right
    							),
    					new EmptyNode(),                           //   level 2—upper right
    					new EmptyNode(),                           //   level 2—lower left
    					new EmptyNode()                            //   level 2—lower right
    					)
    			);
    	return q;
    }
}
