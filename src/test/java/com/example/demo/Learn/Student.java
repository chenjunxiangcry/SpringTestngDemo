package com.example.demo.Learn;


public class Student implements Cloneable {
    private Integer id;
    private Integer score;

    public Student(Integer id,Integer score){

    }

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }
    protected int getAge(){
        return 0;
    }
    private int getSex(){
        return 0;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }

    public void setScore(int i) {
        this.score = i;
    }
    @Override
    public Object clone(){
        try{
            return (Student) super.clone();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
