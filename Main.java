# Bank_System

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Acount ac = new Acount();
		boolean end = false;
		
		System.out.println("銀行口座管理システムへようこそ！");
		while (end == false) {
			System.out.println("【 登録:1  ログイン:2  終わる:3 】");
			int action = sc.nextInt();
			switch (action) {
			case 1:
				ac.flag = false;
				System.out.println("アカウントの登録をします");
				while (ac.flag == false) {
					System.out.println("名前を入力してください");
					String name = sc.next();
					System.out.println("パスワードを入力してください");
					String pass = sc.next();
					ac.Register(name, pass);
				}
				break;
			case 2:
				ac.flag = false;
				System.out.println("ログインします");
				while (ac.flag == false) {
					System.out.println("IDを入力してください");
					String ID = sc.next();
					System.out.println("パスワードを入力してください");
					String pass = sc.next();
					ac.Login(ID, pass);
				}
				break;
			case 3:
				System.out.println("ご利用ありがとうございました");
				end = true;
				break;
			case 0:
				System.out.println(ac.ID);
				System.out.println(ac.Password);
				System.out.println(ac.Balance);
				System.out.println("---------------------------");
				break;
			}
		}
		

	}

}
