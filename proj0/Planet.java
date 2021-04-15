import java.lang.Math;

public class Planet {
    static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet (double xP, double yP, double xV,
                   double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet (Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);

        return (G * this.mass * p.mass) / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double force = this.calcForceExertedBy(p);

        return force * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double force = this.calcForceExertedBy(p);

        return force * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] all_p) {
        double netForceX = 0;
        for (Planet p : all_p) {
            if (this.calcDistance(p) != 0) {
                netForceX += this.calcForceExertedByX(p);
            }
        }

        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] all_p) {
        double netForceY = 0;
        for (Planet p : all_p) {
            if (this.calcDistance(p) != 0) {
                netForceY += this.calcForceExertedByY(p);
            }
        }

        return netForceY;
    }

    public void update(double dt, double xForce, double yForce) {
        double xAcel = xForce / this.mass;
        double yAcel = yForce / this.mass;

        this.xxVel += xAcel * dt;
        this.yyVel += yAcel * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }



}
