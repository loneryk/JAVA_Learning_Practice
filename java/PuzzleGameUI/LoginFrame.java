package PuzzleGameUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import PuzzleGameUI.CodeUtil;
public class LoginFrame extends JFrame implements MouseListener {
    //创建一个集合存储正确的用户名和密码
    static ArrayList<User> list = new ArrayList<>();

    static {
        list.add(new User("zhangsan", "123"));
        list.add(new User("lisi", "1234"));
    }

    JLabel rightCode = new JLabel();
    String codeStr = CodeUtil.getCode();
    //2.添加用户名输入框
    JTextField username = new JTextField();
    //4.密码输入框
    JTextField password = new JTextField();
    //验证码的输入框
    JTextField code = new JTextField();
    //5.添加登录按钮
    //6.添加注册按钮
    JButton login = new JButton();
    JButton register = new JButton();
    //按钮路径
    String LoginButtonPath = "jagame\\image\\login\\登录按钮.png";
    String RegisterButtonPath = "jagame\\image\\login\\注册按钮.png";

    public LoginFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    private void initView() {
        this.getContentPane().removeAll();
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("jagame\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);


        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("jagame\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);


        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("jagame\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);


        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        codeStr = CodeUtil.getCode();

        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);
        //给验证码添加一个点击事件
        rightCode.addMouseListener(this);


        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(LoginButtonPath));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        //给登录按钮添加一个点击事件
        login.addMouseListener(this);


        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon(RegisterButtonPath));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        //给注册按钮添加一个点击事件
        register.addMouseListener(this);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("jagame\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    private void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }


    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            //获取用户名和密码
            String Username = username.getText();
            String Password = password.getText();
            String Code = code.getText();
            User UserInto = new User(Username, Password);

            //判断用户名和密码是否正确



              if (Code.length()==0) {
                System.out.println("验证码为空");
                showJDialog("验证码为空,请重新输入");
                String code = CodeUtil.getCode();
                rightCode.setText(code);
            } else if (Username.length()==0 || Password.length()==0) {

                System.out.println("用户名或密码为空");
                showJDialog("用户名或密码为空,请重新输入");
                String code = CodeUtil.getCode();
                rightCode.setText(code);
            }
            else if (isUserExist(UserInto)) {
                if (Code.equals(codeStr)){
                    //跳转到游戏界面
                    new GameJFrame();
                    //关闭登录界面
                    this.setVisible(false);
                }else if (Code.length()==0) {
                    System.out.println("验证码为空");
                    showJDialog("验证码为空,请重新输入");
                    String code = CodeUtil.getCode();
                    rightCode.setText(code);
                } else if (!Code.equals(codeStr)) {
                    System.out.println("验证码不相同");
                    showJDialog("验证码错误,请重新输入");
                    String code = CodeUtil.getCode();
                    rightCode.setText(code);
                }

            }
        else if (!Code.equals(codeStr)) {
            System.out.println("验证码不相同");
            showJDialog("验证码错误,请重新输入");
            String code = CodeUtil.getCode();
            rightCode.setText(code);}
            else {
                System.out.println("登录失败");
                showJDialog("用户名或密码错误,请重新输入");
                String code = CodeUtil.getCode();
                rightCode.setText(code);
            }

            //更换验证码
            if (e.getSource() == rightCode) {
                System.out.println("更换验证码");
                //获取一个新的验证码
                String code = CodeUtil.getCode();
                rightCode.setText(code);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(new ImageIcon("jagame\\image\\login\\登录按下.png"));

        }
        if (obj == register) {
            register.setIcon(new ImageIcon("jagame\\image\\login\\注册按下.png"));

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(new ImageIcon("jagame\\image\\login\\登录按钮.png"));

        }
        if (obj == register) {
            register.setIcon(new ImageIcon("jagame\\image\\login\\注册按钮.png"));
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    //判断用户是否在集合中存在
    public boolean isUserExist(User Username) {
        for (int i = 0; i < list.size(); i++) {
            User rightUser = list.get(i);
            if ( rightUser.getUsername().equals(Username.getUsername())&& rightUser.getPassword().equals(Username.getPassword())) {
                return true;
            }
        }
        return false;
    }


}