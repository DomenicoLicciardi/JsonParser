package com.example.d_odo.jsonparser.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by d-odo on 27/02/2017.
 */

public class Student {

    private static final String NAME_KEY="nome";
    private static final String EMAIL_KEY="email";
    private static final String GITHUB_KEY="github";
    private static final String STUDENT_IMAGE="avatar";

    String name;
    String email;
    String github;
    private String imageUrl;

    public Student(JSONObject jsonStudent) {

        try {
            name = jsonStudent.getString(NAME_KEY);
            email = jsonStudent.getString(EMAIL_KEY);
            github= buildGithubUrl(jsonStudent.optString(GITHUB_KEY,""));
            imageUrl = jsonStudent.optString(STUDENT_IMAGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String buildGithubUrl(String username) {
        username = username.replace("@","");
        return "http://github.com/" + username;
    }

}
