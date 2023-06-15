package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBCcontroller {

    @Autowired
    private JdbcTemplate jdbc;

    @PostMapping("/insert")
    public String insertData(@RequestBody User user) {
        jdbc.update("INSERT INTO user (uid, uname, upass) VALUES (?, ?, ?)",
                user.getUid(), user.getUname(), user.getUpass());
        return "Data inserted successfully";
    }

    static class User {
        private int uid;
        private String uname;
        private String upass;

        public User() {
        }

        public User(int uid, String uname, String upass) {
            this.uid = uid;
            this.uname = uname;
            this.upass = upass;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUpass() {
            return upass;
        }

        public void setUpass(String upass) {
            this.upass = upass;
        }
    }
    }

