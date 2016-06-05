package edu.grinnell.celestialvisualizer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import edu.grinnell.celestialvisualizer.physics.Body;
import edu.grinnell.celestialvisualizer.physics.NBody;
import edu.grinnell.celestialvisualizer.physics.Physics;
import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

/**
 * A collection of sample systems for use in your program.
 * In particular, the constants SOLAR_SYSTEM, PLANETS, and COLLISION can be
 * used in your program.
 */
public class NBodyExamples {

    /**
     * The size of our world  used throughout our simulations.  The values
     * given below are in terms of this value.
     */
    public static final double DISTANCE = 4000000000.0;
    
    /**
     * The initial bounding box encompassing our world.  This box is also used
     * throughout our simulation.
     * With this bounding box, the middle of the world is at (0, 0).
     */
    public static final BoundingBox WORLD_BOX =
            new BoundingBox(DISTANCE * -5000, DISTANCE * -5000, DISTANCE * 5000, DISTANCE * 5000);
    
    
    private static final double SUN_MASS = 2.0e30;
    private static final Body SUN = new Body(SUN_MASS, new Point(0.0, 0.0), new Vector2d(0.0, 0.0));
    private static final Body MERCURY = new Body(3.30e23, new Point(57910000.0, 0.), new Vector2d(9000.0, 9000.0));
    private static final Body VENUS = new Body(4.87e24, new Point(0.0, 108200000.0), new Vector2d(-9000.0, 0.0));
    private static final Body EARTH = new Body(5.98e24, new Point(-149600000.0, 0.0), new Vector2d(0.0, -9000.0));
    private static final Body MARS = new Body(6.42e23, new Point(0.0, -227940000.0), new Vector2d(600000.0, 0.0));
    private static final Body JUPITER = new Body(1.90e27, new Point(778330000.0, 0.0), new Vector2d(0.0, 450000.0));
    private static final Body SATURN = new Body(5.69e26, new Point(0.0, 1426940000.0), new Vector2d (-300000.0,0.0));
    private static final Body URANUS = new Body(8.69e26, new Point(-2870990000.0, 0.0), new Vector2d(0.0, -200000.0));

    private static final double vspacing = 108200000.0;
    private static final double hspacing = 78200000.0;
    private static final double hwshift = 2026940000.0;
    private static final double vshift = 1926940000.0;
    
    private static final Body blackhole = new Body(SUN_MASS * 10, new Point(0,0), new Vector2d(0,0));
    private static final Body w1 = new Body(SUN_MASS, new Point(-hwshift,-vshift), new Vector2d(0,0));
    private static final Body w2 = new Body(SUN_MASS, new Point(hspacing-hwshift,vspacing-vshift), new Vector2d(0,0));
    private static final Body w3 = new Body(SUN_MASS, new Point(-hspacing-hwshift,vspacing-vshift), new Vector2d(0,0));
    private static final Body w4 = new Body(SUN_MASS, new Point(2*hspacing-hwshift,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body w5 = new Body(SUN_MASS, new Point(-2*hspacing-hwshift,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body w6 = new Body(SUN_MASS, new Point(3*hspacing-hwshift,vspacing-vshift), new Vector2d(0,0));
    private static final Body w7 = new Body(SUN_MASS, new Point(-3*hspacing-hwshift,vspacing-vshift), new Vector2d(0,0));
    private static final Body w8 = new Body(SUN_MASS, new Point(4*hspacing-hwshift,-vshift), new Vector2d(0,0));
    private static final Body w9 = new Body(SUN_MASS, new Point(-4*hspacing-hwshift,-vshift), new Vector2d(0,0));
    private static final Body w10 = new Body(SUN_MASS, new Point(5*hspacing-hwshift,-vspacing-vshift), new Vector2d(0,0));
    private static final Body w11 = new Body(SUN_MASS, new Point(-5*hspacing-hwshift,-vspacing-vshift), new Vector2d(0,0));
    private static final Body w12 = new Body(SUN_MASS, new Point(6*hspacing-hwshift,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body w13 = new Body(SUN_MASS, new Point(-6*hspacing-hwshift,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body w14 = new Body(SUN_MASS, new Point(7*hspacing-hwshift,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body w15 = new Body(SUN_MASS, new Point(-7*hspacing-hwshift,-3*vspacing-vshift), new Vector2d(0,0));
    
    private static final double hashift = 826940000.0;
    private static final Body a1 = new Body(SUN_MASS, new Point(-hashift,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body a2 = new Body(SUN_MASS, new Point(hspacing-hashift,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body a3 = new Body(SUN_MASS, new Point(-hspacing-hashift,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body a4 = new Body(SUN_MASS, new Point(2*hspacing-hashift,-vspacing-vshift), new Vector2d(0,0));
    private static final Body a5 = new Body(SUN_MASS, new Point(-2*hspacing-hashift,-vspacing-vshift), new Vector2d(0,0));
    private static final Body a6 = new Body(SUN_MASS, new Point(3*hspacing-hashift,-vshift), new Vector2d(0,0));
    private static final Body a7 = new Body(SUN_MASS, new Point(-3*hspacing-hashift,-vshift), new Vector2d(0,0));
    private static final Body a8 = new Body(SUN_MASS, new Point(4*hspacing-hashift,vspacing-vshift), new Vector2d(0,0));
    private static final Body a9 = new Body(SUN_MASS, new Point(-4*hspacing-hashift,vspacing-vshift), new Vector2d(0,0));
    private static final Body a10 = new Body(SUN_MASS, new Point(5*hspacing-hashift,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body a11 = new Body(SUN_MASS, new Point(-5*hspacing-hashift,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body a12 = new Body(SUN_MASS, new Point(-3.0/2.0*hspacing-hashift,-vshift), new Vector2d(0,0));
    private static final Body a13 = new Body(SUN_MASS, new Point(3.0/2.0*hspacing-hashift,-vshift), new Vector2d(0,0));
    private static final Body a14 = new Body(SUN_MASS, new Point(-hashift,-vshift), new Vector2d(0,0));
  
    private static final double hlshift = 0;
    private static final Body l1 = new Body(SUN_MASS, new Point(hlshift,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body l2 = new Body(SUN_MASS, new Point(hlshift,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body l3 = new Body(SUN_MASS, new Point(hlshift,-1*vspacing-vshift), new Vector2d(0,0));
    private static final Body l4 = new Body(SUN_MASS, new Point(hlshift,-0*vspacing-vshift), new Vector2d(0,0));
    private static final Body l5 = new Body(SUN_MASS, new Point(hlshift,1*vspacing-vshift), new Vector2d(0,0));
    private static final Body l6 = new Body(SUN_MASS, new Point(hlshift,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body l7 = new Body(SUN_MASS, new Point(hlshift+3.0/2.0*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body l8 = new Body(SUN_MASS, new Point(hlshift+7.0/2.0*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body l9 = new Body(SUN_MASS, new Point(hlshift+11.0/2.0*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    
    private static final double htshift = 726940000.0;
    private static final Body t1 = new Body(SUN_MASS, new Point(htshift+0*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body t2 = new Body(SUN_MASS, new Point(htshift+2*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body t3 = new Body(SUN_MASS, new Point(htshift+4*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body t4 = new Body(SUN_MASS, new Point(htshift+6*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body t5 = new Body(SUN_MASS, new Point(htshift+8*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body t6 = new Body(SUN_MASS, new Point(htshift+4*hspacing,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body t7 = new Body(SUN_MASS, new Point(htshift+4*hspacing,-1*vspacing-vshift), new Vector2d(0,0));
    private static final Body t8 = new Body(SUN_MASS, new Point(htshift+4*hspacing, -vshift), new Vector2d(0,0));
    private static final Body t9 = new Body(SUN_MASS, new Point(htshift+4*hspacing, vspacing-vshift), new Vector2d(0,0));
    private static final Body t10 = new Body(SUN_MASS, new Point(htshift+4*hspacing, 2*vspacing-vshift), new Vector2d(0,0));
    
    private static final double hzshift = 1726940000.0;
    private static final Body z1 = new Body(SUN_MASS, new Point(hzshift+0*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body z2 = new Body(SUN_MASS, new Point(hzshift+2*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body z3 = new Body(SUN_MASS, new Point(hzshift+4*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body z4 = new Body(SUN_MASS, new Point(hzshift+6*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body z5 = new Body(SUN_MASS, new Point(hzshift+8*hspacing,-3*vspacing-vshift), new Vector2d(0,0));
    private static final Body z6 = new Body(SUN_MASS, new Point(hzshift+7*hspacing,-2*vspacing-vshift), new Vector2d(0,0));
    private static final Body z7 = new Body(SUN_MASS, new Point(hzshift+5*hspacing,-1*vspacing-vshift), new Vector2d(0,0));
    private static final Body z8 = new Body(SUN_MASS, new Point(hzshift+3*hspacing,-0*vspacing-vshift), new Vector2d(0,0));
    private static final Body z9 = new Body(SUN_MASS, new Point(hzshift+1*hspacing,1*vspacing-vshift), new Vector2d(0,0));
    private static final Body z10 = new Body(SUN_MASS, new Point(hzshift+0*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body z11 = new Body(SUN_MASS, new Point(hzshift+2*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body z12 = new Body(SUN_MASS, new Point(hzshift+4*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body z13 = new Body(SUN_MASS, new Point(hzshift+6*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    private static final Body z14 = new Body(SUN_MASS, new Point(hzshift+8*hspacing,2*vspacing-vshift), new Vector2d(0,0));
    
    private static final Body q1 = new Body(SUN_MASS, new Point(-1483300000.0,0), new Vector2d(0,0));
    private static final Body q2 = new Body(SUN_MASS, new Point(-1432757778,-383906289), new Vector2d(0,0));
    private static final Body q3 = new Body(SUN_MASS, new Point(-1284575481,-741649999), new Vector2d(0,0));
    private static final Body q4 = new Body(SUN_MASS, new Point(-1048851488.0,-1048851488), new Vector2d(0,0));
    private static final Body q5 = new Body(SUN_MASS, new Point(-741650000.0,-1284575481), new Vector2d(0,0));
    private static final Body q6 = new Body(SUN_MASS, new Point(-383906289.0,-1432757778), new Vector2d(0,0));
    private static final Body q7 = new Body(SUN_MASS, new Point(0,-1483300000), new Vector2d(0,0));
    private static final Body q8 = new Body(SUN_MASS, new Point(383906289.0,-1432757778), new Vector2d(0,0));
    private static final Body q9 = new Body(SUN_MASS, new Point(741649999.0,-1284575481), new Vector2d(0,0));
    private static final Body q10 = new Body(SUN_MASS, new Point(1048851488.0,-1048851488), new Vector2d(0,0));
    private static final Body q11 = new Body(SUN_MASS, new Point(1284575481.0,-741650000), new Vector2d(0,0));
    private static final Body q12 = new Body(SUN_MASS, new Point(1432757778.0,-383906289), new Vector2d(0,0));
    private static final Body q13 = new Body(SUN_MASS, new Point(1483300000.0,0), new Vector2d(0,0));
    private static final Body q14 = new Body(SUN_MASS, new Point(1432757778.0,383906289), new Vector2d(0,0));
    private static final Body q15 = new Body(SUN_MASS, new Point(1284575481.0,741649999), new Vector2d(0,0));
    private static final Body q16 = new Body(SUN_MASS, new Point(1048851488.0,1048851488), new Vector2d(0,0));
    private static final Body q17 = new Body(SUN_MASS, new Point(741650000.0,1284575481), new Vector2d(0,0));
    private static final Body q18 = new Body(SUN_MASS, new Point(383906289.0,1432757778), new Vector2d(0,0));
    private static final Body q19 = new Body(SUN_MASS, new Point(0,1483300000), new Vector2d(0,0));
    private static final Body q20 = new Body(SUN_MASS, new Point(0,1783300000), new Vector2d(0,0));
    private static final Body q21 = new Body(SUN_MASS, new Point(0,2083300000), new Vector2d(0,0));
    private static final Body q22 = new Body(SUN_MASS, new Point(0,2383300000.0), new Vector2d(0,0));
    private static final Body q23 = new Body(SUN_MASS, new Point(108200000,2683300000.0), new Vector2d(0,0));
    private static final Body q24 = new Body(SUN_MASS, new Point(-108200000,2683300000.0), new Vector2d(0,0));
    private static final Body q25 = new Body(SUN_MASS, new Point(57910000.0,2683300000.0+57910000.0), new Vector2d(0,0));
    private static final Body q26 = new Body(SUN_MASS, new Point(-57910000.0,2683300000.0+57910000.0), new Vector2d(0,0));
    private static final Body q27 = new Body(SUN_MASS, new Point(57910000.0,2683300000.0-57910000.0), new Vector2d(0,0));
    private static final Body q28 = new Body(SUN_MASS, new Point(-57910000.0,2683300000.0-57910000.0), new Vector2d(0,0));
    
    public static final NBody WALTZ_SYSTEM =
    		new NBody()
    		.add(blackhole).add(w1).add(w2).add(w3).add(w4).add(w5).add(w6)
    		.add(w7).add(w8).add(w9).add(w10).add(w11).add(w12)
    		.add(w13).add(w14).add(w15)
    		.add(a1).add(a2).add(a3).add(a4).add(a5).add(a6)
    		.add(a7).add(a8).add(a9).add(a10).add(a11).add(a12)
    		.add(a13).add(a14)
    		.add(l1).add(l2).add(l3).add(l4).add(l5).add(l6)
    		.add(l7).add(l8).add(l9)
    		.add(t1).add(t2).add(t3).add(t4).add(t5).add(t6)
    		.add(t7).add(t8).add(t9).add(t10)
    		.add(z1).add(z2).add(z3).add(z4).add(z5).add(z6)
    		.add(z7).add(z8).add(z9).add(z10).add(z11).add(z12)
    		.add(z13).add(z14)
    		.add(q1).add(q2).add(q3).add(q4).add(q5).add(q6)
    		.add(q7).add(q8).add(q9).add(q10).add(q11).add(q12)
    		.add(q13).add(q14).add(q15).add(q16).add(q17).add(q18)
    		.add(q19).add(q20).add(q21).add(q22).add(q23).add(q24)
    		.add(q25).add(q26).add(q27).add(q28);
    
    /** A NBody simulation containing all of the planets and the sun. */
    public static final NBody SOLAR_SYSTEM =
            new NBody()
            .add(SUN)
            .add(MERCURY)
            .add(VENUS)
            .add(EARTH)
            .add(MARS)
            .add(JUPITER)
            .add(SATURN)
            .add(URANUS);

    /** A NBody simulation containing some of the planets and the sun. */
    public static final NBody PLANETS =
            new NBody()
            .add(SUN)
            .add(MARS)
            .add(JUPITER)
            .add(SATURN)
            .add(URANUS);
    
    private static final int NUM_GAUSSIAN_ITERS = 10;
    /**
     * @return a random number from a Gaussian distribution centered at d.
     */
    private static double sampleGaussian(double d) {
        double k = d / NUM_GAUSSIAN_ITERS;
        double acc = 0.0;
        for (int i = 0; i < NUM_GAUSSIAN_ITERS; i++) {
            acc += ThreadLocalRandom.current().nextDouble(k);
        }
        return acc - d / 2;
    }

    /**
     * @return the velocity needed to put mass m2 into a circular orbit around
     *         m1 at radius r.
     */
    private static double calculateOrbitalVelocity(double m1, double m2, double r) {
        return Math.sqrt(m2 * m2 * Physics.G / ((m1 + m2) * r));
    }

    /**
     * @return the tangent vector to a circle centered at p.
     */
    private static Vector2d calculateTangentVector(double x, double y) {
        double theta = Math.atan2(x, y);
        double vx = 0 - Math.cos(theta);
        double vy = Math.sin(theta);
        return new Vector2d(vx, vy);
    }
    
    private static List<Body> makeLots(double starMass, int n) {
        List<Body> bodies = new LinkedList<>();
        bodies.add(new Body(starMass, new Point(0, 0), new Vector2d(0, 0)));
        for (int i = 0; i < n; i++) {
            double dist = DISTANCE * 2;
            double mass = ThreadLocalRandom.current().nextDouble(1000.0) * 1e13;
            double x = sampleGaussian(dist);
            double y = sampleGaussian(dist);
            Vector2d d = new Vector2d(x, y);
            double r = d.magnitude();
            Vector2d v = calculateTangentVector(d.getX(), d.getY());
            double vel = calculateOrbitalVelocity(mass, starMass, r);
            bodies.add(new Body(mass, new Point(x, y), v.scale(vel)));          
        }
        return bodies;
    }
    
    private static void displaceBodies(List<Body> bodies, Vector2d v) {
        for (Body b : bodies) {
            b.displace(v);
        }
    }
    
    private static void addVelocity(List<Body> bodies, Vector2d v) {
        for (Body b : bodies) {
            b.addToVelocity(v);
        }
    }
    
    private static List<Body> createCollisionSystem(int numSunBodies, int numStarBodies) {
        double starMass = SUN_MASS * 0.1;
        List<Body> solar1 = makeLots(SUN_MASS, numSunBodies);
        List<Body> solar2 = makeLots(starMass, numStarBodies);
        Vector2d disp1 = new Vector2d(DISTANCE / 4.0, 0.0);
        Vector2d disp2 = new Vector2d(0.0 - (DISTANCE / 4), 0.0 - (DISTANCE / 4));
        Vector2d diff = disp1.difference(disp2);
        Vector2d v2 = calculateTangentVector(diff.getX(), diff.getY()).scale(
                calculateOrbitalVelocity(starMass, SUN_MASS, diff.magnitude()) * 0.9);
        displaceBodies(solar1, disp1);
        displaceBodies(solar2, disp2);
        addVelocity(solar2, v2);
        List<Body> bodies = new LinkedList<>();
        bodies.addAll(solar1);
        bodies.addAll(solar2);
        return bodies;
    }
    
    private static final int NUM_SUN_BODIES = 1000;
    private static final int NUM_STAR_BODIES = 300;
    
    /**
     * A NBody simulation containing many randomly generated bodies around
     * two colliding suns.
     */
    public static final NBody COLLISION = 
            new NBody(createCollisionSystem(NUM_SUN_BODIES, NUM_STAR_BODIES));
}
