import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.hbs";


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = request.session().attribute("addnewhero");
            model.put("addnewhero", heroes);
            model.put("templates", "addnewhero.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

    }
}
