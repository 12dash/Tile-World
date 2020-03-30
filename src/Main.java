import Environment.*;
import Helper.SaveCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import Agent.*;
import Iterations.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Maze m = SetMaze.setUp();
		Policy p = new Policy(m);
		Maze m1 = SetMaze.setUp();
		List<String> s = new ArrayList<>();
		double thresh = 0.000001;
		int max_util = 2;
		double number_iterations = ValueIteration.run_value_iteration(0.99, m, thresh, p, s, max_util,m1);
		number_iterations--;
		p.set_policy(m);
		SaveCSV.save_csv(s, m, (int) (number_iterations), "Value_Iteration_test.csv");
		display(m, p, (int) number_iterations, 0.99, thresh, max_util);

		m = SetMaze.setUp();
		m1 = SetMaze.setUp();
		p = new Policy(m);

		s = new ArrayList<>();

		number_iterations = PolicyIteration.policyIterations(m, p, 0.99, s, max_util,m1);
		SaveCSV.save_csv(s, m, (int) (number_iterations), "Policy_Iteration_test.csv");
		display(m, p, (int) number_iterations, 0.99, 0, max_util);

	}

	private static void display(Maze m, Policy p, int i, double gamma, double thresh, double max_util) {
		if ((thresh != 0)) {

			System.out.println("\tValue Iteration\n");

			System.out.println("Discount factor : \t" + gamma);
			System.out.println("Number of iterations:\t" + i);
			System.out.println("Threshold :\t\t" + thresh);
			System.out.println("Max Utility : \t\t" + max_util + "\n");
			m.display_maze_symbolic();
			m.display_maze_utility();
			p.display_policy(m);

			System.out.println("\nUtility of the states : (Row,Col)");

			for (int j = 0; j < m.m; j++) {

				for (int k = 0; k < m.n; k++) {
					if (m.maze[j][k].getS() != SquareType.wall)
						System.out.println("(" + j + "," + k + "):\t" + m.maze[j][k].get_utility());
				}
			}
		} else {
			System.out.println("\n\tPolicy Iteration\n");

			System.out.println("Discount factor : \t" + gamma);
			System.out.println("Number of iterations:\t" + i);
			System.out.println("Threshold :\t\t" + thresh);
			System.out.println("Max Utility : \t\t" + max_util + "\n");
			m.display_maze_symbolic();
			m.display_maze_utility();
			p.display_policy(m);

			System.out.println("\nUtility of the states : (Row,Col)");

			for (int j = 0; j < m.m; j++) {
				for (int k = 0; k < m.n; k++) {
					if (m.maze[j][k].getS() != SquareType.wall)
						System.out.println("(" + j + "," + k + "):\t " + m.maze[j][k].get_utility());
				}
			}
		}

	}
}
