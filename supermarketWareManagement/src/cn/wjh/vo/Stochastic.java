package cn.wjh.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * �����
 * @author OMEN
 *
 */
public class Stochastic {
	private String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    String[] beforeShuffle2= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] beforeShuffle3= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
	String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
		"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
		"w", "x", "y", "z" };
	private String brand[] =new String[]{"ӯ��","����","ͬ��","����","�Ƽ�","���","Զ˳","˹��","����","����","�緽","��΢","�غ�","����","����","��","����","����","��ΰ","����","����","����","ʤͨ","����","����","����","����","�κ�","����","�ε�","����","�Ƶ�","�߹�","��ï","����","����","ʱ��","ӯ��","��ҫ","����","��ӭ","˶��","ͬ��","����","��׿","ʫԴ","����","����","����","�°�","ʶʶ","־��","���","�°�","����","��ӭ","����","��¡","����","����","ʤ��","ΰ��","��ŷ","����","ó��","ľ��","Τ˼","��˿","����","����","Ծ��","����","����","Ӫ��","����","ԣ��","����","����","���","Ѷ��","����","ɭ��"};
	private String fruit[] =new String[] {"����","ƻ��","����","����","�㽶","â��","����","⨺���","ɽ��","��ݮ","��ë��","������","����","ӣ��","����","����","��ݮ","�޻���" ,"���ܹ�","��֦","����","����","ʥŮ��"};
	private String furniture[]=new String[] {"ɳ��","��","����","����","Ь��","���ӹ�","���ع�","���輸","����","�¹�","���¼�","����","�;�","��ɡ��"};
	private String meat[]=new String[] {"�廨��","����","ţ��","����","ţ����","����","����","Ѽ��","����","����"};
	private String electric[]=new String[] {"�ֱ�","���ӻ�","�����ֻ�","����","��Ϸ��","������","��¼��","�������","��Ƶ�����"};
	private String address[] =new String [] {"����","����","����","�Ĵ�","����","�㽭","����","�㶫","�Ϻ�","����","���","������","����","�½�","����","����","ɽ��"};
	public Stochastic() {}
	/**
	 * ����һ�������֤��
	 * @return
	 */
	public String achieveCode() {  //�������� 1 , 0 ����ĸ O ,l ��ʱ�ֲ���������ԣ�û������ 1 , 0
		
		List list = Arrays.asList(beforeShuffle);//������ת��Ϊ����
		Collections.shuffle(list);  //���Ҽ���˳��
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //������ת��Ϊ�ַ���
		}
		return sb.toString().substring(3, 9);  //��ȡ�ַ�����4��8
	}
	/**
	 * ����һ������ֻ���
	 * @return
	 */
	public String getTel() {
		List list = Arrays.asList(beforeShuffle2);//������ת��Ϊ����
		Collections.shuffle(list);  //���Ҽ���˳��
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //������ת��Ϊ�ַ���
		}
		List list2 = Arrays.asList(beforeShuffle3);//������ת��Ϊ����
		Collections.shuffle(list2);  //���Ҽ���˳��
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < list2.size(); i++) {
		sb2.append(list2.get(i)); //������ת��Ϊ�ַ���
		}
		return sb.toString().substring(0,1)+sb2.toString();  
	}
	/**
	 * ���������
	 * @param ��ʼ
	 * @param ����
	 * @return
	 */
	public  int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
	/**
	 * ����һ��������
	 * @return
	 */
	public String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0, 1);
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
	/**
	 * �����������
	 * @return
	 */
	public String getPassword() {
		List list = Arrays.asList(beforeShuffle);//������ת��Ϊ����
		Collections.shuffle(list);  //���Ҽ���˳��
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i)); //������ת��Ϊ�ַ���
		}
		return sb.toString().substring(6, 14);
	}
	/**
	 * �������ʱ��
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
	 * ���������ƷƷ��
	 * @return
	 */
	
	public String getGoods() {
		
		int a=getNum(0,brand.length-1),b=getNum(0, fruit.length-1),c=getNum(0, furniture.length-1),d=getNum(0, meat.length-1),e=getNum(0, electric.length-1);
		int f=getNum(0, 3);
		String s=brand[a];
		String s1=null;
		String s2=null;
		if(f==0) {
			s2="ˮ��";
			s1=fruit[b];
		}else if(f==1) {
			s2="�Ҿ�";
			s1=furniture[c];
		}else if(f==2) {
			s2="��";
			s1=meat[d];
		}else {
			s2="���Ӳ�Ʒ";
			s1=electric[e];
		}
		return s+" "+s1+" "+s2;
	}
	/**
	 * �������һ�������ַ���
	 * @return
	 */
	public String getAddress() {
		int a=getNum(0,address.length-1);
		return address[a];
	}
}
