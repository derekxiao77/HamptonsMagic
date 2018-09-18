import java.sql.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class TestConnection {

  static Connection con = null;
  static int personID = -1;

  // used for logging output, see catalina.out for log files
  // private static final Logger logger = LogManager.getLogger("match");

  public static String addStudent(String first_name, String last_name, String first_major, double gpa) {
    con = getConnection();

    // connection doesn't work
    if (con == null) {
      return "bad connection";
    }

    try	{
      // Get ID
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select count(*) as id from student");
      if (rs.next()) {
        personID = rs.getInt("id");
      }

      String updateString = "insert into student (student_id, first_name, last_name, first_major," +
                            "gpa) values (?,?,?,?,?)";
      PreparedStatement updatePerson = con.prepareStatement(updateString);
      updatePerson.setInt(1, personID);
      updatePerson.setString(2, first_name);
      updatePerson.setString(3, last_name);
      updatePerson.setString(4, first_major);
      updatePerson.setDouble(5, gpa);
      updatePerson.executeUpdate();

    } catch (SQLException e) {
      return e.toString();
    }
    return "good run";
  }

  public static boolean addStudent(String first_name, String last_name, String first_major, String second_major, double gpa) {
    con = getConnection();

    // connection doesn't work
    if (con == null) {
      return false;
    }

    try	{
      // Get ID
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select count(*) as id from student");
      if (rs.next()) {
        personID = rs.getInt("id");
      }

			String updateString = "insert into student (student_id, first_name, last_name, first_major," +
														"second_major, gpa) values (?,?,?,?,?,?,?)";
			PreparedStatement updatePerson = con.prepareStatement(updateString);
      updatePerson.setInt(1, personID);
			updatePerson.setString(2, first_name);
			updatePerson.setString(3, last_name);
			updatePerson.setString(4, first_major);
			updatePerson.setString(5, second_major);
			updatePerson.setDouble(6, gpa);
			updatePerson.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
    return true;
  }

  public static boolean addStudent(String first_name, String last_name, String first_major, String second_major,
                           String third_major, double gpa) {
    con = getConnection();

    // connection doesn't work
    if (con == null) {
      return false;
    }

    try	{
      // Get ID
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select count(*) as id from student");
      if (rs.next()) {
        personID = rs.getInt("id");
      }

			String updateString = "insert into student (student_id, first_name, last_name, first_major," +
														"second_major, third_major, gpa) values (?,?,?,?,?,?,?,?)";
			PreparedStatement updatePerson = con.prepareStatement(updateString);
      updatePerson.setInt(1, personID);
			updatePerson.setString(2, first_name);
			updatePerson.setString(3, last_name);
			updatePerson.setString(4, first_major);
			updatePerson.setString(5, second_major);
			updatePerson.setString(6, third_major);
			updatePerson.setDouble(7, gpa);
			updatePerson.executeUpdate();

		} catch (SQLException e) {
			return false;
		}
    return true;
  }

  private static Connection getConnection() {
    // Return existing connection after first call
    if (con != null) {
      return con;
    }
    //logger.trace("Getting database connection...");
    // Attempt to connect to a local postgres server
    if (con == null) {
      con = getLocalConnection();
    }
    // If that fails, give up
    if (con == null) {
      return null;
    }
    // Attempt to initialize the database on first connection
    //initDatabase();
    return con;
  }

  // Working
  /*public static boolean testConn() {
    Connection con = null;
    try {
      Class.forName("org.postgresql.Driver");
      con = DriverManager.getConnection("jdbc:postgresql:user-data");
    }
    catch (ClassNotFoundException e) {System.out.println(e.toString());}
    catch (SQLException e) {System.out.println(e.toString());}
    if (con == null) {
      return false;
    }
    return true;
  }*/

  private static Connection getLocalConnection() {
    try {
      Class.forName("org.postgresql.Driver");
      Connection con = DriverManager.getConnection(
            // set 'user-data' to the name of the database
            "jdbc:postgresql://localhost/user-data");
      return con;
    }
  catch (ClassNotFoundException e) { /*logger.warn(e.toString());*/}
  catch (SQLException e) { /*logger.warn(e.toString());*/}
    return null;
  }

  public static void main(String[] args) {
    System.out.println(addStudent("Alli","Buller","CS",3.85));
  }

}
