package com.facebook;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class App extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Create user
        User user = new User(1, "Valodik", "00oo000",
                "Armenia,Yerevan,Government house 1", 17);
        ObjectMapper jsonMapper = new ObjectMapper();//create new Json mapper // we user Jackson library
        String userJson = jsonMapper.writeValueAsString(user);
        resp.setContentType("application/json"); //set Http Response CONTENT TYPE
        PrintWriter writer = resp.getWriter(); //Get Writer for filling RESPONSE BODY
        writer.println(userJson);
    }

    class User {
        public User(int id, String username, String password, String address, int age) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.address = address;
            this.age = age;
        }

        private int id;
        private String username;
        private String password;
        private String address;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
