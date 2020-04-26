package com.csii.webhook.model;


import java.util.HashMap;
import java.util.Map;

public class IntentCommon {

    //存款
    public static final String DEPOSIT = "deposit";

    //购买
    public static final String BUY = "buy";
    public static final String BOBJ = "bobj"; //购买obj
    public static final String SELECT = "select";

    //查询
    public static final String SEARCH = "search";
    public static final String SEOBJ = "sebj"; //查询obj
    public static final String COMPARE = "compare";
    public static final String CALCULATE = "calculate";
    public static final String HOLD = "hold";

    //卖出
    public static final String SELL = "sell";
    public static final String SOOBJ = "sobj"; //卖出obj

    //公用
    public static final String COMPLETE = "complete";
    public static final String INCOMPLETE = "incomplete";
    public static final String MONEY = "money";
    public static final String YEAR = "year";
    public static final String PASSWORD = "password";
    public static final String IDENTIFYINGCODE = "identifyingcode";
    public static final String DONE = "done";
    public static final String UNDONE = "undone";
    public static final String EXIT = "exit";


    //购买存款产品
    public static final String ANSWER_DEPOSIT = "欢迎您使用存款业务，现在您可以对存款产品进行查询，购买以及对已经买入的产品进行卖出交易";//需要一个util方法，替换字符串里的槽位，后面放若干个数值
    public static final String ANSWER_DEPOSIT_BUY = "您需要购买的存款产品是存款产品一号";
    public static final String ANSWER_BOBJ = "请说购买金额和年限";
    public static final String ANSWER_BUYCOMPLETE = " 您现在要购买xx，金额yy元，kk年，请说，确定，已确认购买";
    public static final String ANSWER_YEARINCOMPLETE = "您说的信息不完整，请告诉我多少年";
    public static final String ANSWER_MONEYINCOMPLETE = "您说的信息不完整，请告诉我多少元";
    public static final String ANSWER_SELECT = "请说收到的验证码，交易密码";
    public static final String ANSWER_PASSWORDINCOMPLETE = "请说收到的交易密码";
    public static final String ANSWER_IDENTIFYINGCODEINCOMPLETE = "请说收到的验证码";
    public static final String ANSWER_DONE = "交易完成，是否退出";
    public static final String ANSWER_UNDONE = "交易未完成，是否退出";
    public static final String ANSWER_EXIT = "感谢您使用渤海银行语音助手，再见";

    //查询存款产品
    public static final String ANSWER_SEARCH = "目前推荐存款产品有。。。请回复序号告诉我要查询哪个。。。";
    public static final String ANSWER_SEOBJ = "介绍具体产品信息，你还有什么要问我的么";
    public static final String ANSWER_SEARCHCOMPARE = "介绍差异，如果您想购买哪个请说序号或者产品名字";
    public static final String ANSWER_CALCULATE = "xxx，请说金额和期限，比如：五万元三年";
    public static final String ANSWER_SEARCH_COMPELETE = "收益xxxx，您要购买他么，请说 金额，或者想了解其他产品，请说刚刚的序号或产品名字";
    public static final String ANSWER_HOLD = "您拥有的产品为存款产品一号，二号";



    //卖出存款产品
    public static final String  ANSWER_SELL= "您现在已经购买的产品有。。。请回复序号告诉我要卖出哪款存款。。。";
    public static final String ANSWER_DEPOSIT_SELL= "要卖出的存款产品是。。。号，请请输入您要卖出存款产品的金额";
    public static final String ANSWER_DEPOSIT_SEOBJ  = "请输入您要卖出的产品的金额为。。。元";
    public static final String ANSWER_SELLCOMPLETE  = "请输入您要卖出的产品的金额为。。。元";



    public static final Map<String, String> IntentQA = new HashMap<String, String>() {
        {
            //购买存款产品
            put(DEPOSIT, ANSWER_DEPOSIT);//进入存款产品意图，响应：产品种类及要干嘛

            put(keySplit(DEPOSIT,BUY), ANSWER_DEPOSIT_BUY);//用户购买存款产品，响应存款产品种类
            put(keySplit(DEPOSIT,BUY,BOBJ), ANSWER_BOBJ);//用户选定第几个，响应：购买年限和金额
            put(keySplit(DEPOSIT, BUY, COMPLETE), ANSWER_BUYCOMPLETE);//用户说年限和金额，响应：确认购买
            put(keySplit(DEPOSIT,BUY,BOBJ,YEAR,INCOMPLETE), ANSWER_YEARINCOMPLETE);//用户说金额，响应：信息不完整，说年限
            put(keySplit(DEPOSIT,BUY,BOBJ,MONEY,INCOMPLETE), ANSWER_MONEYINCOMPLETE);//用户说年限，响应：信息不完整，说金额
            put(keySplit(SELECT),ANSWER_SELECT);//用户确认，响应：请输入验证码，交易密码
            put(keySplit(DEPOSIT,BUY,BOBJ,COMPLETE,SELECT,PASSWORD,INCOMPLETE),ANSWER_PASSWORDINCOMPLETE);//用户只说验证码，响应：请说交易密码
            put(keySplit(DEPOSIT,BUY,BOBJ,COMPLETE,SELECT,IDENTIFYINGCODE,INCOMPLETE),ANSWER_IDENTIFYINGCODEINCOMPLETE);//用户只说交易密码，响应：请说验证码
            put(keySplit(DEPOSIT,BUY,BOBJ,COMPLETE,SELECT,COMPLETE),ANSWER_DONE);//用户说验证码和交易密码，响应：交易完成，是否退出
            put(keySplit(DEPOSIT,BUY,BOBJ,COMPLETE,SELECT,COMPLETE),ANSWER_UNDONE);//用户说验证码，交易密码，响应：交易未完成，是否退出
            put(keySplit(DEPOSIT,BUY,BOBJ,COMPLETE,SELECT,COMPLETE,DONE),ANSWER_EXIT);//用户说退出，响应：感谢使用，再见

            //查询存款产品
            put(SEARCH,ANSWER_SEARCH);//用户查询存款产品，响应：查询哪一个存款产品
            put(SEOBJ,ANSWER_SEOBJ);//用户说第几个，响应：第几个产品具体信息
            put(keySplit(SEARCH,COMPARE),ANSWER_SEARCHCOMPARE);//用户说差异，响应：介绍差异
            put(keySplit(SEARCH,CALCULATE),ANSWER_CALCULATE);//用户说计算第几个的收益，响应：输入金额年限
            put(keySplit(SEARCH,CALCULATE,COMPLETE),ANSWER_SEARCH_COMPELETE);//用户说金额年限，响应：收益多少
            put(keySplit(SEARCH,CALCULATE,YEAR,INCOMPLETE),ANSWER_YEARINCOMPLETE);//用户说金额，响应：信息不完整，说年限
            put(keySplit(SEARCH,CALCULATE,MONEY,INCOMPLETE),ANSWER_MONEYINCOMPLETE);//用户说年限，响应：信息不完整，说金额
            put(keySplit(SEARCH,HOLD),ANSWER_HOLD);//用户说查看持仓，响应：您拥有什么产品

            //卖出存款产品
            put(keySplit(DEPOSIT,SELL),ANSWER_SELL);//用户准备卖出已购存款产品，响应：已经购买的存款产品
            put(keySplit(DEPOSIT,SELL,SOOBJ),ANSWER_DEPOSIT_SELL);//已经选择卖出产品名称或者编号，响应：已经购买的存款产品编号，请输入金额
            put(keySplit(DEPOSIT,SELL,SOOBJ,COMPLETE),ANSWER_DEPOSIT_SEOBJ);//用户准备卖出已购存款产品，响应：已经购买的存款产品
            put(keySplit(DEPOSIT,SEARCH),ANSWER_SELLCOMPLETE);//用户准备卖出已购存款产品，响应：已经购买的存款产品





        }
    };

    //拼接字符串，将 key 以 . 拼接起来
    public static String keySplit(String... str) {
        // 此时str是一个数组
        String result = "";
        for (int i = 0; i < str.length; i++) {
            result = result + "." + str[i] ;
        }
        result = result.substring(1);
        return result;
    }

}