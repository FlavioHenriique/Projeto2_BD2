package com.ifpb.projetobd2.servlet;

import com.ifpb.projetobd2.commands.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front")
public class FrontServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        command(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        command(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        command(request, response);
    }

    public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            request.setCharacterEncoding("UTF-8");

            Command command = (Command) Class.forName("com.ifpb.projetobd2.commands."
                    + request.getParameter("command")).newInstance();

            command.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
