import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import  java.lang.String;

class Main{
	
	public static void main(String[] args) {
		//
		if(args.length!=1) {
			if(args.length==0) {
				System.err.println("No files inputed!"); 
				System.exit(0);
			}
			System.err.println("Only one parameter could be inpted!");
			System.exit(0);
		}
		if(!args[0].equals("input.txt")) {
			System.err.println("Incorrect file name!");
			System.exit(0);
		}
		//
		File inFile=new File(args[0]);
		FileInputStream inStream;
		try {
			
			inStream=new FileInputStream(inFile);
			try {
				int inChar;
				while((inChar=inStream.read())!=-1) {
					//TODO MK
					calculateChar(inChar);
				}
				
				//���ļ������һ�����ַ�����һ��Ҳ������Ч����
				if(Character.isLetterOrDigit(brr))
					row++;
				
				System.out.println("�ַ���Ϊ��"+charCount+"\n"+"���ʵĸ���Ϊ��"+wordCount+"\n"+"��Ч����Ϊ��"+row);
				
				//�Ե��ʽ����������ǰʮ������
				sort(str,number);
				for(int i=0;i<10;i++) {
					System.out.print(str[i]+":"+number[i]+"\t");
				}
				inStream.close();
			} catch (IOException e) {
				System.err.println("Read char failed!");
				System.exit(0);
			}
			

			String s="TODO MK";//TODO MK
			
			File oFile=new File("result.txt");
			if(!oFile.exists()) {
				try {
					oFile.createNewFile();
				} catch (IOException e) {
					System.err.println("Create file result.txt failed!");
					System.exit(0);
				}
			}
			FileOutputStream oStream=new FileOutputStream(oFile);
			try {
				oStream.write(s.getBytes());
				oStream.close();
			} catch (IOException e) {
				System.err.println("Write result.txt failed!");
				System.exit(0);
			}
			
			//TODO MK
			System.out.println("OK");
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File do not exists!");
			System.exit(0);
		}
	}
	static int wordCount=0;       //��¼�ļ��е��ʵĸ���
	static int charCount=0;          //��¼�ļ����ַ��ĸ���
	static int flag=0;           //��¼��������ĸ����
	static String[] str=new String[3000];        //�洢����
	static int[] number=new int[3000];         //�洢��Ӧ���ʵ�����
	static int reduce=0;         //�ظ��ĵ�����
	static int row=0;            //��¼��Ч��
	static char brr='0';          //��¼�ַ������һ��з�
	static boolean rFlag=false;
	static boolean nFlag=false;
	
	private static void calculateChar(int c) {
		
		//ͳ���ļ��е��ַ���
		char i=(char)c;
		if(c>=0&&c<=127) {
			charCount++;
		}
		
		
		//��¼��Ч����
		if(c=='\r') {
			rFlag=true;
		}
		if(c=='\n'&&rFlag) {
			nFlag=true;
		}
		if(nFlag&&Character.isLetterOrDigit(c)) {
			row++;
			rFlag=false;
			nFlag=false;
		}
		//ɾȥ���㻻�з�ʱ�����һ���ַ�
		if(c=='\n')charCount--;
		
		
		//ͳ���ļ��еĵ�����
		if(Character.isLetter(i)) {
				flag++;
		}
		else if(Character.isDigit(i)&&flag>=4){
			flag++;
		}
		else {
			flag=0;
		}
			brr=i;
		
		//��ȡ�������ַ���
		if(flag==1) {
			str[wordCount-reduce]="";
			number[wordCount-reduce]=0;
			str[wordCount-reduce]=str[wordCount-reduce]+brr;
		}
		else if(flag>1&&flag<4)
		{
			str[wordCount-reduce]=str[wordCount-reduce]+brr;
		}
		if(flag==4) {
			wordCount++;
			number[wordCount-reduce-1]+=1;
			str[wordCount-reduce-1]=str[wordCount-reduce-1]+brr;
		}
		else if(flag>4) {
			str[wordCount-reduce-1]=str[wordCount-reduce-1]+brr;
			//�����еĵ���ת����Сд
			str[wordCount-reduce-1]=str[wordCount-reduce-1].toLowerCase();
		}
		
		
		//��¼����Ƶ��
		if(flag==0) {
			for(i=0;i<wordCount-reduce-1;i++)
			{
				if(str[wordCount-reduce-1].equals(str[i])) {
					number[i]++;
					reduce++;
				}
			}
		}
		
	}
	
	//�����õ��ַ�������Ͷ�Ӧ��Ƶ�������������
	private static String[] sort(String[] s,int[] a){
		String str;
		int g=0;
		if(s.length==a.length) {
			for(int i=0;i<s.length-1;i++)
			{
				for(int j=0;j<s.length-1-i;j++) {
					if(a[j]<a[j+1]&&s[j]!=null&&s[j+1]!=null) {
						str=s[j+1];
						s[j+1]=s[j];
						s[j]=s[j+1];
						g=a[j];
						a[j]=a[j+1];
						a[j+1]=g;
					}
					else if(a[j]==a[j+1]&&s[j]!=null&&s[j+1]!=null) {
						if(s[j].compareTo(s[j+1])>0) {
							str=s[j+1];
							s[j+1]=s[j];
							s[j]=s[j+1];
							g=a[j];
							a[j]=a[j+1];
							a[j+1]=g;
						}
					}
				}
			}
		}
		return s;
	}
}