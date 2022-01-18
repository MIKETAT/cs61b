public class Planet {

	public double xxPos; /** Its current x position */
	public double yyPos; /** Its current y position */
	public double xxVel; /** Its current velocity in the x direction */
	public double yyVel; /** Its current velocity in the y direction */
	public double mass;	 /** Its mass */
	public String imgFileName;
	public static double G = 6.67e-11;	/** Ggravitational constant */


	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/** calc the distance between two bodies */
	public double calcDistance( Planet b) {
		double r2,distance;
		r2 = Math.pow(this.xxPos - b.xxPos,2) + Math.pow(this.yyPos - b.yyPos,2);
		distance = Math.sqrt(r2);
		return distance;
	}

	/** returns a double describing the force exerted on this body by the given body. */
	public double calcForceExertedBy( Planet b) {
		double force;
		force = this.mass * b.mass * G;
		force = force / (Math.pow(this.calcDistance(b),2));
		return force;
	}
	
	/** calcForceExertedByX */
	public double calcForceExertedByX( Planet b) {
		double force = calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		double r = this.calcDistance(b);
		double Fx = (force * dx) / r;
		return Fx;
	}

	/** calcForceExertedByY */
	public double calcForceExertedByY( Planet b) {
		double force = calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		double r = this.calcDistance(b);
		double Fy = (force * dy) / r;
		return Fy;
	}

	/** calcNetForceExertedByX */
	public double calcNetForceExertedByX( Planet[] allbodys) {
		double NetForceX = 0;
		double forceX;
		for (Planet b : allbodys ) {
			if(!this.equals(b)) {
			/** Bodys cannot exert gravitational forces on themselves! */
				forceX = this.calcForceExertedByX(b);
				NetForceX = NetForceX + forceX;
			}
		}
		return NetForceX;
	}

	public double calcNetForceExertedByY( Planet[] allbodys) {
		double NetForceY = 0;
		double forceY;
		for ( Planet b : allbodys) {
			if(!this.equals(b)) {
				forceY = this.calcForceExertedByY(b);
				NetForceY = NetForceY +forceY;
			}
		}
		return NetForceY;
	}

	/** determines how much the forces exerted on the body 
	 * will cause that body to accelerate,
	 * resulting change in the body’s velocity and position 
	 *	in a small period of time dt.
	 */ 
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;	/** net acceleration on X */
		double aY = fY / this.mass; /** net acceleration on Y */
		double newxxVel = this.xxVel + dt * aX;
		double newyyVel = this.yyVel + dt * aY;
		double newxxPos = this.xxPos + dt * newxxVel;
		double newyyPos = this.yyPos + dt * newyyVel;
		this.xxPos = newxxPos;
		this.yyPos = newyyPos;
		this.xxVel = newxxVel;
		this.yyVel = newyyVel;
	}

	/**  Draw */
	public void draw( ) {
		StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
		StdDraw.show();
	}
 





}