package br.com.poo.view.promotor;

import java.util.Scanner;
import br.com.poo.view.PromptViewFunctions;

public class PromotorViewPromptFunctions {
    private Scanner scanner = new Scanner(System.in);
    public PromptViewFunctions viewFunctions = new PromptViewFunctions();
    
    public int pegarID() {
        System.out.print("ID: ");
        return viewFunctions.pegarInt();
    }
}
