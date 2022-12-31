package classwork.day20;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MyParser {

    private static final String JSON = "src/test/resources/recipe.json";

    public static String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }

    public void parseGSON(Search ki) throws FileNotFoundException {
        Gson gson = new Gson();

        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);

        System.out.println(recipe.getIngredientList());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public void toGSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Recipe recipe = new Recipe("", List.of(new Ingredient("myaso", 100)), 120);
        System.out.println(gson.toJson(recipe));
    }
}
