package com.example.test;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.lambda.InterfaceWithParams;
import com.example.test.lambda.Message;
import com.example.test.lambda.Message1;

/**
 * lambda表达式
 * Lambda 表达代替匿名内部类创建对象时，lambda 表达式的代码块将会代替实现抽象方法的方法体，lambda 表达式就相当于一个匿名方法。
 * 从语法上面看，lambda 表达式的主要作用就是代替匿名内部类的繁琐语法，它由三部分组成：
 * (形参列表) 形参列表。形参列表允许省略形参类型。如果只有一个参数，甚至可以省略括号。
 * -> 箭头。必须通过英文中画线和大于符号组成。
 * 代码块。
 * 如果代码块只包含一条语句，lambda 表达式允许省略代码块的{}.
 * 如果代码块只有一条 return 语句，甚至可以省略 return 关键字。
 * 
 * 基础语法
 * 对于 lambda 表达式有三种语法格式
 * () -> 单行语句。
 * () -> {一段逻辑}。
 * () -> 表达式。
 */
public class LambdaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda);
    }

    /**
     * lambda表达式测试
     * @param v
     */
    public void onLambda(View v) {
        InterfaceWithParams params = new InterfaceWithParams() {
            @Override
            public void run(String s) {
                System.out.println("通过" + s + "实现run(String)");
            }
        };
        InterfaceWithParams params1 = (String s) -> System.out.println("通过" + s + "实现run(String)");

        params.run("匿名类");
        params1.run("Lambda");
    }

    public void onTest(View v) {
        // 单行语句
        // 直接通过方法来调用
        fun(() -> System.out.println("Hello!"));
        // 直接通过方法来调用， str 为我们传递的参数
        fun1((str)  -> System.out.println(str));

        fun1((s) -> {
            s = s.toUpperCase();
            System.out.println(s);
        });
    }

    public static void fun(Message msg) {
        msg.print();
    }

    public static void fun1(Message1 msg) {
        msg.print("使用 lambda 传递参数");	  //使用 lambda 传递参数
    }
}
