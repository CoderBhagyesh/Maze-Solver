package maze_solver_project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame {
    private int [][] maze=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
    public List<Integer> path = new ArrayList<Integer>();
    AppFrame() {
        this.setTitle("Maze Solver");
        this.setSize(640,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1,1, path);
        System.out.println(path);
    }

    // we need to set colour to the 2d grid and for that we need to use the Graphic calss which will fill the color in the grid

    public void paint(Graphics g) {
        g.translate(80, 80);
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1: color = Color.black; break;
                    case 9: color = Color.red; break;
                    default: color = Color.white;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }

        // draw the path form which we get to the dest point from src point
        for(int i = 0; i < path.size(); i+=2) { // we done i+=2 so that in every iteration we get x cord, because we have pushed like path.add(x), path.add(y)
            int pathX = path.get(i);
            int pathY = path.get(i+1);

            g.setColor(Color.green);
            g.fillRect(30*pathX, 30*pathY, 20, 20);
        }
    }

    public static void main(String args[]) {
        AppFrame frame = new AppFrame();
        frame.setVisible(true);
    }
}
