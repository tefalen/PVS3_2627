package student.oop;

public class Points {
    class Point{
        String name;
        double x, y,z;
        final double DEAFAULT_Z = 0;
        static int PointsCreated = 1;


        public Point(String name, double x, double y, double z) {
            this(name, x, y);
            this.z = z;
        }

        public Point(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
            z = DEAFAULT_Z;
        }



        public Point(double x, double y, double z) {
            name = "point " + PointsCreated;
            this.x = x;
            this.y = y;
            this.z = z;
            Point.PointsCreated ++;

        }


    }
}
