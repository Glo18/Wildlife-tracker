import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/AnimalsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "AnimalsForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addAnimal", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("animalsName");

            Animals animals = new Animals(name);
            animals.save();
            model.put("animals", animals);
            return new ModelAndView(model, "SuccessAnimal.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
