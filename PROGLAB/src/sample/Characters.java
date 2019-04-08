//CHARACTERS CLASS
package sample;

import java.math.*;

public class Characters {
    private String name;
    private String goodevil;
    public int x;
    public int y;

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void setName(String name) { this.name = name; }

    public void setGoodevil(String goodevil) { this.goodevil = goodevil; }

    public int getX() { return x; }

    public int getY() { return y; }

    public String getName() { return name; }

    public String getGoodevil() { return goodevil; }

    public class MasterYoda extends Characters
    {
        private int health;

        public void setHealth(int health) {this.health = health; }

        public int getHealth() { return health; }
    }
    public class LukeSkywalker extends Characters
    {
        private int health;

        public void setHealth(int health) { this.health = health; }

        public int getHealth() {return health; }
    }
    public class DarthVader extends Characters
    {
        public double shortestWay(double playerX , double playerY)
        {
            double[] matrix = new double[4];
            double result= 0;
            matrix[0] = Math.sqrt(Math.pow(playerX-DarthVader.super.x-1,2)+Math.pow(playerY-DarthVader.super.y,2));
            matrix[1] = Math.sqrt(Math.pow(playerX-DarthVader.super.x+1,2)+Math.pow(playerY-DarthVader.super.y,2));
            matrix[2] = Math.sqrt(Math.pow(playerX-DarthVader.super.x,2)+Math.pow(playerY-DarthVader.super.y-1,2));
            matrix[3] = Math.sqrt(Math.pow(playerX-DarthVader.super.x,2)+Math.pow(playerY-DarthVader.super.y+1,2));
            result = matrix[0];

            if(result>matrix[1])
            {
                result = matrix[1];
            }
            else if(result>matrix[2])
            {
                result = matrix[2];
            }
            else if(result>matrix[3])
            {
                result = matrix[3];
            }
            if (result == matrix[0]) return 8;
            if (result == matrix[1]) return 2;
            if (result == matrix[2]) return 4;
            if (result == matrix[3]) return 6;
            return 0;

        }

    }
    public class KyloRen extends  Characters
    {

    }
    public class Stormtrooper extends Characters
    {
        public double shortestWay(double playerX , double playerY, int Checker)
        {
            double[] matrix = new double[4];
            double result= 0;
            if(Checker != 8)
            {
                matrix[0] = Math.sqrt(Math.pow(playerX-Stormtrooper.super.x-1,2)+Math.pow(playerY-Stormtrooper.super.y,2));
                result = matrix[0];
            }
            if(Checker != 2)
            {
                matrix[1] = Math.sqrt(Math.pow(playerX-Stormtrooper.super.x+1,2)+Math.pow(playerY-Stormtrooper.super.y,2));
                result = matrix[1];
            }
            if(Checker != 4)
            {
                matrix[2] = Math.sqrt(Math.pow(playerX-Stormtrooper.super.x,2)+Math.pow(playerY-Stormtrooper.super.y-1,2));
                result = matrix[2];
            }
            if(Checker != 6)
            {
                matrix[3] = Math.sqrt(Math.pow(playerX-Stormtrooper.super.x,2)+Math.pow(playerY-Stormtrooper.super.y+1,2));
                result = matrix[3];
            }

            if(result>matrix[1])
            {
                result = matrix[1];
            }
            else if(result>matrix[2])
            {
                result = matrix[2];
            }
            else if(result>matrix[3])
            {
                result = matrix[3];
            }
            if (result == matrix[0]) return 8;
            if (result == matrix[1]) return 2;
            if (result == matrix[2]) return 4;
            if (result == matrix[3]) return 6;
            return 0;

        }
    }

}
//END OF CHARACTERS CLASS