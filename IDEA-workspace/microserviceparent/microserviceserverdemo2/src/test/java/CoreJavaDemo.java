/**
 * @ClassName CoreJavaDemo
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/15 15:06
 * @Version 1.0
 **/
public class CoreJavaDemo {
    static int i=0;

    public static void main(String[] args) {

//        Demo1
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");

        operate(a,b);
        b=a;
        System.out.println(a+","+b);

//        Demo2
        String c=new String("C");
        String d=new String("D");
        operateStr(c,d);
        System.out.println(c+","+d);

//        Demo3
        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        System.out.println(o.equals("Fred"));

//        Demo4
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=5;
        b6=b4+b5;
//        System.out.println(b6 instanceof Integer);
//        如下编译错误
//        b3=b1+b2;

//        Test1 test1 = new Test1();

        fib(10);
        System.out.println(i);

    }
    public static void  operate(StringBuffer x,StringBuffer y){
        x.append(y);y=x;
    }

    public static void  operateStr(String x,String y){
        x=x.concat(y);y=x;
    }

    public static int fib(int n){
        i++;
        if(n==0){
            return 1;
        }else if(n==1)
            return 2;
        else
            return fib(n-1)+fib(n-2);
    }


}

class Test1{
    public int add(int a,int b){

        try {
            return a+b;
        } catch (Exception e) {
            System.out.println("dfljdl");
        }finally {
            System.out.println("finaly");
        }
        return 0;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println("he shi "+test1.add(9,34));
    }
}
