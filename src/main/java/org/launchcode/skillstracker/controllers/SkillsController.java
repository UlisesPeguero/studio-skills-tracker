package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {
    final String []languages = {"Java", "Javascript", "C++"};


    @GetMapping
    @ResponseBody
    public String listSkills() {
        String response =
                "<h1>Skills Tracker</h1>\n" +
                "  <h2>We have a few skills we would to learn. Here is the list!</h2>\n" +
                "    <ol>\n";
        for(String lang: languages) {
            response += "      <li>" + lang + "</li>\n";
        }
        return response + "    </ol>\n";
    }

    @GetMapping("form")
    @ResponseBody
    public String showForm() {
        String selectOptions = "\n";
        for(String lang: languages) {
            selectOptions += "<option value=\"" + lang + "\">" + lang + "</option>\n";
        }
        selectOptions += "\n";
        String form = "<form action=\"./form\" method=\"POST\">\n" +
            "  <label for=\"name\">Name: </label><input name=\"name\"><br>\n" +
            "  <label for=\"first\">My favorite language: </label><select name=\"first\">\n" + selectOptions + "</select><br>\n" +
            "  <label for=\"second\">My second favorite language: </label><select name=\"second\">\n" + selectOptions + "</select><br>\n" +
            "  <label for=\"third\">My third favorite language: </label><select name=\"third\">\n" + selectOptions + "</select><br>\n" +
                "<button type=\"submit\">Send</button>\n";
        return form + "</form>";
    }

    @PostMapping("form")
    @ResponseBody
    public String displayFormData(@RequestParam String name, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        String response =
                "<h1>" + name + "</h1>\n" +
                        "  <table>\n" +
                        "  <thead title=\"Favorite languages\">\n" +
                        "    <tr>\n" +
                        "       <th>Position</th>\n" +
                        "       <th>Programming language</th>\n" +
                        "    </tr>\n" +
                        "  </thead>\n" +
                        "  <tbody>\n" +
                        "  <tr>\n" +
                        "   <td> First </td>\n" +
                        "   <td>" + first + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "   <td> Second </td>\n" +
                        "   <td>" + second + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "   <td> Third </td>\n" +
                        "   <td>" + third + "</td>\n" +
                        "  </tr>\n" +
                        "  </tbody>\n";
        return response + "</table>\n";
    }
}
