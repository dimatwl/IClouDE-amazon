package managers;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Describes Gson object for packing data
 */
public class GSON {
  protected static final Gson gson = new Gson();

  private GSON(){

  }

  /**
   * Gets Gson object
   * @return Gson object
   */
  public static Gson getInstance(){
    return gson;
  }
}
