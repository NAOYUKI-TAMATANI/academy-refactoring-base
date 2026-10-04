// 問1.以下の不適切なメソッド名を修正してください。
public class AssignmentTask {

  /*
   * パターン1
   * 名詞（userMessage）から、処理内容を表す動詞（greet）に変更。
   */
  public void greet(User user) {
    System.out.println("Hello, " + user.getName());
  }

  /*
   * パターン2
   * 非常に長かったメソッド名を、意味を損なわずに簡潔で読みやすい名称へ変更。
   */
  public void printGreeting(User user) {
    System.out.println("Hello, " + user.getName());
  }

  /*
   * パターン3
   * 抽象的な process から、具体的で何を処理するかが明確な printUserName に変更。
   */
  public void printUserName(User user) {
    System.out.println(user.getName());
  }

  /*
   * パターン4
   * 値を取得して返す処理のため、getを付与。
   */
  public String getUserName(User user) {
    return user.getName();
  }

  /*
   * パターン5:
   * スネークケース（_）から、Javaの標準ルールであるローワーキャメルケースに変更。
   */
  public void printUserInfo(User user) {
    System.out.println(user.getName());
  }

  /*
   * パターン6
   * Javaの予約語である new を回避し、「生成する動作 + 対象」となる名称に変更。
   */
  public User createUser(String name) {
    return new User(name);
  }

  /*
   * パターン7
   * boolean を返す判定メソッドのため、慣例に従い is を頭につけた名称に変更。
   */
  public boolean isActive(User user) {
    return user.isActive();
  }

}