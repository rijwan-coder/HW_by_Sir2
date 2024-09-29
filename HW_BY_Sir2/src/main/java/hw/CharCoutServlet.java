package hw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CharacterCountServlet")
public class CharCoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the input string and character from the form
        String inputString = request.getParameter("inputString");
        String characterToCountStr = request.getParameter("characterToCount");

        // Ensure a valid single character is provided
        if (characterToCountStr.length() != 1) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Please enter a valid character.</h2>");
            return;
        }

        char characterToCount = characterToCountStr.charAt(0);
        int count = 0;

        // Count occurrences of the character
        for (char c : inputString.toCharArray()) {
            if (c == characterToCount) {
                count++;
            }
        }

        // Display the result
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>The character '" + characterToCount + "' appears " + count + " times in the string.</h2>");
    }
}
