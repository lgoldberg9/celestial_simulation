package edu.grinnell.celestialvisualizer.physics;

import java.util.List;

import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

/**
 * A body represents a star, planet, asteroid, etc., in our simulation.
 * It contains its mass, current position, and current velocity.
 */
public class Body {
    
    private double mass;
    private Point position;
    private Vector2d velocity;
    
    /**
     * Constructs a new celestial body.
     * @param mass the mass of the body
     * @param position the initial position of the body
     * @param velocity the initial velocity of the body
     */
    public Body(double mass, Point position, Vector2d velocity) {
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }
    
    /** @return the mass of the body */
    public double getMass() { return mass; }
    /** @return the position of the body */
    public Point getPosition() { return position; }
    /** @return the velocity of the body */
    public Vector2d getVelocity() { return velocity; }
    
    /**
     * Displaces the body by the given vector.
     * @param v the vector by which by displace the velocity.
     */
    public void displace(Vector2d v) {
        position = position.translate(v);
    }
    
    /**
     * Increases the velocity of this body by the given amount.
     * @param v the increase in velocity for this body.
     */
    public void addToVelocity(Vector2d v) {
        velocity = velocity.add(v);
    }
    
    /**
     * Calculates the acceleration on this body by the given list of bodies.
     * The acceleration is simply the sum of the accelerations as given by
     * the universal law of gravitation.
     * @param bodies the bodies acting upon this body
     * @return the total acceleration imparted by the given bodies on this one.
     */
    public Vector2d calculateAcceleration(List<Body> bodies) {

    	Point pos = this.getPosition();
    	Vector2d acceleration = Vector2d.zero;
    	
    	for (Body planet : bodies) {		
    		acceleration = acceleration.add(
    				Physics.calculateAccelerationOn(pos, planet.getMass(), planet.getPosition()));
    	}
    	
    	return acceleration;
    }
    
    /**
     * Updates this body in our simulation according to the given parameters.
     * Body updates proceed by updating the position first and then the
     * velocity.
     * @param elapsedTime the time step in the simulation
     * @param acc the calculated acceleration used to update this body
     */
    public void update(double elapsedTime, Vector2d acc) {
    	
    	Point pos = this.getPosition();
    	Vector2d vel = this.getVelocity();
    	
    	// Updates position.
    	this.position = Physics.calculateUpdatedPosition(pos, elapsedTime, vel, acc);

    	// Updates velocity.
    	this.velocity = Physics.calculateUpdatedVelocity(vel, elapsedTime, acc);
    }
}
