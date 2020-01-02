# Bank_System

import java.util.*;

public class Acount {
	
	Scanner sc = new Scanner(System.in);
	public static ArrayList<String> ID = new ArrayList<String>();
	public static ArrayList<String> Password = new ArrayList<String>();
	public static ArrayList<Integer> Balance = new ArrayList<Integer>();
	public boolean flag = false;
	
	public void Register(String name, String pass) {
		flag = false;
		System.out.println("名前:" + name + " パスワード:" + pass + "でよろしいですか？");
		System.out.println("【 1:はい 0:いいえ 】");
		int response = sc.nextInt();
		if (response == 1) {
			ID.add(name);
			Password.add(pass);
			Balance.add(0);
			System.out.println("登録が完了しました");
			System.out.println("あなたのID:" + name + " パスワード:" + pass + "です");
			System.out.println("---------------------------");
			flag = true;
		}else {
			System.out.println("登録をやり直します");
			flag = false;
		}
	}
	
	public void Login(String Id, String password) {
		flag = false;
		if (ID.contains(Id) == true) {
			if (Password.get(ID.indexOf(Id)).equals(password)) {
				System.out.println("ログインに成功しました");
				System.out.println("---------------------------");
				
				//ログイン後の行動
				boolean flag2 = false;
				while (flag2 == false) {
					System.out.println("【 1:口座確認　2:預金　3:引出し　4:振り込み　5:ログアウト 】");
					int response = sc.nextInt();
					switch (response) {
					case 1:
						System.out.println(Id + "さんの情報");
						System.out.println("残金 : " + Balance.get(ID.indexOf(Id)) + "円");
						System.out.println("---------------------------");
						break;
					case 2:
						System.out.println("金額を入力してください");
						int money1 = sc.nextInt();
						System.out.println(money1 + "円入金します");
						Balance.set(ID.indexOf(Id), (Balance.get(ID.indexOf(Id))+money1));
						System.out.println("現在の残金 : " + Balance.get(ID.indexOf(Id)) + "円");
						System.out.println("---------------------------");
						break;
					case 3:
						System.out.println("金額を入力してください");
						int money2 = sc.nextInt();
						if (Balance.get(ID.indexOf(Id)) >= money2) {
							Balance.set(ID.indexOf(Id), (Balance.get(ID.indexOf(Id))-money2));
							System.out.println("現在の残金 : " + Balance.get(ID.indexOf(Id)) + "円");
							System.out.println("---------------------------");
						}else {
							System.out.println("残金が不足しています");
							System.out.println("現在の残金 : " + Balance.get(ID.indexOf(Id)) + "円");
							System.out.println("---------------------------");
						}
						break;
					case 4:
						System.out.println("振り込み金額を入力してください");
						int money3 = sc.nextInt();
						System.out.println("振込先のIDを入力してください");
						String id = sc.next();
						System.out.println("振込先のパスワードを入力してください");
						String passWord = sc.next();
						
						if (ID.contains(id) == true) {
							if (Password.get(ID.indexOf(id)).equals(passWord)) {
								if (Balance.get(ID.indexOf(Id)) >= money3) {
									System.out.println("振り込みが完了しました");
									Balance.set(ID.indexOf(Id), (Balance.get(ID.indexOf(Id))-money3));
									System.out.println("現在の残金 : " + Balance.get(ID.indexOf(Id)));
									Balance.set(ID.indexOf(id), (Balance.get(ID.indexOf(id))+money3));
									System.out.println("---------------------------");
								}else {
									System.out.println("残金が不足しています");
									System.out.println("現在の残金 : " + Balance.get(ID.indexOf(Id)) + "円");
									System.out.println("---------------------------");
								}
							}else {
								System.out.println("パスワードが間違っています");
							}
						}else {
							System.out.println("入力されたIDが存在しません");
						}
						break;
					case 5:
						System.out.println("ログアウトします");
						System.out.println("---------------------------");
						flag2 = true;
						break;
					}
				}
				
				flag = true;
			}else {
				System.out.println("Passwordが間違っています");
				System.out.println("もう一度やり直しますか？");
				System.out.println("【 1:はい 0:いいえ 】");
				int response = sc.nextInt();
				if (response==1) {
					System.out.println(Password.get(ID.indexOf(Id)));
					flag = false;
				}else {
					System.out.println("---------------------------");
					flag = true;
				}
			}
		}else {
			System.out.println("IDが間違っています");
			System.out.println("もう一度入力してください");
			flag = false;
		}
	}
	
	
}
