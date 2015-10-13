package Exam1;

public class Main {

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

				TotalValue totalValueUp = new TotalValue(matrix[i][j].value, 0);
				TotalValue totalValueDown = new TotalValue(matrix[i][j].value,
						0);

				// from one point either we can go up or down or right.
				Up(i, j, totalValueUp);
				Down(i, j, totalValueDown);

				// update the matrix with maximum totalValue and totaltelepath value
				if (totalValueUp.totalval > totalValueDown.totalval) {
					matrix[i][j].totalValue = totalValueUp.totalval;
				} else if (totalValueUp.totalval == totalValueDown.totalval) {
					if (totalValueUp.totalval == matrix[i][j].totalValue
							&& j != jDimen - 1) {
						// we will reach here if there is no way to reach
						// end
						// traversing this node
						matrix[i][j].totalValue = -1;
					} else {
						matrix[i][j].totalValue = totalValueDown.totalval;
					}
				} else {
					matrix[i][j].totalValue = totalValueDown.totalval;
				}

				if (totalValueUp.televal > totalValueDown.televal) {
					matrix[i][j].totalTelepathValue = totalValueUp.televal;
				} else if (totalValueUp.televal == totalValueDown.televal) {
					if (totalValueUp.televal == matrix[i][j].totalTelepathValue
							&& j != jDimen - 1) {
						// we will reach here if there is no way to reach
						// end
						// traversing this node
						matrix[i][j].totalTelepathValue = -1;
					} else {
						matrix[i][j].totalTelepathValue = totalValueDown.televal;
					}
				} else {
					matrix[i][j].totalTelepathValue = totalValueDown.televal;
				}
			}
		}
	}

	private void Up(int i, int j, TotalValue totalvalue) {
		int ii = i;
		int localValue = 0;
		boolean traverse = true;
		boolean tele = false;

		while (traverse) {
			localValue += matrix[ii][j].value;

			// Check are we on last column
			if (j != jDimen - 1) {
				
				if (matrix[ii][j + 1].totalValue != -1) {
					if (tele) {
						int max = maximum(localValue
								+ matrix[ii][j + 1].totalValue,
								matrix[ii][j + 1].totalTelepathValue);
						if (totalvalue.televal < max) {
							totalvalue.televal = max;
						}
					} else {
						if (totalvalue.totalval < localValue
								+ matrix[ii][j + 1].totalValue) {
							totalvalue.totalval = localValue
									+ matrix[ii][j + 1].totalValue;
						}
						if (totalvalue.televal < matrix[ii][j + 1].totalTelepathValue) {
							totalvalue.televal = matrix[ii][j + 1].totalTelepathValue;
						}
					}
				}
			} else {
				if (tele) {
					if (totalvalue.televal < localValue) {
						totalvalue.televal = localValue;
					}
				} else {
					totalvalue.totalval = localValue;
				}
			}
			// Check if we are on top, if yes
			if (ii == 0) {
				ii = iDimen - 1;
				localValue = 0;
				tele = true;
			} else {
				ii--;
			}
			if (matrix[ii][j].value == -1 || ii == i) {
				traverse = false;
			}
		}
	}

	private int maximum(int v1, int v2) {
		if (v1 > v2) {
			return v1;
		}
		return v2;
	}

	private void Down(int i, int j, TotalValue totalvalue) {

		int ii = i;
		int localValue = 0;
		boolean traverse = true;
		boolean tele = false;

		while (traverse) {
			localValue += matrix[ii][j].value;

			// Check are we on last column
			if (j != jDimen - 1) {
				if (matrix[ii][j + 1].totalValue != -1) {
					if (tele) {
						int max = maximum(localValue
								+ matrix[ii][j + 1].totalValue, localValue
								+ matrix[ii][j + 1].totalTelepathValue);
						if (totalvalue.televal < max) {
							totalvalue.televal = max;
						}
					} else {
						if (totalvalue.totalval < localValue
								+ matrix[ii][j + 1].totalValue) {
							totalvalue.totalval = localValue
									+ matrix[ii][j + 1].totalValue;
						}
						if (totalvalue.televal < matrix[ii][j + 1].totalTelepathValue) {
							totalvalue.televal = matrix[ii][j + 1].totalTelepathValue;
						}
					}
				}
			} else {
				if (tele) {
					if (totalvalue.televal < localValue) {
						totalvalue.televal = localValue;
					}
				} else {
					totalvalue.totalval = localValue;
				}
			}
			// Check if we are on top, if yes
			if (ii == iDimen - 1) {
				ii = 0;
				localValue = 0;
				tele = true;
			} else {
				ii++;
			}

			if (matrix[ii][j].value == -1 || ii == i) {
				traverse = false;
			}
		}
	}

	public void result() {

		int value = -1;

		for (int i = 0; i < iDimen; i++) {
			
			// Check for main value
			if (value < matrix[i][0].totalValue) {
				value = matrix[i][0].totalValue;
			}

			// Check for telePath value
			if (value < matrix[i][0].totalTelepathValue) {
				value = matrix[i][0].totalTelepathValue;
			}
		}

		System.out.println(value);

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

	public TotalValue(int t1, int t2) {
		totalval = t1;
		televal = t2;
	}

}

class NodeInfo {

	public int value;        // Value of the node ( 99999 > value > -1)
	public int totalValue;       // total value from this node to end if we are using not telepath
	public int totalTelepathValue;  // total value from this node to end if we are using telepath

	public NodeInfo(int v, int t) {
		value = v;
		totalValue = t;
		totalTelepathValue = t;
	}
}
