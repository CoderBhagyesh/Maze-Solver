package maze_solver_project;

import java.util.List;

public class DepthFirst {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
        if(maze[y][x]==9) { // we got to destination point
            path.add(x);
            path.add(y);
            return true;
        }

        if(maze[y][x]==0) { // we can move forward
            maze[y][x] = 2; // mark this cell as visited
            // try to go for all four directions and see if there exist a path
            if(searchPath(maze, x-1, y, path)){ // go to the left and check
                path.add(x);
                path.add(y);
                 return true;
            }

            if(searchPath(maze, x+1, y, path)) { // go to the right and check
                path.add(x);
                path.add(y);
                return true;
            }

            if(searchPath(maze, x, y+1, path)) { // go downwards
                path.add(x);
                path.add(y);
                return true;
            }

            if(searchPath(maze, x, y-1, path)) { // go upwards
                path.add(x);
                path.add(y);
                return true;
            }
        }

        return false;
    }
}
