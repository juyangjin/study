package org.example2.direc.loose;

public class Brake {

    //속성
    private String name;
    private boolean isInspected; // 검수여부

    //생성자
    public Brake(String name){
        this.name = name;
        this.isInspected = false;
    }

    public boolean isInspected() {
        return isInspected;
    }

    public void setInspected(boolean inspected) {
        isInspected = inspected;
    }
}
