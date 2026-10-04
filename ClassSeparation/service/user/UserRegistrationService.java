// 問3.以下のクラスを適切に分割してください。
/**
 * 【役割】ユーザー新規登録・登録用バリデーション専門サービス
 * 
 * 【分割理由】
 * ユーザーの新規登録処理と、それに伴う「メールアドレスの重複確認（existsByEmail）」に分離。
 * 【依存オブジェクト】
 * ・UserMapper : 登録時のDB保存（insert）および重複チェック用
 * ・PasswordEncoder : パスワードのハッシュ化用
 */
public class UserRegistrationService {

  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  // コンストラクタ
  public UserRegistrationService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
  }

  // ユーザー登録
  public User register(UserRegistrationForm form) {
    if (existsByEmail(form.getEmail())) {
      throw new IllegalArgumentException("既に登録されています");
    }

    User user = new User();
    user.setName(form.getName());
    user.setEmail(form.getEmail());
    user.setPassword(passwordEncoder.encode(form.getPassword()));
    userMapper.insert(user);

    return userMapper.findById(user.getId());
  }

  // メール存在チェック
  public boolean existsByEmail(String email) {
    return userMapper.findByEmail(email) != null;
  }
}
