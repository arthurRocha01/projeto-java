package br.com.poo.view.promotor;

import br.com.poo.view.PromptViewFunctions;

public class PromotorViewPromptFunctions {
    public PromptViewFunctions viewFunctions = new PromptViewFunctions();
    
    public int pegarID() {
        System.out.print("ID: ");
        return viewFunctions.pegarInt();
    }
}
