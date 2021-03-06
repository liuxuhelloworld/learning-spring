package async.example;

import java.util.concurrent.Future;

public interface AsyncService {
  void asyncTask();

  Future<String> asyncWithReturn(String name);
}
