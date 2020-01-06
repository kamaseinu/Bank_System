import java.util.*;

public class New_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LinkedHashMap<String, String> Acount_password = new LinkedHashMap<String, String>();
		LinkedHashMap<String, Integer> Acount_balance = new LinkedHashMap<String, Integer>();
		
		boolean flag = false;
		while (flag == false) {
			System.out.println("どうしますか？");
			System.out.println("【 1:登録 2:ログイン 3:終わる (4:データの開示) 】");
			String select1 = sc.next();
			if (select1.matches("[0-9]+")) {
				int select = Integer.parseInt(select1);
				if (select == 1) {
					boolean flag1 = false;
					while (flag1 == false) {
						System.out.println("名前を入力してください");
						String name = sc.next();
						System.out.println("パスワードを入力してください");
						String password = sc.next();
						boolean flag11 = false;
						while (flag11 == false) {
							System.out.println("お名前:" + name + " パスワード:" + password + "でよろしいですか？");
							System.out.println("【 1:はい 2:いいえ 】");
							String ok11 = sc.next();
							if (ok11.matches("[0-9]+")) {
								int ok1 = Integer.parseInt(ok11);
								if (ok1 == 1) {
									System.out.println("登録が完了しました");
									System.out.println("-------------------------------");
									Acount_password.put(password, name);
									Acount_balance.put(name, 0);
									flag1 = true;
									flag11 = true;
								}else if (ok1 == 2) {
									System.out.println("登録を取り消します");
									System.out.println("-------------------------------");
									flag1 = true;
									flag11 = true;
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("もう一度入力してください");
									System.out.println("-------------------------------");
								}
							}else {
								System.out.println("入力が読み取れませんでした");
								System.out.println("もう一度入力してください");
								System.out.println("-------------------------------");
							}
						}
					}
				}else if (select == 2) {
					System.out.println("ログインします");
					System.out.println("名前を入力してください");
					String name = sc.next();
					if (Acount_password.containsValue(name)) {
						System.out.println("パスワードを入力してください");
						String password = sc.next();
						String check_name = Acount_password.get(password);
						if (check_name.equals(name)) {
							System.out.println("ログインに成功しました！");
							System.out.println("-------------------------------");
							System.out.println("-------------------------------");
							
							//ログイン後の行動
							boolean flag1 = false;
							while (flag1 == false) {
								System.out.println("【 1:口座確認 2:預金 3:引出し 4:振込み 5:パスワードの変更 6:ログアウト 】");
								String select22 = sc.next();
								if (select22.matches("[0-9]+")) {
									int select2 = Integer.parseInt(select22);
									if (select2 == 1) {
										System.out.println("口座確認します");
										System.out.println(name + "さんの残金 : " + Acount_balance.get(name));
										System.out.println("-------------------------------");
									}else if (select2 == 2) {
										System.out.println("預金します");
										System.out.println("預金額を入力してください");
										String money11 = sc.next();
										if (money11.matches("[0-9]+")) {
											int money1 = Integer.parseInt(money11);
											int balance = Acount_balance.get(name);
											Acount_balance.put(name, (balance + money1));
											System.out.println("預金が完了しました");
										}else {
											System.out.println("入力が読み取れませんでした");
										}
										System.out.println(name + "さんの残金 : " + Acount_balance.get(name));
										System.out.println("-------------------------------");
									}else if (select2 == 3) {
										System.out.println("引出します");
										System.out.println("引出し額を入力してください");
										String money11 = sc.next();
										if (money11.matches("[0-9]+")) {
											int money1 = Integer.parseInt(money11);
											int balance = Acount_balance.get(name);
											if ((balance - money1) >= 0) {
												Acount_balance.put(name, (balance - money1));
												System.out.println("預金が完了しました");
											}else {
												System.out.println("残金が不足しています");
											}
										}else {
											System.out.println("入力が読み取れませんでした");
										}
										System.out.println(name + "さんの残金 : " + Acount_balance.get(name));
										System.out.println("-------------------------------");
									}else if (select2 == 4) {
										System.out.println("振込みを行います");
										System.out.println("振込み額を入力してください");
										String money11 = sc.next();
										if (money11.matches("[0-9]+")) {
											int money1 = Integer.parseInt(money11);
											int balance = Acount_balance.get(name);
											if ((balance - money1) >= 0) {
												System.out.println("振込先の名前を入力してください");
												String name_aite = sc.next();
												if (Acount_password.containsValue(name_aite)) {
													System.out.println("振込先のパスワードを入力してください");
													String password2 = sc.next();
													String check_name1 = Acount_password.get(password2);
													if (check_name1.equals(name_aite)) {
														Acount_balance.put(name, (balance - money1));
														int aite_money = Acount_balance.get(name_aite);
														Acount_balance.put(name_aite, (aite_money + money1));
														System.out.println("振り込みが完了しました");
														System.out.println(name + "さんの残金 : " + Acount_balance.get(name));
													}else {
														System.out.println("パスワードが違います");
													}
												}else {
													System.out.println("振込先が存在しません");
												}
											}else {
												System.out.println("残金が不足しています");
											}
										}else {
											System.out.println("入力が読み取れませんでした");
										}
										System.out.println("-------------------------------");
									}else if (select2 == 5) {
										System.out.println("パスワードの変更を行います");
										System.out.println("現在のパスワードを入力してください");
										String password1 = sc.next();
										boolean flag3 = false;
										while (flag3 == false) {
											if (password.equals(password1)) {
												System.out.println("新しいパスワードを入力してください");
												String password2 = sc.next();
												boolean flag2 = false;
												while (flag2 == false) {
													System.out.println("新しいパスワード:" + password2 + "でいいですか？");
													System.out.println("【 1:はい 2:いいえ 】");
													String select33 = sc.next();
													if (select33.matches("[0-9]+")) {
														int select3 = Integer.parseInt(select33);
														if (select3 == 1) {
															System.out.println("パスワードの変更が完了しました");
															System.out.println("新しいパスワード:\t" + password2);
															flag2 = true;
															flag3 = true;
														}else if (select3 == 2) {
															System.out.println("新しいパスワードをもう一度入力してください");
															System.out.println("-------------------------------");
															flag2 = true;
														}else {
															System.out.println("入力が読み取れませんでした");
															System.out.println("もう一度入力してください");
															System.out.println("-------------------------------");
														}
													}else {
														System.out.println("入力が読み取れませんでした");
														System.out.println("もう一度入力してください");
														System.out.println("-------------------------------");
													}
												}
											}else {
												System.out.println("パスワードが違います");
											}
										}
										System.out.println("-------------------------------");
									}else if (select2 == 6) {
										System.out.println("ログアウトします");
										System.out.println("-------------------------------");
										System.out.println("-------------------------------");
										flag1 = true;
									}else {
										
									}
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("もう一度入力してください");
									System.out.println("-------------------------------");
								}
							}
						}else {
							System.out.println("パスワードが違います");
							System.out.println("-------------------------------");
						}
					}else {
						System.out.println("入力された名前は登録されていません");
						System.out.println("-------------------------------");
					}
				}else if (select == 3){
					System.out.println("ご利用ありがとうございました");
					System.out.println("-------------------------------");
					System.out.println("-------------------------------");
					flag = true;
				}else if (select == 4) {
					System.out.println("【 1:名前とパスワード 2:名前と残金 】");
					String select44 = sc.next();
					if (select44.matches("[0-9]+")) {
						int select4 = Integer.parseInt(select44);
						if (select4 == 1) {
							for (String pass : Acount_password.keySet()) {
								String name_x = Acount_password.get(pass);
								System.out.println("名前:" + name_x + "\tパスワード:" + pass);
							}
							System.out.println("-------------------------------");
						}else if (select4 == 2) {
							for (String name : Acount_balance.keySet()) {
								int balance_x = Acount_balance.get(name);
								System.out.println("名前:" + name + "\t残金:" + balance_x);
							}
							System.out.println("-------------------------------");
						}else {
							System.out.println("入力が読み取れませんでした");
							System.out.println("もう一度入力してください");
							System.out.println("-------------------------------");
						}
					}else {
						System.out.println("入力が読み取れませんでした");
						System.out.println("もう一度入力してください");
						System.out.println("-------------------------------");
					}
				}else {
					System.out.println("入力が読み取れませんでした");
					System.out.println("もう一度入力してください");
					System.out.println("-------------------------------");
				}
			}else {
				System.out.println("入力が読み取れませんでした");
				System.out.println("もう一度入力してください");
				System.out.println("-------------------------------");
			}
		}
		
	}
	
}
