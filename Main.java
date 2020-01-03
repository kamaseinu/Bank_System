# Bank_System

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Acount ac = new Acount();
		boolean end = false;
		
		System.out.println("銀行口座管理システムへようこそ！");
		while (end == false) {			//条件を満たすまでループ(条件 : end==true)
			System.out.println("【 登録:1  ログイン:2  終わる:3 】");
			String action1 = sc.next();
			if (action1.matches("[0-9]+")) {
				int action = Integer.parseInt(action1);
				if (action == 1) {			//1:登録
					ac.Register();
				}else if (action == 2) {			//2:ログイン
					ac.Login();
				}else if (action == 3) {			//3:終わる
					System.out.println("ご利用ありがとうございました");
					end = true;
				}else {
					System.out.println("入力が読み取れませんでした");
					System.out.println("もう一度入力してください");
					System.out.println("-----------------------------");
				}
			}else if (action1.equals("hirakegoma")) {			//hirakegoma:保存データの開示 (※隠しコマンド)
				System.out.println("隠しコマンドが入力されました");
				System.out.println("保存されているデータを開示します");
				System.out.print("ID一覧 : \t");
				System.out.println(ac.ID);
				System.out.print("パスワード一覧 : \t");
				System.out.println(ac.Password);
				System.out.print("残金一覧 : \t");
				System.out.println(ac.Balance);
				System.out.println("-----------------------------");
			}else {
				System.out.println("入力が読み取れませんでした");
				System.out.println("もう一度入力してください");
				System.out.println("-----------------------------");
			}
			
		}
		
	}
}
