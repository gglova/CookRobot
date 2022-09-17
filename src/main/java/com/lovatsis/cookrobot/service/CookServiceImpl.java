package com.lovatsis.cookrobot.service;

import com.lovatsis.cookrobot.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CookServiceImpl implements CookService {

    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public void cook(Recipe recipe) {
        System.out.println("cook recipe");
        validateRecipe(recipe);
        cookRecipe(recipe);
    }

    @Override
    public void initialize() {
        Recipe myRecipe1=new Recipe("Pita-giros","You cut the meat, you grill it, " +
                "you wrap it with pita and add tomato","Pita, Meat, Tomato");
        Recipe myRecipe2=new Recipe("Gemista", "You open the pepper/ntomata and fill it with ryzi.",
                "Piperies, ryzi, ntomata");

        recipes.add(myRecipe1);
        recipes.add(myRecipe2);
    }

    @Override
    public Recipe pickRandomRecipe() {
        int randomIndex = new Random().nextInt(recipes.size());
        return recipes.get(randomIndex);
    }

    @Override
    public Recipe chooseRecipe(String requestedRecipe) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(requestedRecipe))
                return recipe;
        }
        return null;
    }

    @Override
    public Recipe chooseFromMenuAlaCart() {
        System.out.println("We have these recipes: ");
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName());
        }
        System.out.println("Please select by writing the whole name of the recipe you want: ");
        Scanner keyboard = new Scanner(System.in);
        String selectedRecipeName = keyboard.nextLine();
        return chooseRecipe(selectedRecipeName);
    }

    private void validateRecipe(Recipe recipe) {
        System.out.println("validateRecipe");
        if (recipe == null) throw new RuntimeException("Recipe not found");
        if (recipe.getName() == null) throw new RuntimeException("Recipe name not found");
        if (recipe.getInstructions() == null) throw new RuntimeException("Recipe instructions not found");
        if (recipe.getIngredients() == null) throw new RuntimeException("Recipe ingredients not found");
    }

    private void cookRecipe(Recipe recipe) {
        System.out.println("The menu today is: " + recipe.getName());
        System.out.println("We need to have these ingredients:" + recipe.getIngredients());
        System.out.println("We need to follow these instructions:" + recipe.getInstructions());

        System.out.println("Cooking");
        for (int i = 0; i < 10; i++) {
            waitForASec();
            System.out.print(".");
        }
        System.out.print("Ready!");
    }

    private void waitForASec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
