package retrofit;


import modules.Github;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by hend on 5/23/16.
 */
public interface GithubService {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<Github> getUser(@Path("login") String login);
}
