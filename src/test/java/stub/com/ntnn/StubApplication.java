package stub.com.ntnn;

import com.ntnn.Main;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class StubApplication {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  static {
    Security.addProvider(new BouncyCastleProvider());
  }
}
