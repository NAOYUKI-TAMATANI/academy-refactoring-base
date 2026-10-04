// 問2.以下の不適切な変数名を修正してください。
public class VariableNaming {

  public void calculateNumbers() {
    /*
     * パターン1
     * スネークケース（_）や大文字スタートを解消し、プロジェクト全体の記法をローワーキャメルケースに統一。
     */
    int firstNumber = 10;
    int secondNumber = 20;

    /*
     * パターン2
     * a や x といった1文字の変数名は、何を表す数値なのかが判別しにくく可読性を低下させるため。
     * firstNumber, secondNumberから続く計算対象の数値として、明確で役割が伝わる名称に変更しました。
     */
    int thirdNumber = 5;
    int fourthNumber = 3;

    /*
     * パターン3
     * return はJavaの 予約語であり、変数名に使用すると構文エラーが発生するため。
     * 予約語を避け、加算処理に使われる数値として適切な名称に変更しました。
     */
    int fifthNumber = 100;

    int totalResult = firstNumber + secondNumber;
    int sum = thirdNumber + fourthNumber + fifthNumber;

    System.out.println(totalResult);
    System.out.println(sum);
  }
}
