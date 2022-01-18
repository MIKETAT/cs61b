public class NBody {
	/** read the body's radius */
	public static double readRadius( String str ) {
		In in = new In(str);
		int nOfBodys = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/** read the bodys */
	public static Planet[] readPlanets( String str ) {
		In in = new In(str);
		int nOfBodys = in.readInt();
		double radius = in.readDouble();
		double xxPos,yyPos,xxVel,yyVel,mass;
		String imgFileName;
		Planet[] allbodys = new Planet[nOfBodys];
		for(int i=0;i<nOfBodys;i++){
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			allbodys[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return allbodys;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] allbodys = readPlanets(filename);
		int nOfBodys = allbodys.length;	/** number of plantes */


		/** enable doublebuffering */
		StdDraw.enableDoubleBuffering();

		/** Drawing background */
		StdDraw.setScale(-radius,radius);
		String background = "images/starfield.jpg";
		StdDraw.picture(0,0,background);
		StdDraw.show();

		/** Drawing bodies */
		for( Planet b : allbodys) {
			b.draw();
		}

		double time = 0;
		/** loop */
		while(time < T) {
			double[] xForces = new double[nOfBodys];
			double[] yForces = new double[nOfBodys];
			for (int i = 0;i < nOfBodys; i++) {
				/** calc net force    */
				xForces[i] = allbodys[i].calcNetForceExertedByX(allbodys);
				yForces[i] = allbodys[i].calcNetForceExertedByY(allbodys);
				allbodys[i].update(dt,xForces[i],yForces[i]);	/** update */
			}
			StdDraw.clear();
			StdDraw.picture(0,0,background);
			for (int j = 0;j < nOfBodys; j++){
				allbodys[j].draw();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;
		}

		/** print out info */
		StdOut.printf("%d\n",allbodys.length);
		StdOut.printf("%.2e\n",radius);
		for (int i = 0; i < allbodys.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				allbodys[i].xxPos,allbodys[i].yyPos,
				allbodys[i].xxVel,allbodys[i].yyVel,
				allbodys[i].mass,allbodys[i].imgFileName);
		}
	}

}