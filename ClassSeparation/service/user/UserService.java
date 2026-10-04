// 問3.以下のクラスを適切に分割してください。
/**
 * 【役割】登録済みユーザー情報の参照・状態管理専門サービス
 * 
 * 【分割理由】
 * 既存ユーザーに対する一覧取得や退会処理など、日常的な運用・管理機能のみを担当。
 * 
 *【依存オブジェクト】
 * 登録・認証を行わないため PasswordEncoder への依存を排除。
 */
import java.util.ArrayList;
import java.util.List;


public class UserService {

  private final UserMapper userMapper;

  // コンストラクタ
  public UserService(UserMapper userMapper ) {
    this.userMapper = userMapper;
  }

  // ユーザー一覧取得
  public List<User> getActiveUsers() {
    List<User> users = userMapper.findAll();
    List<User> result = new ArrayList<>();

    for (User user : users) {
      if (!user.isDeleted()) {
        result.add(user);
      }
    }
    return result;
  }

  // ユーザー退会
  public void deactivateUser(Long userId) {
    User user = userMapper.findById(userId);
    if (user == null) {
      throw new IllegalArgumentException("存在しません");
    }

    user.setDeleted(true);
    userMapper.update(user);
  }

}

