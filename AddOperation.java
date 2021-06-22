import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddOperation {

	public void create(Scanner in) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL and java connecting driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listtable", "root", "Root"); // connecting
																													// to
			String name = in.next(); // take input
			String list = in.next(); // take input
			System.out.println(name); // print the database
			System.out.println(list);

			Statement stmt = con.createStatement(); // handler to execute query
			String q = "insert into todolist(PersonsName, Addlist) values('" + name + "', + '" + list + "');"; // insert
																												// into
			// database

			stmt.executeUpdate(q); // execute the query

			con.close(); // connection close
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void retrieve() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL and java connecting driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listtable", "root", "Root"); // connecting
																													// //
																													// the
																													// database
			Statement stmt = con.createStatement(); // handler to execute query
			ResultSet rs = stmt.executeQuery("select * from todolist;"); // execute query
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			con.close(); // connection close
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void update(Scanner in) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL and java connecting driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listtable", "root", "Root"); // connecting
																													// to
			String name = in.next(); // take input
			System.out.println(name); // print // the
										// database
			String list = in.next();
			System.out.println(list);

			String name2 = in.next(); // take input
			System.out.println(name2); // print // the
										// database
			String list2 = in.next();
			System.out.println(list2);

			Statement stmt = con.createStatement(); // handler to execute query
			String q = "update todolist set PersonsName = '" + name2 + "', Addlist = '" + list2
					+ "' where PersonsName = '" + name + "' and Addlist = '" + list + "';"; // update into database

			stmt.executeUpdate(q); // execute the query

			con.close(); // connection close
		} catch (Exception e) {
			System.out.println(e);
		}

		// int i = in.nextInt();
		// System.out.println(names.get(i));
		// String name = in.next();
		// names.set(i, name);
	}

	public void delete(Scanner in) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL and java connecting driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listtable", "root", "Root"); // connecting
																													// to
			String name = in.next(); // take input
			System.out.println(name); // print // the
										// database
			String list = in.next();
			System.out.println(list);
			Statement stmt = con.createStatement(); // handler to execute query
			String q = "delete from todolist where PersonsName = '" + name + "' and Addlist = '" + list + "';"; // insert
																												// into
			// database

			stmt.executeUpdate(q); // execute the query

			con.close(); // connection close
		} catch (Exception e) {
			System.out.println(e);
		}

		// int i = in.nextInt();
		// System.out.println(names.get(i));
		// names.remove(i);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String names[] = new String[10];
		List<String> names = new ArrayList<String>();

		Scanner in = new Scanner(System.in);
		AddOperation crud = new AddOperation();

		while (true) {

			System.out.println("Enter 1 to add\nEnter 2 to list\nEnter 3 to update\nEnter 4 to delete ");

			int n = in.nextInt();
			System.out.println(n);

			if (n == 1) {

				crud.create(in); // calling create method

			}

			else if (n == 2) {

				crud.retrieve();
			}

			else if (n == 3) {

				crud.update(in);

			}

			else if (n == 4) {

				crud.delete(in);

			}

		}
	}

}
