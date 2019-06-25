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
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get ("/heroes",(request,response)->{
            Map <String,Object> model = new HashMap<String,Object>();
            model.put("heroes",Hero.all());
            model.put("templates","templates/heroes.hbs");
            return new ModelAndView(model,"layout.hbs");
        },new HandlebarsTemplateEngine());

        get ("/hero/:id",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            String id = request.session().attribute(":id");
            Hero hero = Hero.find(Integer.parseInt(id));

            // model.put("heroes",request.session().attributes());
            model.put("hero", hero);
            model.put("templates", "templates/hero.hbs");
            return new ModelAndView(model, "layout.hbs");
        },new HandlebarsTemplateEngine());

        post ("/hero/:id",(request,response)->{
            Map<String,Object> model = new HashMap<>();
            Hero hero =Hero.find(Integer.parseInt(request.params(":id")));
            model.put("heroes",request.session().attributes());
            model.put("hero",hero);
            model.put("templates","templates/hero.hbs");
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());

        get("/addsquad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes",Hero.all());
            model.put("template", "templates/newsquad.vtl");
            return new ModelAndView(model, "newsquad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}