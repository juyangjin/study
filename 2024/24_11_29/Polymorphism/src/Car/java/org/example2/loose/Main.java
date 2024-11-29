package org.example2.loose;

public class Main {
    public static void main(String[] args){
        Brake brake = new Brake("디스크 브레이크");

        InspcetService inspcetService = new InspcetService();
        inspcetService.inspect(brake);

    }
}
