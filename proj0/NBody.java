public class NBody {
    static public double readRadius(String filename) {
        double radius = 0;
        In in = new In(filename);

        in.readInt();
        radius = in.readDouble();

        return radius;
    }

    static public Planet[] readPlanets (String filename) {
        In in = new In(filename);
        int num = in.readInt();
        Planet[] planets = new Planet[num];

        in.readDouble();

        for (int i = 0; i < num; i += 1) {
            double[] stats = new double[5];
            for (int j = 0; j < 5; j += 1) {
                stats[j] = in.readDouble();
            }
            planets[i] = new Planet(stats[0], stats[1], stats[2], stats[3], stats[4], in.readString());
        }
        return planets;
    }

    static public void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        int num = planets.length;

        StdDraw.setScale(0 - radius, 1 + radius);
        StdDraw.enableDoubleBuffering();

        for (double time = 0; time < T; time += dt) {
            StdDraw.picture(0.5, 0.5, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();

            StdDraw.pause(10);

            double[] xForces = new double[num];
            double[] yForces = new double[num];

            for (int i = 0; i < num; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < num; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
        }

        StdOut.printf("%d\n", num);
        StdOut.printf("%.2e\n", radius);
        for (Planet planet : planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet.xxPos, planet.yyPos, planet.xxVel,
                    planet.yyVel, planet.mass, planet.imgFileName);
        }
    }
}
