package devmaster.edu.vn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/UserAccount")
public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;

	public UserAccount() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");

		out.println("<body style='text-align:center'>");
		out.println("<h1> DEMO tra cứu bằng Servlet </h1>");
		out.println("<form action='SearchAccount'method='post'>");

		out.println("<p> Input phone: ");
		out.println("<input type=text name='phone'/>");
		out.println("<p> <input type='submit' value='Search'/>");

		out.println("</form>");
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-PIJT6KA\\SQLEXPRESS:1433;databaseName=demoSQL;integratedSecurity=true";
			out.print("đã chạy vào đây");
//			String userName = "sa";
//			String password = "An0327762985";
//			out.print("đã chạy vào đây1");
			String userName="sa";
			String password="An0327762985";
			Connection connection = DriverManager.getConnection(url,userName,password);
			out.print("đã chạy vào đây2");
			String sql = "Select * from USER_ACCOUNT ";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			/*
			 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); String sql =
			 * "Select * from USER_ACCOUNT "; Connection conn =
			 * ConnectionUtils.getMSSQLConnection(); Statement stmt =
			 * conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);
			 */
			/*
			 * String sql = "Select * from USER_ACCOUNT ";
			 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); Connection
			 * conn = DriverManager.getConnection(
			 * "jdbc:sqlserver://localhost:1433;databaseName=demoSQL;user=sa;password=An0327762985"
			 * ); Statement stmt = conn.createStatement(); ResultSet rs
			 * =stmt.executeQuery(sql);
			 */
			System.out.println("<h2> Danh sách </h2>");
			System.out.println("<table border=1 align='center'style='width:50%'>");
			System.out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");

			if (rs != null) {
				while (rs.next()) {

					out.println("<tr>");
					out.println("<td>" +

							rs.getString("CusUser") + "</td>");

					out.println("<td>" +

							rs.getString("CusName") + "</td>");

					out.println("<td>" + rs.getString("CusPhone") + "</td>");

					out.println("</tr>");
				}
			}
			rs.close();
			out.println("</table>");
		} catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + " </h1>");
			out.println("<p>" + ex.toString() + " </p>");
			System.out.println("lỗi");
		}
		out.println("</body>");
		out.println("</html>");
	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

}
