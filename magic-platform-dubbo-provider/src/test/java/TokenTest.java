import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-15 10:10
 * @Modified By:
 */
public class TokenTest {


  public static void main(String[] args) {
    String compactJws = Jwts.builder().setSubject("zhangyn")
        .signWith(SignatureAlgorithm.HS512, MacProvider.generateKey())
        .compact();
    System.out.println(compactJws);

    long time = System.currentTimeMillis();
    System.out.println(time);

    List<String> list = Arrays.asList(
        "Access-Control-Allow-Headers",
        "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With",
        "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

    String[] str = list.toArray(new String[0]);

    System.out.println(str.toString());

  }
}
