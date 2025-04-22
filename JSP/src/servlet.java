import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ebookshop");

            out.println("<html>");
            out.println("<head><title>Books</title></head>");
            out.println("<body>");
            out.println("<h1>Books</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("book_id") + "</td><td>" +
                        rs.getString("book_title") + "</td><td>" +
                        rs.getString("book_author") + "</td><td>" +
                        rs.getInt("book_price") + "</td><td>" +
                        rs.getInt("quantity") + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Displays book list from database";
    }
}