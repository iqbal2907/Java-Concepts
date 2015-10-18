package com.jp.year2015;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {

		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		if (rows > 500 || columns > 500) {
			throw new IllegalArgumentException();
		}

		int[][] arr = new int[rows][columns];
		for (int i = 2, j = 0, k = 0; i < args.length; i++) {
			if ((i - 2) % columns == 0 && (i - 2) != 0) {
				j++;
			}
			k = (i - 2) % columns;
			arr[j][k] = Integer.parseInt(args[i]);
		}

		NodeInfo[][] mat = new NodeInfo[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				mat[i][j] = new NodeInfo(arr[i][j], arr[i][j]);
			}
		}

		Game game = new Game();
		game.matrix = mat;
		game.iDimen = rows;
		game.jDimen = columns;

		game.TraverseMatrix();
		game.result();

	}
}

class Game {

	public NodeInfo[][] matrix;
	public int iDimen;
	public int jDimen;

	public void TraverseMatrix() {
		for (int j = jDimen - 1; j >= 0; j--) {
			for (int i = 0; i < iDimen; i++) {
				if (matrix[i][j].value == -1)
					continue;

				List<Address> pathUp = new ArrayList<Address>();
				pathUp.add(new Address(i, j));
				List<Address> telePathpathUp = new ArrayList<Address>();
				pathUp.add(new Address(i, j));

				List<Address> pathDown = new ArrayList<Address>();
				pathDown.add(new Address(i, j));
				List<Address> telePathpathDown = new ArrayList<Address>();
				pathDown.add(new Address(i, j));

				TotalValue totalValueUp = new TotalValue(0, 0, pathUp, telePathpathUp);
				TotalValue totalValueDown = new TotalValue(0, 0, pathDown, telePathpathDown);

				// from one point either we can go up or down or right.
				MoveUpOrDown(i, j, totalValueUp, true);
				MoveUpOrDown(i, j, totalValueDown, false);

				// update the matrix with maximum totalValue and totaltelepath
				// value
				if (totalValueUp.totalval > totalValueDown.totalval) {
					matrix[i][j].totalValue = totalValueUp.totalval;
					matrix[i][j].path = totalValueUp.path;
				} else if (totalValueUp.totalval == totalValueDown.totalval) {
					if (totalValueUp.totalval == matrix[i][j].totalValue && j != jDimen - 1 && matrix[i][j+1].totalValue ==-1) {
						matrix[i][j].totalValue = -1;
						matrix[i][j].path = null;
					} else {
						matrix[i][j].totalValue = totalValueDown.totalval;
						matrix[i][j].path = totalValueDown.path;
					}
				} else {
					matrix[i][j].totalValue = totalValueDown.totalval;
					matrix[i][j].path = totalValueDown.path;
				}

				if (totalValueUp.televal > totalValueDown.televal) {
					matrix[i][j].totalTelepathValue = totalValueUp.televal;
					matrix[i][j].telepath = totalValueUp.telepath;
				} else if (totalValueUp.televal == totalValueDown.televal) {
					if (totalValueUp.televal == matrix[i][j].totalTelepathValue && j != jDimen - 1) {
						matrix[i][j].totalTelepathValue = -1;
						matrix[i][j].telepath = null;
					} else {
						matrix[i][j].totalTelepathValue = totalValueDown.televal;
						matrix[i][j].telepath = totalValueDown.telepath;
					}
				} else {
					matrix[i][j].totalTelepathValue = totalValueDown.televal;
					matrix[i][j].telepath = totalValueDown.telepath;
				}
			}
		}
	}

	private void MoveUpOrDown(int i, int j, TotalValue totalvalue, boolean up) {
		int ii = i;
		int localValue = 0;
		ArrayList<Address> localPath = new ArrayList<Address>();
		boolean traverse = true;
		boolean tele = false;

		while (traverse) {
			localValue += matrix[ii][j].value;
			localPath.add(new Address(ii, j));

			// Check are we on last column
			if (j != jDimen - 1) {

				if (tele) {
					if (localValue + matrix[ii][j + 1].totalValue >= matrix[ii][j + 1].totalTelepathValue) {
						if (totalvalue.televal < localValue + matrix[ii][j + 1].totalValue) {
							totalvalue.televal = localValue + matrix[ii][j + 1].totalValue;
							totalvalue.telepath = new ArrayList<Address>(localPath);
							totalvalue.telepath.addAll(matrix[ii][j + 1].path);
						}
					} else {
						if (totalvalue.televal < matrix[ii][j + 1].totalTelepathValue) {
							totalvalue.televal = matrix[ii][j + 1].totalTelepathValue;
							totalvalue.telepath = new ArrayList<Address>(localPath);
							totalvalue.telepath.addAll(matrix[ii][j + 1].telepath);
						}
					}
				} else {
					if (totalvalue.totalval < localValue + matrix[ii][j + 1].totalValue) {
						totalvalue.totalval = localValue + matrix[ii][j + 1].totalValue;
						totalvalue.path = new ArrayList<Address>(localPath);
						totalvalue.path.addAll(matrix[ii][j + 1].path);

					}

					if (totalvalue.televal < matrix[ii][j + 1].totalTelepathValue) {
						totalvalue.televal = matrix[ii][j + 1].totalTelepathValue;
						totalvalue.telepath = new ArrayList<Address>(localPath);
						totalvalue.telepath.addAll(matrix[ii][j + 1].telepath);
					}
				}

			} else {
				if (tele) {
					totalvalue.televal = localValue;
					totalvalue.telepath = new ArrayList<Address>(localPath);
				} else {
					totalvalue.totalval = localValue;
					totalvalue.path = new ArrayList<Address>(localPath);
				}
			}
			if (up) {
				if (ii == 0) {
					ii = iDimen - 1;
					localValue = 0;
					tele = true;
				} else {
					ii--;
				}
			} else {
				if (ii == iDimen - 1) {
					ii = 0;
					localValue = 0;
					tele = true;
				} else {
					ii++;
				}
			}

			if (matrix[ii][j].value == -1 || ii == i) {
				traverse = false;
			}
		}
	}

	public void result() {

		int value = -1;
		int location = 0;
		boolean tele = false;

		for (int i = 0; i < iDimen; i++) {

			// Check for main value
			if (value < matrix[i][0].totalValue) {
				value = matrix[i][0].totalValue;
				location = i;
				tele = false;
			}

			// Check for telePath value
			if (value < matrix[i][0].totalTelepathValue) {
				value = matrix[i][0].totalTelepathValue;
				location = i;
				tele = true;
			}
		}

		System.out.println("Maximum Value : " + value);
		System.out.println();
		System.out.println("Path : ");

		List<Address> path = tele ? matrix[location][0].telepath : matrix[location][0].path;
		for (Address p : path) {
			System.out.print("( " + p.i + ", " + p.j + ") ");
		}

	}
}

class Address {

	public int i;
	public int j;

	public Address(int x, int y) {
		i = x;
		j = y;
	}
}

class TotalValue {
	public int totalval;
	public int televal;
	public List<Address> path;
	public List<Address> telepath;

	public TotalValue(int totalval, int televal, List<Address> path, List<Address> telepath) {
		this.totalval = totalval;
		this.televal = televal;
		this.telepath = new ArrayList<Address>();
		this.path = new ArrayList<Address>();
	}

}

class NodeInfo {

	public int value; // Value of the node ( 99999 > value > -1)
	public int totalValue; // total value from this node to end if we are using
							// not telepath
	public int totalTelepathValue; // total value from this node to end if we
									// are using telepath
	public List<Address> telepath;
	public List<Address> path;

	public NodeInfo(int v, int t) {
		value = v;
		totalValue = t;
		totalTelepathValue = t;
		this.telepath = new ArrayList<Address>();
		this.path = new ArrayList<Address>();
	}
}
