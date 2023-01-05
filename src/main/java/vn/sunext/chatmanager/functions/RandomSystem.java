package vn.sunext.chatmanager.functions;

import java.util.Random;

public class RandomSystem {

    public String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public String upperCaseAlphabet = alphabet.toUpperCase();
    public String number = "0123456789";
    public String combineNumberAndAlphabet = alphabet + upperCaseAlphabet + number;

    public Random r = new Random();

    public String randomCharacter(int nu) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nu; i++) {
            int n = randomNumber(0, combineNumberAndAlphabet.length() - 1);
            char c = combineNumberAndAlphabet.charAt(n);
            sb.append(c);
        }
        return sb.toString();
    }

    public int randomNumber(int min, int max) {
        return r.nextInt((max - min) + 1) + min;
    }

}
