package com.lovatsis.cookrobot;

import com.lovatsis.cookrobot.model.Recipe;
import com.lovatsis.cookrobot.service.CookService;
import com.lovatsis.cookrobot.service.CookServiceImpl;

public class Application {

    public static void main(String[] args) {
        System.out.println("Cook Robot v1.0");

        CookService cookService = new CookServiceImpl();
        cookService.initialize();
//        Recipe recipe= cookService.pickRandomRecipe();
//        Recipe recipe= cookService.chooseRecipe("Pita-giros");
//        Recipe recipe= cookService.chooseRecipe("Makaronia");
        Recipe recipe= cookService.chooseFromMenuAlaCart();
        cookService.cook(recipe);
    }
}
