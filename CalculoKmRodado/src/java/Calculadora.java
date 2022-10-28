/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author William Lima Alves R.A 21123196-5
 */
@WebServlet(urlPatterns = {"/Calculadora"})
public class Calculadora extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //variaveis para receber e calcular os dados
        String vehicle;
        double gas,average,reviewaverage,tirereview,naverage,nreviewaverage,ntirereview,sum,percentage,totalsum; 
        
        vehicle = request.getParameter("vehicle"); // Receber variavel String
        gas = Double.valueOf(request.getParameter("gas")); //Receber variavel Double com request de String
        average = Double.valueOf(request.getParameter("average"));
        reviewaverage = Double.valueOf(request.getParameter("reviewaverage"));
        tirereview = Double.valueOf(request.getParameter("tirereview"));
       
        naverage = gas/average; // Calculo media combustivel gasto por KM
        nreviewaverage = reviewaverage/10000;// Calculo media manutenção a cada 10.0000 gasto por KM
        ntirereview =  tirereview/50000;// Calculo media pneu novo a cada 50.0000 gasto por KM
        sum = naverage + nreviewaverage + ntirereview; //Soma dos gastos por KM
        percentage = (15 * sum)/100; // calculo porcentagem de 15%
        totalsum = sum + percentage; // soma da porcentagem com a soma dos gastos por KM
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora - Resultado</title>");
            out.println("<link rel='stylesheet' href='./styles.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<section class='wrapper'>");
            out.println("<h1>Calculo Km rodado para o modelo " + vehicle + ":</h1>");
            out.println("<div class='result-group'>");
            out.printf("<p>Valor do combustível: R$ %.2f %n</p>",(gas));
            out.printf("<p>Média do veículo: %.0f Km/L %n</p>",(average));
            out.printf("<p>Valor da revisão a cada 10.000 Km combustível: R$ %.2f %n</p>",(reviewaverage));
            out.printf("<p>Valor da troca de pneu a cada 50.000 Km combustível: R$ %.2f %n</p>",(tirereview));
            out.printf("<p>Valor gasto por Km do veículo é de: R$ %.2f %n</p>",(sum));
            out.printf("<p>Valor gasto por Km do veículo incluindo os 15 porcento é de: R$ %.2f %n</p>",(totalsum));
            out.println("<a href='index.html' class='myButton'>Voltar</a>");
            out.println("</div>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
