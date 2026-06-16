package PuzzleGameUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建条目对象
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    //记录步数
    int step = 0;
    //记录正确图片索引
    int win [][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}};
    //记录空白位置
    int x = 0;
    int y = 0;
    //记录图片路径
    String path = "jagame/image/animal/animal3/";
    //创建二维数组 管理数据
    int[][] data = new int[4][4];

    public GameJFrame() {

        //初始化界面
        InitFrame();
        //初始化菜单
        InitJMenuBar();
        //初始化数据（打乱）
        InitData();
        //初始化图片
        InitImage();


        this.setVisible(true);
    }

    private void InitData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {

            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //提取交换位置后的一维数组

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                //反馈0的位置
                x = i / 4;
                y = i % 4;
            }

                data[i / 4][i % 4] = tempArr[i];
            }



        //便利二维数组
        for (int j = 0; j < data.length; j++) {
            for (int k = 0; k < data[j].length; k++) {
                System.out.print(data[j][k] + " ");
            }
            System.out.println();
        }
    }

    private void InitImage() {
        this.getContentPane().removeAll();
        if (Win()){

JLabel winLabel = new JLabel(new ImageIcon("jagame/image/win.png"));
            winLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winLabel);

        }
        //创建步数标签
JLabel stepLabel = new JLabel("步数：" + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];

                ImageIcon imageIcon = new ImageIcon(path + number + ".jpg");
                JLabel jlabel = new JLabel(imageIcon);
                this.getContentPane().add(jlabel);
                jlabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
//给图片添加边框
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jlabel);
            }

        }


        //添加背景图片
        ImageIcon background = new ImageIcon("jagame/image/background.png");
        JLabel backgroundJLabel = new JLabel(background);
        backgroundJLabel.setBounds(40, 40, 508, 560);

        //添加背景图到主界面
        this.getContentPane().add(backgroundJLabel);
        this.getContentPane().repaint();
    }

    private void InitJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jmenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建更换图片
        JMenu changeImage = new JMenu("更换图片");

        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        changeImage.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
//4.把美女，动物，运动添加到更换图片当中
        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        jmenuBar.add(functionJMenu);
        jmenuBar.add(aboutJMenu);
        this.setJMenuBar(jmenuBar);




    }

    private void InitFrame() {
        //界面的宽高
        this.setSize(603, 680);
        //界面的标题
        this.setTitle("拼图游戏 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //显示界面
        this.setLayout(null);
        //取消默认居中放置，只有取消了才能按照XY轴布局

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    private  void InitLoginFrame(){
        this.setSize(488,430);
        this.setTitle("拼图游戏登录");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //把当前界面中的图片全部删除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //添加背景图片
            ImageIcon background = new ImageIcon("jagame/image/background.png");
            JLabel backgroundJLabel = new JLabel(background);
            backgroundJLabel.setBounds(40, 40, 508, 560);
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Win()) {
            return;
        }


        int code = e.getKeyCode();
        if (code == 38) {
            if (x == 3) {
                return;
            }
            System.out.println("上");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            InitImage();

        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            System.out.println("下");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            InitImage();

        } else if (code == 37) {
            if (y == 3) {
                return;
            }
            System.out.println("左");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            InitImage();

        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            System.out.println("右");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            InitImage();

        }

        if (code == 65) {
            InitImage();

        }

        if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}};
            InitImage();

        }
    }

    public  boolean Win() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新开始");
            //打乱二维数组中的数据
            InitData();
            //清零计步器
            step = 0;
            //添加图片
            InitImage();

    }
        if (obj == reloginItem) {
            System.out.println("重新登录");
            this.setVisible(false);
        new LoginFrame();

        }
        if (obj == accountItem) {
            System.out.println("关于我们");
            //创建弹框对象
            JDialog jDialog = new JDialog();
           JLabel jLabel = new JLabel(new ImageIcon("jagame/image/about.png"));
          //设置宽高
            jLabel.setBounds(0,0,258,258);
           //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
           //弹框大小
            jDialog.setSize(344,344);
           //弹框置顶
            jDialog.setAlwaysOnTop(true);
           //居中
            jDialog.setLocationRelativeTo(null);
           jDialog.setDefaultCloseOperation(2);
           jDialog.setVisible(true);
         //弹框不关闭就无法操作下面的窗口
           jDialog.setModal(true);
        }
        if (obj == closeItem) {
            System.out.println("退出游戏");
            System.exit(0);
        }

        if (obj == girl){
            //切换美女图片
            Random random = new Random();
            int index = random.nextInt(12);
            index++;
            path = "jagame/image/girl/girl"+index+"/";
            InitImage();
        }
        if(obj == animal){
            //切换动物图片
            Random random = new Random();
            int index = random.nextInt(7);
            index++;
            path = "jagame/image/animal/animal"+index+"/";
            InitImage();
        }
        if (obj == sport){
            //切换运动图片
            Random random = new Random();
            int index = random.nextInt(9);
            index++;
            path = "jagame/image/sport/sport"+index+"/";
            InitImage();


        }

  }
}



