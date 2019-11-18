package life.sw.community.controller;

import life.sw.community.dto.AccessTokenDto;
import life.sw.community.dto.GithubUser;
import life.sw.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        //shift enter  自动换行
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUrl);
        accessTokenDto.setState(state);
        String token = githubProvider.getAccessToken(accessTokenDto);  //ctrl alt v
        GithubUser githubUser = githubProvider.getUser(token);
        System.out.println(githubUser.getName());
        return "index";
    }

    //https://api.github.com/user?oauth_token=36dc1483e4399ec146833215cea45bb31462f9ac
}
