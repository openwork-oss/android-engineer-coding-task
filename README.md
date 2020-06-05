# Androidコーディング課題

## アプリ概要
ユーザーは文章を入力して、ユーザー自身の簡単な属性情報（性別と年代）を入力して、サーバに送信します。これを回答（`Answer`）と呼ぶことにします。
また、他の人が送信済みの回答リストをサーバから取得してリストで閲覧できます。

### バックエンドサーバのウェブAPI
回答をPOSTするAPIと、他の回答リストをGETするAPIの2つあります。
本課題では、簡略化のためバックエンドサーバは`retrofit-mock`を利用してモックします。

画面は以下の3つから構成されます。

### 初期画面（ホーム）
2つあるボタンをそれぞれクリックすると対応する画面に遷移するだけです。

### 回答作成画面
* 文字列入力フォーム
* 入力中に文字数を逐次カウントして表示する
* 性別と年代のプルダウンメニュー（回答しないも選択可）
* 回答送信ボタンクリックで入力内容を回答送信APIに送信、成功したら前画面に戻る
* 回答送信ボタンは入力済み文字数が20字以上の時のみ有効になる

### 回答リスト画面
* 回答リスト取得APIから取得した回答リストを表示
  * リストサイズは固定、ページネーション無し
* 性別、年代はそれぞれnullの場合トルツメ
* 性別、年代どちらも存在する回答の場合、「完全回答」というタグをリストアイテムの上部に表示。ない場合トルツメ。
* Options Menuから全回答リスト表示と完全回答のみ表示を切り替え可能
  * 毎回ウェブAPIを叩く必要はなく、一度取得したものを利用する
  * 初期表示は全回答リスト

## 課題
プロジェクトルートにある`android-engineer-coding-task.webm`のアプリを再現してください。

### 実装しなくていいもの
* 色の忠実な再現
  * 仕様が上記動画のみでアバウトなため。それっぽい色を指定すればOKです。
  * ただし、UI要素のトルツメとその際のマージンの変化などは必要です。
* 画面回転（縦向き固定です）
* マルチウインドウ
* タブレットレイアウト
* 多言語化
  * ただし日本語文字列はハードコードではなく`strings.xml`に定義してください
* ウェブAPIのエラーハンドリング
* 難読化対応

### 出題時点で実装済みのもの
* `retrofit-mock`を利用したウェブAPIの実装とモックデータ（実行結果は毎回同じ）
* ウェブAPIエンティティクラス
* 初期画面のレイアウト
  * ボタンクリックイベントは未実装
* Navigationコンポーネントの最低限の設定
  * Activityレイアウトに`NavHostFragment`を設定
  * Activityにアクションバーとの連携を設定
  * 遷移グラフは初期画面のみ定義

### その他
* JetPackや任意のOSSライブラリを適宜使用して問題ありません
* ウェブAPIの定義とモックデータは変更しないでください（サーバサイドの仕様は固定）
* `minSdkVersion`, `targetSdkVersion`, `compileSdkVersion`は変更しないでください
* 適宜わかりやすくパッケージ分けしてください
  * 小規模なアプリなのでモジュールまで分けることは要求しません（どちらでもOK）
* 仕様として明示されていないけどUXに気を使った実装は歓迎です

## 作業方法
このリポジトリをcloneしてご自身のコードを追加した上で、ご自身のGitHubアカウントのリポジトリとして公開し共有いただくか、ソースコード一式をZipするなどして直接ご提出ください。このリポジトリに直接Pull Requestを作成することはお控えください。

## 確認したいスキル
* Rxを利用したバックエンドサーバのウェブAPI問い合わせからView反映までの非同期の実装
  * コルーチンを使いたい場合は適宜変更していただいてOKです
* Data Bindingを利用した動的なレイアウト
* Navigation, ViewModel, LiveDataなどAndroid Architecture Componentsの実践
* Activity, Fragmentのライフサイクルの理解
* ユニットテストがしやすい設計
* コードの読みやすさ、命名の妥当性
