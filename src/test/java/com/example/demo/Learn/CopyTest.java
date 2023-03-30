package com.example.demo.Learn;

public class CopyTest {
    public static void main(String[] args) {
        /*
        Student student = new Student(1, 80);
        User user;
        user = new User(1, "zhangSan", 25, student,345);
        User newUser=user;
        System.out.println(newUser.toString());
        user.setAge(26);
        user.card=123;
        newUser.setName("zhangSan1");
        System.out.println(newUser.toString());
      */

        Student student = new Student(1, 80);
        User user = new User(1, "zhangSan", 25, student,345);
        User newUser = (User) user.clone();//浅拷贝
        System.out.println(newUser.toString());
        //使用这种方式修改student引用，newUser是不会跟着变得，因为创建了一个新的Student类对象，而不是改变原对象的实例值
        //user.setStudent(new Student(2, 90));
        user.card = 123;
        student.setScore(90);
        System.out.println(newUser.toString());

    }
}
