package br.edu.ifet.es.sys.vendas.web.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;

import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ProdutoController", urlPatterns = {"/produtos"})
public class ProdutoController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String par = req.getParameter("op");
        URL url;

        if("del".equals(par)){
            String code = req.getParameter("codigo");
            url = new URL("http://localhost:8090/prod/produtos/" + code);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            in.read();
            in.close();
        }


        url = new URL("http://localhost:8090/prod/produtos");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode dados = mapper.readTree(content.toString());


        req.setAttribute("produtos", dados);
        req.getRequestDispatcher("/produtos/produtos.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        URL url = new URL("http://localhost:8090/prod/produtos");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

//        Map<String, String> parameters = new HashMap<>();
        String json = "{\"nome\":\"" + req.getParameter("nome") + "\"," +
                "\"valor\":" + req.getParameter("valor") + "," +
                "\"descricao\":\"" + req.getParameter("descricao") + "\"," +
                "\"qtdEstoque\":" + req.getParameter("qtdEstoque") + "," +
                "\"desconto\":" + req.getParameter("desconto") + "," +
                "\"categoria\":" + req.getParameter("categoria") + "}";

        JSONObject dados = null;
        try {
            dados = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(json);
        out.flush();
        out.close();

        System.out.println("Response Code : " + con.getResponseCode());

        System.out.println("json : " + json);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");

        rd.forward(req, resp);

    }
}