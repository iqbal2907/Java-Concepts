package Exam1;

import java.util.ArrayList;
import java.util.List;

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

		System.out.println("Input in matrix : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
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
				int valueUp = matrix[i][j].value;
				int valueDown = matrix[i][j].value;
				List<Address> pathUp = new ArrayList<Address>();
				pathUp.add(new Address(i, j));
				List<Address> pathDown = new ArrayList<Address>();
				pathDown.add(new Address(i, j));
				int telePathvalueUp = 0;
				int telePathvalueDown = 0;
				List<Address> telePathpathUp = new ArrayList<Address>();
				pathUp.add(new Address(i, j));
				List<Address> telePathpathDown = new ArrayList<Address>();
				pathDown.add(new Address(i, j));
				Up(i, j, valueUp, pathUp, telePathvalueUp, telePathpathUp);
				Down(i, j, valueDown, pathDown, telePathvalueDown,
						telePathpathDown);
				if (valueUp > valueDown) {
					matrix[i][j].totalValue = valueUp;
					matrix[i][j].path = pathUp;
				} else if (valueUp == valueDown) {
					if (valueUp == matrix[i][j].totalValue && j != jDimen - 1) {
						// we will reach here if there is no way to reach
						// end
						// traversing this node
						matrix[i][j].totalValue = -1;
					} else {
						matrix[i][j].totalValue = valueDown;
						matrix[i][j].path = pathDown;
					}
				} else {
					matrix[i][j].totalValue = valueDown;
					matrix[i][j].path = pathDown;
				}
				if (telePathvalueUp > telePathvalueDown) {
					matrix[i][j].totalTelepathValue = telePathvalueUp;
					matrix[i][j].telepathPath = telePathpathUp;
				} else if (telePathvalueUp == telePathvalueDown) {
					if (telePathvalueUp == matrix[i][j].totalTelepathValue
							&& j != jDimen - 1) {
						// we will reach here if there is no way to reach
						// end
						// traversing this node
						matrix[i][j].totalTelepathValue = -1;
					} else {
						matrix[i][j].totalTelepathValue = telePathvalueDown;
						matrix[i][j].telepathPath = telePathpathDown;
					}
				} else {
					matrix[i][j].totalTelepathValue = telePathvalueDown;
					matrix[i][j].telepathPath = telePathpathDown;
				}
			}
		}
	}

	private void Up(int i, int j, int value, List<Address> path, int televalue,
			List<Address> telepath) {
		int ii = i;
		int localValue = 0;
		List<Address> localPath = new ArrayList<Address>();
		boolean traverse = true;
		boolean tele = false;

		while (traverse) {
			localValue += matrix[ii][j].value;
			localPath.add(new Address(ii, j));
			// Check are we on last column

			if (j != jDimen - 1) {
				if (matrix[ii][j + 1].totalValue != -1) {
					if (tele) {
						int max = maximum(localValue
								+ matrix[ii][j + 1].totalValue, localValue
								+ matrix[ii][j + 1].totalTelepathValue);
						if (televalue < max) {
							televalue = max;
							telepath = new ArrayList<Address>(localPath);
							telepath.add(new Address(ii, j + 1));
						}
					} else {
						if (value < localValue + matrix[ii][j + 1].totalValue) {
							value = localValue + matrix[ii][j + 1].totalValue;
							path = new ArrayList<Address>(localPath);
							path.add(new Address(ii, j + 1));
						}
						if (televalue < matrix[ii][j + 1].totalTelepathValue) {
							televalue = matrix[ii][j + 1].totalTelepathValue;
							telepath = new ArrayList<Address>(localPath);
							telepath.add(new Address(ii, j + 1));
						}
					}
				}
			} else {
				if (tele) {
					if (televalue < localValue) {
						televalue = localValue;
						telepath = new ArrayList<Address>(localPath);
					}
				} else {
					value = localValue;
					path = new ArrayList<Address>(localPath);
					telepath = new ArrayList<Address>(localPath);
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

	private void Down(int i, int j, int value, List<Address> path,
			int televalue, List<Address> telepath) {

		int ii = i;
		int localValue = 0;
		List<Address> localPath = new ArrayList<Address>();
		boolean traverse = true;
		boolean tele = false;

		while (traverse) {
			localValue += matrix[ii][j].value;
			localPath.add(new Address(ii, j));
			// Check are we on last column
			if (j != jDimen - 1) {
				if (matrix[ii][j + 1].totalValue != -1) {
					if (tele) {
						int max = maximum(localValue
								+ matrix[ii][j + 1].totalValue, localValue
								+ matrix[ii][j + 1].totalTelepathValue);
						if (televalue < max) {
							televalue = max;
							telepath = new ArrayList<Address>(localPath);
							telepath.add(new Address(ii, j + 1));
						}
					} else {
						if (value < localValue + matrix[ii][j + 1].totalValue) {
							value = localValue + matrix[ii][j + 1].totalValue;
							path = new ArrayList<Address>(localPath);
							path.add(new Address(ii, j + 1));
						}
						if (televalue < matrix[ii][j + 1].totalTelepathValue) {
							televalue = matrix[ii][j + 1].totalTelepathValue;
							telepath = new ArrayList<Address>(localPath);
							telepath.add(new Address(ii, j + 1));
						}
					}
				}
			} else {
				if (tele) {
					if (televalue < localValue) {
						televalue = localValue;
						telepath = new ArrayList<Address>(localPath);
					}
				} else {
					value = localValue;
					path = new ArrayList<Address>(localPath);
					telepath = new ArrayList<Address>(localPath);
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

		int value = matrix[0][0].totalValue;
		int locationi = 0;
		for (int i = 1; i < iDimen; i++) {
			if (value < matrix[i][0].totalValue) {
				value = matrix[i][0].totalValue;
				locationi = i;
			}
		}

		System.out.println("Maximum value: " + matrix[locationi][0].totalValue);
		// Now print path
		int count = 0;
		Address nextNode = new Address(locationi, 0);
		while (count <= 1) {
			List<Address> path = matrix[nextNode.i][nextNode.j].path;
			int totalnumber = path.size();

			for (int ii = 0; ii < totalnumber - 1; ii++) {
				System.out.println("( " + path.get(ii).i + ", "
						+ path.get(ii).j + " )");
			}
			
			nextNode = path.get(totalnumber - 1);
			if (nextNode.j == jDimen - 1)
				count++;
		}

		System.out.println("( " + nextNode.i + ", " + nextNode.j + " )");

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

class NodeInfo {

	public int value;
	public int totalValue;
	public int totalTelepathValue;
	public List<Address> telepathPath;
	public List<Address> path;

	public NodeInfo(int v, int t) {
		value = v;
		totalValue = t;
		totalTelepathValue = t;
		path = new ArrayList<Address>();
		telepathPath = new ArrayList<Address>();
	}
}
