import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = request.session().attribute("addnewhero");
            model.put("heroes", heroes);
            return new ModelAndView(model, "addnewhero.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/heroes",(request,response)->{
            Map <String,Object> model = new HashMap<String,Object>();
            ArrayList<Hero> heroes=request.session().attribute("heroes");
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPowers =request.queryParams("specialPowers");
            String weakness =request.queryParams("weakness");
            Hero newHero = new Hero(name,age,specialPowers,weakness);
            model.put("templates","templates/success.hbs");
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());
    }
}
