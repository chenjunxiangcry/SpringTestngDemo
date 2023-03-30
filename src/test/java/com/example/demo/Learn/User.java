package com.example.demo.Learn;

public class User implements Cloneable{
    private Integer id;
    private String name;
    private Integer age;
    private Student student;

    public int card;

    public User(int i, String zhangSan, int i1, Student student, int card) {
        this.id = i;
        this.name = zhangSan;
        this.student = student;
        this.card=card;
    }

    public void setAge(int i) {
        age = i;
    }

    public void setName(String zhangSan1) {
        this.name = zhangSan1;
    }
    @Override
    public Object clone(){
        /*
        try{
            return (User) super.clone();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

         */
        User user = null;
        try {
            user = (User) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.student = (Student) student.clone();//调用student的clone方法
        new MinorStudent(1,2);

        return user;
    }




    @Override
    public String toString() {
        return "this id: "+id+" name: "+this.name+" age: "+this.age+ " card: "+this.card+ "Student "+this.student.toString();
    }
}
