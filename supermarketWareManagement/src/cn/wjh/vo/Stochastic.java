package cn.wjh.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 随机类
 * @author OMEN
 *
 */
public class Stochastic {
	private String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	//定义女生的名
	private String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	//定义男生的名
    private String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    String[] beforeShuffle2= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] beforeShuffle3= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
	String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
		"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
		"w", "x", "y", "z" };
	private String brand[] =new String[]{"盈霆","星西","同真","环宏","财集","金尔","远顺","斯飞","银具","傲惠","风方","开微","特禾","海蓝","赛荣","旭吉","林信","润莱","辰伟","辰艾","艾好","京中","胜通","开超","大铁","江典","旺嘉","鑫好","莱凡","鑫帝","吉优","财帝","高冠","子茂","辉庆","林翔","时凯","盈洋","良耀","生派","博迎","硕腾","同南","拓扬","博卓","诗源","威佩","旺好","发特","德奥","识识","志清","天顿","月百","佳子","悦迎","东鼎","格隆","领子","林子","胜宝","伟环","庆欧","凤铁","贸克","木荣","韦思","真丝","力仕","爱扬","跃日","皇至","财信","营威","腾事","裕海","白美","创奇","瑞辉","讯凌","润雅","森久"};
	private String fruit[] =new String[] {"西瓜","苹果","梨子","菠萝","香蕉","芒果","葡萄","猕猴桃","山竹","草莓","红毛丹","火龙果","橘子","樱桃","枇杷","柿子","蓝莓","无花果" ,"哈密瓜","荔枝","柠檬","柚子","圣女果"};
	private String furniture[]=new String[] {"沙发","床","椅子","书桌","鞋柜","电视柜","玄关柜","方茶几","抱枕","衣柜","挂衣架","餐桌","餐具","雨伞架"};
	private String meat[]=new String[] {"五花肉","羊肉","牛肉","猪排","牛脊肉","鸡肉","鱼肉","鸭肉","兔肉","狗肉"};
	private String electric[]=new String[] {"手表","电视机","智能手机","电脑","游戏机","收音机","摄录机","数码相机","视频监控器"};
	private String address[] =new String [] {"湖南","江西","湖北","四川","江苏","浙江","福建","广东","上海","北京","天津","黑龙江","西藏","新疆","重庆","广西","山东"};
	public Stochastic() {}
	/**
	 * 生产一个随机验证码
	 * @return
	 */
	public String achieveCode() {  //由于数字 1 , 0 和字母 O ,l 有时分不清楚，所以，没有数字 1 , 0
		
		List list = Arrays.asList(beforeShuffle);//将数组转换为集合
		Collections.shuffle(list);  //打乱集合顺序
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //将集合转化为字符串
		}
		return sb.toString().substring(3, 9);  //截取字符串第4到8
	}
	/**
	 * 生成一个随机手机号
	 * @return
	 */
	public String getTel() {
		List list = Arrays.asList(beforeShuffle2);//将数组转换为集合
		Collections.shuffle(list);  //打乱集合顺序
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //将集合转化为字符串
		}
		List list2 = Arrays.asList(beforeShuffle3);//将数组转换为集合
		Collections.shuffle(list2);  //打乱集合顺序
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < list2.size(); i++) {
		sb2.append(list2.get(i)); //将集合转化为字符串
		}
		return sb.toString().substring(0,1)+sb2.toString();  
	}
	/**
	 * 产生随机数
	 * @param 开始
	 * @param 结束
	 * @return
	 */
	public  int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
	/**
	 * 返回一个中文名
	 * @return
	 */
	public String getChineseName() {
        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
        String first=firstName.substring(index, index+1);//获取该位置的姓氏
        int sex=getNum(0, 1);
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生字符串的长度
        if(sex==0){//如果随机获取为0，则名字改为女生
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//随机获取名字的位置
        String second=str.substring(index, index+1);//获取该位置中的名字
        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
        String third="";//默认没有第三个字
        if(hasThird==1){//如果随机获取为1，则有第三个字
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//返回姓名
    }
	/**
	 * 随机产生密码
	 * @return
	 */
	public String getPassword() {
		List list = Arrays.asList(beforeShuffle);//将数组转换为集合
		Collections.shuffle(list);  //打乱集合顺序
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //将集合转化为字符串
		}
		return sb.toString().substring(6, 14);
	}
	/**
	 * 随机产生时间
	 * @return
	 */
	public String getTime() {
		int month=getNum(1, 12);
		int day=getNum(1, 31);
		int year=getNum(2000, 2020);
		if(month==2&&year%4==0) {
			day=getNum(1, 29);
		}else {
			day=getNum(1, 28);
		}
		return year+"/"+getNum(1, 12)+"/"+day+" "+getNum(0, 23)+":"+getNum(0, 59)+":"+getNum(0, 59);
	}
	/**
	 * 随机产生商品品种
	 * @return
	 */
	
	public String getGoods() {
		
		int a=getNum(0,brand.length-1),b=getNum(0, fruit.length-1),c=getNum(0, furniture.length-1),d=getNum(0, meat.length-1),e=getNum(0, electric.length-1);
		int f=getNum(0, 3);
		String s=brand[a];
		String s1=null;
		String s2=null;
		if(f==0) {
			s2="水果";
			s1=fruit[b];
		}else if(f==1) {
			s2="家具";
			s1=furniture[c];
		}else if(f==2) {
			s2="肉";
			s1=meat[d];
		}else {
			s2="电子产品";
			s1=electric[e];
		}
		return s+" "+s1+" "+s2;
	}
	/**
	 * 随机返回一个地名字符串
	 * @return
	 */
	public String getAddress() {
		int a=getNum(0,address.length-1);
		return address[a];
	}
}
