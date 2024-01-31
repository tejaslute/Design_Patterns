import java.util.*;

class Security {
    public void login(String email) {
        System.out.println("Login Successful " + email);
    }

    public void signup(String email) {
        System.out.println("Signup Successful " + email);
    }
}

class Post {
    public void upload(String pic) {
        System.out.println("Post uploaded successfully " + pic);
    }
}

class SocialFacade implements Social {
    private Security security;
    private Post post;

    public SocialFacade() {
        this.security = new Security();
        this.post = new Post();
    }

    public void login(String email) {
        security.login(email);
    }

    public void signup(String email) {
        security.signup(email);
    }

    public void uploadPost(String pic) {
        post.upload(pic);
    }
}

public interface Social {
    void login(String email);

    void signup(String email);

    void uploadPost(String pic);
}

public class Facade {

    public static void main(String[] args) {
        // Example usage of the Facade
        SocialFacade socialFacade = new SocialFacade();
        
        // User actions using the Facade
        socialFacade.login("user@example.com");
        socialFacade.signup("newuser@example.com");
        socialFacade.uploadPost("beautiful_sunset.jpg");
    }
}
