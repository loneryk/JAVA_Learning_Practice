package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> Userlist = new ArrayList<>();
        loop1:
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "2" -> register(Userlist);
                case "1" -> {
                    if (login(Userlist)) {
                        break loop1;
                    }
                }
                case "3" -> forgetPassword(Userlist);
                default -> System.out.println("输入错误");
            }
        }


        ArrayList<Student> list = new ArrayList<>();
        loop: while (true) {
            System.out.println("-------------欢迎来到黑马学生管理系统----------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1"-> addStudent(list);
                case "2"-> deleteStudent(list);
                case "3"-> updateStudent(list);
                case "4"-> queryStudent(list);
                case "5"-> {
                    System.out.println("退出");
              break loop;
                }
                default -> System.out.println("输入错误");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list ) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入学生id:");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                System.out.println("该id已存在,请重新输入");
                return;}
        }
        stu.setId(id);
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        stu.setName(name);
        System.out.println("请输入学生年龄:");
        String  age = sc.next();
        stu.setAge(age);
        System.out.println("请输入学生地址:");
        String address = sc.next();
        stu.setAddress(address);
        list.add(stu);
        System.out.println("添加成功");

    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的id:");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                list.remove(i);
                System.out.println("删除成功");
                return;
            } else {
                System.out.println("该id不存在");
            }
        }

    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的id:");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                System.out.println("请输入学生姓名:");
                String name = sc.next();
                list.get(i).setName(name);
                System.out.println("请输入学生年龄:");
                String age = sc.next();
                list.get(i).setAge(age);
                System.out.println("请输入学生地址:");
                String address = sc.next();
                list.get(i).setAddress(address);
                System.out.println("修改成功");

            }
        }
        System.out.println("该id不存在");


    }

    //        查询学生
    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("id\t姓名\t年龄\t地址");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getAge() + "\t" + list.get(i).getAddress());

        }
    }


    public static void register(ArrayList<User> userlist) {
        //用户名
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("请输入用户名:");
        String username = sc.next();
        for (int i = 0; i < userlist.size(); i++) {

            if (username.equals(userlist.get(i).getUserName())) {
                System.out.println("该用户名已存在,请重新输入");
                return;
            }
        }
        if (username.length() < 3 || username.length() > 15) {
            System.out.println("用户名长度不符合要求,请重新输入");
            return;
        }

        boolean hasDigit = false;  // 标记是否包含数字
        boolean hasLetter = false; // 标记是否包含字母

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                hasLetter = true;
            } else {
                // 包含非法字符
                System.out.println("用户名只能包含字母和数字");
                return;
            }
        }

// 如果是纯数字
        if (hasDigit && !hasLetter) {
            System.out.println("用户名不能是纯数字");
            return;
        }

        //密码
        System.out.println("请输入密码:");
        String PasswordFirst = sc.next();
        System.out.println("请再次输入密码:");
        String PasswordSecond = sc.next();

        if (PasswordFirst.equals(PasswordSecond)) {
            user.setPassword(PasswordFirst);
        } else {
            System.out.println("两次输入的密码不一致,请重新输入");
            return;
        }
//验证身份证
        System.out.println("请输入身份证号码:");
        String IDNumber = sc.next();
        if (IDNumber.length() != 18) {
            System.out.println("身份证号码长度不正确,请重新输入");
            return;
        }
        if (IDNumber.charAt(0) == '0') {
            System.out.println("身份证号码不能以0开头,请重新输入");
            return;
        }
        if (IDNumber.charAt(17) == 'X' && IDNumber.charAt(17) == 'x' && IDNumber.charAt(17) > '0' && IDNumber.charAt(17) < '9') {
            System.out.println("身份证号码最后一位必须是X或x或数字,请重新输入");
            return;
        }
        for (int i = 0; i < IDNumber.length() - 1; i++) {
            if (IDNumber.charAt(i) < '0' || IDNumber.charAt(i) > '9') {
                System.out.println("身份证号码只能包含数字,请重新输入");
            }
        }

        //手机号验证
        System.out.println("请输入手机号码:");
        String PhoneNumber = sc.next();
        if (PhoneNumber.length() != 11) {
            System.out.println("手机号码长度不正确,请重新输入");
            return;
        }
        if (PhoneNumber.charAt(0) != '1') {
            System.out.println("手机号码必须以1开头,请重新输入");
            return;
        }
        for (int i = 0; i < PhoneNumber.length(); i++) {
            if (PhoneNumber.charAt(i) < '0' || PhoneNumber.charAt(i) > '9')
                System.out.println("手机号码只能包含数字,请重新输入");
        }
        user.setPhoneNumber(PhoneNumber);
        user.setIDNumber(IDNumber);
        user.setUserName(username);
        userlist.add(user);
    }


    public static boolean login(ArrayList<User> userlist) {
        //登录
//用String Builder生成验证码
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        StringBuilder verifyCode = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int type = ran.nextInt(3);
            switch (type) {
                case 0:
                    verifyCode.append((char) (ran.nextInt(26) + 'a'));
                    break;
                case 1:
                    verifyCode.append((char) (ran.nextInt(26) + 'A'));
                    break;
                case 2:
                    verifyCode.append(ran.nextInt(10));
                    break;
            }
        }
        System.out.println("验证码:" + verifyCode);

        System.out.println("请输入用户名:");
        String username = sc.next();

        int count = 3;
        for (int i = 0; i < userlist.size(); i++) {
            if (count == 0) {
                System.out.println("你已连续输错3次,请稍后再试");
                return false;
            }

            count--;
            if (!(username.equals(userlist.get(i).getUserName()))) {
                System.out.println("用户名不存在,请重新输入你还剩" + count + "次机会");
                continue;
            }
            System.out.println("请输入验证码:");
            String code = sc.next();
            if (!(code.equals(verifyCode.toString()))  ) {
                System.out.println("验证码不正确,请重新输入"+"你还剩" + count + "次机会");
                 continue;
}


            else  {
                System.out.println("请输入密码:");
                String password = sc.next();
                if (password.equals(userlist.get(i).getPassword())) {
                    System.out.println("登录成功");
                    return true;
                } else
                    System.out.println("密码错误,请重新输入你还剩" + count + "次机会");
                continue;
            }


        }return false;
        }






    public static void forgetPassword(ArrayList<User> userlist) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        for (int i = 0; i < userlist.size(); i++) {
            if (!(username.equals(userlist.get(i).getUserName()))) {
                System.out.println("该用户名不存在,请重新输入");
                return;
            }

        }
        System.out.println("请输入身份证号码");
        String IDNumber = sc.next();
        for (int i = 0; i < userlist.size(); i++) {
            if (!(IDNumber.equals(userlist.get(i).getIDNumber()))) {
                System.out.println("身份证号码错误,请重新输入");
                return;
            }
        }
        System.out.println("请输入手机号码");
        String PhoneNumber = sc.next();
        for (int i = 0; i < userlist.size(); i++) {
            if (!(PhoneNumber.equals(userlist.get(i).getPhoneNumber()))) {
                System.out.println("手机号码错误,请重新输入");
                return;
            }

        System.out.println("请输入新密码");
        String Password = sc.next();
        userlist.get(i).setPassword(Password);

        }
    }
}

