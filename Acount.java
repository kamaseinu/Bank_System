# Bank_System

import java.util.*;

public class Acount {
	
	Scanner sc = new Scanner(System.in);
	//SubAction sa = new SubAction();
	public static ArrayList<String> ID = new ArrayList<String>();
	public static ArrayList<String> Password = new ArrayList<String>();
	public static ArrayList<Integer> Balance = new ArrayList<Integer>();
	public boolean flag = false;
	
	public void Register () {			//登録メソッド
		flag = false;
		System.out.println("アカウントの登録をします");
		while (flag == false) {			//条件を満たすまでループ(条件 : flag==true)
			System.out.println("アカウント名を入力してください");
			String name = sc.next();
			System.out.println("4文字以上のパスワードを入力してください");
			String pass = sc.next();
			if (ID.contains(name)) {			//登録するアカウント名がすでに存在している場合
				System.out.println("入力されたアカウント名はすでに存在しています");
				flag = true;
			}else if (name.matches("[0-9]+") == true) {			//登録するアカウント名がすべて数字の場合
				System.out.println("数字のみのアカウント名は登録できません");
				flag = true;
			}else {			//登録するアカウント名に問題がない場合
				if (pass.length() < 4) {			//登録するパスワードが短すぎる場合
					System.out.println("パスワードが短すぎます");
					flag = true;
				}else {			//登録するパスワードに問題がない場合
					System.out.println("名前:" + name + " パスワード:" + pass + "でよろしいですか？");
					System.out.println("【 1:はい 0:いいえ 】");
					String response1 = sc.next();
					if (response1.matches("[0-9]+")) {
						int response = Integer.parseInt(response1);
						if (response == 1) {			//1:登録する
							ID.add(name);
							Password.add(pass);
							Balance.add(0);
							System.out.println("登録が完了しました");
							System.out.println("あなたのID:" + name + " パスワード:" + pass + "です");
							System.out.println("-----------------------------");
							flag = true;
						}else if (response == 0) {			//0:登録しない
							System.out.println("登録を取り消します");
							System.out.println("-----------------------------");
							flag = true;
						}
					}else { 
						System.out.println("入力が読み取れませんでした");
						System.out.println("もう一度入力してください");
						System.out.println("-----------------------------");
					}
				}
			}
		}
	}
	
	public void Login () {			//ログインメソッド
		flag = false;
		int miss_count = 0;
		System.out.println("ログインします");
		while (flag == false) {			//条件を満たすまでループ(条件 : flag==true)
			System.out.println("IDを入力してください");
			String my_name = sc.next();
			System.out.println("パスワードを入力してください");
			String pass = sc.next();
			if (ID.contains(my_name) == true) {			//入力されたアカウント名が登録されている場合(ログイン)
				if (Password.get(ID.indexOf(my_name)).equals(pass)) {			//入力されたパスワードが正しい場合(ログイン)
					System.out.println("ログインに成功しました");
					System.out.println("-----------------------------");
					
					//ログイン後の行動
					boolean flag2 = false;
					while (flag2 == false) {			//条件を満たすまでループ(条件 : flag2==true)
						System.out.println("【 1:口座確認　2:預金　3:引出し　4:振り込み　5:ログアウト 】");
						String response1 = sc.next();
						if (response1.matches("[0-9]+")) {
							int response = Integer.parseInt(response1);
							if (response == 1) {			//1:口座確認
								System.out.println(my_name + "さんの情報");
								System.out.println("残金 : " + Balance.get(ID.indexOf(my_name)) + "円");
								System.out.println("-----------------------------");
							}else if (response == 2) {			//2:預金
								System.out.println("預金額(数字のみ)を入力してください");
								String money11 = sc.next();
								if (money11.matches("[0-9]+")) {
									int money1 = Integer.parseInt(money11);
									System.out.println(money1 + "円入金します");
									Balance.set(ID.indexOf(my_name), (Balance.get(ID.indexOf(my_name))+money1));
									System.out.println("現在の残金 : " + Balance.get(ID.indexOf(my_name)) + "円");
									System.out.println("-----------------------------");
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("-----------------------------");
								}
							}else if (response == 3) {			//3:引出し
								System.out.println("引出し額(数字のみ)を入力してください");
								String money22 = sc.next();
								if (money22.matches("[0-9]+")) {
									int money2 = Integer.parseInt(money22);
									if (Balance.get(ID.indexOf(my_name)) >= money2) {			//引出額が残金を上回っている場合
										Balance.set(ID.indexOf(my_name), (Balance.get(ID.indexOf(my_name))-money2));
										System.out.println("現在の残金 : " + Balance.get(ID.indexOf(my_name)) + "円");
										System.out.println("-----------------------------");
									}else {			//引出額が残金を下回っている場合
										System.out.println("残金が不足しています");
										System.out.println("現在の残金 : " + Balance.get(ID.indexOf(my_name)) + "円");
										System.out.println("-----------------------------");
									}
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("-----------------------------");
								}
							}else if (response == 4) {			//4:振り込み
								System.out.println("振込み額を入力してください");
								String money3 = sc.next();
								System.out.println("振込先のIDを入力してください");
								String Payee = sc.next();
								System.out.println("振込先のパスワードを入力してください");
								String passWord = sc.next();
								if (money3.matches("[0-9]+")==true) {
									int money4 = Integer.parseInt(money3);
									if (ID.contains(Payee) == true) {			//入力されたアカウント名が登録されている場合(振込先)
										if (Password.get(ID.indexOf(Payee)).equals(passWord)) {			//入力されたパスワードが正しい場合(振込先)
											if (Balance.get(ID.indexOf(my_name)) >= money4) {			//振り込み額が残金を上回っている場合
												System.out.println("振り込みが完了しました");
												Balance.set(ID.indexOf(my_name), (Balance.get(ID.indexOf(my_name))-money4));
												System.out.println("現在の残金 : " + Balance.get(ID.indexOf(my_name)));
												Balance.set(ID.indexOf(Payee), (Balance.get(ID.indexOf(Payee))+money4));
												System.out.println("-----------------------------");
											}else {			//振り込み額が残金を下回っている場合
												System.out.println("残金が不足しています");
												System.out.println("現在の残金 : " + Balance.get(ID.indexOf(my_name)) + "円");
												System.out.println("-----------------------------");
											}
										}else {			//入力されたパスワードが間違っている場合(振込先)
											System.out.println("パスワードが間違っています");
											System.out.println("-----------------------------");
										}
									}else {			//入力されたアカウント名が登録されていない場合(振込先)
										System.out.println("入力されたIDが存在しません");
										System.out.println("-----------------------------");
									}
								}else {
									System.out.println("金額が読み取れませんでした");
									System.out.println("-----------------------------");
								}
							}else if (response == 5) {			//5:ログアウト
								System.out.println("ログアウトします");
								System.out.println("-----------------------------");
								flag2 = true;
							}else {			//ログイン後の行動選択が読み取れない場合
								System.out.println("入力が読み取れませんでした");
								System.out.println("もう一度入力してください");
								System.out.println("-----------------------------");
							}
						}else {
							System.out.println("入力が読み取れませんでした");
							System.out.println("もう一度入力してください");
							System.out.println("-----------------------------");
						}
					}
					flag = true;
				}else {			//入力されたパスワードが間違っている場合(ログイン)
					System.out.println("Passwordが間違っています");
					System.out.println("もう一度やり直しますか？");
					System.out.println("【 1:はい 0:いいえ 】");
					String response1 = sc.next();
					if (response1.matches("[0-9]+")) {
						int response = Integer.parseInt(response1);
						if (response == 1) {			//ログインをやり直す場合
							System.out.println("-----------------------------");
						}else if (response == 0) {			//ログインをやり直さない場合
							System.out.println("-----------------------------");
							flag = true;
						}else {			////ログインをやり直す行動選択が読み取れない場合
							System.out.println("入力が読み取れませんでした");
							System.out.println("もう一度入力してください");
							System.out.println("-----------------------------");
						}
					}else {
						System.out.println("入力が読み取れませんでした");
						System.out.println("もう一度入力してください");
						System.out.println("-----------------------------");
					}
				}
			}else {			//入力されたアカウント名が登録されていない場合(ログイン)
				System.out.println("IDが間違っています");
				System.out.println("もう一度入力してください");
				flag = false;
			}
		}
	}
}
