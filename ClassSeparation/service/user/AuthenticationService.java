// 問3.以下のクラスを適切に分割してください。
/**
 * 【役割】ユーザー認証（ログイン）専門サービス
 * 
 * 【分割理由】
 * 単一責任の原則に基づき、セキュリティに関わる認証ロジックを独立した関心事として分離。
 * 
 * 【依存オブジェクト】
 * ・UserMapper : メールアドレスによるユーザー取得用
 * ・PasswordEncoder : 入力パスワードとハッシュ化パスワードの照合用
 */
public class AuthenticationService {

  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  // コンストラクタ
  public AuthenticationService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
  }

  // ログイン認証
  public User authenticate(LoginForm form) {
    User user = userMapper.findByEmail(form.getEmail());
    if (user == null) {
      throw new IllegalArgumentException("認証失敗");
    }

    if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("認証失敗");
    }

    return user;
  }

}
