package com.example.demo2.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/order")
    public String test() {
        return "order";
    }

    @RequestMapping(value = "/order_confirm")
    public String order_confirm(HttpServletRequest request, Model model) {
        String buyer_no = request.getParameter("buyer_no");
        String buyer_name = request.getParameter("buyer_name");
        String buyer_hp = request.getParameter("buyer_hp");
        String buyer_email = request.getParameter("buyer_email");
        String buy_goods = request.getParameter("buy_goods");
        String buy_total = request.getParameter("buy_total");
        String order_num = request.getParameter("order_num");
        String is_reguler = request.getParameter("is_reguler");
        String pay_year = request.getParameter("pay_year");
        String pay_month = request.getParameter("pay_month");
        String is_taxsave = request.getParameter("is_taxsave");
        String work_type = request.getParameter("work_type");
        model.addAttribute("buyer_no", buyer_no);
        model.addAttribute("buyer_name", buyer_name);
        model.addAttribute("buyer_hp", buyer_hp);
        model.addAttribute("buyer_email", buyer_email);
        model.addAttribute("buy_goods", buy_goods);
        model.addAttribute("buy_total", buy_total);
        model.addAttribute("order_num", order_num);
        model.addAttribute("is_reguler", is_reguler);
        model.addAttribute("pay_year", pay_year);
        model.addAttribute("pay_month", pay_month);
        model.addAttribute("is_taxsave", is_taxsave);
        model.addAttribute("work_type", work_type);
        return "order_confirm";
    }

    @RequestMapping(value = "/order_result")
    public String order_result() {
        return "order_result";
    }

    @ResponseBody
    @PostMapping(value = "/pg/auth")
    public JSONObject payAuth() {
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try {

            String pURL = "http://testcpay.payple.kr/php/auth.php";
            String cst_id = "test";
            String cust_key = "abcd1234567890";
            String pcd_refund_key = "a41ce010ede9fcbfb3be86b24858806596a9db68b79d138b147c3e563e1829a0";

            JSONObject obj = new JSONObject();
            obj.put("cst_id", cst_id);
            obj.put("custKey", cust_key);

            URL url = new URL(pURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("referer", "http://localhost:8080");
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(obj.toString());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            // System.out.println("HTTP 응답 코드 : " + responseCode);
            // System.out.println("HTTP Body : " + response.toString());

            jsonObject = (JSONObject) jsonParser.parse(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
