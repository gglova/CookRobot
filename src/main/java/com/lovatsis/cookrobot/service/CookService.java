package com.lovatsis.cookrobot.service;

import com.lovatsis.cookrobot.model.Recipe;

public interface CookService {

    void cook(Recipe recipe);

    void initialize();

    Recipe pickRandomRecipe();

    Recipe chooseRecipe(String requestedRecipe);

    Recipe chooseFromMenuAlaCart();
}
