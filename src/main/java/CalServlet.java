import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalServlet", value = "/calculator")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount_percent = Double.parseDouble(request.getParameter("percent"));
        double discount_amount = price * discount_percent * 0.01;
        double discount_price = price - discount_amount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + description + "</h1>");
        writer.println("<h1>Price: " + price + "USD" + "</h1>");
        writer.println("<h1>Discount Percent: " + discount_percent + "%" + "</h1>");
        writer.println("<h1>Discount Amount: " + discount_amount + "USD" + "</h1>");
        writer.println("<h1>Discount Price: " + discount_price + "USD" + "</h1>");
    }
}
